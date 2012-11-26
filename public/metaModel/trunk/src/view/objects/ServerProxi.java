package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ServerProxi extends ViewProxi implements ServerView{
    
    public ServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi typeManager = null;
        String typeManager$String = (String)resultTable.get("typeManager");
        if (typeManager$String != null) {
            common.ProxiInformation typeManager$Info = common.RPCConstantsAndServices.createProxiInformation(typeManager$String);
            typeManager = ViewProxi.createProxi(typeManager$Info,connectionKey);
            typeManager.setToString(typeManager$Info.getToString());
        }
        ViewProxi aspectManager = null;
        String aspectManager$String = (String)resultTable.get("aspectManager");
        if (aspectManager$String != null) {
            common.ProxiInformation aspectManager$Info = common.RPCConstantsAndServices.createProxiInformation(aspectManager$String);
            aspectManager = ViewProxi.createProxi(aspectManager$Info,connectionKey);
            aspectManager.setToString(aspectManager$Info.getToString());
        }
        ViewProxi associationManager = null;
        String associationManager$String = (String)resultTable.get("associationManager");
        if (associationManager$String != null) {
            common.ProxiInformation associationManager$Info = common.RPCConstantsAndServices.createProxiInformation(associationManager$String);
            associationManager = ViewProxi.createProxi(associationManager$Info,connectionKey);
            associationManager.setToString(associationManager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((TypeManagerView)typeManager,(AspectManagerView)aspectManager,(AssociationManagerView)associationManager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getTypeManager() != null) return new TypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getTypeManager());
        if(this.getTypeManager() != null) index = index - 1;
        if(index == 0 && this.getAspectManager() != null) return new AspectManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAspectManager());
        if(this.getAspectManager() != null) index = index - 1;
        if(index == 0 && this.getAssociationManager() != null) return new AssociationManagerServerWrapper(this, originalIndex, (ViewRoot)this.getAssociationManager());
        if(this.getAssociationManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTypeManager() == null ? 0 : 1)
            + (this.getAspectManager() == null ? 0 : 1)
            + (this.getAssociationManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTypeManager() == null ? true : false)
            && (this.getAspectManager() == null ? true : false)
            && (this.getAssociationManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getTypeManager() != null && this.getTypeManager().equals(child)) return result;
        if(this.getTypeManager() != null) result = result + 1;
        if(this.getAspectManager() != null && this.getAspectManager().equals(child)) return result;
        if(this.getAspectManager() != null) result = result + 1;
        if(this.getAssociationManager() != null && this.getAssociationManager().equals(child)) return result;
        if(this.getAssociationManager() != null) result = result + 1;
        return -1;
    }
    
    public TypeManagerView getTypeManager() throws ModelException {
        return ((Server)this.getTheObject()).getTypeManager();
    }
    public AspectManagerView getAspectManager() throws ModelException {
        return ((Server)this.getTheObject()).getAspectManager();
    }
    public AssociationManagerView getAssociationManager() throws ModelException {
        return ((Server)this.getTheObject()).getAssociationManager();
    }
    public java.util.Vector<ErrorDisplayView> getErrors() throws ModelException {
        return ((Server)this.getTheObject()).getErrors();
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        ((Server)this.getTheObject()).setErrors(newValue);
    }
    public String getUser() throws ModelException {
        return ((Server)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws ModelException {
        ((Server)this.getTheObject()).setUser(newValue);
    }
    
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    
    
    public ServerConnection connectServer(ConnectionMaster master, ExceptionAndEventHandler handler) throws ModelException{
        ServerConnection result;
		try {
			result = (ServerConnection)new ServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
