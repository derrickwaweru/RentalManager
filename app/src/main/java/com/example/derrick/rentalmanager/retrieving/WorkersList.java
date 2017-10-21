package com.example.derrick.rentalmanager.retrieving;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddWorkers;

import java.util.List;

public class WorkersList extends ArrayAdapter<AddWorkers> {
    private Activity context;
    List<AddWorkers> workers;

    public WorkersList(Activity context, List<AddWorkers> workers) {
        super(context, R.layout.workers_list, workers);
        this.context = context;
        this.workers = workers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.workers_list, null, true);

        TextView workersFirstName = (TextView) listViewItem.findViewById(R.id.workersFirstNameTextView);
        TextView workersLastName = (TextView) listViewItem.findViewById(R.id.workersLastNameTextView);
        TextView workersProfession = (TextView) listViewItem.findViewById(R.id.workersProfessionTextView);
        TextView workersPhone = (TextView) listViewItem.findViewById(R.id.workersPhoneTextView);
        TextView workersSalary = (TextView) listViewItem.findViewById(R.id.workersSalaryTextView);
        TextView workersProperty = (TextView) listViewItem.findViewById(R.id.workersPropertyTextView);

        AddWorkers worker = workers.get(position);
        workersFirstName.setText("First Name: " + worker.getFirstName());
        workersLastName.setText("Last Name: " + worker.getLastName());
        workersProfession.setText("Profession: " + worker.getProfession());
        workersPhone.setText("Phone Number: " + worker.getPhone());
        workersSalary.setText("Salary: " + worker.getSalary());
        workersProperty.setText("Works At: " + worker.getWorksAt());

        return listViewItem;
    }
}
