package com.example.fashion.ui.slideshow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fashion.R;

import java.util.ArrayList;


public class NewsFragment extends Fragment {
    RecyclerView recyclerView6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.row_news, container, false );

        recyclerView6=root.findViewById( R.id.recyclerview6 );

        ArrayList<row_news> arrayList=new ArrayList<row_news>();

        arrayList.add( new row_news( R.drawable.j1,"Fish","Discount Offer Rs:35/- when order in groceries" ) );
        arrayList.add( new row_news( R.drawable.l1,"Crabs","Discount Offer Rs:35/- when order in groceries" ) );
        arrayList.add( new row_news( R.drawable.m1,"Chiken","Discount Offer Rs:35/- when order in groceries" ) );
        arrayList.add( new row_news( R.drawable.n1,"Fresh mutton Meat","Discount Offer Rs:35/- when order in groceries" ) );


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity() );
        recyclerView6.setLayoutManager( linearLayoutManager );

        Adapter adapter = new Adapter( arrayList );
        recyclerView6.setAdapter( adapter );

        return root;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<row_news> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text,text1;
            ImageView image;

            public MyViewHolder(View item) {
                super(item);
                image = item.findViewById(R.id.image);
                text = item.findViewById(R.id.text);
                text1 = item.findViewById(R.id.text1);



            }
        }


        public Adapter(ArrayList<row_news> arrayList1) {
            //consructor to retrieve data
            this.arrayList2 = arrayList1;//global assignment
        }
        @Override
        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater=LayoutInflater.from (parent.getContext ());
            View itemView = inflater.inflate (R.layout.fragment_news, parent, false);
            return new Adapter.MyViewHolder(itemView);

        }
        @Override
        public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

            //action perform and data set
            holder.image.setImageResource(arrayList2.get (position).getImage());
            holder.text.setText(arrayList2.get(position).getText());
            holder.text1.setText(arrayList2.get(position).getText1());



            // holder.recyclerview.setAdapter ();
        }

        @Override
        public int getItemCount() {

            return arrayList2.size ();
        }
    }
}