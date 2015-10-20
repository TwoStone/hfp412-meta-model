package model.messageOrLink;

import static org.junit.Assert.assertEquals;
import model.ConsistencyException;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.ActualParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentMessage;
import persistence.PersistentMessageManager;
import persistence.Predcate;
import util.AbstractTest;
import util.InjectSingleton;

public class MessageManagerTest extends AbstractTest {

	@InjectSingleton(MessageManager.class)
	private PersistentMessageManager messMan;

	@Test
	public void removeStandardMessage() throws PersistenceException, DoubleDefinitionException {
		messMan.getMessages().add(standardMessage);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.removeMessage(standardMessage);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test
	public void removeVoidMessage() throws PersistenceException, DoubleDefinitionException {
		messMan.getMessages().add(voidMessage);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.removeMessage(voidMessage);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test
	public void removeConstantMessage() throws PersistenceException, DoubleDefinitionException {
		messMan.getMessages().add(constantMessage);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.removeMessage(constantMessage);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test
	public void removeStaticMessage() throws PersistenceException, DoubleDefinitionException {
		messMan.getMessages().add(staticMessage);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.removeMessage(staticMessage);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test
	public void createStandardMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createVoidMessageSuccess() throws PersistenceException, DoubleDefinitionException, ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createConstantMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createStaticMessageSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createStandardMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao1, mao6, apList);
		assertEquals(1, messMan.getMessages().getLength());
		assertEquals(3, messMan.getMessages().findFirst(new Predcate<PersistentMessage>() {
			@Override
			public boolean test(PersistentMessage argument) throws PersistenceException {
				return true;
			}
		}).getActualParameters().getLength());
	}

	@Test
	public void createVoidMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createVoidMessage(voidOp, mao1, apList);
		assertEquals(1, messMan.getMessages().getLength());
		assertEquals(3, messMan.getMessages().findFirst(new Predcate<PersistentMessage>() {
			@Override
			public boolean test(PersistentMessage argument) throws PersistenceException {
				return true;
			}
		}).getActualParameters().getLength());
	}

	@Test
	public void createStaticMessageWithAPSuccess() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createStaticMessage(staticOp, "staticOperation", mao1, apList);
		assertEquals(1, messMan.getMessages().getLength());
		assertEquals(3, messMan.getMessages().findFirst(new Predcate<PersistentMessage>() {
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
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao6, mao6, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStandardMessageFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao1, mao1, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createVoidMessageFailureWrongSource() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createVoidMessage(voidOp, mao6, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createConstantFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createConst(constantOp, "constantOperation", mao6);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStaticMessageFailureWrongTarget() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createStaticMessage(staticOp, "staticOperation", mao6, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStandardMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(voidOp, mao6, mao1, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createVoidMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createVoidMessage(standardOp, mao6, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createConstantFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createConst(standardOp, "constantOperation", mao6);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = ConsistencyException.class)
	public void createStaticMessageFailureWrongType() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createStaticMessage(standardOp, "staticOperation", mao6, ap);
		assertEquals(0, messMan.getMessages().getLength());
	}

	@Test(expected = DoubleDefinitionException.class)
	public void createStandardMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.createMessage(standardOp, mao1, mao6, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createVoidMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.createVoidMessage(voidOp, mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createConstantMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.createConst(constantOp, "constantOperation", mao1);
		assertEquals(1, messMan.getMessages().getLength());
	}

	@Test
	public void createStaticMessageFailureDDE() throws PersistenceException, DoubleDefinitionException,
			ConsistencyException {
		ActualParameterSearchList ap = new ActualParameterSearchList();
		assertEquals(0, messMan.getMessages().getLength());
		messMan.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
		messMan.createStaticMessage(staticOp, "staticOperation", mao1, ap);
		assertEquals(1, messMan.getMessages().getLength());
	}
}
