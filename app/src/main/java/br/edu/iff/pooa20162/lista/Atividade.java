package br.edu.iff.pooa20162.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Atividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        Intent intent = getIntent();

        final EditText tAtividade = (EditText) findViewById(R.id.tAtividade);
        final EditText tDesc = (EditText) findViewById(R.id.tDesc);


        Button bAdcAtividade = (Button) findViewById(R.id.bAdcAtividade);
        bAdcAtividade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Atividade.this, Lista.class);
                startActivity(intent);
            }
        });
    }
}
