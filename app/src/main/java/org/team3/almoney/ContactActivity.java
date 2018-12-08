package org.team3.almoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ContactActivity extends AppCompatActivity {

    ContactListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView listView = findViewById(R.id.contact_list_view);

        adapter = new ContactListViewAdapter();
        adapter.addItem("구지훈", "010-5611-5297");
        adapter.addItem("김재은", "010-8996-5403");
        adapter.addItem("이동완", "010-0000-0000");
        adapter.addItem("문지혜", "010-0000-0000");
        adapter.addItem("차세아", "010-0000-0000");
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContactActivity.this, SetAlarmActivity.class);
                String name =  ((ContactItem)adapter.getItem(position)).getName();
                String phoneNum =  ((ContactItem)adapter.getItem(position)).getPhoneNumber();
                intent.putExtra("name", name);
                intent.putExtra("phoneNum", phoneNum);
                startActivity(intent);
            }
        });
    }
}
