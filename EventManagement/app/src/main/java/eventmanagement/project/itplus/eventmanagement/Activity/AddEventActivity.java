package eventmanagement.project.itplus.eventmanagement.Activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import eventmanagement.project.itplus.eventmanagement.R;

public class AddEventActivity extends AppCompatActivity {

    TextView txtViewTime;
    EditText edAddNameEvent,edAddDesEvent;
    Button btnTimePick,btnDatePick,btnAdd;
    Spinner spinnerKind;
    String arr[] = {
            "Chọn 1 thể loại",
            "Thể thao",
            "Giải trí",
            "Phượt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        prepare();
        spinnerPick();
        dateAndTimeButtonClick();


    }



    private void prepare() {
        spinnerKind = (Spinner) findViewById(R.id.spinnerKind);
        edAddNameEvent = (EditText) findViewById(R.id.edAddNameEvent);
        edAddDesEvent = (EditText) findViewById(R.id.edAddDesEvent);
        btnDatePick = (Button) findViewById(R.id.btnDatePicker);
        btnTimePick = (Button) findViewById(R.id.btnTimePicker);
        txtViewTime = (TextView) findViewById(R.id.txtViewTime);

    }


    private void dateAndTimeButtonClick() {
        btnTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void spinnerPick() {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spinnerKind.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spinnerKind.setOnItemSelectedListener(new MyProcessEvent());
    }


    //Class tạo sự kiện spinner
    private class MyProcessEvent implements
            AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(i > 0)
            {
                //lấy ra danh mục arr[i]
                edAddDesEvent.setText(arr[i].toString());

            }
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {

            //Toast.makeText()
        }
    }
}

