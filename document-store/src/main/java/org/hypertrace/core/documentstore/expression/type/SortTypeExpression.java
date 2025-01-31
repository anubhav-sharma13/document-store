package org.hypertrace.core.documentstore.expression.type;

import org.hypertrace.core.documentstore.expression.model.Hashable;
import org.hypertrace.core.documentstore.parser.SortTypeExpressionVisitor;

/**
 * An interface to represent that the expression can be used in the ORDER BY clause of the query.
 */
public interface SortTypeExpression extends Hashable {
  <T> T accept(final SortTypeExpressionVisitor visitor);
}
