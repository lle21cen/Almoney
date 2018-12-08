package org.team3.almoney;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class SetAlarmActivity extends AppCompatActivity implements View.OnClickListener {

    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    Calendar calendar;
    private int sel_year, sel_month, sel_day, sel_hour, sel_minute;
    TextView dateText, periodText;
    LinearLayout periodLayout;

    EditText moneyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        periodLayout = findViewById(R.id.period_layout);
        periodLayout.setOnClickListener(this);

        moneyView = findViewById(R.id.set_alarm_money);
        calendar = new GregorianCalendar(Locale.KOREA);
        RelativeLayout dayLayout = findViewById(R.id.set_alarm_start_day_layout);
        RelativeLayout periodLayout = findViewById(R.id.set_alarm_period_layout);
        dayLayout.setOnClickListener(this);
        periodLayout.setOnClickListener(this);

        dateText = findViewById(R.id.set_alarm_start_day);
        periodText = findViewById(R.id.set_alarm_period_text);

        TextView one = findViewById(R.id.period_1);
        TextView two = findViewById(R.id.period_2);
        TextView three = findViewById(R.id.period_3);
        TextView four = findViewById(R.id.period_4);
        TextView five = findViewById(R.id.period_5);
        TextView six = findViewById(R.id.period_6);
        TextView seven = findViewById(R.id.period_7);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);

        Button confirmBtn = findViewById(R.id.set_alarm_confirm_btn);
        confirmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_alarm_start_day_layout:
                showDialog(DIALOG_DATE);
                break;
            case R.id.set_alarm_period_layout:
                if (periodLayout.getVisibility() == View.VISIBLE) {
                    periodLayout.setVisibility(View.GONE);
                } else {
                    periodLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.period_1:
                setPeriodText(1);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_2:
                setPeriodText(2);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_3:
                setPeriodText(3);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_4:
                setPeriodText(4);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_5:
                setPeriodText(5);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_6:
                setPeriodText(6);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.period_7:
                setPeriodText(7);
                periodText.setTextColor(Color.RED);
                periodLayout.setVisibility(View.GONE);
                break;
            case R.id.set_alarm_confirm_btn :
                Intent intent = new Intent(SetAlarmActivity.this, NoticeActivity.class);
                intent.putExtra("money", moneyView.getText().toString());
                startActivity(intent);
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DATE:
                DatePickerDialog dpd = new DatePickerDialog(SetAlarmActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                sel_year = year;
                                sel_month = month;
                                sel_day = dayOfMonth;
                                showDialog(DIALOG_TIME);
                            }
                        }, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DAY_OF_MONTH));
                return dpd;
            case DIALOG_TIME:
                TimePickerDialog tpd =
                        new TimePickerDialog(SetAlarmActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        sel_hour = hourOfDay;
                                        sel_minute = minute;
                                        if (sel_hour > 12) {
                                            dateText.setText(sel_year + "." + sel_month + "." + sel_day + " 오후 " + (sel_hour - 12) + ":" + sel_minute);
                                        } else {
                                            dateText.setText(sel_year + "." + sel_month + "." + sel_day + " 오전 " + sel_hour + ":" + sel_minute);
                                        }
                                        dateText.setTextColor(Color.RED);
                                    }
                                },
                                4, 19, false);
                return tpd;
        }
        return super.onCreateDialog(id);
    }

    protected void setPeriodText(int period) {
        periodText.setText(period + "일");
    }
}
