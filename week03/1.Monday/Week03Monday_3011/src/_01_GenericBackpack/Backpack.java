package _01_GenericBackpack;

public class Backpack<Item> {
	Item item;

	public Item getItem(){
		return item;
	}
	
	public void setItem(Item item){
		this.item=item;
	}
	
	public static void main(String[] args){
		Backpack<String> bp=new Backpack<>();
		bp.setItem("2");
		System.out.println(bp.getItem());
	}
}
