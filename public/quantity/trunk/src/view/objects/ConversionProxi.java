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
        ViewProxi target = null;
        String target$String = (String)resultTable.get("target");
        if (target$String != null) {
            common.ProxiInformation target$Info = common.RPCConstantsAndServices.createProxiInformation(target$String);
            target = ViewProxi.createProxi(target$Info,connectionKey);
            target.setToString(target$Info.getToString());
        }
        ViewProxi convFunction = null;
        String convFunction$String = (String)resultTable.get("convFunction");
        if (convFunction$String != null) {
            common.ProxiInformation convFunction$Info = common.RPCConstantsAndServices.createProxiInformation(convFunction$String);
            convFunction = ViewProxi.createProxi(convFunction$Info,connectionKey);
            convFunction.setToString(convFunction$Info.getToString());
        }
        ConversionView result$$ = new Conversion((UnitView)source,(UnitView)target,(FunctionView)convFunction, this.getId(), this.getClassId());
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
        if(index == 0 && this.getTarget() != null) return new TargetConversionWrapper(this, originalIndex, (ViewRoot)this.getTarget());
        if(this.getTarget() != null) index = index - 1;
        if(index == 0 && this.getConvFunction() != null) return new ConvFunctionConversionWrapper(this, originalIndex, (ViewRoot)this.getConvFunction());
        if(this.getConvFunction() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getTarget() == null ? 0 : 1)
            + (this.getConvFunction() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSource() == null ? true : false)
            && (this.getTarget() == null ? true : false)
            && (this.getConvFunction() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSource() != null && this.getSource().equals(child)) return result;
        if(this.getSource() != null) result = result + 1;
        if(this.getTarget() != null && this.getTarget().equals(child)) return result;
        if(this.getTarget() != null) result = result + 1;
        if(this.getConvFunction() != null && this.getConvFunction().equals(child)) return result;
        if(this.getConvFunction() != null) result = result + 1;
        return -1;
    }
    
    public UnitView getSource() throws ModelException {
        return ((Conversion)this.getTheObject()).getSource();
    }
    public void setSource(UnitView newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setSource(newValue);
    }
    public UnitView getTarget() throws ModelException {
        return ((Conversion)this.getTheObject()).getTarget();
    }
    public void setTarget(UnitView newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setTarget(newValue);
    }
    public FunctionView getConvFunction() throws ModelException {
        return ((Conversion)this.getTheObject()).getConvFunction();
    }
    public void setConvFunction(FunctionView newValue) throws ModelException {
        ((Conversion)this.getTheObject()).setConvFunction(newValue);
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
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Conversion
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
