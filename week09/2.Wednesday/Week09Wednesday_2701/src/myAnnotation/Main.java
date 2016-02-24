package myAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		MyClass obj=new MyClass();
		
		@SuppressWarnings("unchecked")
		Class<MyClass> cls = (Class<MyClass>) obj.getClass(); //or MyClass.class
		readAnnotationOn(cls);
		Method method = cls.getMethod("getString", new Class[]{});
		readAnnotationOn(method);
		Annotation[] annotation = cls.getAnnotations();
	}
	
	//vij dali ima vuobshte anotacii? isAnnotations?
	
	static void readAnnotationOn(AnnotatedElement element){
		try{
			System.out.println("n, Finding annotations on "+element.getClass().getName());
			Annotation[] annotations = element.getAnnotations();
			
			for(Annotation annotation : annotations){
				if(annotation instanceof ClassInfo){
					ClassInfo classInfo=(ClassInfo) annotation;
					System.out.println("Author:"+classInfo.author());
					System.out.println("Revision :" + classInfo.revision());
					System.out.println("ifChecked: "+ classInfo.ifChecked());
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
