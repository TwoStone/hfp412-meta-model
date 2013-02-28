package viewClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

import rGType.CharacterType;

import view.Anything;
import view.ModelException;
import expressions.RegularExpression;
import expressions.RegularExpressionHandler;

@SuppressWarnings("serial")
abstract public class DetailPanel extends JPanel {
		
	public static void setButtonToNeutral(JButton button) {
		button.setBackground(Wizard.Yellow);
		button.setForeground(Wizard.NeutralForeground);
		button.setText(Wizard.NeutralText);
		button.setIcon(Wizard.NeutralIcon);
		button.setEnabled(false);
	}
	public static void setButtonToOK(JButton button) {
		button.setBackground(Wizard.Green);
		button.setForeground(Wizard.OKForeground);
		button.setText(Wizard.OKText);
		button.setIcon(Wizard.OKIcon);
		button.setEnabled(true);
	}
	public static void setButtonToNotOk(JButton button) {
		button.setBackground(Wizard.Red);
		button.setForeground(Wizard.NotOKForeground);
		button.setText(Wizard.NotOKText);
		button.setIcon(Wizard.NotOKIcon);
		button.setEnabled(false);
	}
		
	protected Anything anything;
	private ExceptionAndEventHandler exceptionAndEventHandler;
	
	protected DetailPanel(ExceptionAndEventHandler exceptionHandler){
		super();
		this.exceptionAndEventHandler = exceptionHandler;
	}
	abstract public void setAnything(Anything anything);
	protected Anything getAnything(){
		return this.anything;
	}
	protected ExceptionAndEventHandler getExceptionAndEventhandler(){
		return this.exceptionAndEventHandler;
	}
}

@SuppressWarnings("serial")
abstract class BaseTypePanel extends JPanel {

	public String toString(java.util.Date value, boolean doWithMillies) {
		return  view.objects.ViewRoot.toString(value, doWithMillies);
	}

	static final int Neutral = 0;
	protected static final int OK = 1;
	static final int NotOK = 2;

	private DefaultDetailPanel master;
	
	protected BaseTypePanel(DefaultDetailPanel master, String name, String value){
		this.master = master;
		this.setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
		this.add(this.getUpdateButton());
		this.add(new JLabel("  "));
		this.add(getLabel());
		getLabel().setText(name);
		this.add(new JLabel(" :  "));
		this.add(getValueTextField());
		this.setValue(value);
		this.setMaximumSize(new Dimension(Wizard.BaseTypePanelStandardWidth,Wizard.BaseTypePanelStandardHeight));
	}
	private JButton updateButton;
	private JButton getUpdateButton() {
		if (this.updateButton == null){
			this.updateButton = new JButton();
			this.updateButton.setText("    ");
			this.setStatus(Neutral);
			this.updateButton.setMargin(new Insets(0,0,0,0));
			this.updateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (isUpdatable())update();
				}
			});
		}
		return this.updateButton;
	}
	public String getValue(){
		return this.getValueTextField().getText();
	}
	
	protected void setOK(boolean ok){
		if (ok){
			this.setStatus(OK);
		}else{
			this.setStatus(NotOK);
		}
	}
	private int status = BaseTypePanel.Neutral;
	protected void setStatus(int status) {
		this.status = status;
		if (this.status == Neutral)DetailPanel.setButtonToNeutral(this.getUpdateButton());
		if (this.status == OK)DetailPanel.setButtonToOK(this.getUpdateButton());
		if (this.status == NotOK)DetailPanel.setButtonToNotOk(this.getUpdateButton());
		this.master.check(); 
	}
	protected void setValue(String value){
		this.getValueTextField().setText(value);
		this.getValueTextField().setCaretPosition(0);
	}
	private JTextField valueTextField;
	protected JTextField getValueTextField() {
		if (valueTextField == null){
			this.valueTextField = new JTextField();
			this.valueTextField.setHorizontalAlignment(JTextField.LEFT);
			this.valueTextField.setEditable(false);
			this.valueTextField.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					if (isUpdatable()) {
						try {
							setOK(updater.check(getValue()));
						} catch (view.ModelException me) {
							getValueTextField().setText(me.getMessage());
						}
					}
				}
				public void keyTyped(KeyEvent e) {}
			});
		}
		return this.valueTextField;
	}
	private JLabel nameLabel;
	private Updater updater;
	protected JLabel getLabel() {
		if (nameLabel ==  null){
			nameLabel = new JLabel();
		}
		return nameLabel;
	}
	protected DefaultDetailPanel getMaster(){
		return this.master;
	}
	protected void registerUpdater(Updater updater) {
		this.updater = updater;
		this.setUpdatable();
		this.getValueTextField().setText(updater.format(this.getValueTextField().getText()));
	}
	protected void setUpdatable() {
		this.getValueTextField().setEditable(true);
	}
	protected boolean isUpdatable(){
		return this.updater != null;
	}
	protected boolean isReadyForUpdate(){
		return this.isUpdatable()  && this.getUpdateButton().isEnabled();
	}
	public void updateIfReady() {
		if (this.isReadyForUpdate()) this.update();
	}
	private void update() {
		try {
			updater.update(this.getValue());
			setStatus(Neutral);
		} catch (view.ModelException ex) {
			getValueTextField().setText(ex.getMessage());
			setStatus(NotOK);
		}	
	}
	public int getStatus() {
		return this.status;
	}
}

@SuppressWarnings("serial")
class IntegerPanel extends BaseTypePanel {
	protected IntegerPanel(DefaultDetailPanel master, String name, long value) {
		super(master, name, new Long(value).toString());
	}
}
@SuppressWarnings("serial")
class FractionPanel extends BaseTypePanel {
	protected FractionPanel(DefaultDetailPanel master, String name, common.Fraction value) {
		super(master, name, value.toString());
	}
}

@SuppressWarnings("serial")
class StringPanel extends BaseTypePanel {
	protected StringPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
	}
}
@SuppressWarnings("serial")
class RegularExpressionPanel extends BaseTypePanel {

	private RegularExpressionHandler handler;

