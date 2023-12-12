package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import models.*;
import service.Controller;
public class EditData {
    private JTextField tfJenisKendaraan;
    private JLabel labelEditData;
    private JTextField tfModelKendaraan;
    private JTextField tfWarna;
    private JTextField tfJumlahPenumpang;
    private JTextField tfTahunProduksi;
    private JTextField tfHargaSewa;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel labelJenis;
    private JLabel labelModel;
    private JLabel labelWarna;
    private JLabel labelJumlahPenumpang;
    private JLabel labelTahunProduksi;
    private JLabel labelHargaSewa;
    private JPanel panelEditData;
    private JTextField tfJumlahPintu;
    private JLabel labelJumlahPintu;

    Controller controllerKendaraan = new Controller();
    public JPanel getEditDataPanel() {
        return panelEditData;
    }
    public EditData(int rowSelected) {
        SwingUtilities.invokeLater(()->{
            Catalog catalog = new Catalog();
            catalog.initData();
        });
        Vector<Kendaraan> listKendaraan = controllerKendaraan.getKendaraan();
        Kendaraan kendaraan = listKendaraan.get(rowSelected);

        if (kendaraan instanceof Mobil) {
            labelJumlahPintu.setVisible(true);
            tfJumlahPintu.setVisible(true);
            tfJumlahPintu.setText(String.valueOf(((Mobil) kendaraan).getJumlahPintu()));
        } else {
            labelJumlahPintu.setVisible(false);
            tfJumlahPintu.setVisible(false);
        }

        tfJenisKendaraan.setText(kendaraan.getJenisKendaraan());
        tfJenisKendaraan.setEditable(false);
        tfModelKendaraan.setText(kendaraan.getModelKendaraan());
        tfWarna.setText(kendaraan.getWarna());
        tfJumlahPenumpang.setText(String.valueOf(kendaraan.getJumlahPenumpang()));
        tfTahunProduksi.setText(String.valueOf(kendaraan.getTahunProduksi()));
        tfHargaSewa.setText(String.valueOf(kendaraan.getHargaSewa()));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelKendaraan, warna;
                int jumlahPenumpang, tahunProduksi, jumlahPintu;
                double hargaSewa;

                modelKendaraan = tfModelKendaraan.getText();
                warna = tfWarna.getText();
                jumlahPenumpang = Integer.parseInt(tfJumlahPenumpang.getText());
                jumlahPintu = Integer.parseInt(tfJumlahPintu.getText());
                tahunProduksi = Integer.parseInt(tfTahunProduksi.getText());
                hargaSewa = Double.parseDouble(tfHargaSewa.getText());

                kendaraan.setModelKendaraan(modelKendaraan);
                kendaraan.setWarna(warna);
                kendaraan.setJumlahPenumpang(jumlahPenumpang);
                if (kendaraan instanceof Mobil) {
                    ((Mobil) kendaraan).setJumlahPintu(jumlahPintu);
                }
                kendaraan.setTahunProduksi(tahunProduksi);
                kendaraan.setHargaSewa(hargaSewa);

                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");

                // close window
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEditData);
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEditData);
                frame.dispose();
            }
        });
    }
}
