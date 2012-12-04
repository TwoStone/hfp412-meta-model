
package view.visitor;

import view.*;

public abstract class AbsUnitTypeStandardVisitor implements AbsUnitTypeVisitor {
    
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(AbsUnitTypeView absUnitType) throws ModelException;
}
