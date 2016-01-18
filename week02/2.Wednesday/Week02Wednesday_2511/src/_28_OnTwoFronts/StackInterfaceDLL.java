package _28_OnTwoFronts;

public interface StackInterfaceDLL<Item> {
    
    boolean isEmpty();
    void add(Item item); 
    Item remove(); 
    int size(); 
    void clear();
    Item get(int elementIndex); 
    Item getFirst(); 
    Item getLast(); 
}
