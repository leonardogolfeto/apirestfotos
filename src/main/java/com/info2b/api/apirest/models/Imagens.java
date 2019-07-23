package com.info2b.api.apirest.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "TB_IMAGENS")
public class Imagens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotEmpty()
    private String titulo;

    @NotEmpty()
    private String url;

    private String descricao;

    public Imagens() {
    }

    public Imagens(String titulo, String url, String descricao) {
        this.titulo = titulo;
        this.url = url;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public String getDescricao() {
        return descricao;
    }
}