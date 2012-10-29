
package view.visitor;
import view.UserException;
import view.*;

public interface AbsUnitTypeExceptionVisitor<E extends UserException> {
    
    public void handleUnitType(UnitTypeView unitType) throws ModelException, E;
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException, E;
    
}