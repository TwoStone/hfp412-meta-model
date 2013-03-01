package model.meta;

public interface MModelItemMssgs {
    void accept(MModelItemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MModelItemDOWNMssgs extends Mssgs, MModelItemMssgs{}
interface MModelItemUPMssgs extends AbstractObjectUPMssgs, MTypeUPMssgs, MessageOrLinkUPMssgs, MModelItemMssgs{}
