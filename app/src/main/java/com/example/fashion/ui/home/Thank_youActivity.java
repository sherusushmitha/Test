package com.example.fashion.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fashion.R;

public class Thank_youActivity extends AppCompatActivity {
//    TextView text_short2;
//    FragmentTransaction fragmentTransaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thank_you );

//        text_short2=findViewById( R.id.text_short2 );


//        text_short2.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                My_AccountFragment my_accountFragment=new My_AccountFragment();
//                fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation,my_accountFragment );
//                fragmentTransaction.addToBackStack( null );
//                fragmentTransaction.commit();
//
//            }
//        } );


            Toolbar toolbar = findViewById(R.id.thank_you);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle( "" );
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
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