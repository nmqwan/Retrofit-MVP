package vn.com.winta.quan.retrofit_rest_mvp.Presenter.Login;

import android.content.Context;
import android.util.Log;

import vn.com.winta.quan.retrofit_rest_mvp.APIService.APIServiceIml;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Status;

/**
 * Created by QWAN on 07/03/2017.
 */

public class Login {
    String TAG="Login";
    APIServiceIml apiService;
    Context context;
    String user,pass;
    public Login(Context context,String usr,String pss) {
        this.context = context;
        this.apiService =new APIServiceIml();
        user=usr;
        pass=pss;
    }
    public Status loginPresenter(){
        final Status[] s1 = {new Status()};
        apiService.login(new LoginImp() {
            @Override
            public void Success(Status s) {
                s1[0] =s;
                Log.e(TAG, "Success: "+s1[0].status );
            }
        },user,pass);
        Log.e(TAG, "loginPresenter: "+s1[0].status );
        return s1[0];
    }
}
