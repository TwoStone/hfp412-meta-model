package model.meta;

public interface ConversionManagerMssgs {
    void accept(ConversionManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ConversionManagerDOWNMssgs extends Mssgs, ConversionManagerMssgs{}
interface ConversionManagerUPMssgs extends Mssgs, ConversionManagerMssgs{}
