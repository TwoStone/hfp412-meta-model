package model.meta;

public interface BooleanTrueMssgs {
    void accept(BooleanTrueMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BooleanTrueDOWNMssgs extends BooleanValueDOWNMssgs, BooleanTrueMssgs{}
interface BooleanTrueUPMssgs extends Mssgs, BooleanTrueMssgs{}
