package test;

import static org.junit.Assert.assertEquals;
import model.CycleException;
import model.MAspect;
import model.MAtomicType;
import model.MFalse;
import model.MProductType;
import model.MSumType;
import model.MTrue;
import model.WrongSubTypeAspectException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;

public class LessOrEqualThanTest extends AbstractTest {
	
	private PersistentMAspect aspect1;
	private PersistentMAspect aspect2;
	private PersistentMAspect aspect3;

	private PersistentMBoolean mTrue;
	private PersistentMBoolean mFalse;

	
	@Before
	public void init() throws PersistenceException {
		aspect1 = MAspect.createMAspect("Aspekt No. 1");
		aspect2 = MAspect.createMAspect("Aspekt No. 2");
		aspect3 = MAspect.createMAspect("Aspekt No. 3");

		mTrue = MTrue.getTheMTrue();
		mFalse = MFalse.getTheMFalse();
	}

	@Test	
	public void atomicTypeLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		mat1.setSuperType(mat2);
		assertEquals(mTrue, mat1.lessOrEqual(mat2));
		assertEquals(mFalse, mat2.lessOrEqual(mat1));
		assertEquals(mTrue, mat1.lessOrEqual(mat1));
	}
	
	@Test	
	public void atomicTypeIndirectLessOrEqualThanAtomicType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);
		PersistentMAtomicType mat3 = MAtomicType.createMAtomicType("Typ3",aspect3);
		
		mat1.setSuperType(mat2);
		mat2.setSuperType(mat3);
		
		assertEquals(mTrue, mat1.lessOrEqual(mat3));
		assertEquals(mFalse, mat2.lessOrEqual(mat1));
		assertEquals(mFalse, mat3.lessOrEqual(mat1));

		assertEquals(mTrue, mat1.lessOrEqual(mat1));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanEmptyProductType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMProductType mpt = MProductType.createMProductType();
		
		assertEquals(mFalse, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanSameSingleProductType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMProductType mpt = MProductType.createMProductType();
		
		mpt.getContainedTypes().add(mat1);
		
		assertEquals(mTrue, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanLessSingleProductType() throws PersistenceException, CycleException, WrongSubTypeAspectException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType mpt = MProductType.createMProductType();
		
		mat2.addSubType(mat1);
		mpt.getContainedTypes().add(mat2);
		
		assertEquals(mTrue, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanNotSameSingleProductType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType mpt = MProductType.createMProductType();
		
		mpt.getContainedTypes().add(mat2);
		
		assertEquals(mFalse, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleProductType1() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType mpt = MProductType.createMProductType();
		
		mpt.getContainedTypes().add(mat2);
		mpt.getContainedTypes().add(mat1);
		
		assertEquals(mFalse, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleProductType2() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);
		PersistentMAtomicType mat3 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType mpt = MProductType.createMProductType();
		
		mpt.getContainedTypes().add(mat2);
		mpt.getContainedTypes().add(mat3);
		
		assertEquals(mFalse, mat1.lessOrEqual(mpt));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleProductType3() throws PersistenceException, CycleException, WrongSubTypeAspectException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);
		PersistentMAtomicType mat3 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType mpt = MProductType.createMProductType();
		
		mat3.addSubType(mat1);
		mpt.getContainedTypes().add(mat2);
		mpt.getContainedTypes().add(mat3);
		
		assertEquals(mFalse, mat1.lessOrEqual(mpt));
	}
	
	/*
	 * ODER
	 */
	
	@Test	
	public void atomicTypeLessOrEqualThanSameSingleSumType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMSumType sumType = MSumType.createMSumType();
		
		sumType.getContainedTypes().add(mat1);
		
		assertEquals(mTrue, mat1.lessOrEqual(sumType));
	}
	
	@Test	
	public void atomicTypeLessThanSingleSumType() throws PersistenceException, CycleException, WrongSubTypeAspectException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMSumType sumType = MSumType.createMSumType();
		
		mat2.addSubType(mat1);
		sumType.getContainedTypes().add(mat2);
		
		assertEquals(mTrue, mat1.lessOrEqual(sumType));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanNotSameSingleSumType() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMSumType sumType = MSumType.createMSumType();
		
		sumType.getContainedTypes().add(mat2);
		
		assertEquals(mFalse, mat1.lessOrEqual(sumType));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleSumType1() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMSumType sumType = MSumType.createMSumType();
		
		sumType.getContainedTypes().add(mat2);
		sumType.getContainedTypes().add(mat1);
		
		assertEquals(mTrue, mat1.lessOrEqual(sumType));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleSumType2() throws PersistenceException, CycleException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);
		PersistentMAtomicType mat3 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMSumType sumType = MSumType.createMSumType();
		
		sumType.getContainedTypes().add(mat2);
		sumType.getContainedTypes().add(mat3);
		
		assertEquals(mFalse, mat1.lessOrEqual(sumType));
	}
	
	@Test	
	public void atomicTypeLessOrEqualThanMultipleSumType3() throws PersistenceException, CycleException, WrongSubTypeAspectException {
		PersistentMAtomicType mat1 = MAtomicType.createMAtomicType("Typ1",aspect1);
		PersistentMAtomicType mat2 = MAtomicType.createMAtomicType("Typ2",aspect2);
		PersistentMAtomicType mat3 = MAtomicType.createMAtomicType("Typ2",aspect2);

		PersistentMProductType sumType = MProductType.createMProductType();
		
		mat3.addSubType(mat1);
		sumType.getContainedTypes().add(mat2);
		sumType.getContainedTypes().add(mat3);
		
		assertEquals(mTrue, mat1.lessOrEqual(sumType));
	}
	
	

	
}