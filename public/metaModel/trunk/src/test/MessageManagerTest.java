package test;

import static org.junit.Assert.assertEquals;
import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.messageOrLink.MessageManager;

import org.junit.Before;
import org.junit.Test;

import persistence.ActualParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentMessage;
import persistence.PersistentMessageManager;
import persistence.Predcate;
import test.util.AbstractTest;

public class MessageManagerTest extends AbstractTest {
	private final PersistentMessageManager manager;

	public MessageManagerTest() throws CycleException, PersistenceException {
		super();
		this.manager = MessageManager.getTheMessageManager();
	}

	@Before
	public void cleanUp() throws PersistenceException {
		// TODO: Manager leeren
	}

	@Test
	public void removeStandardMessage() throws PersistenceException, DoubleDefinitionException {
		manager.getMessages().add(standardMessage);
		assertEquals(1, manager.getMessages().getLength());
		manager.removeMessage(standardMessage);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test
	public void removeVoidMessage() throws PersistenceException, DoubleDefinitionException {
		manager.getMessages().add(voidMessage);
		assertEquals(1, manager.getMessages().getLength());
		manager.removeMessage(voidMessage);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test
	public void removeConstantMessage() throws PersistenceException, DoubleDefinitionException {
		manager.getMessages().add(constantMessage);
		assertEquals(1, manager.getMessages().getLength());
		manager.removeMessage(constantMessage);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test
	public void removeStaticMessage() throws PersistenceException, DoubleDefinitionException {
		manager.getMessages().add(staticMessage);
		assertEquals(1, manager.getMessages().getLength());
		manager.removeMessage(staticMessage);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test
	public void createStandardMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createVoidMessageSuccess() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createConstantMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createStaticMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createStandardMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao1, mao6, apList);
		assertEquals(1, manager.getMessages().getLength());
		assertEquals(3, manager.getMessages().findFirst(new Predcate<PersistentMessage>() {
			@Override
			public boolean test(PersistentMessage argument) throws PersistenceException {
				return true;
			}
		}).getActualParameters().getLength());
	}

	@Test
	public void createVoidMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, manager.getMessages().getLength());
		manager.createVoidMessage(voidOp, mao1, apList);
		assertEquals(1, manager.getMessages().getLength());
		assertEquals(3, manager.getMessages().findFirst(new Predcate<PersistentMessage>() {
			@Override
			public boolean test(PersistentMessage argument) throws PersistenceException {
				return true;
			}
		}).getActualParameters().getLength());
	}

	@Test
	public void createStaticMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, manager.getMessages().getLength());
		manager.createStaticMessage(staticOp, "staticOperation", mao1, apList);
		assertEquals(1, manager.getMessages().getLength());
		assertEquals(3, manager.getMessages().findFirst(new Predcate<PersistentMessage>() {
			@Override
			public boolean test(PersistentMessage argument) throws PersistenceException {
				return true;
			}
		}).getActualParameters().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStandardMessageFailureWrongSource() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao6, mao6, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStandardMessageFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao1, mao1, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createVoidMessageFailureWrongSource() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createVoidMessage(voidOp, mao6, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createConstantFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, manager.getMessages().getLength());
		manager.createConst(constantOp, "constantOperation", mao6);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStaticMessageFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createStaticMessage(staticOp, "staticOperation", mao6, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStandardMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(voidOp, mao6, mao1, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createVoidMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createVoidMessage(standardOp, mao6, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createConstantFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, manager.getMessages().getLength());
		manager.createConst(standardOp, "constantOperation", mao6);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStaticMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createStaticMessage(standardOp, "staticOperation", mao6, ap);
		assertEquals(0, manager.getMessages().getLength());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createStandardMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, manager.getMessages().getLength());
		manager.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createVoidMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
		manager.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createConstantMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, manager.getMessages().getLength());
		manager.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, manager.getMessages().getLength());
	}

	@Test
	public void createStaticMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, manager.getMessages().getLength());
		manager.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
		manager.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, manager.getMessages().getLength());
	}
}
