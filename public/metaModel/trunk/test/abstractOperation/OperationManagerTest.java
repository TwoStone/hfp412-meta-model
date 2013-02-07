package abstractOperation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.NotAvailableException;
import model.abstractOperation.FormalParameter;
import model.abstractOperation.Operation;
import model.abstractOperation.OperationManager;
import model.messageOrLink.MessageManager;
import model.typeSystem.MEmptySumType;
import model.visitor.AbsOperationVisitor;

import org.junit.Before;
import org.junit.Test;

import persistence.ActualParameterSearchList;
import persistence.FormalParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAssociation;
import persistence.PersistentFormalParameter;
import persistence.PersistentMessageManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.Predcate;
import persistence.SearchListRoot;
import test.util.AbstractTest;

public class OperationManagerTest extends AbstractTest {

	private PersistentOperationManager manager;
	private PersistentMessageManager messageManager;

	public OperationManagerTest() throws CycleException, PersistenceException, ConsistencyException {
		super();
	}

	@Before
	public void cleanUp() throws PersistenceException, SQLException, IOException {
		this.manager = getManager(OperationManager.class);
		this.messageManager = getManager(MessageManager.class);
	}

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedOperationsAreNotAllowed() throws DoubleDefinitionException, PersistenceException {
		manager.createOperation(mat2, mat3, "test1", manager.getFormalParameters().getList());
		manager.createOperation(mat3, mat4, "test1", manager.getFormalParameters().getList());
	}

	@Test
	public void operationsWithDifferendNamesAreAllowed() throws DoubleDefinitionException, PersistenceException {
		manager.createOperation(mat2, mat3, "test1", manager.getFormalParameters().getList());
		manager.createOperation(mat3, mat4, "test2", manager.getFormalParameters().getList());
	}

	@Test
	public void listShouldContainOperationAfterCreation() throws DoubleDefinitionException, PersistenceException {
		String name = "einName";
		manager.createOperation(mat2, mat3, name, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Operation wurde offenbar nicht erstellt!");
		}
	}

	@Test
	public void sourceOfStaticOperationHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException {
		String name = "test04";
		// 1. Erstellen
		manager.createStaticOp(name, mat2, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Static Operation wurde offenbar nicht erstellt!");
		}
		assertEqualsWithNameAndVisitor(name, new AbsOperationVisitor() {

			@Override
			public void handleOperation(PersistentOperation operation) throws PersistenceException {

				assertEquals(MEmptySumType.getTheMEmptySumType(), operation.getSource());
			}

			@Override
			public void handleAssociation(PersistentAssociation association) throws PersistenceException {
				// Wenn eine Operation genauso heisst wie eine Association ist das
				// erstmal nicht relevant.
			}
		});
	}

