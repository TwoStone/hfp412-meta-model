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

		assertMTrue(typeA.isLessOrEqual(typeA));
	}

	@Test
	public void atomicSubtypes() throws PersistenceException, CycleException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertMTrue(typeB.isLessOrEqual(typeA));
	}

	@Test
	public void atomicTypesNotSubtypes() throws PersistenceException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect);

		assertMFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void atomicTypesNotSubtypes2() throws PersistenceException, CycleException {
		PersistentMAspect aspect = aspect("TestAspect");
		PersistentMAtomicType typeA = atomicType("A", aspect);
		PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertMFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleIsLoE() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMProductType product = product(typeA, typeB);

		assertMTrue(product.isLessOrEqual(typeA));
		assertMTrue(product.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleNotLoE() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMProductType product = product(atomicType("B", aspect("Asp_B")));

		assertMFalse(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumTypeSimpleIsLoE() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMSumType sum = sum(typeA, typeB);

		assertMTrue(typeA.isLessOrEqual(sum));
		assertMTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void sumTypeSimpleIsNotLoE() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		PersistentMSumType sum = sum(typeB);

		assertMFalse(typeA.isLessOrEqual(sum));
	}

	@Test
	public void productOfSingleType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMProductType product = product(typeA);

		assertMTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void productOfSingleSubType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		PersistentMProductType product = product(typeB);

		assertMTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumOfSingleType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMSumType sum = sum(typeA);

		assertMTrue(typeA.isLessOrEqual(sum));
	}

	@Test
	public void sumOfSingleSubType() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		PersistentMSumType sum = sum(typeA);

		assertMTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void productsWithLessFactors() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMProductType product1 = product(typeA, typeB);
		PersistentMProductType product2 = product(typeA, typeB, typeC);

		assertMTrue(product2.isLessOrEqual(product1));
		assertMFalse(product1.isLessOrEqual(product2));
	}

	@Test
	public void sumWithLessAddends() throws CycleException, PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMSumType sum1 = sum(typeA, typeB);
		PersistentMSumType sum2 = sum(typeA, typeB, typeC);

		assertMTrue(sum1.isLessOrEqual(sum2));
		assertMFalse(sum2.isLessOrEqual(sum1));
	}

	@Test
	public void sumOfProducts() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMProductType product1 = product(typeA, typeB);
		PersistentMProductType product2 = product(typeB, typeC);

		PersistentMSumType sum = sum(product1, product2);

		assertMTrue(product1.isLessOrEqual(sum));
		assertMTrue(product2.isLessOrEqual(sum));
		assertMFalse(typeA.isLessOrEqual(sum));
		assertMFalse(typeB.isLessOrEqual(sum));
		assertMFalse(sum.isLessOrEqual(typeC));
	}

	@Test
	public void productOfSums() throws PersistenceException, CycleException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		PersistentMSumType sum1 = sum(typeA, typeB);
		PersistentMSumType sum2 = sum(typeB, typeC);

		PersistentMProductType product = product(sum1, sum2);

		assertMTrue(product.isLessOrEqual(sum1));
		assertMTrue(product.isLessOrEqual(sum2));
	}

	@Test
	public void emptyProduct() throws PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertMTrue(MEmptyProductType.getTheMEmptyProductType().isLessOrEqual(typeA));
	}

	@Test
	public void emptySum() throws PersistenceException {
		PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertMFalse(MEmptySumType.getTheMEmptySumType().isLessOrEqual(typeA));
	}

}
