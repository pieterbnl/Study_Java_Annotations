package com.pbe;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class) // annotated with @Repeatable to make MyAnno repeatable and which specifies its container annotation, named MyRepeatedAnnos
@interface MyAnno {
    String str() default "Repeated Anno test";
    int num() default 99;
}

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}

public class Example_RepeatedAnnotation {

    // Repeat MyAnno on myMethod()
    @MyAnno(str = "First annotation", num = -1)
    @MyAnno(str = "Second annotation", num = 10)

    public static void myMethod(String str, int i) {
        Example_RepeatedAnnotation ob = new Example_RepeatedAnnotation();
        try {
            Class<?> c = ob.getClass();

            // Obtain myMethod() annotations
            Method m = c.getMethod("myMethod", String.class, int.class);

            // Display repeated MyAnnno annotations
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class); // access repeated annotation by calling getAnnotation() and passing in the class of the container annotation
            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        myMethod("test", 10); // output will be the repeated annotations, seperate by a comma, not returned individually
    }
}