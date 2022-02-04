package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class DataManager {

    public static final String ROOT_URL = "https://hardhin.com/api/user/";
    public static final String CATEGORY_URL = "https://azs4s.com/agribiz/uploaded_files/categories/";
    public static final String PRODUCT_URL = "https://azs4s.com/agribiz/uploaded_files/products/images/";
    public static final String PAY_URL = "http://128.199.28.150:8080/";
    public static final String PLAN_IMAGE_URL = "http://128.199.28.150:8080/images/memberplanimages/";

    private static DataManager dataManager;
    private Retrofit retrofit;

    private DataManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel( HttpLoggingInterceptor.Level.BODY );

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.callTimeout( 1, TimeUnit.MINUTES );
        httpClient.readTimeout( 1, TimeUnit.MINUTES );

        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor( logging );

        // <-- this is the important line!
        // httpClient.callTimeout(30, TimeUnit.SECONDS);
        // connect timeout
        //httpClient.readTimeout(30, TimeUnit.SECONDS);
        // socket timeout


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl( ROOT_URL )
                .addConverterFactory( GsonConverterFactory.create( gson ) )
                .client( httpClient.build() )
                .build();


    }

    public static DataManager getDataManager() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }


    public void userlogin(Callback<Model> cb, String username, String password, String identity) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.userlogin( username, password, identity );
        call.enqueue( cb );
    }

    public void registeruser(Callback<Model> cb, String name, String mobile, String address,
                             String identity, String typemasterinfo, String password) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.registeruser( name, mobile, address, identity, typemasterinfo, password );
        call.enqueue( cb );
    }

    public void verifyotp(Callback<Model> cb, String otp) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.verifyotp( otp );
        call.enqueue( cb );
    }

    public void forgotpassword(Callback<Model> cb, String mobile) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.forgotpassword( mobile );
        call.enqueue( cb );
    }

    public void displayallcategories(Callback<Model> cb, String user_masterid, String Token, String type) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.displayallcategories( user_masterid, Token, type );
        call.enqueue( cb );
    }

    public void subcategories_by_category(Callback<Model> cb, String category_id, String type) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.subcategories_by_category( category_id, type );
        call.enqueue( cb );
    }

    public void displayproductsbycategoryid(Callback<Model> cb, String user_masterid, String Token, String type, String categoryid, String identity) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.displayproductsbycategoryid( user_masterid, Token, type, categoryid, identity );
        call.enqueue( cb );
    }

    public void changepassword(Callback<Model> cb, String user_masterid, String Token, String oldpassword, String password) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.changepassword( user_masterid, Token, oldpassword, password );
        call.enqueue( cb );
    }

    public void updateprofile(Callback<Model> cb, String user_masterid,String Token,String name,String email,String imagename, String image) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.updateprofile( user_masterid,Token,name,email,imagename,image );
        call.enqueue( cb );
    }

    public void findalladdressesbyuserid(Callback<Model> cb, String user_masterid,String Token) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.findalladdressesbyuserid( user_masterid,Token );
        call.enqueue( cb );
    }

    public void addnewaddress(Callback<Model> cb, String user_masterid,String Token,String name,String mobile,String email,String address
            ,String landmark,String city,String district,String pincode) {
        API apiService;
        apiService = retrofit.create( API.class );
        Call<Model> call = apiService.addnewaddress( user_masterid,Token,name,mobile,email,address,landmark,city,district,pincode);
        call.enqueue( cb );
    }

}
