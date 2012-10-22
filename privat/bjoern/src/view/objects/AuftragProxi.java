package view.objects;

import view.*;
import viewClient.*;

public class AuftragProxi extends ViewProxi implements AuftragView{
    
    public AuftragProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AuftragView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi auftraggeber = null;
        String auftraggeber$String = (String)resultTable.get("auftraggeber");
        if (auftraggeber$String != null) {
            common.ProxiInformation auftraggeber$Info = common.RPCConstantsAndServices.createProxiInformation(auftraggeber$String);
            auftraggeber = ViewProxi.createProxi(auftraggeber$Info,connectionKey);
            auftraggeber.setToString(auftraggeber$Info.getToString());
        }
        ViewProxi auftragnehmer = null;
        String auftragnehmer$String = (String)resultTable.get("auftragnehmer");
        if (auftragnehmer$String != null) {
            common.ProxiInformation auftragnehmer$Info = common.RPCConstantsAndServices.createProxiInformation(auftragnehmer$String);
            auftragnehmer = ViewProxi.createProxi(auftragnehmer$Info,connectionKey);
            auftragnehmer.setToString(auftragnehmer$Info.getToString());
        }
        java.util.Vector<String> positionen_string = (java.util.Vector<String>)resultTable.get("positionen");
        java.util.Vector<PositionView> positionen = ViewProxi.getProxiVector(positionen_string, connectionKey);
        AuftragView result$$ = new Auftrag((KundeView)auftraggeber,(LieferantView)auftragnehmer,positionen, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index == 0 && this.getAuftraggeber() != null) return new AuftraggeberAuftragWrapper(this, originalIndex, (ViewRoot)this.getAuftraggeber());
        if(this.getAuftraggeber() != null) index = index - 1;
        if(index == 0 && this.getAuftragnehmer() != null) return new AuftragnehmerAuftragWrapper(this, originalIndex, (ViewRoot)this.getAuftragnehmer());
        if(this.getAuftragnehmer() != null) index = index - 1;
        if(index < this.getPositionen().size()) return new PositionenAuftragWrapper(this, originalIndex, (ViewRoot)this.getPositionen().get(index));
        index = index - this.getPositionen().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAuftraggeber() == null ? 0 : 1)
            + (this.getAuftragnehmer() == null ? 0 : 1)
            + (this.getPositionen().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAuftraggeber() == null ? true : false)
            && (this.getAuftragnehmer() == null ? true : false)
            && (this.getPositionen().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAuftraggeber() != null && this.getAuftraggeber().equals(child)) return result;
        if(this.getAuftraggeber() != null) result = result + 1;
        if(this.getAuftragnehmer() != null && this.getAuftragnehmer().equals(child)) return result;
        if(this.getAuftragnehmer() != null) result = result + 1;
        java.util.Iterator<?> getPositionenIterator = this.getPositionen().iterator();
        while(getPositionenIterator.hasNext()){
            if(getPositionenIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public KundeView getAuftraggeber() throws ModelException {
        return ((Auftrag)this.getTheObject()).getAuftraggeber();
    }
    public void setAuftraggeber(KundeView newValue) throws ModelException {
        ((Auftrag)this.getTheObject()).setAuftraggeber(newValue);
    }
    public LieferantView getAuftragnehmer() throws ModelException {
        return ((Auftrag)this.getTheObject()).getAuftragnehmer();
    }
    public void setAuftragnehmer(LieferantView newValue) throws ModelException {
        ((Auftrag)this.getTheObject()).setAuftragnehmer(newValue);
    }
    public java.util.Vector<PositionView> getPositionen() throws ModelException {
        return ((Auftrag)this.getTheObject()).getPositionen();
    }
    public void setPositionen(java.util.Vector<PositionView> newValue) throws ModelException {
        ((Auftrag)this.getTheObject()).setPositionen(newValue);
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAuftrag(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAuftrag(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAuftrag(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAuftrag(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Auftrag
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
