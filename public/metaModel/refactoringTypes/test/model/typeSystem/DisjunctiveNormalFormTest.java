package model.typeSystem;

import junit.framework.Assert;
import model.CycleException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import util.TestingBase;

public class DisjunctiveNormalFormTest extends TestingBase {

	@Before
	public void setUp() throws PersistenceException {
	}

	public void tearDown() {
	}

	@Test
	public void testAtomicType() throws PersistenceException, CycleException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);

		PersistentMSumType expected = sum(product(typeA));

		assertEquals(expected, typeA.fetchDisjunctiveNormalform());
		Assert.assertTrue(typeA.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testEmptySum() throws PersistenceException {
		PersistentMEmptySumType theMEmptySumType = MEmptySumType.getTheMEmptySumType();

		Assert.assertEquals(theMEmptySumType, theMEmptySumType.fetchDisjunctiveNormalform());
		Assert.assertFalse(theMEmptySumType.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testEmptyProduct() throws PersistenceException, CycleException {
		PersistentMEmptyProductType theMEmptyProductType = MEmptyProductType.getTheMEmptyProductType();

		PersistentMSumType expected = sum(theMEmptyProductType);

		assertEquals(expected, theMEmptyProductType.fetchDisjunctiveNormalform());
		Assert.assertTrue(theMEmptyProductType.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProduct() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMProductType product = product(typeA, typeB);

		PersistentMSumType expected = sum(product(typeA, typeB));

		assertEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductWithSum() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMProductType product = product(typeA, sum(typeB, typeC));

		PersistentMSumType expected = sum(product(typeA, typeB), product(typeA, typeC));

		assertEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductWithSum2() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMProductType product = product(typeA, sum(product(typeB, typeC), typeD));

		PersistentMSumType expected = sum(product(typeA, typeB, typeC), product(typeA, typeD));

		assertEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductOf2Sums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMProductType product = product(sum(typeA, typeB), sum(typeC, typeD));

		PersistentMSumType expected = sum(product(typeA, typeC), product(typeB, typeC), product(typeA, typeD),
				product(typeB, typeD));

		assertEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductOf2Products() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMProductType product = product(product(typeA, typeB), product(typeC, typeD));

		PersistentMSumType expected = sum(product(typeA, typeB, typeC, typeD));

		assertEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSum() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMSumType sum = sum(typeA, typeB);

		PersistentMSumType expected = sum(product(typeA), product(typeB));

		assertEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSumOf2Products() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMSumType sum = sum(product(typeA, typeB), product(typeC, typeD));

		PersistentMSumType expected = sum(product(typeA, typeB), product(typeC, typeD));

		assertEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSumOf2Sums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMSumType sum = sum(sum(typeA, typeB), sum(typeC, typeD));

		PersistentMSumType expected = sum(product(typeA), product(typeB), product(typeC), product(typeD));

		assertEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}
}
