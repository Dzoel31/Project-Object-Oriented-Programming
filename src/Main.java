import javax.swing.*;

import gui.Menu;
import service.WindowLayout;

public class Main {
    public static void main(String[] args) {
        WindowLayout layout = new WindowLayout();
        JFrame frame = new JFrame("Menu");
        frame.setLocation(layout.getWidth(), layout.getHeight());

        frame.setSize(300, 200);
        frame.setContentPane(new Menu().getMenuPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
