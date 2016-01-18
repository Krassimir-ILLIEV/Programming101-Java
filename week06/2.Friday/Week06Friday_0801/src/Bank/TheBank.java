package Bank;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


public class TheBank {
    private static TheBank bank;
    private Path path;
    
	private enum commandsType{help,
		create_bank_account,
		show_history,
		add_money,
		withdraw_money,
	    transfer_money,
	    calculate_amount, 
	    show_existing_bank_accounts
};
	private static ListOfBankAccounts listBA; //=new ListOfBankAccounts();
	
	
	public TheBank(){
	
			String BankDataPath=System.getProperty("user.dir");
			BankDataPath+="/BankData.ser";
			path = FileSystems.getDefault().getPath(BankDataPath);
			
			if(Files.exists(path)){
				listBA=SerializeDeserialize.<TheBank.ListOfBankAccounts>deserialize(path);
				
			} else listBA= new ListOfBankAccounts();
	}
	
	private static class ListOfBankAccounts implements Serializable{
		private HashMap<Long,BankAccount> bankAccountTable; //was private
		private long maxID;
		
		public ListOfBankAccounts(){
			bankAccountTable=new HashMap<Long,BankAccount>();
			maxID=1000;
		}
	}
	
	/*
	 private final Path pathTo = 
	 
			FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week06Friday_0801/src/Bank/TheBank/ListOfBankAccounts");
	
	private void serialize(){
		
		try
	      {
			
	         FileOutputStream fileOut =
	         new FileOutputStream(pathTo.toFile());
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(listBA);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in %s\n",pathTo.toString());
	      }catch(IOException ioe)
	      {
	          ioe.printStackTrace();
	      }
	}
	
	private void deserialize(){
		try
	      {
	         FileInputStream fileIn = new FileInputStream(pathTo.toFile());
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         listBA = (ListOfBankAccounts) in.readObject();
	         in.close();
	         fileIn.close();
	

		 System.out.printf("Deserialized data was read successfully.");
				
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException cnfe)
	      {
	         System.out.println("ListOfBankAccounts class not found");
	         cnfe.printStackTrace();
	         return;
	      }
	}
	*/
	
	
	private void addAccount(BankAccount ba){
		listBA.bankAccountTable.put(ba.getBankAccountNumber(),ba);
	}
	
	private boolean isExistingBankAccount(long BankAccountNumber){
		return listBA.bankAccountTable.containsKey(BankAccountNumber);
	}
	
	public String toString(){
		StringBuilder listOfAccounts=new StringBuilder();
		for(Entry<Long, BankAccount> entry:listBA.bankAccountTable.entrySet()){
			listOfAccounts.append(entry.getValue().toString()+System.lineSeparator());
		}
		return listOfAccounts.toString();
	}
	
	private BankAccount getBankAccount(long bankAccountNumber){ 
		return listBA.bankAccountTable.get(bankAccountNumber);
	}
	
	private long create_bank_account(String firstName, 
			String lastName, 
			String stringAge,
			String interestTypeInput) throws IllegalArgumentException{
		
		int age=Integer.parseInt(stringAge);
		
		BankAccount ba = new BankAccount(listBA.maxID, firstName, 
				lastName, 
				age,
				interestTypeInput);
		listBA.maxID=ba.getBankAccountNumber()+1;
		addAccount(ba);
		return ba.getBankAccountNumber();
	}
	
	private String show_history(String sbankAccountNumber) 
			throws NonExistingBankAccountException{
		long bankAccountNumber=Long.parseLong(sbankAccountNumber);
		if(bank.isExistingBankAccount(bankAccountNumber)){
			return getBankAccount(bankAccountNumber).getHistory();
		} throw new NonExistingBankAccountException("Please enter a correct account number.");
		
	}
	
	private void add_money(String sbankAccountNumber, String samountToAdd)
	throws NonExistingBankAccountException{
		long bankAccountNumber=Long.parseLong(sbankAccountNumber);
		double amountToAdd=Double.parseDouble(samountToAdd);
		
	if(bank.isExistingBankAccount(bankAccountNumber)) {
		BankAccount bankAccount=getBankAccount(bankAccountNumber);
		bankAccount.add(amountToAdd);
	} else throw new NonExistingBankAccountException("Please enter a correct account number.");
	
	}
	
