package _01_Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
		private String name;
		private int grade;
		
		public Student(String name, int grade){
			this.name=name;
			this.grade=grade;
		}
	
		public int compareTo(Student st){
			if(this.grade<st.grade) 
			{return 1;}
			else if (this.grade==st.grade && this.name.charAt(0)>st.name.charAt(0)){
				return 1; } 
			else if (this.grade==st.grade && this.name.charAt(0)<=st.name.charAt(0)){
				return -1;
			} else {
				return -1;
			}
		}
		
		//public void sort(List<Student_01> l){
		//	Collections.sort(l);
			
		//}
		
		public String toString(){
			
			
			return "Name"+name+" "+"grade :" + grade+"\n";
		}
	
	
	public static void main(String[] args){
		Student st1= new Student("K", 6);
		Student st2= new Student("A", 6);
		Student st3= new Student("A", 4);
		Student[] a={st1,st2,st3};
		//List<Student_01> ls= new LinkedList<Student_01>();
		List<Student> ll = new ArrayList<Student>();
		ll.add(st1);
		ll.add(st2);
		ll.add(st3);
		for(Student s :ll){
			System.out.println(s.toString());
		}
		Collections.sort(ll);
		System.out.println("-----------------");
		for(Student s :ll){
			System.out.println(s.toString());
		}
			
		
	}
}
//ili da se napravi map
//implement compareTo 
