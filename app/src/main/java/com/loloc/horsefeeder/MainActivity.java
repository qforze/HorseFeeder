package com.loloc.horsefeeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.loloc.horsefeeder.data.Horse;
import com.loloc.horsefeeder.data.ViewVisibility;


public class MainActivity extends AppCompatActivity {

    TextView generalInformation;
    Button workLoad[];
    EditText weight;
    Horse horse = new Horse();
    ViewVisibility viewVisibility = new ViewVisibility();
    ListView supplementListView;

    public void slideDataCollectionViews(){
        viewVisibility.arrayViewHide(workLoad);
        viewVisibility.viewHide(generalInformation);
        viewVisibility.viewShow(weight);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workLoad            = new Button[4];
        workLoad[0]         = findViewById(R.id.buttonLight);
        workLoad[1]         = findViewById(R.id.buttonModerate);
        workLoad[2]         = findViewById(R.id.buttonHeavy);
        workLoad[3]         = findViewById(R.id.buttonIntense);
        generalInformation  = findViewById(R.id.generalInformationTextView);
        weight              = findViewById(R.id.editText);
        supplementListView  = findViewById(R.id.supplementListView);

        horse.listViewAdapterSettings(this, supplementListView);

        viewVisibility.getContext(this);

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                horse.onClickCalculate(weight);
                viewVisibility.viewHide(weight);
                viewVisibility.hideKeyboard(weight);
                viewVisibility.viewShow(supplementListView);
                horse.refreshList();

            }
          });
        workLoad[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horse.onClickSetWorkLoad(v);
                slideDataCollectionViews();
            }
        });
        workLoad[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horse.onClickSetWorkLoad(v);
                slideDataCollectionViews();
            }
        });
        workLoad[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horse.onClickSetWorkLoad(v);
                slideDataCollectionViews();
            }
        });
        workLoad[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horse.onClickSetWorkLoad(v);
                slideDataCollectionViews();
            }
        });
        }
    }

