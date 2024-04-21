package solver.track;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Getter
@NoArgsConstructor
public class Track {

    private Node head;
    private Node tail;

    private int size;

    public Track(Node node) {
        head = node;
        tail = node;
        size = 1;
    }

    public Track(Point point) {
        this(new Node(point));
    }

    public void add(Node node) {
        node.setPrevious(tail);
        tail.setNext(node);
        tail = node;
        size++;
    }

    public void add(Point point) {
        Node node = new Node(point);
        add(node);
    }

    public void add(int x, int y) {
        Point point = new Point(x, y);
        add(point);
    }

    public void pop() {
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
    }

    public void paint(Graphics g, int size) {
        Node current = head;
        while (current != null) {
            current.getPoint().paint(g, size);
            current = current.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        while (current != null) {
            stringBuilder.append(current).append(" ");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

}