	private void withdraw_money(String sbankAccountNumber, String samountToWithdraw) 
			throws InsufficientFundsException, BlockedAccountException,NonExistingBankAccountException{
		long bankAccountNumber=Long.parseLong(sbankAccountNumber);
		double amountToWithdraw=Double.parseDouble(samountToWithdraw);
		
	if(bank.isExistingBankAccount(bankAccountNumber)) {
		BankAccount bankAccount=getBankAccount(bankAccountNumber);
		bankAccount.withdraw(amountToWithdraw);
	} else throw new NonExistingBankAccountException("Please enter a correct account number.");
	
	}
	
	private void transfer_money(String sbankAccountNumberFrom, String sbankAccountNumberTo, String samountToTransfer) 
			throws InsufficientFundsException,NonExistingBankAccountException,BlockedAccountException{
		long bankAccountNumberFrom=Long.parseLong(sbankAccountNumberFrom);
		long bankAccountNumberTo=Long.parseLong(sbankAccountNumberTo);
		double amountToTransfer=Double.parseDouble(samountToTransfer);
		
	if(bank.isExistingBankAccount(bankAccountNumberFrom) && bank.isExistingBankAccount(bankAccountNumberTo)) {
		BankAccount bankAccountFrom=getBankAccount(bankAccountNumberFrom);
		BankAccount bankAccountTo=getBankAccount(bankAccountNumberTo);
		bankAccountFrom.transferTo(bankAccountTo, amountToTransfer);
		} else throw new NonExistingBankAccountException("Please enter a correct account number.");
	
	}
	
	private double calculate_amount(String sbankAccountNumber, String snumberOfMonths)
	throws NonExistingBankAccountException{
		long bankAccountNumber=Long.parseLong(sbankAccountNumber);
		int numberOfMonths=Integer.parseInt(snumberOfMonths);
	    double balancePlusInterest=0.0;
		if(bank.isExistingBankAccount(bankAccountNumber)){
			BankAccount bankAccount=getBankAccount(bankAccountNumber);
			balancePlusInterest= bankAccount.getAccountBalanceInterest(numberOfMonths);
		} else throw new NonExistingBankAccountException("Please enter a correct account number.");
		
		return balancePlusInterest;
	}
	
