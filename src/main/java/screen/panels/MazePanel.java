package screen.panels;

import maze.Maze;
import solver.Solver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MazePanel extends JPanel implements ActionListener {

    private final int WIDTH, HEIGHT;

    private final int SIZE = 18;
    private final Maze maze;
    private final Solver solver;

    public MazePanel(File file, int delay) {
        maze = Maze.getInstance(file);
        WIDTH = maze.getImage().getWidth() * SIZE;
        HEIGHT =  maze.getImage().getHeight() * SIZE;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        setLayout(null);
        setVisible(true);
        solver = new Solver(maze);

        start(delay);
    }

    private void start(int delay) {
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        maze.paint(g, SIZE);
        solver.paint(g, SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!solver.isStop()) solver.solve();
        repaint();
    }
}
