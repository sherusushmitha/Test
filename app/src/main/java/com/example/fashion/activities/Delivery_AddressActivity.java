package com.example.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fashion.R;
import com.example.fashion.ui.home.delivery_list;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.Addresslist;
import utilities.DataManager;
import utilities.Model;
import utilities.UsersData;

public class Delivery_AddressActivity extends AppCompatActivity {
    RecyclerView delivery_address1;
    TextView choose_text1;
    SharedPreferences sharedPreferences;
    String user_masterid,Token;


//    TextView name,mobile,email,pincode,address,landmark,city,district;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_delivery_address );

        delivery_address1 = findViewById( R.id.delivery_address1 );
        choose_text1=findViewById( R.id.choose_text1 );

        ArrayList<delivery_list> arrayList = new ArrayList<>();


        arrayList.add( new delivery_list( "sheru sushma","395/A","gundlasingaram","506009,Warangal","ph:9876543210") );
        arrayList.add( new delivery_list("sheru manasa","340/B","Hanamkonda","560004,Bangalorw-560004","ph:9321456987") );
        arrayList.add( new delivery_list( "sheru sumathi","6-54-395/A","Wrangal Urban","506001,Hanamkonda","ph:8632541793") );


        GridLayoutManager gridLayoutManager = new GridLayoutManager( getApplication(), 1);
        delivery_address1.setLayoutManager( gridLayoutManager );

//       Adapter adapter = new Adapter( arrayList );
//        delivery_address1.setAdapter( adapter );

        sharedPreferences = getSharedPreferences( "Agribiz", Context.MODE_PRIVATE );
        Token = sharedPreferences.getString( "Token", null );
        user_masterid = sharedPreferences.getString( "id", null );


        serviceAddressList(user_masterid,Token);

//        System.out.println("user_masterid"+user_masterid+","+"name"+name+","+"mobile"+mobile+","+"email"+email+","+"pincode"+pincode+","+
//                "address"+address+","+"landmark"+landmark+","+"city"+city+","+"district"+district);


        Toolbar toolbar = findViewById(R.id.delivery_tool);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Choose Delivery Address");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        choose_text1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=  new Intent(Delivery_AddressActivity.this, Add_AddressActivity.class);
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

    private void serviceAddressList(String user_masterid, String Token) {

        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.findalladdressesbyuserid( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();

                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {

                            ArrayList<Addresslist> addresslist=model.getAddresslists();

                            if(model.getAddresslists()!=null&&model.getAddresslists().size()>0){
                               Adapter adapter = new Adapter( model.getAddresslists() );
                                delivery_address1.setAdapter( adapter );


                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_masterid, Token );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





//    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
//
//    }


    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<Addresslist> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView name,mobile,email,pincode,address,landmark,city,district;


            public MyViewHolder(View item) {
                super( item );
                name = item.findViewById( R.id.name );
                mobile = item.findViewById( R.id.mobile );
                email = item.findViewById( R.id.email );
                pincode = item.findViewById( R.id.pincode );
                address = item.findViewById( R.id.address );
                landmark = item.findViewById( R.id.landmark );
                city = item.findViewById( R.id.city );
                district = item.findViewById( R.id.district );



            }

        }


        public Adapter(ArrayList<Addresslist> arrayList1) {
            this.arrayList2 = arrayList1;
        }

        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row_delivery, parent, false );
            return new Adapter.MyViewHolder( itemView );

        }

        public void onBindViewHolder(MyViewHolder holder, int position) {


            //action perform and data set

            holder.name.setText( arrayList2.get( position ).getName() );
            holder.mobile.setText( arrayList2.get( position ).getMobile() );
            holder.email.setText( arrayList2.get( position ).getEmail() );
            holder.pincode.setText( arrayList2.get( position ).getPincode() );
            holder.address.setText( arrayList2.get( position ).getAddress() );
            holder.landmark.setText( arrayList2.get( position ).getLandmark() );
            holder.city.setText( arrayList2.get( position ).getCity() );
            holder.district.setText( arrayList2.get( position ).getDistrict() );



            holder.itemView.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
//                    ProductFragment productFragment = new ProductFragment();
//                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, productFragment );
//                    fragmentTransaction.addToBackStack( null );
//                    fragmentTransaction.commit();
                }
            } );

        }

        public int getItemCount() {
            return arrayList2.size();
        }


    }


}