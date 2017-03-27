package vn.com.winta.quan.retrofit_rest_mvp.Presenter.PostData;

import java.util.ArrayList;

import vn.com.winta.quan.retrofit_rest_mvp.Model.Item;

/**
 * Created by QWAN on 07/03/2017.
 */

public interface PostDataIml {
    void onFetchSuccess(ArrayList<Item> list);
    void onFetchFault(Exception e);
}
