import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FunnyArraySorter <T extends Number> {

	private Number pivot;
	
	public FunnyArraySorter(Number pivot){
		this.pivot=pivot;
		
	}

	

	
	public void reverseSort(List<T> list){
		list.sort(new Comparator<T>(){
			
			@Override
			public int compare(T o1, T o2){
				if (o1.doubleValue()<o2.doubleValue()) return +1; //reversed sign
				if (o1.doubleValue()>o2.doubleValue()) return -1;
				return 0;
			}
			
		});
		
	}
	
		public void pivotSubtractionSort(List<T> list){
			list.sort(new Comparator<T>(){
				@Override
				public int compare(T o1, T o2){
					if (o1.doubleValue()-pivot.doubleValue()<o2.doubleValue()) return -1;
					if (o1.doubleValue()-pivot.doubleValue()>o2.doubleValue()) return 1;
					return 0;
			    }
			});
			
		}
		
		public void pivotDivisionSort(List<T> list){
			list.sort(new Comparator<T>(){
				@Override
				public int compare(T o1, T o2){
									
					if (o1.doubleValue()/pivot.doubleValue()<o2.doubleValue()) return -1;
					if (o1.doubleValue()/pivot.doubleValue()>o2.doubleValue()) return 1;
					return 0;
				}
			});
			
		}
		
		
		public static void main(String[] args){
			FunnyArraySorter<Double> fas=new FunnyArraySorter<Double>(2);
			//int[] intArray={2,4,1};
			List l=Arrays.asList(6,0,3);
			fas.reverseSort(l);
			//fas.pivotSubtractionSort(l);
			System.out.println(l);
			
			
		}
	
}
