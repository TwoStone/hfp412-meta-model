package model.meta;

public interface MessageOrLinkMssgsVisitor extends MessageOrLinkDOWNMssgsVisitor, MessageOrLinkUPMssgsVisitor {}


interface MessageOrLinkDOWNMssgsVisitor extends MessageDOWNMssgsVisitor, LinkDOWNMssgsVisitor {

    
}


interface MessageOrLinkUPMssgsVisitor extends MModelItemUPMssgsVisitor {

    
}
