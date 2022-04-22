package com.example.lesson7task4java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.text_input_email);
        password = (EditText) findViewById(R.id.text_input_password);
        loginButton = (Button) findViewById(R.id.input_button);
        textView = (TextView) findViewById(R.id.textView);

        email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                textView.setText(email.getText().toString());
                return false;
            }
        });

        loginButton.setEnabled(false);

        TextWatcher textWatcher = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                String emailInput = MainActivity.this.email.getText().toString();
                String passwordText = MainActivity.this.password.getText().toString();
                loginButton.setEnabled(!emailInput.contentEquals("") && !passwordText.contentEquals(""));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        };
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }
}