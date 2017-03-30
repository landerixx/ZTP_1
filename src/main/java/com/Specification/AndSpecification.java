package com.Specification;

/**
 * Created by Piotrek on 2017-03-30.
 */
public class AndSpecification<T> extends CompositeSpecification<T> {

    ISpecification<T> leftSpec;
    ISpecification<T> rigtSpec;

    public AndSpecification(ISpecification<T> left, ISpecification<T> right) {

        this.leftSpec=left;
        this.rigtSpec=right;

    }

    public boolean isSatisfiedBy(T o) {
        return leftSpec.isSatisfiedBy(o) && rigtSpec.isSatisfiedBy(o);
    }
}
