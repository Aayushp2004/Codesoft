import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGame extends JFrame {
    final Random random = new Random();
    final int minRange = 1;
    final int maxRange = 100;
    final int maxAttempts = 10;
    final int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
    int attempts = 0;

    final JLabel label = new JLabel("Number Game");
    final JLabel instructionLabel = new JLabel("Guess the number between " + minRange + "and" + maxRange + ".");
    final JLabel attemptsLabel = new JLabel("Attempts remaining: " + (maxAttempts - attempts));

    final JTextField guessField = new JTextField(10);
    final JButton guessButton = new JButton("Guess");
    final JTextArea resultArea  = new JTextArea(5,30);

    public NumberGame(){
        setTitle("Number Guessing game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeGuess();
            }
        });

        add(label);
        add(instructionLabel);
        add(attemptsLabel);
        add(guessField);
        add(guessButton);
        add(resultArea);

        pack();
        setLocationRelativeTo(null); //Center the window

    }
    public void takeGuess(){
        if (attempts >= maxAttempts){
            resultArea.append("Game over. you've reached the maximum number of attempts.\n");
            resultArea.append("The correct number was : " + randomNumber + "\n");
            guessField.setEnabled(false);
            guessButton.setEnabled(false);
        }else {
            int guess;
            try{
                guess = Integer.parseInt(guessField.getText());
            } catch (NumberFormatException e){
                resultArea.append("Invalid input. Please enter a valid number.\n");
                return;
            }

            attempts++;

            if (guess == randomNumber){
                  resultArea.append("Congratulation!!! You guess the correct number.\n");
                  guessField.setEnabled(false);
                  guessButton.setEnabled(false);
            } else if (guess < randomNumber) {
                resultArea.append("Attempt #" + attempts + ":Your Guess is too low.\n");
                attemptsLabel.setText("Attempts remaining: " + (maxAttempts - attempts));
            } else {
                resultArea.append("Attempt #" + attempts + ": You guess is too high.\n");
                attemptsLabel.setText("Attempts remaining: " + (maxAttempts - attempts) );
            }
        }
        guessField.setText("");

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGame().setVisible(true);
            }
        });

    }
}
