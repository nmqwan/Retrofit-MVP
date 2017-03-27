package vn.com.winta.quan.retrofit_rest_mvp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Status;
import vn.com.winta.quan.retrofit_rest_mvp.Presenter.Login.Login;
import vn.com.winta.quan.retrofit_rest_mvp.Presenter.PostData.PostData;

public class MainActivity extends AppCompatActivity {
    String TAG=MainActivity.class.getSimpleName();
    @BindView(R.id.txtuser)
    TextInputEditText txtuser;
    @BindView(R.id.txtpass)
    TextInputEditText txtpass;
    @BindView(R.id.btnlogin)
    AppCompatButton btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PostData p = new PostData(this);

        p.fetchData();
    }

    @OnClick(R.id.btnlogin)
    public void onClick() {
        Login l = new Login(this,txtuser.getText().toString(),txtpass.getText().toString());
        Status s=l.loginPresenter();
        Log.e(TAG, "onClick: s"+ s.status );
    }
}
