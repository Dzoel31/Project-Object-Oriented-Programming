package models;

public class Motor extends Kendaraan{
    public static final int JUMLAHPENUMPANG = 2;
    public Motor(String jenisKendaraan,
                 String modelKendaran,
                 String warna,
                 int tahunProduksi,
                 double hargaSewa) {
        super(jenisKendaraan, modelKendaran, warna, tahunProduksi, hargaSewa);
    }

    public int getJumlahPenumpang() {
        return JUMLAHPENUMPANG;
    }
}

