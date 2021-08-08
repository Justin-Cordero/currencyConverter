/*
 * Justin Cordero
 * U2PA1
 * 8/8/2021
 * */
package mypackage;

import javax.swing.JFrame;

public class CurrencyConverterTest {

    public static void main(String[] args) {
        CurrencyConverter currencyFrame = new CurrencyConverter();
        currencyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currencyFrame.setSize(350, 250);
        currencyFrame.setVisible(true);
    }

}
