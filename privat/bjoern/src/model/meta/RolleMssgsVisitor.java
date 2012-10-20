package model.meta;

public interface RolleMssgsVisitor extends RolleDOWNMssgsVisitor, RolleUPMssgsVisitor {}


interface RolleDOWNMssgsVisitor extends LieferantDOWNMssgsVisitor, KundeDOWNMssgsVisitor {

    
}


interface RolleUPMssgsVisitor  {

    
}
