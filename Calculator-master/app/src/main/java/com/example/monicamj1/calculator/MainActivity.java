package com.example.monicamj1.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Model
    private String num = ""; //Aquí es donde está guardado el número actual.
    private String numA = ""; //Número anterior
    private char operator = ' ';
    //private Boolean cont = false;
    private Boolean point = false;


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
       Button b = (Button) view;
       /*
       if(cont == false){
           num = "0";
       }*/
       num += b.getText().toString();

       //Delete leading zeros
       while (num.length() > 1 && num.indexOf("0")==0) {
           num = num.substring(1);
       }


       numView.setText(num);
   }

   public void onClickOperator(View view){
        Button b = (Button) view;
        if(num == "") {
            Toast.makeText(this, "Set second value", Toast.LENGTH_SHORT).show();
        }else

            numA = num;
            operator = b.getText().toString().charAt(0);
            point = false;
            /*
            if(cont == true){
                onClickEquals(view);
            }else{
                num = "0";
            }*/
           num = "";
           numView.setText(num);
           //cont = true;

   }

   public void onClickEquals(View view){
       double result;
        if(num == ""){
            Toast.makeText(this, "Set second value", Toast.LENGTH_SHORT).show();
        }else {
            double x = Double.valueOf(num);
            double xA = Double.valueOf(numA);

            switch (operator) {
                case '+':
                    num = Double.toString(xA + x);
                    break;
                case '-':
                    num = Double.toString(xA - x);
                    break;
                case '*':
                    num = Double.toString(xA * x);
                    break;
                case '/':
                    num = Double.toString(xA / x);
                    break;
                case ' ':
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    break;
            }

            numView.setText(num);
            operator = ' ';
            //cont = false;
            numA = num;
            point = false;
        }
   }

    public void onClickReset(View view){
        num = "0";
        numA = "0";
        operator = ' ';
        numView.setText(num);
        //cont = false;

    }

    public void onClickDeleteLast(View view){
        if (num != null && num.length() > 0) {
            num = num.substring(0, num.length() - 1);
        }
        numView.setText(num);

    }

    public void onClickAddComa (View view){
        if(point==false) {
            Button b = (Button) view;
            num += b.getText().toString();
            numView.setText(num);
            point = true;
        }
    }
}
