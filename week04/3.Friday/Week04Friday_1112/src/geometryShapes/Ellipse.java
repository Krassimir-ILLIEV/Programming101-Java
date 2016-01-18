package geometryShapes;

public class Ellipse implements Shape {
	private final double majorAxis;
	private final double minorAxis;
	private final Point center;

	public Ellipse(double majorAxis, double minorAxis, Point center){
		if(majorAxis==0 || minorAxis==0) 
			throw new java.lang.IllegalArgumentException("Ellipse axis length cannot be zero.");
		
		if(majorAxis<minorAxis){
			this.majorAxis=minorAxis;
			this.minorAxis=majorAxis;
		} else {		
		this.majorAxis=majorAxis;
		this.minorAxis=minorAxis;
		}
		this.center=new Point(center);
	}
		
	public Ellipse(Ellipse e){
		this(e.majorAxis,e.minorAxis,e.center);
	}
	
	public Point getUppermostPoint(){
		return new Point(center.getX(),center.getY()+minorAxis/2);
	}
	
	public Point getLowermostPoint(){
		return new Point(center.getX(),center.getY()-minorAxis/2);
	}
	
	public Point getLeftmostPoint(){
		return new Point(center.getX()-majorAxis/2,center.getY());
	}
	
	public Point getRightmostPoint(){
		return new Point(center.getX()+majorAxis/2,center.getY());
	}
	
	public Point getCenter(){
		return center;
	}
	
	public double getPerimeter(){
		double A=majorAxis;
		double B=minorAxis;
		double H=Math.abs(A-B)/(A+B);
	
		return (Math.PI/2)*(A+B)*(1+Math.pow(H, 2)/4+Math.pow(H, 4)/64+Math.pow(H, 6)/256+25*(Math.pow(H, 8)/16384));
		//(pi/2)(A+B)[1 + H2/4 + H4/64 + H6/256 + 25H8/16384]
			//	where H = |A-B|/(A+B)
	}
	
	public double getArea(){
		return Math.PI*(majorAxis/2)*(minorAxis/2);
	}
	
	public double getMajorAxis(){
		return majorAxis;
	}
	@Override
	public String toString(){
		return "Ellipse[("+center.getX()+","+center.getY()+"),("+minorAxis+","+majorAxis+")]";
		//Ellipse[(x,y), (height,width)]
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + center.hashCode();
	    hash = hash * 23 + ((Double) majorAxis).hashCode();
	    hash = hash * 23 + ((Double) minorAxis).hashCode();
	    return hash;
	}
	
	@Override
	public boolean equals(Object e){
		if(getClass().getName()!=e.getClass().getName()) {return false;}
		Ellipse e1=(Ellipse) e;
		if(center.equals(e1.center) && majorAxis==e1.majorAxis && minorAxis==e1.minorAxis) {
			return true;
		} return false;
	}

	public static void main(String[] args){
		Ellipse e=new Ellipse(4,2,new Point());
		System.out.println(e);
				
	}
}
