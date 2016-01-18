package _05_FindFirstUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Duplicate_05<T> {

    public T firstUnique(Collection<T> C) {
        LinkedList<T> cCopy = new LinkedList<>();
        for (T t : C) {
            cCopy.add(t);
        }
        for (T t : C) {
            cCopy.remove(t);
            if (!cCopy.contains(t)) {
                return t;
            }
            cCopy.add(t);
        }
        return null;
    }

    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);
        Duplicate_05<Integer> d = new Duplicate_05<>();
        System.out.println(d.firstUnique(ints));
    }
}
