package Vector_;

public class VectorDim1 extends VectorBase {

 public VectorDim1(double d){
   super();
	data=new double[1]; 
	data[0]=d;
}
 
 public VectorDim1(){
	   super();
		data=new double[1]; 
	}

public String toString(){
	return "this is a test"+super.toString();
}
 
 public static void main(String[] args){
	 VectorDim1 v=new VectorDim1();
	 System.out.println(v);
	 System.out.println(v.getElement(1));
	 v.setElement(1, 2);
	 System.out.println(v);
	 
 }
}
