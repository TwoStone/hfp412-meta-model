package view;

import view.objects.*;

public interface AuftragView extends Anything, AbstractViewProxi {
    
    public KundeView getAuftraggeber() throws ModelException ;
    public void setAuftraggeber(KundeView newValue) throws ModelException ;
    public LieferantView getAuftragnehmer() throws ModelException ;
    public void setAuftragnehmer(LieferantView newValue) throws ModelException ;
    public java.util.Vector<PositionView> getPositionen() throws ModelException ;
    public void setPositionen(java.util.Vector<PositionView> newValue) throws ModelException ;
    
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

