package View;

import javax.swing.*;

import Model.CurrencyType;

import java.awt.*;

public abstract class BaseTransferMoneyWindow extends JFrame {

    protected JLabel amountLabel;
    protected JTextField amountField;
    protected JLabel descLabel;
    protected JTextField descField;
    protected JLabel currencyLabel;
    protected JComboBox<CurrencyType> currencyField;
    protected JButton transferButton;
    protected JButton cancelButton;

    public BaseTransferMoneyWindow() {
        setTitle("Transfer Money");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        amountLabel = new JLabel("Amount:");
        amountField = new JTextField(15);

        descLabel = new JLabel("Description:");
        descField = new JTextField(15);

        currencyLabel = new JLabel("Currency:");
        currencyField = new JComboBox<>(CurrencyType.values());

        transferButton = new JButton("Transfer");
        cancelButton = new JButton("Cancel");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(descLabel, gbc);

        gbc.gridx = 1;
        add(descField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(currencyLabel, gbc);

        gbc.gridx = 1;
        add(currencyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(transferButton, gbc);

        gbc.gridx = 1;
        add(cancelButton, gbc);
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JTextField getDescField() {
        return descField;
    }

    public JComboBox<CurrencyType> getCurrencyField() {
        return currencyField;
    }

    public JButton getTransferButton() {
        return transferButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public abstract CurrencyType getCurrencyType();
}
