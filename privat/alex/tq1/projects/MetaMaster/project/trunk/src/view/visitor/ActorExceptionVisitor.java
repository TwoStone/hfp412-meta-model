
package view.visitor;

import view.*;

public interface ActorExceptionVisitor<E extends model.UserException> {
    
    public void handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException, E;
    public void handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException, E;
    
}
