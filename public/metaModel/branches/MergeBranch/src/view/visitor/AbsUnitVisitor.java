
package view.visitor;

import view.*;

public interface AbsUnitVisitor {
    
    public void handleUnit(UnitView unit) throws ModelException;
    public void handleCompUnit(CompUnitView compUnit) throws ModelException;
    
}
