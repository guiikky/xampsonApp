package usjt.caixa.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import usjt.caixa.R;

public class ExtratoAdapter extends BaseAdapter implements SectionIndexer {
    Activity context;
    Extrato[] extratos;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public ExtratoAdapter(Activity context, Extrato[] extratos) {
        this.context = context;
        this.extratos = extratos;
        sectionHeaders = SectionIndexBuilder.BuildSectionHeaders(extratos);
        positionForSectionMap = SectionIndexBuilder.BuildPositionForSectionMap(extratos);
        sectionForPositionMap = SectionIndexBuilder.BuildSectionForPositionMap(extratos);

    }

    @Override
    public int getCount() {
        return extratos.length;
    }

    @Override
    public Object getItem(int position) {
        if (position >= 0 && position < extratos.length)
            return extratos[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_extrato, parent, false);

            TextView data = (TextView) view.findViewById(R.id.data);
            TextView operacao = (TextView) view.findViewById(R.id.operacao);
            TextView valor = (TextView) view.findViewById(R.id.valor);
            view.setTag(new ViewHolder(data, operacao, valor));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.getData().setText(extratos[position].getData());
        holder.getOperacao().setText(extratos[position].getOperacao());
        holder.getValor().setText("R$" + extratos[position].getValor());

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
