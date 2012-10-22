package view.objects;

import view.*;
import viewClient.*;

public class AkteurProxi extends ViewProxi implements AkteurView{
    
    public AkteurProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AkteurView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> meineRollen_string = (java.util.Vector<String>)resultTable.get("meineRollen");
        java.util.Vector<RolleView> meineRollen = ViewProxi.getProxiVector(meineRollen_string, connectionKey);
        AkteurView result$$ = new Akteur((String)name,meineRollen, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMeineRollen().size()) return new MeineRollenAkteurWrapper(this, originalIndex, (ViewRoot)this.getMeineRollen().get(index));
        index = index - this.getMeineRollen().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMeineRollen().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMeineRollen().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMeineRollenIterator = this.getMeineRollen().iterator();
        while(getMeineRollenIterator.hasNext()){
            if(getMeineRollenIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName() throws ModelException {
        return ((Akteur)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Akteur)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<RolleView> getMeineRollen() throws ModelException {
        return ((Akteur)this.getTheObject()).getMeineRollen();
    }
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException {
        visitor.handleAkteur(this);
    }
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAkteur(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAkteur(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAkteur(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        renderer.setIcon(null);
            //TODO: implement setIcon in view class Akteur
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
