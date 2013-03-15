package viewClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;

import view.AbsQuantityView;
import view.AbsUnitTypeView;
import view.AbsUnitView;
import view.AccountManagerView;
import view.AccountTypeManagerView;
import view.AccountView;
import view.AspectManagerView;
import view.AssociationManagerView;
import view.AssociationView;
import view.ConsistencyException;
import view.CycleException;
import view.DeletedException;
import view.DoubleDefinitionException;
import view.EmptyTypeException;
import view.EnumerationManagerView;
import view.ExponentMatchingException;
import view.FormalParameterView;
import view.HierarchyView;
import view.LinkManagerView;
import view.LinkView;
import view.MAccountTypeView;
import view.MAspectView;
import view.MAtomicTypeView;
import view.MComplexTypeView;
import view.MEnumValueView;
import view.MEnumView;
import view.MMeasurementTypeView;
import view.MObjectView;
import view.MObservationTypeView;
import view.MObservationView;
import view.MTypeView;
import view.MeasurementTypeManagerView;
import view.MeasurementView;
import view.ModelException;
import view.NameSchemeManagerView;
import view.NameSchemeView;
import view.NameView;
import view.NotAvailableException;
import view.NotComputableException;
import view.NotFoundException;
import view.ObsTypeManagerView;
import view.OperationManagerView;
import view.OperationView;
import view.PatternNotMatchException;
import view.QuantityManagerView;
import view.QuantityView;
import view.RestrictionException;
import view.ServerView;
import view.TypeManagerView;
import view.UnitTypeManagerView;
import view.UnitTypeView;
import view.UnitView;
import view.UserException;
import view.WrongSubTypeAspectException;

public class ServerConnection extends ConnectionMaster {

