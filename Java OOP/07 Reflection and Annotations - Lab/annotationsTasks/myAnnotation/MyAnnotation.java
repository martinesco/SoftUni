package annotationsTasks.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target(ElementType.CONSTRUCTOR)
public @interface MyAnnotation {

    String value() default "asd";

    int val1() default 0;

    int max() default Integer.MAX_VALUE;

}
