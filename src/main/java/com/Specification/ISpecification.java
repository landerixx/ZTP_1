package com.Specification;

/**
 * Created by Piotrek on 2017-03-30.
 */
public interface ISpecification<T> {

    boolean isSatisfiedBy(T o);
    ISpecification<T> and(ISpecification<T> specification);
    ISpecification<T> or (ISpecification<T> specification);
    ISpecification<T> not ();
}
