package geometryShapes;

public class Triangle implements Shape {
private Point a,b,c;

	public Triangle(Point a, Point b, Point c){
		if((Point.isEqualDouble(a.getX(),b.getX()) && Point.isEqualDouble(a.getX(),c.getX())) ||
				(Point.isEqualDouble(a.getY(),b.getY()) && Point.isEqualDouble(a.getY(),c.getY()))	
				)
			throw new java.lang.IllegalArgumentException("Points are on the same line.");
		
		this.a=new Point(a);
		this.b=new Point(b);
		this.c=new Point(c);
		
	}
	
	public Triangle(Triangle t){
		this(t.a, t.b, t.c);
	}
	
	public Point getA(){
		return a;
	}
	
	public Point getB(){
		return b;
	}
	
	public Point getC(){
		return c;
	}
	
	public LineSegment getSideA(){  //or length
	return new LineSegment(b,c);
	}
	
	public LineSegment getSideB(){
		return new LineSegment(a,c);
		}
	
	public LineSegment getSideC(){
		return new LineSegment(a,b);
		}
	
	public double getBase(){
		return getSideA().getLength();
	}
	
	public double getHeight(){    
		return 2*getArea()/getBase();
	}
	
	public double getPerimeter(){
		return getSideA().getLength()+getSideB().getLength()+getSideC().getLength();
	}
	
	public double getArea(){ //Heron's formula
		double p=getPerimeter()/2;
		double sideA=getSideA().getLength();
		double sideB=getSideB().getLength();
		double sideC=getSideC().getLength();
		
		return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
		
	}
	
	public Point getCenter(){ //????
		LineSegment medianA= new LineSegment(getSideA().getPartitionPoint(1.0/2),a);
		return medianA.getPartitionPoint(1.0/3);
	}
	
	@Override
	public String toString(){
		return "Triangle[("+getCenter().getX()+","+getCenter().getY()+"),("+getHeight()+","+getBase()+")]";
				//Triangle[(x,y), (height,base)]
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + a.hashCode();
	    hash = hash * 23 + b.hashCode();
	    hash = hash * 23 + c.hashCode();
	    return hash;
	}
	
	@Override
	public boolean equals(Object t){
		if(getClass().getName()!=t.getClass().getName()) {return false;}
		Triangle t1=(Triangle) t;
		if(a.equals(t1.a) && b.equals(t1.b) && c.equals(t1.c)) {return true;}
		return false;
	}
	public static void main(String[] args){
		Triangle t=new Triangle(new Point(),new Point(1,0),new Point(0.5,Math.sqrt(0.75)));
		System.out.println(t);
		System.out.println("A: "+t.getArea()+" P: "+t.getPerimeter());
	}
}
