package com.pbe;

/** Study on Annotations
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// ANNOTATION
// *********************
//
// Annotation basics
// Annotations are a form of metadata and embed supplemental information about a program, without changing the actions of a program.
// I.e.: annotations have no direct effect on the operation of the annotated code.
// However, the information can be used various tools during both development and deployment:
// - As info the compiler, annotations can be used by the compiler to detect errors or suppress warnings.
// - As info for compile-time and deployment-time processing, annotations can be processed by software tools to generate code, XML files, etc.
// - As info for runtime processing, annotations can be examined at runtime.
//
// Besides the possibility of defining own annotation types, there are also standard Java annotations available, defined in java.lang or java.lang.annotation packages.
//
// In its simplest form, an annotation looks like: @Entity
// The @ sign is used to tell the compiler that an annotation type is being declared.
// The keyword that follows the @ sign, is the annotation name.
//
// Note: by convention, each annotation appears on its own line.
//
// Annotation can include elements, which can be named or unnamed, and that can be given values.
// @Author(
//    name = "Author Name",
//    date = "01/12/1985"
// )
// If the annotation has no elements, then the parentheses can be left out, just like @Entity
//
// It's possible to use multiple annotations on the same declaration. For example:
// @Author(name = "Author Name")
// @EBook
// class MyBookClass { ... }
//
// The annotations @Author and @EBook are linked to class MyBookClass
// The string "Author name" is assigned to the string member 'name' of Author.
// When an annotation member is given a value, only its name is used. As such, they look like fields in this context.
//
// If annotations have the same type, then this is called a repeating annotation (supported since JDK8):
// @Author(name = "Author Name1")
// @Author(name = "Author Name2")
// class MyClass { ... }

// Use of annotations
// Once an annotation is declared, it can be used to annotate anything.
// Any type of declaration -such as classes, methods, fields, parameters, enum constants- can have an annotation associated with it.
//
// As of JDK8, annotations can also be applied to the use of types, a 'type annotation'. For example:
// - Class instance creation expression: new @Interned MyObject();
// - Type cast: myString = (@NonNull String) str;
// - Implements clause:
//   class UnmodifiableList<T> implements
//      @Readonly List<@Readonly T> { ... }
// - Thrown exception declaration:
//   void monitorTemperature() throws
//      @Critical TemperatureException { ... }

// Declaring an annotation type
// Annotations are created through a mechanism based on the interface.
// Declaring an annotation type looks similar to an interface definition where the keyword interface is preceded by the @ sign. For example:
// @Interface MyAnnotation {
//    String str();
//    int val();
// }
//
// After creation of the annotation type, annotations of that type can be used with the values filled in, like this:
// @MyAnnotation {
//    str = "Some text";
//    val = 100;
// }
//

// Javadoc-generated documentation
// To have information in an annotation appear in Javadoc-generated documentation, it must be annotated with the @Documentation annotation. For example:
// import java.lang.annotation.*;
// @Documented
// @interface MyAnnotation {
// // Annotation element definitions
// }

// Predefined annotation types
// The Java API has a predefined set of annotation types defined in java.lang:
// 1. @Deprecated - indicates that the marked element should not longer be used, which will have the compiler generate a warning whenever the annotated code is used.
// 2. @Override - informs the compiler that the element is meant to override an element declared in the superclass.
//    Using this annotation when overriding is not mandatory, but helps clarify. Also, if a method marked @Override fails to correctly override a method, the compiler generates an error.
// 3. @SuppressWarnings - tells the compiler to suppress specific warnings that it would otherwise generate.
//    Note that Java lists two categories of warnings: deprecation and unchecked. To suppress both categories use the syntax: @SuppressWarnings({"unchecked", "deprecation"})
// 4. @SafeVarargs - when applied to a method or constructor, asserts that the code does not perform potentially unsafe operations on its varargs parameter. Unchecked warnings related to varargs usage are suppressed.
// 5. @FunctionalInterface - indicates that the type declaration is intended to be a functional interface

// Annotations that apply to other annotations
//  Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types defined in java.lang.annotation:
// 1. @Retention - specifies how the marked annotation is stored. See retentionpolicy for more info.
// 2. @Documented - indicates that whenever the specified annotation is used those elements should be documented using the Javadoc tool
// 3. @Target - marks another annotation to restrict what kind of Java elements the annotation can be applied to
// 4. @Inherited - indicates that the annotation type can be inherited from the super class (not true by default)
// 5. @Repeatable - indicates that the marked annotation can be applied more than once to the same declaration or type use. For more info see repeating annotations.

// Type Annotations and Pluggable Type Systems
// As of the Java SE 8 release, annotations can also be applied to any type use.
// This means that annotations can be used anywhere you use a type. For example class instance creation expressions (new), casts, implements clauses and throws clauses.
// Type annotations are supposed to support stronger type checking.
// JDK does not provide a type checking framework, but it does allow to write or use a third party plugin.
// For example, to ensure that a particular variable in a program is never assigned to null and avoid triggering a NullPointerException, a plug-in to check for this could be written.
// The particular variable could be annotated, indicating that it is never to be assigned to null. For example: @NonNull String str;
// The compiler could then print a warning if it detects a potential problem, allowing the code to be modified to avoid the error.

// Repeating annotations
// There are some situations where you want to apply the same annotation to a declaration or type use.
// This can be done with 'repeating annotations'. For example:
// @Schedule(dayOfMonth="last")
// @Schedule(dayOfWeek="Fri", hour="23")
// public void doPeriodicCleanup() { ... }

// Specifying a retention policy
// A retention policy -specified by Java's build-in annotation @Retention(retention-policy)- determines at what point an annotation is discarded.
// Java defines three policies (within java.annotation.RetentionPolicy):
// 1. SOURCE - retained only in the source file and discarded during compilation
// 2. CLASS - stored in .class file during compilation and NOT available through the JVM during run time
// 3. RUNTIME - stored in .class file during compilation and IS available through the JVM during run time
// RUNTIME retention offers the greatest annotation persistence. Example:
// @Retention(RetentionPolicy.RUNTIME)
// @Interface MyAnnotation { .. }

// Obtaining annotations at run time by use of reflection
// Annotations that are specified with the retention policy of RUNTIME, can be queried at run time through the use of reflection (java.lang.reflect).
// This is a feature that enables information about a class to be obtained at run time.
// T.B.D.

// Notes:
// Annotations can't be extended, but automatically extend the Annotation interface (java.lang.annotation package)
// This makes Annotation a super-interface of all annotations.
// Annotation overrides hashCode(), equals() and toString(), which are defined by Object.
// Annotation specifies annotationType(), which returns a Class object that represents the invoking annotation.

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    // Example of annotation in it's simplest form
//    @MyAnnotation

    // Example of annotation with elements
//    @Author(
//    name = "Author Name",
//    date = "01/12/1985"
//    )

    // Example of using multiple annotations on the same declaration
//    @Author(name = "Author Name")
//    @EBook
//    class MyBookClass { ... }

    // Example of annotation with the same type; a repeating annotation (supported since JDK8)
//    @Author(name = "Author Name1")
//    @Author(name = "Author Name2")
//    class MyClass { ... }

    // Example of a 'type annotation' (annotation applied to the use of types - possible since JDK8)
    // 1. Class instance creation expression:
//    new @Interned MyObject();
    // 2. Type cast:
//    myString = (@NonNull String) str;
    // 3. Implements clause:
//    class UnmodifiableList<T> implements
//        @Readonly List<@Readonly T> { ... }
    // 4. Thrown exception declaration:
//    void monitorTemperature() throws
//        @Critical TemperatureException { ... }

    // Example of annotation with retention policy
//    @Retention(RetentionPolicy.RUNTIME)
//    @Interface MyAnnotation {
//        String input();
//        int num();
//    }

    // Example of an annotation type declaration
//    @interface MyAnnotation { // the @ tells the compiler an annotation type is being declared
//        String input();
//        int num();
//    }

}