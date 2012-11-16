package model.meta;

public interface BooleanFalseMssgs {
    void accept(BooleanFalseMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BooleanFalseDOWNMssgs extends BooleanValueDOWNMssgs, BooleanFalseMssgs{}
interface BooleanFalseUPMssgs extends Mssgs, BooleanFalseMssgs{}
