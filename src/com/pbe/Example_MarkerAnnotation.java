package com.pbe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface myMarker { } // creating the (completely empty) myMarker annotation that will be used as a marker


// Example of the use of a marker annotation
// A marker annotation is a special kind of annotation that contains no members.
// It's sole purpose is to mark an item
public class Example_MarkerAnnotation {

    @myMarker // annotating the method with myMarker - note this annotation is not followed with parentheses (it can, but not needed)
    public static void myMethod() {
        Example_MarkerAnnotation ob = new Example_MarkerAnnotation(); // create new class object
        try {
            Method m = ob.getClass().getMethod("myMethod"); // retrieve myMethod from the class object and save it as a Method object

            // Determine if the annotation is present
            if(m.isAnnotationPresent(myMarker.class)) // check if the annotation 'myMarker' is present in the Method object, with isAnnotationPresent()
                System.out.println("myMarker is present");

        } catch (NoSuchMethodException e) {
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}