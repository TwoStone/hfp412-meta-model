package model.typeSystem;

import junit.framework.Assert;
import model.CycleException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
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

		PersistentMMixedTypeDisjunction expected = sum(product(typeA));

		// Reflexivität
		assertMTrue(typeA.isLessOrEqual(typeA));
		// Äquivalenz zur eigenen DNF
		assertMTrue(typeA.isLessOrEqual(typeA.fetchDisjunctiveNormalform()));
		assertMTrue(typeA.fetchDisjunctiveNormalform().isLessOrEqual(typeA));

		// Reflexivität der DNF
		assertMTrue(typeA.fetchDisjunctiveNormalform().isLessOrEqual(typeA.fetchDisjunctiveNormalform()));

		assertMTrue(typeA.fetchDisjunctiveNormalform().isLessOrEqual(expected.fetchDisjunctiveNormalform()));
		assertMTrue(expected.isLessOrEqual(typeA.fetchDisjunctiveNormalform()));
		assertTypeSemanticEquals(expected, typeA.fetchDisjunctiveNormalform());
		Assert.assertTrue(typeA.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testEmptySum() throws PersistenceException {
		PersistentMEmptyTypeDisjunction theMEmptySumType = MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();

		Assert.assertEquals(theMEmptySumType, theMEmptySumType.fetchDisjunctiveNormalform());
	}

	@Test
	public void testEmptyProduct() throws PersistenceException, CycleException {
		PersistentMEmptyTypeConjunction theMEmptyProductType = MEmptyTypeConjunction.getTheMEmptyTypeConjunction();

		PersistentMMixedTypeDisjunction expected = sum(theMEmptyProductType);

		assertTypeStructureEquals(expected, theMEmptyProductType.fetchDisjunctiveNormalform());
		Assert.assertTrue(theMEmptyProductType.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProduct() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMMixedConjunction product = product(typeA, typeB);

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeB));
		assertTypeStructureEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductWithSum() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMMixedConjunction product = product(typeA, sum(typeB, typeC));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeB), product(typeA, typeC));

		assertTypeStructureEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductWithSum2() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMMixedConjunction product = product(typeA, sum(product(typeB, typeC), typeD));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeB, typeC), product(typeA, typeD));

		assertTypeStructureEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductOf2Sums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMMixedConjunction product = product(sum(typeA, typeB), sum(typeC, typeD));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeC), product(typeA, typeD),
				product(typeB, typeC), product(typeB, typeD));

		assertTypeStructureEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testProductOf2Products() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMMixedConjunction product = product(product(typeA, typeB), product(typeC, typeD));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeB, typeC, typeD));

		assertTypeStructureEquals(expected, product.fetchDisjunctiveNormalform());
		Assert.assertTrue(product.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSum() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));
		PersistentMMixedTypeDisjunction sum = sum(typeA, typeB);

		PersistentMMixedTypeDisjunction expected = sum(product(typeA), product(typeB));

		assertTypeStructureEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSumOf2Products() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMMixedTypeDisjunction sum = sum(product(typeA, typeB), product(typeC, typeD));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA, typeB), product(typeC, typeD));

		assertTypeStructureEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}

	@Test
	public void testSumOf2Sums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Aspect1"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Aspect2"));

		PersistentMAtomicType typeC = atomicType("C", aspect("Aspect3"));
		PersistentMAtomicType typeD = atomicType("D", aspect("Aspect4"));

		PersistentMMixedTypeDisjunction sum = sum(sum(typeA, typeB), sum(typeC, typeD));

		PersistentMMixedTypeDisjunction expected = sum(product(typeA), product(typeB), product(typeC), product(typeD));

		assertTypeStructureEquals(expected, sum.fetchDisjunctiveNormalform());
		Assert.assertTrue(sum.fetchDisjunctiveNormalform().isDelayed$Persistence());
	}
}
