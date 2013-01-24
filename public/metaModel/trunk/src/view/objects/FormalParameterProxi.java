package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FormalParameterProxi extends ViewProxi implements FormalParameterView{
    
    public FormalParameterProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FormalParameterView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi ofType = null;
        String ofType$String = (String)resultTable.get("ofType");
        if (ofType$String != null) {
            common.ProxiInformation ofType$Info = common.RPCConstantsAndServices.createProxiInformation(ofType$String);
            ofType = ViewProxi.createProxi(ofType$Info,connectionKey);
            ofType.setToString(ofType$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        FormalParameterView result$$ = new FormalParameter((MTypeView)ofType,(String)name, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getOfType() != null) return new OfTypeFormalParameterWrapper(this, originalIndex, (ViewRoot)this.getOfType());
        if(this.getOfType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOfType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getOfType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOfType() != null && this.getOfType().equals(child)) return result;
        if(this.getOfType() != null) result = result + 1;
        return -1;
    }
    
    public MTypeView getOfType() throws ModelException {
        return ((FormalParameter)this.getTheObject()).getOfType();
    }
    public void setOfType(MTypeView newValue) throws ModelException {
        ((FormalParameter)this.getTheObject()).setOfType(newValue);
    }
    public String getName() throws ModelException {
        return ((FormalParameter)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((FormalParameter)this.getTheObject()).setName(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFormalParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFormalParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFormalParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFormalParameter(this);
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