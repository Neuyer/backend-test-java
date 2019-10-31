package br.com.estacionamento.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VeiculoId implements Serializable {
    private long id;
    private String placa;

    public VeiculoId() {
    }

    public VeiculoId(Long id, String placa) {
        this.placa = placa;
        this.id= id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VeiculoId)) return false;
        VeiculoId veiculoId1 = (VeiculoId) o;
        return id == veiculoId1.id &&
                Objects.equals(placa, veiculoId1.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa);
    }
}

