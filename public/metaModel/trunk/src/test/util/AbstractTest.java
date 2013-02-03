package test.util;

import model.CycleException;
import model.DBConnectionConstants;
import model.InstanceObject;
import model.abstractOperation.FormalParameter;
import model.abstractOperation.Operation;
import model.basic.MFalse;
import model.basic.MTrue;
import model.messageOrLink.ActualParameter;
import model.messageOrLink.Message;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MEmptyProductType;
import model.typeSystem.MEmptySumType;
import model.typeSystem.MProductType;
import model.typeSystem.MSumType;
import modelServer.ConnectionServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import persistence.ActualParameterSearchList;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentActualParameter;
import persistence.PersistentFormalParameter;
import persistence.PersistentInstanceObject;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMessage;
import persistence.PersistentOperation;

public abstract class AbstractTest {

	protected PersistentMBoolean mTrue;
	protected PersistentMBoolean mFalse;

	protected PersistentMAtomicType mat1;
	protected PersistentMAtomicType mat2;
	protected PersistentMAtomicType mat3;
	protected PersistentMAtomicType mat4;
	protected PersistentMAtomicType mat5;
	protected PersistentMAtomicType mat6;

	protected PersistentMEmptyProductType mptEmpty;
	protected PersistentMProductType mptSingle1;
	protected PersistentMProductType mptSingle2;
	protected PersistentMProductType mptSingle3;
	protected PersistentMProductType mptSingle4;
	protected PersistentMProductType mptSingle5;
	protected PersistentMProductType mptMultiple2And4;
	protected PersistentMProductType mptMultiple4And2;
	protected PersistentMProductType mptMultiple5And6;
	protected PersistentMProductType mptMultiple4And5;

	protected PersistentMEmptySumType mstEmpty;
	protected PersistentMSumType mstSingle1;
	protected PersistentMSumType mstSingle2;
	protected PersistentMSumType mstSingle3;
	protected PersistentMSumType mstSingle4;
	protected PersistentMSumType mstSingle5;
	protected PersistentMSumType mstMultiple2And4;
	protected PersistentMSumType mstMultiple4And2;
	protected PersistentMSumType mstMultiple4And5;
	protected PersistentMSumType mstMultiple5And6;
	protected PersistentMSumType mstMultiple2And4And5;

	protected PersistentInstanceObject mao1;
	protected PersistentInstanceObject mao6;
	protected PersistentInstanceObject msoEmpty;

	protected PersistentOperation standardOp;
	protected PersistentOperation voidOp;
	protected PersistentOperation constantOp;
	protected PersistentOperation staticOp;

	protected PersistentMessage standardMessage;
	protected PersistentMessage voidMessage;
	protected PersistentMessage constantMessage;
	protected PersistentMessage staticMessage;

	protected ActualParameterSearchList apList;

	protected PersistentActualParameter ap1;
	protected PersistentActualParameter ap2;
	protected PersistentActualParameter ap3;

	protected PersistentFormalParameter fp1;
	protected PersistentFormalParameter fp2;
	protected PersistentFormalParameter fp3;

	public AbstractTest() throws CycleException, PersistenceException {
		this.initHierarchy();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DBConnectionConstants.Password = new char[2];
		ConnectionHandler connection = ConnectionHandler.getTheConnectionHandler();
		connection.connect(DBConnectionConstants.DataBaseName, DBConnectionConstants.SchemaName,
				DBConnectionConstants.UserName, DBConnectionConstants.Password, true);
		ConnectionHandler.initializeMapsForMappedFields();
		ConnectionServer.startTheConnectionServer(EmptyServerReporter.getTheInstance());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ConnectionServer.stopTheConnectionServer();
	}

