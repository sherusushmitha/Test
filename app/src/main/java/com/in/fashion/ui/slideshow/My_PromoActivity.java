package com.in.fashion.ui.slideshow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.fashion.R;

public class My_PromoActivity extends AppCompatActivity {
    ImageView imageview;
    FragmentTransaction fragmentTransaction;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate( savedInstanceState );
       setContentView( R.layout.activity_my_promo );
       imageview=findViewById( R.id.imageView );
//       imageview.setOnClickListener( new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               FragmentManager fragmentManager = getSupportFragmentManager();
//               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//               fragmentTransaction.replace(R.id.relative, new My_AccountFragment()).commit();
//           }
//       } );


//       FragmentManager fragmentManager = getSupportFragmentManager();
//       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//       fragmentTransaction.replace(R.id.relative, new My_AccountFragment()).commit();

       Toolbar toolbar = findViewById(R.id.delivery_tool9);
       setSupportActionBar(toolbar);
       ActionBar actionBar = getSupportActionBar();
       if (actionBar != null) {
           actionBar.setTitle("My Promo");
           actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
           actionBar.setDisplayHomeAsUpEnabled(true);
           actionBar.setHomeButtonEnabled(true);
       }



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

