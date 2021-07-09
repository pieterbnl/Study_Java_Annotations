package com.pbe;

import java.lang.annotation.RetentionPolicy;

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
// Put differently: annotations are meta-meta-objects which can be used to describe other meta-objects.
// Meta-objects are classes, fields and methods.
// Asking an object for its meta-object is called introspection.
// Introspection and annotations are a form of reflection and meta-programming.
//
// Annotations can be interpreted at development-time by the IDE or the compiler, or at run-time by a framework:
// - As info the compiler, annotations can be used by the compiler to detect errors or suppress warnings.
// - As info for compile-time and deployment-time processing, annotations can be processed by software tools to generate code, XML files, etc.
// - As info for runtime processing, annotations can be examined at runtime.
//
// Annotation processing is a very powerful mechanism and can be used in a lot of different ways:
// - to describe constraints or usage of an element: e.g. @Deprecated, @Override, or @NotNull
// - to describe the "nature" of an element, e.g. @Entity, @TestCase, @WebService
// - to describe the behavior of an element: @Statefull, @Transaction
// - to describe how to process the element: @Column, @XmlElement
// Annotations describe the element and clarify its meaning.
//
// Usage of annotations:
// - by compiler to detect errors and suppress warnings
// - by software tools to generate code, xml files, documentation etc., For example, Javadoc use annotations while generating java documentation for your class.
// - to describe the constraints (Ex: @Null, @NotNull, @Max, @Min, @Email).
// - to describe type of an element. Ex: @Entity, @Repository, @Service, @Controller, @RestController, @Resource etc.,
// - to specify the behaviour. Ex: @Transactional, @Stateful
// - to specify how to process an element. Ex: @Column, @Embeddable, @EmbeddedId
// - in testing frameworks, to define test cases (@Test), define test suites (@Suite) etc.,
// - in AOP (Aspect Oriented programming) use annotations (@Before, @After, @Around etc.,)
// - in ORM tools like Hibernate, Eclipselink use annotations
//
// Documentation, Compilation, IDE, Testing frameworks, IoC containers, Serialization, Aspect-oriented programming (AOP), Application servers, Object-relational mapping (ORM), etc.
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

// Predefined/build-in annotation types
// The Java API has a predefined set of annotation types defined in java.lang.
// Most are specialized, but nine are general purpose.
// Of these, four are imported from java.lang.annotation: @Retention, @Documented, @Target, @Inherited
// And five are are included in java.lang: @Override, @Deprecated, @FunctionalInterface, @SafeVarargs, @SuppressWarnings
// 1. @Deprecated - indicates that the marked element should not longer be used (and allows to specify from which Java version), which will have the compiler generate a warning whenever the annotated code is used.
// 2. @Override - informs the compiler that the element is meant to override an element declared in the superclass. Can only be used on methods.
//    Using this annotation when overriding is not mandatory, but helps clarify. Also, if a method marked @Override fails to correctly override a method, the compiler generates an error.
// 3. @SuppressWarnings - tells the compiler to suppress specific warnings that it would otherwise generate.
//    Note that Java lists two categories of warnings: deprecation and unchecked. To suppress both categories use the syntax: @SuppressWarnings({"unchecked", "deprecation"})
// 4. @SafeVarargs - a marker annotation that can be applied methods and constructors; asserts that the code does not perform potentially unsafe operations on its varargs parameter.
//    Unchecked warnings related to varargs usage are suppressed. Methods must be static, final or private.
// 5. @FunctionalInterface - designed for use on interfaces, indicates that the annotated interface is a functional interface (= an interface that contains only one abstract method; they are used in lambda expressions)
//    Note that it's not mandatory to use @FunctionalInterface. Any interface with only one extract method is by definition a functional interface. Like @Override, @FunctionalInterface is mostly informative.

