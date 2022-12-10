package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 12-09-2022.
 */
public class Login_page extends AppCompatActivity {
    EditText mob,pass;
    Button login;
    TextView tv;
    String str_mob,str_pass;
    SharedPrefHandler shr;

    String str_shr_mno,str_shr_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mob=(EditText)findViewById(R.id.et_Vehicle_Mobile);
        pass=(EditText)findViewById(R.id.et_Vehicle_Password);
        login=(Button)findViewById(R.id.btn_LOGIN);
        tv=(TextView)findViewById(R.id.tv_newaccount);
        shr=new SharedPrefHandler(this);
        str_shr_mno=shr.getSharedPreferences("str_mno");
        str_shr_pass=shr.getSharedPreferences("str_pass");

        Toast.makeText(Login_page.this, "input "+str_mob+str_pass, Toast.LENGTH_SHORT).show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_mob = mob.getText().toString();
                str_pass = pass.getText().toString();
                if (str_mob.length() < 10 || str_pass.isEmpty() || !str_mob.matches("^[6-9]\\d{9}"))
                {
                    Toast.makeText(Login_page.this, "Fill the details", Toast.LENGTH_SHORT).show();
                }
                else if (str_mob.equals(str_shr_mno) && str_pass.equals(str_shr_pass)) {
                    shr.setSharedPreferences("login","true");
                    shr.setSharedPreferences("umno",str_mob);
                    Intent i = new Intent(getApplication(), Home_page.class);
                    startActivity(i);
                    Toast.makeText(Login_page.this, "Home page", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login_page.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Signup_page.class);
                startActivity(i);
                Toast.makeText(Login_page.this, "Signup page", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
