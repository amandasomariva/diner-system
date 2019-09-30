package br.com.amandasomariva.dinersystem.model.exemplo;


import br.com.amandasomariva.dinersystem.model.util.AbstractEntity;

import javax.persistence.Entity;

@Entity
public class Exemplo extends AbstractEntity {

    private String texto;

    public Exemplo() {
    }

    public Exemplo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
