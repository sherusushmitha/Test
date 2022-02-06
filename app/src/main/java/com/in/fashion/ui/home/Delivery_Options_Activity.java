package com.in.fashion.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fashion.R;
import com.in.fashion.activities.Delivery_AddressActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Delivery_Options_Activity extends AppCompatActivity {
   TextView change;
   private BottomSheetDialog bottomSheetDialog;
   Button button;
   FragmentTransaction fragmentTransaction;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_delivery_options );
        change=findViewById( R.id.change );
        button=findViewById( R.id.button );


        Toolbar toolbar = findViewById(R.id.delivery_tool1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Delivery Options ");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

//        text2.setOnClickListener( new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                bottomSheetDialog=new BottomSheetDialog( CheckOut_Activity.this,R.style.BottomSheetTheme );
//
//                View sheetview= LayoutInflater.from(getApplicationContext()).inflate( R.layout.activity_bottom_sheet_background ,
//                        (LinearLayout)findViewById( R.id.bottomSheetContainer ));
//                sheetview.findViewById( R.id.add_address ).setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent=new Intent(CheckOut_Activity.this,Add_AddressActivity.class);
//                        startActivity( intent );
//                        bottomSheetDialog.dismiss();
//
//                    }
//                } );
//                bottomSheetDialog.setContentView( sheetview );
//                bottomSheetDialog.show();
//
//            }
//        } );

        change.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
//
//                Delivery_AddressFragment deliveryFragment = new Delivery_AddressFragment();
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, deliveryFragment);
//                fragmentTransaction.addToBackStack( null );
//                fragmentTransaction.commit();
                Intent intent=new Intent( Delivery_Options_Activity.this, Delivery_AddressActivity.class);
                startActivity( intent );
            }
        } );

        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent( Delivery_Options_Activity.this, Payment_Activity.class);
                startActivity( intent );
            }
        } );


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