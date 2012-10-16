package model.meta;

public interface ActorMssgsVisitor extends ActorDOWNMssgsVisitor, ActorUPMssgsVisitor {}


interface ActorDOWNMssgsVisitor extends JuristicPersonDOWNMssgsVisitor, NaturalPersonDOWNMssgsVisitor {

    
}


interface ActorUPMssgsVisitor  {

    
}
