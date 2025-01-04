import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private JButton[] numberButtons, operationButtons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private JButton decButton, memStoreButton, memRecallButton, memClearButton;
    private JButton sinButton, cosButton, tanButton, logButton, lnButton, factButton;
    private JButton squareButton, sqrtButton, expButton;
    private JPanel panel;

    // Fields for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private double memory = 0;

    public CalculatorApp() {
        // Frame setup
        setTitle("Complex Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Display field
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);

        // Buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        decButton = new JButton(".");
        memStoreButton = new JButton("M+");
        memRecallButton = new JButton("MR");
        memClearButton = new JButton("MC");
        squareButton = new JButton("x²");
        sqrtButton = new JButton("√");
        expButton = new JButton("^");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        lnButton = new JButton("ln");
        factButton = new JButton("n!");

        operationButtons = new JButton[]{
                addButton, subButton, mulButton, divButton, eqButton, clrButton,
                decButton, memStoreButton, memRecallButton, memClearButton,
                squareButton, sqrtButton, expButton,
                sinButton, cosButton, tanButton, logButton, lnButton, factButton
        };

        for (JButton btn : operationButtons) {
            btn.addActionListener(this);
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(6, 4, 10, 10));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(sqrtButton);
        panel.add(expButton);
        panel.add(squareButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(decButton);
        panel.add(expButton);
        panel.add(factButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);
        panel.add(lnButton);
        panel.add(memStoreButton);
        panel.add(memRecallButton);
        panel.add(memClearButton);
        

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    display.setText(display.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == decButton) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText().concat("."));
                }
            }
            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '+';
                display.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '-';
                display.setText("");
            }
            if (e.getSource() == mulButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '*';
                display.setText("");
            }
            if (e.getSource() == divButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '/';
                display.setText("");
            }
            if (e.getSource() == expButton) {
                num1 = Double.parseDouble(display.getText());
                operator = '^';
                display.setText("");
            }
            if (e.getSource() == squareButton) {
                num1 = Double.parseDouble(display.getText());
                result = num1 * num1;
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == sqrtButton) {
                num1 = Double.parseDouble(display.getText());
                if (num1 < 0) throw new ArithmeticException("Invalid Input");
                result = Math.sqrt(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == factButton) {
                num1 = Double.parseDouble(display.getText());
                result = 1;
                for (int i = 1; i <= num1; i++) result *= i;
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == sinButton) {
                num1 = Math.toRadians(Double.parseDouble(display.getText()));
                result = Math.sin(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == cosButton) {
                num1 = Math.toRadians(Double.parseDouble(display.getText()));
                result = Math.cos(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == tanButton) {
                num1 = Math.toRadians(Double.parseDouble(display.getText()));
                result = Math.tan(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == logButton) {
                num1 = Double.parseDouble(display.getText());
                if (num1 <= 0) throw new ArithmeticException("Invalid Input");
                result = Math.log10(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == lnButton) {
                num1 = Double.parseDouble(display.getText());
                if (num1 <= 0) throw new ArithmeticException("Invalid Input");
                result = Math.log(num1);
                display.setText(String.valueOf(result));
            }
            if (e.getSource() == eqButton) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': result = num1 / num2; break;
                    case '^': result = Math.pow(num1, num2); break;
                }
                display.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == memStoreButton) {
                memory = Double.parseDouble(display.getText());
            }
            if (e.getSource() == memRecallButton) {
                display.setText(String.valueOf(memory));
            }
            if (e.getSource() == memClearButton) {
                memory = 0;
            }
            if (e.getSource() == clrButton) {
                display.setText("");
                num1 = num2 = result = 0;
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
