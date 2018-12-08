package org.team3.almoney;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class UsingServiceActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_service);

        RelativeLayout alarimyLayout = findViewById(R.id.alarm_layout);
        alarimyLayout.setOnClickListener(this);
    }

    class AlrimyDialog extends Dialog {

        public AlrimyDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alarimy_dialog);

            Button yesBtn = findViewById(R.id.alarimy_yes);
            yesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UsingServiceActivity.this, ContactActivity.class);
                    startActivity(intent);
                }
            });
            Button noBtn = findViewById(R.id.alarimy_no);
            noBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alarm_layout :
                AlrimyDialog dialog = new AlrimyDialog(UsingServiceActivity.this);
                dialog.show();
                break;
        }
    }
}
