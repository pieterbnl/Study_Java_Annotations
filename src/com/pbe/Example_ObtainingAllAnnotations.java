package com.pbe;

import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String userinput(); // String member, no default value
    int num(); // int member, no default value
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

// This example obtains an array of all annotations associated with the Class and it's method myMethod()
@What(description = "Annotation test class")
@MyAnnotation2(userinput = "Testing class", num = 99)
public class Example_ObtainingAllAnnotations {

    @What(description = "Annotation test method")
    @MyAnnotation2(userinput = "Testing method", num = 100)
    public static void myMethod() {
        Example_ObtainingAllAnnotations ob = new Example_ObtainingAllAnnotations();

        try {
            Annotation annos[] = ob.getClass().getAnnotations(); // returns an array of Annotation objects

            // Display all annotations for Example_ObtainingAllAnnotations class
            System.out.println("All annotations for this class: ");
            for (Annotation x : annos)
                System.out.println(x);

            System.out.println();

            // Display all annotations for myMethod()
            Method m = ob.getClass().getMethod("myMethod"); // obtain an object that represents the method with use of getMethod() and reference to the method name
            annos = m.getAnnotations(); // obtain all annotations from the method - both lines could also be replaced with single line ->> Annotation annos2[] = ob.getClass().getMethod("myMethod").getAnnotations(); // obtain all annotations from the method
            System.out.println("All annotations for myMethod(): ");
            for (Annotation x : annos)
                System.out.println(x);
        } catch (NoSuchMethodException e) {
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}