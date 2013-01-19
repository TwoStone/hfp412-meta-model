package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class LinkManagerProxi extends ViewProxi implements LinkManagerView{
    
    public LinkManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public LinkManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> links_string = (java.util.Vector<String>)resultTable.get("links");
        java.util.Vector<LinkView> links = ViewProxi.getProxiVector(links_string, connectionKey);
        LinkManagerView result$$ = new LinkManager(links, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getLinks().size()) return new LinksLinkManagerWrapper(this, originalIndex, (ViewRoot)this.getLinks().get(index));
        index = index - this.getLinks().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLinks().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getLinks().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getLinksIterator = this.getLinks().iterator();
        while(getLinksIterator.hasNext()){
            if(getLinksIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<LinkView> getLinks() throws ModelException {
        return ((LinkManager)this.getTheObject()).getLinks();
    }
    public void setLinks(java.util.Vector<LinkView> newValue) throws ModelException {
        ((LinkManager)this.getTheObject()).setLinks(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleLinkManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLinkManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLinkManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLinkManager(this);
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
