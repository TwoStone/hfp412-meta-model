package model.meta;

public interface MModelItemMssgsVisitor extends MModelItemDOWNMssgsVisitor, MModelItemUPMssgsVisitor {}


interface MModelItemDOWNMssgsVisitor extends MTypeDOWNMssgsVisitor, MessageOrLinkDOWNMssgsVisitor {

    
}


interface MModelItemUPMssgsVisitor  {

    
}
