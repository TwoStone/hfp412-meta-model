
package model.visitor;

import persistence.MAccountTypeHierarchyHIERARCHY;
import persistence.PersistenceException;
import persistence.PersistentMAccountType;

public abstract class MAccountTypeHierarchyHIERARCHYStandardVisitor implements MAccountTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException{
        this.standardHandling(mAccountType);
    }
    protected abstract void standardHandling(MAccountTypeHierarchyHIERARCHY mAccountTypeHierarchyHIERARCHY) throws PersistenceException;
}
