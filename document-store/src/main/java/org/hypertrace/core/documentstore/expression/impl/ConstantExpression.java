package org.hypertrace.core.documentstore.expression.impl;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.apache.commons.collections4.CollectionUtils;
import org.hypertrace.core.documentstore.expression.type.SelectTypeExpression;
import org.hypertrace.core.documentstore.parser.SelectTypeExpressionVisitor;

/**
 * Expression representing either a string constant, a numeric constant or a list of string/numeric
 * constants.
 *
 * <p>Example: <code>
 *    ConstantExpression.of(5);           // Numeric constant
 *    ConstantExpression.of("const");     // String constant
 *  </code>
 */
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantExpression implements SelectTypeExpression {

  Object value;

  public static ConstantExpression of(final String value) {
    return new ConstantExpression(value);
  }

  public static ConstantExpression of(final Number value) {
    return new ConstantExpression(value);
  }

  public static ConstantExpression of(final Boolean value) {
    return new ConstantExpression(value);
  }

  public static ConstantExpression ofStrings(final List<String> values) {
    return validateAndReturn(values);
  }

  public static ConstantExpression ofNumbers(final List<? extends Number> values) {
    return validateAndReturn(values);
  }

  public static ConstantExpression ofBooleans(final List<Boolean> values) {
    return validateAndReturn(values);
  }

  private static ConstantExpression validateAndReturn(final List<?> values) {
    if (CollectionUtils.isEmpty(values)) {
      throw new IllegalArgumentException(
          "At least one value must be present in ConstantExpression");
    }

    return new ConstantExpression(values);
  }

  @Override
  public <T> T accept(final SelectTypeExpressionVisitor visitor) {
    return visitor.visit(this);
  }
}
