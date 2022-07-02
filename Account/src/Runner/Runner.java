package Runner;

import view.MainWindow;

public class Runner {
    public static void main(String[] args) {
        MainWindow myWindow = new MainWindow();
        myWindow.begin();
        myWindow.setVisible( true );
    }
}
