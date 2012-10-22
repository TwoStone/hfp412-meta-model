package persistence;

import model.*;

import java.util.Iterator;

public class Lieferant_PortfolioProxi extends PersistentListProxi<PersistentProdukt> {

  private ProduktList list;
  private Lieferant owner;

  public Lieferant_PortfolioProxi(Lieferant owner) {
    this.owner = owner;
  }
  public ProduktList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theLieferantFacade.portfolioGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentProdukt> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentProdukt entry) throws PersistenceException {
    if (entry != null) {
      ProduktList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theLieferantFacade
                       .portfolioAdd(owner.getId(), entry);
      list.add((PersistentProdukt)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theLieferantFacade.portfolioRem(entry.getListEntryId());
    
  }
  public Lieferant_PortfolioProxi copy(Lieferant owner) throws PersistenceException {
  	Lieferant_PortfolioProxi result = new Lieferant_PortfolioProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
