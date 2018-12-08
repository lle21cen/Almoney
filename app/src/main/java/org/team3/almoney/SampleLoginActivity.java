package org.team3.almoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kakao.kakaolink.KakaoLink;

import org.team3.almoney.R;

public class SampleLoginActivity extends AppCompatActivity {

    private KakaoLink kakaoLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_login);
    }
}
