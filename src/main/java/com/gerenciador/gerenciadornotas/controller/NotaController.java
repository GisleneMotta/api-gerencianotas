package com.gerenciador.gerenciadornotas.controller;

import com.gerenciador.gerenciadornotas.model.Nota;
import com.gerenciador.gerenciadornotas.repository.NotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> list(){
        return notaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Nota findById(@PathVariable Long id){
        return notaRepository.getById(id);
    }

    @PostMapping
    public Nota create(@RequestBody Nota nota){
        return notaRepository.saveAndFlush(nota);
    }

    @RequestMapping(value="{id}", method =  RequestMethod.PUT)
    public Nota update(@PathVariable Long id, @RequestBody Nota nota){
        Optional<Nota> notaExistente = notaRepository.findById(id);
        BeanUtils.copyProperties(nota, notaExistente,"id_nota");
        return notaRepository.saveAndFlush(nota);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        notaRepository.deleteById(id);
    }

}
