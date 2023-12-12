package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import service.Controller;
import models.Kendaraan;
import models.Transaksi;
import service.HistoryController;


public class RentConfirmation {

    private JLabel formTitle;
    private JPanel rentConfirmPanel;
    private JTextField tfJenisKendaraan;
    private JTextField tfModelKendaraan;
    private JTextField tfJumlahPenumpang;
    private JTextField tfHargaSewa;
    private JLabel labelJenisKendaraan;
    private JLabel labelModelKendaraan;
    private JLabel labelJumlahPenumpang;
    private JLabel labelHargaSewa;
    private JTextField tfLamaSewa;
    private JLabel labelLamaSewa;
    private JButton rentButton;

    Controller controllerKendaraan = new Controller();
    HistoryController historyController = new HistoryController();

    Vector<Kendaraan> listKendaraan = controllerKendaraan.getKendaraan();
    int rowSelected;


    public JPanel getRentConfirmPanel() {
        return rentConfirmPanel;
    }
    public void reset() {
        tfJenisKendaraan.setText("");
        tfModelKendaraan.setText("");
        tfJumlahPenumpang.setText("");
        tfHargaSewa.setText("");
        tfLamaSewa.setText("");
    }

    public RentConfirmation(int row) {
        this.rowSelected = row;


        tfJenisKendaraan.setText(listKendaraan.get(rowSelected).getJenisKendaraan());
        tfModelKendaraan.setText(listKendaraan.get(rowSelected).getModelKendaraan());
        tfJumlahPenumpang.setText(String.valueOf(listKendaraan.get(rowSelected).getJumlahPenumpang()));
        tfHargaSewa.setText(String.valueOf(listKendaraan.get(rowSelected).getHargaSewa()));

        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double lamaSewa, totalSewa;
                String waktuSewa, waktuPengembalian;

                lamaSewa = Double.parseDouble(tfLamaSewa.getText());
                totalSewa = listKendaraan.get(rowSelected).getHargaSewa() * lamaSewa;

                LocalDateTime currentTime = LocalDateTime.now();
                LocalDateTime returnTime = currentTime.plusDays((long) lamaSewa);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                waktuSewa = currentTime.format(formatter);
                waktuPengembalian = returnTime.format(formatter);

                JOptionPane.showMessageDialog(null, "Sewa Berhasil!\n Total Harga Sewa: " + totalSewa);


                Transaksi transaksi = new Transaksi(listKendaraan.get(rowSelected).getJenisKendaraan(), lamaSewa, totalSewa, waktuSewa, waktuPengembalian);
                historyController.addTransaksi(transaksi);

                reset();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rentConfirmPanel);
                frame.dispose();
            }
        });
    }
}
