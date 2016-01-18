package _03_ImplementOnOff;

import java.util.Collection;
import java.util.Stack;

import java.util.Iterator;

public class OnOffCollection_03<T, Item extends Collection<T>> {

    public void add(Item item, T t) {
        if (item.contains(t)) {
            item.remove(t);
        } else {
            item.add(t);

        }
    }

    private static <T,TT extends Collection<T>> void printCollection(TT item){
        Iterator<T> iterator=item.iterator();
        while (iterator.hasNext()){
        T o=iterator.next();
        System.out.println(o);
        }
    }

    public static void main(String[] args) {
        OnOffCollection_03<Integer,Stack<Integer>> test_object = new OnOffCollection_03<>();
      
        Stack<Integer> st = new Stack<>();
        st.add(5);
        st.add(4);
        st.add(3);
        test_object.add(st,6);
        OnOffCollection_03.<Integer,Stack<Integer>>printCollection(st);
        System.out.println("---");
        test_object.add(st,4);
        OnOffCollection_03.<Integer,Stack<Integer>>printCollection(st);
    }

}
