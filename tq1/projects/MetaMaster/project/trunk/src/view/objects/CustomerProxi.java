package view.objects;

import view.*;
import viewClient.*;

public class CustomerProxi extends RoleProxi implements CustomerView{
    
    public CustomerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public CustomerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi roleOwner = null;
        String roleOwner$String = (String)resultTable.get("roleOwner");
        if (roleOwner$String != null) {
            common.ProxiInformation roleOwner$Info = common.RPCConstantsAndServices.createProxiInformation(roleOwner$String);
            roleOwner = ViewProxi.createProxi(roleOwner$Info,connectionKey);
            roleOwner.setToString(roleOwner$Info.getToString());
        }
        CustomerView result$$ = new Customer((ActorView)roleOwner, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(view.visitor.RoleVisitor visitor) throws ModelException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(view.visitor.RoleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RoleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCustomer(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleCustomer(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCustomer(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCustomer(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCustomer(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Customer
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
