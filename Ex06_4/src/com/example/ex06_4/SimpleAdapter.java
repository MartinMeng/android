package com.example.ex06_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.widget.ListView;

public class SimpleAdapter extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);
        ListView listView = (ListView)findViewById(R.id.arrayList);
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null);
        startManagingCursor(cursor);
        List<Map<String, Object>> phoneList = new ArrayList<Map<String, Object>>();
        while (cursor.moveToNext()) {
            String phoneInfo = "";
            Map<String, Object> map = new HashMap<String, Object>();
            String name = cursor.getString(cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME));
            map.put("name", name);
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);
            while (phone.moveToNext()) {
                String phoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.
                        CommonDataKinds.Phone.NUMBER));
                phoneInfo += phoneNumber + '\n';
            }
            map.put("phone", phoneInfo);
            phone.close();
            phoneList.add(map);
        }
        cursor.close();
        SimpleAdapter listAdapter = new SimpleAdapter(this, phoneList, R.layout.list,
                new String[] {"name", "phone"}, new int[] { R.id.name, R.id.phone });
        listView.setAdapter(listAdapter);
    }
}
