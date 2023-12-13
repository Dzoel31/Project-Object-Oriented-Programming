package models;

public class Mobil extends Kendaraan{
    private int JumlahPintu;
    public Mobil(String jenisKendaraan,
                 String modelKendaran,
                 String warna,
                 int jumlahPenumpang,
                 int jumlahPintu,
                 int tahunProduksi,
                 double hargaSewa) {
        super(jenisKendaraan, modelKendaran, warna, tahunProduksi, hargaSewa);
        this.jumlahPenumpang = jumlahPenumpang;
        this.JumlahPintu = jumlahPintu;
    }
    public int getJumlahPintu() {
        return this.JumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.JumlahPintu = jumlahPintu;
    }
}