	private static void bankInterpreter(){
		 bank= new TheBank();
		Scanner reader=new Scanner(System.in);
		String doItAgain="y";
		
		while(doItAgain.toUpperCase().equals("Y")){
	
				try{
				
					System.out.print("\nEnter command: ");
			     	String commandAndArgs = reader.nextLine();
					commandAndArgs=commandAndArgs.replaceAll(","," ");
					commandAndArgs=commandAndArgs.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();
					
					String[] commandsSplit=commandAndArgs.split(" ");
					
					switch (commandsType.valueOf(commandsSplit[0].toLowerCase())){
					case help:
						    System.out.println("Available commands: ");
							System.out.println("create_bank_account <first name> <last name> <age> <SIMPLE/COMPOUNDED>");
							System.out.println("show_history <account number>");
							System.out.println("add_money <account number> <amount to add>");
							System.out.println("withdraw_money <account number> <amount to withdraw>");
							System.out.println("transfer_money <from account number> <to account number> <amount to transfer>");
							System.out.println("calculate_amount <account number> <number of months>");
					break;
							
				case create_bank_account: 
					Long bankAccountNumber=bank.create_bank_account(commandsSplit[1],commandsSplit[2],commandsSplit[3],commandsSplit[4]); 
				
					System.out.printf("Bank account %d was created successfully!\n",bankAccountNumber);
				break;
	
				case show_history: System.out.println(bank.show_history(commandsSplit[1]));
				break;
				
				case add_money:  bank.add_money(commandsSplit[1],commandsSplit[2]);
				System.out.printf("$%s was added to bank account#%s.\n",commandsSplit[2],commandsSplit[1]);
				break;
				
				case withdraw_money: bank.withdraw_money(commandsSplit[1],commandsSplit[2]);
				System.out.printf("$%s was withdrawn from bank account#%s.\n",commandsSplit[2],commandsSplit[1]);
				break;
				
				case transfer_money: bank.transfer_money(commandsSplit[1],commandsSplit[2],commandsSplit[3]);
				System.out.printf("$%s was tansferred from bank account#%s to bank account#%s.\n",commandsSplit[3],commandsSplit[1],commandsSplit[2]);
				break;
				
				case calculate_amount: bank.calculate_amount(commandsSplit[1],commandsSplit[2]);
				System.out.printf("The balance of bank account#%s after %s months will be $%s.\n",commandsSplit[1],commandsSplit[2],commandsSplit[3]);
				break;
				
				case show_existing_bank_accounts: 
					System.out.println(bank.toString());
				};
			
				}
			catch(Exception e){
				//Code for error recovery
				System.out.println(e.getClass().getName());
				System.out.println(e.getMessage());
				//Consume the trailing newline due to bad input
				//reader.nextLine();
				switch (e.getClass().getName()) {
				case "InsufficientFundsException":
					System.out.println(e.getMessage());
					break;

				case "NonExistingBankAccountException":
					System.out.println(e.getMessage());
					break;
					
				case "BlockedAccountException":
					System.out.println(e.getMessage());
					break;
					
				case "java.lang.IllegalArgumentException":
					System.out.println("Please provide a valid argument.");
				
				case "java.lang.NumberFormatException": 
					System.out.println("Please provide a valid number.");
					
				default:
					break;
				}
			}
		
				System.out.print("\nContinue? (y/n)? ");
			//Consume the trailing end of line
			//reader.nextLine();
			doItAgain=reader.nextLine();
		}
		SerializeDeserialize.<TheBank.ListOfBankAccounts>serialize(listBA,bank.path);
		
		System.out.print("\nGoodbye!\n");
	}
	
		
	public static void main(String[] args) throws Exception{
		
		/*
		BankAccount baK=new BankAccount("Krassimir","Illiev",29,"compounded");
		baK.add(1000);
		String BankDataPath=System.getProperty("user.dir");
		BankDataPath+="/BankData.ser";
		Path path = FileSystems.getDefault().getPath(BankDataPath);
		HashMap<Long,BankAccount> bankAccountTable=new HashMap<Long,BankAccount>();
		bankAccountTable.put(baK.getBankAccountNumber(),baK);
		ListOfBankAccounts listBA=new ListOfBankAccounts();
		listBA.bankAccountTable.put(baK.getBankAccountNumber(),baK);
		
		SerializeDeserialize.<ListOfBankAccounts>serialize(listBA, path);
		//System.out.println(bankAccountTable.toString());
		System.out.println("----------------");
		ListOfBankAccounts baK1=SerializeDeserialize.<ListOfBankAccounts>deserialize(path);
		System.out.println(baK1.toString());
		
		*/
		
		//BankAccount baY=new BankAccount("Yuliy","Iliev",56,"compounded");
		//baK.setAccountBalance(100);
		//baY.add(50);
		//baK.transferTo(baY, 50);
		
		//System.out.println(baK);
		//System.out.println(baY);
			
		//TheBank tb=new TheBank();
		//bank=tb;
		
		//tb.addAccount(baK);
		//tb.addAccount(baY);
		//System.out.println(tb);
		
		/*
		tb.create_bank_account("Y","I","50","SIMPLE");
		tb.create_bank_account("K","I","20","compounded");
		tb.add_money("10001","100");
		tb.transfer_money("10001","10002","100");
		//tb.withdraw_money("10002", "100");
		System.out.println(tb.calculate_amount("10001","12"));
		System.out.println(tb.calculate_amount("10002","1"));
		System.out.println(tb.show_history("10001"));
		System.out.println(tb.show_history("10002"));
		 
		 */
		
		
		bankInterpreter();
		
	}
}
