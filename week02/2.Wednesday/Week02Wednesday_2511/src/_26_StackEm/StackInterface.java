package _26_StackEm;

public interface StackInterface<Item> {
 
    boolean isEmpty();
    //boolean isFull();  a will be resized
    void push(Item item); 
    Item pop(); 
    int length(); 
    void clear();

}
