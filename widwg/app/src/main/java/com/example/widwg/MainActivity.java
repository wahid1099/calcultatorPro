package com.example.widwg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner myspinner;
    String[] cricketer={"sakib","sakib1","sakib2","sakib3","sakib4","sakib","sakib","sakib",};
         Button orderbtn;
         CheckBox pizzack,coffeck,pastack;
         TextView displaytv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orderbtn=findViewById(R.id.btn);
        pizzack=findViewById(R.id.pizza);
        pastack=findViewById(R.id.pasta);
        coffeck=findViewById(R.id.coffe);
        displaytv=findViewById(R.id.tv);

        myspinner=findViewById(R.id.spinner);


        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                StringBuilder result = new StringBuilder();
                result.append("\n select itemms :");

                if (pizzack.isChecked()) {
                    result.append("\n Pizza price 99");
                    total += 99;
                }

                if (pastack.isChecked()) {
                    result.append("\n Pizza price 150");
                    total += 150;


                }
                if (coffeck.isChecked()) {
                    result.append("\n Pizza price 60");
                    total += 60;
                }
                result.append("\n total ammount is" + total + "taka");
                displaytv.setText(result);
            }


        });
        ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,cricketer);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);
        myspinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }
}

