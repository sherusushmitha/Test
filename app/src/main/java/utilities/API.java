package utilities;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {


    // User Registration


    @FormUrlEncoded
    @POST("userlogin")
    Call<Model> userlogin(@Field("mobile") String mobile,
                          @Field("password") String password,
                          @Field("identity") String identity);

    @FormUrlEncoded
    @POST("registeruser")
    Call<Model> registeruser(@Field("name") String name,
                             @Field("mobile") String email,
                             @Field("address") String address,
                             @Field("identity") String identity,
                             @Field("typemasterinfo") String typemasterinfo,
                             @Field("password") String password);

    @FormUrlEncoded
    @POST("verifyotp")
    Call<Model> verifyotp(@Field("otp") String otp);

    @FormUrlEncoded
    @POST("forgotpassword")
    Call<Model> forgotpassword(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("displayallcategories")
    Call<Model> displayallcategories(@Field("user_masterid") String user_masterid,
                                     @Field("Token") String Token,
                                     @Field("type") String type);

    @FormUrlEncoded
    @POST("subcategories_by_category")
    Call<Model> subcategories_by_category(@Field("category_id") String category_id,
                                          @Field("type") String type);

    @FormUrlEncoded
    @POST("displayproductsbycategoryid")
    Call<Model> displayproductsbycategoryid(@Field("user_masterid") String user_masterid,
                                            @Field("Token") String Token,
                                            @Field("type") String type,
                                            @Field("categoryid") String categoryid,
                                            @Field("identity") String identity);

    @FormUrlEncoded
    @POST("changepassword")
    Call<Model> changepassword(@Field("user_masterid") String user_masterid,
                               @Field("Token") String Token,
                               @Field("oldpassword") String oldpassword,
                               @Field("password") String password);
    @FormUrlEncoded
    @POST("updateprofile")
    Call<Model> updateprofile(@Field("user_masterid") String user_masterid,
                               @Field("Token") String Token,
                               @Field("name") String name,
                               @Field("email") String email,
                              @Field( "imagename" ) String imagename,
                              @Field("image") String image);
    @FormUrlEncoded
    @POST("findalladdressesbyuserid")
    Call<Model> findalladdressesbyuserid(@Field("user_masterid") String user_masterid,
                              @Field("Token") String Token);

    @FormUrlEncoded
    @POST("addnewaddress")
    Call<Model> addnewaddress(@Field("user_masterid") String user_masterid,
                              @Field("Token") String Token,
                              @Field("name") String name,
                              @Field("mobile") String mobile,
                              @Field("email") String email,
                              @Field("address") String address,
                              @Field("landmark") String landmark,
                              @Field("city") String city,
                              @Field("district") String district,
                              @Field("pincode") String pincode);

}

