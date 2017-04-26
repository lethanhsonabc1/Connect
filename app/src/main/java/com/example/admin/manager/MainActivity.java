package com.example.admin.manager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATA_BAYSE_NAME="SQLite_Demo.sqlite";
    SQLiteDatabase database ;
    ListView listView;
    ArrayList<Nhanvien> list;
    AdapterNhanvien adapterNhanvien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //database= Database.initDatabase(this,DATA_BAYSE_NAME);
       // Cursor cursor= database.rawQuery("SELECT * FROM tbNhanvien",null);
       // cursor.moveToFirst();
        //Toast.makeText(this,cursor.getString(1),Toast.LENGTH_SHORT).show();
        addControl();
        readData();
    }

    private void addControl() {
        listView =(ListView)findViewById(R.id.listView);
        list= new ArrayList<>();
        adapterNhanvien= new AdapterNhanvien(this,list);
        listView.setAdapter(adapterNhanvien);
    }
    private  void readData(){
        database= Database.initDatabase(this,DATA_BAYSE_NAME);
        Cursor cursor= database.rawQuery("SELECT * FROM tbNhanvien",null);
        list.clear();
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            int id=cursor.getInt(0);
            String ten=cursor.getString(1);
            String sdt =cursor.getString(2);
            byte[] anh = cursor.getBlob(3);
            list.add(new Nhanvien(id,ten,sdt,anh));

        }
        adapterNhanvien.notifyDataSetChanged();
    }
}
