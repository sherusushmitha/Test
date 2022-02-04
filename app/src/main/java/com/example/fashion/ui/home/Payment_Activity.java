package com.example.fashion.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.fashion.R;
import com.example.fashion.activities.Add_AddressActivity;

public class Payment_Activity extends AppCompatActivity {
    TextView textview;
    ScrollView scrollView;
    ImageView image_one;
    LinearLayout hiddenView;
    CardView one;
    int status = 0;

    LinearLayout hiddenView1;
    ImageView image_one1;
    CardView two;

    LinearLayout hiddenView2;
    ImageView image_one2;
    CardView three;

    Button pay;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_payment );
        scrollView = findViewById( R.id.scroll );

        one = findViewById( R.id.one );
        image_one = findViewById( R.id.image_one );
        hiddenView = findViewById( R.id.hidden_view );

        two = findViewById( R.id.two );
        image_one1 = findViewById( R.id.image_one1 );
        hiddenView1 = findViewById( R.id.hidden_view1 );


        three = findViewById( R.id.three );
        image_one2 = findViewById( R.id.image_one2 );
        hiddenView2 = findViewById( R.id.hidden_view2 );
        pay=findViewById( R.id.pay );

        textview=findViewById( R.id.textview );

        textview.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Payment_Activity.this, Add_AddressActivity.class);
                startActivity( intent );
            }
        } );

        Toolbar toolbar = findViewById(R.id.delivery_tool4);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Payment");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



        image_one.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                if (status == 0) {
                    hiddenView.setVisibility( View.VISIBLE );
                    image_one.setImageResource( R.drawable.less );
                    status = 1;
                } else if (status == 1) {
                    hiddenView.setVisibility( View.GONE );
                    image_one.setImageResource( R.drawable.more );
                    status = 0;
                }

//                if (hiddenView.getVisibility() == View.VISIBLE) {
//                    TransitionManager.beginDelayedTransition(one,
//                            new AutoTransition());
//                    hiddenView.setVisibility(View.GONE);
//                    image_one.setImageResource(R.drawable.more);
//                }
//                else {
//
//                    TransitionManager.beginDelayedTransition(one,
//                            new AutoTransition());
//                    hiddenView.setVisibility(View.VISIBLE);
//                    image_one.setImageResource(R.drawable.less);
//                }

            }
        } );

        image_one1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                if (status == 0) {
                    hiddenView1.setVisibility( View.VISIBLE );
                    image_one1.setImageResource( R.drawable.less );
                    status = 1;
                } else if (status == 1) {
                    hiddenView1.setVisibility( View.GONE );
                    image_one1.setImageResource( R.drawable.more );
                    status = 0;
                }

            }
        } );


        image_one2.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                if (status == 0) {
                    hiddenView2.setVisibility( View.VISIBLE );
                    image_one2.setImageResource( R.drawable.less );
                    status = 1;
                } else if (status == 1) {
                    hiddenView2.setVisibility( View.GONE );
                    image_one2.setImageResource( R.drawable.more );
                    status = 0;
                }

            }
        } );


        pay.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                showDialogBox();


            }

            private void showDialogBox() {

                    ViewGroup viewGroup = findViewById( android.R.id.content );

                    View view = LayoutInflater.from( getApplicationContext() ).inflate( R.layout.row_pay_now_design, viewGroup, false );
                    Button submit = view.findViewById( R.id.button1 );


                    AlertDialog.Builder builder = new AlertDialog.Builder( Payment_Activity.this );
                    builder.setView( view );//setting view to  dialog
                    //Creating dialog box
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    submit.setOnClickListener( new View.OnClickListener() {
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    } );
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