	protected RegularExpressionPanel(DefaultDetailPanel master, String name, String value, RegularExpressionHandler handler) {
		super(master, name, value);
		this.handler = handler;
		this.getValueTextField().addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if (getValueTextField().isEditable() && e.isAltDown()) getMaster().switchToRegExprView(RegularExpressionPanel.this);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	protected boolean check() {
		return this.handler.check(this.getValue());
	}
	public RegularExpression<Character,rGType.CharacterType> getExpression() {
		return handler.getRegExpr();
	}
}

@SuppressWarnings("serial")
class TextPanel extends BaseTypePanel {
	private String value;
	protected TextPanel(DefaultDetailPanel master, String name, String value) {
		super(master, name, value);
		this.value = value;
		this.getValueTextField().addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 || e.isAltDown()) getMaster().switchToTextView(TextPanel.this);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		this.getValueTextField().setToolTipText(Wizard.TextFieldToolTipText);
	}
	public String getValue(){
		return this.value;
	}
	protected void setValue(String value){
		this.value = value;
		boolean tooLong = value.length() > Wizard.TextPreviewLength;
		this.getValueTextField().setText(value.substring(0, tooLong ? Wizard.TextPreviewLength : value.length()) + (tooLong ? ".....":""));
		this.getValueTextField().setCaretPosition(0);
	}
	protected void setUpdatable() {
		getValueTextField().setBackground(Color.WHITE);
	}

}
@SuppressWarnings("serial")
class DatePanel extends BaseTypePanel {
	protected DatePanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super(master, name, "");
		this.getValueTextField().setText(this.toString(value, false));
	}
}
@SuppressWarnings("serial")
class TimestampPanel extends BaseTypePanel {
	protected TimestampPanel(DefaultDetailPanel master, String name, java.util.Date value) {
		super(master, name, "");
		this.getValueTextField().setText(this.toString(value, true));
	}
}
interface CompleteUpdater {
	void update() throws view.ModelException;
}

interface Updater {
	void update(String text) throws view.ModelException;
	String format(String text);
	boolean check(String text) throws view.ModelException;
}
abstract class StandardUpdater implements Updater {
	public String format(String text){
		return text;
	}	
}
abstract class UpdaterForInteger extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			Long.parseLong(text);
			return true;
		}catch (NumberFormatException nfe){
			return false;
		}
	}
}
abstract class UpdaterForString extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		return true;
	}
}
abstract class UpdaterForText extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		return true;
	}
}
abstract class UpdaterForDate extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			new java.text.SimpleDateFormat(view.objects.ViewRoot.DATEFORMAT).parse(text);
			return true;
		} catch (java.text.ParseException pe){
			return false;
		}
	}
}
abstract class UpdaterForTimeStamp extends StandardUpdater {
	public boolean check(String text) throws view.ModelException{
		try {
			new java.text.SimpleDateFormat(view.objects.ViewRoot.TIMESTAMPFORMAT).parse(text);
			return true;
		} catch (java.text.ParseException pe){
			return false;
		}
	}
}

@SuppressWarnings("serial")
abstract class DefaultDetailPanel extends DetailPanel {

	public static DetailPanel getStandardDetailPanel(Anything object, final ExceptionAndEventHandler handler) throws view.ModelException {
		DetailPanelFactory factory = new DetailPanelFactory(handler);
		object.accept(factory);
		return factory.result;
	}
	
