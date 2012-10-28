package model.meta;

public interface ConversionRateMssgs {
    void accept(ConversionRateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ConversionRateDOWNMssgs extends Mssgs, ConversionRateMssgs{}
interface ConversionRateUPMssgs extends Mssgs, ConversionRateMssgs{}
