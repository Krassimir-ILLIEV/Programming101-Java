package Shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Order {
	private Map<Integer, Integer> productList;

	public Order(){
	productList=new HashMap<Integer, Integer>();
	}
	
	public void add(int productId, int quantity){
		if(!productList.containsKey(productId)){
		productList.put(productId,quantity);
		} else{
			productList.replace(productId, productList.get(productId)+quantity);
		}
	}
	
	public Set<Entry<Integer,Integer>> myIterator(){
		return productList.entrySet();
	}
}
