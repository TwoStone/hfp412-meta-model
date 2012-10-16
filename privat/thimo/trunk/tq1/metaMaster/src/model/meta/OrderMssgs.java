package model.meta;

public interface OrderMssgs {
    void accept(OrderMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OrderDOWNMssgs extends Mssgs, OrderMssgs{}
interface OrderUPMssgs extends Mssgs, OrderMssgs{}
