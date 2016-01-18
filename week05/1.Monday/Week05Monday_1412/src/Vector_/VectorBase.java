package Vector_;

public class VectorBase {
	
protected double[] data;

public VectorBase(VectorBase v){
	for(int i=0;i<v.data.length;i++){
	data[i]=v.data[i];
	}
}

public VectorBase(){
}

public static VectorBase classF(double... d){
	if (d.length==1)
		return new VectorDim1(d[0]);
	return null;
	
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
		VectorBase vb=classF(1);
		System.out.println(vb);
	}
}


