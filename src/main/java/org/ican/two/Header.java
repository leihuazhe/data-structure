package org.ican.two;

import java.lang.annotation.*;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-23 5:22 PM
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Header {

    String value() default "";

    boolean required() default true;


}
