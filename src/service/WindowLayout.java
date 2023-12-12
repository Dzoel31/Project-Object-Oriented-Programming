package service;
import java.awt.Dimension;
import java.awt.Toolkit;
public class WindowLayout {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int width = (int) screenSize.getWidth();
    private final int height = (int) screenSize.getHeight();

    public int getWidth() {
        return width / 2 - 115;
    }
    public int getHeight() {
        return height / 2 - 100;
    }
}
