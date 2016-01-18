package _02_Pair;

public class Pair<Item1, Item2> {
	Item1 item1;
	Item2 item2;




	public void setItem1(Item1 item1){
		this.item1=item1;
	}
	
	public void setItem2(Item2 item2){
		this.item2=item2;

	}
	
	public Item1 getItem1(){

		return item1;
	}
	
	public Item2 getItem2(){

		return item2;
	}
	
	public static void main(String[] args){
		Pair<Double, String> p=new Pair<Double, String>();
		p.setItem2("67.0");
		System.out.println(p.getItem2());
		
	}
}

