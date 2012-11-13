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
        ViewProxi quantityManager = null;
        String quantityManager$String = (String)resultTable.get("quantityManager");
        if (quantityManager$String != null) {
            common.ProxiInformation quantityManager$Info = common.RPCConstantsAndServices.createProxiInformation(quantityManager$String);
            quantityManager = ViewProxi.createProxi(quantityManager$Info,connectionKey);
            quantityManager.setToString(quantityManager$Info.getToString());
        }
        ViewProxi unitTypeManager = null;
        String unitTypeManager$String = (String)resultTable.get("unitTypeManager");
        if (unitTypeManager$String != null) {
            common.ProxiInformation unitTypeManager$Info = common.RPCConstantsAndServices.createProxiInformation(unitTypeManager$String);
            unitTypeManager = ViewProxi.createProxi(unitTypeManager$Info,connectionKey);
            unitTypeManager.setToString(unitTypeManager$Info.getToString());
        }
        ViewProxi conversionManager = null;
        String conversionManager$String = (String)resultTable.get("conversionManager");
        if (conversionManager$String != null) {
            common.ProxiInformation conversionManager$Info = common.RPCConstantsAndServices.createProxiInformation(conversionManager$String);
            conversionManager = ViewProxi.createProxi(conversionManager$Info,connectionKey);
            conversionManager.setToString(conversionManager$Info.getToString());
        }
        ViewProxi fractionManager = null;
        String fractionManager$String = (String)resultTable.get("fractionManager");
        if (fractionManager$String != null) {
            common.ProxiInformation fractionManager$Info = common.RPCConstantsAndServices.createProxiInformation(fractionManager$String);
            fractionManager = ViewProxi.createProxi(fractionManager$Info,connectionKey);
            fractionManager.setToString(fractionManager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((QuantityManagerView)quantityManager,(UnitTypeManagerView)unitTypeManager,(ConversionManagerView)conversionManager,(FractionManagerView)fractionManager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getQuantityManager() != null) return new QuantityManagerServerWrapper(this, originalIndex, (ViewRoot)this.getQuantityManager());
        if(this.getQuantityManager() != null) index = index - 1;
        if(index == 0 && this.getUnitTypeManager() != null) return new UnitTypeManagerServerWrapper(this, originalIndex, (ViewRoot)this.getUnitTypeManager());
        if(this.getUnitTypeManager() != null) index = index - 1;
        if(index == 0 && this.getConversionManager() != null) return new ConversionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getConversionManager());
        if(this.getConversionManager() != null) index = index - 1;
        if(index == 0 && this.getFractionManager() != null) return new FractionManagerServerWrapper(this, originalIndex, (ViewRoot)this.getFractionManager());
        if(this.getFractionManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getQuantityManager() == null ? 0 : 1)
            + (this.getUnitTypeManager() == null ? 0 : 1)
            + (this.getConversionManager() == null ? 0 : 1)
            + (this.getFractionManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getQuantityManager() == null ? true : false)
            && (this.getUnitTypeManager() == null ? true : false)
            && (this.getConversionManager() == null ? true : false)
            && (this.getFractionManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getQuantityManager() != null && this.getQuantityManager().equals(child)) return result;
        if(this.getQuantityManager() != null) result = result + 1;
        if(this.getUnitTypeManager() != null && this.getUnitTypeManager().equals(child)) return result;
        if(this.getUnitTypeManager() != null) result = result + 1;
        if(this.getConversionManager() != null && this.getConversionManager().equals(child)) return result;
        if(this.getConversionManager() != null) result = result + 1;
        if(this.getFractionManager() != null && this.getFractionManager().equals(child)) return result;
        if(this.getFractionManager() != null) result = result + 1;
        return -1;
    }
    
    public QuantityManagerView getQuantityManager() throws ModelException {
        return ((Server)this.getTheObject()).getQuantityManager();
    }
    public UnitTypeManagerView getUnitTypeManager() throws ModelException {
        return ((Server)this.getTheObject()).getUnitTypeManager();
    }
    public ConversionManagerView getConversionManager() throws ModelException {
        return ((Server)this.getTheObject()).getConversionManager();
    }
    public FractionManagerView getFractionManager() throws ModelException {
        return ((Server)this.getTheObject()).getFractionManager();
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
