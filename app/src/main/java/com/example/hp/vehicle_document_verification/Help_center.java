package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HP on 14-09-2022.
 */
public class Help_center extends AppCompatActivity {
    ImageView call_admin,call_technical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_center);

        call_admin =(ImageView)findViewById(R.id.img_call1);
        call_technical =(ImageView)findViewById(R.id.img_call2);

        call_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:6363096585"));
                startActivity(i);
            }
        });

        call_technical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:7090102409"));
                startActivity(i);
            }
        });
    }
}


