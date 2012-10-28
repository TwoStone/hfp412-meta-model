package model.meta;

public interface CompoundUnitTypeMssgs {
    void accept(CompoundUnitTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompoundUnitTypeDOWNMssgs extends AbsUnitTypeDOWNMssgs, CompoundUnitTypeMssgs{}
interface CompoundUnitTypeUPMssgs extends Mssgs, CompoundUnitTypeMssgs{}
