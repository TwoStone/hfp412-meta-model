
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException;
    public abstract void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException;
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    public abstract void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    public abstract void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException;
    public abstract void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException;
    public abstract void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public abstract void handleAssociation(PersistentAssociation association) throws PersistenceException;
    public abstract void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException;
    public abstract void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException;
    public abstract void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException;
    public abstract void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException;
    public abstract void handleMObject(PersistentMObject mObject) throws PersistenceException;
    public abstract void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException;
    public abstract void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException;
    public abstract void handleMessage(PersistentMessage message) throws PersistenceException;
    public abstract void handleFunction(PersistentFunction function) throws PersistenceException;
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    public abstract void handleLink(PersistentLink link) throws PersistenceException;
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    public abstract void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    public abstract void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    public abstract void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    public abstract void handleOperation(PersistentOperation operation) throws PersistenceException;
    public abstract void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public abstract void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException;
    public abstract void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    public abstract void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException;
    public abstract void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public abstract void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException;
    public abstract void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public abstract void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    public abstract void handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException;
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    public abstract void handleMFalse(PersistentMFalse mFalse) throws PersistenceException;
    public abstract void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException;
    public abstract void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    public abstract void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException;
    public abstract void handleMTrue(PersistentMTrue mTrue) throws PersistenceException;
    public abstract void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public abstract void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException;
    public abstract void handleName(PersistentName name) throws PersistenceException;
    public abstract void handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException;
    public abstract void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException;
    
}
