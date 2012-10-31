package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MAtomicTypeProxi extends ViewProxi implements MAtomicTypeView{
    
    public MAtomicTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MAtomicTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi aspect = null;
        String aspect$String = (String)resultTable.get("aspect");
        if (aspect$String != null) {
            common.ProxiInformation aspect$Info = common.RPCConstantsAndServices.createProxiInformation(aspect$String);
            aspect = ViewProxi.createProxi(aspect$Info,connectionKey);
            aspect.setToString(aspect$Info.getToString());
        }
        MAtomicTypeView result$$ = new MAtomicType((String)name,(MAspectView)aspect, this.getId(), this.getClassId());
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
    
    public String getName() throws ModelException {
        return ((MAtomicType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MAtomicType)this.getTheObject()).setName(newValue);
    }
    public MAspectView getAspect() throws ModelException {
        return ((MAtomicType)this.getTheObject()).getAspect();
    }
    public void setAspect(MAspectView newValue) throws ModelException {
        ((MAtomicType)this.getTheObject()).setAspect(newValue);
    }
    
    public void accept(MTypeVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMAtomicType(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
