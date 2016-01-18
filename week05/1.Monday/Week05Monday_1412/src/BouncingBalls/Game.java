package BouncingBalls;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import javax.swing.*;
import java.awt.*;


public class Game {

	LinkedList<Ball> balls;
	double width;
	double height;

	
	private static class RectDraw extends JPanel {
	    public void paintComponent(Graphics g) {
	    super.paintComponent(g);  
	     g.drawRect(0,0,100,50);  
	     g.setColor(Color.RED);  
	     g.fillRect(0,0,10,10);  
	    }
	    }
	
	class DrawPanel extends JPanel {

	    private void doDrawing(Graphics g) {

	        Graphics2D g2d = (Graphics2D) g;

	        g2d.setColor(Color.blue);

	        for (int i = 0; i <= 1000; i++) {

	            Dimension size = getSize();
	            Insets insets = getInsets();

	            int w = size.width - insets.left - insets.right;
	            int h = size.height - insets.top - insets.bottom;

	            Random r = new Random();
	            int x = Math.abs(r.nextInt()) % w;
	            int y = Math.abs(r.nextInt()) % h;
	            g2d.drawLine(x, y, x, y);
	        }
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }
	}
	public Game(double width, double height){
		this.width=width;
		this.height=height;
		balls=new LinkedList<Ball>();
		
		
		JPanel content = new JPanel();
		content.setBackground(Color.BLACK);
		RectDraw r=new RectDraw();
		 content.add(r);
        JButton okButton= new JButton("OK");
        JButton clearButton= new JButton("Clear");
        content.add(okButton);
        content.add(clearButton);
        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(250,100);
        window.setLocation(100,100);
        //window.setVisible(true);
		
		
		
		
		
		JFrame fr=new JFrame("theGUI");
		//Container pane=getContentPane();
		
		  fr.setSize((int) width,(int) height);
	      fr.setLocation(100,100);
	     ///JPanel panel1=new JPanel();
	     ///JPanel panel2=new JPanel();
	     //panel1.setBounds(0, 0,500,1000);
	     //fr.setLayout(new GridLayout(2,1));
	     //fr.add(panel1);
			DrawPanel dp=new DrawPanel();

	      dp.setSize(10, 50);
	     fr.add(dp);
	      
	      fr.setVisible(true);		
	}
	
	
	public void moveAll(){
		for(Ball b: balls){
			b.move(0.1,width,height);
		}
	}
	public static void main(String[] args){
		Game game=new Game(500,200);
	}
}
