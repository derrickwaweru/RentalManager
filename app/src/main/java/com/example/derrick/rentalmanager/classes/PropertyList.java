package com.example.derrick.rentalmanager.classes;

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
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEmail);


        AddProperty property = properties.get(position);
        textViewName.setText("Name:" + property.getName());
        textViewLocation.setText("Location:" + property.getLocation());
        textViewCategory.setText("Category:" + property.getCategory());
        textViewEmail.setText("Email:" + property.getEmail());


        return listViewItem;
    }

}