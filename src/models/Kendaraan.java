package models;

public class Kendaraan {
    protected String jenisKendaraan, modelKendaraan, warna;
    protected int tahunProduksi, lamaSewa, jumlahPenumpang;
    protected double hargaSewa, hargaTotal;

    public Kendaraan(String jenisKendaraan,
                     String modelKendaraan,
                     String warna,
                     int tahunProduksi,
                     double hargaSewa) {
        this.jenisKendaraan = jenisKendaraan;
        this.modelKendaraan = modelKendaraan;
        this.warna = warna;
        this.tahunProduksi = tahunProduksi;
        this.hargaSewa = hargaSewa;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }

    public String getWarna() {
        return warna;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public double getHargaTotal() {
        return hargaTotal;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void setModelKendaraan(String modelKendaran) {
        this.modelKendaraan = modelKendaran;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public double hitungHargaTotal() {
        return this.hargaTotal = this.getHargaSewa() * this.getLamaSewa();
    }

}

