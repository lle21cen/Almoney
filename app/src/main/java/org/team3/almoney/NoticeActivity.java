package org.team3.almoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;


public class NoticeActivity extends AppCompatActivity implements View.OnClickListener {

    KakaoLink kakaoLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Intent intent = getIntent();
        String money = intent.getStringExtra("money");

        TextView wonView = findViewById(R.id.notice_won_alarimy);
        wonView.setText(money + "원 알리기");

        try {
            kakaoLink = KakaoLink.getKakaoLink(NoticeActivity.this);
        } catch (KakaoParameterException e) {
            e.printStackTrace();
        }

        Button kakaoButton = findViewById(R.id.kakao_btn);
        kakaoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.kakao_btn:

                final KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder
                        = kakaoLink.createKakaoTalkLinkMessageBuilder();
                try {
                    kakaoTalkLinkMessageBuilder.addText("다운받아사용해보세요");
                } catch (KakaoParameterException e) {
                    e.printStackTrace();
                }
                try {
                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder, this);// 메시지 전송
                } catch (KakaoParameterException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
