package com.pbe;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Declaring an annotation
// @ tells compiler that an annotation type is being declared
// The RetentionPolicy RUNTIME makes the annotation available through the JVM during run time, offering the greatest annotation persistence (state of a system/data that outlives the process that created it)
// This allows the annotation to be queried at run time, through the use of reflection
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String userinput() default "default input"; // String member, with a default value
    int num() default 666; // int member, with a default value
}

// *******
// Example of how to the default values from members from an annotation
// The used method in this example has no arguments. In the DefaultValues2 example, it has.
// *******
public class Example_DefaultValues {

    @MyAnnotation() // applying annotation MyAnnotation to myMethod()
    public static void myMethod() {

        // Create new class object
        Example_DefaultValues ob = new Example_DefaultValues();

        // Obtain annotation for this method and display the member's values
        try {
            // First step to using reflection is to obtain a Class object that represents the class whose annotations needs to be obtained
            // Return the Class object that represents the invoking object, with use of getClass()
            Class<?> c = ob.getClass();

            // Now the Class object is maintained, it's methods can be used
            // to obtain information about the various items declared by the class, including its annotations
            // To obtain annotations associated with a specific item declared within a class, we must first obtain an object that represents that item.
            // Here, getMethod() is used to obtain myMethod() (note it's name is passed as argument)
            // myMethod() is returned as Method object that represents the method
            Method m = c.getMethod("myMethod");

            // Next, the annotation can be retrieved from the Method by using getAnnotation()
            // Note that getAnnotation() can be used to obtain annotations not only from a Method, but also from a Class, Field or Constructor associated with an object
            MyAnnotation myanno = m.getAnnotation(MyAnnotation.class);

            // Now the annotation member values can be displayed
            System.out.println(myanno.userinput() + " " + myanno.num());
        } catch (NoSuchMethodException e) { // if myMethod() wouldn't be found, a NoSuchMethodException would be thrown
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        // Call myMethod to retrieve information from its annotation
        myMethod();
    }
}