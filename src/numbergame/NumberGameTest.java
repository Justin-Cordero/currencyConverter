package numbergame;

import javax.swing.*;

public class NumberGameTest {
    public static void main(String[] args) {
        NumberGame numberGameFrame = new NumberGame();
        numberGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        numberGameFrame.setSize(1000,500);
        numberGameFrame.setVisible(true);
    }
}
