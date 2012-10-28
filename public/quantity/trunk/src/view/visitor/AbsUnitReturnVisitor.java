
package view.visitor;

import view.*;

public interface AbsUnitReturnVisitor<R> {
    
    public R handleUnit(UnitView unit) throws ModelException;
    public R handleUnitReference(UnitReferenceView unitReference) throws ModelException;
    public R handleCompoundUnit(CompoundUnitView compoundUnit) throws ModelException;
    
}
