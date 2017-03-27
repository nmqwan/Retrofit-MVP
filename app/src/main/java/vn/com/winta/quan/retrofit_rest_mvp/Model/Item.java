package vn.com.winta.quan.retrofit_rest_mvp.Model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by QWAN on 07/03/2017.
 */

public class Item {
    @SerializedName("id_product")
    public String id_product;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("decription")
    public String decription;
    @SerializedName("price")
    public String price;
    @SerializedName("thumnail")
    public String thumnail;

    private static Item getItem (JSONObject jsonObject){
        return new Gson().fromJson(jsonObject.toString(),Item.class);
    }

    public  static ArrayList<Item> getAllProduct(JSONArray jsonArray) throws JSONException {
        ArrayList<Item> arrayList = new ArrayList<>();
        for(int i = 0; i<jsonArray.length(); i++) {
            arrayList.add(getItem(jsonArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
