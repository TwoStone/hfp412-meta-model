
package view.visitor;

import view.*;

public abstract class AbsUnitStandardVisitor implements AbsUnitVisitor {
    
    public void handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException{
        this.standardHandling(compoundUnit);
    }
    public void handleUnitReference(UnitReferenceView unitReference) throws ModelException{
        this.standardHandling(unitReference);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    protected abstract void standardHandling(AbsUnitView absUnit) throws ModelException;
}
