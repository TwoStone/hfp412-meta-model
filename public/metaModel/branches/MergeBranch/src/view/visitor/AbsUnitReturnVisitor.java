
package view.visitor;

import view.*;

public interface AbsUnitReturnVisitor<R> {
    
    public R handleUnit(UnitView unit) throws ModelException;
    public R handleCompUnit(CompUnitView compUnit) throws ModelException;
    
}
