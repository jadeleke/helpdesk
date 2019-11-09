package co.obware.hashcode.api;


import co.obware.hashcode.MVP.ComplaintType;
import co.obware.hashcode.MVP.LoginType;
import co.obware.hashcode.MVP.RegisterType;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/loginMobile")
    Call<LoginType> getLoginType(
            @Field("indexNumber") String index,
            @Field("password") String password
    );
//    @FormUrlEncoded
//    @POST("/signup.php")
//    Call<RegisterType> getCustomerType();

//    @FormUrlEncoded
//    @POST("registerMobile")
//    Call<RegisterType> getRegister(
//            @Field("name") String username,
//            @Field("indexNumber") String index,
//            @Field("number") String number,
//            @Field("email") String email,
//            @Field("password") String password,
//            @Field("gender") String gender
//            );

    @FormUrlEncoded
    @POST("auth/registerMobile")
    Call<RegisterType> getRegister(
            @Field("indexNumber") String index,
            @Field("gender") String gender,
            @Field("phone") String number,
            @Field("email") String email,
            @Field("name") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("v1/complaint")
    Call<ComplaintType> getComplaint(
            @Field("indexNumber") String index,
            @Field("cat_id") String strSpinner,
            @Field("description") String Description
    );

    @GET("v1/category")
    Call<String> getCategoryType();

//    @FormUrlEncoded
//    @POST("lo")
//    Call<ProviderType> getProviderType(
//            @Field("company") String company,
//            @Field("fullname") String fullname,
//            @Field("username") String username,
//            @Field("number") String number,
//            @Field("email") String email,
//            @Field("primary") String primary,
//            @Field("secondary") String secondary,
//            @Field("password") String password,
//            @Field("hash") String hash
//    );
//
//    @GET("files/locator.php")
//    Call<List<RequestType>> getRequestType();
//
////    @GET("files/Primary.php")
////    Call<String> getCategoryType();
//
//    @GET("json_parsing.php")
//    Call<String> getCategoryType();
}
