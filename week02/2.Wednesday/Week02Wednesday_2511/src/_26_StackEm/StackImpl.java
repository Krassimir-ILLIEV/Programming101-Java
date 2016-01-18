package _26_StackEm;

public class StackImpl<Item> implements StackInterface<Item> {
    private int size = 0;
    private Item[] a = (Item[]) new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    private Item[] resizeUp(Item[] a_old){
        Item[] b= (Item[]) new Object[a_old.length*2];
        for(int i=0;i<size;i++){
      b[i]=a_old[i];  
        }
        return b;
    }

    public void push(Item item) {
        if (a.length == size){
            a=resizeUp(a);}
            a[size++]=item;
    }

    private Item[] resizeDown(Item[] a_old){
        Item[] b= (Item[]) new Object[a_old.length/2];
        for(int i=0;i<size;i++){
        b[i]=a_old[i];  
        }
        return b; 
    }
    
    public Item pop(){
        if (isEmpty()) {return null;}
        if(size<a.length/4) {a=resizeDown(a);}
        Item item=a[--size];
        a[size]=null;
        return item;
    }
    
    public int length(){
        return size;
    }
    
    public void clear(){
        a=(Item[]) new Object[10];
        size=0;
    }

public static void main(String[] args){
    StackImpl<Integer> a=new StackImpl<Integer>();
    System.out.println(a.pop());
    System.out.println(a.isEmpty());
    for(int i=0;i<200;i++){
    a.push(i);
    }
    System.out.println(a.length());
    System.out.println(a.isEmpty());
    for(int i=0;i<200;i++){
        a.pop();
        }
    System.out.println(a.length());
    System.out.println(a.isEmpty());
}
}
