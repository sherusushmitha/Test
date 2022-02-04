package com.example.fashion.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.fashion.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.CategoriesList;
import utilities.DataManager;
import utilities.Model;

public class HomeFragment extends Fragment {
    ViewPager viewpager, viewPager1;
    RecyclerView recyclerview, recyclerView4;
    FragmentTransaction fragmentTransaction;
    TextView text4;
    private DrawerLayout mDrawerLayout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    String Token, id, type;
    ArrayList<Integer> list;
    ArrayList<Integer> list1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_home, container, false );
        setHasOptionsMenu( true );

        sharedPreferences = getActivity().getSharedPreferences( "Agribiz", Context.MODE_PRIVATE );
        Token = sharedPreferences.getString( "Token", null );
        id = sharedPreferences.getString( "id", null );
        type = sharedPreferences.getString( "type", null );

        System.out.println( "Token" + Token + "," + "id" + id + "," + "type" + type );

        serviceCategories( id, Token, type );

        text4 = root.findViewById( R.id.text4 );



//        TextView tv = null;
//
//        tv.setPaintFlags(tv.getPaintFlags()|
//                Paint.STRIKE_THRU_TEXT_FLAG);

        viewpager = root.findViewById( R.id.viewpager );
        viewpager.setClipToPadding( false );
        // viewpager.setPageMargin( 10 );
        //    viewpager.setPadding( 10, 10, 45, 10 );

        viewPager1 = root.findViewById( R.id.viewpager1 );
        viewPager1.setClipToPadding( false );
//        viewPager1.setPageMargin( 10 );
//        viewPager1.setPadding( 10, 10, 45, 10 );


        list = new ArrayList<>();
        list.add( R.drawable.bb1 );
        list.add( R.drawable.bb2 );
        list.add( R.drawable.bb3 );
        list.add( R.drawable.bb4 );
        list.add( R.drawable.bb9 );
        list.add( R.drawable.bb6 );
        list.add( R.drawable.bb7 );
        list.add( R.drawable.bb1 );
        list.add( R.drawable.bb3 );
        list.add( R.drawable.bb7 );

        SlidingImage_Adapter SlidingImage_Adapter = new SlidingImage_Adapter( getActivity(), list );
        viewpager.setAdapter( SlidingImage_Adapter );

        Timer timer = new Timer();
      timer.scheduleAtFixedRate(new SliderTimer(), 5000, 5000);
//
//        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(getActivity(), list);
//        viewpager.setAdapter(itemsPager_adapter);
//        my_tablayout.setupWithViewPager(viewpager,true);



        recyclerview = root.findViewById( R.id.recyclerview );
        ArrayList<grid_list> arrayList = new ArrayList<grid_list>();

