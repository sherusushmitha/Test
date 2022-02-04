package com.example.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.fashion.R;
import com.example.fashion.ui.home.Thank_youActivity;

public class ContactActivity extends AppCompatActivity {
    Button con_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contact );
        con_button=findViewById( R.id.con_button );

        con_button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(ContactActivity.this, Thank_youActivity.class);
                startActivity( intent );
            }
        } );



        Toolbar toolbar = findViewById(R.id.delivery_tool1);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    }
