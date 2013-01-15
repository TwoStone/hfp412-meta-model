
package view.visitor;

import view.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException;
    public R handleUnitType(UnitTypeView unitType) throws ModelException;
    
}
