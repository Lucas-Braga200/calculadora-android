package com.example.calculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String operation = "";
    Number result = null;
    TextView textViewOperation;
    TextView textViewResult;

    public void onClickNumberButtons(View view) {
        try {
            String number = view.getTag().toString();
            addValueToOperation(number);
        } catch (Exception e) {
            System.out.println("=================================");
            System.out.println("Error");
            System.out.println("=================================");
            System.out.println(e);
        }
    }
    public void onClickOperationButtons(View view) {
        try {
            String operation = view.getTag().toString();
            if ("clear".equals(operation)) {
                clearOperation();
            }
            if ("subtraction".equals(operation)) {
                addValueToOperation("-");
            }
            if ("addition".equals(operation)) {
                addValueToOperation("+");
            }
            if ("multiplication".equals(operation)) {
                addValueToOperation("*");
            }
            if ("division".equals(operation)) {
                addValueToOperation("/");
            }
        } catch (Exception e) {
            System.out.println("=================================");
            System.out.println("Error");
            System.out.println("=================================");
            System.out.println(e);
        }
    }

    public void addValueToOperation(String number) {
        if (operation == null) {
            operation = number;
        } else {
            operation += number;
        }
        textViewOperation.setText(operation);
    }
    public void clearOperation() {
        operation = "";
        textViewOperation.setText(operation);
    }

    public void setResultValue(Number value) {
        if (value == null) {
            textViewResult.setText("");
        } else {
            textViewResult.setText(value.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOperation = findViewById(R.id.operation_text);
        textViewResult = findViewById(R.id.result_text);

        textViewOperation.setText(operation);
        setResultValue(result);
    }
}