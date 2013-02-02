
package model.visitor;

import persistence.*;

public abstract class AccountHierarchyHIERARCHYStandardVisitor implements AccountHierarchyHIERARCHYVisitor {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    protected abstract void standardHandling(AccountHierarchyHIERARCHY accountHierarchyHIERARCHY) throws PersistenceException;
}
