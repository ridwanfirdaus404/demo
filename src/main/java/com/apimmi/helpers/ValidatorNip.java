package com.apimmi.helpers;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @Constraint(validatedBy = ValidatorNipUniqe.class)
public @interface ValidatorNip {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
