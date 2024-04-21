package screen.panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuPanel extends JPanel implements ActionListener {
    private final JButton selectButton;
    private final JButton startButton;
    private final JTextField delayField;
    private File file;

    public MenuPanel() {
        setFocusable(true);
        setLayout(null);
        setVisible(true);

        selectButton = new JButton("Select maze");
        selectButton.setBounds(30, 40, 105, 30);
        selectButton.setFocusable(false);
        selectButton.addActionListener(this);
        add(selectButton);

        startButton = new JButton("Start");
        startButton.setBounds(110, 100, 80, 30);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        add(startButton);

        JLabel delayLabel = new JLabel("Delay (ms):");
        delayLabel.setBounds(160, 20, 100, 25);
        add(delayLabel);

        delayField = new JTextField();
        delayField.setBounds(160, 45, 100, 25);
        add(delayField);
    }

    private void selectFile() {
        String path = "./src/main/resources";
        JFileChooser fileChooser = new JFileChooser(new File(path));

        int value = fileChooser.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION)
            file = fileChooser.getSelectedFile();
    }

    private void start() {
        if (file == null) return;
        JFrame frame = new JFrame();
        frame.add(new MazePanel(file, getDelay()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private int getDelay() {
        String delayString = delayField.getText();
        if (delayString.equals("")) return 0;
        return Integer.parseInt(delayString);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (selectButton.equals(source)) selectFile();
        else if (startButton.equals(source)) start();
    }
}
