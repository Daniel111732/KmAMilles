package edu.upc.eseiaat.pma.kmamilles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);

        final EditText textokm = (EditText) findViewById(R.id.Texto_Km);
        final EditText textomillas = (EditText) findViewById(R.id.Texto_Millas);

        textokm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                textokm.setText("");
            }
        });

        textomillas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                textomillas.setText("");
            }
        });

        textokm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(textokm.hasFocus()) {
                    //Km -> Milles
                    if (textokm.getText().length() != 0) {
                        String stringkm = textokm.getText().toString();
                        float km = Float.parseFloat(stringkm);
                        float millas = km / 1.609f;
                        String stringmillas = String.format("%f", millas);
                        textomillas.setText(stringmillas);
                    } else {
                        textomillas.setText("");
                    }
                }
            }
        });

        textomillas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("ha cambiat");
                if(textomillas.hasFocus()) {
                    //Milles -> Km
                    if (textomillas.getText().length() != 0) {
                        String stringmillas = textomillas.getText().toString();
                        float millas = Float.parseFloat(stringmillas);
                        float km = millas * 1.609f;
                        String stringkm = String.format("%f", km);
                        textokm.setText(stringkm);
                    } else {
                        textokm.setText("");
                    }
                }

            }
        });

        /* NO UTILITZEM ELS BOTONS

        Button botonmillas = (Button) findViewById(R.id.Boton_Millas);
        Button botonkm = (Button) findViewById(R.id.Boton_Km);

        botonmillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("testbotonKm","boton millas clicado!");
                //Km -> Milles
                String stringkm=textokm.getText().toString();
                float km = Float.parseFloat(stringkm);
                float millas = km/1.609f;
                String stringmillas= String.format("%f",millas);
                textomillas.setText(stringmillas);
            }
        });

        botonkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("testbotonMillas","boton Km clicado!");
                //Milles -> Km
                String stringmillas=textomillas.getText().toString();
                float millas = Float.parseFloat(stringmillas);
                float km = millas*1.609f;
                String stringkm= String.format("%f",km);
                textokm.setText(stringkm);
            }
        });

        */


    }
}
