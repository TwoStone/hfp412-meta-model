package view.objects;

import view.*;
import viewClient.*;

public class KundeProxi extends RolleProxi implements KundeView{
    
    public KundeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public KundeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi rolleFuer = null;
        String rolleFuer$String = (String)resultTable.get("rolleFuer");
        if (rolleFuer$String != null) {
            common.ProxiInformation rolleFuer$Info = common.RPCConstantsAndServices.createProxiInformation(rolleFuer$String);
            rolleFuer = ViewProxi.createProxi(rolleFuer$Info,connectionKey);
            rolleFuer.setToString(rolleFuer$Info.getToString());
        }
        KundeView result$$ = new Kunde((AkteurView)rolleFuer, this.getId(), this.getClassId());
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
    
    
    public void accept(view.visitor.RolleVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(view.visitor.RolleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.RolleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleKunde(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKunde(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKunde(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKunde(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Kunde
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