	public void check() {
		boolean somethingUpdatable = false;
		this.setStatus(BaseTypePanel.Neutral);
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			if (current.getStatus() == BaseTypePanel.NotOK){
				this.setStatus(BaseTypePanel.NotOK);
				return;
			}
			if (current.getStatus() == BaseTypePanel.OK){
				somethingUpdatable = true;
			}
		}
		if (somethingUpdatable) this.setStatus(BaseTypePanel.OK);
	}

	Hashtable<String, BaseTypePanel> panels;
	private CompleteUpdater completeUpdater;

	protected DefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
		super(exceptionHandler);
		this.panels = new Hashtable<String, BaseTypePanel>();
		this.setLayout(new BorderLayout());
		this.add(this.getMainPane(),BorderLayout.CENTER);
		this.setAnything(anything);
	}
	
	protected void registerUpdater(String fieldName, Updater updater){
		BaseTypePanel panel = this.panels.get(fieldName);
		if (panel != null) panel.registerUpdater(updater);
	}
	protected void registerCompleteUpdater(CompleteUpdater completeUpdater){
		this.completeUpdater = completeUpdater;
	}
	abstract protected void addFields();
	
	public BaseTypePanel getPanel(String key){
		return this.panels.get(key);
	}
	public void switchBackFromTextView (boolean update){
		this.getMainPane().remove(this.getTextPane());
		this.getMainPane().add(this.getMainScrollPane(),BorderLayout.CENTER);
		if (update){
			this.currentTextPanel.setValue(this.getTextView().getText());
			this.currentTextPanel.setStatus(BaseTypePanel.OK);
		}
		this.getMainPane().invalidate();
		this.getMainScrollPane().invalidate();
		this.updateUI();
	}
	private TextPanel currentTextPanel = null;
	public void switchToTextView (TextPanel panel){
		this.currentTextPanel = panel;
		this.getMainPane().remove(this.getMainScrollPane());
		this.getMainPane().add(this.getTextPane(),BorderLayout.CENTER);
		this.getTextView().setText(panel.getValue());
		this.getTextView().setEditable(currentTextPanel.isUpdatable());
		this.getTextView().setCaretPosition(0);
		this.getTextPaneTitleBorder().setTitle(panel.getLabel().getText());
		this.getMainPane().invalidate();
		this.getTextScrollPane().invalidate();
		this.getTextView().invalidate();
		this.updateUI();
		this.getTextView().grabFocus();
	}
	private RegularExpressionPanel currentRegExpPanel = null;
	public void switchToRegExprView(RegularExpressionPanel panel) {
		this.currentRegExpPanel = panel;
		this.getMainPane().remove(this.getMainScrollPane());
		this.getMainPane().add(this.getRegExprComfortPanel(panel.getExpression(),panel.getLabel().getText(),panel.getValue()),BorderLayout.CENTER);
		this.getMainPane().invalidate();
		this.regExprComfortPanel.invalidate();
		this.updateUI();
		this.currentRegExpPanel.getValueTextField().grabFocus();
	}
	private JPanel regExprComfortPanel = null;
	private JPanel getRegExprComfortPanel(RegularExpression<Character,CharacterType> expression, String name,String value) {
		if (this.regExprComfortPanel == null){
			this.regExprComfortPanel = new JPanel();
			this.regExprComfortPanel.setLayout(new BorderLayout());
			this.regExprComfortPanel.add(this.getRegExprComfortToolBar(), BorderLayout.SOUTH);
		}else{
			this.regExprComfortPanel.remove(this.regExprPane);
		}
		this.regExprComfortPanel.updateUI();
		this.getRegExprPane(expression,name,value);
		this.regExprComfortPanel.add(regExprPane,BorderLayout.CENTER);
		return regExprComfortPanel;
	}
	private JToolBar regExprComfortToolBar = null;
	private JToolBar getRegExprComfortToolBar() {
		if (this.regExprComfortToolBar == null){
			this.regExprComfortToolBar = new JToolBar();
			this.regExprComfortToolBar.add(getRegExpOkButton());
			this.regExprComfortToolBar.add(getRegExpCancelButton());
		}
		return regExprComfortToolBar;
	}
	private JButton regExpOkButton = null;
	private JButton getRegExpOkButton() {
		if (this.regExpOkButton == null){
			this.regExpOkButton = new JButton();
			this.regExpOkButton.setText(Wizard.UpdateButtonText);
			this.regExpOkButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromRegExpView(true);
				}
			});
		}
		return regExpOkButton;
	}
	public void switchBackFromRegExpView (boolean update){
		this.getMainPane().remove(this.regExprComfortPanel);
		this.getMainPane().add(this.getMainScrollPane(),BorderLayout.CENTER);
		if (update){
			String value = this.regExprPane.getRegExprInput().getText();
			this.currentRegExpPanel.setValue(value);
			this.currentRegExpPanel.setOK(this.currentRegExpPanel.check());
		}
		this.getMainPane().invalidate();
		this.getMainScrollPane().invalidate();
		this.updateUI();
	}

	private JButton regExpCancelButton = null;
	private JButton getRegExpCancelButton() {
		if (this.regExpCancelButton == null){
			this.regExpCancelButton = new JButton();
			this.regExpCancelButton.setText(Wizard.CancelButtonText);
			this.regExpCancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromRegExpView(false);
				}
			});
		}
		return regExpCancelButton;
	}

	private view.RegExprPanel regExprPane = null;
	private view.RegExprPanel getRegExprPane(RegularExpression<Character,CharacterType> expression, String name, String value) {
		 this.regExprPane = new view.RegExprPanel(expression,name);
		 this.regExprPane.getRegExprInput().setText(value);
		 return regExprPane;
	}

	private JPanel mainPanel = null;
	private JPanel getMainPane() {
		if (mainPanel == null){
			this.mainPanel = new JPanel();
			this.mainPanel.setLayout(new BorderLayout());
			this.mainPanel.add(this.getMainScrollPane(),BorderLayout.CENTER);
		}
		return mainPanel;
	}
	private JPanel mainScrollPane;
	private JPanel getMainScrollPane(){
		if (this.mainScrollPane == null){
			this.mainScrollPane = new JPanel();
			this.mainScrollPane.setLayout(new BorderLayout());
			this.mainScrollPane.add(this.getDetailScrollPane(),BorderLayout.CENTER);
			this.mainScrollPane.add(this.getMajorToolBar(),BorderLayout.SOUTH);
		}
		return this.mainScrollPane;
	}
	private JToolBar majorToolBar;
	private JToolBar getMajorToolBar(){
		if (this.majorToolBar == null){
			this.majorToolBar = new JToolBar();
			this.majorToolBar.add(this.getUpdateAllButton());
		}
		return this.majorToolBar;
	}
	private JButton updateAllButton;
	private JButton getUpdateAllButton(){
		if (this.updateAllButton == null){
			this.updateAllButton = new JButton();
			this.updateAllButton.setText(Wizard.UpdateText);
			this.updateAllButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					updateAll();
				}
			});
			this.setStatus(BaseTypePanel.Neutral);
		}
		return this.updateAllButton;
	}
	protected void updateAll() {
		if (this.hasCompleteUpdater()){
			try {
				this.completeUpdater.update();
				this.resetDetails(true, "");
			} catch (ModelException e) {
				this.resetDetails(false, e.getMessage());
			}
		}
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			current.updateIfReady();	
		}
		this.check();
	}

	private void resetDetails(boolean withoutErrors, String message) {
		java.util.Iterator<BaseTypePanel> panelIterator = this.panels.values().iterator();
		while (panelIterator.hasNext()){
			BaseTypePanel current = panelIterator.next();
			if (current.isReadyForUpdate()){
				if(withoutErrors){
					current.setStatus(BaseTypePanel.Neutral);
				}else {
					current.setValue(message);
					current.setStatus(BaseTypePanel.NotOK);
				}
			}
		}
		this.check();
	}

	private boolean hasCompleteUpdater() {
		return this.completeUpdater != null;
	}

	private void setStatus(int status) {
		if (status == BaseTypePanel.Neutral)DetailPanel.setButtonToNeutral(this.getUpdateAllButton());
		if (status == BaseTypePanel.OK)DetailPanel.setButtonToOK(this.getUpdateAllButton());
		if (status == BaseTypePanel.NotOK)DetailPanel.setButtonToNotOk(this.getUpdateAllButton());
	}


	private JScrollPane detailScrollPane = null;
	private JScrollPane getDetailScrollPane() {
		if (detailScrollPane == null){
			this.detailScrollPane = new JScrollPane();
			this.detailScrollPane.setViewportView(this.getScrollablePane());
		}
		return detailScrollPane;
	}
	private JPanel textPane = null;
	private JPanel getTextPane(){
		if (this.textPane == null){
			this.textPane  = new JPanel();
			this.textPane.setLayout(new BorderLayout());
			this.textPane.setBorder(this.getTextPaneTitleBorder());
			this.textPane.add(this.getTextScrollPane(),BorderLayout.CENTER);
			this.textPane.add(this.getTextToolBar(),BorderLayout.SOUTH);
		}
		return this.textPane;
	}
	private TitledBorder textPaneTitle;
	private TitledBorder getTextPaneTitleBorder(){
		if ( this.textPaneTitle == null){
			this.textPaneTitle = new TitledBorder("");
		}
		return this.textPaneTitle;
	}
	private JToolBar textToolBar;
	private JToolBar getTextToolBar() {
		if (textToolBar == null){
			this.textToolBar = new JToolBar();
			this.textToolBar.add(this.getSwitchBackCancelButton());
			this.textToolBar.add(this.getSwitchBackUpdateButton());
		}
		return this.textToolBar;
	}
	private JButton switchBackUpdateButton;
	private JButton getSwitchBackUpdateButton() {
		if (this.switchBackUpdateButton == null){
			this.switchBackUpdateButton = new JButton();
			this.switchBackUpdateButton.setText(Wizard.UpdateButtonText);
			this.switchBackUpdateButton.setEnabled(false);
			this.switchBackUpdateButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromTextView(true);
				}
			});
		}
		return this.switchBackUpdateButton;
	}
	private JButton switchBackCancelButton;
	private JButton getSwitchBackCancelButton() {
		if (this.switchBackCancelButton == null){
			this.switchBackCancelButton = new JButton();
			this.switchBackCancelButton.setText(Wizard.CancelButtonText);
			this.switchBackCancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					switchBackFromTextView(false);
				}
			});
		}
		return this.switchBackCancelButton;
	}

	private JScrollPane textScrollPane;
	private JScrollPane getTextScrollPane() {
		if (this.textScrollPane == null){
			this.textScrollPane = new JScrollPane();
			this.textScrollPane.setViewportView(this.getTextView());
		}
		return this.textScrollPane;
	}

	private JTextArea textView = null;
	private JTextArea getTextView() {
		if (this.textView == null){
			this.textView = new JTextArea();
			this.textView.setLineWrap(true);
			this.textView.setWrapStyleWord(true);
			this.textView.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {
					getSwitchBackUpdateButton().setEnabled(getTextView().isEditable());
				}
				public void keyTyped(KeyEvent e) {}
			});
		}
		return this.textView;
	}
	private JPanel scrollablePane = null;
	protected JPanel getScrollablePane() {
		if (scrollablePane == null){
			scrollablePane = new JPanel();
			BoxLayout layout = new javax.swing.BoxLayout(
					scrollablePane, javax.swing.BoxLayout.Y_AXIS);
			scrollablePane.setLayout(layout);
		}
		return scrollablePane;
	}
	public void setAnything(Anything anything) {
		this.anything = anything;
		((view.objects.ViewProxi)anything).expand();
		this.addFields();
	}
}


