package gui;

import service.WindowLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JLabel Title;
    private JLabel Menu;
    private JButton Insert;
    private JButton Catalog;
    private JButton History;
    private JPanel menuPanel;

    public  JPanel getMenuPanel() {
        return menuPanel;
    }

    WindowLayout layout = new WindowLayout();

    public Menu() {
        Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Insert Data");
                frame.setLocation(layout.getWidth(), layout.getHeight());
                frame.setContentPane(new InsertData().getInsertdataPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        Catalog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Catalog");
                frame.setLocation(layout.getWidth(), layout.getHeight());
                frame.setSize(500, 300);
                frame.setContentPane(new Catalog().getCatalogPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        History.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("History");
                frame.setLocation(layout.getWidth(), layout.getHeight());
                frame.setSize(500, 300);
                frame.setContentPane(new History().getHistoryPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
