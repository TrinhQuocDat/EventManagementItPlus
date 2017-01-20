package eventmanagement.project.itplus.eventmanagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import eventmanagement.project.itplus.eventmanagement.R;
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.ioexample_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {//button back
                onBackPressed();
            }
        });

        TextView txtTitle = (TextView) findViewById(R.id.detailTitle);
        txtTitle.setText("Test title");
    }

}
