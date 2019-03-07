package com.loloc.horsefeeder.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class Horse {

    public ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private int bodyWeight;
    private int workLoad;
    private double sweatLoss;
    private double dE;
    private double cP;
    private double cA;
    private double p;
    private double lys;
    private double k;
    private double nA;
    private double cL;


    public void setWeight(int horseWeight) {

        bodyWeight = horseWeight;

    }

    public int getWeight() {
        return bodyWeight;

    }

    public void setWorkLoad(int horseWorkLoad) {

        workLoad = horseWorkLoad;

    }

    public int getWorkLoad() {
        return workLoad;

    }

    public void onClickSetWorkLoad(View view) {

        switch (view.getTag().toString()) {

            case "0":
                setWorkLoad(1);
                break;

            case "1":
                setWorkLoad(2);
                break;

            case "2":
                setWorkLoad(3);
                break;

            case "3":
                setWorkLoad(4);
                break;


        }

    }

    public void onClickCalculate(View view) {

        EditText weightEditText = (EditText) view;

        Integer horseWeight = Integer.parseInt(weightEditText.getText().toString());


        if (horseWeight > 0 && horseWeight < 1000){

            setWeight(horseWeight);

        }

        switch (getWorkLoad()) {

            case 1:
                sweatLoss = bodyWeight * 0.0025;
                dE = (bodyWeight * 0.0333) * 1.2;
                cP = (bodyWeight * 1.26) + (bodyWeight * 0.089) + (sweatLoss * 7.8 * 2.0 / 0.79);
                cA = (bodyWeight * 0.06);
                p = (bodyWeight * 0.036);
                lys = (cP * 0.043);
                k = (bodyWeight * 0.05 + 2.8 * sweatLoss);
                nA = (bodyWeight * 0.02 + 3.1 * sweatLoss);
                cL = (bodyWeight * 0.08 + 5.3 * sweatLoss);
                break;

            case 2:
                sweatLoss = bodyWeight * 0.005;
                dE = (bodyWeight * 0.0333) * 1.4;
                cP = (bodyWeight * 1.26) + (bodyWeight * 0.177) + (sweatLoss * 7.8 * 2.0 / 0.79);
                cA = (bodyWeight * 0.07);
                p = (bodyWeight * 0.042);
                lys = (cP * 0.043);
                k = (bodyWeight * 0.05 + 2.8 * sweatLoss);
                nA = (bodyWeight * 0.02 + 3.1 * sweatLoss);
                cL = (bodyWeight * 0.08 + 5.3 * sweatLoss);
                break;

            case 3:

                sweatLoss = bodyWeight * 0.01;
                dE = (bodyWeight * 0.0333) * 1.6;
                cP = (bodyWeight * 1.26) + (bodyWeight * 0.266) + (sweatLoss * 7.8 * 2.0 / 0.79);
                cA = (bodyWeight * 0.08);
                p = (bodyWeight * 0.058);
                lys = (cP * 0.043);
                k = (bodyWeight * 0.05 + 2.8 * sweatLoss);
                nA = (bodyWeight * 0.02 + 3.1 * sweatLoss);
                cL = (bodyWeight * 0.08 + 5.3 * sweatLoss);
                break;

            case 4:
                sweatLoss = bodyWeight * 0.02;
                dE = (bodyWeight * 0.0363) * 1.9;
                cP = (bodyWeight * 1.26) + (bodyWeight * 0.354) + (sweatLoss * 7.8 * 2.0 / 0.79);
                cA = (bodyWeight * 0.08);
                p = (bodyWeight * 0.058);
                lys = (cP * 0.043);
                k = (bodyWeight * 0.05 + 2.8 * sweatLoss);
                nA = (bodyWeight * 0.02 + 3.1 * sweatLoss);
                cL = (bodyWeight * 0.08 + 5.3 * sweatLoss);
                break;

        }
        refreshList();
    }
    public void refreshList(){

        adapter.clear();

        list.add("Digestible Energy (Mcal)  " + String.format("%.1f", dE));
        list.add("Crude Protein (g)         " + String.format("%.1f", cP));
        list.add("Lysine        (g)         " + String.format("%.1f", lys));
        list.add("Calcium       (g)         " + String.format("%.1f", cA));
        list.add("Phosphorus    (g)         " + String.format("%.1f", p));
        list.add("Sodium        (g)         " + String.format("%.1f", nA));
        list.add("Potassium     (g)         " + String.format("%.1f", k));
        list.add("Chlorine      (g)         " + String.format("%.1f", cL));

        adapter.notifyDataSetChanged();

    }

    public void listViewAdapterSettings(Context context, ListView listView) {

        adapter = new ArrayAdapter<String>
                (context, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}