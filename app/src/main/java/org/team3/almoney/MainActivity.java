package org.team3.almoney;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView bankText;
    EditText accountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bankText = findViewById(R.id.main_bank_text);
        bankText.setOnClickListener(this);
        accountText = findViewById(R.id.main_account_text);


        Button confirmButton = findViewById(R.id.main_confirm_btn);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bank_text :
                BankDialog dialog = new BankDialog(MainActivity.this);
                dialog.show();
                break;
            case R.id.main_confirm_btn :
                ConfirmDialog confirmDialog = new ConfirmDialog(this);
                confirmDialog.show();
                break;

        }
    }

    class BankDialog extends Dialog implements View.OnClickListener{

        public BankDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_bank_choice_dialog);
//            setCancelable(false);

            WindowManager.LayoutParams params = this.getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            this.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

            TextView nh = findViewById(R.id.bank_nh);
            TextView woori = findViewById(R.id.bank_woori);
            TextView shinhan = findViewById(R.id.bank_shinhan);

            nh.setOnClickListener(this);
            woori.setOnClickListener(this);
            shinhan.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            bankText.setText(((TextView)v).getText());
            dismiss();
        }
    }

    class ConfirmDialog extends Dialog {

        public ConfirmDialog(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_confirm_dialog);

            setCancelable(false);
            setCanceledOnTouchOutside(false);
            Button confirm = findViewById(R.id.main_confirm_dialog_btn);
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, UsingServiceActivity.class);
                    startActivity(intent);
                    dismiss();
                }
            });
        }
    }

}
