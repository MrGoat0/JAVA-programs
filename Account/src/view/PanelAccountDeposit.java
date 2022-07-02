package view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class PanelAccountDeposit extends PanelAccount {

    private JSpinner interest;
    private JComboBox<String> excent;
    private JButton accept;

    public PanelAccountDeposit( MainWindow mainWindow){
        super(mainWindow);
        this.setLayout( new GridLayout(7,2));
        beginComponents();
        addComponents();
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        add( new JLabel("Tasa de Interes"));
        add(interest);
        add( new JLabel("Cuenta Excenta"));
        add(excent);
        add(accept);
    }

    @Override
    protected void beginComponents() {
        super.beginComponents();
        SpinnerModel model = new SpinnerNumberModel(2.0,0.0,3.0,0.1);
        interest = new JSpinner( model );

        excent = new JComboBox<>(new String[]{"Si","No"});

        accept = new JButton("Agregar Cuenta Deposito");
        accept.setActionCommand( HandlingEvents.ADD_ACCOUNT_DEPOSIT);
        accept.addActionListener( new HandlingEvents( mainWindow ) );
    }

    @Override
    public String[] getFields() {
        String txtNumber = number.getText();

        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String txtDateOpen = fmt.format(dateOpen.getDate());

        String txtBalance = balance.getText();
        String txtInterest = String.valueOf( interest.getValue());
        String txtExcent = excent.getSelectedIndex() == 0 ? "S" : "N";

        return new String[]{txtNumber,txtDateOpen,txtBalance,txtInterest,txtExcent};
    }

    @Override
    public void cleanFields() {
        super.cleanFields();
        interest.setValue(2.0);
        excent.setSelectedIndex(0);
    }

}