package persistence;

import java.util.Hashtable;

public interface AbstractPersistentRoot {

  public long getId();
  public long getClassId();
  public PersistentRoot getTheObject()  throws PersistenceException;
  public Hashtable<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver)throws PersistenceException;
  public Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver)throws PersistenceException;
 
  abstract boolean hasEssentialFields() throws PersistenceException;
  abstract public String toString(boolean inner) throws PersistenceException;
  abstract public void delete$Me() throws PersistenceException ;
  abstract public String createProxiInformation() throws PersistenceException; 
  
  abstract public int getIconInfo() throws PersistenceException;
  abstract public int getLeafInfo() throws PersistenceException;
  
  
}
