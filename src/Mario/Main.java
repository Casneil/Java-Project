package Mario;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame("Casio");
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();

    }
}
