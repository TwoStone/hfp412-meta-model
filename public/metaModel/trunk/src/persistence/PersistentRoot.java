package persistence;

import java.util.Hashtable;;

public abstract class PersistentRoot {

  private long id;

  public PersistentRoot(long id) {
    this.id = id;
  }

  public long getId(){
    return this.id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public boolean equals(Object object){
    PersistentRoot argument;
    if(object == null) return false;
    try {
      argument = (PersistentRoot)object;
    }catch (ClassCastException cce) {
      return false;
    }
    return this.id == argument.id && this.getClassId() == argument.getClassId();
  }
  public int hashCode(){
	return new Long(id).intValue();
  }

  public abstract long getClassId();
  public abstract PersistentRoot getTheObject()  throws PersistenceException;
  public abstract Hashtable<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException;
  public abstract Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException;

  public abstract boolean hasEssentialFields() throws PersistenceException;

  public abstract String toString(boolean inner)throws PersistenceException;

  public void delete$Me() throws PersistenceException{
	  ConnectionHandler.getTheConnectionHandler().dltObjct(this);
  }

  public String createProxiInformation(boolean asLeaf) throws PersistenceException {
	  return common.RPCConstantsAndServices.createProxiRepresentation(this.getClassId(), this.getId(), 
			  														  this.getIconInfo(), asLeaf ? 0 : this.getLeafInfo(), this.toString());
  }

  public int getLeafInfo() throws PersistenceException {
	  return 1;
  }

  abstract public int getIconInfo() throws PersistenceException;
}
