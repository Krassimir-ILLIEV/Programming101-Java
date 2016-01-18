package geometryShapes;

public class Circle extends Ellipse{
	
	public Circle(double radius, Point center){
		super(radius*2,radius*2,center);
	}
	
	public Circle(Circle c){
		this(c.getMajorAxis()/2,c.getCenter());
	}
	
	//four extreme points' methods and getCenter are inherited, equals and hashcode() are inherited
	//getPerimeter(),getArea() are also inherited
	
	@Override
	public String toString(){
		return (super.toString()).replace("Ellipse","Circle");
	}
	public static void main(String[] args){
		Circle c=new Circle(3,new Point(0,0));
		System.out.println(c.getUppermostPoint());
		System.out.println(c);
		System.out.println("A: "+c.getArea()+" P: "+c.getPerimeter());
	}
}
