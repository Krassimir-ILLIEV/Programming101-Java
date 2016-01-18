package geometryShapes;

public class Rectangle implements Shape{

	private Point upperLeft;
	private Point lowerRight;
	private Point lowerLeft;
	private Point upperRight;
	private LineSegment upperEdge;
	private LineSegment lowerEdge;
	private LineSegment leftEdge;
	private LineSegment rightEdge;
	
	public Rectangle(Point upperLeft, Point lowerRight){
		if(Point.isEqualDouble(upperLeft.getX(),lowerRight.getX()) || Point.isEqualDouble(upperLeft.getY(),lowerRight.getY()) )
			throw new java.lang.IllegalArgumentException("Points are on the same axis.");
	if(upperLeft.getX()<(lowerRight.getX())) {
	this.upperLeft=upperLeft;
	this.lowerRight=lowerRight;	
	} else {
		this.upperLeft=lowerRight;
		this.lowerRight=upperLeft;		
	}
	
	if(this.upperLeft.getY()<this.lowerRight.getY()) 
		throw new java.lang.IllegalArgumentException("Incorrect coordinates.");
	
	this.lowerLeft=new Point(upperLeft.getX(),lowerRight.getY());
	this.upperRight=new Point(lowerRight.getX(),upperLeft.getY());
	
	upperEdge=new LineSegment(this.upperLeft,upperRight);
	lowerEdge=new LineSegment(lowerLeft,this.lowerRight);
	leftEdge=new LineSegment(this.upperLeft, lowerLeft);
	rightEdge=new LineSegment(upperRight, this.lowerRight);
	
	}
	
	public Rectangle(Rectangle r){ 
		this(r.upperLeft,r.lowerRight);
	}
	
	public Point getUpperLeft(){
		return upperLeft;
	}
	
	public Point getLowerLeft(){
		return lowerLeft;	
	}
	
	public Point getUpperRight(){
		return upperRight;
	}

	public Point getLowerRight(){
		return lowerRight;
	}
	
	public LineSegment getUpperEdge(){
		return upperEdge;
	}
	
	public LineSegment getLowerEdge(){
		return lowerEdge;
	}
	
	public LineSegment getLeftEdge(){
		return leftEdge;
	}
	
	public LineSegment getRightEdge(){
		return rightEdge;
	}
	
	public double getHeight(){
		return leftEdge.getLength();
	}
	
	public double getWidth(){
		return upperEdge.getLength();
	}
	
	public double getPerimeter(){
		return 2*(getHeight()+getWidth());
	}
	
	public double getArea(){
		return getHeight()*getWidth();
	}
	
	public Point getCenter(){
		return new Point((lowerLeft.getX()+upperRight.getX())/2,(lowerLeft.getY()+upperRight.getY())/2);
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + upperLeft.hashCode();
	    hash = hash * 23 + lowerLeft.hashCode();
	    hash = hash * 23 + upperRight.hashCode();
	    hash = hash * 23 + lowerRight.hashCode();
	    return hash;
	}

	@Override
	public String toString(){
		return "Rectangle[("+getCenter().getX()+","+getCenter().getY()+"),("+getHeight()+","+getWidth()+")]";
	}

	@Override
	public boolean equals(Object r){
		if(getClass().getName()!=r.getClass().getName()) {return false;}
		Rectangle r1=(Rectangle) r;
		if(getCenter().equals(r1.getCenter()) && getHeight()==r1.getHeight() && getWidth()==r1.getWidth()) {
			return true;
		} return false;
	}
	
	public static void main(String[] args){
		Rectangle r=new Rectangle(new Point(1,0),new Point(0,1));
		System.out.println("P="+r.getPerimeter());
		System.out.println("A="+r.getArea());
		System.out.println(r.getCenter());
		System.out.println(r.getRightEdge());
		System.out.println(r);
		System.out.println("if r equals r:" +r.equals(r));
		System.out.println(r.hashCode());
	}
}
