package model.typeSystem;

import model.ConsistencyException;
import model.CycleException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import util.InjectSingleton;
import util.TestingBase;

public class LessOrEqualsTest extends TestingBase {

	@Test
	public void sameAtomicType() throws ConsistencyException, PersistenceException, CycleException {
		final PersistentMAspect aspect = aspect("A");
		final PersistentMAtomicType typeA = atomicType("A", aspect);

		assertMTrue(typeA.isLessOrEqual(typeA));
	}

	@Test
	public void atomicSubtypes() throws PersistenceException, CycleException {
		final PersistentMAspect aspect = aspect("TestAspect");
		final PersistentMAtomicType typeA = atomicType("A", aspect);
		System.out.println(aspect.getName());
		System.out.println(aspect.getName());
		final PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertMTrue(typeB.isLessOrEqual(typeA));
	}

	@Test
	public void atomicTypesNotSubtypes() throws PersistenceException, CycleException {
		final PersistentMAspect aspect = aspect("TestAspect");
		final PersistentMAtomicType typeA = atomicType("A", aspect);
		final PersistentMAtomicType typeB = atomicType("B", aspect);

		assertMFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void atomicTypesNotSubtypes2() throws PersistenceException, CycleException {
		final PersistentMAspect aspect = aspect("TestAspect");
		final PersistentMAtomicType typeA = atomicType("A", aspect);
		final PersistentMAtomicType typeB = atomicType("B", aspect, typeA);

		assertMFalse(typeA.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleIsLoE() throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		final PersistentMMixedConjunction product = product(typeA, typeB);

		assertMTrue(product.isLessOrEqual(typeA));
		assertMTrue(product.isLessOrEqual(typeB));
	}

	@Test
	public void productTypeSimpleNotLoE() throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMMixedConjunction product = product(atomicType("B", aspect("Asp_B")));

		assertMFalse(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumTypeSimpleIsLoE() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		final PersistentMMixedTypeDisjunction sum = sum(typeA, typeB);

		assertMTrue(typeA.isLessOrEqual(sum));
		assertMTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void sumTypeSimpleIsNotLoE() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("Asp_B"));
		final PersistentMMixedTypeDisjunction sum = sum(typeB);

		assertMFalse(typeA.isLessOrEqual(sum));
	}

	@Test
	public void productOfSingleType() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMMixedConjunction product = product(typeA);

		assertMTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void productOfSingleSubType() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		final PersistentMMixedConjunction product = product(typeB);

		assertMTrue(product.isLessOrEqual(typeA));
	}

	@Test
	public void sumOfSingleType() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMMixedTypeDisjunction sum = sum(typeA);

		assertMTrue(typeA.isLessOrEqual(sum));
	}

	@Test
	public void sumOfSingleSubType() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("Asp_A"));
		final PersistentMAtomicType typeB = atomicType("A", aspect("Asp_A"), typeA);
		final PersistentMMixedTypeDisjunction sum = sum(typeA);

		assertMTrue(typeB.isLessOrEqual(sum));
	}

	@Test
	public void productsWithLessFactors() throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		final PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		final PersistentMMixedConjunction product1 = product(typeA, typeB);
		final PersistentMMixedConjunction product2 = product(typeA, typeB, typeC);

		assertMTrue(product2.isLessOrEqual(product1));
		assertMFalse(product1.isLessOrEqual(product2));
	}

	@Test
	public void sumWithLessAddends() throws CycleException, PersistenceException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		final PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		final PersistentMMixedTypeDisjunction sum1 = sum(typeA, typeB);
		final PersistentMMixedTypeDisjunction sum2 = sum(typeA, typeB, typeC);

		assertMTrue(sum1.isLessOrEqual(sum2));
		assertMFalse(sum2.isLessOrEqual(sum1));
	}

	@Test
	public void sumOfProducts() throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		final PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		final PersistentMMixedConjunction product1 = product(typeA, typeB);
		final PersistentMMixedConjunction product2 = product(typeB, typeC);

		final PersistentMMixedTypeDisjunction sum = sum(product1, product2);

		assertMTrue(product1.isLessOrEqual(sum));
		assertMTrue(product2.isLessOrEqual(sum));
		assertMFalse(typeA.isLessOrEqual(sum));
		assertMFalse(typeB.isLessOrEqual(sum));
		assertMFalse(sum.isLessOrEqual(typeC));
	}

	@Test
	public void productOfSums() throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));
		final PersistentMAtomicType typeB = atomicType("B", aspect("B"));
		final PersistentMAtomicType typeC = atomicType("C", aspect("C"));

		final PersistentMMixedTypeDisjunction sum1 = sum(typeA, typeB);
		final PersistentMMixedTypeDisjunction sum2 = sum(typeB, typeC);

		final PersistentMMixedConjunction product = product(sum1, sum2);

		assertMTrue(product.isLessOrEqual(sum1));
		assertMTrue(product.isLessOrEqual(sum2));
	}

	@Test
	public void emptyProduct(@InjectSingleton(MEmptyTypeConjunction.class) final PersistentMEmptyTypeConjunction emptyTypeConjunction)
			throws PersistenceException, CycleException {
		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertMFalse(MEmptyTypeConjunction.getTheMEmptyTypeConjunction().isLessOrEqual(typeA));
		assertMTrue(typeA.isLessOrEqual(emptyTypeConjunction));
	}

	@Test
	public void emptySum(@InjectSingleton(MEmptyTypeDisjunction.class) final PersistentMEmptyTypeDisjunction emptyTypeDisjunction)
			throws PersistenceException, CycleException {

		final PersistentMAtomicType typeA = atomicType("A", aspect("A"));

		assertMTrue(emptyTypeDisjunction.isLessOrEqual(typeA));
	}

}
