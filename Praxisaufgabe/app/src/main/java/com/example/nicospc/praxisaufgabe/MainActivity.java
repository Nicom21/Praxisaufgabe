package com.example.nicospc.praxisaufgabe;

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

        //  Erstellen des Eingabefeldes (Quersumme)
        final EditText Eingabe = findViewById(R.id.Eingabe);

        //  Erstellen des Buttons (Quersumme)
        Button btn = findViewById(R.id.btn);

        //  Erstellen des Ausgabefeldes (Quersumme)
        final TextView Ausgabe = findViewById(R.id.Ausgabe);

        //  Erstellen der Funktion des Buttons (Quersumme)
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //  Ausgabe dessen, was von calculateDigitSum(), was eine Eingabe bekommt,
                //  berechnet wurde
                Ausgabe.setText(calculateDigitSum(Eingabe.getText().toString()));
            }
        });

        //  Erstellen des Ausgabefeldes (Fibonacci)
        final TextView Ausgabe2 = findViewById(R.id.Ausgabe2);

        //Erstellen des Buttons (Fibonacci)
        Button btn2 = findViewById(R.id.btn2);

        //Erstellen der Funktion des Buttons (Fibonacci)
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Ausgabe der ersten 30 Stellen der Fibonacci-Folge
                Ausgabe2.setText(calculateFibonacciRow());
            }
        });


    }

    public String calculateDigitSum(String input) {
        //  parsen des erhaltenen String-Wertes auf einen Integer um damit weiter zu rechnen
       int c = Integer.parseInt(input);

       int rechenvariable = c;
       double count = 0;
       int quersumme = 0;
       int Potenz = 10;

        //  Die rechvariable wird durch 10 geteilt. So erhält man den ersten Summanden der
        //  quersumme, da Integer keine Gleitkommazahlen sind. Dann wird die erste Ziffer der Zahl
        //  wieder auf ihre urspüngliche Länge gebracht und von c abgezogen. Somit fällt von c die
        //  erste Ziffer weg. Die wird solange wiederholt, bis c einstellig ist. Man erhält
        //  nacheinander die einzelnen Ziffern und kann diese addieren um die quersumme zu erhalten
       while(rechenvariable > 9) {
           while (rechenvariable > 9) {
               rechenvariable = rechenvariable / 10;
               count++;
           }
           quersumme = quersumme + rechenvariable;
           while(count > 1){
               Potenz = Potenz * 10;
               count--;
           }
           c = c - (Potenz * rechenvariable);
           Potenz = 10;
           rechenvariable = c;
           count = 0;

       }
        quersumme = quersumme + rechenvariable;

       //   zurückparsen des verrechneten Inegers auf einen String um ausgegeben werden zu können
       input = Integer.toString(quersumme);
       return input;
      }

    public String calculateFibonacciRow() {

        int fib1 = 0;
        int fib2 = 1;
        int fib3;

        String b = fib1 + "\n" + fib2 + "\n";

        int count = 0;

        while(count < 30){
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
            b = b + fib3 + "\n";
            count++;
        }

        return b;
    }
}
