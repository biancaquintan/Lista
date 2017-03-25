package br.edu.iff.pooa20162.lista.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.edu.iff.pooa20162.lista.Model.Usuario;
import br.edu.iff.pooa20162.lista.R;

public class Cadastro extends AppCompatActivity {

    EditText login, senha;
    Button bcadastrar;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Intent intent = getIntent();

        id = (Long) intent.getSerializableExtra("id");

        String usuarioc = (String) intent.getSerializableExtra("usuario");
        String senhac = (String) intent.getSerializableExtra("senha");

        EditText usuario = (EditText) findViewById(R.id.tlogin);
        usuario.setText(usuarioc);

        EditText senha = (EditText) findViewById(R.id.tsenha);
        senha.setText(senhac);

        Button bcadastrar = (Button) findViewById(R.id.bcadastrar);

        bcadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this, Horario.class);
                salvar();
                startActivity(intent);
            }
        });
    }

    public void salvar() {
        login = (EditText) findViewById(R.id.tlogin);
        senha = (EditText) findViewById(R.id.tsenha);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        Usuario usuario = new Usuario(login.getText().toString(),senha.getText().toString(), dateFormat.format(cal.getTime()) );
        usuario.save();

        Toast.makeText(this,"Cadastro realizado!",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
