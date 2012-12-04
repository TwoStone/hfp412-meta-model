
package view.visitor;

import view.*;

public abstract class AbsUnitStandardVisitor implements AbsUnitVisitor {
    
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    protected abstract void standardHandling(AbsUnitView absUnit) throws ModelException;
}
