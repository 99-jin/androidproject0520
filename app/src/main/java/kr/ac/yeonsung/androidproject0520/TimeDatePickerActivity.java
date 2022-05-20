package kr.ac.yeonsung.androidproject0520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimeDatePickerActivity extends AppCompatActivity {
    TextView texttime, textdate;
    TimePicker timePick;
    DatePicker datePick;
    int selectedyear, selectedmonth, selectedday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_date_picker);
        texttime = findViewById(R.id.texttime);
        textdate = findViewById(R.id.text_date);
        timePick = findViewById(R.id.time_pick);
        datePick = findViewById(R.id.date_pick);
        datePick.setOnDateChangedListener(dateListener);

        Button btn = findViewById(R.id.btndate);
        btn.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            textdate.setText(selectedyear + "년 " + (selectedmonth + 1) + "월 " + selectedday + "일");
            texttime.setText(timePick.getCurrentHour() + "시 " + timePick.getCurrentMinute() + "분");
        }
    };
    DatePicker.OnDateChangedListener dateListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
            selectedyear = year;
            selectedmonth = month;
            selectedday = day;
        }
    };
}