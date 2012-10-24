package model.meta;

public interface CompoundUnitMssgs {
    void accept(CompoundUnitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompoundUnitDOWNMssgs extends AbsUnitDOWNMssgs, CompoundUnitMssgs{}
interface CompoundUnitUPMssgs extends Mssgs, CompoundUnitMssgs{}