class DetailPanelFactory implements view.visitor.AnythingVisitor {
	protected DefaultDetailPanel result = null;
	private ExceptionAndEventHandler handler;
	public DetailPanelFactory(ExceptionAndEventHandler handler) {
		this.handler = handler;
	}
    public void handleMinStrategy(view.MinStrategyView object){
        result = new MinStrategyDefaultDetailPanel(handler, object);
    }
    public void handleNameSchemeInstance(view.NameSchemeInstanceView object){
        result = new NameSchemeInstanceDefaultDetailPanel(handler, object);
    }
    public void handleCompoundQuantity(view.CompoundQuantityView object){
        result = new CompoundQuantityDefaultDetailPanel(handler, object);
    }
    public void handleServer(view.ServerView object){
        result = new ServerDefaultDetailPanel(handler, object);
    }
    public void handleNameScheme(view.NameSchemeView object){
        result = new NameSchemeDefaultDetailPanel(handler, object);
    }
    public void handleMAtomicType(view.MAtomicTypeView object){
        result = new MAtomicTypeDefaultDetailPanel(handler, object);
    }
    public void handleMEmptyTypeDisjunction(view.MEmptyTypeDisjunctionView object){
        result = new MEmptyTypeDisjunctionDefaultDetailPanel(handler, object);
    }
    public void handleCompUnitType(view.CompUnitTypeView object){
        result = new CompUnitTypeDefaultDetailPanel(handler, object);
    }
    public void handleMeasurement(view.MeasurementView object){
        result = new MeasurementDefaultDetailPanel(handler, object);
    }
    public void handleAssociation(view.AssociationView object){
        result = new AssociationDefaultDetailPanel(handler, object);
    }
    public void handleFormalParameter(view.FormalParameterView object){
        result = new FormalParameterDefaultDetailPanel(handler, object);
    }
    public void handleOperationManager(view.OperationManagerView object){
        result = new OperationManagerDefaultDetailPanel(handler, object);
    }
    public void handleMMixedConjunction(view.MMixedConjunctionView object){
        result = new MMixedConjunctionDefaultDetailPanel(handler, object);
    }
    public void handleErrorDisplay(view.ErrorDisplayView object){
        result = new ErrorDisplayDefaultDetailPanel(handler, object);
    }
    public void handleUnit(view.UnitView object){
        result = new UnitDefaultDetailPanel(handler, object);
    }
    public void handleMMeasurementType(view.MMeasurementTypeView object){
        result = new MMeasurementTypeDefaultDetailPanel(handler, object);
    }
    public void handleAccountTypeManager(view.AccountTypeManagerView object){
        result = new AccountTypeManagerDefaultDetailPanel(handler, object);
    }
    public void handleMObject(view.MObjectView object){
        result = new MObjectDefaultDetailPanel(handler, object);
    }
    public void handleMEmptyTypeConjunction(view.MEmptyTypeConjunctionView object){
        result = new MEmptyTypeConjunctionDefaultDetailPanel(handler, object);
    }
    public void handleNameInstance(view.NameInstanceView object){
        result = new NameInstanceDefaultDetailPanel(handler, object);
    }
    public void handleMessage(view.MessageView object){
        result = new MessageDefaultDetailPanel(handler, object);
    }
    public void handleFunction(view.FunctionView object){
        result = new FunctionDefaultDetailPanel(handler, object);
    }
    public void handleAspectManager(view.AspectManagerView object){
        result = new AspectManagerDefaultDetailPanel(handler, object);
    }
    public void handleLink(view.LinkView object){
        result = new LinkDefaultDetailPanel(handler, object);
    }
    public void handleMAspect(view.MAspectView object){
        result = new MAspectDefaultDetailPanel(handler, object);
    }
    public void handleAccountManager(view.AccountManagerView object){
        result = new AccountManagerDefaultDetailPanel(handler, object);
    }
    public void handleCompUnit(view.CompUnitView object){
        result = new CompUnitDefaultDetailPanel(handler, object);
    }
    public void handleOperation(view.OperationView object){
        result = new OperationDefaultDetailPanel(handler, object);
    }
    public void handleCONCMModelItem(view.CONCMModelItemView object){
        result = new CONCMModelItemDefaultDetailPanel(handler, object);
    }
    public void handleQuantityManager(view.QuantityManagerView object){
        result = new QuantityManagerDefaultDetailPanel(handler, object);
    }
    public void handleNameSchemeManager(view.NameSchemeManagerView object){
        result = new NameSchemeManagerDefaultDetailPanel(handler, object);
    }
    public void handleAssociationManager(view.AssociationManagerView object){
        result = new AssociationManagerDefaultDetailPanel(handler, object);
    }
    public void handleAvgStrategy(view.AvgStrategyView object){
        result = new AvgStrategyDefaultDetailPanel(handler, object);
    }
    public void handleHierarchy(view.HierarchyView object){
        result = new HierarchyDefaultDetailPanel(handler, object);
    }
    public void handleMAccountType(view.MAccountTypeView object){
        result = new MAccountTypeDefaultDetailPanel(handler, object);
    }
    public void handleMMixedTypeDisjunction(view.MMixedTypeDisjunctionView object){
        result = new MMixedTypeDisjunctionDefaultDetailPanel(handler, object);
    }
    public void handleTypeManager(view.TypeManagerView object){
        result = new TypeManagerDefaultDetailPanel(handler, object);
    }
    public void handleMNonEmptyAtomicTypeConjunction(view.MNonEmptyAtomicTypeConjunctionView object){
        result = new MNonEmptyAtomicTypeConjunctionDefaultDetailPanel(handler, object);
    }
    public void handleMessageManager(view.MessageManagerView object){
        result = new MessageManagerDefaultDetailPanel(handler, object);
    }
    public void handleSumStrategy(view.SumStrategyView object){
        result = new SumStrategyDefaultDetailPanel(handler, object);
    }
    public void handleUnitTypeManager(view.UnitTypeManagerView object){
        result = new UnitTypeManagerDefaultDetailPanel(handler, object);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(view.MNonEmptyDisjunctiveNormalFormView object){
        result = new MNonEmptyDisjunctiveNormalFormDefaultDetailPanel(handler, object);
    }
    public void handleFractionManager(view.FractionManagerView object){
        result = new FractionManagerDefaultDetailPanel(handler, object);
    }
    public void handleConversion(view.ConversionView object){
        result = new ConversionDefaultDetailPanel(handler, object);
    }
    public void handleReference(view.ReferenceView object){
        result = new ReferenceDefaultDetailPanel(handler, object);
    }
    public void handleReferenceType(view.ReferenceTypeView object){
        result = new ReferenceTypeDefaultDetailPanel(handler, object);
    }
    public void handleMaxStrategy(view.MaxStrategyView object){
        result = new MaxStrategyDefaultDetailPanel(handler, object);
    }
    public void handleAccount(view.AccountView object){
        result = new AccountDefaultDetailPanel(handler, object);
    }
    public void handleUnitType(view.UnitTypeView object){
        result = new UnitTypeDefaultDetailPanel(handler, object);
    }
    public void handleMFalse(view.MFalseView object){
        result = new MFalseDefaultDetailPanel(handler, object);
    }
    public void handleMeasurementTypeManager(view.MeasurementTypeManagerView object){
        result = new MeasurementTypeManagerDefaultDetailPanel(handler, object);
    }
    public void handleLinkManager(view.LinkManagerView object){
        result = new LinkManagerDefaultDetailPanel(handler, object);
    }
    public void handleMTrue(view.MTrueView object){
        result = new MTrueDefaultDetailPanel(handler, object);
    }
    public void handleQuantity(view.QuantityView object){
        result = new QuantityDefaultDetailPanel(handler, object);
    }
    public void handleActualParameter(view.ActualParameterView object){
        result = new ActualParameterDefaultDetailPanel(handler, object);
    }
    public void handleName(view.NameView object){
        result = new NameDefaultDetailPanel(handler, object);
    }
    public void handleMSingletonObject(view.MSingletonObjectView object){
        result = new MSingletonObjectDefaultDetailPanel(handler, object);
    }
    public void handleFractionWrapper(view.FractionWrapperView object){
        result = new FractionWrapperDefaultDetailPanel(handler, object);
    }
    public void handleFunctionManager(view.FunctionManagerView object){
        result = new FunctionManagerDefaultDetailPanel(handler, object);
    }
    public void handleObjectManager(view.ObjectManagerView object){
        result = new ObjectManagerDefaultDetailPanel(handler, object);
    }

}



@SuppressWarnings("serial")
class MinStrategyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected MinStrategyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MinStrategyView getAnything(){
        return (view.MinStrategyView)this.anything;
    }
}

