package test;

import static org.junit.Assert.assertEquals;
import model.CycleException;
import model.DoubleDefinitionException;
import model.messageOrLink.MessageManager;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMessageManager;
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
}
