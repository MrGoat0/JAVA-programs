package view;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class PanelTransactions extends PanelAccount {

    private JComboBox<String> numberAccounts;
    private JRadioButton deposit;
    private JRadioButton withDraw;
    private JTextField value;
    private JButton accept;

    public PanelTransactions(MainWindow mainWindow){
        super(mainWindow);
        setLayout(new GridLayout(5,2));
        beginComponents();
        addComponents();
    }

    protected void addComponents() {
        add(new JLabel("Consignar/Retirar"));
        add(new JLabel());
        add(new JLabel("Numero Cuenta"));
        add( numberAccounts );

        ButtonGroup group = new ButtonGroup();
        group.add( deposit );
        group.add( withDraw );

        add(new JLabel("Tipo Transacción"));

        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(2,2));
        panel.add(new JLabel("Consignar"));
        panel.add(deposit);
        panel.add(new JLabel("Retirar"));
        panel.add(withDraw);

        add(panel);

        add(new JLabel("Valor"));
        add( value );
        add(accept);
    }

    protected void beginComponents() {
        numberAccounts = new JComboBox<>();

        deposit = new JRadioButton();
        deposit.setSelected( true );
        withDraw = new JRadioButton();

        value = new JTextField();

        accept = new JButton("Confirmar");
        accept.setActionCommand( HandlingEvents.TRANSACTION );
        accept.addActionListener( new HandlingEvents(mainWindow));
    }

    @Override
    public String[] getFields() {
        String number = numberAccounts.getItemAt( numberAccounts.getSelectedIndex());
        String type = deposit.isSelected() ? "C" : "R";
        String valueTransaction = value.getText();

        return new String[]{number,type,valueTransaction};
    }

    public void addNumberAccount(String number){
        numberAccounts.addItem( number );
    }

    @Override
    public void cleanFields(){
        //Limpiar Campos
    }
}