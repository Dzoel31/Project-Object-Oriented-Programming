package service;
import java.util.ArrayList;
import java.util.Vector;

import models.*;

public class Controller {

    public static Vector<Kendaraan> kendaraan = new Vector<>();

    public void addKendaraan(Kendaraan k) {
        kendaraan.add(k);
    }
    public void removeKendaraan(int index) {
        kendaraan.remove(index);
    }

    public void updateKendaraan(int index, Kendaraan k) {
        kendaraan.set(index, k);
    }

    public Vector<Kendaraan> getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Vector<Kendaraan> kendaraan) {
        Controller.kendaraan = kendaraan;
    }

    public void clearKendaraan() {
        kendaraan.clear();
    }
}