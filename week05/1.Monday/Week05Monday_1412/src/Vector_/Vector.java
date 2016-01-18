package Vector_;

public class Vector {
	
private double[] data;

	public Vector(double... a){
		data=new double[a.length]; 
		for(int i=0;i<a.length;i++){
			data[i]=a[i];
		}
	}
	
	public Vector(int N){
		data=new double[N];
	}
	
	public Vector(Vector v){
		for(int i=0;i<v.data.length;i++){
		data[i]=v.data[i];
		}
	}
	
	public int getDim(){
		return data.length;
	}
	
	public double getElement(int i){ //vector elements start from 1
		if(i<=0 || i>data.length) 
			throw new java.lang.NullPointerException("Element out of range");
		return data[i-1];
	}
	
	public void setElement(int i,double d){ //vector elements start from 1
		if(i<=0 || i>data.length) 
			throw new java.lang.NullPointerException("Element out of range");
		data[i-1]=d;
	}
	
	public String toString(){
		StringBuilder s=new StringBuilder("Vector(");
		
		for(int i=0;i<data.length;i++){
		 s.append(data[i]+",");
		}
		s.deleteCharAt(s.length()-1);
		s.append(")");
		return s.toString();
	}
	
	public static void main(String[] args){
		Vector v=new Vector(1,2,3,4,5);
		System.out.println(v);
		System.out.println(v.getElement(5));
		v.setElement(5,6);
		System.out.println(v);
	}
}
