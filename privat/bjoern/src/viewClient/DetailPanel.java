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
	private JPanel getRegExprComfortPanel(RegularExpression expression, String name,String value) {
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
	private view.RegExprPanel getRegExprPane(RegularExpression expression, String name, String value) {
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
    public void handleTransactionManager(view.TransactionManagerView object){
        result = new TransactionManagerDefaultDetailPanel(handler, object);
    }
    public void handleAuftrag(view.AuftragView object){
        result = new AuftragDefaultDetailPanel(handler, object);
    }
    public void handleErrorDisplay(view.ErrorDisplayView object){
        result = new ErrorDisplayDefaultDetailPanel(handler, object);
    }
    public void handleServer(view.ServerView object){
        result = new ServerDefaultDetailPanel(handler, object);
    }
    public void handleKunde(view.KundeView object){
        result = new KundeDefaultDetailPanel(handler, object);
    }
    public void handleAkteur(view.AkteurView object){
        result = new AkteurDefaultDetailPanel(handler, object);
    }
    public void handlePosition(view.PositionView object){
        result = new PositionDefaultDetailPanel(handler, object);
    }
    public void handleLieferant(view.LieferantView object){
        result = new LieferantDefaultDetailPanel(handler, object);
    }
    public void handleProdukt(view.ProduktView object){
        result = new ProduktDefaultDetailPanel(handler, object);
    }

}



@SuppressWarnings("serial")
class TransactionManagerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String TransactionManager$$akteure = "TransactionManager$$akteure";
    
    protected TransactionManagerDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.TransactionManagerView getAnything(){
        return (view.TransactionManagerView)this.anything;
    }
}

@SuppressWarnings("serial")
class AuftragDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Auftrag$$auftraggeber = "Auftrag$$auftraggeber";
    protected static final String Auftrag$$auftragnehmer = "Auftrag$$auftragnehmer";
    protected static final String Auftrag$$positionen = "Auftrag$$positionen";
    
    protected AuftragDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.AuftragView getAnything(){
        return (view.AuftragView)this.anything;
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
class ServerDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Server$$transactionManager = "Server$$transactionManager";
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
class KundeDefaultDetailPanel extends DefaultDetailPanel{
    
    protected KundeDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.KundeView getAnything(){
        return (view.KundeView)this.anything;
    }
}

@SuppressWarnings("serial")
class AkteurDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Akteur$$name = "Akteur$$name";
    protected static final String Akteur$$meineRollen = "Akteur$$meineRollen";
    
    protected AkteurDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(Akteur$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.AkteurView getAnything(){
        return (view.AkteurView)this.anything;
    }
}

@SuppressWarnings("serial")
class PositionDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Position$$beziehtSichAuf = "Position$$beziehtSichAuf";
    
    protected PositionDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.PositionView getAnything(){
        return (view.PositionView)this.anything;
    }
}

@SuppressWarnings("serial")
class LieferantDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Lieferant$$portfolio = "Lieferant$$portfolio";
    
    protected LieferantDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        
    }
    protected view.LieferantView getAnything(){
        return (view.LieferantView)this.anything;
    }
}

@SuppressWarnings("serial")
class ProduktDefaultDetailPanel extends DefaultDetailPanel{
    
    protected static final String Produkt$$name = "Produkt$$name";
    
    protected ProduktDefaultDetailPanel(ExceptionAndEventHandler exceptionHandler, Anything anything) {
        super(exceptionHandler, anything);
    }
    protected void addFields(){
        try{
            BaseTypePanel panel = new StringPanel(this, "name", this.getAnything().getName());
            this.getScrollablePane().add(panel);
            this.panels.put(Produkt$$name, panel);
        }catch(view.ModelException e){
            this.getExceptionAndEventhandler().handleException(e);
        }
        
    }
    protected view.ProduktView getAnything(){
        return (view.ProduktView)this.anything;
    }
}