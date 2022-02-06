package com.in.fashion.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fashion.R;

import java.util.ArrayList;


public class Delivery_AddressFragment extends Fragment {
    RecyclerView delivery_address;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.fragment_delivery__address, container, false );
//        delivery_address=root.findViewById( R.id.delivery_address );
//
//        ArrayList<delivery_list> arrayList = new ArrayList<delivery_list>();
//
//
//        arrayList.add( new delivery_list( "sheru sushma","395/A","gundlasingaram","506009,Warangal","ph:9876543210") );
//        arrayList.add( new delivery_list("sheru manasa","340/B","Hanamkonda","560004,Bangalorw-560004","ph:9321456987") );
//        arrayList.add( new delivery_list( "sheru sumathi","6-54-395/A","Wrangal Urban","506001,Hanamkonda","ph:8632541793") );
//
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 1);
//        delivery_address.setLayoutManager( gridLayoutManager );
//
//       Adapter adapter = new Adapter( arrayList );
//        delivery_address.setAdapter( adapter );
        return root;
    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        private ArrayList<delivery_list> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView delivery_textview,delivery_textview1,delivery_textview2,delivery_textview3,delivery_textview4;


            public MyViewHolder(View item) {
                super( item );
                delivery_textview = item.findViewById( R.id.delivery_textview );
                delivery_textview1 = item.findViewById( R.id.delivery_textview );
                delivery_textview2 = item.findViewById( R.id.delivery_textview );
                delivery_textview3 = item.findViewById( R.id.delivery_textview );
                delivery_textview4 = item.findViewById( R.id.delivery_textview );



            }

        }


        public Adapter(ArrayList<delivery_list> arrayList1) {
            this.arrayList2 = arrayList1;
        }

        public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row_delivery, parent, false );
            return new Adapter.MyViewHolder( itemView );

        }

        public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

            //action perform and data set
            holder.delivery_textview.setText( arrayList2.get( position ).getDelivery_textview() );
            holder.delivery_textview1.setText( arrayList2.get( position ).getDelivery_textview1() );
            holder.delivery_textview2.setText( arrayList2.get( position ).getDelivery_textview2() );
            holder.delivery_textview3.setText( arrayList2.get( position ).getDelivery_textview3() );
            holder.delivery_textview4.setText( arrayList2.get( position ).getDelivery_textview4() );



            holder.itemView.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {

                    Delivery_AddressFragment delivery_addressFragment = new Delivery_AddressFragment();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, delivery_addressFragment );
                    fragmentTransaction.addToBackStack( null );
                    fragmentTransaction.commit();

                }
            } );

        }

        public int getItemCount() {
            return arrayList2.size();
        }
    }
}