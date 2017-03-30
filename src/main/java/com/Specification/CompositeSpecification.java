package com.Specification;

/**
 * Created by Piotrek on 2017-03-30.
 */
public abstract  class CompositeSpecification <T> implements  ISpecification<T> {


    public  abstract boolean isSatisfiedBy(T o);


    public ISpecification<T> and(ISpecification<T> specification) {
        return new AndSpecification<T>(this,specification);
    }

    public ISpecification<T> or(ISpecification<T> specification) {
        return new OrSpecification<T>(this,specification);
    }

    public ISpecification<T> not() {
        return new NotSpecification<T>(this);
    }
}