@SuppressWarnings("serial")
class NameSchemeInstanceDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String NameSchemeInstance$$name = "NameSchemeInstance$$name";
    protected static final String NameSchemeInstance$$type = "NameSchemeInstance$$type";
    
    protected NameSchemeInstanceDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(NameSchemeInstance$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.NameSchemeInstanceView getAnything(){
        return (view.NameSchemeInstanceView)this.anything;
    }
}

@SuppressWarnings("serial")
class CompoundQuantityDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String CompoundQuantity$$parts = "CompoundQuantity$$parts";
    
    protected CompoundQuantityDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.CompoundQuantityView getAnything(){
        return (view.CompoundQuantityView)this.anything;
    }
}

@SuppressWarnings("serial")
class ServerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Server$$aspectManager = "Server$$aspectManager";
    protected static final String Server$$typeManager = "Server$$typeManager";
    protected static final String Server$$quantityManager = "Server$$quantityManager";
    protected static final String Server$$unitTypeManager = "Server$$unitTypeManager";
    protected static final String Server$$fractionManager = "Server$$fractionManager";
    protected static final String Server$$measurementTypeManager = "Server$$measurementTypeManager";
    protected static final String Server$$accountTypeManager = "Server$$accountTypeManager";
    protected static final String Server$$accountManager = "Server$$accountManager";
    protected static final String Server$$objectManager = "Server$$objectManager";
    protected static final String Server$$nameSchemeManager = "Server$$nameSchemeManager";
    protected static final String Server$$associationManager = "Server$$associationManager";
    protected static final String Server$$operationManager = "Server$$operationManager";
    protected static final String Server$$messageManager = "Server$$messageManager";
    protected static final String Server$$linkManager = "Server$$linkManager";
    protected static final String Server$$user = "Server$$user";
    
    protected ServerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "user", this.getAnything().getUser());
            this.getScrollablePane().add(panel);
            this.panels.put(Server$$user, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ServerView getAnything(){
        return (view.ServerView)this.anything;
    }
}

