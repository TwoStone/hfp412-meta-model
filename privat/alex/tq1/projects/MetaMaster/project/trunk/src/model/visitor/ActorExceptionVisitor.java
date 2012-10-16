
package model.visitor;

import persistence.*;

public interface ActorExceptionVisitor<E extends model.UserException> {
    
    public void handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException, E;
    public void handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException, E;
    
}
