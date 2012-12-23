
package view.visitor;
import view.UserException;
import view.*;

public interface AbsUnitTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleUnitType(UnitTypeView unitType) throws ModelException, E;
    public R handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException, E;
    
}
