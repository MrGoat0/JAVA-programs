package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class Window extends JFrame implements ActionListener, KeyListener, WindowListener {
    private JLabel title;
    private JTextField txtOne;
    private JTextField txtTwo;
    private JButton btnAccept;
    private JButton btnClear;
    private JTextField result;
    private JComboBox<String> options;
    //Constantes
    private final String ACCEPT = "Aceptar";
    private final String CLEAR_FIELDS = "Limpiar campos";
    private final String OPTION_MENU = "Opciones del menu";


    public Window(){
        super("Ejemplo de Swing");
        this.setSize(new Dimension(640, 160));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        // Organizadores de contenido: FlowLayout, BorderLayout, GridLayaout, GridBagLayout
        this.setLayout(new BorderLayout());
        this.addWindowListener(this);


    }
    public void begin(){
        beginComponents();
        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,4));

        //Componentes de la primer fila
        panel.add(new JLabel("Numero uno"));
        panel.add(txtOne);
        panel.add(new JLabel("Numero dos"));
        panel.add(txtTwo);
        //Componentes de la segunda fila
        panel.add(new JLabel());
        panel.add(options);
        panel.add(new JLabel("Resultado"));
        panel.add(result);

        JPanel panelTitle = new JPanel(new FlowLayout());
        panelTitle.add(title);
        add(panelTitle, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);

        JPanel panelBtn = new JPanel(new FlowLayout());
        panelBtn.add(btnAccept);
        panelBtn.add(btnClear);
        add(panelBtn, BorderLayout.SOUTH);
    }

    private void beginComponents() {
        title = new JLabel("Ejemplo de Swing");

        txtOne = new JTextField();
        txtOne.addKeyListener(this);
        txtTwo = new JTextField();
        txtTwo.addKeyListener(this);

        btnAccept = new JButton("Aceptar");
        btnAccept.setActionCommand(ACCEPT);
        btnAccept.addActionListener(this);


        btnClear = new JButton("Clear");
        btnClear.setActionCommand(CLEAR_FIELDS);
        btnClear.addActionListener(this);

        String[] txtOptions = {"Sumar", "Restar", "Dividir", "Multiplicar"};
        options = new JComboBox<>(txtOptions);
        options.setActionCommand(OPTION_MENU);
        options.addActionListener(this );

        result = new JTextField();
        result.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ACCEPT: txtTwo.setText(txtOne.getText());
            break;
            case CLEAR_FIELDS:
                txtTwo.setText("");
                txtOne.setText("");
                break;
            case OPTION_MENU: validateMune();
            break;


        }
    }

    private void validateMune() {
        //System.out.println(options.getSelectedIndex());
        int numOne = Integer.parseInt(txtOne.getText());
        int numTwo = Integer.parseInt(txtTwo.getText());
        switch (options.getSelectedIndex()){
            case 0:
                result.setText(String.valueOf(numOne+numTwo));
                break;
            case 1:
                result.setText(String.valueOf(numOne-numTwo));
                break;
            case 2:
                result.setText(String.valueOf(numOne/numTwo));
                break;
            case 3:
                result.setText(String.valueOf(numOne*numTwo));
                break;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyChar();
        if (key>=48 && key<=57){
            //System.out.println("Se pulso la tecla: "+key);
        }
        else {
            e.consume();
            //System.out.println("No valido");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int close = JOptionPane.showConfirmDialog(null, "Desea salir", "HOLA", JOptionPane.YES_NO_OPTION);
        if ( close == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
