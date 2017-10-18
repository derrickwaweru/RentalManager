package com.example.derrick.rentalmanager.ui;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddOwner;

import java.util.List;

public class OwnersList extends ArrayAdapter<AddOwner> {
    private Activity context;
    List<AddOwner> owners;

    public OwnersList(Activity context, List<AddOwner> owners) {
        super(context, R.layout.owners_list, owners);
        this.context = context;
        this.owners = owners;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.owners_list, null, true);

        TextView firstNameTextView = (TextView) listViewItem.findViewById(R.id.ownersFirstName);
        TextView lastNameTextView = (TextView) listViewItem.findViewById(R.id.ownersLastName);
        TextView emailTextView = (TextView) listViewItem.findViewById(R.id.ownersEmail);
        TextView phoneTextView = (TextView) listViewItem.findViewById(R.id.ownersPhones);

        AddOwner owner = owners.get(position);
        firstNameTextView.setText("First Name: " + owner.getFirstName());
        lastNameTextView.setText("Last Name: " + owner.getLastName());
        emailTextView.setText("Email: " + owner.getEmail());
        phoneTextView.setText("Phone: " + owner.getPhone());

        return listViewItem;
    }
}
