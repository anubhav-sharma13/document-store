package org.hypertrace.core.documentstore.mongo.parser;

import java.util.Map;
import org.hypertrace.core.documentstore.expression.impl.AggregateExpression;
import org.hypertrace.core.documentstore.query.Query;

public class MongoNonAggregationSelectingExpressionParser extends MongoSelectingExpressionParser {

  public MongoNonAggregationSelectingExpressionParser(final Query query) {
    super(query);
  }

  @Override
  public Map<String, Object> parse(final AggregateExpression expression) {
    return null;
  }
}