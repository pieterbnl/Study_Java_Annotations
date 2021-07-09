package com.pbe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value(); // this variable must be value !!
}

// Example of annotation with a single member.
// A single member annotation contains only one member.
// It works like any annotation, but allows a shorthand form of specifying the value of the member.
// The value for the single member can be specified when the annotation is applied.
// In order to use the shorthand, the name of the member must be value!
public class Example_SingleMemberAnnotation {

    @MySingle(666)
    public static void myMethod() {

        Example_SingleMemberAnnotation ob = new Example_SingleMemberAnnotation(); // create class object

        try {
            Method m = ob.getClass().getMethod("myMethod");  // retrieve myMethod from the class object and save it as a Method object
            MySingle anno = m.getAnnotation(MySingle.class); // retrieve annotation from Method object
            System.out.println(anno.value()); // displays the single value
        }catch (NoSuchMethodException e) {
            System.out.println("No method found");
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}