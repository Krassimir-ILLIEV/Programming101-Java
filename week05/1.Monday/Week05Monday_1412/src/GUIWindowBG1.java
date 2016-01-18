import javax.swing.*;
import java.awt.*;

public class GUIWindowBG1{

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
pane.setLayout(new GridLayout(3,1));
pane.add(panel_white);
pane.add(panel_green);
pane.add(panel_red);
theGUI.setVisible(true);

}
}