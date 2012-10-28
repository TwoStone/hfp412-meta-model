
package view.visitor;

import view.*;

public interface AbsUnitTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleTypeReference(TypeReferenceView typeReference) throws ModelException, E;
    public R handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException, E;
    public R handleUnitType(UnitTypeView unitType) throws ModelException, E;
    
}
