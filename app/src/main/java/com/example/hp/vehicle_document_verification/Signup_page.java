package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 12-09-2022.
 */
public class Signup_page extends AppCompatActivity {
    EditText name,email,mobileno,city,addr,pass;
    Button add;
    String str_name,str_email,str_mno,str_city,str_addr,str_pass;
    SharedPrefHandler shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        name=(EditText)findViewById(R.id.et_signup_name);
        email=(EditText)findViewById(R.id.et_signup_email);
        mobileno=(EditText)findViewById(R.id.et_signup_mno);
        city=(EditText)findViewById(R.id.et_signup_city);
        addr=(EditText)findViewById(R.id.et_signup_postaladdress);
        pass=(EditText)findViewById(R.id.et_signup_pass);
        add=(Button)findViewById(R.id.btn_signup_add);
        shr=new SharedPrefHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_name = name.getText().toString();
                str_email = email.getText().toString();
                str_mno = mobileno.getText().toString();
                str_city = city.getText().toString();
                str_addr = addr.getText().toString();
                str_pass = pass.getText().toString();

                if (str_name.isEmpty() || str_email.isEmpty() || str_mno.isEmpty() || str_city.isEmpty() || str_addr.isEmpty() || str_pass.isEmpty()
                        || !str_name.matches("[a-zA-Z]+")
                        || !str_email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
                        || !str_mno.matches("^[6-9]\\d{9}")
                        || !str_city.matches("[a-zA-Z]+"))

                {
                    Toast.makeText(Signup_page.this, "Fill all details", Toast.LENGTH_SHORT).show();
                } else {

                    shr.setSharedPreferences("str_mno",str_mno);
                    shr.setSharedPreferences("str_pass",str_pass);

                    CreateUserAccount();
                    Intent i = new Intent(getApplication(),Login_page.class);
                    startActivity(i);
                    Toast.makeText(Signup_page.this, "Added succesfully", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }

    ///This function is used to post application data to the server using post method and help of a retrofeit library(http protocol)
    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.signup_page(
                str_name, str_email, str_mno, str_city, str_addr, str_pass
        );

        call.enqueue(new Callback<IsExist>() {
            @Override
            public void onResponse(Call<IsExist> call, Response<IsExist> response) {
                IsExist responseResult = response.body();

                Boolean isSuccess = false;
                if(responseResult != null)
                {
                    isSuccess = responseResult.getSuccess();
                }

                if(isSuccess)
                {

                }
                else
                {
                    // Show Creation Failed Message

                }
            }

            @Override
            public void onFailure(Call<IsExist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
