
package view.visitor;

import view.*;

public abstract class ActorStandardVisitor implements ActorVisitor {
    
    public void handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException{
        this.standardHandling(juristicPerson);
    }
    public void handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException{
        this.standardHandling(naturalPerson);
    }
    protected abstract void standardHandling(ActorView actor) throws ModelException;
}
