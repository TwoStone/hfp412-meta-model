package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MessageManagerProxi extends ViewProxi implements MessageManagerView{
    
    public MessageManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MessageManagerView getRemoteObject(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> messages_string = (java.util.Vector<String>)resultTable.get("messages");
        java.util.Vector<MessageView> messages = ViewProxi.getProxiVector(messages_string, connectionKey);
        MessageManagerView result$$ = new MessageManager(messages, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<MessageView> getMessages() throws ModelException {
        return ((MessageManager)this.getTheObject()).getMessages();
    }
    public void setMessages(java.util.Vector<MessageView> newValue) throws ModelException {
        ((MessageManager)this.getTheObject()).setMessages(newValue);
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
