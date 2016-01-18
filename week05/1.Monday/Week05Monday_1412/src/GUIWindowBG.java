import javax.swing.*;
import java.awt.*;

public class GUIWindowBG{

public static void main(String[] args){
JFrame theGUI=new JFrame();
theGUI.setTitle("Bulgaria");
theGUI.setSize(300,200);
theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel_white=new JPanel();
panel_white.setBackground(Color.white);
JPanel panel_green=new JPanel();
panel_green.setBackground(Color.green);
JPanel panel_red=new JPanel();
panel_red.setBackground(Color.red);
Container pane=theGUI.getContentPane();
pane.add(panel_white,BorderLayout.NORTH);
pane.add(panel_green,BorderLayout.CENTER);
pane.add(panel_red,BorderLayout.SOUTH);
theGUI.setVisible(true);

}
}