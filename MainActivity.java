package com.example.manny.mynotes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {
    String myPassword = "123456";
    String strTitleError = "Login Failled";
    String strMsgError = "Incorrect password";
    char[] chr = {' ',' '};
    Button btn1 ;
    Button btn2 ;
    Button btn3 ;
    Button btn4 ;
    Button btn5 ;
    Button btn6 ;
    Button btn7 ;
    Button btn8 ;
    Button btn9 ;
    Button btn10 ;
    Button btnClear ;
    Button btnConfirm ;
    EditText inputTextNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgNumber = String.valueOf(inputTextNumber.getText().toString());
                if (checkPassword(msgNumber)) {
                    nextPage(MyNotesActivity.class);
                } else {
                    new AlertDialog.Builder(MainActivity.this).setTitle(strTitleError).setMessage(strMsgError).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTextNumber.setText("");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputBtnNumber(0);
            }
        });


    }



    private void nextPage(Class page) {
        Intent i = new Intent(this, page);
        startActivity(i);
    }

    private void inputBtnNumber(int i) {
        String msgNumber = String.valueOf(inputTextNumber.getText().toString());
        msgNumber = String.format("%s%d",msgNumber,i);
        inputTextNumber.setText(msgNumber);
    }
    private boolean checkPassword(String str) {
        return str.equals(myPassword);
    }


    private void initialize() {
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btnClear = (Button) findViewById(R.id.button11);
        btnConfirm = (Button) findViewById(R.id.button12);

        inputTextNumber = (EditText)findViewById(R.id.edit_text_number);
    }


}
