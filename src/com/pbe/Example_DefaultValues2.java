package com.pbe;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Declaring an annotation
// @ tells compiler that an annotation type is being declared
// The RetentionPolicy RUNTIME makes the annotation available through the JVM during run time, offering the greatest annotation persistence (state of a system/data that outlives the process that created it)
// This allows the annotation to be queried at run time, through the use of reflection
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String userinput(); // String member, without a default value
    int num(); // int member, without a default value
}

// *******
// Example of how to the default values from members from an annotation
// The used method in this example has multiple arguments. In the DefaultValues example, it has none.
// *******
public class Example_DefaultValues2 {

    @MyAnnotation2(userinput = "Input parameters", num = 99) // applying annotation MyAnnotation to myMethod(), with provision of parameters
    public static void myMethod(String str, int i) { // note that the method specifies two parameters, taking a String and int value that can be passed as additional arguments

        // Create new class object
        Example_DefaultValues2 ob = new Example_DefaultValues2();

        // Obtain annotation for this method and display the member's values
        try {
            // Return the Class object that represents the invoking object, with use of getClass()
            Class<?> c = ob.getClass();

            // Use getMethod() to obtain myMethod() (note it's name is passed as argument)
            // The parameter types are specified ! with String.class and int.class
            Method m = c.getMethod("myMethod", String.class, int.class);

            // Retrieve annotation from the Method by using getAnnotation()
            MyAnnotation2 myanno = m.getAnnotation(MyAnnotation2.class);

            // Now the annotation member values can be displayed
            System.out.println(myanno.userinput() + " " + myanno.num());
        } catch (NoSuchMethodException e) { // if myMethod() wouldn't be found, a NoSuchMethodException would be thrown
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        // Call myMethod to retrieve information from its annotation
        // Note that the returned values are different from the inputted values, as the annotation arguments are fixed
        myMethod("test", 10);
    }
}