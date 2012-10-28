
package view.visitor;

import view.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleTypeReference(TypeReferenceView typeReference) throws ModelException;
    public R handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException;
    public R handleUnitType(UnitTypeView unitType) throws ModelException;
    
}
