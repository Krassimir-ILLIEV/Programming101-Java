package _35_creditCardValidation;

public class Problem35 {
	// CreditCardValidation
	public static boolean is_credit_card_valid(String number) {
		if (number.length() % 2 == 0)
			return false;
		int sum = 0;
		int currentNumber;
		for (int i = 0; i < number.length(); i++) {
			currentNumber = Character.getNumericValue(number.charAt(i));
			if (currentNumber == -1)
				return false;
			if (i % 2 != 0) {
				sum += currentNumber * 2;
			} else
				sum += currentNumber;
		}
		System.out.println(sum);
		return sum % 10 == 0;

	}

	public static void main(String[] args) {
		System.out.println(is_credit_card_valid("79927398715"));
		System.out.println(is_credit_card_valid("79927398713"));
	}
}
