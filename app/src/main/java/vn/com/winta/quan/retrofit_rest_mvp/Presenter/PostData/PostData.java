package vn.com.winta.quan.retrofit_rest_mvp.Presenter.PostData;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import vn.com.winta.quan.retrofit_rest_mvp.APIService.APIServiceIml;
import vn.com.winta.quan.retrofit_rest_mvp.Model.Item;

/**
 * Created by QWAN on 07/03/2017.
 */

public class PostData  {
    String TAG = PostData.class.getSimpleName();
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item> productsList;
    APIServiceIml apiServiceIml;

    public PostData(Context context) {
        apiServiceIml = new APIServiceIml();
        layoutManager = new GridLayoutManager(context,2);
        productsList = new ArrayList<>();
    }

    /**
     * parse data
     * Noti adapter
     * */
    public void fetchData() {
        //Call method getAllProduct in API
        Log.e(TAG, "fetchData: " );
        apiServiceIml.getAllItem(new PostDataIml() {
            @Override
            public void onFetchSuccess(ArrayList<Item> list) {
                Log.e(TAG, "onFetchSuccess: "+list.size());
            }

            @Override
            public void onFetchFault(Exception e) {

            }
        },"123","321","456");
    }
}
