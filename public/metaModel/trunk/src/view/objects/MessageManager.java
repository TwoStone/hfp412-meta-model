
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class MessageManager extends ViewObject implements MessageManagerView{
    
    protected java.util.Vector<MessageView> messages;
    
    public MessageManager(java.util.Vector<MessageView> messages,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.messages = messages;        
    }
    
    static public long getTypeId() {
        return 239;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<MessageView> getMessages() throws ModelException {
        return this.messages;
    }
    public void setMessages(java.util.Vector<MessageView> newValue) throws ModelException {
        this.messages = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMessageManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMessageManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMessageManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMessageManager(this);
    }
    
    public void resolveProxies(java.util.Hashtable<String, Object> resultTable) throws ModelException {
        java.util.Vector<?> messages = this.getMessages();
        if (messages != null) {
            ViewObject.resolveVectorProxies(messages, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException {
        int index = originalIndex;
        if(index < this.getMessages().size()) return new MessagesMessageManagerWrapper(this, originalIndex, (ViewRoot)this.getMessages().get(index));
        index = index - this.getMessages().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMessages().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getMessages().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMessagesIterator = this.getMessages().iterator();
        while(getMessagesIterator.hasNext()){
            if(getMessagesIterator.next().equals(child)) return result;
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
