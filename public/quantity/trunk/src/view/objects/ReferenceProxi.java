package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ReferenceProxi extends ViewProxi implements ReferenceView{
    
    public ReferenceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ReferenceView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        long exponent = new Long((String)resultTable.get("exponent")).longValue();
        ViewProxi ref = null;
        String ref$String = (String)resultTable.get("ref");
        if (ref$String != null) {
            common.ProxiInformation ref$Info = common.RPCConstantsAndServices.createProxiInformation(ref$String);
            ref = ViewProxi.createProxi(ref$Info,connectionKey);
            ref.setToString(ref$Info.getToString());
        }
        ReferenceView result$$ = new Reference((ReferenceTypeView)type,(long)exponent,(UnitView)ref, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getType() != null) return new TypeReferenceWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        if(index == 0 && this.getRef() != null) return new RefReferenceWrapper(this, originalIndex, (ViewRoot)this.getRef());
        if(this.getRef() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getType() == null ? 0 : 1)
            + (this.getRef() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getType() == null ? true : false)
            && (this.getRef() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        if(this.getRef() != null && this.getRef().equals(child)) return result;
        if(this.getRef() != null) result = result + 1;
        return -1;
    }
    
    public ReferenceTypeView getType() throws ModelException {
        return ((Reference)this.getTheObject()).getType();
    }
    public void setType(ReferenceTypeView newValue) throws ModelException {
        ((Reference)this.getTheObject()).setType(newValue);
    }
    public long getExponent() throws ModelException {
        return ((Reference)this.getTheObject()).getExponent();
    }
    public void setExponent(long newValue) throws ModelException {
        ((Reference)this.getTheObject()).setExponent(newValue);
    }
    public UnitView getRef() throws ModelException {
        return ((Reference)this.getTheObject()).getRef();
    }
    public void setRef(UnitView newValue) throws ModelException {
        ((Reference)this.getTheObject()).setRef(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleReference(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReference(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Reference
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
