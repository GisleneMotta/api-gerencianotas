package com.gerenciador.gerenciadornotas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "empresas")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;
    private String nome_empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")// nome do atributo do relacionamento com a nota linha 23
    private List<Nota> notas;

    public Empresa() {
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

}
