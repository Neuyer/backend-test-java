package br.com.estacionamento.model;

import br.com.estacionamento.enums.TiposVeiculos;

import javax.validation.constraints.Pattern;

public class VeiculoDTO {
    private String marca;
    private String modelo;
    private String cor;
    private TiposVeiculos tipo;
    private String placa;

    public VeiculoDTO( ){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public TiposVeiculos getTipo() {
        return tipo;
    }

    public void setTipo(TiposVeiculos tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
