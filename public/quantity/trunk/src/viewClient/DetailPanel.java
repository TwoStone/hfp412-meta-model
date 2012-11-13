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

import view.Anything;
import view.ModelException;

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
	protected boolean check() {
		return true;
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
		this.addFields();
	}
}


class DetailPanelFactory implements view.visitor.AnythingVisitor {
	protected DefaultDetailPanel result = null;
	private ExceptionAndEventHandler handler;
	public DetailPanelFactory(ExceptionAndEventHandler handler) {
		this.handler = handler;
	}
    public void handleConversionManager(view.ConversionManagerView object){
        result = new ConversionManagerDefaultDetailPanel(handler, object);
    }
    public void handleReferenceType(view.ReferenceTypeView object){
        result = new ReferenceTypeDefaultDetailPanel(handler, object);
    }
    public void handleQuantityManager(view.QuantityManagerView object){
        result = new QuantityManagerDefaultDetailPanel(handler, object);
    }
    public void handleErrorDisplay(view.ErrorDisplayView object){
        result = new ErrorDisplayDefaultDetailPanel(handler, object);
    }
    public void handleUnit(view.UnitView object){
        result = new UnitDefaultDetailPanel(handler, object);
    }
    public void handleUnitType(view.UnitTypeView object){
        result = new UnitTypeDefaultDetailPanel(handler, object);
    }
    public void handleQuantity(view.QuantityView object){
        result = new QuantityDefaultDetailPanel(handler, object);
    }
    public void handleCompoundQuantity(view.CompoundQuantityView object){
        result = new CompoundQuantityDefaultDetailPanel(handler, object);
    }
    public void handleUnitTypeManager(view.UnitTypeManagerView object){
        result = new UnitTypeManagerDefaultDetailPanel(handler, object);
    }
    public void handleServer(view.ServerView object){
        result = new ServerDefaultDetailPanel(handler, object);
    }
    public void handleFractionManager(view.FractionManagerView object){
        result = new FractionManagerDefaultDetailPanel(handler, object);
    }
    public void handleCompUnit(view.CompUnitView object){
        result = new CompUnitDefaultDetailPanel(handler, object);
    }
    public void handleReference(view.ReferenceView object){
        result = new ReferenceDefaultDetailPanel(handler, object);
    }
    public void handleConversion(view.ConversionView object){
        result = new ConversionDefaultDetailPanel(handler, object);
    }
    public void handleCompUnitType(view.CompUnitTypeView object){
        result = new CompUnitTypeDefaultDetailPanel(handler, object);
    }

}



@SuppressWarnings("serial")
class ConversionManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ConversionManager$$conversions = "ConversionManager$$conversions";
    
    protected ConversionManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.ConversionManagerView getAnything(){
        return (view.ConversionManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class ReferenceTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String ReferenceType$$exponent = "ReferenceType$$exponent";
    protected static final String ReferenceType$$ref = "ReferenceType$$ref";
    
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
    
    protected static final String AbsUnit$$type = "AbsUnit$$type";
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
class UnitTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnitType$$defaultUnit = "AbsUnitType$$defaultUnit";
    protected static final String AbsUnitType$$name = "AbsUnitType$$name";
    
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
class ServerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Server$$quantityManager = "Server$$quantityManager";
    protected static final String Server$$unitTypeManager = "Server$$unitTypeManager";
    protected static final String Server$$conversionManager = "Server$$conversionManager";
    protected static final String Server$$fractionManager = "Server$$fractionManager";
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
class FractionManagerDefaultDetailPanel extends DefaultDetailPanel{
    
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
class CompUnitDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnit$$type = "AbsUnit$$type";
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
class ConversionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Conversion$$source = "Conversion$$source";
    protected static final String Conversion$$type = "Conversion$$type";
    protected static final String Conversion$$factor = "Conversion$$factor";
    protected static final String Conversion$$constant = "Conversion$$constant";
    
    protected ConversionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new FractionPanel(this, "factor", this.getAnything().getFactor());
            this.getScrollablePane().add(panel);
            this.panels.put(Conversion$$factor, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        try{
            BaseTypePanel panel = new FractionPanel(this, "constant", this.getAnything().getConstant());
            this.getScrollablePane().add(panel);
            this.panels.put(Conversion$$constant, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ConversionView getAnything(){
        return (view.ConversionView)this.anything;
    }
}

@SuppressWarnings("serial")
class CompUnitTypeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String AbsUnitType$$defaultUnit = "AbsUnitType$$defaultUnit";
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
