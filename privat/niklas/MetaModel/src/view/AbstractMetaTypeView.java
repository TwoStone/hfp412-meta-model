package view;

import view.objects.*;

public interface AbstractMetaTypeView extends Anything, AbstractViewProxi {
    
    
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

