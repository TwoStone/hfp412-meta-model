package view.objects;

import view.*;
import viewClient.*;

public class ServerProxi extends ViewProxi implements ServerView{
    
    public ServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi transactionManager = null;
        String transactionManager$String = (String)resultTable.get("transactionManager");
        if (transactionManager$String != null) {
            common.ProxiInformation transactionManager$Info = common.RPCConstantsAndServices.createProxiInformation(transactionManager$String);
            transactionManager = ViewProxi.createProxi(transactionManager$Info,connectionKey);
            transactionManager.setToString(transactionManager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((TransactionManagerView)transactionManager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(this.getTransactionManager() != null && index < this.getTransactionManager().getTheObject().getChildCount())
            return this.getTransactionManager().getTheObject().getChild(index);
        if(this.getTransactionManager() != null) index = index - this.getTransactionManager().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransactionManager() == null ? 0 : this.getTransactionManager().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTransactionManager() == null ? true : this.getTransactionManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getTransactionManager() != null && this.getTransactionManager().equals(child)) return result;
        if(this.getTransactionManager() != null) result = result + 1;
        return -1;
    }
    
    public TransactionManagerView getTransactionManager() throws ModelException {
        return ((Server)this.getTheObject()).getTransactionManager();
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
    
    public void accept(view.visitor.RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(view.visitor.RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Server
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
