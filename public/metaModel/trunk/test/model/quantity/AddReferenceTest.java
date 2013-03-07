package model.quantity;

import java.util.Iterator;

import junit.framework.Assert;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.AbstractTest;
import util.InjectSingleton;

public class AddReferenceTest extends AbstractTest {

	public AddReferenceTest() {
		super();
	}

	@InjectSingleton(UnitTypeManager.class)
	private PersistentUnitTypeManager utman;

	/**
	 * Unit "m" -> addRef("m", exp= 1) => CU "m²"
	 */
	@Test
	public void addReferenceForUnit_m2() throws PersistenceException, DoubleDefinitionException {
		final PersistentUnitType unitTypeLaenge = UnitType.createUnitType("Laenge");
		final PersistentUnit unitM = Unit.createUnit(unitTypeLaenge, "m");

		final PersistentCompUnit compUnit = utman.addReference("Fläche", unitM, unitM, 1);

		//Exemplarebene richtig?
		Assert.assertEquals(1, compUnit.getRefs().getLength());
		final PersistentReference reference = compUnit.getRefs().iterator().next();
		Assert.assertEquals(unitM, reference.getRef());
		Assert.assertEquals(2, reference.getExponent());

		//Typebene richtig?
		final PersistentCompUnitType compUnitType = (PersistentCompUnitType) compUnit.getType();
		Assert.assertEquals(1, compUnitType.getRefs().getLength());
		final PersistentReferenceType firstRefType = compUnitType.getRefs().iterator().next();
		Assert.assertEquals(2, firstRefType.getExponent());
		Assert.assertEquals(unitTypeLaenge, firstRefType.getRef());
	}
	/**
	 * Unit "km" -> addRef("h", exp= -1) => CU "km/h" (Geschwindigkeit)
	 * -> addRef("s", exp= -1) => CU "km/(h*s)" (Beschleunigung)
	 */
	@Test
	public void addReferenceForUnit_speed_speedup() throws PersistenceException, DoubleDefinitionException {
		final PersistentUnitType unitTypeLaenge = UnitType.createUnitType("Laenge");
		final PersistentUnit unitKm= Unit.createUnit(unitTypeLaenge, "km");

		final PersistentUnitType unitTypeZeit = UnitType.createUnitType("Zeit");
		final PersistentUnit unitH = Unit.createUnit(unitTypeZeit, "h");
		final PersistentUnit unitS = Unit.createUnit(unitTypeZeit, "s");

		//km/h erzeugen
		final PersistentCompUnit compUnitKmh = utman.addReference("km/h", unitKm, unitH, -1);

		
		
		//Exemplarebene km/h richtig?
		Assert.assertEquals(2, compUnitKmh.getRefs().getLength());
		Iterator<PersistentReference> kmhIterator = compUnitKmh.getRefs().iterator();
		
		final PersistentReference reference1 = kmhIterator.next();
		Assert.assertEquals(unitKm, reference1.getRef());
		Assert.assertEquals(1, reference1.getExponent());
		
		final PersistentReference reference2 = kmhIterator.next();
		Assert.assertEquals(unitH, reference2.getRef());
		Assert.assertEquals(-1, reference2.getExponent());

		//Typebene km/h richtig?
		PersistentCompUnitType compUnitKmhType = (PersistentCompUnitType) compUnitKmh.getType();
		Assert.assertEquals(2, compUnitKmhType.getRefs().getLength());
		Iterator<PersistentReferenceType> kmhTypeIterator = compUnitKmhType.getRefs().iterator();
		
		PersistentReferenceType refType1 = kmhTypeIterator.next();
		Assert.assertEquals(1, refType1.getExponent());
		Assert.assertEquals(unitTypeLaenge, refType1.getRef());

		PersistentReferenceType refType2 = kmhTypeIterator.next();
		Assert.assertEquals(-1, refType2.getExponent());
		Assert.assertEquals(unitTypeZeit, refType2.getRef());

		
		
		//km/(h*s) erzeugen
		final PersistentCompUnit compUnitKmhs = utman.addReference("km/(h*s)", compUnitKmh, unitS, -1);

		//Exemplarebene km/h richtig?
		Assert.assertEquals(3, compUnitKmhs.getRefs().getLength());
		Iterator<PersistentReference> kmhsIterator = compUnitKmhs.getRefs().iterator();
		
		final PersistentReference referenceKmhs1 = kmhsIterator.next();
		Assert.assertEquals(unitKm, referenceKmhs1.getRef());
		Assert.assertEquals(1, referenceKmhs1.getExponent());
		
		final PersistentReference referenceKmhs2 = kmhsIterator.next();
		Assert.assertEquals(unitH, referenceKmhs2.getRef());
		Assert.assertEquals(-1, referenceKmhs2.getExponent());
		
		final PersistentReference referenceKmhs3 = kmhsIterator.next();
		Assert.assertEquals(unitS, referenceKmhs3.getRef());
		Assert.assertEquals(-1, referenceKmhs3.getExponent());

		//Typebene km/h richtig?
		PersistentCompUnitType compUnitKmhsType = (PersistentCompUnitType) compUnitKmhs.getType();
		Assert.assertEquals(2, compUnitKmhsType.getRefs().getLength());
		Iterator<PersistentReferenceType> kmhsTypeIterator = compUnitKmhsType.getRefs().iterator();
		
		PersistentReferenceType refTypeKmhs1 = kmhsTypeIterator.next();
		Assert.assertEquals(1, refTypeKmhs1.getExponent());
		Assert.assertEquals(unitTypeLaenge, refTypeKmhs1.getRef());

		PersistentReferenceType refTypeKmhs2 = kmhsTypeIterator.next();
		Assert.assertEquals(-2, refTypeKmhs2.getExponent());
		Assert.assertEquals(unitTypeZeit, refTypeKmhs2.getRef());
		
	}
	
	/**
	 * Scalar holen
	 * @throws PersistenceException 
	 */
	@Test
	public void fetchScalar() throws PersistenceException {
		PersistentCompUnit fetchedScalar = utman.fetchScalar();
		Assert.assertEquals(0, fetchedScalar.getRefs().getLength());
	}

}
