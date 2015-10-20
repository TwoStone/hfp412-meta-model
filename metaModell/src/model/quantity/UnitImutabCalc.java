package model.quantity;

import java.util.ArrayList;
import java.util.Iterator;

import model.NotComputableException;
import model.visitor.MBooleanReturnVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentBasicCalculation;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;
import persistence.PersistentQuantity;
import persistence.PersistentUnitImutabCalc;
import persistence.TDObserver;
import utils.Lists;

/* Additional import section end */

public abstract class UnitImutabCalc extends model.quantity.BasicCalculation implements PersistentUnitImutabCalc{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract UnitImutabCalc provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public UnitImutabCalc(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,id);        
    }
    
    static public long getTypeId() {
        return 331;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        
    }
    
    public abstract PersistentUnitImutabCalc getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitImutabCalc)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    
    public void calc1Compound1Atomar(final PersistentQuantity atom, final PersistentCompoundQuantity comp) 
				throws model.NotComputableException, PersistenceException{
		final PersistentQuantity counterPart = this.getQuantityWithSameUnit(comp, atom);
		if (counterPart != null) {
			final PersistentQuantity q = (PersistentQuantity) this.doCalcAtomar(atom, counterPart);
			// remove counterpart from comp
			final Iterator<PersistentQuantity> i = comp.getParts().iterator();
			while (i.hasNext()) {
				final PersistentQuantity current = i.next();
				if (current.equals(counterPart)) {
					i.remove();
				}
			}
			// add q to comp
			comp.getParts().add(q);
		} else {
			comp.getParts().add((PersistentQuantity) positiveOrNegative(atom));
		}

	}
    public void calcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2) 
				throws model.NotComputableException, PersistenceException{
		getThis().setResultt(this.doCalcAtomar(atom1, atom2));
	}
    public void calcComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2) 
				throws model.NotComputableException, PersistenceException{
		// check unit type of vector
		if (!(comp1.getParts().iterator().next().equals(comp2.getParts().iterator().next()))) {
			throw new model.NotComputableException(constants.ExceptionConstants.UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB);
		}
		// initialize result object
		final PersistentCompoundQuantity cp = CompoundQuantity.createCompoundQuantity();
		// remember elements already read
		final ArrayList<PersistentQuantity> readElements = Lists.newArrayList();
		// iterate over 1st comp quantity
		Iterator<PersistentQuantity> i = comp1.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity current = i.next();
			PersistentQuantity counterPart = getQuantityWithSameUnit(comp2, current);
			if (counterPart != null) {
				// zusammenrechnen
				final PersistentAbsQuantity q = this.doCalcAtomar(current, counterPart);
				readElements.add(counterPart);
				counterPart = null;
			} else {
				cp.getParts().add((PersistentQuantity) positiveOrNegative(current));
			}
		}
		// iterate over 2nd comp quantity
		i = comp2.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity current = i.next();
			if (!(readElements.contains(current))) {
				cp.getParts().add((PersistentQuantity) positiveOrNegative(current));
			}
		}
	}

    /* Start of protected part that is not overridden by persistence generator */
    

	private PersistentQuantity getQuantityWithSameUnit(final PersistentCompoundQuantity comp, final PersistentQuantity argument)
			throws PersistenceException {
		PersistentQuantity result = null;

		final Iterator<PersistentQuantity> i = comp.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity current = i.next();
			if (current.getUnit().equals(argument.getUnit())) {
				result = current;
			}
		}

		return result;
	}

	private PersistentAbsQuantity positiveOrNegative(final PersistentQuantity current) throws PersistenceException {
		if (getThis().mustSignInverted().accept(new MBooleanReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMFalse(final PersistentMFalse mFalse) throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMTrue(final PersistentMTrue mTrue) throws PersistenceException {
				return true;
			}
		})) {
			final PersistentQuantity currentInverted = (PersistentQuantity) QuantityManager.getTheQuantityManager().invertSign(current);
			return currentInverted;
		} else {
			return current;
		}
	}

	private PersistentAbsQuantity doCalcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2) throws model.NotComputableException,
			PersistenceException {
		if (atom1.getUnit().equals(atom2.getUnit())) {

			final PersistentQuantity result = QuantityManager.getTheQuantityManager().createQuantity(atom1.getUnit(),
					getThis().calcFraction(atom1.getAmount(), atom2.getAmount()));
			return result;

		} else {

			if (!(atom1.getUnit().getType().equals(atom2.getUnit().getType()))) {
				throw new NotComputableException(constants.ExceptionConstants.UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB);
			}

			final PersistentCompoundQuantity result = CompoundQuantity.createCompoundQuantity();

			result.getParts().add(atom1);
			final Boolean mustBeInverted = getThis().mustSignInverted().accept(new MBooleanReturnVisitor<Boolean>() {

				@Override
				public Boolean handleMFalse(final PersistentMFalse mFalse) throws PersistenceException {
					return false;
				}

				@Override
				public Boolean handleMTrue(final PersistentMTrue mTrue) throws PersistenceException {
					return true;
				}
			});
			if (mustBeInverted) {
				result.getParts().add((PersistentQuantity) QuantityManager.getTheQuantityManager().invertSign(atom2));
			} else {
				result.getParts().add(atom2);
			}
			QuantityManager.getTheQuantityManager().getQuantities().add(result);
			return result;
		}

	}

	
    /* End of protected part that is not overridden by persistence generator */
    
}