@SuppressWarnings("serial")
class NameSchemeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String NameScheme$$regExpPattern = "NameScheme$$regExpPattern";
    protected static final String NameScheme$$name = "NameScheme$$name";
    protected static final String NameScheme$$isIterable = "NameScheme$$isIterable";
    protected static final String NameScheme$$names = "NameScheme$$names";
    
    protected NameSchemeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "regExpPattern", this.getAnything().getRegExpPattern());
            this.getScrollablePane().add(panel);
            this.panels.put(NameScheme$$regExpPattern, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(NameScheme$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.NameSchemeView getAnything(){
        return (view.NameSchemeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MAtomicTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MAtomicType$$name = "MAtomicType$$name";
    protected static final String MAtomicType$$singletonType = "MAtomicType$$singletonType";
    protected static final String MAtomicType$$abstractType = "MAtomicType$$abstractType";
    protected static final String MAtomicType$$subTypes = "MAtomicType$$subTypes";
    protected static final String MAtomicType$$possibleNames = "MAtomicType$$possibleNames";
    
    protected MAtomicTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(MAtomicType$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "singletonType", this.getAnything().getSingletonType());
            this.getScrollablePane().add(panel);
            this.panels.put(MAtomicType$$singletonType, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new StringPanel(this, "abstractType", this.getAnything().getAbstractType());
            this.getScrollablePane().add(panel);
            this.panels.put(MAtomicType$$abstractType, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.MAtomicTypeView getAnything(){
        return (view.MAtomicTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MEmptyTypeDisjunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    
    protected MEmptyTypeDisjunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MEmptyTypeDisjunctionView getAnything(){
        return (view.MEmptyTypeDisjunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class CompUnitTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnitType$$name = "AbsUnitType$$name";
    protected static final String CompUnitType$$refs = "CompUnitType$$refs";
    
    protected CompUnitTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsUnitType$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.CompUnitTypeView getAnything(){
        return (view.CompUnitTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MeasurementDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String QuantifObject$$object = "QuantifObject$$object";
    protected static final String Measurement$$type = "Measurement$$type";
    protected static final String Measurement$$quantity = "Measurement$$quantity";
    
    protected MeasurementDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MeasurementView getAnything(){
        return (view.MeasurementView)this.anything;
    }
}

@SuppressWarnings("serial")
class AssociationDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsOperation$$name = "AbsOperation$$name";
    protected static final String AbsOperation$$source = "AbsOperation$$source";
    protected static final String AbsOperation$$target = "AbsOperation$$target";
    protected static final String AbsOperation$$parameters = "AbsOperation$$parameters";
    protected static final String Association$$hierarchies = "Association$$hierarchies";
    
    protected AssociationDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsOperation$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.AssociationView getAnything(){
        return (view.AssociationView)this.anything;
    }
}

@SuppressWarnings("serial")
class FormalParameterDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String FormalParameter$$ofType = "FormalParameter$$ofType";
    protected static final String FormalParameter$$name = "FormalParameter$$name";
    
    protected FormalParameterDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(FormalParameter$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.FormalParameterView getAnything(){
        return (view.FormalParameterView)this.anything;
    }
}

@SuppressWarnings("serial")
class OperationManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String OperationManager$$operations = "OperationManager$$operations";
    protected static final String OperationManager$$staticOperations = "OperationManager$$staticOperations";
    protected static final String OperationManager$$constants = "OperationManager$$constants";
    protected static final String OperationManager$$formalParameters = "OperationManager$$formalParameters";
    
    protected OperationManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.OperationManagerView getAnything(){
        return (view.OperationManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class MMixedConjunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    protected static final String MMixedConjunction$$factors = "MMixedConjunction$$factors";
    
    protected MMixedConjunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MMixedConjunctionView getAnything(){
        return (view.MMixedConjunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class ErrorDisplayDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ErrorDisplay$$message = "ErrorDisplay$$message";
    
    protected ErrorDisplayDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "message", this.getAnything().getMessage());
            this.getScrollablePane().add(panel);
            this.panels.put(ErrorDisplay$$message, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ErrorDisplayView getAnything(){
        return (view.ErrorDisplayView)this.anything;
    }
}

@SuppressWarnings("serial")
class UnitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnit$$name = "AbsUnit$$name";
    protected static final String Unit$$myConversion = "Unit$$myConversion";
    
    protected UnitDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsUnit$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.UnitView getAnything(){
        return (view.UnitView)this.anything;
    }
}

@SuppressWarnings("serial")
class MMeasurementTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MQuantiObjectType$$type = "MQuantiObjectType$$type";
    protected static final String MQuantiObjectType$$unitType = "MQuantiObjectType$$unitType";
    
    protected MMeasurementTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MMeasurementTypeView getAnything(){
        return (view.MMeasurementTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountTypeManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AccountTypeManager$$accountTypes = "AccountTypeManager$$accountTypes";
    
    protected AccountTypeManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AccountTypeManagerView getAnything(){
        return (view.AccountTypeManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class MObjectDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbstractObject$$possibleNames = "AbstractObject$$possibleNames";
    protected static final String AbstractObject$$productType = "AbstractObject$$productType";
    protected static final String MObject$$types = "MObject$$types";
    protected static final String MObject$$linksFromMe = "MObject$$linksFromMe";
    protected static final String MObject$$linksToMe = "MObject$$linksToMe";
    protected static final String MObject$$names = "MObject$$names";
    
    protected MObjectDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MObjectView getAnything(){
        return (view.MObjectView)this.anything;
    }
}

@SuppressWarnings("serial")
class MEmptyTypeConjunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    
    protected MEmptyTypeConjunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MEmptyTypeConjunctionView getAnything(){
        return (view.MEmptyTypeConjunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class NameInstanceDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String NameInstance$$type = "NameInstance$$type";
    protected static final String NameInstance$$fromObject = "NameInstance$$fromObject";
    protected static final String NameInstance$$nameScheme = "NameInstance$$nameScheme";
    
    protected NameInstanceDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NameInstanceView getAnything(){
        return (view.NameInstanceView)this.anything;
    }
}

@SuppressWarnings("serial")
class MessageDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MessageOrLink$$source = "MessageOrLink$$source";
    protected static final String MessageOrLink$$target = "MessageOrLink$$target";
    protected static final String Message$$type = "Message$$type";
    protected static final String Message$$actualParameters = "Message$$actualParameters";
    
    protected MessageDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MessageView getAnything(){
        return (view.MessageView)this.anything;
    }
}

@SuppressWarnings("serial")
class FunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Function$$factor = "Function$$factor";
    protected static final String Function$$constant = "Function$$constant";
    
    protected FunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "factor", this.getAnything().getFactor());
            this.getScrollablePane().add(panel);
            this.panels.put(Function$$factor, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "constant", this.getAnything().getConstant());
            this.getScrollablePane().add(panel);
            this.panels.put(Function$$constant, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.FunctionView getAnything(){
        return (view.FunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class AspectManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AspectManager$$aspects = "AspectManager$$aspects";
    
    protected AspectManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AspectManagerView getAnything(){
        return (view.AspectManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class LinkDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MessageOrLink$$source = "MessageOrLink$$source";
    protected static final String MessageOrLink$$target = "MessageOrLink$$target";
    protected static final String Link$$type = "Link$$type";
    
    protected LinkDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.LinkView getAnything(){
        return (view.LinkView)this.anything;
    }
}

@SuppressWarnings("serial")
class MAspectDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MAspect$$name = "MAspect$$name";
    protected static final String MAspect$$types = "MAspect$$types";
    
    protected MAspectDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(MAspect$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.MAspectView getAnything(){
        return (view.MAspectView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AccountManager$$accounts = "AccountManager$$accounts";
    
    protected AccountManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AccountManagerView getAnything(){
        return (view.AccountManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class CompUnitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnit$$name = "AbsUnit$$name";
    protected static final String CompUnit$$refs = "CompUnit$$refs";
    
    protected CompUnitDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsUnit$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.CompUnitView getAnything(){
        return (view.CompUnitView)this.anything;
    }
}

@SuppressWarnings("serial")
class OperationDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsOperation$$name = "AbsOperation$$name";
    protected static final String AbsOperation$$source = "AbsOperation$$source";
    protected static final String AbsOperation$$target = "AbsOperation$$target";
    protected static final String AbsOperation$$parameters = "AbsOperation$$parameters";
    
    protected OperationDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsOperation$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.OperationView getAnything(){
        return (view.OperationView)this.anything;
    }
}

@SuppressWarnings("serial")
class CONCMModelItemDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    
    protected CONCMModelItemDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.CONCMModelItemView getAnything(){
        return (view.CONCMModelItemView)this.anything;
    }
}

@SuppressWarnings("serial")
class QuantityManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String QuantityManager$$quantities = "QuantityManager$$quantities";
    
    protected QuantityManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.QuantityManagerView getAnything(){
        return (view.QuantityManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class NameSchemeManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String NameSchemeManager$$schemes = "NameSchemeManager$$schemes";
    protected static final String NameSchemeManager$$names = "NameSchemeManager$$names";
    
    protected NameSchemeManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NameSchemeManagerView getAnything(){
        return (view.NameSchemeManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class AssociationManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AssociationManager$$associations = "AssociationManager$$associations";
    protected static final String AssociationManager$$hierarchies = "AssociationManager$$hierarchies";
    
    protected AssociationManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AssociationManagerView getAnything(){
        return (view.AssociationManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class AvgStrategyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected AvgStrategyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AvgStrategyView getAnything(){
        return (view.AvgStrategyView)this.anything;
    }
}

@SuppressWarnings("serial")
class HierarchyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Hierarchy$$name = "Hierarchy$$name";
    protected static final String Hierarchy$$associations = "Hierarchy$$associations";
    
    protected HierarchyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(Hierarchy$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.HierarchyView getAnything(){
        return (view.HierarchyView)this.anything;
    }
}

@SuppressWarnings("serial")
class MAccountTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MQuantiObjectType$$type = "MQuantiObjectType$$type";
    protected static final String MQuantiObjectType$$unitType = "MQuantiObjectType$$unitType";
    protected static final String MAccountType$$subAccountTypes = "MAccountType$$subAccountTypes";
    
    protected MAccountTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MAccountTypeView getAnything(){
        return (view.MAccountTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MMixedTypeDisjunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    protected static final String MMixedTypeDisjunction$$addends = "MMixedTypeDisjunction$$addends";
    
    protected MMixedTypeDisjunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MMixedTypeDisjunctionView getAnything(){
        return (view.MMixedTypeDisjunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class TypeManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String TypeManager$$types = "TypeManager$$types";
    
    protected TypeManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.TypeManagerView getAnything(){
        return (view.TypeManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class MNonEmptyAtomicTypeConjunctionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    protected static final String MNonEmptyAtomicTypeConjunction$$factors = "MNonEmptyAtomicTypeConjunction$$factors";
    
    protected MNonEmptyAtomicTypeConjunctionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MNonEmptyAtomicTypeConjunctionView getAnything(){
        return (view.MNonEmptyAtomicTypeConjunctionView)this.anything;
    }
}

@SuppressWarnings("serial")
class MessageManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MessageManager$$messages = "MessageManager$$messages";
    
    protected MessageManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MessageManagerView getAnything(){
        return (view.MessageManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class SumStrategyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected SumStrategyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.SumStrategyView getAnything(){
        return (view.SumStrategyView)this.anything;
    }
}

@SuppressWarnings("serial")
class UnitTypeManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String UnitTypeManager$$unitTypes = "UnitTypeManager$$unitTypes";
    protected static final String UnitTypeManager$$units = "UnitTypeManager$$units";
    
    protected UnitTypeManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.UnitTypeManagerView getAnything(){
        return (view.UnitTypeManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class MNonEmptyDisjunctiveNormalFormDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MModelItem$$dependentItems = "MModelItem$$dependentItems";
    protected static final String MComplexType$$containedTypes = "MComplexType$$containedTypes";
    protected static final String MNonEmptyDisjunctiveNormalForm$$addends = "MNonEmptyDisjunctiveNormalForm$$addends";
    
    protected MNonEmptyDisjunctiveNormalFormDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MNonEmptyDisjunctiveNormalFormView getAnything(){
        return (view.MNonEmptyDisjunctiveNormalFormView)this.anything;
    }
}

@SuppressWarnings("serial")
class FractionManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String FractionManager$$managedFractions = "FractionManager$$managedFractions";
    
    protected FractionManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.FractionManagerView getAnything(){
        return (view.FractionManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class ConversionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Conversion$$myFunction = "Conversion$$myFunction";
    
    protected ConversionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ConversionView getAnything(){
        return (view.ConversionView)this.anything;
    }
}

@SuppressWarnings("serial")
class ReferenceDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Reference$$type = "Reference$$type";
    protected static final String Reference$$exponent = "Reference$$exponent";
    protected static final String Reference$$ref = "Reference$$ref";
    
    protected ReferenceDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "exponent", this.getAnything().getExponent());
            this.getScrollablePane().add(panel);
            this.panels.put(Reference$$exponent, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ReferenceView getAnything(){
        return (view.ReferenceView)this.anything;
    }
}

@SuppressWarnings("serial")
class ReferenceTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ReferenceType$$exponent = "ReferenceType$$exponent";
    
    protected ReferenceTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new IntegerPanel(this, "exponent", this.getAnything().getExponent());
            this.getScrollablePane().add(panel);
            this.panels.put(ReferenceType$$exponent, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ReferenceTypeView getAnything(){
        return (view.ReferenceTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MaxStrategyDefaultDetailPanel extends DefaultDetailPanel{
    
    protected MaxStrategyDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MaxStrategyView getAnything(){
        return (view.MaxStrategyView)this.anything;
    }
}

@SuppressWarnings("serial")
class AccountDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String QuantifObject$$object = "QuantifObject$$object";
    protected static final String Account$$type = "Account$$type";
    protected static final String Account$$subAccounts = "Account$$subAccounts";
    protected static final String Account$$entries = "Account$$entries";
    
    protected AccountDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AccountView getAnything(){
        return (view.AccountView)this.anything;
    }
}

@SuppressWarnings("serial")
class UnitTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnitType$$name = "AbsUnitType$$name";
    protected static final String UnitType$$defaultUnit = "UnitType$$defaultUnit";
    
    protected UnitTypeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(AbsUnitType$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.UnitTypeView getAnything(){
        return (view.UnitTypeView)this.anything;
    }
}

@SuppressWarnings("serial")
class MFalseDefaultDetailPanel extends DefaultDetailPanel{
    
    protected MFalseDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MFalseView getAnything(){
        return (view.MFalseView)this.anything;
    }
}

@SuppressWarnings("serial")
class MeasurementTypeManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String MeasurementTypeManager$$measurementTypes = "MeasurementTypeManager$$measurementTypes";
    
    protected MeasurementTypeManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MeasurementTypeManagerView getAnything(){
        return (view.MeasurementTypeManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class LinkManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String LinkManager$$links = "LinkManager$$links";
    
    protected LinkManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.LinkManagerView getAnything(){
        return (view.LinkManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class MTrueDefaultDetailPanel extends DefaultDetailPanel{
    
    protected MTrueDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MTrueView getAnything(){
        return (view.MTrueView)this.anything;
    }
}

@SuppressWarnings("serial")
class QuantityDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Quantity$$amount = "Quantity$$amount";
    protected static final String Quantity$$unit = "Quantity$$unit";
    
    protected QuantityDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "amount", this.getAnything().getAmount());
            this.getScrollablePane().add(panel);
            this.panels.put(Quantity$$amount, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.QuantityView getAnything(){
        return (view.QuantityView)this.anything;
    }
}

@SuppressWarnings("serial")
class ActualParameterDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ActualParameter$$type = "ActualParameter$$type";
    protected static final String ActualParameter$$value = "ActualParameter$$value";
    
    protected ActualParameterDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ActualParameterView getAnything(){
        return (view.ActualParameterView)this.anything;
    }
}

@SuppressWarnings("serial")
class NameDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Name$$fromType = "Name$$fromType";
    protected static final String Name$$nameScheme = "Name$$nameScheme";
    
    protected NameDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.NameView getAnything(){
        return (view.NameView)this.anything;
    }
}

@SuppressWarnings("serial")
class MSingletonObjectDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbstractObject$$possibleNames = "AbstractObject$$possibleNames";
    protected static final String AbstractObject$$productType = "AbstractObject$$productType";
    protected static final String MSingletonObject$$type = "MSingletonObject$$type";
    
    protected MSingletonObjectDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.MSingletonObjectView getAnything(){
        return (view.MSingletonObjectView)this.anything;
    }
}

@SuppressWarnings("serial")
class FractionWrapperDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String FractionWrapper$$fraction = "FractionWrapper$$fraction";
    
    protected FractionWrapperDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "fraction", this.getAnything().getFraction());
            this.getScrollablePane().add(panel);
            this.panels.put(FractionWrapper$$fraction, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.FractionWrapperView getAnything(){
        return (view.FractionWrapperView)this.anything;
    }
}

@SuppressWarnings("serial")
class FunctionManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String FunctionManager$$functions = "FunctionManager$$functions";
    
    protected FunctionManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.FunctionManagerView getAnything(){
        return (view.FunctionManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class ObjectManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ObjectManager$$objects = "ObjectManager$$objects";
    
    protected ObjectManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ObjectManagerView getAnything(){
        return (view.ObjectManagerView)this.anything;
    }
}
