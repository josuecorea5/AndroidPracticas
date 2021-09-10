package com.example.androidbitcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] opciones = {"Dólares","Lempiras","Quetzales","Córdobas","Colón Costarricense"};
        Spinner objSpinner;
        DecimalFormat df = new DecimalFormat("#.00");
        objSpinner = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> theAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_option,opciones);
        objSpinner.setAdapter(theAdapter);
        Button theBotton = (Button)findViewById(R.id.btnConverter);
        theBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int optionSelected;
                EditText priceBitcoin = (EditText)findViewById(R.id.priceBitcoin);
                TextView objLabel = (TextView)findViewById(R.id.result);
                optionSelected = objSpinner.getSelectedItemPosition();
                Double cantidad = Double.parseDouble(priceBitcoin.getText().toString());
                Double resultado = 0.0;
                Double lempira = 23.71, quetzal = 7.71, cordoba = 34.98, colonCRC = 619.25;
                Double priceUSD = 48077.70;
                String abreviatura = "";
                switch (optionSelected) {
                    case 0:
                        resultado = cantidad * 1;
                        abreviatura = "$";
                        break;
                    case 1:
                        resultado = cantidad * lempira;
                        df.format(resultado);
                        abreviatura = "L";
                        break;
                    case 2:
                        resultado = cantidad * quetzal;
                        abreviatura = "Q";
                        break;
                    case 3:
                        resultado = cantidad * cordoba;
                        abreviatura = "C$";
                        break;
                    case 4:
                        resultado = cantidad * colonCRC;
                        abreviatura = "₡";
                        break;
                }
                objLabel.setText("1 BTC a " + opciones[optionSelected] + " es: "+abreviatura + resultado.toString());
            }
        });
    }


}