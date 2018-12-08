package org.team3.almoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListViewAdapter extends BaseAdapter {

    ArrayList<ContactItem> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contact_list_item, parent, false);
        }

        TextView nameView = convertView.findViewById(R.id.contact_item_name);
        TextView phoneNumView = convertView.findViewById(R.id.contact_item_number);

        ContactItem item = items.get(pos);

        nameView.setText(item.getName());
        phoneNumView.setText(item.getPhoneNumber());

        return convertView;
    }

    public void addItem (String name, String phoneNum) {
        items.add(new ContactItem(name, phoneNum));
    }
}
