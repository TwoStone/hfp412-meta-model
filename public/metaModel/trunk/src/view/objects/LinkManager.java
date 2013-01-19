
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class LinkManager extends ViewObject implements LinkManagerView{
    
    protected java.util.Vector<LinkView> links;
    
    public LinkManager(java.util.Vector<LinkView> links,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.links = links;        
    }
    
    static public long getTypeId() {
        return 244;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<LinkView> getLinks() throws ModelException {
        return this.links;
    }
    public void setLinks(java.util.Vector<LinkView> newValue) throws ModelException {
        this.links = newValue;
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
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> links = this.getLinks();
        if (links != null) {
            ViewObject.resolveVectorProxies(links, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
