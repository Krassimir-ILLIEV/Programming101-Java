package Bank;

public class NonExistingBankAccountException extends Exception{

	public NonExistingBankAccountException(String message)
    {
       super(message);
    }
}
