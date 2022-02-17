package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button Convert;
    EditText temperature;
    ToggleButton tb;

    Double temp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperature = findViewById(R.id.editTextNumber);
        Convert = findViewById(R.id.button);
        tb = findViewById(R.id.toggleButton);

        Convert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if(temperature.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter a temperature", Toast.LENGTH_SHORT);
                }
                else if(tb.isChecked())
                {
                    ConvertTempCalc CToF = new ConvertTempCalc();
                    temp = Double.parseDouble(String.valueOf(temperature.getText()));
//                    temp = (temp * 1.8) +32;
                    String Faren = CToF.convertFarenheitToCelc(temp);
                    Toast.makeText(MainActivity.this, Faren+" in Farenhieit", Toast.LENGTH_LONG);

                            //1.8 (or 9/5) and add 32.
                }
                else if(!tb.isChecked())
                {
                    temp = Double.parseDouble(String.valueOf(temperature.getText()));
                  //  temp = (temp * 1.8) +32;
                    String Faren = String.valueOf(temp);
                    Toast.makeText(MainActivity.this, Faren +" in Celcius", Toast.LENGTH_LONG);
                }
            }
        }

        );
    }
}