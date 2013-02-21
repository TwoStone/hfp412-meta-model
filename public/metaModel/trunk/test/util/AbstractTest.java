package util;

import java.io.IOException;
import java.sql.SQLException;

import model.ConsistencyException;
import model.CycleException;
import model.abstractOperation.FormalParameter;
import model.abstractOperation.Operation;
import model.messageOrLink.ActualParameter;
import model.messageOrLink.Message;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MEmptyTypeConjunction;
import model.typeSystem.MEmptyTypeDisjunction;
import model.typeSystem.MObject;

import org.junit.Before;

import persistence.ActualParameterSearchList;
import persistence.PersistenceException;
import persistence.PersistentActualParameter;
import persistence.PersistentFormalParameter;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMObject;
import persistence.PersistentMessage;
import persistence.PersistentOperation;

public abstract class AbstractTest extends TestingBase {

	protected PersistentMAtomicType mat1;
	protected PersistentMAtomicType mat2;
	protected PersistentMAtomicType mat3;
	protected PersistentMAtomicType mat4;
	protected PersistentMAtomicType mat5;
	protected PersistentMAtomicType mat6;

	@InjectSingleton(MEmptyTypeConjunction.class)
	protected PersistentMEmptyTypeConjunction mptEmpty;
	protected PersistentMAbstractTypeConjunction mptSingle1;
	protected PersistentMAbstractTypeConjunction mptSingle2;
	protected PersistentMAbstractTypeConjunction mptSingle3;
	protected PersistentMAbstractTypeConjunction mptSingle4;
	protected PersistentMAbstractTypeConjunction mptSingle5;
	protected PersistentMAbstractTypeConjunction mptMultiple2And4;
	protected PersistentMAbstractTypeConjunction mptMultiple4And2;
	protected PersistentMAbstractTypeConjunction mptMultiple5And6;
	protected PersistentMAbstractTypeConjunction mptMultiple4And5;

	@InjectSingleton(MEmptyTypeDisjunction.class)
	protected PersistentMEmptyTypeDisjunction mstEmpty;
	protected PersistentMAbstractTypeDisjunction mstSingle1;
	protected PersistentMAbstractTypeDisjunction mstSingle2;
	protected PersistentMAbstractTypeDisjunction mstSingle3;
	protected PersistentMAbstractTypeDisjunction mstSingle4;
	protected PersistentMAbstractTypeDisjunction mstSingle5;
	protected PersistentMAbstractTypeDisjunction mstMultiple2And4;
	protected PersistentMAbstractTypeDisjunction mstMultiple4And2;
	protected PersistentMAbstractTypeDisjunction mstMultiple4And5;
	protected PersistentMAbstractTypeDisjunction mstMultiple5And6;
	protected PersistentMAbstractTypeDisjunction mstMultiple2And4And5;

	protected PersistentMObject mao1;
	protected PersistentMObject mao4;
	protected PersistentMObject mao5;
	protected PersistentMObject mao6;
	protected PersistentMObject msoEmpty;
	protected PersistentMObject mpo4And5;

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

	@Before
	public void setup() throws PersistenceException, SQLException, IOException {
		try {
			this.init();
		} catch (CycleException e) {
			e.printStackTrace();
		} catch (ConsistencyException e) {
			e.printStackTrace();
		}
	}

	private void init() throws CycleException, PersistenceException, ConsistencyException {

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
		/*
		 * mptEmpty = MEmptyTypeConjunction.getTheMEmptyTypeConjunction(); mptSingle1 =
		 * MMixedConjunction.createMMixedConjunction(); mptSingle2 = MMixedConjunction.createMMixedConjunction();
		 * mptSingle3 = MMixedConjunction.createMMixedConjunction(); mptSingle4 =
		 * MMixedConjunction.createMMixedConjunction(); mptSingle5 = MMixedConjunction.createMMixedConjunction();
		 * mptMultiple2And4 = MMixedConjunction.createMMixedConjunction(); mptMultiple4And2 =
		 * MMixedConjunction.createMMixedConjunction(); mptMultiple5And6 = MMixedConjunction.createMMixedConjunction();
		 * mptMultiple4And5 = MMixedConjunction.createMMixedConjunction();
		 */
		mptSingle1 = TestingBase.transNormConj(mat1);
		mptSingle2 = TestingBase.transNormConj(mat2);
		mptSingle3 = TestingBase.transNormConj(mat3);
		mptSingle4 = TestingBase.transNormConj(mat4);
		mptSingle5 = TestingBase.transNormConj(mat5);

		mptMultiple2And4 = TestingBase.transNormConj(mat2, mat4);
		mptMultiple4And2 = TestingBase.transNormConj(mat4, mat2);
		mptMultiple5And6 = TestingBase.transNormConj(mat5, mat6);
		mptMultiple4And5 = TestingBase.transNormConj(mat4, mat5);

		// SumType
		/*
		 * mstEmpty = MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction(); mstSingle1 = MSumType.createMSumType();
		 * mstSingle2 = MSumType.createMSumType(); mstSingle3 = MSumType.createMSumType(); mstSingle4 =
		 * MSumType.createMSumType(); mstSingle5 = MSumType.createMSumType(); mstMultiple2And4 =
		 * MSumType.createMSumType(); mstMultiple4And2 = MSumType.createMSumType(); mstMultiple4And5 =
		 * MSumType.createMSumType(); mstMultiple5And6 = MSumType.createMSumType(); mstMultiple2And4And5 =
		 * MSumType.createMSumType();
		 */
		mstSingle1 = TestingBase.transNormDisj(mat1);
		mstSingle2 = TestingBase.transNormDisj(mat2);
		mstSingle3 = TestingBase.transNormDisj(mat3);
		mstSingle4 = TestingBase.transNormDisj(mat4);
		mstSingle5 = TestingBase.transNormDisj(mat5);

		mstMultiple2And4 = TestingBase.transNormDisj(mat2, mat4);
		mstMultiple4And2 = TestingBase.transNormDisj(mat4, mat2);
		mstMultiple4And5 = TestingBase.transNormDisj(mat4, mat5);
		mstMultiple5And6 = TestingBase.transNormDisj(mat5, mat6);
		mstMultiple2And4And5 = TestingBase.transNormDisj(mat2, mat4, mat5);

		mao1 = MObject.createMObject();
		mao1.addType(mat1);
		mao4 = MObject.createMObject();
		mao4.addType(mat4);
		mao5 = MObject.createMObject();
		mao5.addType(mat5);
		mao6 = MObject.createMObject();
		mao6.addType(mat6);

		mpo4And5 = MObject.createMObject();
		mpo4And5.addType(mat4);
		mpo4And5.addType(mat5);

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
		apList.add(ap1);
		apList.add(ap2);
		apList.add(ap3);
	}
}
