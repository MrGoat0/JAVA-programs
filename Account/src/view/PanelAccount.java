package view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.Date;

public abstract class PanelAccount extends JPanel {
    protected JTextField number;
    protected JDateChooser dateOpen;
    protected JTextField balance;
    protected MainWindow mainWindow;

    public PanelAccount(MainWindow mainWindow){
        this.mainWindow = mainWindow;
    }

    protected void addComponents( ){
        add( new JLabel("Agregar Cuenta"));
        add( new JLabel());
        add( new JLabel("Número de Cuenta"));
        add(number);
        add( new JLabel("Fecha Apertura"));
        add(dateOpen);
        add( new JLabel("Saldo de Cuenta"));
        add( balance);
    };

    protected void beginComponents() {
        number = new JTextField();

        dateOpen = new JDateChooser();

        dateOpen.setDate(new Date());

        balance = new JTextField();
    }

    public abstract String[]  getFields();

    public void cleanFields(){
        number.setText("");
        dateOpen.setDate( new Date());
        balance.setText("");
    }
}