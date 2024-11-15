package dev.md19303.demoasm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {

    List<carModel> carList;
    Context context;

    public CarAdapter(Context context, List<carModel> carList){
        this.context = context;
        this.carList = carList;
    }
    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_car,parent,false);

        TextView tvID = (TextView) view.findViewById(R.id.tvId);
        ImageView imgAvatar = (ImageView) view.findViewById(R.id.imgAvatatr);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);

        TextView tvNamSX = (TextView) view.findViewById(R.id.tvNamSX);

        TextView tvHang = (TextView) view.findViewById(R.id.tvHang);

        TextView tvGia = (TextView) view.findViewById(R.id.tvGia);

        tvName.setText(String.valueOf(carList.get(position).getTen()));

        tvNamSX.setText(String.valueOf(carList.get(position).getNamSX()));

        tvHang.setText(String.valueOf(carList.get(position).getHang()));

        tvGia.setText(String.valueOf(carList.get(position).getGia()));

        return view;
    }
}
