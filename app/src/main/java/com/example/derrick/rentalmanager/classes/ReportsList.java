package com.example.derrick.rentalmanager.classes;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddReports;

import java.util.List;

public class ReportsList extends ArrayAdapter<AddReports> {
    private Activity context;
    List<AddReports> reports;

    public ReportsList(Activity context,List<AddReports> reports){
        super(context, R.layout.reports_list,reports);
        this.context = context;
        this.reports = reports;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.reports_list,null,true);

        TextView fromTextView = (TextView) listViewItem.findViewById(R.id.fromTextView);
        TextView toTextView = (TextView) listViewItem.findViewById(R.id.toTextView);
        TextView reportTypeTextView = (TextView) listViewItem.findViewById(R.id.reportTypeTextView);
        TextView reportDescription = (TextView) listViewItem.findViewById(R.id.reportDescriptionTextview);
        TextView buildingReportTextView = (TextView) listViewItem.findViewById(R.id.reportyBuildingTextView);
        TextView roomNumberTextView = (TextView) listViewItem.findViewById(R.id.roomNumberTextView);

        AddReports report = reports.get(position);
        fromTextView.setText("From day: " + report.getFrom());
        toTextView.setText("To day: " + report.getTo());
        reportTypeTextView.setText("Report Type: " + report.getReportType());
        reportDescription.setText("Description: " + report.getReportDescription());
        buildingReportTextView.setText("Property Name: " + report.getPropertyName());
        roomNumberTextView.setText("Room Number: " + report.getRoomNumber());

        return listViewItem;
    }

}


