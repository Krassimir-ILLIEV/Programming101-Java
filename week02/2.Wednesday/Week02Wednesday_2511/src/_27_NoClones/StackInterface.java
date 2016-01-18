package _27_NoClones;

public interface StackInterface<Item> {
 
    boolean isEmpty();
    //boolean isFull();  a will be resized
    void push(Item item); 
    Item pop(); 
    int length(); 
    void clear();

}