	private void initHierarchy() throws CycleException, PersistenceException {
		// Boolean
		mTrue = MTrue.getTheMTrue();
		mFalse = MFalse.getTheMFalse();

		// AtomicType
		mat1 = MAtomicType.createMAtomicType("Typ1", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 1"));
		mat2 = MAtomicType.createMAtomicType("Typ2", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 2"));
		mat3 = MAtomicType.createMAtomicType("Typ3", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 3"));
		mat4 = MAtomicType.createMAtomicType("Typ4", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 4"));
		mat5 = MAtomicType.createMAtomicType("Typ5", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 5"));
		mat6 = MAtomicType.createMAtomicType("Typ5", mFalse, mFalse, MAspect.createMAspect("Aspekt No. 6"));

		mat1.setSuperType(mat2);
		mat2.setSuperType(mat3);

		// ProductType
		mptEmpty = MEmptyProductType.getTheMEmptyProductType();
		mptSingle1 = MProductType.createMProductType();
		mptSingle2 = MProductType.createMProductType();
		mptSingle3 = MProductType.createMProductType();
		mptSingle4 = MProductType.createMProductType();
		mptSingle5 = MProductType.createMProductType();
		mptMultiple2And4 = MProductType.createMProductType();
		mptMultiple4And2 = MProductType.createMProductType();
		mptMultiple5And6 = MProductType.createMProductType();
		mptMultiple4And5 = MProductType.createMProductType();

		mptSingle1.getContainedTypes().add(mat1);
		mptSingle2.getContainedTypes().add(mat2);
		mptSingle3.getContainedTypes().add(mat3);
		mptSingle4.getContainedTypes().add(mat4);
		mptSingle5.getContainedTypes().add(mat5);
		mptMultiple2And4.getContainedTypes().add(mat2);
		mptMultiple2And4.getContainedTypes().add(mat4);
		mptMultiple4And2.getContainedTypes().add(mat4);
		mptMultiple4And2.getContainedTypes().add(mat2);
		mptMultiple5And6.getContainedTypes().add(mat5);
		mptMultiple5And6.getContainedTypes().add(mat6);
		mptMultiple4And5.getContainedTypes().add(mat4);
		mptMultiple4And5.getContainedTypes().add(mat5);

		// SumType
		mstEmpty = MEmptySumType.getTheMEmptySumType();
		mstSingle1 = MSumType.createMSumType();
		mstSingle2 = MSumType.createMSumType();
		mstSingle3 = MSumType.createMSumType();
		mstSingle4 = MSumType.createMSumType();
		mstSingle5 = MSumType.createMSumType();
		mstMultiple2And4 = MSumType.createMSumType();
		mstMultiple4And2 = MSumType.createMSumType();
		mstMultiple4And5 = MSumType.createMSumType();
		mstMultiple5And6 = MSumType.createMSumType();
		mstMultiple2And4And5 = MSumType.createMSumType();

		mstSingle1.getContainedTypes().add(mat1);
		mstSingle2.getContainedTypes().add(mat2);
		mstSingle3.getContainedTypes().add(mat3);
		mstSingle4.getContainedTypes().add(mat4);
		mstSingle5.getContainedTypes().add(mat5);
		mstMultiple2And4.getContainedTypes().add(mat2);
		mstMultiple2And4.getContainedTypes().add(mat4);
		mstMultiple4And2.getContainedTypes().add(mat4);
		mstMultiple4And2.getContainedTypes().add(mat2);
		mstMultiple4And5.getContainedTypes().add(mat4);
		mstMultiple4And5.getContainedTypes().add(mat5);
		mstMultiple5And6.getContainedTypes().add(mat5);
		mstMultiple5And6.getContainedTypes().add(mat6);
		mstMultiple2And4And5.getContainedTypes().add(mat2);
		mstMultiple2And4And5.getContainedTypes().add(mat4);
		mstMultiple2And4And5.getContainedTypes().add(mat5);

		mao1 = InstanceObject.createInstanceObject(mat1);
		mao6 = InstanceObject.createInstanceObject(mat6);
		// TODO: Exemplar von emptySumType
		// msoEmpty = InstanceObject.createInstanceObject(mstEmpty);

		standardOp = Operation.createOperation("Standardoperation", mat1, mat6);
		voidOp = Operation.createOperation("void-Operation", mat1, mstEmpty);
		constantOp = Operation.createOperation("Konstante", mstEmpty, mat1);
		staticOp = Operation.createOperation("static-Operation", mstEmpty, mat1);

		standardMessage = Message.createMessage(mao1, mao6, standardOp);
		// TODO
		// voidMessage = Message.createMessage(mao1, msoEmpty, standardOp);
		// constantMessage = Message.createMessage(msoEmpty, mao1, standardOp);
		// staticMessage = Message.createMessage(msoEmpty, mao1, standardOp);

		fp1 = FormalParameter.createFormalParameter(mat1, "formalparameter1");
		fp2 = FormalParameter.createFormalParameter(mat1, "formalparameter2");
		fp3 = FormalParameter.createFormalParameter(mat6, "formalparameter3");

		ap1 = ActualParameter.createActualParameter(fp1, mao1);
		ap2 = ActualParameter.createActualParameter(fp2, mao1);
		ap3 = ActualParameter.createActualParameter(fp3, mao6);

		apList = new ActualParameterSearchList();
	}
}
