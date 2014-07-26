package mg.facedev.algorithm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Main Window : Initialization of all the components.
 * User Interactions and Algorithm
 * @author Marius Rabenarivo <marius@espa-tana.mg>
 *
 */
public class MainWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** Declaration of canvas. */
    private Canvas canvas;
    /** Panel to contain the buttons. */
    private JPanel buttons;
    /** Command buttons. */
    private JButton trace, reset;
    /** Width of the main window. */
    final int WINDOW_WIDTH = 500;
    /** Height of the main window. */
    final int WINDOW_HEIGHT = 400;
    /** Title of the main window. */
    final String WINDOW_TITLE = "Joint Points - facedev.mg";

    /**
     * Constructor of the main window.
     */
    public MainWindow() {
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setTitle(WINDOW_TITLE);
        canvas = new Canvas();
        setContentPane(canvas);
        buttons = new JPanel();
        trace = new JButton("Trace");
        reset = new JButton("Reset");
        setLayout(new BorderLayout());
        buttons.add(trace);
        buttons.add(reset);
        add(buttons, BorderLayout.NORTH);

        trace.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                ArrayList<Point2D> points = canvas.getPoints();
                ArrayList<Double> angles = new ArrayList<Double>();
                if (points.size() > 1) {
                    double sumx = 0;
                    double sumy = 0;
                    for (int i = 0; i < points.size(); i++) {
                        sumx += points.get(i).getX();
                        sumy += points.get(i).getY();
                    }

                    for (int i = 0; i < points.size(); i++) {
                        // reference change
                        double xt = points.get(i).getX() - sumx / points.size();
                        double yt = points.get(i).getY() - sumy / points.size();
                        double a = Math.toDegrees(Math.atan(yt / xt));

                        if (xt > 0 && yt > 0) {
                            angles.add(360 - a);
                        } else if (xt < 0 && yt > 0) {
                            angles.add(180 - a);
                        } else if (xt < 0 && yt < 0) {
                            angles.add(180 - a);
                        } else {
                            angles.add(-a);
                        }
                    }
                    ArrayList<Integer> lines = new ArrayList<Integer>();
                    Double[] orderedAngles = new Double[angles.size()];
                    for (int i = 0; i < angles.size(); i++) {
                        orderedAngles[i] = angles.get(i);
                    }
                    Arrays.sort(orderedAngles);
                    for (int i = 0; i < orderedAngles.length; i++) {
                        lines.add(angles.indexOf(orderedAngles[i]));
                    }
                    lines.add(lines.get(0));

                    canvas.setLines(lines);
                }

                canvas.repaint();
            }
        });

        reset.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                canvas.setPoints(new ArrayList<Point2D>());
                canvas.setLines(null);
                canvas.repaint();
            }
        });
    }

}
