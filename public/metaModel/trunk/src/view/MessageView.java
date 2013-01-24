package view;

import view.visitor.*;

public interface MessageView extends MessageOrLinkView {
    
    public OperationView getType() throws ModelException ;
    public void setType(OperationView newValue) throws ModelException ;
    public java.util.Vector<ActualParameterView> getActualParameters() throws ModelException ;
    public void setActualParameters(java.util.Vector<ActualParameterView> newValue) throws ModelException ;
    
    public void accept(MessageOrLinkVisitor visitor) throws ModelException;
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}
