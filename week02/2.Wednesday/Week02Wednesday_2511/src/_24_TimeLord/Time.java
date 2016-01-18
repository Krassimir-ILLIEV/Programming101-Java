package _24_TimeLord;

public class Time {
    public TimeFactory now() {
        return new MyTime();
    }

    public static void main(String[] args) {
        Time tL = new Time();
        TimeFactory tF = tL.now();
        System.out.println(tF);
    }
}
