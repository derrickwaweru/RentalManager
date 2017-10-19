package com.example.derrick.rentalmanager.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddVacancy;

import java.util.List;

/**
 * Created by root on 10/19/17.
 */

public class VacancyList extends ArrayAdapter<AddVacancy> {
    public Activity context;
    List<AddVacancy> vacancies;

    public VacancyList(Activity context, List<AddVacancy> vacancies) {
        super(context, R.layout.vacancy_list, vacancies);
        this.context = context;
        this.vacancies = vacancies;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.vacancy_list, null, true);

        TextView nameTextView = (TextView) listViewItem.findViewById(R.id.name);
        TextView phoneTextView = (TextView) listViewItem.findViewById(R.id.phone);
        TextView propertyNameTextView = (TextView) listViewItem.findViewById(R.id.propertyName);
        TextView addressTextView = (TextView) listViewItem.findViewById(R.id.address);
        TextView vacanciesTextView = (TextView) listViewItem.findViewById(R.id.vacancies);
        TextView rentTextView = (TextView) listViewItem.findViewById(R.id.rent);

        AddVacancy vacancy = vacancies.get(position);
        nameTextView.setText("Agent Name: " + vacancy.getName());
        phoneTextView.setText("Phone: " + vacancy.getPhone());
        propertyNameTextView.setText("Property Name: " + vacancy.getPropertyName());
        addressTextView.setText("Address: " + vacancy.getAddress());
        vacanciesTextView.setText("Vacancies: " + vacancy.getVacancies());
        rentTextView.setText("Rent: " + vacancy.getRent());

        return listViewItem;

    }

}