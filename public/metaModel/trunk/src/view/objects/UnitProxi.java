package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitProxi extends AbsUnitProxi implements UnitView{
    
    public UnitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public UnitView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        ViewProxi myConversion = null;
        String myConversion$String = (String)resultTable.get("myConversion");
        if (myConversion$String != null) {
            common.ProxiInformation myConversion$Info = common.RPCConstantsAndServices.createProxiInformation(myConversion$String);
            myConversion = ViewProxi.createProxi(myConversion$Info,connectionKey);
            myConversion.setToString(myConversion$Info.getToString());
        }
        UnitView result$$ = new Unit((AbsUnitTypeView)type,(String)name,(ConversionView)myConversion, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getMyConversion() != null) return new MyConversionUnitWrapper(this, originalIndex, (ViewRoot)this.getMyConversion());
        if(this.getMyConversion() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMyConversion() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMyConversion() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMyConversion() != null && this.getMyConversion().equals(child)) return result;
        if(this.getMyConversion() != null) result = result + 1;
        return -1;
    }
    
    public ConversionView getMyConversion() throws ModelException {
        return ((Unit)this.getTheObject()).getMyConversion();
    }
    
    public void accept(AbsUnitVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
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