package com.example.admin.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 4/25/2017.
 */

public class AdapterNhanvien extends BaseAdapter {
    Context context;
    ArrayList<Nhanvien> list;

    public AdapterNhanvien(Context context, ArrayList<Nhanvien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.activity_listview,null);
        ImageView imgView =(ImageView) row.findViewById(R.id.imgHinhDaiDien);
        TextView Ten =(TextView)row.findViewById(R.id.txtTen);
        TextView sdt =(TextView)row.findViewById(R.id.txtSDT);
        Button btnSua = (Button) row.findViewById(R.id.btnSua);
        Button btnXoa = (Button)row.findViewById(R.id.btnXoa);
        Nhanvien nhanvien= list.get(position);
        Ten.setText(nhanvien.ten);
        sdt.setText(nhanvien.sdt);
        Bitmap bitmap = BitmapFactory.decodeByteArray(nhanvien.anh,0,nhanvien.anh.length);
        imgView.setImageBitmap(bitmap);

return row;
    }
}
