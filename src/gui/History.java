package gui;
import models.*;
import service.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class History {
    private JLabel History;
    private JTable historyTable;
    private JPanel historyPanel;
    private JButton hapusButton;
    private JButton hapusSemuaButton;

    HistoryController historyController = new HistoryController();
    public JPanel getHistoryPanel() {
        return historyPanel;
    }
    public void initHistory(){
        // initialize table
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Model Kendaraan");
        columnNames.add("Lama Sewa");
        columnNames.add("Harga Total");
        columnNames.add("Waktu Sewa");
        columnNames.add("Waktu Pengembalian");

        DefaultTableModel model = getDefaultTableModel(columnNames);
        historyTable.setModel(model);
        historyTable.setDefaultEditor(Object.class, null);
    }
    private DefaultTableModel getDefaultTableModel(Vector<String> columnNames) {
        Vector<Vector<Object>> data = new Vector<>();
        for (Transaksi t : historyController.getListTransaksi()) {
            Vector<Object> row = new Vector<>();
            row.add(t.getModelKendaraan());
            row.add(t.getLamaSewa());
            row.add(t.getHargaTotal());
            row.add(t.getWaktuSewa());
            row.add(t.getWaktuPengembalian());
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }
    public History() {
        initHistory();
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = historyTable.getSelectedRow();

                if (rowSelected == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
                    return;
                }
                historyController.removeTransaksi(rowSelected);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        initHistory();
                    }
                });
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            }
        });
        hapusSemuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historyController.removeAll();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        initHistory();
                    }
                });
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            }
        });
    }
}
