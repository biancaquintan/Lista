package br.edu.iff.pooa20162.lista.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.lista.Model.Atividade;
import br.edu.iff.pooa20162.lista.R;

public class TelaAtividade extends AppCompatActivity {

    EditText titulo, descricao;
    Button badicionar,balterar;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atividade);

        Intent intent = getIntent();

        id = (Long) intent.getSerializableExtra("id");

        String tituloa = (String) intent.getSerializableExtra("titulo");
        String descricaoa = (String) intent.getSerializableExtra("descricao");

        EditText titulo = (EditText) findViewById(R.id.ttitulo);
        titulo.setText(tituloa);

        EditText descricao = (EditText) findViewById(R.id.tdescricao);
        descricao.setText(descricaoa);

        Button badicionar = (Button) findViewById(R.id.badicionar);
        Button balterar = (Button) findViewById(R.id.balterar);

        badicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaAtividade.this, Lista.class);
                salvar();
                startActivity(intent);
            }
        });

        balterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id != 0) {
            badicionar.setEnabled(false);
            badicionar.setClickable(false);
            badicionar.setVisibility(View.INVISIBLE);
        }
        else {
            balterar.setEnabled(false);
            balterar.setClickable(false);
            balterar.setVisibility(View.INVISIBLE);
        }

    }

    public void salvar() {
        titulo = (EditText) findViewById(R.id.ttitulo);
        descricao = (EditText) findViewById(R.id.tdescricao);

        Atividade atividade = new Atividade(titulo.getText().toString(),descricao.getText().toString());
        atividade.save();

        Toast.makeText(this,"Uma nova atividade foi cadastrada!",Toast.LENGTH_LONG).show();
        this.finish();
    }
    public void alterar() {
        titulo = (EditText) findViewById(R.id.ttitulo);
        descricao = (EditText) findViewById(R.id.tdescricao);

        Atividade atividade = Atividade.findById(Atividade.class, id);

        atividade.setTitulo(titulo.getText().toString());
        atividade.setDescricao(descricao.getText().toString());
        atividade.save();

        Toast.makeText(this,"A atividade foi atualizada!",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
