package com.in.fashion.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fashion.R;

public class Continue_Activity extends AppCompatActivity {
    ImageView image;
    Button button_continue;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_continue );
        image=findViewById( R.id.image );

        button_continue=findViewById( R.id.button_continue );

//        image.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Continue_Activity.this,CheckOut_Activity.class);
//                startActivity( intent );
//            }
//        } );

        button_continue.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Continue_Activity.this, Payment_Activity.class);
                startActivity( intent );
            }
        } );


        Toolbar toolbar = findViewById(R.id.delivery_tool2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Address");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
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