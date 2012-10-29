package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ReferenceTypeProxi extends ViewProxi implements ReferenceTypeView{
    
    public ReferenceTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ReferenceTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long exponent = new Long((String)resultTable.get("exponent")).longValue();
        ViewProxi ref = null;
        String ref$String = (String)resultTable.get("ref");
        if (ref$String != null) {
            common.ProxiInformation ref$Info = common.RPCConstantsAndServices.createProxiInformation(ref$String);
            ref = ViewProxi.createProxi(ref$Info,connectionKey);
            ref.setToString(ref$Info.getToString());
        }
        ReferenceTypeView result$$ = new ReferenceType((long)exponent,(UnitTypeView)ref, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getRef() != null) return new RefReferenceTypeWrapper(this, originalIndex, (ViewRoot)this.getRef());
        if(this.getRef() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRef() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getRef() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getRef() != null && this.getRef().equals(child)) return result;
        if(this.getRef() != null) result = result + 1;
        return -1;
    }
    
    public long getExponent() throws ModelException {
        return ((ReferenceType)this.getTheObject()).getExponent();
    }
    public void setExponent(long newValue) throws ModelException {
        ((ReferenceType)this.getTheObject()).setExponent(newValue);
    }
    public UnitTypeView getRef() throws ModelException {
        return ((ReferenceType)this.getTheObject()).getRef();
    }
    public void setRef(UnitTypeView newValue) throws ModelException {
        ((ReferenceType)this.getTheObject()).setRef(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleReferenceType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReferenceType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReferenceType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReferenceType(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class ReferenceType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
