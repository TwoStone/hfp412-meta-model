package persistence;


/* Additional import section end */

public interface Decoratees extends AbstractPersistentProxi {
    
    public persistence.AbstractPersistentRoot createDecorator() ;

    
}

