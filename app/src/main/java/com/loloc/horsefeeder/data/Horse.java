package com.loloc.horsefeeder.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Horse {

    public ArrayList<String> listNames = new ArrayList<>();
    public ArrayList<Integer> listResults = new ArrayList<>();
    RowItem rowItem;
    public List<RowItem> rowitems;
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

    public void onClickCalculate(int horseWeight) {

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
    }
    public void refreshList() {

        listNames.add("Digestible Energy");
        listNames.add("Crude Protein");
        listNames.add("Lysine");
        listNames.add("Calcium");
        listNames.add("Phosphorus");
        listNames.add("Sodium");
        listNames.add("Potassium");
        listNames.add("Chlorine");

        listResults.add((int) Math.round(dE));
        listResults.add((int) Math.round(cP));
        listResults.add((int) Math.round(lys));
        listResults.add((int) Math.round(cA));
        listResults.add((int) Math.round(p));
        listResults.add((int) Math.round(k));
        listResults.add((int) Math.round(nA));
        listResults.add((int) Math.round(cL));

        rowitems = new ArrayList<RowItem>();

        for (int i = 0; i < listNames.size(); i++) {

            rowItem = new RowItem(listNames.get(i),listResults.get(i));
            rowitems.add(rowItem);
        }
    }
   }