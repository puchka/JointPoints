package mg.facedev.algorithm;

import javax.swing.JFrame;

/** Main class : Initialization of the main window.
 *
 * @author Marius Rabenarivo <marius@espa-tana.mg>
 *
 */
public class Main {
    /**
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        JFrame mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
