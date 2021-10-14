package com.gerenciador.gerenciadornotas.controller;

import com.gerenciador.gerenciadornotas.model.Empresa;
import com.gerenciador.gerenciadornotas.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> list(){
       return empresaRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Empresa get(@PathVariable Long id){
        return empresaRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody  Empresa empresa){
        empresaRepository.saveAndFlush(empresa);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Empresa update(@PathVariable Long id, @RequestBody Empresa empresa){
        Empresa empresaExistente = empresaRepository.getById(id);
        BeanUtils.copyProperties(empresa,empresaExistente,"empresa_id");
        return empresaRepository.saveAndFlush(empresaExistente);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        empresaRepository.deleteById(id);
    }
}
