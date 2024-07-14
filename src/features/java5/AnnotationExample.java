package features.java5;

// Java Annotation is a tag that represents the metadata attached with class, interface or field
// to indicate some additional information which can be used by java compiler and JVM

// Build-in Annotations

// used in Java code
// @Override: assures the subclass method is overriding  the parent class method
// @SuppressWarning: is used to suppress warnings issued by the compiler
// @Deprecated: compiler prints warning informed user that it may be removed in the future version.

// used in other annotations
// @Target: is used to specify at which type, the annotation is used
// (ElementType.TYPE|FIELD|METHOD|CONSTRUCTOR|LOCAL_VARIABLE|ANNOTATION_TYPE|PARAMETER)

// @Retention: is sued to specify to what level annotation will be available (RetentionPolicy.SOURCE|CLASS|RUNTIME)
// RetentionPolicy.SOURCE: refers to the source code, discarded during compilation
// RetentionPolicy.CLASS: refers to the .class file, available to java compiler but not to JVM
// RetentionPolicy.RUNTIME: refers to the runtime, available to java compiler and JVM

// @Inherited: annotations are not inherited to subclasses. The @Inherited annotations marks the annotation to be inherited to subclasses
// @Document: marks the annotation for inclusion in the documentation

// @interface MyAnnotations{}: is used to declare an annotation
// method should not have any throws clause, return the following: primitive data types, String, Class, arrays
// should not have any parameter, might assign a default value

// Type of annotations
// Marker Annotation: has no method
// Single-Value, Multi-Value Annotation

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define annotations
@Target(ElementType.METHOD)
@interface MyMarkerAnnotation{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MySingleValueAnnotation{
    int value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@interface MyMultiValueAnnotation{
    int value1() default 1;
    String value2() default "ABC";
}

// Apply annotations
class Hello {
    @MySingleValueAnnotation(value=10)
    public void sayHello() {
        System.out.println("Hello annotation");
    }
}
public class AnnotationExample {
    public static void main(String[] args) throws NoSuchMethodException {
        Hello h = new Hello();
        Method m = h.getClass().getMethod("sayHello");
        MySingleValueAnnotation manno = m.getAnnotation(MySingleValueAnnotation.class);
        System.out.println("Value is: " + manno.value());
    }
}
