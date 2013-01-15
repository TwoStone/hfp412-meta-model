
package view.visitor;

import view.*;

public interface AbsUnitTypeVisitor {
    
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException;
    public void handleUnitType(UnitTypeView unitType) throws ModelException;
    
}
