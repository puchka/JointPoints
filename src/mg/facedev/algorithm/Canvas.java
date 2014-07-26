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

public class Canvas extends JPanel implements MouseListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Point2D> points;
    //private ArrayList<Integer> lines;
    private Point2D g;

    public Canvas() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        points = new ArrayList<Point2D>();
        //lines = new ArrayList<Integer>();
        g = null;
        this.addMouseListener(this);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for (int i=0; i<points.size(); i++) {
            int x = (int)points.get(i).getX();
            int y = (int)points.get(i).getY();
            g.drawOval(x-5, y-5, 10, 10);
        }
        /*
        if (lines.size()>1) {
            for (int i=0; i<lines.size()-1; i++) {
                int x1 = (int) points.get(lines.get(i)).getX();
                int y1 = (int) points.get(lines.get(i)).getY();
                int x2 = (int) points.get(lines.get(i+1)).getX();
                int y2 = (int) points.get(lines.get(i+1)).getY();
                g.drawLine(x1, y1, x2, y2);
            }
        }
        */
        if (this.g!=null)
            g.fillOval((int)this.g.getX()-5, (int)this.g.getY()-5, 10, 10);
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
    /*
    public void setLines(ArrayList<Integer> lines) {
        this.lines = lines;
    }
    */
    public void setG(Point2D g) {
        this.g = g;
    }
    
}
