package VAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class VatTaxCalculator_my {
	private String defaultCountryId="Neverland";

	Hashtable<String,CountryVatTax> ht;
	public VatTaxCalculator_my(List<CountryVatTax> l){
		ht=new Hashtable<String,CountryVatTax>();
		for(CountryVatTax c: l){
			if(!ht.containsKey(c.getCountryId())){
				ht.put(c.getCountryId(), new CountryVatTax(c));
				if(c.getisDefault()) {defaultCountryId=c.getCountryId();}
			}
		}
		
	}
	
	//NotSupportedCountryException extends Exception{
//}
	public double CalculateTax(double productPrice, String countryId) throws NotSupportedCountryException{
		if(ht.containsKey(countryId)) 
			{return productPrice*(ht.get(countryId).getVATTax());}
		else throw new NotSupportedCountryException("No such country in database");
		//throw new NotSupportedCountryException("You might want to check your country.")
	}
	
	public double CalculateTax(double productPrice) throws NotSupportedCountryException{
		return CalculateTax(productPrice, defaultCountryId);
	}
		public static void main(String[] args){
			CountryVatTax Bulgaria=new CountryVatTax("BG",0.2,true);
			CountryVatTax Austria=new CountryVatTax("AT",0.2,false);
			CountryVatTax Germany=new CountryVatTax("DE",0.19,true);
			//CountryVatTax[] arrayCountry={Bulgaria,Austria,Germany};
			ArrayList<CountryVatTax> countryList=new ArrayList<CountryVatTax>(Arrays.asList(Bulgaria,Austria,Germany));
			
		}
}