//        arrayList.add( new grid_list( R.drawable.bbb1, "FUDGE BAR" ) );
//        arrayList.add( new grid_list( R.drawable.j1, "BERTOLLI" ) );
//        arrayList.add( new grid_list( R.drawable.grocery1, "String Cheese" ) );
//        arrayList.add( new grid_list( R.drawable.k1, "Agriculture Fruits" ) );
//        arrayList.add( new grid_list( R.drawable.grocery3, "Vegan Noodles" ) );
//        arrayList.add( new grid_list( R.drawable.grocery4, "Maggi" ) );
//        arrayList.add( new grid_list( R.drawable.n1, "Red Berries" ) );
//        arrayList.add( new grid_list( R.drawable.grocery6, "Apples" ) );
//        arrayList.add( new grid_list( R.drawable.grocery26, "Dragon fruits" ) );
//        arrayList.add( new grid_list( R.drawable.grocery25, "Dragon fruits" ) );
//        arrayList.add( new grid_list( R.drawable.grocery32, "Avocado" ) );
//        arrayList.add( new grid_list( R.drawable.m1, "White Stroberries" ) );
//        arrayList.add( new grid_list( R.drawable.grocery25, "Dragon fruits" ) );
//        arrayList.add( new grid_list( R.drawable.grocery7, "Honey" ) );
//        arrayList.add( new grid_list( R.drawable.grocery8, "Oranges" ) );
//        arrayList.add( new grid_list( R.drawable.grocery9, "Vegetables" ) );
//        arrayList.add( new grid_list( R.drawable.grocery10, "Dettol" ) );
//        arrayList.add( new grid_list( R.drawable.grocery24, "Orange" ) );
////        arrayList.add( new grid_list( R.drawable.l1, "carberry Chocolate" ) );
////        arrayList.add( new grid_list( R.drawable.grocery12, "Coca Cola" ) );
////        arrayList.add( new grid_list( R.drawable.grocery13, "Tata Lodized" ) );
////        arrayList.add( new grid_list( R.drawable.m1, "Carrot" ) );
////        arrayList.add( new grid_list( R.drawable.grocery15, "Beans" ) );
////        arrayList.add( new grid_list( R.drawable.grocery16, " Beans " ) );
////        arrayList.add( new grid_list( R.drawable.grocery25, "Dragon fruits" ) );
////        arrayList.add( new grid_list( R.drawable.grocery26, "Dragon fruits" ) );
////        arrayList.add( new grid_list( R.drawable.grocery19, "Chakki Fresh Atta" ) );
////        arrayList.add( new grid_list( R.drawable.grocery20, "Biscuits" ) );
////        arrayList.add( new grid_list( R.drawable.b1, "Pastha" ) );
////        arrayList.add( new grid_list( R.drawable.grocery22, "Cakes" ) );
////        arrayList.add( new grid_list( R.drawable.c1, "Vegetables" ) );
////        arrayList.add( new grid_list( R.drawable.grocery24, "Orange" ) );
////        arrayList.add( new grid_list( R.drawable.grocery25, "Dragon fruits" ) );
////        arrayList.add( new grid_list( R.drawable.grocery26, "Dragon fruits" ) );
////        arrayList.add( new grid_list( R.drawable.d1, "Rambutan fruits" ) );
////        arrayList.add( new grid_list( R.drawable.e1, "Rambutan fruits" ) );


        GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 3 );
        recyclerview.setLayoutManager( gridLayoutManager );



        list1 = new ArrayList<>();
        list1.add( R.drawable.bb10 );
        list1.add( R.drawable.bb11 );
        list1.add( R.drawable.bb1 );
        list1.add( R.drawable.bb2 );
        list1.add( R.drawable.bb3 );
        list1.add( R.drawable.bb4 );
        list1.add( R.drawable.bb6 );
        list1.add( R.drawable.bb7 );
        list1.add( R.drawable.bb8 );
        list1.add( R.drawable.bb7 );

        SlidingImage_Adapter1 SlidingImage_Adapter1 = new SlidingImage_Adapter1( getActivity(), list1 );
        viewPager1.setAdapter( SlidingImage_Adapter1 );

        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new SliderTimer1(), 5000, 5000);

        recyclerView4 = root.findViewById( R.id.recyclerview4 );
        ArrayList<row2_design> arrayList1 = new ArrayList<row2_design>();

        arrayList1.add( new row2_design( R.drawable.bbb8, "Coco cola", "summer drink" ) );
        arrayList1.add( new row2_design( R.drawable.bbb4, "Beans", "Agriculture farming" ) );
        arrayList1.add( new row2_design( R.drawable.bbb3, "Beans", "Agriculture farming" ) );
        arrayList1.add( new row2_design( R.drawable.bbb5, "Fresh atta", "natural food" ) );
        arrayList1.add( new row2_design( R.drawable.bbb7, "Toll House", "Nestle" ) );
        arrayList1.add( new row2_design( R.drawable.bbb6, "Dragon fruit", "Agriculture Farming" ) );


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.HORIZONTAL, false );
        recyclerView4.setLayoutManager( linearLayoutManager );

        Adapter1 adapter1 = new Adapter1( arrayList1 );
        recyclerView4.setAdapter( adapter1 );


        return root;
    }

    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewpager.getCurrentItem() < list.size() - 1) {
                            viewpager.setCurrentItem(viewpager.getCurrentItem() + 1, true);
                        } else {
                            viewpager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }
//3



    private class SliderTimer1 extends TimerTask {
        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager1.getCurrentItem() < list1.size() - 1) {
                            viewPager1.setCurrentItem(viewPager1.getCurrentItem() + 1, true);
                        } else {
                            viewPager1.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }


        //

//    public class The_Slide_items_Pager_Adapter extends PagerAdapter {
//
//        private Context Mcontext;
//        private List theSlideItemsModelClassList;
//
//        public The_Slide_items_Pager_Adapter(Context Mcontext, List theSlideItemsModelClassList) {
//            this.Mcontext = Mcontext;
//            this.theSlideItemsModelClassList = theSlideItemsModelClassList;
//        }
//
//        @NonNull
//        @Override
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//            LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View sliderLayout = inflater.inflate(R.layout.row_product_horizontal,null);
////
////            ImageView featured_image = sliderLayout.findViewById(R.id.Imageview);
////
////            featured_image.setImageResource(theSlideItemsModelClassList.get(position).getFeatured_image());
//            container.addView(sliderLayout);
//            return sliderLayout;
//        }
//
//        @Override
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            container.removeView((View)object);
//        }
//
//        @Override
//        public int getCount() {
//            return theSlideItemsModelClassList.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//            return view == o;
//        }
//    }
//




    //


    public class SlidingImage_Adapter extends PagerAdapter {
        private ArrayList<Integer> IMAGES;
        private LayoutInflater inflater;
        private Context context;


        public SlidingImage_Adapter(Context context, ArrayList<Integer> IMAGES) {
            this.context = context;
            this.IMAGES = IMAGES;
            inflater = LayoutInflater.from( context );
        }

        public SlidingImage_Adapter(HomeFragment homeFragment, ArrayList<Integer> list) {
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }

        @Override
        public int getCount() {
            return IMAGES.size();
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View imageLayout = inflater.inflate( R.layout.row_design, view, false );

            assert imageLayout != null;
            final ImageView imageView = (ImageView) imageLayout
                    .findViewById( R.id.Imageview );
            imageView.setImageResource( IMAGES.get( position ) );

            view.addView( imageLayout, 0 );

            return imageLayout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals( object );
        }
    }
