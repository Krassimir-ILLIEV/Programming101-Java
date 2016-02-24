package myAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface ClassInfo {

	String author();
	String revision () default "1";
	boolean ifChecked() default true;
	//Class<?>[] related();
}

/*
It should contain information about:

author of the class
revision of the class (by default it should be 1)
should the class be 'checked' (by default it should be) //this 'checked' thing is a bogus one, I just made it up so you can use a boolean default

an array of 'related' classes (Class<?>[])

Annotatate a class with this annotation. Fill in the 'required' information
In a main method, instantiate the annotated class. Using the getClass().getAnnotations(), print out all the annotations declared for your annotated class.
Now fetch your own annotation using yourInstance.getClass().getAnnotation(YourAnnotationName.class);
Print out all the filled information

*/