package com.in.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.in.fashion.ui.home.Delivery_Options_Activity;
import com.example.fashion.R;
import com.in.fashion.cart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView recycler;
    Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );

        recycler = findViewById( R.id.recycler );

        button = findViewById( R.id.button );

        ArrayList<cart> arrayList = new ArrayList<cart>();

        arrayList.add( new cart( R.drawable.d1, "Fresh-Water Melon", "2 pcs-(Approx.1kg-2kg)", "Rs 250" ) );
        arrayList.add( new cart( R.drawable.e1, "Fresh-Strawberry", "2 pcs-(Approx.1kg-2kg)", "Rs 550" ) );
        arrayList.add( new cart( R.drawable.f1, "Fresh-Cream", "2 box-(Approx.1kg-2kg)", "Rs 100" ) );
        arrayList.add( new cart( R.drawable.b1, "Fresh-Bananas", "2 pcs-(Approx.1kg-2kg)", "Rs 90" ) );
        arrayList.add( new cart( R.drawable.c1, "Fresh-Cherry", "2 pcs-(Approx.1kg-2kg)", "Rs 600" ) );
        arrayList.add( new cart( R.drawable.j1, "Fresh-Fish", "2 pcs-(Approx.1kg-2kg)", "Rs 500" ) );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        recycler.setLayoutManager( linearLayoutManager );

        Adapter adapter = new Adapter( arrayList );
        recycler.setAdapter( adapter );

        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( CartActivity.this, Delivery_Options_Activity.class );
                startActivity( intent );
            }
        } );

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Cart");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }


    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<cart> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text, text1, text2, decre, count, incre;
            ImageView image;

            public MyViewHolder(View item) {
                super( item );
                image = item.findViewById( R.id.image );
                text = item.findViewById( R.id.text );
                text1 = item.findViewById( R.id.text1 );
                text2 = item.findViewById( R.id.text2 );
                decre = item.findViewById( R.id.minus );
                count = item.findViewById( R.id.count );
                incre = item.findViewById( R.id.plus );

            }
        }


        public Adapter(ArrayList<cart> arrayList1) {

            this.arrayList2 = arrayList1;
        }

        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row_cart_design, parent, false );
            return new Adapter.MyViewHolder( itemView );

        }


        public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

            //action perform and data set
            holder.image.setImageResource( arrayList2.get( position ).getImage() );
            holder.text.setText( arrayList2.get( position ).getText() );
            holder.text1.setText( arrayList2.get( position ).getText1() );
            holder.text2.setText( arrayList2.get( position ).getText2() );


            holder.count.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    holder.count.setText( "1" );
                    holder.count.setClickable( false );
                    holder.incre.setVisibility( View.VISIBLE );
                    holder.decre.setVisibility( View.VISIBLE );
                }
            } );
            holder.decre.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    int count_int = Integer.parseInt( holder.count.getText().toString() );
                    if (count_int > 1) {
                        count_int = count_int - 1;
                        holder.count.setText( String.valueOf( count_int ) );
                    } else {
                        holder.count.setText( "AddCart" );
                        holder.incre.setVisibility( View.GONE );
                        holder.count.setClickable( true );
                        holder.decre.setVisibility( View.GONE );
                    }
                }
            } );

            holder.incre.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    int count_int = Integer.parseInt( holder.count.getText().toString() );
                    count_int = count_int + 1;
                    holder.count.setText( String.valueOf( count_int ) );
                }
            } );


        }


        public int getItemCount() {

            return arrayList2.size();
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