//2222

    class Adapter extends RecyclerView.Adapter<HomeFragment.Adapter.MyViewHolder> {
        private ArrayList<CategoriesList> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text;
            ImageView image;

            public MyViewHolder(View item) {
                super( item );
                image = item.findViewById( R.id.image );
                text = item.findViewById( R.id.text );

            }

        }


        public Adapter(ArrayList<CategoriesList> arrayList1) {
            this.arrayList2 = arrayList1;
        }

        @Override
        public HomeFragment.Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.grid_view_design, parent, false );
            return new HomeFragment.Adapter.MyViewHolder( itemView );

        }

        @Override
        public void onBindViewHolder(HomeFragment.Adapter.MyViewHolder holder, int position) {

            //action perform and data set
           // holder.image.setImageResource( arrayList2.get( position ).getCategory_image() );
            Glide.with(getActivity())
                    .load(DataManager.CATEGORY_URL+arrayList2.get(position).getCategory_image())
                    .into(holder.image);

            holder.text.setText( arrayList2.get( position ).getName() );


            holder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle=new Bundle();
                    bundle.putString( "category_id",arrayList2.get( position ).getId() );

                    ProductFragment productFragment = new ProductFragment();
                    productFragment.setArguments( bundle );
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, productFragment );
                    fragmentTransaction.addToBackStack( null );
                    fragmentTransaction.commit();

                }
            } );

        }

        @Override

        public int getItemCount() {
            return arrayList2.size();
        }
//44


    }

    //4
    public class SlidingImage_Adapter1 extends PagerAdapter {
        private ArrayList<Integer> IMAGES;
        private LayoutInflater inflater;
        private Context context;


        public SlidingImage_Adapter1(Context context, ArrayList<Integer> IMAGES) {
            this.context = context;
            this.IMAGES = IMAGES;
            inflater = LayoutInflater.from( context );
        }

        public SlidingImage_Adapter1(HomeFragment homeFragment, ArrayList<Integer> list) {
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }

        @Override
        public int getCount() {
            return IMAGES.size();
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View imageLayout = inflater.inflate( R.layout.row1_design, view, false );

            assert imageLayout != null;
            final ImageView imageView = (ImageView) imageLayout
                    .findViewById( R.id.Imageview );
            imageView.setImageResource( IMAGES.get( position ) );

            view.addView( imageLayout, 0 );

            return imageLayout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals( object );


        }

    }

    //5
    class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {
        private ArrayList<row2_design> arrayList2;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public Object category_image;
            TextView text, text1, decre, count, incre;
            ImageView image;

            public MyViewHolder(View item) {
                super( item );
                image = item.findViewById( R.id.image );
                text = item.findViewById( R.id.text );
                text1 = item.findViewById( R.id.text1 );
                decre = item.findViewById( R.id.minus );
                count = item.findViewById( R.id.count );
                incre = item.findViewById( R.id.plus );
            }

        }


        public Adapter1(ArrayList<row2_design> arrayList1) {
            this.arrayList2 = arrayList1;
        }

        @Override
        public Adapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
            View itemView = inflater.inflate( R.layout.row2_design, parent, false );
            return new Adapter1.MyViewHolder( itemView );

        }

        @Override
        public void onBindViewHolder(Adapter1.MyViewHolder holder, int position) {

            //action perform and data set
            holder.image.setImageResource( arrayList2.get( position ).getImage() );
            holder.text.setText( arrayList2.get( position ).getText() );
            holder.text1.setText( arrayList2.get( position ).getText1() );

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


    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu( menu );
        MenuItem item = menu.findItem( R.id.cart );
        if (item != null) {
            item.setVisible( false );
        }
    }


    private void serviceCategories(String id, String token, String type) {

        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.displayallcategories( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();

                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getActivity(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {

                            if(model.getCategorieslist()!=null&&model.getCategorieslist().size()>0){
                                HomeFragment.Adapter adapter = new HomeFragment.Adapter( model.getCategorieslist() );
                                recyclerview.setAdapter( adapter );

                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getActivity(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, id, token, type );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

