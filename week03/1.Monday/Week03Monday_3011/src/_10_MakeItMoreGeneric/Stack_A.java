package _10_MakeItMoreGeneric;

public class Stack_A<Item> {
	int size;
	Item[] a;
	
	public Stack_A(){
	size=0;
	a=(Item[]) new Object[2];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	private Item[] resizeUp(Item[] a){
		Item[] b=(Item[]) new Object[size*2];
		for(int i=0;i<size;i++){
			b[i]=a[i];
		}
		//System.out.println("resizeUp, length: "+a.length);
		return b;
	}
	
	private Item[] resizeDown(Item[] a){
		Item[] b=(Item[]) new Object[a.length/2];
		for(int i=0;i<size;i++){
			b[i]=a[i];
		}
		a=b;
		//System.out.println("resizeDown, length:"+a.length);
		return a;
	}
	
	public void push(Item item){
		if(size>=a.length){
			a=resizeUp(a);
		}
		a[size]=item;
		size++;
		
		
	}
	
	public Item pop(){
		if (isEmpty()) return null;
		Item returnItem=a[size-1];
		size--;
		if(size<a.length/4) {
			a=resizeDown(a);
		}
		return returnItem;
		
	}
	
	public int a_length(){
		return a.length;
	}
	
public static void main(String[] args){

	Stack_A<Integer> myStack=new Stack_A<Integer>(); 
	System.out.println(myStack.isEmpty());
	myStack.push(3);
	myStack.push(4);
	myStack.push(5);
	System.out.println(myStack.a_length());
	System.out.println(myStack.size());
	System.out.println(myStack.isEmpty());
	myStack.pop();
	myStack.pop();
	myStack.pop();
	myStack.pop();
	System.out.println(myStack.size());
	System.out.println(myStack.isEmpty());
	myStack.push(4);
	myStack.push(5);
	System.out.println(myStack.a_length());
	
	
}
}
