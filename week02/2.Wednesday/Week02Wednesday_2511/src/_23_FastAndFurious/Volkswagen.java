package _23_FastAndFurious;

public class Volkswagen extends Car{

    public Volkswagen(double mileage, int seats, int maxSpeed) {
        super(mileage, seats, maxSpeed);
    }

    public boolean isEcoFriendly(boolean testing){
        if(testing) {
            return true;
        }
        return false;
    }
    public String getBrandName(){
        return this.getClass().getName();
    }
}
