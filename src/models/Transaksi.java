package models;

public  class Transaksi {
    private String modelKendaraan, waktuSewa, waktuPengembalian;
    private double lamaSewa, hargaTotal;

    public Transaksi(String modelKendaraan, double lamaSewa, double hargaTotal, String waktuSewa, String waktuPengembalian) {
        this.modelKendaraan = modelKendaraan;
        this.lamaSewa = lamaSewa;
        this.hargaTotal = hargaTotal;
        this.waktuSewa = waktuSewa;
        this.waktuPengembalian = waktuPengembalian;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }
    public double getLamaSewa() {
        return lamaSewa;
    }
    public double getHargaTotal() {
        return hargaTotal;
    }
    public String getWaktuSewa() {
        return waktuSewa;
    }
    public String getWaktuPengembalian() {
        return waktuPengembalian;
    }

}