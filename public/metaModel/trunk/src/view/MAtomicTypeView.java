package view;

import view.visitor.*;

public interface MAtomicTypeView extends MTypeView {
    
    public String getName() throws ModelException ;
    public void setName(String newValue) throws ModelException ;
    public MBooleanView getSingletonType() throws ModelException ;
    public void setSingletonType(MBooleanView newValue) throws ModelException ;
    public MBooleanView getAbstractType() throws ModelException ;
    public void setAbstractType(MBooleanView newValue) throws ModelException ;
    public MAspectView getAspect() throws ModelException ;
    public void setAspect(MAspectView newValue) throws ModelException ;
    public MAtomicTypeView getSuperType() throws ModelException ;
    public void setSuperType(MAtomicTypeView newValue) throws ModelException ;
    public java.util.Vector<MAtomicTypeView> getSubTypes() throws ModelException ;
    
    public void accept(MTypeVisitor visitor) throws ModelException;
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

