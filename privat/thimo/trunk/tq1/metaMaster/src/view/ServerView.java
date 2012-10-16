package view;

import viewClient.*;
import view.objects.*;

public interface ServerView extends Remote, Anything, AbstractViewProxi {
    
    public ActorManagerView getActorManager() throws ModelException ;
    public java.util.Vector<ErrorDisplayView> getErrors() throws ModelException ;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    public String getUser() throws ModelException ;
    public void setUser(String newValue) throws ModelException ;
    
    public void accept(view.visitor.RemoteVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServerConnection connectServer(ConnectionMaster master, ExceptionAndEventHandler handler) throws ModelException;
}

