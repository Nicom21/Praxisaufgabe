package com.example.nicospc.apppraxisaufgabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int H = 0;

        Button Quersumme = findViewById(R.id.Quersumme);
        Quersumme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDigitSum(H);
                TextView Ergebnis = findViewById(R.id.Ergebnis);
                Ergebnis.setText(H);
            }
        });


    }

    public void calculateDigitSum(int H){
        EditText Eingabe = findViewById(R.id.Eingabe);
        int Zahl = 0;
        Eingabe.setText(Zahl);

        int Ergebnis = 0;
        H = Zahl;
        int i = 0;

        while(H > 9) {
            while (H > 9) {
                H = H/10;
                i++;
            }
            Ergebnis = Ergebnis + H;
            H = (i * 10) * H;
            H = Zahl - H;
        }

    }
}