	public ServerConnection(final String url, final ExceptionAndEventHandler handler, final ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServerView getServerView() {
		return (ServerView) super.getServer();
	}

	public synchronized java.util.Vector<?> a_Path_In_CreateHierarchy() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "a_Path_In_CreateHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> child_Path_In_AddSubAccountType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "child_Path_In_AddSubAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> child_Path_In_AddSubAccount() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "child_Path_In_AddSubAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> containees_Path_In_CreateTypeConjunction() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "containees_Path_In_CreateTypeConjunction", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> containees_Path_In_CreateTypeDisjunction() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "containees_Path_In_CreateTypeDisjunction", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> defaultUnit_Path_In_SetDefaultUnit() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "defaultUnit_Path_In_SetDefaultUnit", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> dividend_Path_In_Div() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "dividend_Path_In_Div", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> divisor_Path_In_Div() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "divisor_Path_In_Div", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> enumType_Path_In_CreateObsType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "enumType_Path_In_CreateObsType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> enumValue_Path_In_CreateObservation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "enumValue_Path_In_CreateObservation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> factor1_Path_In_Mul() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "factor1_Path_In_Mul", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> factor2_Path_In_Mul() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "factor2_Path_In_Mul", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> fp_Path_In_AddFp() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fp_Path_In_AddFp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> fp_Path_In_CreateOperation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fp_Path_In_CreateOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> fp_Path_In_CreateStaticOp() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fp_Path_In_CreateStaticOp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> fp_Path_In_CreateVoidOperation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fp_Path_In_CreateVoidOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> measurementType_Path_In_CreateEntry() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "measurementType_Path_In_CreateEntry", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> minuend_Path_In_Sub() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "minuend_Path_In_Sub", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> newType_Path_In_AddType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "newType_Path_In_AddType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> newType_Path_In_ReplaceType(final MAtomicTypeView oldType) throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) oldType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "newType_Path_In_ReplaceType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> object_Path_In_CreateAccount() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "object_Path_In_CreateAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> object_Path_In_CreateEntry() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "object_Path_In_CreateEntry", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> ofType_Path_In_CreateFp() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "ofType_Path_In_CreateFp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> oldType_Path_In_RemoveType(final MObjectView object) throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "oldType_Path_In_RemoveType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> oldType_Path_In_ReplaceType(final MObjectView object) throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "oldType_Path_In_ReplaceType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> otherTypes_Path_In_CreateMObject() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "otherTypes_Path_In_CreateMObject", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> quantity_Path_In_CreateEntry() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "quantity_Path_In_CreateEntry", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> referenceUnitType_Path_In_AddReferenceType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "referenceUnitType_Path_In_AddReferenceType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> referenceUnit_Path_In_AddReference() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "referenceUnit_Path_In_AddReference", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> scheme_Path_In_AssignNameScheme() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "scheme_Path_In_AssignNameScheme", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> scheme_Path_In_AssignName(final MObjectView object) throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "scheme_Path_In_AssignName", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> source_Path_In_CreateAssociation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "source_Path_In_CreateAssociation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> source_Path_In_CreateLink() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "source_Path_In_CreateLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> source_Path_In_CreateOperation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "source_Path_In_CreateOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> source_Path_In_CreateVoidOperation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "source_Path_In_CreateVoidOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> subtrahend_Path_In_Sub() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "subtrahend_Path_In_Sub", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> summand1_Path_In_Add() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "summand1_Path_In_Add", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> summand2_Path_In_Add() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "summand2_Path_In_Add", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> target_Path_In_CreateAssociation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "target_Path_In_CreateAssociation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> target_Path_In_CreateConstant() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "target_Path_In_CreateConstant", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> target_Path_In_CreateLink() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "target_Path_In_CreateLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> target_Path_In_CreateOperation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "target_Path_In_CreateOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> target_Path_In_CreateStaticOp() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "target_Path_In_CreateStaticOp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> theObsObject_Path_In_CreateObservation() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "theObsObject_Path_In_CreateObservation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> theType_Path_In_CreateObsType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "theType_Path_In_CreateObsType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> type_Path_In_CreateAccountType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "type_Path_In_CreateAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> type_Path_In_CreateAccount() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "type_Path_In_CreateAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> type_Path_In_CreateLink() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "type_Path_In_CreateLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> type_Path_In_CreateMObject() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "type_Path_In_CreateMObject", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> type_Path_In_CreateMeasurementType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "type_Path_In_CreateMeasurementType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> unitType_Path_In_CreateAccountType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "unitType_Path_In_CreateAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> unitType_Path_In_CreateMeasurementType() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "unitType_Path_In_CreateMeasurementType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> unit_Path_In_Convert() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "unit_Path_In_Convert", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized java.util.Vector<?> unit_Path_In_CreateQuantity() throws ModelException, UserException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			final Hashtable<?, ?> success = this.execute(this.connectionName, "unit_Path_In_CreateQuantity", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -228)
					throw ExponentMatchingException.fromHashtableToExponentMatchingException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -229)
					throw WrongSubTypeAspectException.fromHashtableToWrongSubTypeAspectException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -266)
					throw PatternNotMatchException.fromHashtableToPatternNotMatchException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -234)
					throw NotAvailableException.fromHashtableToNotAvailableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -280)
					throw EmptyTypeException.fromHashtableToEmptyTypeException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -282)
					throw NotFoundException.fromHashtableToNotFoundException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -237)
					throw RestrictionException.fromHashtableToRestrictionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				return view.objects.ViewProxi.getProxiVector((Vector<String>) success.get(common.RPCConstantsAndServices.ResultListFieldName),
						this.getHandler());
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addAssociation(final HierarchyView h, final AssociationView a) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) h).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) a).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addAssociation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addFp(final OperationView op, final FormalParameterView fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) op).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) fp).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addFp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addReferenceType(final AbsUnitTypeView unitType, final String name, final UnitTypeView referenceUnitType,
			final long exponent) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) unitType).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) referenceUnitType).createProxiInformation());
			parameters.add(new Long(exponent).toString());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addReferenceType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addReference(final AbsUnitView unit, final String name, final UnitView referenceUnit, final long exponent)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) unit).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) referenceUnit).createProxiInformation());
			parameters.add(new Long(exponent).toString());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addReference", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addSubAccountType(final MAccountTypeView parent, final MAccountTypeView child) throws ModelException, CycleException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) parent).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) child).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addSubAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addSubAccount(final AccountView parent, final AccountView child) throws ModelException, CycleException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) parent).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) child).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addSubAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -231)
					throw CycleException.fromHashtableToCycleException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addToHierarchy(final AssociationView association, final HierarchyView theHierarchy) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) association).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) theHierarchy).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addToHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void addType(final MObjectView object, final MAtomicTypeView newType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) newType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "addType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void add(final AbsQuantityView summand1, final AbsQuantityView summand2) throws ModelException, NotComputableException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) summand1).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) summand2).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "add", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	@SuppressWarnings("unchecked")
	public synchronized AbsQuantityView aggregateByStrategy(final AccountView account, final String strategy) throws ModelException,
			ConsistencyException, NotComputableException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) account).createProxiInformation());
			parameters.add(strategy);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "aggregateByStrategy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			} else {
				final java.util.Hashtable<String, Object> allResults = (java.util.Hashtable<String, Object>) success
						.get(common.RPCConstantsAndServices.ResultFieldName);
				view.objects.ViewProxi.resolveReferences(allResults, this.getHandler());
				final common.ProxiInformation proxiInformation = common.RPCConstantsAndServices.createProxiInformation((String) success
						.get(common.RPCConstantsAndServices.RootFieldName));
				final AbsQuantityView result = (AbsQuantityView) view.objects.ViewProxi.createProxi(proxiInformation, this.getHandler());
				if (result != null)
					((view.objects.ViewRoot) result).setToString(proxiInformation.getToString());
				final view.objects.ViewObject root = (view.objects.ViewObject) allResults.get(proxiInformation.getHashKey());
				if (root != null)
					((view.objects.ViewProxi) result).setObject(root);
				return result;
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void assignNameScheme(final MAtomicTypeView type, final NameSchemeView scheme) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) scheme).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "assignNameScheme", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void assignName(final MObjectView object, final NameView scheme, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) scheme).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "assignName", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void assignType(final NameSchemeView scheme, final MAtomicTypeView type) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) scheme).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "assignType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void changeAbstract(final MAtomicTypeView type, final String newAbstractType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(newAbstractType);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "changeAbstract", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void changeSingleton(final MAtomicTypeView type, final String newSingletonType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(newSingletonType);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "changeSingleton", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void changeUnitName(final AbsUnitView unit, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) unit).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "changeUnitName", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void changeUnitTypeName(final AbsUnitTypeView unitType, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) unitType).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "changeUnitTypeName", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void convert(final QuantityView quantity, final AbsUnitView unit) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) quantity).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) unit).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "convert", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAccountType(final AccountTypeManagerView accountTypeManager, final String name, final MTypeView type,
			final UnitTypeView unitType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) accountTypeManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) unitType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAccount(final AccountManagerView accountManager, final String name, final MAccountTypeView type,
			final MObjectView object) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) accountManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAspect(final AspectManagerView aspectManager, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) aspectManager).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAspect", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAssociation(final AssociationManagerView manager, final MTypeView source, final MTypeView target, final String name)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAssociation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAtomicRootType(final MAspectView aspect, final String typeName, final String singletonType,
			final String abstractType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) aspect).createProxiInformation());
			parameters.add(typeName);
			parameters.add(singletonType);
			parameters.add(abstractType);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAtomicRootType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createAtomicSubType(final MAtomicTypeView superType, final String typeName, final String singletonType,
			final String abstractType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) superType).createProxiInformation());
			parameters.add(typeName);
			parameters.add(singletonType);
			parameters.add(abstractType);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createAtomicSubType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createConstant(final OperationManagerView operationManager, final String name, final MTypeView target)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operationManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createConstant", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createEntry(final AccountView account, final MObjectView object, final MMeasurementTypeView measurementType,
			final QuantityView quantity) throws ModelException, ConsistencyException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) account).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) measurementType).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) quantity).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createEntry", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createEnumValue(final MEnumView type, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createEnumValue", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createEnum(final EnumerationManagerView enumManager, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) enumManager).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createEnum", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createFp(final OperationManagerView operationManager, final String name, final MTypeView ofType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operationManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) ofType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createFp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createHierarchy(final AssociationManagerView manager, final AssociationView a, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) a).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createHierarchy(final AssociationView a, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) a).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createLink(final LinkManagerView link, final AssociationView type, final MObjectView source, final MObjectView target)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) link).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createLink(final MObjectView source, final AssociationView type, final MObjectView target) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createMObject(final MAtomicTypeView type, final java.util.Vector<MAtomicTypeView> otherTypes) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			final java.util.Vector<String> otherTypesTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<MAtomicTypeView> otherTypesItrtr = otherTypes.iterator();
			while (otherTypesItrtr.hasNext()) {
				final MAtomicTypeView current = otherTypesItrtr.next();
				otherTypesTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(otherTypesTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createMObject", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createMeasurementType(final MeasurementTypeManagerView measurementTypeManager, final String name, final MTypeView type,
			final UnitTypeView unitType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) measurementTypeManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) unitType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createMeasurementType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createNameScheme(final NameSchemeManagerView manager, final String schemeName, final String regExp,
			final String isIterable) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			parameters.add(schemeName);
			parameters.add(regExp);
			parameters.add(isIterable);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createNameScheme", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createObsType(final ObsTypeManagerView obsTypeManager, final String name, final MEnumView enumType,
			final MTypeView theType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) obsTypeManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) enumType).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) theType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createObsType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createObservation(final MObservationTypeView theType, final String name, final MObjectView theObsObject,
			final MEnumValueView enumValue) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) theType).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) theObsObject).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) enumValue).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createObservation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createOperation(final MTypeView source, final MTypeView target, final String name,
			final java.util.Vector<FormalParameterView> fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			parameters.add(name);
			final java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
			while (fpItrtr.hasNext()) {
				final FormalParameterView current = fpItrtr.next();
				fpTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(fpTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createOperation(final OperationManagerView operationManager, final MTypeView source, final MTypeView target,
			final String name, final java.util.Vector<FormalParameterView> fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operationManager).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			parameters.add(name);
			final java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
			while (fpItrtr.hasNext()) {
				final FormalParameterView current = fpItrtr.next();
				fpTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(fpTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createQuantity(final QuantityManagerView manager, final AbsUnitView unit, final common.Fraction f) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) unit).createProxiInformation());
			parameters.add(f.toString());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createQuantity", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createStaticOp(final OperationManagerView operationManager, final String name, final MTypeView target,
			final java.util.Vector<FormalParameterView> fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operationManager).createProxiInformation());
			parameters.add(name);
			parameters.add(((view.objects.ViewProxi) target).createProxiInformation());
			final java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
			while (fpItrtr.hasNext()) {
				final FormalParameterView current = fpItrtr.next();
				fpTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(fpTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createStaticOp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createTypeConjunction(final TypeManagerView typeManager, final java.util.Vector<MTypeView> containees)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) typeManager).createProxiInformation());
			final java.util.Vector<String> containeesTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<MTypeView> containeesItrtr = containees.iterator();
			while (containeesItrtr.hasNext()) {
				final MTypeView current = containeesItrtr.next();
				containeesTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(containeesTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createTypeConjunction", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createTypeDisjunction(final TypeManagerView typeManager, final java.util.Vector<MTypeView> containees)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) typeManager).createProxiInformation());
			final java.util.Vector<String> containeesTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<MTypeView> containeesItrtr = containees.iterator();
			while (containeesItrtr.hasNext()) {
				final MTypeView current = containeesItrtr.next();
				containeesTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(containeesTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createTypeDisjunction", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createUnitType(final UnitTypeManagerView manager, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createUnitType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createUnit(final UnitTypeView type, final String name) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(name);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createUnit", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createVoidOperation(final MTypeView source, final String name, final java.util.Vector<FormalParameterView> fp)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(name);
			final java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
			while (fpItrtr.hasNext()) {
				final FormalParameterView current = fpItrtr.next();
				fpTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(fpTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createVoidOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void createVoidOperation(final OperationManagerView operationManager, final MTypeView source, final String name,
			final java.util.Vector<FormalParameterView> fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operationManager).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) source).createProxiInformation());
			parameters.add(name);
			final java.util.Vector<String> fpTrnsprt = new java.util.Vector<String>();
			final java.util.Iterator<FormalParameterView> fpItrtr = fp.iterator();
			while (fpItrtr.hasNext()) {
				final FormalParameterView current = fpItrtr.next();
				fpTrnsprt.add(((view.objects.ViewProxi) current).createProxiInformation());
			}
			parameters.add(fpTrnsprt);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "createVoidOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteAccountType(final MAccountTypeView accountType) throws ModelException, ConsistencyException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) accountType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteAccountType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteAccount(final AccountView account) throws ModelException, ConsistencyException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) account).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteAccount", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteAspect(final MAspectView aspect) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) aspect).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteAspect", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteAtomicType(final MAtomicTypeView type) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteAtomicType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteComplexType(final MComplexTypeView type) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteComplexType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteEntry(final MeasurementView measurement) throws ModelException, ConsistencyException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) measurement).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteEntry", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -323)
					throw DeletedException.fromHashtableToDeletedException((Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName),
							this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -230)
					throw ConsistencyException.fromHashtableToConsistencyException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteEnumValue(final MEnumValueView enumValue) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) enumValue).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteEnumValue", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteEnum(final MEnumView type) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteEnum", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteObject(final MObjectView object) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteObject", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteObsType(final MObservationTypeView theType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) theType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteObsType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void deleteObservation(final MObservationView observation) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) observation).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "deleteObservation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void div(final AbsQuantityView dividend, final AbsQuantityView divisor) throws ModelException, NotComputableException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) dividend).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) divisor).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "div", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void fetchScalarType(final UnitTypeManagerView manager) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fetchScalarType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void fetchScalar(final UnitTypeManagerView manager) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) manager).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "fetchScalar", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void mul(final AbsQuantityView factor1, final AbsQuantityView factor2) throws ModelException, DoubleDefinitionException,
			NotComputableException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) factor1).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) factor2).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "mul", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -235)
					throw DoubleDefinitionException.fromHashtableToDoubleDefinitionException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeAssociation(final AssociationView a) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) a).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeAssociation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeFpFromOp(final OperationView operation, final FormalParameterView fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) operation).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) fp).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeFpFromOp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeFp(final FormalParameterView fp) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) fp).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeFp", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeFromHierarchy(final HierarchyView h, final AssociationView a) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) h).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) a).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeFromHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeHierarchy(final HierarchyView h) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) h).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeHierarchy", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeLink(final LinkView link) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) link).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeLink", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeOperation(final OperationView op) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) op).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeOperation", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void removeType(final MObjectView object, final MAtomicTypeView oldType) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) oldType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "removeType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void renameAspect(final MAspectView aspect, final String newName) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) aspect).createProxiInformation());
			parameters.add(newName);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "renameAspect", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void renameAtomicType(final MAtomicTypeView type, final String newName) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(newName);
			final Hashtable<?, ?> success = this.execute(this.connectionName, "renameAtomicType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void replaceType(final MObjectView object, final MAtomicTypeView oldType, final MAtomicTypeView newType)
			throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) object).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) oldType).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) newType).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "replaceType", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void setConversion(final UnitView unit, final common.Fraction factor, final common.Fraction constant) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) unit).createProxiInformation());
			parameters.add(factor.toString());
			parameters.add(constant.toString());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "setConversion", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void setDefaultUnit(final UnitTypeView type, final UnitView defaultUnit) throws ModelException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) type).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) defaultUnit).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "setDefaultUnit", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

	public synchronized void sub(final AbsQuantityView minuend, final AbsQuantityView subtrahend) throws ModelException, NotComputableException {
		try {
			final Vector<Object> parameters = new Vector<Object>();
			parameters.add(((view.objects.ViewProxi) minuend).createProxiInformation());
			parameters.add(((view.objects.ViewProxi) subtrahend).createProxiInformation());
			final Hashtable<?, ?> success = this.execute(this.connectionName, "sub", parameters);
			if (!((Boolean) success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()) {
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
					throw new ModelException((String) success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName),
							((Integer) success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
				if (((Integer) success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -285)
					throw NotComputableException.fromHashtableToNotComputableException(
							(Hashtable) success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
				throw new Error("Fatal error (unknown exception code:" + success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")");
			}
		} catch (final IOException ioe) {
			throw new ModelException(ioe.getMessage(), 0);
		} catch (final XmlRpcException xre) {
			throw new ModelException(xre.getMessage(), 0);
		}

	}

}
