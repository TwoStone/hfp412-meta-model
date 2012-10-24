
package view.visitor;

import view.*;

public interface AbsUnitTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleTypeReference(TypeReferenceView typeReference) throws ModelException, E;
    public void handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException, E;
    public void handleUnitType(UnitTypeView unitType) throws ModelException, E;
    
}
