package com.myfinances.myfinances.dto;

import java.util.Objects;

public class MyFinancesDTO {
    private Long id;
    private String empresa;
    private Double valorDespesa;
    private String dataPagamento;

    public MyFinancesDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyFinancesDTO that = (MyFinancesDTO) o;
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
