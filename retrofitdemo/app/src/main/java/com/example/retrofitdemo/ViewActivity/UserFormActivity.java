package com.example.retrofitdemo.ViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitdemo.R;

public class UserFormActivity extends AppCompatActivity {

    TextView content;
    EditText fname, email, login, pass;

    Button btnThem, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        content = (TextView) findViewById(R.id.content);
        fname = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        login = (EditText) findViewById(R.id.loginname);
        pass = (EditText) findViewById(R.id.password);


        btnThoat = findViewById(R.id.btnThoat);
        btnThem= findViewById(R.id.btnThem);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btnThem:
                    them();
                    break;

                case R.id.btnThoat:

                    break;
            }
        }
    };

    private void them() {
        String Name, Email, User, Pass;

        Name = fname.getText().toString();
        Email = email.getText().toString();
        User = login.getText().toString();
        Pass = pass.getText().toString();


    }
}
