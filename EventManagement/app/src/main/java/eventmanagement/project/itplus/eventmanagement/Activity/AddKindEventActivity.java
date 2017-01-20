package eventmanagement.project.itplus.eventmanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import eventmanagement.project.itplus.eventmanagement.Adapter.KindEventAdapter;
import eventmanagement.project.itplus.eventmanagement.Config;
import eventmanagement.project.itplus.eventmanagement.Data.EventDbHelper;
import eventmanagement.project.itplus.eventmanagement.Inteface.EventClickListener;
import eventmanagement.project.itplus.eventmanagement.Model.Category;
import eventmanagement.project.itplus.eventmanagement.R;
import eventmanagement.project.itplus.eventmanagement.Request.GetCategory;
import eventmanagement.project.itplus.eventmanagement.VolleySingleton;

public class AddKindEventActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Category> arrayList;
    private KindEventAdapter kindEventAdapter;
    private EventDbHelper mEventDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kind_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAddKind);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEventDbHelper = new EventDbHelper(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        arrayList = new ArrayList<>();
//        getListCategory();
        if(mEventDbHelper.checkEmptyCategory()){
            getListCategory();
            Log.e("empty","true");
        } else {
            mEventDbHelper.addCategoryToArraylist(arrayList);
            kindEventAdapter = new KindEventAdapter(arrayList, getApplicationContext(), new EventClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(getApplicationContext(), AddEventActivity.class);
                    intent.putExtra(Config.CATEGORY_ID, arrayList.get(position).getCategoryID());
                    startActivity(intent);
                }

                @Override
                public void onPopupMenuItemClick(View view, int position) {

                }
            });
            recyclerView.setAdapter(kindEventAdapter);
            Log.e("empty","false");
        }




    }

    private void getListCategory() {
        RequestQueue requestQueue = VolleySingleton.getmInstance(getApplicationContext()).getmRequestQueue();
        GetCategory getCategory = new GetCategory(requestQueue);
        getCategory.getAllCategory(new GetCategory.CategoryInteface() {
            @Override
            public void onSuccess(final ArrayList<Category> categories) {


                for (int i = 0; i < categories.size(); i++) {
                    mEventDbHelper.insertCategory(categories.get(i));
                }

                mEventDbHelper.addCategoryToArraylist(arrayList);
                kindEventAdapter = new KindEventAdapter(arrayList, getApplicationContext(), new EventClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), AddEventActivity.class);
                        intent.putExtra(Config.CATEGORY_ID, arrayList.get(position).getCategoryID());
                        startActivity(intent);
                    }

                    @Override
                    public void onPopupMenuItemClick(View view, int position) {

                    }
                });
                recyclerView.setAdapter(kindEventAdapter);
            }

            @Override
            public void onError(String message) {

            }
        });
    }

}
