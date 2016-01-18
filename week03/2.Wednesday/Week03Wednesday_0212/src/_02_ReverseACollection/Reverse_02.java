package _02_ReverseACollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class Reverse_02 {

    public static <T> void  reverse (Collection<T> collection){
        Iterator<T> iterator =collection.iterator();
        Stack<T> st= new Stack<>();
        while(iterator.hasNext()){
           st.push(iterator.next());
        }
        collection.clear();
        while(!st.isEmpty()){
            collection.add(st.pop());
        }
    }
    
        public static<T> void printCollection(Collection<T> collection){
            //Iterator<T> iterator =collection.iterator();
            for(T t: collection){
                System.out.println(t);
            }
        }
        public static void main(String[] args){
            Collection<Integer> col = new Stack<Integer>();
            col.add(new Integer(2));
            col.add(new Integer(4));
            col.add(5);
            
            printCollection(col);
            System.out.println("----");
            reverse(col);
            printCollection(col);
            
        }
    }
    
    
