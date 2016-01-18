package Bank;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BankAccount implements Serializable{
	private enum interestT {COMPOUNDED, SIMPLE};  //compounded and simple
	private enum operationsT {CREATE, ADD, WITHDRAW, TRANSFER};
	private static final double DEFAULT_INT_RATE=0.0012;
	
	private long bankAccountNumber;
	private Person person;
	private double accountBalance;
	private interestT interestType;
	private double interestRate;
	private History accounHistory;

	private boolean isNullOrEmpty(String str){
		
		return str==null || str.isEmpty();
	}
	
	public BankAccount(long ID, String firstName, 
			String lastName, 
			int age,
			String interestTypeInput) throws IllegalArgumentException{
		
		
		if(age<18 || isNullOrEmpty(firstName) || isNullOrEmpty(lastName))
			throw new IllegalArgumentException("Age must be an integer greater than 18 and names must not be empty strings");
		
		
		
		person=new Person(firstName, lastName);
		setAge(age);
		//clientFirstName=firstName; //^[\p{L}\s'.-]+$ <----regex to check name
	
	
		
		accounHistory=new History();
		try{
		
			
			interestType=interestT.valueOf(interestTypeInput.toUpperCase());
		}
		catch(Exception e){
				throw new IllegalArgumentException("InterestType can only be COMPOUNDED or SIMPLE"); 
			
		}
		
		
		interestRate=DEFAULT_INT_RATE;
		
		accounHistory.addToHistory(operationsT.CREATE, 0);
		
		bankAccountNumber=ID; 
		
	}

	
	
	//Your regex ^[0-9] matches anything beginning with a digit, including strings like "1A". To avoid a partial match, append a $ to the end:

		//^[0-9]*$

		//This accepts any number of digits, including none. To accept one or more digits, change the * to +. To accept exactly one digit, just remove the *.

		//UPDATE: You mixed up the arguments to IsMatch. The pattern should be the second argument, not the first:

	//regex Code to check a number, change * to + to allow at least 1 digit
	
	//if (!System.Text.RegularExpressions.Regex.IsMatch(textbox.Text, "^[0-9]*$"))
		
		
	public long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public String getClientFirstName() {
		return person.getFirstName();
	}

	public void setClientFirstName(String clientFirstName) {
		person.setFirstName(clientFirstName);
	}

	public String getClientLastName() {
		return person.getLastName();
	}

	public void setClientLastName(String clientLastName) {
		person.setLastName(clientLastName);
	}

	public int getAge() {
		return person.getAge();
	}

	public String getHistory(){
		return accounHistory.toString();
	}
	
	public void setAge(int age) {
		
		
		Calendar calendarToday=Calendar.getInstance();
		calendarToday.setTime(new Date());
		int yearOfBirth=calendarToday.get(Calendar.YEAR)-age;
		person.setBirthYear(yearOfBirth);
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	
	public double getAccountBalanceInterest(int numberOfMonths){
		
		double balanceInterest=getBalance();
		//interestRate;
		//accountBalance
		
		switch (interestType){
		case SIMPLE:
			balanceInterest +=balanceInterest*interestRate/12*numberOfMonths;
			break;
		case COMPOUNDED:
			balanceInterest=balanceInterest*Math.pow((1+interestRate/12),numberOfMonths);
			break;
		}
		
		return balanceInterest;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = 0.0;
		add(accountBalance);
	}



	public interestT getInterestType() {
		return interestType;
	}



	public void setInterestType(interestT interestType) {
		this.interestType = interestType;
	}



	public double getInterestRate() {
		return interestRate;
	}



	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}



	public void add(double amountToAdd){
		accountBalance +=amountToAdd;
		
		accounHistory.addToHistory(operationsT.ADD,amountToAdd);
	}
	
	private double getBalance(){ //
		return accountBalance;
	}
	
	public void withdraw(double amountToRemove) throws InsufficientFundsException, BlockedAccountException{
		if(getBalance()<amountToRemove)
			throw new InsufficientFundsException("Insufficient Funds.");
		if(getInterestRate()>0.01) 
			throw new BlockedAccountException("Illegal operation; Interest rate="+getInterestRate());
		
		
		
		accountBalance -=amountToRemove;
		accounHistory.addToHistory(operationsT.WITHDRAW,amountToRemove);	
	}
	
	public void transferTo(BankAccount accountTo,double amountToTransfer) 
			throws InsufficientFundsException,NonExistingBankAccountException,BlockedAccountException{
				
		if(getBalance()<amountToTransfer){
			throw new InsufficientFundsException("InsufficientFunds");
		}
		accounHistory.addToHistory(operationsT.TRANSFER,0.0);	
		withdraw(amountToTransfer);
		accountTo.accounHistory.addToHistory(operationsT.TRANSFER,0.0);
		accountTo.add(amountToTransfer);
		
	}
	
	public String toString(){
		return String.format("Bank account# %d, balance: %.2f, interest rate: %.4f, interest type: %s, client: %s \n history: \n%s",
				bankAccountNumber, accountBalance, interestRate,interestType, person, accounHistory);
	}
	
	private static class HistoryItem implements Serializable{
		private operationsT operationType;
		private double amount;
		private Date date; 
		
		public HistoryItem(operationsT o, double amount){
			operationType=o;
			this.amount=amount;
			date=new Date();
		}
		
		public String toString(){
			return String.format("Date: %s, operation: %s, amount: $%.2f \n", date,operationType,amount);
		}
		
		
	}
	
	private static class History implements Serializable{
		private ArrayDeque<HistoryItem> q;
		
		public History(){
		q=new ArrayDeque<HistoryItem>(5);
		}
		
		public void addToHistory(operationsT o, double amount){
			if(!q.isEmpty()){
					HistoryItem lastItem=q.getLast();
					if(lastItem.operationType.equals(operationsT.TRANSFER) && lastItem.amount==0.0){
						
						switch(o){
						case ADD:
							lastItem.amount=amount;
							break;
						case WITHDRAW:
							lastItem.amount=-amount;
							break;
			            }
						
						return;
					   }
			}
			
			if(q.size()>5){
				q.remove();
			}
			
			HistoryItem hi=new HistoryItem(o,amount);
			q.add(hi);
		}
		
		public String toString(){
			StringBuilder historyToPrint=new StringBuilder();
			for(HistoryItem h:q){
				historyToPrint.append(h);
			}
			
			return historyToPrint.toString();
		}
	}
	
	private class Person implements Serializable{
		
		private String clientFirstName;
		private String clientLastName;
		private int birthYear; //was birthDate
		
		public Person(String firstName, String lastName){
			clientFirstName=firstName;
			clientLastName=lastName;
			//setBirthYear(yearOfBirth);
		}
		
		public int getAge(){
			Calendar calendarToday=Calendar.getInstance();
			calendarToday.setTime(new Date());
			Calendar calendarBirthDay=Calendar.getInstance();
			//calendarBirthDay.setTime(birthDate);
			//int age=calendarToday.get(Calendar.YEAR) - calendarBirthDay.get(Calendar.YEAR);
			int age=calendarToday.get(Calendar.YEAR)-birthYear;
			//if (calendarToday.get(Calendar.DAY_OF_YEAR) <= calendarBirthDay.get(Calendar.DAY_OF_YEAR))
				//age--;
				return age;
		}
		
		public void setBirthYear(int birthYear){
			this.birthYear=birthYear;
		}
		
		public String getFirstName(){
			return clientFirstName; 
		}
		
		public String getLastName(){
			return clientLastName; 
		}
		
		public void setFirstName(String firstName){
			clientFirstName=firstName; 
		}
		
		public void setLastName(String lastName){
			clientLastName=lastName; 
		}
		
		public String toString(){
			return String.format("%s %s,%d",clientFirstName, clientLastName,getAge());
		}
		
		
	}
}
