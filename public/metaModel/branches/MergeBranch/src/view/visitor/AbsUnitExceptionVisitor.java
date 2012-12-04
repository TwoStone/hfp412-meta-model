
package view.visitor;
import view.UserException;
import view.*;

public interface AbsUnitExceptionVisitor<E extends UserException> {
    
    public void handleUnit(UnitView unit) throws ModelException, E;
    public void handleCompUnit(CompUnitView compUnit) throws ModelException, E;
    
}
