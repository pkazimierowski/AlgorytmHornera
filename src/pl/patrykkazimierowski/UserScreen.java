package pl.patrykkazimierowski;

import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class UserScreen {

    static private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    public static int getWidth() {

        return d.width;

    }
    public static int getHeight() {

        return d.height;

    }

}
