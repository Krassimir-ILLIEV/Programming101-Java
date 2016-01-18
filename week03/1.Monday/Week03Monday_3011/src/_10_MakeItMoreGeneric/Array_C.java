package _10_MakeItMoreGeneric;

public class Array_C <Item extends Comparable>{

	public Item findMIn(Item[] a){
		Item minItem=a[0];
		for(int i=0;i<a.length;i++){
			if(minItem.compareTo(a[i])>0){
				minItem=a[i];
			}
		}
		return minItem;
	}
	
	public static  <Item1 extends Comparable> Item1 findMInStatic(Item1[] a){
		Item1 minItem=a[0];
		for(int i=0;i<a.length;i++){
			if(minItem.compareTo(a[i])>0){
				minItem=a[i];
			}
		}
		return minItem;
	}
	public static void main(String[] args){
		Double[] a={2.0,4.5,-6.5,1.0};
		System.out.println(new Array_C<Double>().findMIn(a));
		System.out.println(Array_C.findMInStatic(a));
	}
	
}
