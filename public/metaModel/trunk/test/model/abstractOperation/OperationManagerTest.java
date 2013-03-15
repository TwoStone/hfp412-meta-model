package model.abstractOperation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.NotAvailableException;
import model.messageOrLink.MessageManager;
import model.typeSystem.MEmptyTypeDisjunction;

import org.junit.Test;

import persistence.ActualParameterSearchList;
import persistence.FormalParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentAssociationManager;
import persistence.PersistentFormalParameter;
import persistence.PersistentMessageManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.Predcate;
import persistence.SearchListRoot;
import util.AbstractTest;
import util.InjectSingleton;

public class OperationManagerTest extends AbstractTest {

	@InjectSingleton(OperationManager.class)
	private PersistentOperationManager manager;

	@InjectSingleton(AssociationManager.class)
	private PersistentAssociationManager assocManager;

	@InjectSingleton(MessageManager.class)
	private PersistentMessageManager messageManager;

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedOperationsAreNotAllowed() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		manager.createOperation(mat2, mat3, "test1", manager.getFormalParameters().getList());
		manager.createOperation(mat3, mat4, "test1", manager.getFormalParameters().getList());
	}

	@Test
	public void operationsWithDifferendNamesAreAllowed() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		manager.createOperation(mat2, mat3, "test1", manager.getFormalParameters().getList());
		manager.createOperation(mat3, mat4, "test2", manager.getFormalParameters().getList());
	}

	@Test
	public void listShouldContainOperationAfterCreation() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final String name = "einName";
		manager.createOperation(mat2, mat3, name, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Operation wurde offenbar nicht erstellt!");
		}
	}

	@Test
	public void sourceOfStaticOperationHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final String name = "test04";
		// 1. Erstellen
		final PersistentOperation createStaticOp = manager.createStaticOp(name, mat2, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Static Operation wurde offenbar nicht erstellt!");
		}
		assertEquals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(), createStaticOp.getSource());
	}

	/* Eigentlich unnoetig aber kost ja nischt! */
	@Test
	public void sourceOfConstantHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final String name = "test0X";
		// 1. Erstellen
		final PersistentOperation createConstant = manager.createConstant(name, mat2);

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Static Operation wurde offenbar nicht erstellt!");
		}

		assertEquals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(), createConstant.getSource());
	}

	@Test
	public void targetOfVoidOperationHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final String name = "test05";
		final PersistentOperation createVoidOperation = manager.createVoidOperation(mat1, name, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Void Operation wurde offenbar nicht erstellt!");
		}
		assertEquals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(), createVoidOperation.getTarget());
	}

	@Test
	public void listShouldNotContainOperationAfterRemove() throws DoubleDefinitionException, PersistenceException, ConsistencyException {
		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "Irgendeine", new FormalParameterSearchList());
		manager.removeOperation(createOperation);

		final PersistentOperation found = manager.getOperations().findFirst(new Predcate<PersistentOperation>() {

			@Override
			public boolean test(final PersistentOperation argument) throws PersistenceException {
				return argument.equals(createOperation);
			}
		});

		assertNull(found);
	}

	@Test(expected = ConsistencyException.class)
	public void removingOperationIsNotAllowedIfMessagesExists() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "Irgendeiner01", new FormalParameterSearchList());
		messageManager.createMessage(createOperation, mao1, mao6, new ActualParameterSearchList());

		this.manager.removeOperation(createOperation);
	}

	@Test
	public void operationShouldContainParameterAfterAdd() throws PersistenceException, ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = manager.createFp("x", mat1);
		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "irgendeiner", new FormalParameterSearchList());
		manager.addFp(createOperation, param);

		final PersistentFormalParameter foundParam = createOperation.getParameters().findFirst(new Predcate<PersistentFormalParameter>() {

			@Override
			public boolean test(final PersistentFormalParameter argument) throws PersistenceException {
				return param.equals(argument);
			}
		});

		assertNotNull(foundParam);
	}

	@Test
	public void operationShouldContainParameterAfterMultipleAdd() throws PersistenceException, ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat1, "y");

		final FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "bla", new FormalParameterSearchList());
		manager.addMultipleFp(createOperation, searchList);

		final SearchListRoot<PersistentFormalParameter> findAll = createOperation.getParameters().findAll(new Predcate<PersistentFormalParameter>() {

			@Override
			public boolean test(final PersistentFormalParameter argument) throws PersistenceException {
				return param.equals(argument) || param2.equals(argument);
			}
		});

		assertEquals(2, findAll.getLength());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedParametersInSameOperationAreNotAllowd() throws PersistenceException, ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = manager.createFp("x", mat1);
		final PersistentFormalParameter param2 = manager.createFp("x", mat2);

		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "Irgendeiner01", new FormalParameterSearchList());
		manager.addFp(createOperation, param);
		manager.addFp(createOperation, param2);
	}

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedParametersInSameOperationAreNotAllowd2() throws PersistenceException, ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = manager.createFp("x", mat1);
		final PersistentFormalParameter param2 = manager.createFp("x", mat2);

		final FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "Irgendeiner01", new FormalParameterSearchList());
		manager.addMultipleFp(createOperation, searchList);
	}

	@Test
	public void operationShouldNotContainParameterAfterRemove() throws PersistenceException, NotAvailableException, ConsistencyException,
			DoubleDefinitionException {
		final PersistentFormalParameter param = manager.createFp("x", mat1);
		final PersistentFormalParameter param2 = manager.createFp("y", mat2);

		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, "Irgendeiner03", new FormalParameterSearchList());
		manager.addFp(createOperation, param);
		manager.addFp(createOperation, param2);

		manager.removeFpFromOp(createOperation, param);

		final PersistentFormalParameter foundParam = createOperation.getParameters().findFirst(new Predcate<PersistentFormalParameter>() {

			@Override
			public boolean test(final PersistentFormalParameter argument) throws PersistenceException {
				return param.equals(argument);
			}
		});

		assertNull(foundParam);
	}

	/**
	 * Wenn ein Formalparameter von einer Operation benutzt wird, kann dieser nicht geloescht werden.
	 * 
	 * @throws PersistenceException
	 * @throws NotAvailableException
	 * @throws ConsistencyException
	 * @throws DoubleDefinitionException
	 */
	@Test(expected = ConsistencyException.class)
	public void removingUsedParametersIsNotAllowed() throws PersistenceException, NotAvailableException, ConsistencyException,
			DoubleDefinitionException {
		final PersistentFormalParameter param = manager.createFp("x", mat1);
		final PersistentFormalParameter param2 = manager.createFp("y", mat2);

		final FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		manager.createOperation(mat3, mat4, "IrgendeinerXX", searchList);

		manager.removeFp(param);
	}

	@Test(expected = NotAvailableException.class)
	public void removingFormalParameterFromOperationWithoutTheseParam() throws PersistenceException, DoubleDefinitionException, ConsistencyException,
			NotAvailableException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "y");

		final FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);

		final String name = "IrgendeinerXXX";
		final PersistentOperation createOperation = manager.createOperation(mat3, mat4, name, searchList);
		manager.removeFpFromOp(createOperation, param2);
	}

	@Test(expected = ConsistencyException.class)
	public void addMultipleFp() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		final PersistentOperation o = manager.createOperation(mat1, mat6, "a", new FormalParameterSearchList());
		final PersistentFormalParameter fp = manager.createFp("fp", mat3);
		manager.addFp(o, fp);
		manager.addFp(o, fp);
	}

	@Test
	public void checkOpDDEWithAssoc() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		assocManager.createAssociation(mat1, mat2, "a");
		final PersistentOperation o = manager.createOperation(mat1, mat2, "a", new FormalParameterSearchList());
	}

	@Test(expected = ConsistencyException.class)
	public void createFpWithEmptyTypeDisj() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		manager.createFp("f", mstEmpty);
	}

	@Test(expected = ConsistencyException.class)
	public void createOpWithBothEmptyTypeDisj() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		manager.createOperation(mstEmpty, mstEmpty, "a", new FormalParameterSearchList());
	}

	@Test
	public void removeFp() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		final PersistentFormalParameter fp = manager.createFp("f", mat1);
		manager.removeFp(fp);
	}

	@Test(expected = ConsistencyException.class)
	public void removeOpWithLink() throws DoubleDefinitionException, ConsistencyException, PersistenceException {
		manager.createOperation(mstEmpty, mstEmpty, "a", new FormalParameterSearchList());
	}
}
