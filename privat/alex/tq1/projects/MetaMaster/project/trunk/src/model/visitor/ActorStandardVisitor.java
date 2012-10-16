
package model.visitor;

import persistence.*;

public abstract class ActorStandardVisitor implements ActorVisitor {
    
    public void handleJuristicPerson(PersistentJuristicPerson juristicPerson) throws PersistenceException{
        this.standardHandling(juristicPerson);
    }
    public void handleNaturalPerson(PersistentNaturalPerson naturalPerson) throws PersistenceException{
        this.standardHandling(naturalPerson);
    }
    protected abstract void standardHandling(PersistentActor actor) throws PersistenceException;
}
