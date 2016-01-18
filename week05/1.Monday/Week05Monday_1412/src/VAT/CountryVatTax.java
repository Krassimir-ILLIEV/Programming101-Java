package VAT;

public final class CountryVatTax {
	private String countryId;
	private double VATTax;
	private boolean isDefault;
	
public CountryVatTax(String countryId,double VATTax, boolean isDefault){
this.countryId=countryId;
this.VATTax=VATTax;
this.isDefault=isDefault;
}

public CountryVatTax(CountryVatTax c){
this.countryId=c.countryId;
this.VATTax=c.VATTax;
this.isDefault=c.isDefault;
}

public String getCountryId(){
	return countryId;
}
public double getVATTax(){
	return VATTax;
}
public boolean getisDefault(){
	return isDefault;
}
}
