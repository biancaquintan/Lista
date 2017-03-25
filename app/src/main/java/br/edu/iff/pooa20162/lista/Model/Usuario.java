package br.edu.iff.pooa20162.lista.Model;


import com.orm.SugarRecord;

import java.sql.Time;

public class Usuario extends SugarRecord {

    private String login, senha;
    private String horario;

    public Usuario (String login, String senha, String horario) {
        this.login = login;
        this.senha = senha;
        this.horario = horario;
    }

    public Usuario () {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String usuario) {
        this.login = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHorario() {    return horario;   }

    public void setHorario(String horario) {  this.horario = horario;  }
}