	/* Eigentlich unnoetig aber kost ja nischt! */
	@Test
	public void sourceOfConstantHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException {
		String name = "test0X";
		// 1. Erstellen
		manager.createConstant(name, mat2);

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Static Operation wurde offenbar nicht erstellt!");
		}
		assertEqualsWithNameAndVisitor(name, new AbsOperationVisitor() {

			@Override
			public void handleOperation(PersistentOperation operation) throws PersistenceException {

				assertEquals(MEmptySumType.getTheMEmptySumType(), operation.getSource());
			}

			@Override
			public void handleAssociation(PersistentAssociation association) throws PersistenceException {
				// Wenn eine Operation genauso heisst wie eine Association ist das
				// erstmal nicht relevant.
			}
		});
	}

	@Test
	public void targetOfVoidOperationHaveToBeEmptySum() throws DoubleDefinitionException, PersistenceException {
		String name = "test05";
		manager.createVoidOperation(mat1, name, manager.getFormalParameters().getList());

		if (Operation.getAbsOperationByName(name).getLength() <= 0) {
			fail("Void Operation wurde offenbar nicht erstellt!");
		}

		assertEqualsWithNameAndVisitor(name, new AbsOperationVisitor() {

			@Override
			public void handleOperation(PersistentOperation operation) throws PersistenceException {
				assertEquals(MEmptySumType.getTheMEmptySumType(), operation.getTarget());
			}

			@Override
			public void handleAssociation(PersistentAssociation association) throws PersistenceException {
				// Wenn eine Operation genauso heisst wie eine Association ist das
				// erstmal nicht relevant.
			}
		});
	}

	@Test
	public void listShouldNotContainOperationAfterRemove() throws DoubleDefinitionException, PersistenceException,
			ConsistencyException {
		final PersistentOperation createOperation = Operation.createOperation("Irgendeiner", mat3, mat4);
		manager.removeOperation(createOperation);
		PersistentOperation found = manager.getOperations().getList().findFirst(new Predcate<PersistentOperation>() {

			@Override
			public boolean test(PersistentOperation argument) throws PersistenceException {
				return argument.equals(createOperation);
			}
		});

		assertNull(found);
	}

	@Test(expected = ConsistencyException.class)
	public void removingOperationIsNotAllowedIfMessagesExists() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		final PersistentOperation createOperation = Operation.createOperation("Irgendeiner01", mat3, mat4);

		messageManager.createMessage(createOperation, mao1, mao6, new ActualParameterSearchList());

		this.manager.removeOperation(createOperation);
	}

	@Test
	public void operationShouldContainParameterAfterAdd() throws PersistenceException, ConsistencyException,
			DoubleDefinitionException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		PersistentOperation createOperation = Operation.createOperation("Irgendeiner01", mat3, mat4);
		manager.addFp(createOperation, param);

		PersistentFormalParameter foundParam = createOperation.getParameters().findFirst(
				new Predcate<PersistentFormalParameter>() {

					@Override
					public boolean test(PersistentFormalParameter argument) throws PersistenceException {
						return param.equals(argument);
					}
				});

		assertNotNull(foundParam);
	}

	@Test
	public void operationShouldContainParameterAfterMultipleAdd() throws PersistenceException, ConsistencyException,
			DoubleDefinitionException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat1, "y");

		FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		PersistentOperation createOperation = Operation.createOperation("IrgendeinerXY", mat3, mat4);
		manager.addMultipleFp(createOperation, searchList);

		SearchListRoot<PersistentFormalParameter> findAll = createOperation.getParameters().findAll(
				new Predcate<PersistentFormalParameter>() {

					@Override
					public boolean test(PersistentFormalParameter argument) throws PersistenceException {
						return param.equals(argument) || param2.equals(argument);
					}
				});

		assertEquals(2, findAll.getLength());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedParametersInSameOperationAreNotAllowd() throws PersistenceException, ConsistencyException,
			DoubleDefinitionException {
		PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "x");

		PersistentOperation createOperation = Operation.createOperation("Irgendeiner01", mat3, mat4);
		manager.addFp(createOperation, param);
		manager.addFp(createOperation, param2);
	}

	@Test(expected = DoubleDefinitionException.class)
	public void equalNamedParametersInSameOperationAreNotAllowd2() throws PersistenceException, ConsistencyException,
			DoubleDefinitionException {
		PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "x");

		FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		PersistentOperation createOperation = Operation.createOperation("Irgendeiner02", mat3, mat4);
		manager.addMultipleFp(createOperation, searchList);
	}

	@Test
	public void operationShouldNotContainParameterAfterRemove() throws PersistenceException, NotAvailableException,
			ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "y");

		PersistentOperation createOperation = Operation.createOperation("Irgendeiner03", mat3, mat4);
		manager.addFp(createOperation, param);
		manager.addFp(createOperation, param2);

		manager.removeFpFromOp(createOperation, param);

		PersistentFormalParameter foundParam = createOperation.getParameters().findFirst(
				new Predcate<PersistentFormalParameter>() {

					@Override
					public boolean test(PersistentFormalParameter argument) throws PersistenceException {
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
	public void removingUsedParametersIsNotAllowed() throws PersistenceException, NotAvailableException,
			ConsistencyException, DoubleDefinitionException {
		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "y");

		FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);
		searchList.add(param2);

		manager.createOperation(mat3, mat4, "IrgendeinerXX", searchList);

		manager.removeFp(param);
	}

	@Test(expected = ConsistencyException.class)
	public void removingFormalParameterFromOperationWithoutTheseParam() throws PersistenceException,
			DoubleDefinitionException, ConsistencyException {
		// TODO: Das muss doch besser gehen!? Erst anlegen und dann den Angelegten mit etwas vergleichen...

		final PersistentFormalParameter param = FormalParameter.createFormalParameter(mat1, "x");
		final PersistentFormalParameter param2 = FormalParameter.createFormalParameter(mat2, "y");

		FormalParameterSearchList searchList = new FormalParameterSearchList();
		searchList.add(param);

		final String name = "IrgendeinerXXX";
		manager.createOperation(mat3, mat4, name, searchList);

		PersistentOperation findFirst = manager.getOperations().findFirst(new Predcate<PersistentOperation>() {

			@Override
			public boolean test(PersistentOperation argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		});
		manager.removeFpFromOp(findFirst, param2);
	}

	@Test
	public void removingFormalParameterIsNotAllowedIfActualParameterExists() throws PersistenceException,
			DoubleDefinitionException {
		this.manager.createFp("Parameter 1", mat1);
		fail("Actualparameter noch nicht anlegbar");
	}

	/**
	 * Iteriert durch alle gleichnamigen AbstractOperations (also Operations oder Associations) und wendet auf jedes
	 * Element den uebergebenen Visitor an.
	 * 
	 * @param name
	 * @param visitor
	 * @throws PersistenceException
	 */
	private void assertEqualsWithNameAndVisitor(String name, AbsOperationVisitor visitor) throws PersistenceException {
		// 1. Wieder aus der Liste fummeln...
		SearchListRoot<PersistentAbsOperation> findAll = Operation.getAbsOperationByName(name);
		/*
		 * 2. Da es ggf. mehrere gibt (bspw. eine Assoziation und eine Operation), nur die iterieren und nur die
		 * Operation vergleichen
		 */
		Iterator<PersistentAbsOperation> iterator = findAll.iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(visitor);
		}
	}
}
