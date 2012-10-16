
package view.visitor;

import view.*;

public interface ActorVisitor {
    
    public void handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException;
    public void handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException;
    public void handleActor(ActorView actor) throws ModelException;
    
}
