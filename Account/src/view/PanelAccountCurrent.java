package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PanelAccountCurrent extends PanelAccount {
    private JTextField overDraft;
    private JButton accept;

    public PanelAccountCurrent(MainWindow mainWindow){
        super(mainWindow);
        this.setLayout( new GridLayout(6,2));
        beginComponents();
        addComponents();
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        add( new JLabel("Valor Sobregiro"));
        add(overDraft);

        add(accept);
    }

    @Override
    protected void beginComponents() {
        super.beginComponents();

        overDraft = new JTextField();
        accept = new JButton("Agregar Cuenta Corriente");
        accept.setActionCommand( HandlingEvents.ADD_ACCOUNT_CURRENT);
        accept.addActionListener( new HandlingEvents( mainWindow ) );
    }

    @Override
    public String[] getFields() {
        String txtNumber = number.getText();

        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String txtDateOpen = fmt.format(dateOpen.getDate());

        String txtBalance = balance.getText();
        String txtOverdraft = overDraft.getText();

        return new String[]{txtNumber, txtDateOpen, txtBalance, txtOverdraft };
    }

    @Override
    public void cleanFields() {
        super.cleanFields();
        overDraft.setText("");
    }
}