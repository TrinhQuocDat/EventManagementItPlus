package eventmanagement.project.itplus.eventmanagement;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Dat UET on 1/15/2017.
 */

public class VolleySingleton {
    private static VolleySingleton mInstance = null ;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleySingleton(Context context) {
        mContext = context;
        mRequestQueue = getmRequestQueue();
    }

    public static synchronized VolleySingleton getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getmRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }
}
