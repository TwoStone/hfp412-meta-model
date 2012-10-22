package view;

import view.objects.*;

public interface RolleView extends Anything, AbstractViewProxi {
    
    public AkteurView getRolleFuer() throws ModelException ;
    public void setRolleFuer(AkteurView newValue) throws ModelException ;
    
    public void accept(view.visitor.RolleVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RolleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RolleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

