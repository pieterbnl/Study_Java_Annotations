package com.pbe;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Several marker annotations that can be applied to a type
@Target(ElementType.TYPE_USE)
@interface TypeAnno { }

@Target(ElementType.TYPE_USE)
@interface NotZeroLen { }

@Target(ElementType.TYPE_USE)
@interface Unique { }

@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int num();
}

// Parameterized annotation that can be applied to a type parameter
@Target (ElementType.TYPE_PARAMETER)
@interface Whatthen {
    String notes();
}
//Annotation that can be applied to a field declaration
@Target(ElementType.FIELD)
@interface EmptyOK { }

//Annotation that can be applied to a method declaration
@Target(ElementType.METHOD)
@interface Recommended { }

// ****
// Demonstration of the use of several type annotations
// ****
// using an annotation on a type parameter
public class Example_TypeAnnotations<@Whatthen(notes = "generic data type") T> {

    // Using type annotation on constructor
    public @Unique Example_TypeAnnotations() { }

    // Annotate the type (String), not the field
    @TypeAnno String str;

    // Annotating a field (test)
    @EmptyOK String test;

// Note that in the previous two examples, @TypeAnno annotates the type String and @EmptyOK annotates a field, even tho both annotations precede String.
// This is because both use a different ElementType. Being TYPE_USE and FIELD respectively, meaning they target different elements.


    // Annotating 'this' (the receiver)
    public int f(@TypeAnno Example_TypeAnnotations<T> this, int x) {
        return 10;
    }

    // Annotating the return type
    public @TypeAnno Integer f2(int a, int b) {
        return a + b;
    }

    // Annotating the method declaration
    public @Recommended Integer f3(String input) {
        return input.length() / 4;
    }

// Note that @TypeAnno in the two previous examples (annotating return type & method declaration) precedes the method's return type, but annotate two different things.
// This is because @TypeAnno has its target specified as ElementType.TYPE_USE, meaning it can be used to annotate type uses.
// In the second case, @Recommended annotates the method declaration itself, because @Recommended has its target specified as ElementType.METHOD
// This makes @Recommened apply to the declaration, not the return type

    // Annotating a throws clause
    public void f4() throws @TypeAnno NullPointerException {
        // ...
    }

    // Annotating array levels
    String @MaxLen(num=99) [] @NotZeroLen [] w;

    // Annotating array element type
    @TypeAnno Integer[] myarray;

    public static void myMethod(int x) {

        // Annotation on type argument
        Example_TypeAnnotations<@TypeAnno Integer> ob = new Example_TypeAnnotations<@TypeAnno Integer>();

        // Annotating new
        @Unique Example_TypeAnnotations<Integer> ob2 = new @Unique Example_TypeAnnotations<Integer>();

        Object obX = Integer.valueOf(99);
        Integer z;

        // Annotating cast
        z = (@TypeAnno Integer) x;

    }

    public static void main(String[] args) {
        myMethod(10);
    }

    // Annotating with inheritance clause
    class SomeClass extends @TypeAnno Example_TypeAnnotations<Boolean> {
        //
    }
}