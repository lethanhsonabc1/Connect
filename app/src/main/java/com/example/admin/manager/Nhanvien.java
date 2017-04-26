package com.example.admin.manager;

public class Nhanvien {
  public int id;
    public String sdt;
    public String ten;
    public byte[] anh;

    public Nhanvien(int id, String sdt, String ten, byte[] anh) {
        this.id = id;
        this.sdt = sdt;
        this.ten = ten;
        this.anh = anh;
    }
}
