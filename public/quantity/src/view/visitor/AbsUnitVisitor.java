
package view.visitor;

import view.*;

public interface AbsUnitVisitor {
    
    public void handleUnit(UnitView unit) throws ModelException;
    public void handleUnitReference(UnitReferenceView unitReference) throws ModelException;
    public void handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException;
    
}
