package com.example.fashion.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fashion.R;

public class Private_PolicyActivity extends AppCompatActivity {
    TextView message_window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_private_policy );

        Toolbar toolbar = findViewById(R.id.delivery_tool6);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Privacy & Policy");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

//        message_window = findViewById( R.id.message_window );
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String someMessage = "We value the trust you place in us and recognize the importance of secure transactions and information privacy. This Privacy Policy describes how Flipkart Internet Private Limited and its affiliates (collectively “Flipkart, we, our, us”) collect, use, share or otherwise process your personal information through Flipkart website www.flipkart.com, its mobile application, and m-site (hereinafter referred to as the “Platform”).\n" +
//                "\n" +
//                "While you may be able to browse certain sections of the Platform without registering with us, however, please note we do not offer any product/service under this Platform outside India. By visiting this Platform, providing your information or availing out product/service, you expressly agree to be bound by the terms and conditions of this Privacy Policy, the Terms of Use and the applicable service/product terms and conditions, and agree to be governed by the laws of India including but not limited to the laws applicable to data protection and privacy. If you do not agree please do not use or access our Platform.";
//
//        for(int i=0;i<100;i++){
//            StringBuilder.append(someMessage);
//        }
//        message_window.setText( StringBuilder.toString() );
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}