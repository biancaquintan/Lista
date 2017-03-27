package br.edu.iff.pooa20162.lista.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.lista.Adapter.AtividadeAdapter;
import br.edu.iff.pooa20162.lista.Model.Atividade;
import br.edu.iff.pooa20162.lista.R;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lista.this, TelaAtividade.class);
                intent.putExtra("id", Long.valueOf(0));
                intent.putExtra("", "");
                intent.putExtra("descricao", "");
                startActivity(intent);
            }
        });

        /*FloatingActionButton bHorario = (FloatingActionButton) findViewById(R.id.bHorario);
        bHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lista.this, Horario.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_atividade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Atividade> atividades = (ArrayList<Atividade>) Atividade.listAll(Atividade.class);

        ListView lista = (ListView) findViewById(R.id.lvAtividades);
        ArrayAdapter adapter = new AtividadeAdapter(this, atividades);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Lista.this,TelaAtividade.class);

                intent.putExtra("id",atividades.get(i).getId());
                intent.putExtra("titulo",atividades.get(i).getTitulo());
                intent.putExtra("descricao",atividades.get(i).getDescricao());
                startActivity(intent);
            }
        });
    }
}
