package org.hypertrace.core.documentstore.expression;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UnaryOperatorExpression implements OperatorExpression {
  private final Expression operand;
  private final UnaryOperator operation;

  @Override
  public String toString() {
    return String.format("%s(%s)", operation, operand.toString());
  }
}
