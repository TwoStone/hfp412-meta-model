
package view.visitor;

import view.*;

public interface ActorReturnVisitor<R> {
    
    public R handleJuristicPerson(JuristicPersonView juristicPerson) throws ModelException;
    public R handleNaturalPerson(NaturalPersonView naturalPerson) throws ModelException;
    
}
