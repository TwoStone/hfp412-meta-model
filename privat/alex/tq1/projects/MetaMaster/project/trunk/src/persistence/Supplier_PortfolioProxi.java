package persistence;

import model.*;

import java.util.Iterator;

public class Supplier_PortfolioProxi extends PersistentListProxi<PersistentProduct> {

  private ProductList list;
  private Supplier owner;

  public Supplier_PortfolioProxi(Supplier owner) {
    this.owner = owner;
  }
  public ProductList getList() throws PersistenceException{
    if (this.list == null) {
      this.list = ConnectionHandler
                    .getTheConnectionHandler()
                      .theSupplierFacade.portfolioGet(this.owner.getId());
    }
    return this.list;
  }
  public Iterator<PersistentProduct> iterator() throws PersistenceException{
    return this.getList().iterator(this);
  }
  public long getLength() throws PersistenceException{
	  return this.getList().getLength();
  }
  public void add(PersistentProduct entry) throws PersistenceException {
    if (entry != null) {
      ProductList list = this.getList();
      long entryId = ConnectionHandler.getTheConnectionHandler().theSupplierFacade
                       .portfolioAdd(owner.getId(), entry);
      list.add((PersistentProduct)PersistentProxi.createListEntryProxi(entry.getId(),
                               entry.getClassId(),
                               entryId));
      
    }
  }
  protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    ConnectionHandler.getTheConnectionHandler().theSupplierFacade.portfolioRem(entry.getListEntryId());
    
  }
  public Supplier_PortfolioProxi copy(Supplier owner) throws PersistenceException {
  	Supplier_PortfolioProxi result = new Supplier_PortfolioProxi(owner);
  	result.list = this.getList().copy();
  	return result;
  } 

}
