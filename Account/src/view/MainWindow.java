package view;

import account.Controll;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private PanelAccountDeposit panelDeposit;
    private PanelAccountCurrent panelCurrent;
    private PanelTransactions panelTransactions;
    private Controll controll;

    public MainWindow(){
        setTitle("Gestión de Cuentas");
        setSize( new Dimension(640,360));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable( false );
    }

    public void begin(){
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        controll = new Controll();
        tabbedPane = new JTabbedPane();
        panelDeposit = new PanelAccountDeposit(this);
        panelCurrent = new PanelAccountCurrent( this );
        panelTransactions = new PanelTransactions( this );
    }

    private void addComponents() {
        tabbedPane.add( "Cuenta Deposito",panelDeposit );
        tabbedPane.add( "Cuenta Corriente",panelCurrent );
        tabbedPane.add( "Transacciones",panelTransactions );
        add(tabbedPane);
    }

    public void addAccountDeposit() {
        String[] fields = panelDeposit.getFields();
        String number = fields[0];
        LocalDate dateOpen = LocalDate.parse( fields[1] );
        double balance = Double.parseDouble( fields[2]);
        double interest = Double.parseDouble( fields[3]);
        boolean excent = fields[4].equals("S") ? true : false;

        if( controll.addAccount(number,dateOpen,balance,interest,excent)){
            JOptionPane.showMessageDialog(null,"Se Agregó la Cuenta Depósito","Hecho",JOptionPane.INFORMATION_MESSAGE);
            panelTransactions.addNumberAccount( number );
            panelDeposit.cleanFields();
        }else{
            JOptionPane.showMessageDialog(null,"Número de Cuenta ya Registrada","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addAccountCurrent() {
        String[] fields = panelCurrent.getFields();
        String number = fields[0];
        LocalDate dateOpen = LocalDate.parse( fields[1] );
        double balance = Double.parseDouble( fields[2]);
        double overdraft = Double.parseDouble( fields[3] );
        if( controll.addAccount(number,dateOpen,balance,overdraft)){
            JOptionPane.showMessageDialog(null,"Se Agregó la Cuenta Corriente","Hecho",JOptionPane.INFORMATION_MESSAGE);
            panelTransactions.addNumberAccount( number );
            panelCurrent.cleanFields();
        }else{
            JOptionPane.showMessageDialog(null,"Número de Cuenta ya Registrada","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void transaction(){
        String[] data = panelTransactions.getFields();
        String number = data[0];
        double value = Double.parseDouble( data[2]);

        if( data[1].equals("C")){
            if( controll.deposit( number,value ) ){
                Object[] account = controll.findAccount( number );
                JOptionPane.showMessageDialog(null,"Transacción Exitosa, su nuevo saldo es " + account[2],"Hecho",JOptionPane.INFORMATION_MESSAGE);
                panelTransactions.cleanFields();
            }else{
                JOptionPane.showMessageDialog(null,"Número de Cuenta No Registrada","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            //TODO realizar Retiro
        }
    }
}