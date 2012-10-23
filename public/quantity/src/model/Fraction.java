
package model;

import persistence.*;


/* Additional import section end */

public class Fraction extends PersistentObject implements PersistentFraction{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFraction getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFractionFacade.getClass(objectId);
        return (PersistentFraction)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFraction createFraction() throws PersistenceException {
        PersistentFraction result = ConnectionHandler.getTheConnectionHandler().theFractionFacade
            .newFraction(0,0);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFraction createFraction(PersistentFraction This) throws PersistenceException {
        PersistentFraction result = ConnectionHandler.getTheConnectionHandler().theFractionFacade
            .newFraction(0,0);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("enumerator", new Long(this.getEnumerator()).toString());
            result.put("denominator", new Long(this.getDenominator()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Fraction provideCopy() throws PersistenceException{
        Fraction result = this;
        result = new Fraction(this.enumerator, 
                              this.denominator, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long enumerator;
    protected long denominator;
    protected PersistentFraction This;
    
    public Fraction(long enumerator,long denominator,PersistentFraction This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.enumerator = enumerator;
        this.denominator = denominator;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getEnumerator() throws PersistenceException {
        return this.enumerator;
    }
    public void setEnumerator(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theFractionFacade.enumeratorSet(this.getId(), newValue);
        this.enumerator = newValue;
    }
    public long getDenominator() throws PersistenceException {
        
    	return this.denominator;
    }
    public void setDenominator(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theFractionFacade.denominatorSet(this.getId(), newValue);
        if(newValue == 0)
    		throw new PersistenceException(constants.ExceptionConstants.NENNER_IST_0, 0);
        this.denominator = newValue;
    }
    protected void setThis(PersistentFraction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFraction)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theFractionFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentFraction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFraction result = new FractionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFraction)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFraction(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFraction(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFraction(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFraction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public PersistentFraction add(final PersistentFraction fraction) 
				throws PersistenceException{
    	PersistentFraction result = Fraction.createFraction();
    	result.setEnumerator(fraction.getEnumerator()*this.denominator+this.enumerator*fraction.getDenominator());
    	result.setDenominator(this.denominator*fraction.getDenominator());
    	return result.toRational();
    }
    public PersistentFraction toRational() 
				throws PersistenceException{
    	long localGcd = this.gcd(this.enumerator, this.denominator);
    	PersistentFraction resultFraction = Fraction.createFraction();
    	resultFraction.setEnumerator(this.getEnumerator() / localGcd);
    	resultFraction.setDenominator(this.getDenominator() / localGcd);
    	return resultFraction;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public PersistentFraction mul(final PersistentFraction fraction) throws PersistenceException{

    	// e1/d1 * e2/d2 = kuerzen(e1/d2) * kuerzen(e2/d1)
    	
    	// Kreuzprodukt Bruch 1
    	PersistentFraction frac1 = Fraction.createFraction();
    	frac1.setEnumerator(this.enumerator);
    	frac1.setDenominator(fraction.getDenominator());
    	// Kürzen
    	PersistentFraction frac1Rat = frac1.toRational();
    	
    	// Kreuzprodukt Bruch 2
    	PersistentFraction frac2 = Fraction.createFraction();
    	frac2.setEnumerator(fraction.getEnumerator());
    	frac2.setDenominator(this.denominator);
    	// Kürzen
    	PersistentFraction frac2Rat = frac2.toRational();
    	
    	PersistentFraction result = Fraction.createFraction();
    	result.setEnumerator(frac1Rat.getEnumerator()*frac2Rat.getEnumerator());
    	result.setDenominator(frac1Rat.getDenominator()*frac2Rat.getDenominator());
    	return result;
    	
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFraction)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() throws PersistenceException{
    	
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /** 
     * GGT
     * @param x1
     * @param x2
     * @return
     * @throws PersistenceException
     */
    private long gcd(long x1, long x2) throws PersistenceException {
        
        long a,b,g,z;

        if(x1>x2) {
            a = x1;
            b = x2;
        } else {
            a = x2;
            b = x1;
        }

        if(b==0) return 0;

        g = b;
        while (g!=0) {
            z= a%g;
            a = g;
            g = z;
        }
        return a;
    }
    /* End of protected part that is not overridden by persistence generator */
    
}
