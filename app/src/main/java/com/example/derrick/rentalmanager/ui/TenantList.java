package com.example.derrick.rentalmanager.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddTenant;

import java.util.List;

/**
 * Created by root on 10/16/17.
 */

public class TenantList extends ArrayAdapter<AddTenant> {
    private Activity context;
    List<AddTenant> tenants;

    public TenantList(Activity context, List<AddTenant> tenants){
        super(context, R.layout.tenant_list, tenants);
        this.context= context;
        this.tenants = tenants;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.tenant_list, null, true);

        TextView textViewFirstName = (TextView) listViewItem.findViewById(R.id.textViewFirstName);
        TextView textViewLastName = (TextView) listViewItem.findViewById(R.id.textViewLastName);
        TextView textViewRoomNumber = (TextView) listViewItem.findViewById(R.id.textViewRoomNumber);
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.textViewPhone);


        AddTenant tenant = tenants.get(position);
        textViewFirstName.setText(tenant.getFirstName());
        textViewLastName.setText(tenant.getLastName());
        textViewRoomNumber.setText(tenant.getRoomNumber());
        textViewEmail.setText(tenant.getEmail());
        textViewPhone.setText(tenant.getPhone());

        return listViewItem;
    }

}