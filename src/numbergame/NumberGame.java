package numbergame;

import currencyconverter.CurrencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGame extends JFrame {
    private final RectanglePanel hintPanel;
    private JLabel starterText, output;
    private JTextField userGuess;
    private JButton submit;
    private int randomNum;

    // No argument constructor
    public NumberGame() {
        super("Number Game");
        setLayout(new FlowLayout());
        // Add game components
        starterText = new JLabel("I have a number between 1 and 1000. Can you guess my number?\n" +
                "Please enter your guess.");
        add(starterText);
        userGuess = new JTextField(5);
        add(userGuess);
        submit = new JButton("Guess");
        add(submit);
        output = new JLabel("");
        add(output, BorderLayout.SOUTH);
        hintPanel = new RectanglePanel();
        add(hintPanel);
        hintPanel.setBackground(Color.BLACK);
        // Generate random number 1-1000
        randomNum = ThreadLocalRandom.current().nextInt(1, 1001);
        System.out.println(randomNum);
        // Handle user submission
        ButtonHandler handler = new ButtonHandler();
        submit.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            double guess;
            double lastGuess = 9999;
            String guessString;

            try {
                guessString = userGuess.getText();
                guess = Double.parseDouble(guessString);
                if (guess == randomNum) {
                    output.setText("Correct!");
                    hintPanel.setBackground(Color.GREEN);
                    userGuess.setEditable(false);
                } else if (guess > randomNum) {
                    output.setText("Too High");
                    userGuess.setText("");
                    // Adjust hint color based on last guess
                    if ((randomNum - guess) < (randomNum - lastGuess)) {
                        // set color blue for colder
                        hintPanel.setBackground(Color.BLUE);
                    } else if ((randomNum - guess) > (randomNum - lastGuess)) {
                        // set color red for warmer
                        hintPanel.setBackground(Color.RED);
                    }
                    lastGuess = guess;
                } else if (guess < randomNum) {
                    output.setText("Too Low");
                    userGuess.setText("");
                    // Adjust hint color based on last guess
                    if ((randomNum - guess) < (randomNum - lastGuess)) {
                        // set color blue for colder
                        hintPanel.setBackground(Color.BLUE);
                    } else if ((randomNum - guess) > (randomNum - lastGuess)) {
                        // set color red for warmer
                        hintPanel.setBackground(Color.RED);
                    }
                    lastGuess = guess;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                userGuess.setText("");
            }

        }
    }
}
