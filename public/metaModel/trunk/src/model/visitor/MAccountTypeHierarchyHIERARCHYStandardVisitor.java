
package model.visitor;

import persistence.*;

public abstract class MAccountTypeHierarchyHIERARCHYStandardVisitor implements MAccountTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.standardHandling(mAccountType);
    }
    protected abstract void standardHandling(MAccountTypeHierarchyHIERARCHY mAccountTypeHierarchyHIERARCHY) throws PersistenceException;
}
