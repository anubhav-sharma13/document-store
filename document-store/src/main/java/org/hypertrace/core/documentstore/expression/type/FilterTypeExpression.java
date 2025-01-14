package org.hypertrace.core.documentstore.expression.type;

import org.hypertrace.core.documentstore.expression.model.Hashable;
import org.hypertrace.core.documentstore.parser.FilterTypeExpressionVisitor;

/**
 * An interface to represent that the expression can be used in either the WHERE clause or the
 * HAVING clause of the query.
 */
public interface FilterTypeExpression extends Hashable {
  <T> T accept(final FilterTypeExpressionVisitor visitor);
}
