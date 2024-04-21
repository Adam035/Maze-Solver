package solver.track;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@Getter
@AllArgsConstructor
public class Point {
    private int x, y;

    public Point[] getNeighbors() {
        Point[] points = new Point[4];
        points[0] = new Point(x, y - 1);
        points[1] = new Point(x + 1, y);
        points[2] = new Point(x, y + 1);
        points[3] = new Point(x - 1, y);
        return points;
    }

    public void paint(Graphics g, int size) {
        g.setColor(Color.BLUE);
        g.fillRect(x * size, y * size, size, size);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Point point)) return false;
        return getX() == point.getX() && getY() == point.getY();
    }
}
