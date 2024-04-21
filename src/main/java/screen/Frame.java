package screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
