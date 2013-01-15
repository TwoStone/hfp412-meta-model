package view;

import view.objects.*;

import view.visitor.*;

public interface MessageOrLinkView extends Anything, AbstractViewProxi {
    
    public InstanceObjectView getSource() throws ModelException ;
    public void setSource(InstanceObjectView newValue) throws ModelException ;
    public InstanceObjectView getTarget() throws ModelException ;
    public void setTarget(InstanceObjectView newValue) throws ModelException ;
    
    public void accept(MessageOrLinkVisitor visitor) throws ModelException;
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

