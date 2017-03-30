package com.Specification;

/**
 * Created by Piotrek on 2017-03-30.
 */
public class NotSpecification<T> extends CompositeSpecification<T> {

    ISpecification spec;

    public NotSpecification(ISpecification spec){
        this.spec=spec;
    }

    public boolean isSatisfiedBy(T o) {
        return ! spec.isSatisfiedBy(o);
    }
}
