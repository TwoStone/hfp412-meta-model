package persistence;

import java.util.Iterator;

interface PersistentListService<T extends AbstractPersistentRoot> {

  public Iterator<T> iterator(PersistentListProxi<T> listProxi);

}
