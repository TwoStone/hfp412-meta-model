package model.meta;

public interface BooleanValueMssgs {
    void accept(BooleanValueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BooleanValueDOWNMssgs extends Mssgs, BooleanValueMssgs{}
interface BooleanValueUPMssgs extends BooleanFalseUPMssgs, BooleanTrueUPMssgs, BooleanValueMssgs{}
