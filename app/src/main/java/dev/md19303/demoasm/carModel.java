package dev.md19303.demoasm;

public class carModel {
    private String _id;
    private String ten;

    private int namSX;

    private String hang;

    private double gia;

    public carModel(String _id, String ten, int namSX, String hang, double gia) {
        this._id = _id;
        this.ten = ten;
        this.namSX = namSX;
        this.hang = hang;
        this.gia = gia;
    }

    public carModel(String ten, int namSX, String hang, double gia) {
        this.ten = ten;
        this.namSX = namSX;
        this.hang = hang;
        this.gia = gia;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}