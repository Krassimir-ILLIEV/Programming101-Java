package Bank;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TheBankGUI extends JFrame {

	
	//help,
	//create_bank_account,
	//show_history,
	//add_money,
	//withdraw_money,
    //transfer_money,
    //calculate_amount 
    
	
		//private JLabel celsiusLabel    =new JLabel("Degrees Celsius");
	    private JComboBox operationsList;
	    private JTextField createBAFirstNameField=new JTextField("");
	    private JTextField createBALastNameField=new JTextField("");
	    private JTextField createBAAgeField=new JTextField("");
	    private JTextField createBAIntTypeField=new JTextField("");
	    private JButton createBankAccountButton  =new JButton("create_bank_account");
		
		//Constructor
		public TheBankGUI(){
			String[] petStrings = "help,create_bank_account,show_history,add_money,withdraw_money,transfer_money,calculate_amount".split(",");
			JComboBox petList = new JComboBox(petStrings);
			petList.addActionListener(new createBankAccountListener());

			//Set up panels to organize widgets and
			//add them to the window
			JPanel dataPanel=new JPanel(new GridLayout(1,5));
			//dataPanel.add(fahrLabel);
			//dataPanel.add(celsiusLabel);
			setSize(1000,20);
	       
			dataPanel.add(createBAFirstNameField);
			dataPanel.add(createBALastNameField);
			dataPanel.add(createBAAgeField);
			dataPanel.add(createBAIntTypeField);
			
			
			JPanel buttonPanel=new JPanel();
			buttonPanel.setSize(200, 20);
			//buttonPanel.add(fahrButton);
			buttonPanel.setLayout(new GridLayout(1, 1));
			//buttonPanel.add(createBankAccountButton);
			buttonPanel.add(petList);
			//createBankAccountButton.setLocation(10,30);
			Container container=getContentPane();
			container.setLayout(new GridLayout(1, 2));
			//container.setSize(300, 30);
			container.add(buttonPanel);
			container.add(dataPanel);
			
			//Attach a listener to the convert button
			createBankAccountButton.addActionListener(new createBankAccountListener());
			//celsiusButton.addActionListener(new CelsiusListener());
			
		}
		
		// >>>>>>>>>> The controller <<<<<<<<<<<<
		
		private class createBankAccountListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				try{
					//String s=e.getSource().getClass().getName();
					operationsList=(JComboBox)e.getSource();
					String operation=operationsList.getSelectedItem().toString();
			
					createBAFirstNameField.setText(operation);
					if (operation.equals("add_money")){
						createBAAgeField.setVisible(false);
					} else {
						createBAAgeField.setVisible(true);
					}
				
				String firstName=createBAFirstNameField.getText();      //Obtain input
				String lastName=createBALastNameField.getText();
				String age=createBAAgeField.getText();
				String intType=createBAAgeField.getText();
		
				
				//double fahr = Double.parseDouble(input); //Convert to a double
				//thermo.setFahrenheit(fahr);              //Reset thermometer
				//double celsius=thermo.getCelsius();      //Obtain Celsius
				//celsiusField.setText(""+celsius);        //Output result
				
				}catch(Exception ex){
					JOptionPane.showMessageDialog(TheBankGUI.this,"Bad number format","Temperature Converter",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
			public static void main(String[] args){
				TheBankGUI theGUI=new TheBankGUI();
				theGUI.setTitle("KTB2");
				theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//theGUI.pack();
				theGUI.setVisible(true);//Make the window visible
				
			}
		}

