package _25_PairEmUp;

import java.lang.reflect.Field;

public class PairGenerics<Item> {
    private Item obj1;
    private Item obj2;
    
    public PairGenerics(Item obj1,Item obj2){
        
        this.obj1=obj1;
        this.obj2=obj2;
    }
    
    public Object getObjectN(int i){
        if(i==1) return obj1;
        if(i==2) return obj2;
         return null;
    }
    

}
