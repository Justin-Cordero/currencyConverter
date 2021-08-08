package currencyconverter;
// Justin Cordero
// Description U2 PA1
// 8/8/2021
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CurrencyConverter extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField dollarField;
    private JTextField conversionRateField;
    private JButton convertButton;
    private JLabel currencyLabel;
    private JTextField dracField;

    public CurrencyConverter() {
        super("Currency Conversion");
        setLayout(  new FlowLayout() );

        currencyLabel = new JLabel("Enter the Dollar amount and conversion rate: ");
        add(currencyLabel);

        dollarField = new JTextField( 5 );
        add(dollarField);

        conversionRateField = new JTextField( 5 );
        add(conversionRateField);

        convertButton = new JButton("Convert");
        add (convertButton);

        dracField = new JTextField(25);
        dracField.setEditable(false);
        add (dracField);

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        convertButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            double dollar, conversionRate, drac;
            String dollarString, conversionRateString;

            dollarString = dollarField.getText(); //gets text from the text field
            conversionRateString = conversionRateField.getText();
            try {
                dollar = Double.parseDouble(dollarString);
                conversionRate = Double.parseDouble(conversionRateString);
                drac = dollar * conversionRate;
                String textString = String.format("%s%.2f%s", "Your Dollar amount converts to ", drac, "Drac.");
                dracField.setText(textString);
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
                // clear fields on error
                dollarField.setText("");
                dracField.setText("");
            }

        }

    }
}
