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

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    RecyclerView recyclerView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.history_row_design, container, false );
        recyclerView2 = root.findViewById( R.id.recyclerview2 );

        ArrayList<histoey_row_design> arrayList = new ArrayList<histoey_row_design>();

        arrayList.add( new histoey_row_design( R.drawable.grocery10, "Tata salt", "Salt", "Rs.15", "Order now" ) );
        arrayList.add( new histoey_row_design( R.drawable.grocery11, "Carbery Chocolate", "Chocolate", "Rs.150", "Order now" ) );
        arrayList.add( new histoey_row_design( R.drawable.grocery12, "Coco cola", "Summer Drink", "Rs.150", "Order now" ) );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity() );
        recyclerView2.setLayoutManager( linearLayoutManager );

        Adapter adapter = new Adapter( arrayList );
        recyclerView2.setAdapter( adapter );

        return root;
    }
        class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
            private ArrayList<histoey_row_design> arrayList2;

            public class MyViewHolder extends RecyclerView.ViewHolder {
                TextView textview,text,text1,text2;
                ImageView image;

                public MyViewHolder(View item) {
                    super(item);
                    image = item.findViewById(R.id.image);
                    textview = item.findViewById(R.id.textview);
                    text = item.findViewById(R.id.text);
                    text1 = item.findViewById(R.id.text1);
                    text2 = item.findViewById(R.id.text2);

                }
            }


            public Adapter(ArrayList<histoey_row_design> arrayList1) {
                //consructor to retrieve data
                this.arrayList2 = arrayList1;//global assignment
            }
            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                //row layout specifications

                LayoutInflater inflater=LayoutInflater.from (parent.getContext ());
                View itemView = inflater.inflate (R.layout.fragment_history, parent, false);
                return new MyViewHolder(itemView);

            }
            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {

                //action perform and data set
                holder.image.setImageResource(arrayList2.get (position).getImage());
                holder.textview.setText(arrayList2.get(position).getTextview());
                holder.text.setText(arrayList2.get(position).getText());
                holder.text1.setText(arrayList2.get(position).getText1());
                holder.text2.setText(arrayList2.get(position).getText2());


                // holder.recyclerview.setAdapter ();
            }

            @Override
            public int getItemCount() {

                return arrayList2.size ();
            }
        }
    }
