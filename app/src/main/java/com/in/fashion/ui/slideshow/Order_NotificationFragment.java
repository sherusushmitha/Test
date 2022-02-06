package com.in.fashion.ui.slideshow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fashion.R;

import java.util.ArrayList;

public class Order_NotificationFragment extends Fragment {
    RecyclerView recyclerView5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.row_order_notification, container, false );

        recyclerView5 = root.findViewById( R.id.recyclerview5 );

        ArrayList<row_order_notification> arrayList = new ArrayList<row_order_notification>();

        arrayList.add( new row_order_notification( R.drawable.grocery13, "Tata Salt", "sushanth has delivered your order successfuly! Thanks for choosing us today" ) );
        arrayList.add( new row_order_notification( R.drawable.grocery26, "Yellow Dragon Fruit", "sushanth has delivered your order successfuly! Thanks for choosing us today" ) );
        arrayList.add( new row_order_notification( R.drawable.grocery24, "Oranges", "sushanth has delivered your order successfuly! Thanks for choosing us today" ) );


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity() );
        recyclerView5.setLayoutManager( linearLayoutManager );

        Adapter adapter = new Adapter( arrayList );
        recyclerView5.setAdapter( adapter );


        return root;


    }
    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<row_order_notification> arrayList2;

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


        public Adapter(ArrayList<row_order_notification> arrayList1) {
            //consructor to retrieve data
            this.arrayList2 = arrayList1;//global assignment
        }
        @Override
        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater=LayoutInflater.from (parent.getContext ());
            View itemView = inflater.inflate (R.layout.fragment_order__notification, parent, false);
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