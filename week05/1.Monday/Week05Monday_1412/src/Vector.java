import java.util.ArrayList;

public class Vector {

	private int dimension;
	private ArrayList<Double> al;
	
	public Vector(int dimension){
		this.dimension=dimension;
		al=new ArrayList<>(dimension);
	}
	
	public Vector(Vector v){
		this.dimension=v.dimension;  //???? tuk trqbva li da e get ili direktno
		ArrayList<Double> al=new ArrayList<>(dimension);
		for(int i=0;i<dimension;i++){
		al.set(i, v.getCoordinate(i));
		}
	}
	
	public double getCoordinate(int index){
		return al.get(index);
	}
	
}
