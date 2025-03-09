package Aufgabe7;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Documentation(description = "Annotation used to describe the implemented classes, interfaces, methods and constructors.",
    responsible = "Yoana Angelova")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR}) // Applicable to classes, interfaces, methods, and constructors
public @interface Documentation {
    String description() default "";
    String responsible() default "";
    String[] preconditions() default {};
    String[] postconditions() default {};
    String[] invariants() default {};
    String[] historyConstraints() default {};
}
