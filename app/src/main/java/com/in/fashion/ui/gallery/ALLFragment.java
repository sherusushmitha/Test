package com.in.fashion.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fashion.R;

import java.util.ArrayList;


public class ALLFragment extends Fragment {
    RecyclerView recyclerView1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.all_row_design, container, false );
        recyclerView1=root.findViewById( R.id.recyclerview1 );




        ArrayList<all_row_design> arrayList=new ArrayList<all_row_design>();

        arrayList.add( new all_row_design( R.drawable.grocery3,R.drawable.ic_baseline_star_border_24,"Vegan Noodles","Home Made","Rs.150","coming in 1 day...","5","Free Delivery" ) );
        arrayList.add( new all_row_design( R.drawable.grocery10,R.drawable.ic_baseline_star_border_24,"Dettol","AntiVirus Protaction","Rs.50","coming in 1 day...","5","Free Delivery" ) );
        arrayList.add( new all_row_design( R.drawable.grocery6,R.drawable.ic_baseline_star_border_24,"Apples","Agriculture Farming","Rs.100","coming in 1 day...","5","Free Delivery" ) );
        arrayList.add( new all_row_design( R.drawable.grocery7,R.drawable.ic_baseline_star_border_24,"Honey","Natural honey","Rs.550","coming in 1 day...","5","Free Delivery" ) );
        arrayList.add( new all_row_design( R.drawable.grocery4,R.drawable.ic_baseline_star_border_24,"Maggi","Home Made","Rs.50","coming in 1 day...","5","Free Delivery" ) );


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(linearLayoutManager);

        Adapter adapter = new Adapter(arrayList);
        recyclerView1.setAdapter(adapter);

        return root;
    }
    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<all_row_design> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text,text1,text2,text3,text4,text5;
            ImageView image1,image2;

            public MyViewHolder(View item) {
                super(item);
                image1 = item.findViewById(R.id.image1);
                image2 = item.findViewById(R.id.image2);
                text = item.findViewById(R.id.text);
                text1 = item.findViewById(R.id.text1);
                text2 = item.findViewById(R.id.text2);
                text3 = item.findViewById(R.id.text3);
                text4 = item.findViewById(R.id.text4);
                text5 = item.findViewById(R.id.text5);

            }
        }


        public Adapter(ArrayList<all_row_design> arrayList1) {
            //consructor to retrieve data
            this.arrayList2 = arrayList1;//global assignment
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater=LayoutInflater.from (parent.getContext ());
            View itemView = inflater.inflate (R.layout.fragment_a_l_l, parent, false);
            return new MyViewHolder(itemView);

        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            //action perform and data set
            holder.image1.setImageResource(arrayList2.get (position).getImage1());
            holder.image2.setImageResource(arrayList2.get (position).getImage2());
            holder.text.setText(arrayList2.get(position).getText());
            holder.text1.setText(arrayList2.get(position).getText1());
            holder.text2.setText(arrayList2.get(position).getText2());
            holder.text3.setText(arrayList2.get(position).getText3());
            holder.text4.setText(arrayList2.get(position).getText4());
            holder.text5.setText(arrayList2.get(position).getText5());


            // holder.recyclerview.setAdapter ();
        }

        @Override
        public int getItemCount() {

            return arrayList2.size ();
        }
    }

}