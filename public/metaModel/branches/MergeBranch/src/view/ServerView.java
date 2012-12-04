package view;

import viewClient.*;

import view.objects.*;

import view.visitor.*;

public interface ServerView extends Remote, Anything, AbstractViewProxi {
    
    public TypeManagerView getTypeManager() throws ModelException ;
    public AspectManagerView getAspectManager() throws ModelException ;
    public AssociationManagerView getAssociationManager() throws ModelException ;
    public java.util.Vector<ErrorDisplayView> getErrors() throws ModelException ;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    public String getUser() throws ModelException ;
    public void setUser(String newValue) throws ModelException ;
    
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServerConnection connectServer(ConnectionMaster master, ExceptionAndEventHandler handler) throws ModelException;
}

