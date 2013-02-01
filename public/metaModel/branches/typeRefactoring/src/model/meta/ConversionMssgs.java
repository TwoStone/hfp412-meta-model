package model.meta;

public interface ConversionMssgs {
    void accept(ConversionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ConversionDOWNMssgs extends Mssgs, ConversionMssgs{}
interface ConversionUPMssgs extends Mssgs, ConversionMssgs{}
