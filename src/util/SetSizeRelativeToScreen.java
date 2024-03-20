package util;

import java.awt.*;

public class SetSizeRelativeToScreen {

    public static void setSizeRelativeToScreen(Window window, double widthPercentage, double heightPercentage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * widthPercentage);
        int height = (int) (screenSize.getHeight() * heightPercentage);
        window.setSize(width, height);
    }

}
