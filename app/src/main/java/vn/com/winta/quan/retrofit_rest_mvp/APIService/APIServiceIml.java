package vn.com.winta.quan.retrofit_rest_mvp.APIService;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Item;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Status;
import vn.com.winta.quan.retrofit_rest_mvp.Presenter.Login.LoginImp;
import vn.com.winta.quan.retrofit_rest_mvp.Presenter.PostData.PostDataIml;

/**
 * Created by QWAN on 07/03/2017.
 */

public class APIServiceIml {
    String TAG= APIServiceIml.class.getSimpleName();
    APIService apiService;

    public APIServiceIml() {
        apiService=APIService.retrofit.create(APIService.class);;
    }

    public void getAllItem (final PostDataIml dataIml, String... a){
        Call<ArrayList<Item>> call= apiService.postListItem(a[0],a[1],a[2]);
        call.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                dataIml.onFetchSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                dataIml.onFetchFault(new Exception("LOi"));
            }
        });
    }
    public void login (final LoginImp loginImp, String User, String Pass){
        Call<Status> call= apiService.login(User,Pass);
        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                loginImp.Success(response.body());
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString() );
            }
        });
    }
}
