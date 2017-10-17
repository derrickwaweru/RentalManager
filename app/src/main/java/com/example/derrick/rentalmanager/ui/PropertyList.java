package com.example.derrick.rentalmanager.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddProperty;

import java.util.List;

/**
 * Created by root on 10/16/17.
 */

public class PropertyList extends ArrayAdapter<AddProperty> {
    private Activity context;
    List<AddProperty> properties;

    public PropertyList(Activity context, List<AddProperty> properties){
        super(context, R.layout.property_list, properties);
        this.context= context;
        this.properties = properties;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.property_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.textViewLocation);
        TextView textViewCategory = (TextView) listViewItem.findViewById(R.id.textViewCategory);
        TextView textViewIncome = (TextView) listViewItem.findViewById(R.id.textViewIncome);


        AddProperty property = properties.get(position);
        textViewName.setText(property.getName());
        textViewLocation.setText(property.getLocation());
        textViewCategory.setText(property.getCategory());
        textViewIncome.setText(property.getIncome());


        return listViewItem;
    }

}