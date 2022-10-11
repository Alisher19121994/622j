package com.example.a622j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a622j.managers.Managerss;
import com.example.a622j.models.Users;

public class MainActivity extends AppCompatActivity {
    Button save;
    EditText fullname;
    EditText email;
    EditText password;
    EditText c_password;
    Context context;


    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
        initViews();
    }

    public void initViews() {
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        c_password = findViewById(R.id.confirm_password);

        save = findViewById(R.id.button_sign);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveD();
            }
        });

    }


    public void saveD() {

        String getfullname = fullname.getText().toString().trim();
        String getemail = email.getText().toString().trim();
        String getpassword = password.getText().toString().trim();
        String getc_password = c_password.getText().toString().trim();

        Users users = new Users(getfullname, getemail, getpassword, getc_password);

        new Managerss(context,sharedPreferences).saveData(users);


    }
}