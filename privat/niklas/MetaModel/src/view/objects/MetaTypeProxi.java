package view.objects;

import view.*;
import viewClient.*;

public class MetaTypeProxi extends AbstractMetaTypeProxi implements MetaTypeView{
    
    public MetaTypeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MetaTypeView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> subtypes_string = (java.util.Vector<String>)resultTable.get("subtypes");
        java.util.Vector<MetaTypeView> subtypes = ViewProxi.getProxiVector(subtypes_string, connectionKey);
        ViewProxi myAspect = null;
        String myAspect$String = (String)resultTable.get("myAspect");
        if (myAspect$String != null) {
            common.ProxiInformation myAspect$Info = common.RPCConstantsAndServices.createProxiInformation(myAspect$String);
            myAspect = ViewProxi.createProxi(myAspect$Info,connectionKey);
            myAspect.setToString(myAspect$Info.getToString());
        }
        ViewProxi myCONCNamedEntity = null;
        String myCONCNamedEntity$String = (String)resultTable.get("myCONCNamedEntity");
        if (myCONCNamedEntity$String != null) {
            common.ProxiInformation myCONCNamedEntity$Info = common.RPCConstantsAndServices.createProxiInformation(myCONCNamedEntity$String);
            myCONCNamedEntity = ViewProxi.createProxi(myCONCNamedEntity$Info,connectionKey);
            myCONCNamedEntity.setToString(myCONCNamedEntity$Info.getToString());
        }
        MetaTypeView result$$ = new MetaType(subtypes,(MetaAspectView)myAspect,(NamedEntityView)myCONCNamedEntity, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getSubtypes().size()) return new SubtypesMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getSubtypes().get(index));
        index = index - this.getSubtypes().size();
        if(index == 0 && this.getMyAspect() != null) return new MyAspectMetaTypeWrapper(this, originalIndex, (ViewRoot)this.getMyAspect());
        if(this.getMyAspect() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSubtypes().size())
            + (this.getMyAspect() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSubtypes().size() == 0)
            && (this.getMyAspect() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getSubtypesIterator = this.getSubtypes().iterator();
        while(getSubtypesIterator.hasNext()){
            if(getSubtypesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getMyAspect() != null && this.getMyAspect().equals(child)) return result;
        if(this.getMyAspect() != null) result = result + 1;
        return -1;
    }
    
    public java.util.Vector<MetaTypeView> getSubtypes() throws ModelException {
        return ((MetaType)this.getTheObject()).getSubtypes();
    }
    public void setSubtypes(java.util.Vector<MetaTypeView> newValue) throws ModelException {
        ((MetaType)this.getTheObject()).setSubtypes(newValue);
    }
    public MetaAspectView getMyAspect() throws ModelException {
        return ((MetaType)this.getTheObject()).getMyAspect();
    }
    public void setMyAspect(MetaAspectView newValue) throws ModelException {
        ((MetaType)this.getTheObject()).setMyAspect(newValue);
    }
    public NamedEntityView getMyCONCNamedEntity() throws ModelException {
        return ((MetaType)this.getTheObject()).getMyCONCNamedEntity();
    }
    public void setMyCONCNamedEntity(NamedEntityView newValue) throws ModelException {
        ((MetaType)this.getTheObject()).setMyCONCNamedEntity(newValue);
    }
    public String getName() throws ModelException {
        return ((MetaType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((MetaType)this.getTheObject()).setName(newValue);
    }
    
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMetaType(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class MetaType
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
