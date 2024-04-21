package maze;

import lombok.Getter;
import lombok.Setter;
import solver.track.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    public static final int WALL = -16777216;
    public static final int START = -4856291;
    public static final int STOP = -1237980;

    private static Maze instance;
    @Getter
    @Setter
    private BufferedImage image;
    @Getter
    @Setter
    private List<solver.track.Point> walls;
    @Getter
    @Setter
    private solver.track.Point start, stop;

    private Maze(File file) {
        walls = new ArrayList<>();
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mapPoints();
    }

    public static Maze getInstance(File file) {
        if (instance == null) instance = new Maze(file);
        return instance;
    }

    private void mapPoints() {
        for (int y = 0; y < image.getHeight(); y++)
            for (int x = 0; x < image.getWidth(); x++) {
                getPoint(x, y);
            }
    }

    private void getPoint(int x, int y) {
        int rgb = image.getRGB(x, y);
        switch (rgb) {
            case Maze.START -> start = new solver.track.Point(x, y);
            case Maze.STOP -> stop = new solver.track.Point(x, y);
            case Maze.WALL -> walls.add(new Point(x, y));
        }
    }

    public void paint(Graphics g, int size) {
        g.setColor(new Color(Maze.START));
        g.fillRect(start.getX() * size, start.getY() * size, size, size);

        g.setColor(new Color(Maze.STOP));
        g.fillRect(stop.getX() * size, stop.getY() * size, size, size);

        g.setColor(new Color(Maze.WALL));
        walls.forEach(wall -> g.fillRect(wall.getX() * size, wall.getY() * size, size, size));
    }
}
