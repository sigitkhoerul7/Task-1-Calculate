package com.example.sigit.calculate;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputBinding;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    KeyboardView key;
    EditText in,out;
    TextView balance;
    FloatingActionButton del,hit;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Keypad actionlistener = new Keypad(this);


        key =(KeyboardView) findViewById(R.id.keyboard);
        Keyboard keyboard = new Keyboard(this, R.layout.keyboard);
        key.setKeyboard(keyboard);
        key.setOnKeyboardActionListener(actionlistener);

        in = (EditText)findViewById(R.id.Income);
        out = (EditText)findViewById(R.id.Outcome);
        balance = (TextView) findViewById(R.id.Balance);


        in.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                EditText edittext = (EditText) v;
                int inType = edittext.getInputType();       // Backup the input type
                edittext.setInputType(InputType.TYPE_NULL); // Disable standard keyboard
                edittext.onTouchEvent(event);               // Call native handler
                edittext.setInputType(inType);              // Restore input type
                return true; // Consume touch event
            }
        });
        in.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch (View v, MotionEvent event){
                EditText editText = (EditText) v;
                int inType = editText.getInputType();
                editText.setInputType(InputType.TYPE_NULL);
                editText.onTouchEvent(event);
                editText.setInputType(inType);
                return true;
            }
        });

        in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //cursor start from the last char
                int count = editable.length();
                in.setSelection(count);
            }
        });
        out.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        hit = (FloatingActionButton)findViewById(R.id.floatinghasil);

        hit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                String income = in.getText().toString();
                String outcome = out.getText().toString();
                int hasil;

                if (income.isEmpty()||outcome.isEmpty()){
                    Toast.makeText(MainActivity.this,"Filed is empety", Toast.LENGTH_SHORT).show();
                }else{
                    int inint = Integer.parseInt(income);
                    int outint = Integer.parseInt(outcome);

                    hasil = inint - outint;

                    balance.setText("Balance : " + hasil);
                }

                hit.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view){
                        in.setText("");
                        out.setText("");
                        balance.setText("");
                     }
                });


            }
        });

    }
}

