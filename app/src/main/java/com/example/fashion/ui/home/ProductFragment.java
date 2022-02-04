package com.example.fashion.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fashion.activities.CartActivity;
import com.example.fashion.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;
import utilities.ProductData;
import utilities.subcategories;

public class ProductFragment extends Fragment {
    RecyclerView recyclerview1, product_recycler;
    Button button1;
    TextView count, plus, minus;
    private ProductFragment holder;
    String category_id, type;
    String user_masterid, Token, identity = "1";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    Bundle bundle;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_product, container, false );
        setHasOptionsMenu( true );

        recyclerview1 = root.findViewById( R.id.recyclerview );
        product_recycler = root.findViewById( R.id.product_recycler );

        button1 = root.findViewById( R.id.button1 );
        count = root.findViewById( R.id.count );
        plus = root.findViewById( R.id.plus );
        minus = root.findViewById( R.id.minus );


        sharedPreferences = getActivity().getSharedPreferences( "Agribiz", Context.MODE_PRIVATE );
        //  category_id = sharedPreferences.getString( "category_id", null );
        type = sharedPreferences.getString( "type", null );

        user_masterid = sharedPreferences.getString( "id", null );
        Token = sharedPreferences.getString( "Token", null );


        bundle = getArguments();
        if (bundle != null) {
            category_id = bundle.getString( "category_id" );
        }

        servicesubcatagories( category_id, type );

        serviceProduct( user_masterid, Token, type, category_id, identity );
        System.out.println( "user_masterid" + user_masterid + "," + "Token" + Token + "," + "type" + type + "," + "categoryid" + category_id + "," + "identity" + identity );


        GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 2 );
        recyclerview1.setLayoutManager( gridLayoutManager );


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );
        product_recycler.setLayoutManager( linearLayoutManager );



        return root;
    }

    private void serviceProduct(String user_masterid, String Token, String type, String categoryid, String identity) {

        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.displayproductsbycategoryid( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();

                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getActivity(), model.getStatus(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {
                            System.out.println("size"+  model.getProductslist().get( 0 ).getProductsData().size());

                            if (model.getProductslist()!= null && model.getProductslist().size()>0&&
                                    model.getProductslist().get( 0 ).getProductsData()!=null&&
                                    model.getProductslist().get( 0 ).getProductsData().size()>0) {

                                Adapter1 adapter = new Adapter1( model.getProductslist().get( 0 ).getProductsData() );
                                recyclerview1.setAdapter( adapter );

                                Toast.makeText( getActivity(), model.getProductslist().get( 0 ).getProductsData().size()+"",Toast.LENGTH_SHORT ).show();

                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getActivity(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_masterid, Token, type, categoryid, identity );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//

    class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {
        private ArrayList<ProductData> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView productname, textView, text1, decre, count, incre,product_cost,product_name;
            ImageView image;

            public MyViewHolder(View item) {
                super( item );
                image = item.findViewById( R.id.image );
                productname = item.findViewById( R.id.productname );
                textView = item.findViewById( R.id.textview );
                text1 = item.findViewById( R.id.text1 );
                decre = item.findViewById( R.id.minus );
                count = item.findViewById( R.id.count );
                incre = item.findViewById( R.id.plus );
                product_cost=item.findViewById( R.id.product_cost );
                product_name=item.findViewById( R.id.product_name );

            }

        }


        public Adapter1(ArrayList<ProductData> arrayList1) {
            this.arrayList2 = arrayList1;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row_gridview_design, parent, false );

            return new MyViewHolder( itemView );

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            Glide.with(getActivity())
                    .load(DataManager.PRODUCT_URL+arrayList2.get(position).getImage())
                    .into(holder.image);

            holder.productname.setText( arrayList2.get( position ).getEnglish_name());

            holder.product_name.setText( arrayList2.get( position ).getTelugu_name());

            holder.product_cost.setText( arrayList2.get( position ).getMrp() );


            //action perform and data set
//            holder.image.setImageResource( arrayList2.get( position ).getImage() );
//            holder.text.setText( arrayList2.get( position ).getText() );
//            holder.textView.setText( arrayList2.get( position ).getTextview() );
//            holder.text1.setText( arrayList2.get( position ).getText1() );


            holder.count.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.count.setText( "1" );
                    holder.count.setClickable( false );
                    holder.incre.setVisibility( View.VISIBLE );
                    holder.decre.setVisibility( View.VISIBLE );
                }
            } );

            holder.decre.setOnClickListener( new View.OnClickListener() {
                @Override
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
                @Override
                public void onClick(View v) {
                    int count_int = Integer.parseInt( holder.count.getText().toString() );
                    count_int = count_int + 1;
                    holder.count.setText( String.valueOf( count_int ) );
                }
            } );



        }

        @Override

        public int getItemCount() {
            return arrayList2.size();
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.cart:
                Intent intent = new Intent( getActivity(), CartActivity.class );
                startActivity( intent );
                break;

        }
        return super.onOptionsItemSelected( item );
    }


    ///

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<subcategories> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView product_text;


            public MyViewHolder(View item) {
                super( item );
                product_text = item.findViewById( R.id.product_text );


            }
        }


        public Adapter(ArrayList<subcategories> arrayList1) {
            //consructor to retrieve data
            this.arrayList2 = arrayList1;//global assignment
        }

        @Override
        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row_product_horizontal, parent, false );
            return new Adapter.MyViewHolder( itemView );

        }

        @Override
        public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

            //action perform and data set
            holder.product_text.setText( arrayList2.get( position ).getName() );


            // holder.recyclerview.setAdapter ();
        }

        @Override
        public int getItemCount() {

            return arrayList2.size();
        }
    }
//

    private void servicesubcatagories(String category_id, String type) {

        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.subcategories_by_category( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();

                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getActivity(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {

                            if(model.getSubcategories()!=null&&model.getSubcategories().size()>0){

                                Adapter adapter1 = new Adapter( model.getSubcategories() );
                                product_recycler.setAdapter( adapter1 );



                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getActivity(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, category_id, type );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
//


}