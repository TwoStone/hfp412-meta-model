
package view.visitor;

import view.*;

public interface AbsUnitExceptionVisitor<E extends model.UserException> {
    
    public void handleUnit(UnitView unit) throws ModelException, E;
    public void handleUnitReference(UnitReferenceView unitReference) throws ModelException, E;
    public void handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException, E;
    
}
