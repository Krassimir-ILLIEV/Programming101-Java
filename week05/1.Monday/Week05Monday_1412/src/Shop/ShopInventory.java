package Shop;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import VAT.Country;
import VAT.CountryManager;
import VAT.CountryVatTax;
import VAT.NotSupportedCountryException;

public class ShopInventory {
	
	Hashtable<Integer, Product> ht;
	
	public ShopInventory(){
		ht=new Hashtable<Integer, Product>();
	}

	public void add(Product p){
		ht.put(p.getProductId(),p);
	}
	
	public double requestOrder(Order o) throws NotSupportedCountryException,NotAvailableInInventoryException {
		double totalBill=0;
		for(Entry<Integer,Integer> entry: o.myIterator()){
			int id=entry.getKey();
			
			int quantity=entry.getValue();
			if(!ht.containsKey(id) || ht.get(id).getQuantity()<quantity){
				throw new NotAvailableInInventoryException("No such product in inventory or available in insufficient quantity");
			}
			
			
			//double priceBeforeTax=ht.get(id).getPriceBeforeTax();
			double priceAfterTax=ht.get(id).getPriceAfterTax();
			totalBill +=priceAfterTax*quantity;
		}
		return totalBill;
	}
	
	public double Audit() throws NotSupportedCountryException{
		double revenue=0;
		for(Entry<Integer,Product> entry: ht.entrySet()){
			Product p=entry.getValue();
			//double priceBeforeTax=p.getPriceBeforeTax();
			double priceAfterTax=p.getPriceAfterTax();
			revenue +=priceAfterTax*p.getQuantity();
		}
		return revenue;
	}
	
	public static void main(String[] args) throws NotSupportedCountryException, NotAvailableInInventoryException {
			
		Country Bulgaria=new Country("BG", "Bulgaria",true,0.2);
		Country Austria=new Country("AT","Austria",false,0.2);
		Country Germany=new Country("DE","Germany",false,0.19);
		
			//CountryVatTax Bulgaria=new CountryVatTax("BG",0.2,true);
			//CountryVatTax Austria=new CountryVatTax("AT",0.2,false);
			//CountryVatTax Germany=new CountryVatTax("DE",0.19,true);
		
			CountryManager cm= CountryManager.getInstance();
			cm.add(Bulgaria);
			cm.add(Austria);
			cm.add(Germany);

		ShopInventory s=new ShopInventory();
		Product p1=new Product(1,"olive oil",20,"BG",333);
		Product p2=new Product(2,"oil",2,"BG",444);
		s.add(p1);
		s.add(p2);
		
		System.out.println(s.Audit());
		
		Order o=new Order();
		o.add(1,1);
		o.add(2,1);
		double totalBill=s.requestOrder(o);
		System.out.println(totalBill);
		
	}
	}
	

