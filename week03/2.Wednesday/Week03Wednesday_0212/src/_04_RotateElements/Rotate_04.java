package _04_RotateElements;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import _02_ReverseACollection.Reverse_02;

public class Rotate_04<T, C extends Collection<T>> {

    public void rotate(Collection<T> collection, int rotateStep ){
        LinkedList<T> LL= new LinkedList<T>();
        
      for(T t: collection){
         LL.add(t); 
      }
      
      collection.clear();
      
      if(rotateStep>0) {
          for(int i=0;i<rotateStep;i++){
              LL.addFirst(LL.removeLast());
          }
      } else {
          for(int i=0;i<-rotateStep;i++){
              LL.addLast(LL.removeFirst());
          }
      }
    while(!LL.isEmpty()){
       collection.add(LL.removeFirst());
    }
    }
    
    public void rotate_complex(C col, int rotateStep){
        LinkedList<T> q = new LinkedList<T>();
         //Iterator iterator=col.iterator();
        for(T t: col){
            q.add(t);
        }
        col.clear();
        Stack<T> st=new Stack<T>();
        for(int i=0;i<rotateStep;i++){
            st.add(q.removeLast());
        }
        while(!st.isEmpty()){
        col.add(st.pop());
        }
        while(!q.isEmpty()){
        col.add(q.removeFirst());
        }
    }
    
    public static void main(String[] args){
        Rotate_04<Integer, Stack<Integer>> r=new Rotate_04<>();
        Stack<Integer> st=new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        st.add(6);
        st.add(7);
        st.add(8);
        Reverse_02.printCollection(st);
        System.out.println("----");
        r.rotate(st,-5);
        Reverse_02.printCollection(st);
    }
}
