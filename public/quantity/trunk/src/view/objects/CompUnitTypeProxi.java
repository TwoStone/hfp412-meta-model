package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CompUnitTypeProxi extends AbsUnitTypeProxi implements CompUnitTypeView{
    
    public CompUnitTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public CompUnitTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi defaultUnit = null;
        String defaultUnit$String = (String)resultTable.get("defaultUnit");
        if (defaultUnit$String != null) {
            common.ProxiInformation defaultUnit$Info = common.RPCConstantsAndServices.createProxiInformation(defaultUnit$String);
            defaultUnit = ViewProxi.createProxi(defaultUnit$Info,connectionKey);
            defaultUnit.setToString(defaultUnit$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        java.util.Vector<String> refs_string = (java.util.Vector<String>)resultTable.get("refs");
        java.util.Vector<ReferenceTypeView> refs = ViewProxi.getProxiVector(refs_string, connectionKey);
        CompUnitTypeView result$$ = new CompUnitType((AbsUnitView)defaultUnit,(String)name,refs, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getDefaultUnit() != null) return new DefaultUnitAbsUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getDefaultUnit());
        if(this.getDefaultUnit() != null) index = index - 1;
        if(index < this.getRefs().size()) return new RefsCompUnitTypeWrapper(this, originalIndex, (ViewRoot)this.getRefs().get(index));
        index = index - this.getRefs().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getDefaultUnit() == null ? 0 : 1)
            + (this.getRefs().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getDefaultUnit() == null ? true : false)
            && (this.getRefs().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getDefaultUnit() != null && this.getDefaultUnit().equals(child)) return result;
        if(this.getDefaultUnit() != null) result = result + 1;
        java.util.Iterator<?> getRefsIterator = this.getRefs().iterator();
        while(getRefsIterator.hasNext()){
            if(getRefsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ReferenceTypeView> getRefs() throws ModelException {
        return ((CompUnitType)this.getTheObject()).getRefs();
    }
    public void setRefs(java.util.Vector<ReferenceTypeView> newValue) throws ModelException {
        ((CompUnitType)this.getTheObject()).setRefs(newValue);
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws ModelException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCompUnitType(this);
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
