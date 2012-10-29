
package view.visitor;

import view.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleUnitType(UnitTypeView unitType) throws ModelException;
    public R handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException;
    
}
