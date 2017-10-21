package com.example.derrick.rentalmanager.classes;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddManager;

import java.util.List;

public class ManagersList extends ArrayAdapter<AddManager> {
    private Activity context;
    private List<AddManager> managers;

    public ManagersList(Activity context, List<AddManager> managers) {
        super(context, R.layout.managers_list, managers);
        this.context = context;
        this.managers = managers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.managers_list, null, true);

        TextView firstName = (TextView) listViewItem.findViewById(R.id.managersFirstName);
        TextView lastName = (TextView) listViewItem.findViewById(R.id.managersLastName);
        TextView email = (TextView) listViewItem.findViewById(R.id.managersEmail);
        TextView phone = (TextView) listViewItem.findViewById(R.id.managersPhone);
        TextView managedProperty = (TextView) listViewItem.findViewById(R.id.managersProperty);

        AddManager manager = managers.get(position);
        firstName.setText("First Name: " + manager.getFirstName());
        lastName.setText("Last Name: " + manager.getLastName());
        email.setText("Email: " + manager.getEmail());
        phone.setText("Phone: " + manager.getPhone());
        managedProperty.setText("Property Managed: " + manager.getPropertyManaged());

        return listViewItem;
    }
}
