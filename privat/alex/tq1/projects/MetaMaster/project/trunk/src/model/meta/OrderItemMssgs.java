package model.meta;

public interface OrderItemMssgs {
    void accept(OrderItemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OrderItemDOWNMssgs extends Mssgs, OrderItemMssgs{}
interface OrderItemUPMssgs extends Mssgs, OrderItemMssgs{}
