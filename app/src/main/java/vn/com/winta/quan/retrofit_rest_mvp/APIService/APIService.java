package vn.com.winta.quan.retrofit_rest_mvp.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import vn.com.winta.quan.retrofit_rest_mvp.Config;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Item;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Status;

/**
 * Created by QWAN on 07/03/2017.
 */

public interface APIService {
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl(Config.URL_PRODUCT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @FormUrlEncoded
    @POST("json")
    Call<ArrayList<Item>> postListItem(@Field("a") String a,
                                       @Field("b") String b,
                                       @Field("c") String c);

    @FormUrlEncoded
    @POST("login")
    Call<Status> login(@Field("user") String user,
                       @Field("pass") String pass);
}
