package model.typeSystem;

import model.ConsistencyException;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import util.TestingBase;

public class LessOrEqualsTest extends TestingBase {

	@Test
	public void sameAtomicType() throws ConsistencyException, PersistenceException {
		PersistentMAspect aspect = aspect("A");
		PersistentMAtomicType typeA = atomicType("A", aspect);

		assertTrue(typeA.isLessOrEqual(typeA));
	}

	@Test
	public void atomicSubtypes() throws PersistenceException, CycleException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertTrue(typeB.isLessOrEqual(typeA));
	}

	@Test
	public void atomicTypesNotSubtypes() throws PersistenceException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect);

		assertFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void atomicTypesNotSubtypes2() throws PersistenceException, CycleException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleIsLoE() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMProductType product = product(typeA, typeB);

		assertTrue(product.isLessOrEqual(typeA));
		assertTrue(product.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleNotLoE() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMProductType product = product(atomicType("B", aspect("Asp_B")));

		assertFalse(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumTypeSimpleIsLoE() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMSumType sum = sum(typeA, typeB);

		assertTrue(typeA.isLessOrEqual(sum));
		assertTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void sumTypeSimpleIsNotLoE() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMSumType sum = sum(typeB);

		assertFalse(typeA.isLessOrEqual(sum));
	}

	@Test
	public void productOfSingleType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMProductType product = product(typeA);

		assertTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void productOfSingleSubType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		PersistentMProductType product = product(typeB);

		assertTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumOfSingleType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMSumType sum = sum(typeA);

		assertTrue(typeA.isLessOrEqual(sum));
	}

	@Test
	public void sumOfSingleSubType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		PersistentMSumType sum = sum(typeA);

		assertTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void productsWithLessFactors() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMProductType product1 = product(typeA, typeB);
		PersistentMProductType product2 = product(typeA, typeB, typeC);

		assertTrue(product2.isLessOrEqual(product1));
		assertFalse(product1.isLessOrEqual(product2));
	}

	@Test
	public void sumWithLessAddends() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMSumType sum1 = sum(typeA, typeB);
		PersistentMSumType sum2 = sum(typeA, typeB, typeC);

		assertTrue(sum1.isLessOrEqual(sum2));
		assertFalse(sum2.isLessOrEqual(sum1));
	}

	@Test
	public void sumOfProducts() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMProductType product1 = product(typeA, typeB);
		PersistentMProductType product2 = product(typeB, typeC);

		PersistentMSumType sum = sum(product1, product2);

		assertTrue(product1.isLessOrEqual(sum));
		assertTrue(product2.isLessOrEqual(sum));
		assertFalse(typeA.isLessOrEqual(sum));
		assertFalse(typeB.isLessOrEqual(sum));
		assertFalse(sum.isLessOrEqual(typeC));
	}

	@Test
	public void productOfSums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMSumType sum1 = sum(typeA, typeB);
		PersistentMSumType sum2 = sum(typeB, typeC);

		PersistentMProductType product = product(sum1, sum2);

		assertTrue(product.isLessOrEqual(sum1));
		assertTrue(product.isLessOrEqual(sum2));
	}

	@Test
	public void emptyProduct() throws PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertTrue(MEmptyProductType.getTheMEmptyProductType().isLessOrEqual(typeA));
	}

	@Test
	public void emptySum() throws PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertFalse(MEmptySumType.getTheMEmptySumType().isLessOrEqual(typeA));
	}

}