// Annotations that apply to other annotations
//  Annotations that apply to other annotations are called meta-annotations. There are several meta-annotation types defined in java.lang.annotation:
// 1. @Retention - specifies how the marked annotation is stored. See retention policy for more info. I.e. @Retention is designed to be used only as an annotation to another annotation.
// 2. @Documented - is a marker interface that indicates that an annotation is to be documented using the Javadoc tool. Designed to be used as an annotation to an annotation declaration.
// 3. @Target - marks another annotation to restrict what kind of Java elements the annotation can be applied to (which is to be specified in an array of constants that @Target takes as argument)
// 4. @Inherited - indicates that the annotation type can be inherited from the super class (not true by default) and causes the annotation to be inherited by a subclass. Can only be used on another annotation declaration.
// 5. @Repeatable - indicates that the marked annotation can be applied more than once to the same declaration or type use. For more info see repeating annotations.
// 6. @Native - annotates a field that can be accessed by native code

// Type Annotations and Pluggable Type Systems
// As of the Java SE 8 release, annotations can also be applied to any type use.
// This means that annotations can be used anywhere you use a type.
// For example you can annotate the return type of a method, the type of this within a method, a cast, array levels,
// an inherited class, class instance creation expressions (new), casts, implements clauses and throws clauses.
// It's also possible to annotate generic types, including generic type parameter bounds an generic type arguments.
//
// Type annotations are supposed to support stronger type checking. They enable tools to perform additional checks on code to prevent errors.
// JDK does not provide a type checking framework by itself, but it does allow to write or use a third party plugin.
// For example, to ensure that a particular variable in a program is never assigned to null and avoid triggering a NullPointerException, a plug-in to check for this could be written.
// The particular variable could be annotated, indicating that it is never to be assigned to null. For example: @NonNull String str;
// The compiler could then print a warning if it detects a potential problem, allowing the code to be modified to avoid the error.
//
// A type annotation must include ElementType.TYPE_USE as a target (note: valid annotation targets are specified using @Target as annotation)
// For example to annotate a NullPointerException in throws clause:
// void myMethod() throws @TypeAnnotation NullPointerException { // ...


// Repeating annotations
// There are some situations where you want to apply the same annotation to a declaration or type use.
// This can be done with 'repeating annotations'.
// For an annotation to be repeatable, it must be annotated with @Repeatable, defined in java.lang.annotation.
// Its value field specifies the 'container' type for the repeatable annotation.
// The container is specified as an annotation for which the value field is an array of the repeatable annotation type.
// I.e.: to create a repeatable annotation, 1) a container annotation must be created and 2) have the annotation type specified as an argument to the @Repeatable annotation
// See repeated annotation example.

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

// AnnotatedElement interface
// The AnnotatedElement interface is defined in java.lang.reflect and supports reflection for annotations.
// It's -among others- implemented by the classes Method, Field, Constructor, Class and Package.
// It defines several methods such as:
// - getAnnotation()
// - getAnnotations() - to obtain an array of all annotations associated with an item (class, method, constructor, field, ..) [note: needs to apply RUNTIME retention]
// - getDeclaredAnnotations() - returns all non-inherited annotations present in the invoking object
// - isAnnotationPresent() - returns true if the annotation specified is associated with the invoking object

// Using default values
// Annotation members can be given default values that will be used if no value is specified when the annotation is applied.
// It's possible to specify none, or one or more values if desired. If no values are specified, the default values will be used.
// See the added Default_Values examples.

// Marker annotations
// A marker annotation is a special kind of annotation that contains no members.
// It's sole purpose is to mark an item, making it's presence as an annotation sufficient.
// The isAnnotationPresent() method can be used to determine if a marker annotation is present.

// Single member annotations
// A single member annotation contains only one member.
// It works like any annotation, but allows a shorthand form of specifying the value of the member.
// The value for the single member can be specified when the annotation is applied.
// In order to use the shorthand, the name of the member must be value!

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

    // Example of using default value with annotation
//    @Retention (RetentionPolicy.RUNTIME)
//    @interface MyAnnotation {
//        String userinput() default "Default user input";
//        int num() default 99;
//    }

}