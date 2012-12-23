package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CompUnitProxi extends AbsUnitProxi implements CompUnitView{
    
    public CompUnitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompUnitView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        java.util.Vector<String> refs_string = (java.util.Vector<String>)resultTable.get("refs");
        java.util.Vector<ReferenceView> refs = ViewProxi.getProxiVector(refs_string, connectionKey);
        ViewProxi isFinal = null;
        String isFinal$String = (String)resultTable.get("isFinal");
        if (isFinal$String != null) {
            common.ProxiInformation isFinal$Info = common.RPCConstantsAndServices.createProxiInformation(isFinal$String);
            isFinal = ViewProxi.createProxi(isFinal$Info,connectionKey);
            isFinal.setToString(isFinal$Info.getToString());
        }
        CompUnitView result$$ = new CompUnit((AbsUnitTypeView)type,(String)name,refs,(MBooleanView)isFinal, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getRefs().size()) return new RefsCompUnitWrapper(this, originalIndex, (ViewRoot)this.getRefs().get(index));
        index = index - this.getRefs().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getRefs().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getRefs().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getRefsIterator = this.getRefs().iterator();
        while(getRefsIterator.hasNext()){
            if(getRefsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ReferenceView> getRefs() throws ModelException {
        return ((CompUnit)this.getTheObject()).getRefs();
    }
    public void setRefs(java.util.Vector<ReferenceView> newValue) throws ModelException {
        ((CompUnit)this.getTheObject()).setRefs(newValue);
    }
    public MBooleanView getIsFinal() throws ModelException {
        return ((CompUnit)this.getTheObject()).getIsFinal();
    }
    public void setIsFinal(MBooleanView newValue) throws ModelException {
        ((CompUnit)this.getTheObject()).setIsFinal(newValue);
    }
    
    public void accept(AbsUnitVisitor visitor) throws ModelException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnit(this);
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
