
package view.visitor;

import view.*;

public interface AbsUnitReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleUnit(UnitView unit) throws ModelException, E;
    public R handleUnitReference(UnitReferenceView unitReference) throws ModelException, E;
    public R handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException, E;
    
}
