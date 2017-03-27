package br.edu.iff.pooa20162.lista.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20162.lista.Model.Atividade;
import br.edu.iff.pooa20162.lista.Model.Usuario;
import br.edu.iff.pooa20162.lista.R;

import static br.edu.iff.pooa20162.lista.R.id.belse;

public class Login extends AppCompatActivity {
    EditText login, senha;
    Button belse;
    List<Usuario> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = new ArrayList<>();
        long count = Usuario.count(Usuario.class);

        belse = (Button) findViewById(R.id.belse);

        if(count > 0) {
          belse.setVisibility(View.INVISIBLE);
        }

        final Button blogin = (Button) findViewById(R.id.blogin);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = (EditText) findViewById(R.id.tlogin);
                senha = (EditText) findViewById(R.id.tsenha);

                long count = Usuario.count(Usuario.class);

                if(count > 0) {
                    user = Usuario.find(Usuario.class, "login=? and senha=?", String.valueOf(login.getText()), String.valueOf(senha.getText()) );
                    if (user.isEmpty()) {
                        Toast.makeText(getApplication(), "Usuário não cadastrado!", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(Login.this, Lista.class);
                        startActivity(intent);
                    }
                }
            }
        });

        Button belse = (Button) findViewById(R.id.belse);
        belse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });
    }
}