package solver;

import lombok.Getter;
import lombok.Setter;
import maze.Maze;
import solver.track.Track;
import solver.track.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solver {
    @Getter
    private final Track track;
    @Setter
    private Maze maze;
    private final List<Point> visited;
    @Getter
    private boolean stop;

    public Solver(Maze maze) {
        visited = new ArrayList<>();
        this.maze = maze;
        track = new Track(maze.getStart());
    }

    public void solve() {
        Point current = track.getTail().getPoint();
        Point[] neighbors = current.getNeighbors();
        int size = track.getSize();
        for (int i = 0; i < 4; i++) {
            Point point = neighbors[i];
            if (add(point)) return;
        }
        if (track.getSize() == size) track.pop();
    }

    public boolean add(Point point) {
        if (checkPoint(point)) {
            track.add(point);
            visited.add(point);
            if (point.equals(maze.getStop()))
                stop = true;
            return true;
        }
        return false;
    }

    private boolean checkPoint(Point point) {
        return maze.getWalls()
                .stream()
                .noneMatch(p -> p.equals(point))
                && !visited.contains(point)
                && checkPosition(point);
    }

    private boolean checkPosition(Point point) {
        return point.getX() >= 0
                && point.getY() >= 0
                && point.getX() < maze.getImage().getWidth()
                && point.getY() < maze.getImage().getHeight();
    }

    public void paint(Graphics g, int size) {
        track.paint(g, size);
    }
}
