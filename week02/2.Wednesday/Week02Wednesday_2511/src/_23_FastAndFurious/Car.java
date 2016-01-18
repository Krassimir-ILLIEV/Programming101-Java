package _23_FastAndFurious;

public class Car {
    double mileage;
    int seats;
    int maxSpeed;
    
    public Car(double mileage, int seats, int maxSpeed){
        this.mileage=mileage;
        this.seats=seats;
        this.maxSpeed=maxSpeed;
    }
    
   
    public boolean isEcoFriendly(boolean testing){
        return true;
    }
    public String getBrandName(){
        return this.getClass().getName();
    }
    
    
    public double getMileage(){
        return mileage;
    }
    
    
    
    
    public static void main(String[] args){
        Car Vw=new Volkswagen(200.0,4,200);
        Car A=new Audi(100.0,4,200);
        A.getMileage();

        System.out.println(Vw.getBrandName() +" is "+ Vw.isEcoFriendly(false));
        System.out.println(A.getBrandName() +" is "+ A.isEcoFriendly(false));
        System.out.println(A.getMileage());

        
    }
}
