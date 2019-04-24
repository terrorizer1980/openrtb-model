/*
 * Copyright  2019 - present. MEDIA.NET ADVERTISING FZ-LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.media.utils.validator;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = CheckExactlyOneNotNull.CheckExactlyOneNotNullValidator.class)
@Documented
public @interface CheckExactlyOneNotNull {
  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String[] fieldNames();

  class CheckExactlyOneNotNullValidator
      implements ConstraintValidator<CheckExactlyOneNotNull, Object> {
    private String[] fieldNames;

    public void initialize(CheckExactlyOneNotNull constraint) {
      this.fieldNames = constraint.fieldNames();
    }

    public boolean isValid(Object object, ConstraintValidatorContext context) {
      if (object == null) {
        return true;
      }
      boolean firstField = false;
      try {
        for (String fieldName : fieldNames) {
          Object property = PropertyUtils.getProperty(object, fieldName);
          if (property != null) {
            if (firstField) {
              ValidatorErrorHandler.setErrorMessage(
                  context,
                  "exactly one of the following should be present: " + Arrays.toString(fieldNames));
              return false;
            }
            firstField = true;
          }
        }
        if (firstField) {
          return true;
        }
        ValidatorErrorHandler.setErrorMessage(
            context, "Exactly one of the following should be present: " + fieldNames);
        return false;
      } catch (Exception e) {
        ValidatorErrorHandler.setErrorMessage(
            context, "Exactly one of the following should be present: " + fieldNames);
        return false;
      }
    }
  }
}
