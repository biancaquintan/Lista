package br.edu.iff.pooa20162.lista.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import br.edu.iff.pooa20162.lista.Model.Atividade;
import br.edu.iff.pooa20162.lista.R;

public class AtividadeAdapter extends ArrayAdapter<Atividade> {
    private Context context = null;
    private ArrayList<Atividade> atividades = null;

    public AtividadeAdapter(Context context, ArrayList<Atividade> atividades) {
            super(context, R.layout.linhaatividade, atividades);
            this.context = context;
            this.atividades = atividades;
    }

    public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.linhaatividade, parent, false);

            TextView titulo = (TextView) rowView.findViewById(R.id.tvllvTitulo);
            TextView descricao = (TextView) rowView.findViewById(R.id.tvllvDescricao);


        titulo.setText(atividades.get(position).getTitulo());
        descricao.setText(atividades.get(position).getDescricao());
        return rowView;
    }
}
