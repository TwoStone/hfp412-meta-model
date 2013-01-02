package model.meta;

public interface MEmptySumMssgs {
    void accept(MEmptySumMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MEmptySumDOWNMssgs extends MSumTypeDOWNMssgs, MEmptySumMssgs{}
interface MEmptySumUPMssgs extends Mssgs, MEmptySumMssgs{}
