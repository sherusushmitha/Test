package com.example.fashion.ui.gallery;

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
import com.example.fashion.draft_row;

import java.util.ArrayList;

public class DraftFragment extends Fragment {
    RecyclerView recyclerView3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.draft_row_design, container, false );
        recyclerView3=root.findViewById( R.id.recyclerview3 );

        ArrayList<draft_row> arrayList=new ArrayList<draft_row>();

        arrayList.add( new draft_row( R.drawable.grocery32,"Avocado","Agriculture farming","Rs.200","Draft") );
        arrayList.add( new draft_row( R.drawable.grocery27,"Passion fruits","Agriculture farming","Rs.200","Draft") );
        arrayList.add( new draft_row( R.drawable.grocery29,"Stoberry","Agriculture farming","Rs.350","Draft") );
        arrayList.add( new draft_row( R.drawable.grocery2,"Fruits","Agriculture farming","Rs.500","Draft") );



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView3.setLayoutManager(linearLayoutManager);

       Adapter adapter = new Adapter(arrayList);
        recyclerView3.setAdapter(adapter);



        return root;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<draft_row> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text,text1,text2,text3;
            ImageView image;

            public MyViewHolder(View item) {
                super(item);
                image = item.findViewById(R.id.image);
                text = item.findViewById(R.id.text);
                text1 = item.findViewById(R.id.text1);
                text2 = item.findViewById(R.id.text2);
                text3 = item.findViewById(R.id.text3);


            }
        }


        public Adapter(ArrayList<draft_row> arrayList1) {
            //consructor to retrieve data
            this.arrayList2 = arrayList1;//global assignment
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //row layout specifications

            LayoutInflater inflater=LayoutInflater.from (parent.getContext ());
            View itemView = inflater.inflate (R.layout.fragment_draft, parent, false);
            return new MyViewHolder(itemView);

        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            //action perform and data set
            holder.image.setImageResource(arrayList2.get (position).getImage());
            holder.text.setText(arrayList2.get(position).getText());
            holder.text1.setText(arrayList2.get(position).getText1());
            holder.text2.setText(arrayList2.get(position).getText2());
            holder.text3.setText(arrayList2.get(position).getText3());


            // holder.recyclerview.setAdapter ();
        }

        @Override
        public int getItemCount() {

            return arrayList2.size ();
        }
    }

}