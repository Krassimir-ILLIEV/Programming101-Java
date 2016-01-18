package geometryShapes;

public class Point implements Comparable<Point> {
private double x_coord;
private double y_coord;
private static Point ORIGIN=new Point(); 
private static final double EPSILON=0.0000001;


	public Point(double x, double y){
		x_coord=x;
		y_coord=y;
	}
	public Point(){
		x_coord=0.0;
		y_coord=0.0;
	}
	
	public Point(Point p){
		x_coord=p.x_coord;
		y_coord=p.y_coord;
	}
	
	public double getX(){
		return x_coord;
	}
	public double getY(){
		return y_coord;
	}
	public static Point getOrigin(){
		Point p=new Point();
		return p;
	}
	@Override
	public String toString(){
		String s ="Point("+x_coord+","+y_coord+")";
		return s;
		
	}	
	public static LineSegment Add(Point point1, Point point2){
		LineSegment l= new LineSegment(point1, point2);
		return l;
	}
	
	public static int compareDouble(double d1, double d2){
		
		if(Math.abs(d1-d2)>EPSILON) {
			if(d1>d2) {return 1;}
			else return -1;
		} else return 0;

	}
	public static boolean isEqualDouble(double d1, double d2){
		
		return (Math.abs(d1-d2)<EPSILON);

	}
	
	public int compareTo(Point p){
		if(isEqualDouble(getX(),p.getX())) {
			if(isEqualDouble(getY(),p.getY())) {
				return 0;}
			else if(getY()>p.getY()){
				return 1;
			} else return -1;
		}
		if(getX()>p.getX()) {return 1;}
		else return -1;
	}
	
	
	
	@Override
	public boolean equals(Object p){
		if(this.getClass().getName()!=p.getClass().getName()) {return false;}
		Point p1=(Point) p;
		if(!isEqualDouble(getX(),p1.getX())) {return false;}
		else if(!isEqualDouble(getY(),p1.getY())) {return false;}
		return true;
	}
	
	@Override
	public int hashCode(){
		int hash=17;
		hash=hash*23+((Double) this.x_coord).hashCode();
		hash=hash*23+((Double) this.y_coord).hashCode();
		return hash;
	}
	
	public static void main(String[] args){
		
	}
	
}
