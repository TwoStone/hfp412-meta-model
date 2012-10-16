
package model.visitor;

import persistence.*;

public interface ActorVisitor {
    
    public void handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException;
    public void handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException;
    public void handleActor(PersistentActor actor) throws PersistenceException;
    
}
