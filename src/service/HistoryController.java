package service;

import models.Transaksi;

import java.util.Vector;

public class HistoryController {
    public static Vector<Transaksi> listTransaksi = new Vector<>();

    public void addTransaksi(Transaksi transaksi) {
        listTransaksi.add(transaksi);
    }

    public void removeTransaksi(int index) {
        listTransaksi.remove(index);
    }
    public void removeAll(){
        listTransaksi.removeAllElements();
    }
    public Vector<Transaksi> getListTransaksi() {
        return listTransaksi;
    }
}
