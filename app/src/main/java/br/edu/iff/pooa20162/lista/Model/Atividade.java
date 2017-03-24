package br.edu.iff.pooa20162.lista.Model;

import com.orm.SugarApp;
import com.orm.SugarRecord;
import android.database.sqlite.*;


public class Atividade extends SugarRecord {

    private String titulo, descricao;

    public Atividade(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Atividade() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
