
package view.visitor;
import view.UserException;
import view.*;

public interface AbsUnitReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleUnit(UnitView unit) throws ModelException, E;
    public R handleCompUnit(CompUnitView compUnit) throws ModelException, E;
    
}
