package mg.facedev.algorithm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/** Canvas to display the points and the hull.
 * @author Marius Rabenarivo <marius@espa-tana.mg>
 */
public class Canvas extends JPanel implements MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** Width of the canvas. */
    final int CANVAS_WIDTH = 400;
    /** Height of the canvas. */
    final int CANVAS_HEIGHT = 400;
    /** Radius of the points. */
    final int POINT_RADIUS = 5;
    /** List of the points. */
    private ArrayList<Point2D> points;
    /** List of the index of the points in the hull. */
    private ArrayList<Integer> lines;
    /**
     * Constructor of the Canvas.
     */
    public Canvas() {
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setBackground(Color.WHITE);
        points = new ArrayList<Point2D>();
        lines = new ArrayList<Integer>();
        this.addMouseListener(this);
    }

    public void paint(final Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        if (points != null) {
            for (int i = 0; i < points.size(); i++) {
                int x = (int) points.get(i).getX();
                int y = (int) points.get(i).getY();
                g.drawOval(x - POINT_RADIUS, y - POINT_RADIUS,
                           2 * POINT_RADIUS, 2 * POINT_RADIUS);
            }
        }
        if (lines != null && lines.size() > 1) {
            for (int i = 0; i < lines.size() - 1; i++) {
                int x1 = (int) points.get(lines.get(i)).getX();
                int y1 = (int) points.get(lines.get(i)).getY();
                int x2 = (int) points.get(lines.get(i + 1)).getX();
                int y2 = (int) points.get(lines.get(i + 1)).getY();
                g.drawLine(x1, y1, x2, y2);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        points.add(new Point(arg0.getX(), arg0.getY()));
        this.repaint();

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    public ArrayList<Point2D> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point2D> points) {
        this.points = points;
    }

    public void setLines(ArrayList<Integer> lines) {
        this.lines = lines;
    }

}
