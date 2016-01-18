package _25_PairEmUp;

import java.lang.reflect.Field;

public class Pair {

    private Object obj1;
    private Object obj2;

    public Pair(Object obj1, Object obj2) {

        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public Object getObjectN(int i) {
        if (i == 1)
            return obj1;
        if (i == 2)
            return obj2;
        return null;
    }

    private static Object cloneObject(Object obj) {
        try {
            Object clone = obj.getClass().newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(clone, field.get(obj));
            }
            return clone;
        } catch (Exception e) {
            return null;
        }
    }

    private String toStringObj(Object obj) {
        String s = "";
try {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            s += field.get(obj).toString();
        }
        return s;
    } catch (Exception e) {
        return null;
    }
    }

    public String toString() {
        String s = "Obj1: " + toStringObj(obj1) + "\n";
        s += "Obj2: " + toStringObj(obj2) + "\n";
        return s;
    }
    public static void main(String[] args){
        Integer A=1;
        Integer B=1;
        
        Pair p=new Pair(A,B);
        System.out.println(p);
    }
}
