package com.gerenciador.gerenciadornotas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "notas")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nota;
    private String descricao;
    private LocalDateTime data_compra;
    private double valor;
    private LocalDateTime data_vencimento;
    private boolean pago;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Nota() {
    }

    public Nota(Long id_nota, String descricao, LocalDateTime data_compra, double valor, LocalDateTime data_vencimento, boolean pago, Empresa empresa) {
        this.id_nota = id_nota;
        this.descricao = descricao;
        this.data_compra = data_compra;
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.pago = pago;
        this.empresa = empresa;
    }

    public Long getId_nota() {
        return id_nota;
    }

    public void setId_nota(Long id_nota) {
        this.id_nota = id_nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDateTime data_compra) {
        this.data_compra = data_compra;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDateTime data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
