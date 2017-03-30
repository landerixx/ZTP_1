package com.Specification;


import java.util.function.Predicate;

/**
 * Created by Piotrek on 2017-03-30.
 */
public class ExpressionSpecification<T> extends CompositeSpecification<T> {

    Predicate<T> expression;

    ExpressionSpecification(Predicate<T> expression){

        this.expression=expression;
    }


    public boolean isSatisfiedBy(T o) {
        return this.expression.test(o);
    }
}
