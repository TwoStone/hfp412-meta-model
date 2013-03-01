package model.meta;

public interface MModelItemMssgsVisitor extends MModelItemDOWNMssgsVisitor, MModelItemUPMssgsVisitor {}


interface MModelItemDOWNMssgsVisitor extends AbstractObjectDOWNMssgsVisitor, MTypeDOWNMssgsVisitor, MessageOrLinkDOWNMssgsVisitor {

    
}


interface MModelItemUPMssgsVisitor  {

    
}
