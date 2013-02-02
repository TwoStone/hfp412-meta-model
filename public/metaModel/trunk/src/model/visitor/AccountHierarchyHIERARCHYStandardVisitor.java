
package model.visitor;

import persistence.AccountHierarchyHIERARCHY;
import persistence.PersistenceException;
import persistence.PersistentAccount;

public abstract class AccountHierarchyHIERARCHYStandardVisitor implements AccountHierarchyHIERARCHYVisitor {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException{
        this.standardHandling(account);
    }
    protected abstract void standardHandling(AccountHierarchyHIERARCHY accountHierarchyHIERARCHY) throws PersistenceException;
}
