package com.example.hp.vehicle_document_verification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by HP on 18-09-2022.
 */
public class Pdf_page extends AppCompatActivity {
    Button pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_page);
        pdf=(Button)findViewById(R.id.btn_pdf);

    }
}
