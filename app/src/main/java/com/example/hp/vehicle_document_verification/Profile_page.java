package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 14-09-2022.
 */
public class Profile_page extends AppCompatActivity {
    EditText name,email,mno,city,addr,pass;
    Button update;
    String usr_name,usr_email,usr_mno,usr_city,usr_addr,usr_pass;
    SharedPrefHandler shr;
    String str_shr_umno;
    String[] product;
    List<UserAccountArray> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        name=(EditText)findViewById(R.id.et_update_name);
        email=(EditText)findViewById(R.id.et_update_email);
        mno=(EditText)findViewById(R.id.et_update_mno);
        city=(EditText)findViewById(R.id.et_update_city);
        addr=(EditText)findViewById(R.id.et_update_postaladdress);
        pass=(EditText)findViewById(R.id.et_update_pass);
        update=(Button)findViewById(R.id.btn_update);
        shr=new SharedPrefHandler(this);

        str_shr_umno=shr.getSharedPreferences("umno");
        getProductByCode(str_shr_umno);

        Toast.makeText(Profile_page.this, ""+ str_shr_umno, Toast.LENGTH_SHORT).show();


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_name = name.getText().toString();
                usr_email = email.getText().toString();
                usr_mno = mno.getText().toString();
                usr_city = city.getText().toString();
                usr_addr = addr.getText().toString();
                usr_pass = pass.getText().toString();

                if (usr_name.isEmpty() || usr_pass.isEmpty() || usr_addr.isEmpty() || usr_mno.isEmpty() || usr_city.isEmpty() || usr_email.isEmpty()
                        || !usr_name.matches("[a-zA-Z]+")
                        || !usr_email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
                        || !usr_mno.matches("^[6-9]\\d{9}")
                        || !usr_city.matches("[a-zA-Z]+")) {
                    Toast.makeText(Profile_page.this, "Fill details", Toast.LENGTH_SHORT).show();
                } else {

                    CreateUserAccount();
                    Toast.makeText(Profile_page.this, "Updated succesfully " + usr_name + usr_email + usr_mno + usr_city + usr_addr + usr_pass, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getProductByCode(final String str_shr_umno)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<UserAccountArray>> call = api.getUserdetails(str_shr_umno);

        call.enqueue(new Callback<List<UserAccountArray>>() {
            @Override
            public void onResponse(Call<List<UserAccountArray>> call, Response<List<UserAccountArray>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    Toast.makeText(Profile_page.this, "Hi", Toast.LENGTH_SHORT).show();
                    name.setText(productList.get(0).getname());
                    email.setText(productList.get(0).getemail());
                    mno.setText(productList.get(0).getmobileno());
                    city.setText(productList.get(0).getcity());
                    addr.setText(productList.get(0).getpostaladdress());
                    pass.setText(productList.get(0).getpassword());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<UserAccountArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExist> call = api.updatepage(
                usr_name, usr_email, usr_mno, usr_city, usr_addr, usr_pass
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
