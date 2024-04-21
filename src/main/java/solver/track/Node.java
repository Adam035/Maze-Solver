package solver.track;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Node {
    public Point point;
    @Setter
    public Node next;
    @Setter
    public Node previous;

    public Node(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return point.toString();
    }
}
