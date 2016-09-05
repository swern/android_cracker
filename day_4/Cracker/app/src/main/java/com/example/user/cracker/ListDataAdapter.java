package com.example.user.cracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/08/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView FOOD_TYPE, CALORIES, MEAL;
    }

    @Override
    public  void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.FOOD_TYPE = (TextView)row.findViewById(R.id.text_food_type);
            layoutHandler.CALORIES = (TextView)row.findViewById(R.id.text_calories);
            layoutHandler.MEAL = (TextView)row.findViewById(R.id.text_meal);
            row.setTag(layoutHandler);

        }
        else{
            layoutHandler = (LayoutHandler) row.getTag();


        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.FOOD_TYPE.setText(dataProvider.getFood_type());
        layoutHandler.CALORIES.setText(dataProvider.getCalories());
        layoutHandler.MEAL.setText(dataProvider.getMeal());

        return row;
    }
}
