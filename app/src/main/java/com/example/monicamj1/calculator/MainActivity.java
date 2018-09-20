package com.example.monicamj1.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    //Model
    private String num = "0"; //Aquí es donde está guardado el número actual.
    private String numA = "0"; //Número anterior
    private char operator = ' ';

    //References
    private TextView numView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numView = findViewById(R.id.numView);
        numView.setText(num);
    }




   public void onClickDigit(View view){
       Button b = (Button)view;
       //String num = numView.getText().toString();
       num += b.getText().toString();
       numView.setText(num);
   }

   public void onClickOperator(View view){
        Button b = (Button)view;
        numA = num;
        num = "";
        operator = b.getText().toString().charAt(0);
        numView.setText(num);

   }

   public void onClickEquals(View view){
        double x = Double.valueOf(num);
        double xA = Double.valueOf(numA);

        switch(operator){
            case '+':
                num = Double.toString(xA+x);
                break;
            case '-':
                num = Double.toString(xA-x);
                break;
            case '*':
                num = Double.toString(xA*x);
                break;
            case '/':
                num = Double.toString(xA/x);
                break;
            case ' ':
                Toast.makeText(this, "Set next value.", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Set operation", Toast.LENGTH_SHORT).show();
                break;
        }

       numView.setText(num);
   }


}
