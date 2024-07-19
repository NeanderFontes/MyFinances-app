package com.myfinances.myfinances.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "myfinances")
public class MyFinancesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "empresa", nullable = false)
    private String empresa;
    @JsonProperty("valor_despesa")
    @JsonAlias({"valorDespesa", "valor-despesa", "valor despesa"})
    @Column(name = "valor_despesa", nullable = false)
    private Double valorDespesa;
    @JsonProperty("data_pagamento")
    @JsonAlias({"dataPagamento", "data-pagamento", "data pagamento"})
    @Column(name = "data_pagamento", nullable = false)
    private String dataPagamento;

    public MyFinancesModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFinancesModel that = (MyFinancesModel) o;
        return id.equals(that.id) && empresa.equals(that.empresa) && valorDespesa.equals(that.valorDespesa) && dataPagamento.equals(that.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empresa, valorDespesa, dataPagamento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(Double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

