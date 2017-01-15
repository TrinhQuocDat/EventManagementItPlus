package eventmanagement.project.itplus.eventmanagement.Request;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import eventmanagement.project.itplus.eventmanagement.Model.Category;

/**
 * Created by Dat UET on 1/15/2017.
 */

public class GetCategory {
    public interface CategoryInteface {
        void onSuccess(ArrayList<Category> categories);

        void onError(String message);
    }
    private RequestQueue requestQueue;
    private static final String URL =
            "http://datuet.esy.es/get_all_category.php";

    public GetCategory(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }
    public void getAllCategory(final CategoryInteface callback){
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<Category> categories = new ArrayList<>();
                if(response.length() > 0){
                    try {
                        JSONArray jsonArray = response.getJSONArray("category");
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int categoryID = Integer.parseInt(jsonObject.getString("categoryID"));
                            String name = jsonObject.getString("name");
                            String image = jsonObject.getString("image");
                            Category category = new Category();
                            category.setCategoryID(categoryID);
                            category.setName(name);
                            category.setImage(image);
                            categories.add(category);
                            Log.e("n",name);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    callback.onSuccess(categories);
                } else {
                    callback.onError("error");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError("error");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
