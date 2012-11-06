package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MAtomicTypeProxi extends ViewProxi implements MAtomicTypeView{
    
    public MAtomicTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MAtomicTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi aspect = null;
        String aspect$String = (String)resultTable.get("aspect");
        if (aspect$String != null) {
            common.ProxiInformation aspect$Info = common.RPCConstantsAndServices.createProxiInformation(aspect$String);
            aspect = ViewProxi.createProxi(aspect$Info,connectionKey);
            aspect.setToString(aspect$Info.getToString());
        }
        ViewProxi superType = null;
        String superType$String = (String)resultTable.get("superType");
        if (superType$String != null) {
            common.ProxiInformation superType$Info = common.RPCConstantsAndServices.createProxiInformation(superType$String);
            superType = ViewProxi.createProxi(superType$Info,connectionKey);
            superType.setToString(superType$Info.getToString());
        }
        java.util.Vector<String> subTypes_string = (java.util.Vector<String>)resultTable.get("subTypes");
        java.util.Vector<MAtomicTypeView> subTypes = ViewProxi.getProxiVector(subTypes_string, connectionKey);
        MAtomicTypeView result$$ = new MAtomicType((String)name,(MAspectView)aspect,(MAtomicTypeView)superType,subTypes, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getSubTypes().size()) return new SubTypesMAtomicTypeWrapper(this, originalIndex, (ViewRoot)this.getSubTypes().get(index));
        index = index - this.getSubTypes().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSubTypes().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSubTypes().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getSubTypesIterator = this.getSubTypes().iterator();
        while(getSubTypesIterator.hasNext()){
            if(getSubTypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
    public MAtomicTypeView getSuperType() throws ModelException {
        return ((MAtomicType)this.getTheObject()).getSuperType();
    }
    public void setSuperType(MAtomicTypeView newValue) throws ModelException {
        ((MAtomicType)this.getTheObject()).setSuperType(newValue);
    }
    public java.util.Vector<MAtomicTypeView> getSubTypes() throws ModelException {
        return ((MAtomicType)this.getTheObject()).getSubTypes();
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
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
