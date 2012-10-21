
package model.visitor;

import persistence.*;

public interface ActorReturnVisitor<R> {
    
    public R handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException;
    public R handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException;
    
}
