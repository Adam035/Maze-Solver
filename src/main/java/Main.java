import screen.Frame;
import screen.panels.MenuPanel;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame(300, 200);
        MenuPanel menuPanel = new MenuPanel();
        frame.add(menuPanel);
        frame.setVisible(true);
    }
}

