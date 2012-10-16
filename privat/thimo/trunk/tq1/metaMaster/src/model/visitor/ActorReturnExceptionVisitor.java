
package model.visitor;

import persistence.*;

public interface ActorReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException, E;
    public R handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException, E;
    public R handleActor(PersistentActor actor) throws PersistenceException, E;
    
}
