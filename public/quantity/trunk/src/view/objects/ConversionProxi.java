package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ConversionProxi extends ViewProxi implements ConversionView{
    
    public ConversionProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ConversionView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi source = null;
        String source$String = (String)resultTable.get("source");
        if (source$String != null) {
            common.ProxiInformation source$Info = common.RPCConstantsAndServices.createProxiInformation(source$String);
            source = ViewProxi.createProxi(source$Info,connectionKey);
            source.setToString(source$Info.getToString());
        }
        ViewProxi type = null;
        String type$String = (String)resultTable.get("type");
        if (type$String != null) {
            common.ProxiInformation type$Info = common.RPCConstantsAndServices.createProxiInformation(type$String);
            type = ViewProxi.createProxi(type$Info,connectionKey);
            type.setToString(type$Info.getToString());
        }
        common.Fraction factor = common.Fraction.parse((String)resultTable.get("factor"));
        common.Fraction constant = common.Fraction.parse((String)resultTable.get("constant"));
        ConversionView result$$ = new Conversion((UnitView)source,(UnitTypeView)type,(common.Fraction)factor,(common.Fraction)constant, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getSource() != null) return new SourceConversionWrapper(this, originalIndex, (ViewRoot)this.getSource());
        if(this.getSource() != null) index = index - 1;
        if(index == 0 && this.getType() != null) return new TypeConversionWrapper(this, originalIndex, (ViewRoot)this.getType());
        if(this.getType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getType() != null && this.getType().equals(child)) return result;
        if(this.getType() != null) result = result + 1;
        return -1;
    }
    
    public UnitView getSource() throws ModelException {
        return ((Conversion)this.getTheObject()).getSource();
    }
    public void setSource(UnitView newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setSource(newValue);
    }
    public UnitTypeView getType() throws ModelException {
        return ((Conversion)this.getTheObject()).getType();
    }
    public void setType(UnitTypeView newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setType(newValue);
    }
    public common.Fraction getFactor() throws ModelException {
        return ((Conversion)this.getTheObject()).getFactor();
    }
    public void setFactor(common.Fraction newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setFactor(newValue);
    }
    public common.Fraction getConstant() throws ModelException {
        return ((Conversion)this.getTheObject()).getConstant();
    }
    public void setConstant(common.Fraction newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setConstant(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleConversion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleConversion(this);
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
