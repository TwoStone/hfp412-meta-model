
package view.visitor;

import view.*;

public interface AbsUnitTypeVisitor {
    
    public void handleUnitType(UnitTypeView unitType) throws ModelException;
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException;
    
}
