package mg.facedev.algorithm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    Canvas canvas;
    
    JPanel buttons;
    JButton trace, reset;
    
    ArrayList<Point2D> points;
    
    public MainWindow() {
        setSize(new Dimension(500, 400));
        canvas = new Canvas();
        setContentPane(canvas);
        buttons = new JPanel();
        trace = new JButton("Tracer");
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
                points = canvas.getPoints();
                double sumx = 0;
                double sumy = 0;
                for (int i=0;i<points.size();i++) {
                    sumx += points.get(i).getX();
                    sumy += points.get(i).getY();
                }
                int xg = (int)sumx/points.size();
                int yg = (int)sumy/points.size();
                canvas.setG(new Point(xg, yg));
                /*
                if (points.size()>1) {
                    ArrayList<Integer> lines = new ArrayList<Integer>();
                    for (int i=0; i < points.size()-1; i++) {
                        lines.add(i);
                        lines.add(i+1);
                    }
                    lines.add(0);
                    canvas.setLines(lines);
                    canvas.repaint();
                }
                */
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
                //canvas.setLines(new ArrayList<Integer>());
                canvas.repaint();
            }
        });
    }
    
}
