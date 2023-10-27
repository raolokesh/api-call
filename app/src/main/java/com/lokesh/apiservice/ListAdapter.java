package com.lokesh.apiservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;


public class ListAdapter extends ArrayAdapter<Model> {
    TextView plaza_id_view,vehicle_class_id_view,vehicle_class_name_view,
            toll_rate_view,overload_fee_view,gui_visible_view;

    private Context context;

    public ListAdapter(Context context, List<Model> data) {
        super(context, 0, data);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.data_list_row,parent,false);
        }

        plaza_id_view = convertView.findViewById(R.id.plaza_id_view);
        vehicle_class_id_view = convertView.findViewById(R.id.vehicle_class_id_view);
        vehicle_class_name_view = convertView.findViewById(R.id.vehicle_class_name_view);
        toll_rate_view = convertView.findViewById(R.id.toll_rate_view);
        overload_fee_view = convertView.findViewById(R.id.overload_fee_view);
        gui_visible_view = convertView.findViewById(R.id.gui_visible_view);



        Model model = getItem(position);
        if(model != null){
            plaza_id_view.setText("Plaza ID:- "+model.getPLAZA_ID());
            vehicle_class_id_view.setText("Vehicle class Id:- "+model.getVEHICLE_CLASS_ID());
            vehicle_class_name_view.setText("Vehicle class Name:- "+model.getVEHICLE_CLASS_NAME());
            toll_rate_view.setText("Toll Rate:- "+model.getTOLL_RATE());
            overload_fee_view.setText("Overload Fee:- "+model.getOVERLOAD_FEE());
            gui_visible_view.setText("GUI Visible:- "+model.getGUI_VISIBLE());
        }


        return convertView;
    }



}
