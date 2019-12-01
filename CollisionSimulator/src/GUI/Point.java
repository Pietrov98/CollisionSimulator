package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Point extends JPanel implements Runnable {

        Color color;
        int diameter;
        long delay;
        private int vx;
        private int vy;
        private List<Point> otherMoveables = new ArrayList();
    	
        public int getVx()
        {
			return vx;
        }
        
        public int getVy()
        {
			return vy;
        }
        
        public void setMoveables(List<Point> moveables)
        {
        	this.otherMoveables = moveables;
        }

        public Point(int ballcolor, int xvelocity, int yvelocity) {
            if (ballcolor == 1) {
                color = Color.red;
            } else if (ballcolor == 2) {
                color = Color.blue;
            } else if (ballcolor == 3) {
                color = Color.black;
            } else if (ballcolor == 4) {
                color = Color.cyan;
            } else if (ballcolor == 5) {
                color = Color.darkGray;
            } else if (ballcolor == 6) {
                color = Color.gray;
            } else if (ballcolor == 7) {
                color = Color.green;
            } else if (ballcolor == 8) {
                color = Color.yellow;
            } else if (ballcolor == 9) {
                color = Color.lightGray;
            } else if (ballcolor == 10) {
                color = Color.magenta;
            } else if (ballcolor == 11) {
                color = Color.orange;
            } else if (ballcolor == 12) {
                color = Color.pink;
            } else if (ballcolor == 0) {
                color = Color.white;
            }
            diameter = 10;
            delay = 50;

            vx = xvelocity;
            vy = yvelocity;

            new Thread(this).start();

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int x = getX();
            int y = getY();
            this.setSize(this.diameter+2, this.diameter+2);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(color);
            g.fillOval(0, 0, this.diameter, this.diameter); //adds color to circle
            g.setColor(Color.black);
            g2.drawOval(0, 0, this.diameter, this.diameter); //draws circle
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(diameter, diameter);
        }

        public void run() {

            try {
                // Randamize the location...
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        int x = (int) (Math.round(Math.random() * getParent().getWidth()));
                        int y = (int) (Math.round(Math.random() * getParent().getHeight()));

                        setLocation(x, y);
                    }
                });
            } catch (InterruptedException exp) {
                exp.printStackTrace();
            } catch (InvocationTargetException exp) {
                exp.printStackTrace();
            }

            while (isVisible()) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }

                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            move();
                            repaint();
                          
                        }
                    });
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                } catch (InvocationTargetException exp) {
                    exp.printStackTrace();
                }
            }
        }

        public void move() {

            int x = getX();
            int y = getY();

            if (x + vx < 0 || (x + diameter + vx) > getParent().getWidth()) {
                vx *= -1;
            }
            if (y + vy < 0 || (y + diameter + vy) > getParent().getHeight()) {
                vy *= -1;
            }
           
            	/*if((x + vx - diameter/2) < (moveables.get(0).getVx() + moveables.get(0).getX()) && (x + vx + diameter/2) > (moveables.get(0).getVx() + moveables.get(0).getX()))
            	{
                	if((y + vy - diameter/2) < (moveables.get(0).getVy() + moveables.get(0).getY()) && (x + vx + diameter/2) > (moveables.get(0).getVy() + moveables.get(0).getY()))
                	{
                		System.out.println(this.getName() + moveables.get(0).getVx() + " " + moveables.get(0).getX());
                		vx *= -1;
                		vy *= -1;
                	}
            		
            	}*/
           /* if((x + vx - diameter/2 - 1) > (moveables.get(0).getX() + moveables.get(0).getVx() + diameter/2))
            {
            	if((y + vy - diameter/2 - 1) > (moveables.get(0).getY() + moveables.get(0).getVy() + diameter/2))
                {
                	vy *= -1;
                	vx *= -1;
                }
            	
            }*/
            
            
            //System.out.println(this.getLocationOnScreen());
            
            x += vx;
            y += vy;

            // Update the size and location...
            setSize(getPreferredSize());
            setLocation(x, y);

        }
    }
