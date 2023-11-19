package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAC, btnDivison, btnMultiplication, btnSubtraction, btnAddition, btnEqual, btnDot, btnPercent;
    private boolean dot_inserted, operator_inserted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivison = (Button) findViewById(R.id.btnDivision);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnPercent = (Button) findViewById(R.id.btnPercent);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                displayOne();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                displayOne();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                displayOne();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                displayOne();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                displayOne();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                displayOne();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                displayOne();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                displayOne();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                displayOne();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                displayOne();
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.isEmpty()){
                    curr = "0.";
                    dot_inserted = true;
                }
                displayOne();
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        btnDivison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " ÷ ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dot_inserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspace();
                    }
                    if (operator_inserted == false) {
                        curr = Double.toString(Double.parseDouble(curr) / 100);
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator_inserted==true && !curr.substring(curr.length()-1,curr.length()).equals(" ")){
                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)){
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                        case '%':
                            res = Double.toString(Double.parseDouble(tokens[0]) / 100);
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }
    public void displayOne(){
        calculation.setText(curr);
    }

    public void displayTwo(){
        result.setText(res);
    }

    public void clear(){
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public void backspace(){
        if(!curr.isEmpty()){
            if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                dot_inserted = false;
            }
            if(curr.substring(curr.length()-1, curr.length()).equals(" ")){
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            }else{
                curr = curr.substring(0, curr.length()-1);
            }
        }
    }
}