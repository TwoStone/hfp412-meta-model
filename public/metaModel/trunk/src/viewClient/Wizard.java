package viewClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import view.Anything;
import view.ModelException;
import view.objects.IconRenderer;
import view.objects.ViewObject;
import view.objects.ViewObjectInTree;
import view.objects.ViewRoot;

@SuppressWarnings("serial")
public abstract class Wizard extends JDialog {

	public static final String DetailsTitle = "Details";
	public static final String NaviationTitle = "Navigation";
	public static final String ErrorTitle = "Errors";

	private static final String NoTitle = "-----";
	protected static final String EditTextButtonText = "Bearbeiten";
	protected static final String ShowTextButtonText = "Anzeigen";
	protected static final String BrowseButtonText = "Auswählen";
	protected static final String NullRepresentation = "NULL";
	protected static final String WrongTypeMessage = "Falsches Objekt, Anzahl: ";
	public static final String OKButtonText = "O.K.";
	public static final String CancelButtonText = "Abbrechen";
	public static final String HelpButtonText = "Hilfe";
	public static final String ObjectSelectionHint = "Auswählen auch mit Alt+Click!";
	public static final String ChooseFromText = "Auswählen aus:";
	private static final String HelpTitle = "Hilfe";
	public static final String UpdateButtonText = "Übernehmen";
	public static final String TextFieldToolTipText = "Öffnen mit Doppel-Klick";
	public static final String UpdateText = "Alles Aktualisieren";
	public static final String SaveTextButtonText = "Speichern ...";
	public static final String CloseTextButtonText = "Schließen";
	public static final String SupportButtonText = "Eingabeunterstützung";
	protected static final String SaveTextApproveText = "Text speichern!";
	protected static final String ApproveText = "Datei wird überschrieben!";
	public static final String OpenTextButtonText = "Datei öffnen ...";
	protected static final String OpenTextFileApproveText = "Datei als Text öffnen";
	protected static final String FileDoesNotExistText = "Datei existiert nicht: ";
	protected static final String EmptyCollectionText = "EMPTY";

	public static final int BaseTypePanelStandardWidth = 10000;
	public static final int BaseTypePanelStandardHeight = 28;
	protected static final String ConfirmQuestionMark = " ?";
	
	public static final Color NeutralForeground = new Color(120, 120, 120);
	public static final Color OKForeground = new Color(0, 0, 0);
	public static final Color NotOKForeground = new Color(127, 127, 127);
	
	public static final Color Yellow = new Color(200, 200, 0);
	public static final String NeutralText = "Aktualisieren";
	public static final Icon NeutralIcon = null;

	public static final Color Green = new Color(0, 200, 0);
	public static final String OKText = NeutralText;
	public static final Icon OKIcon = null;

	public static final Color Red = new Color(200, 0, 0);
	public static final String NotOKText = NeutralText;
	public static final Icon NotOKIcon = null;
	
	public static final int TextPreviewLength = 100;

	static final Color ReturnValueBackgroundColor = new Color(255, 255, 220); 
	static final Color ReturnValueBackgroundErrorColor = new Color(180,0,0); 
	static final Color ReturnValueForegroundErrorColor = new Color(120,255,255); 
	static final int ReturnValueSmallHeight = 20;
	public static final int StandardBrowserPanelHeight = 300;
	public static final int StandardRegExprBrowserPanelHeight = 200;

	
	private javax.swing.JRootPane jContentPane = null;
	private javax.swing.JToolBar toolBar = null;
	private javax.swing.JButton okButton = null;
	private javax.swing.JPanel parametersPanel = null;
	private JLabel distanceLabel = null;
	private JLabel statusBar = null;

	public Wizard() {
		super();
		initialize();
		this.setResizable(true);
	}

	protected void initialize() {
		this.setModal(true);
		this.setContentPane(getJContentPane());
		this.setTitle(NoTitle);
		this.check();
	}

	javax.swing.JRootPane getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JRootPane();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getToolBar(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getParametersPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.setDefaultButton(this.getOkButton());
		}
		return jContentPane;
	}

	private javax.swing.JToolBar getToolBar() {
		if (toolBar == null) {
			distanceLabel = new JLabel();
			distanceLabel.setText("   ");
			toolBar = new javax.swing.JToolBar();
			toolBar.add(getOkButton());
			toolBar.add(getMainCancelButton());
			if (hasHelp() )toolBar.add(getHelpButton());
			toolBar.add(distanceLabel);
			toolBar.add(getStatusBar());
		}
		return toolBar;
	}
	
	protected boolean hasHelp(){
		java.net.URL in = this.getClass().getClassLoader().getResource(this.helpFileName);
		return in != null;
	};
	
	private JButton helpButton = null;
	private JButton getHelpButton() {
		if (this.helpButton == null){
			this.helpButton = new JButton();
			this.helpButton.setText(HelpButtonText);
			this.helpButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					showHelp();
				}
			});
		}
		return this.helpButton;
	}
	protected String helpFileName = "helpText.help";
	protected void showHelp(){
		String contentString = "No help available";
		java.net.URL in = this.getClass().getClassLoader().getResource(this.helpFileName);
		java.net.URLConnection con;
		try {
			con = in.openConnection();
			InputStream content = (InputStream) con.getContent();
			DataInputStream reader = new DataInputStream(content);
			StringBuffer stringResult = new StringBuffer();
			try {
				while (true){
					byte next = reader.readByte();
					stringResult.append((char) next);
				}
			}catch(EOFException eof){}
			contentString = stringResult.toString();
		} catch (IOException e) {}
		this.getHelpTextArea().setText(contentString);
		this.getHelpWindow().setLocationRelativeTo(this);
		this.getHelpWindow().setSize(this.getSize());
		this.getHelpWindow().setVisible(true);
	}
	private JFrame helpWindow = null;
	private JFrame getHelpWindow() {
		if (helpWindow == null){
			this.helpWindow = new JFrame();
			this.helpWindow.setContentPane(this.getHelpWindowContentPane());
			this.helpWindow.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			this.helpWindow.setTitle(HelpTitle);
		}
		return this.helpWindow;
	}
	private JPanel helpWindowContentPane = null;
	private JPanel getHelpWindowContentPane() {
		if(this.helpWindowContentPane == null){
			this.helpWindowContentPane = new JPanel();
			this.helpWindowContentPane.setLayout(new BorderLayout());
			this.helpWindowContentPane.add(getHelpTextAreaScrollPane(), BorderLayout.CENTER);
		}
		return this.helpWindowContentPane;
	}
	private JScrollPane helpTextAreaScrollPane = null;
	private JScrollPane getHelpTextAreaScrollPane() {
		if(this.helpTextAreaScrollPane == null){
			this.helpTextAreaScrollPane = new JScrollPane();
			this.helpTextAreaScrollPane.setViewportView(getHelpTextArea());
		}
		return this.helpTextAreaScrollPane;
	}

	private JTextArea helpTextArea = null;
	private JTextArea getHelpTextArea() {
		if(this.helpTextArea == null){
			this.helpTextArea = new JTextArea();
			this.helpTextArea.setEditable(false);
			this.helpTextArea.setLineWrap(true);
			this.helpTextArea.setWrapStyleWord(true);
			this.helpTextArea.setFont(this.getFont());
			this.helpTextArea.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e) {
				}
				public void focusLost(FocusEvent e) {
					getHelpWindow().setVisible(false);
					getHelpWindow().dispose();
				}
			});
		}
		return this.helpTextArea;
	}

	private JButton mainCancelButton = null;
	private JButton getMainCancelButton() {
		if (mainCancelButton == null){
			mainCancelButton = new JButton();
			mainCancelButton.setText(CancelButtonText);
			mainCancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return mainCancelButton;
	}
	
	protected JLabel getStatusBar() {
		if(statusBar == null){
			statusBar = new JLabel();
			statusBar.setForeground(Color.RED);
			statusBar.setText(" ");
		}
		return statusBar;
	}

	protected javax.swing.JButton getOkButton() {
		if (okButton == null) {
			okButton = new javax.swing.JButton();
			okButton.setEnabled(false);
			okButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					perform();
					okButton.grabFocus();
				}
			});
		}
		return okButton;
	}

	protected abstract void perform();

	protected javax.swing.JPanel getParametersPanel() {
		if (parametersPanel == null) {
			parametersPanel = new javax.swing.JPanel();
			parametersPanel.setLayout(new javax.swing.BoxLayout(
					getParametersPanel(), javax.swing.BoxLayout.Y_AXIS));
			this.addParameters();
		}
		return parametersPanel;
	}

	protected boolean check() {
		getStatusBar().setText("");
		boolean result = true;
		for (int i = 0; i < getParametersPanel().getComponentCount(); i++) {
			SelectionPanel current = (SelectionPanel) getParametersPanel().getComponent(i);
			if (!current.check()){
				result = false;
			}
			handleDependencies(i);
		}
		if (result) {
			String checkComment = this.checkCompleteParameterSet();
			result = checkComment == null || checkComment.equals("");
			if (! result){
				this.getStatusBar().setText(checkComment);
			}
		}
		
		getOkButton().setEnabled(result);
		return result;
	}
	protected abstract String checkCompleteParameterSet();
	
	abstract protected void handleDependencies(int i);

	protected abstract void addParameters();

	private AbstractBrowserPanel browserPanel;
	private Dimension preferredSize;
	private Component focusOwner;

	public void setPanel(AbstractBrowserPanel browserPanel) {
		this.focusOwner = this.getFocusOwner();
		getStatusBar().setText("");
		this.browserPanel = browserPanel;
		this.preferredSize = this.getPreferredSize();
		this.getContentPane().remove(this.getParametersPanel());
		this.add((Component) this.browserPanel, BorderLayout.CENTER);
		this.getOkButton().setEnabled(false);
		this.setPreferredSize(browserPanel.getPreferredSize());
		this.pack();
		this.repaint();
		this.getJContentPane().setDefaultButton(browserPanel.getDefaultButton());
		browserPanel.determineFirstFocus();
		
	}

	public void resetPanel() {
		this.getContentPane().remove((Component)this.browserPanel);
		this.getContentPane().add(this.getParametersPanel(),
				BorderLayout.CENTER);
		this.setPreferredSize(this.preferredSize);
		this.pack();
		this.repaint();
		this.check();
		this.getFocusTraversalPolicy().getComponentAfter(this, this.focusOwner).requestFocusInWindow();
		this.jContentPane.setDefaultButton(getOkButton());
	}
}

@SuppressWarnings("serial")
abstract class SelectionPanel extends JPanel {

	protected Wizard main;

	protected String parameterName;

	SelectionPanel() {
		super();
	}

	SelectionPanel(String parameterName, Wizard main) {
		super();
		this.main = main;
		this.parameterName = parameterName;
		this.setLayout(new javax.swing.BoxLayout(this,
				javax.swing.BoxLayout.X_AXIS));
		this.add(getParameterNameLabel());
	}

	private JLabel parameterNameLabel = null;

	private JLabel getParameterNameLabel() {
		if (parameterNameLabel == null) {
			parameterNameLabel = new JLabel(parameterName + ": ");
		}
		return parameterNameLabel;
	}
	abstract protected Object getResult();
	abstract boolean check();
	abstract protected void browse();
	void preset(common.Fraction value){}
	void preset(long value){}
	void preset(java.util.Date value){}
	void preset(String value){}
	void preset(java.util.Vector<?> value){}
	void preset(Anything value){}
	protected void setOk(boolean b) {
		this.getParameterNameLabel().setForeground(b?Color.BLACK:Color.RED);
		this.invalidate();
		this.main.repaint();
	}


}

@SuppressWarnings("serial")
class IntegerSelectionPanel extends SelectionPanel {

	Long result;
	
	IntegerSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getIntegerInputTextField());
	}

	private JTextField integerInputTextField = null;

	protected JTextField getIntegerInputTextField() {
		if (integerInputTextField == null) {
			integerInputTextField = new JTextField();
			integerInputTextField.setText("0");
			integerInputTextField.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
					main.check();
				}

				public void keyTyped(KeyEvent e) {
				}
			});
		}
		return integerInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = Long.parseLong(getIntegerInputTextField().getText());
			resultValue = true;
		} catch (NumberFormatException nfe) {}
		this.setOk(resultValue);
		return resultValue;
	}

	protected Long getResult() {
		return result;
	}
	void preset(long value){
		this.getIntegerInputTextField().setText(new Long(value).toString());
	}
	void preset(String value){
		this.getIntegerInputTextField().setText(value);
	}
	protected void browse() {}

}
@SuppressWarnings("serial")
abstract class UserIntegerSelectionPanel extends IntegerSelectionPanel {
	UserIntegerSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}
@SuppressWarnings("serial")
class FractionSelectionPanel extends SelectionPanel {

	common.Fraction result;
	
	FractionSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getFractionInputTextField());
	}

	private JTextField fractionInputTextField = null;

	protected JTextField getFractionInputTextField() {
		if (fractionInputTextField == null) {
			fractionInputTextField = new JTextField();
			fractionInputTextField.setText("0");
			fractionInputTextField.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
					main.check();
				}

				public void keyTyped(KeyEvent e) {
				}
			});
		}
		return fractionInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = common.Fraction.parse(getFractionInputTextField().getText());
			resultValue = true;
		} catch (NumberFormatException nfe) {}
		this.setOk(resultValue);
		return resultValue;
	}

	protected common.Fraction getResult() {
		return result;
	}
	void preset(String value){
		this.getFractionInputTextField().setText(value);
	}
	void preset(common.Fraction value){
		this.getFractionInputTextField().setText(value.toString());
	}
	protected void browse() {}

}
@SuppressWarnings("serial")
abstract class UserFractionSelectionPanel extends FractionSelectionPanel {
	UserFractionSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class StringSelectionPanel extends SelectionPanel {

	StringSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getStringInputTextField());
	}

	private JTextField stringInputTextField = null;

	protected JTextField getStringInputTextField() {
		if (stringInputTextField == null) {
			stringInputTextField = new JTextField();
			stringInputTextField.setText("");
			stringInputTextField.addKeyListener(this.getInputKeyListener());
		}
		return stringInputTextField;
	}

	protected KeyListener getInputKeyListener(){
		return new KeyListener() {
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				main.check();
			}

			public void keyTyped(KeyEvent e) {
			}
		};
	}
	boolean check() {
		this.setOk(true);
		return true;
	}

	protected String getResult() {
		return getStringInputTextField().getText();
	}
	void preset(String value){
		this.getStringInputTextField().setText(value);
	}
	protected void browse() {}

}


@SuppressWarnings("serial")
abstract class UserStringSelectionPanel extends StringSelectionPanel {
	UserStringSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}

	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}
@SuppressWarnings("serial")
class PasswordSelectionPanel extends SelectionPanel {

	PasswordSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getPasswordInputTextField());
	}

	private JPasswordField passwordInputTextField = null;

	private JPasswordField getPasswordInputTextField() {
		if (passwordInputTextField == null) {
			passwordInputTextField = new JPasswordField();
			passwordInputTextField.setText("");
			passwordInputTextField.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
					main.check();
				}

				public void keyTyped(KeyEvent e) {
				}
			});
		}
		return passwordInputTextField;
	}

	boolean check() {
		this.setOk(true);
		return true;
	}

	protected String getResult() {
		StringBuffer result = new StringBuffer();
		char[] password = getPasswordInputTextField().getPassword();
		for (int i = 0; i < password.length; i++)result.append(password[i]);
		return result.toString();
	}
	void preset(String value){
		this.getPasswordInputTextField().setText(value);
	}
	protected void browse() {}

}
@SuppressWarnings("serial")
abstract class UserPasswordSelectionPanel extends PasswordSelectionPanel {
	UserPasswordSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class DateSelectionPanel extends SelectionPanel {

	java.util.Date result;
	
	DateSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getDateInputTextField());
	}

	private JTextField dateInputTextField = null;

	protected JTextField getDateInputTextField() {
		if (dateInputTextField == null) {
			dateInputTextField = new JTextField();
			dateInputTextField.setText(new java.text.SimpleDateFormat(this.getFormat()).format(new java.util.Date()));
			dateInputTextField.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
					main.check();
				}

				public void keyTyped(KeyEvent e) {
				}
			});
		}
		return dateInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = new java.text.SimpleDateFormat(this.getFormat()).parse(this.getDateInputTextField().getText());
			resultValue = true;
		} catch (java.text.ParseException pe) {}
		this.setOk(resultValue);
		return resultValue;
	}
	protected String getFormat() {
		return view.objects.ViewRoot.DATEFORMAT;
	}

	protected java.util.Date  getResult() {
		return this.result;
	}
	void preset(java.util.Date value){
		this.getDateInputTextField().setText(new java.text.SimpleDateFormat(getFormat()).format(value));
	}
	void preset(String value){
		this.getDateInputTextField().setText(value);
	}

	protected void browse() {}

}
@SuppressWarnings("serial")
abstract class UserDateSelectionPanel extends DateSelectionPanel {
	UserDateSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class TimestampSelectionPanel extends SelectionPanel {

	java.util.Date result;
	
	TimestampSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getDateInputTextField());
	}

	private JTextField dateInputTextField = null;

	protected JTextField getDateInputTextField() {
		if (dateInputTextField == null) {
			dateInputTextField = new JTextField();
			dateInputTextField.setText(new java.text.SimpleDateFormat(this.getFormat()).format(new java.util.Date()));
			dateInputTextField.addKeyListener(new KeyListener() {
				public void keyPressed(KeyEvent e) {
				}

				public void keyReleased(KeyEvent e) {
					main.check();
				}

				public void keyTyped(KeyEvent e) {
				}
			});
		}
		return dateInputTextField;
	}

	boolean check() {
		boolean resultValue = false;
		try {
			result = new java.text.SimpleDateFormat(this.getFormat()).parse(this.getDateInputTextField().getText());
			resultValue = true;
		} catch (java.text.ParseException pe) {}
		this.setOk(resultValue);
		return resultValue;
	}
	protected String getFormat() {
		return view.objects.ViewRoot.TIMESTAMPFORMAT;
	}

	protected java.util.Date  getResult() {
		return this.result;
	}
	void preset(java.util.Date value){
		this.getDateInputTextField().setText(new java.text.SimpleDateFormat(getFormat()).format(value));
	}
	void preset(String value){
		this.getDateInputTextField().setText(value);
	}
	protected void browse() {}

}
@SuppressWarnings("serial")
abstract class UserTimestampSelectionPanel extends TimestampSelectionPanel {
	UserTimestampSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}
	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class TextSelectionPanel extends SelectionPanel {

	String originalText = "";
	
	TextSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
		this.add(getTextViewTextField());
		this.add(getEditButton());
		this.add(getOpenFileButton());
	}
	private JButton openFileButton = null;
	private JButton getOpenFileButton() {
		if(this.openFileButton == null){
			this.openFileButton = new JButton();
			this.openFileButton.setText(Wizard.OpenTextButtonText);
			this.openFileButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					if (chooser.showDialog(main, Wizard.OpenTextFileApproveText) == JFileChooser.APPROVE_OPTION){
						File file = chooser.getSelectedFile();
						try {
							int size = (int) file.length();
							int chars_read = 0;
							FileReader in = new FileReader(file);
							char[] data = new char[size];
							while (in.ready()) {
								chars_read += in.read(data, chars_read, size - chars_read);
							}
							in.close();
							setText(new String(data, 0, chars_read));
						} catch (FileNotFoundException fnfe) {
							main.getStatusBar().setText(Wizard.FileDoesNotExistText + file);
						} catch (IOException ioe) {
							main.getStatusBar().setText(ioe.getMessage());
						}
					}
				}
			});
		}
		return this.openFileButton;
	}
	private JButton editButton = null;
	private JButton getEditButton() {
		if(editButton == null){
			editButton = new JButton();
			editButton.setText(Wizard.EditTextButtonText);
			editButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					browse();
				}
			});
		}
		return editButton;
	}
	protected AbstractBrowserPanel getTextEditPanel() {
		return new TextEditPanel(main,this,parameterName,this.originalText);
	}
	private JTextField stringInputTextField = null;

	protected JTextField getTextViewTextField() {
		if (stringInputTextField == null) {
			stringInputTextField = new JTextField();
			stringInputTextField.setText("");
			stringInputTextField.setEditable(false);
			stringInputTextField.setFocusable(false);
		}
		return stringInputTextField;
	}

	boolean check() {
		this.setOk(true);
		return true;
	}
	protected String getResult() {
		return this.originalText;
	}
	public void setText(String text) {
		this.originalText = text;
		getTextViewTextField().setText(text);
		getTextViewTextField().setCaretPosition(0);
	}
	void preset(String value){
		this.originalText = value;
		this.getTextViewTextField().setText(value);
	}
	protected void browse() {
		main.setPanel(getTextEditPanel());
	}

}
@SuppressWarnings("serial")
abstract class UserTextSelectionPanel extends TextSelectionPanel {
	UserTextSelectionPanel(String parameterName, Wizard main) {
		super(parameterName, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	boolean standardCheck(){
		return super.check();
	}

	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class ObjectSelectionPanel extends SelectionPanel {

	Anything selected = null;
	private String typeName;
	protected ViewRoot navigationRoot;

	ObjectSelectionPanel(String parameterName, String typeName,
			ViewRoot navigationRoot, Wizard main) {
		super(parameterName, main);
		this.typeName = typeName;
		this.navigationRoot = navigationRoot;
		this.add(getSelectedObject());
		this.add(getBrowseButton());
	}
	private JButton browseButton = null;
	private JButton getBrowseButton() {
		if (browseButton == null) {
			browseButton = new JButton();
			browseButton.setText(Wizard.BrowseButtonText);
			browseButton.setEnabled(this.navigationRoot != null);
			browseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					browse();
				}
			});
		}
		return browseButton;
	}
	protected void browse() {
		main.setPanel(getBrowserPanel());
	}

	private BrowserPanel getBrowserPanel() {
		return new BrowserPanel(main, this, parameterName, typeName, this.getBrowserRoot());
	}
	protected ViewRoot getBrowserRoot() {
		return this.navigationRoot;
	}
	protected void setBrowserRoot(ViewRoot navigationRoot){
		if (this.navigationRoot == null || navigationRoot == null || !this.navigationRoot.equals(navigationRoot)){
			this.setSelectedObject(null);
			this.navigationRoot = navigationRoot;
			this.getBrowseButton().setEnabled(this.navigationRoot != null);
		}
	}
	private JTextField selectedObject = null;
	private JTextField getSelectedObject() {
		if (selectedObject == null) {
			selectedObject = new JTextField();
			selectedObject.setEditable(false);
			selectedObject.setText(Wizard.NullRepresentation);
			selectedObject.setFocusable(false);
		}
		return selectedObject;
	}
	boolean check() {
		boolean resultValue = selected != null;
		this.setOk(resultValue);
		return resultValue;
	}
	public void setSelectedObject(Anything selected) {
		this.selected = selected;
		this.getSelectedObject().setText(selected == null ? Wizard.NullRepresentation : selected.toString());
		if (selected != null && this.check()){
			this.main.check();
		}
	}
	protected Anything getResult() {
		return this.selected;
	}
	void preset(Anything value){
		this.setSelectedObject(value);
	}
}
@SuppressWarnings("serial")
abstract class UserObjectSelectionPanel extends ObjectSelectionPanel {
	UserObjectSelectionPanel(String parameterName, String typeName, ViewRoot treeModel, Wizard main) {
		super(parameterName, typeName, treeModel, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class ObjectCollectionSelectionPanel extends SelectionPanel {

	private String typeName;
	protected ViewRoot navigationRoot;

	ObjectCollectionSelectionPanel(String parameterName, String typeName,
			ViewRoot navigationRoot, Wizard main) {
		super(parameterName, main);
		this.typeName = typeName;
		this.navigationRoot = navigationRoot;
		this.add(getSelectedObjects());
		this.add(new JLabel("  "));
		this.add(getNumberLabel());
		this.add(new JLabel("  "));
		this.add(getBrowseButton());
	}
	private JLabel numberLabel = null;
	private JLabel getNumberLabel(){
		if (numberLabel == null){
			numberLabel = new JLabel();
			numberLabel.setPreferredSize(new Dimension(24,10));
			numberLabel.setText("0");
		}
		return numberLabel;
	}
	
	
	private JComboBox selectedObjects = null;

	private JComboBox getSelectedObjects() {
		if (selectedObjects == null) {
			selectedObjects = new JComboBox();
			selectedObjects.setEditable(false);
			selectedObjects.setModel(getSelectedObjectsModel());
			selectedObjects.setFocusable(false);
		}
		return selectedObjects;
	}
	private DefaultComboBoxModel selectedObjectsModel = null;
	DefaultComboBoxModel getSelectedObjectsModel() {
		if(selectedObjectsModel == null){
			selectedObjectsModel = new DefaultComboBoxModel();
			selectedObjectsModel.addListDataListener(new ListDataListener(){
				public void contentsChanged(ListDataEvent e) {
					standard();
				}
				private void standard() {
					numberLabel.setText(new Integer(getSelectedObjectsModel().getSize()).toString());
				}
				public void intervalAdded(ListDataEvent e) {
					standard();
				}
				public void intervalRemoved(ListDataEvent e) {
					standard();
				}
				
			});
		}
		return selectedObjectsModel;
	}

	private JButton browseButton = null;

	private JButton getBrowseButton() {
		if (browseButton == null) {
			browseButton = new JButton();
			browseButton.setText(Wizard.BrowseButtonText);
			browseButton.setEnabled(this.navigationRoot != null);
			browseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					browse();
				}
			});
		}
		return browseButton;
	}

	protected void browse() {
		main.setPanel(getBrowserPanel());
	}


	private CollectionBrowserPanel getBrowserPanel() {
		return new CollectionBrowserPanel(main,this,parameterName,typeName,this.getBrowserRoot());
	}

	protected ViewRoot getBrowserRoot() {
		return this.navigationRoot;
	}

	boolean check() {
		this.setOk(true);
		return true;
	}
	boolean check(Anything selected) {
		return true;
	}
	
	protected Vector<?> getResult() {
		Vector<Object> result = new Vector<Object>();
		for (int i = 0; i < getSelectedObjectsModel().getSize(); i++){
			result.add(getSelectedObjectsModel().getElementAt(i));
		}
		return result;
	}
	void preset(java.util.Vector<?> value){
		java.util.Iterator<?> values = value.iterator();
		while (values.hasNext())this.getSelectedObjectsModel().addElement(values.next());
	}

	protected void setBrowserRoot(ViewRoot navigationRoot){
		if (this.navigationRoot == null || navigationRoot == null || !this.navigationRoot.equals(navigationRoot)){
			this.getSelectedObjectsModel().removeAllElements();
			this.navigationRoot = navigationRoot;
			this.getBrowseButton().setEnabled(this.navigationRoot != null);
		}
	}

}
@SuppressWarnings("serial")
abstract class UserObjectCollectionSelectionPanel extends ObjectCollectionSelectionPanel {
	UserObjectCollectionSelectionPanel(String parameterName, String typeName, ViewRoot navigationRoot, Wizard main) {
		super(parameterName, typeName, navigationRoot, main);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	/** Check whole collection "this.getResult()" */
	abstract protected boolean userCheck();
	
	boolean check(Anything anything) {
		return this.userCheck(anything);
	}
	/** Check individual object that gets selected in the browser ">>>" */
	abstract protected boolean userCheck(Anything anything);
	
}

@SuppressWarnings("serial")
abstract class AbstractBrowserPanel extends JPanel{

	abstract public void determineFirstFocus();
	abstract JButton getDefaultButton();
	
};

class CollectionBrowserPanel extends AbstractBrowserPanel {

	private static final long serialVersionUID = 1L;
	private JSplitPane splitPane = null;
	private JPanel treePanel = null;
	private JPanel listPanel = null;
	private JScrollPane treeScrollPane = null;
	private JTreeRefresh tree = null;
	private JScrollPane listScrollPane = null;
	private JList list = null;
	private Wizard main;
	private ObjectCollectionSelectionPanel panel;
	private String parameterName;
	private ViewRoot navigationRoot;
	private String typeName;


	public CollectionBrowserPanel(Wizard main, ObjectCollectionSelectionPanel panel, String parameterName, String typeName, ViewRoot navigationRoot) {
		super();
		this.main = main;
		this.panel = panel;
		this.parameterName = parameterName;
		this.navigationRoot = navigationRoot;
		this.typeName = typeName;
		this.setPreferredSize(new java.awt.Dimension(main.getWidth(), Wizard.StandardBrowserPanelHeight));
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(getSplitPane(), BorderLayout.CENTER);
		this.add(getToolBar(), BorderLayout.SOUTH);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerLocation((int)this.getPreferredSize().getWidth()/2);
			splitPane.setRightComponent(getListPanel());
			splitPane.setLeftComponent(getTreePanel());
		}
		return splitPane;
	}

	private JPanel getTreePanel() {
		if (treePanel == null) {
			treePanel = new JPanel();
			treePanel.setLayout(new BorderLayout());
			treePanel.add(getTreeScrollPane(), BorderLayout.CENTER);
			treePanel.setBorder(new TitledBorder(Wizard.ChooseFromText));
		}
		return treePanel;
	}

	private JPanel getListPanel() {
		if (listPanel == null) {
			listPanel = new JPanel();
			listPanel.setLayout(new BorderLayout());
			listPanel.add(getListScrollPane(), BorderLayout.CENTER);
			listPanel.add(getMovePanel(), BorderLayout.WEST);
			listPanel.setBorder(new TitledBorder(this.parameterName));
		}
		return listPanel;
	}

	private JScrollPane getTreeScrollPane() {
		if (treeScrollPane == null) {
			treeScrollPane = new JScrollPane();
			treeScrollPane.setViewportView(getTree());
		}
		return treeScrollPane;
	}

	private JTreeRefresh getTree() {
		if (tree == null) {
			tree = new JTreeRefresh();
			DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
			selectionModel.setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
			tree.setSelectionModel(selectionModel);
			tree.setModel(navigationRoot);
			tree.addKeyListener(new KeyListener() {
				public void keyTyped(KeyEvent arg0) {}
				public void keyReleased(KeyEvent arg0) {
					if (arg0.getKeyChar() == '>') addSelectedItems();
				}
				public void keyPressed(KeyEvent arg0) {}
			});
		}
		return tree;
	}

	private JScrollPane getListScrollPane() {
		if (listScrollPane == null) {
			listScrollPane = new JScrollPane();
			listScrollPane.setViewportView(getList());
		}
		return listScrollPane;
	}

	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			list.setModel(this.getListModel());
		}
		return list;
	}
	private DefaultComboBoxModel listModel = null;
	private JPanel toolBar = null;
	private JButton okButton = null;
	private JLabel distanceLabel = null;
	private JLabel statusbar = null;
	private JPanel movePanel = null;
	private JButton addButton = null;
	private JButton removeButton = null;
	private JPanel fillPanelTop = null;
	private JPanel fillPanelBottom = null;

	private DefaultComboBoxModel getListModel() {
		if(listModel == null){
			listModel = this.panel.getSelectedObjectsModel();
		}
		return listModel;
	}

	private JPanel getToolBar() {
		if (toolBar == null) {
			statusbar = new JLabel();
			statusbar.setText("");
			distanceLabel = new JLabel();
			distanceLabel.setText("   ");
			toolBar = new JPanel();
			toolBar.setLayout(new BoxLayout(toolBar,BoxLayout.X_AXIS));
			toolBar.add(distanceLabel);
			toolBar.add(statusbar);
			JPanel fillup = new JPanel();
			fillup.setPreferredSize(new Dimension(2000,10));
			toolBar.add(fillup);
			toolBar.add(getOKButton());
		}
		return toolBar;
	}

	private JButton getOKButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText(Wizard.OKButtonText);
			okButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					main.resetPanel();
				}
			});
		}
		return okButton;
	}

	private JPanel getMovePanel() {
		if (movePanel == null) {
			movePanel = new JPanel();
			movePanel.setLayout(new BoxLayout(getMovePanel(), BoxLayout.Y_AXIS));
			movePanel.add(getFillPanelTop(), null);
			movePanel.add(getAddButton(), null);
			movePanel.add(getRemoveButton(), null);
			movePanel.add(getFillPanelBottom(), null);
		}
		return movePanel;
	}

	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText(">>>");
			addButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					addSelectedItems();
				}
			});
		}
		return addButton;
	}

	protected void addSelectedItems() {
		TreePath[] selections = getTree().getSelectionPaths();
		int numberOfErrors = 0;
		if(selections != null) {
selectedLoop: for (int i = 0; i < selections.length; i++){
				ViewRoot selected = ((ViewObjectInTree) selections[i].getLastPathComponent()).getWrappedObject();
				if(selected != null){
					try {
						if (Class.forName(typeName).isInstance(selected) && panel.check((Anything) selected)) {
							for (int j = 0; j < getListModel().getSize(); j++){
								if (getListModel().getElementAt(j).equals(selected))
									continue selectedLoop;
							}
							getListModel().addElement(selected);
						} else {
							numberOfErrors = numberOfErrors + 1;
						}
					} catch (ClassNotFoundException e1) {
						throw new Error("Type not found: " + typeName);
					}							
				}
			}
		}
		if (numberOfErrors > 0) setStatusbar(Wizard.WrongTypeMessage + " " + numberOfErrors);
		else setStatusbar("");
		CollectionBrowserPanel.this.main.getJContentPane().setDefaultButton(getDefaultButton());
	}

	protected void setStatusbar(String wrongTypeMessage) {
		statusbar.setText(wrongTypeMessage);
	}

	private JButton getRemoveButton() {
		if (removeButton == null) {
			removeButton = new JButton();
			removeButton.setText("<<<");
			removeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Object[] selections = getList().getSelectedValues();
					for (int i = 0; i < selections.length; i++){
						getListModel().removeElement(selections[i]);
					}
					CollectionBrowserPanel.this.main.getJContentPane().setDefaultButton(getDefaultButton());
				}
			});
		}
		return removeButton;
	}

	private JPanel getFillPanelTop() {
		if (fillPanelTop == null) {
			fillPanelTop = new JPanel();
			fillPanelTop.setLayout(new GridBagLayout());
		}
		return fillPanelTop;
	}

	private JPanel getFillPanelBottom() {
		if (fillPanelBottom == null) {
			fillPanelBottom = new JPanel();
			fillPanelBottom.setLayout(new GridBagLayout());
		}
		return fillPanelBottom;
	}

	@Override
	public void determineFirstFocus() {
		this.getTree().requestFocusInWindow();
	}

	@Override
	JButton getDefaultButton() {
		return this.getOKButton();
	}

}
@SuppressWarnings("serial")
class TextEditPanel extends AbstractBrowserPanel {
	private Wizard main;
	private TextSelectionPanel panel;
	private String text;

	TextEditPanel(Wizard main, TextSelectionPanel panel, String parameterName, String text){
		this.main = main;
		this.panel = panel;
		this.text = text;
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(parameterName));
		this.add(getTextAreaScrollPane(),BorderLayout.CENTER);
		this.add(getButtonPanel(),BorderLayout.SOUTH);
		this.setPreferredSize(new java.awt.Dimension(main.getWidth(), Wizard.StandardBrowserPanelHeight));
	}
	private JPanel buttonPanel = null;
	private Component getButtonPanel() {
		if(buttonPanel == null){
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
			buttonPanel.add(getFillupPanel());
			buttonPanel.add(getOKButton());
			buttonPanel.add(getCancelButton());
		}
		return buttonPanel;
	}
	private JButton cancelButton = null;
	private Component getCancelButton() {
		if (cancelButton == null){
			cancelButton = new JButton();
			cancelButton.setText(Wizard.CancelButtonText);
			cancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					main.resetPanel();
				}
			});
		}
		return cancelButton;
	}

	private JButton okButton = null;
	private JButton getOKButton() {
		if (okButton == null){
			okButton = new JButton();
			okButton.setText(Wizard.OKButtonText);
			okButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					panel.setText(getTextArea().getText());
					main.resetPanel();
					setVisible(false);
				}
			});
		}
		return okButton;
	}
	private JPanel fillupPanel = null;
	private JPanel getFillupPanel() {
		if(fillupPanel == null){
			fillupPanel = new JPanel();
			fillupPanel.setPreferredSize(new Dimension(2000,10));
		}
		return fillupPanel;
	}
	private JScrollPane textAreaScrollPane = null;
	private JScrollPane getTextAreaScrollPane() {
		if(textAreaScrollPane == null){
			textAreaScrollPane = new JScrollPane();
			textAreaScrollPane.setViewportView(getTextArea());
		}
		return textAreaScrollPane;
	}
	private JTextArea textArea = null;
	private JTextArea getTextArea() {
		if(textArea == null){
			textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setText(text);
		}
		textArea.setCaretPosition(0);
		textArea.getCaret().setVisible(true);
		textArea.setFocusable(true);
		return textArea;
	}
	@Override
	public void determineFirstFocus() {
		getTextArea().requestFocusInWindow();
	}
	@Override
	JButton getDefaultButton() {
		return this.getOKButton();
	}
}
@SuppressWarnings("serial")
class BrowserPanel extends AbstractBrowserPanel {

	private String typeName;
	private Wizard main;
	private ViewRoot navigationRoot;
	private ObjectSelectionPanel panel;

	BrowserPanel(Wizard main, ObjectSelectionPanel panel, String parameterName,
			String typeName, ViewRoot navigationRoot) {
		this.typeName = typeName;
		this.main = main;
		this.panel = panel;
		this.navigationRoot = navigationRoot;
		setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(parameterName + " :: " + Wizard.ObjectSelectionHint));
		add(getBrowserTreeScrollPane(), BorderLayout.CENTER);
		this.add(getButtonPanel(),BorderLayout.SOUTH);
		this.setPreferredSize(new java.awt.Dimension(main.getWidth(), Wizard.StandardBrowserPanelHeight));
	}
	private JPanel buttonPanel = null;
	private Component getButtonPanel() {
		if(buttonPanel == null){
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
			buttonPanel.add(getStatusbar());
			buttonPanel.add(getFillupPanel());
			buttonPanel.add(getOkButton());
			buttonPanel.add(getCancelButton());
		}
		return buttonPanel;
	}
	private JPanel fillupPanel = null;
	private JPanel getFillupPanel() {
		if(fillupPanel == null){
			fillupPanel = new JPanel();
			fillupPanel.setPreferredSize(new Dimension(2000,10));
		}
		return fillupPanel;
	}
	private JButton okButton = null;
	private JButton getOkButton() {
		if (okButton == null){
			okButton = new JButton();
			okButton.setText(Wizard.OKButtonText);
			okButton.setEnabled(false);
			okButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					trySelect();
				}
			});
		}
		return okButton;
	}

	private JButton cancelButton = null;
	private Component getCancelButton() {
		if (cancelButton == null){
			cancelButton = new JButton();
			cancelButton.setText(Wizard.CancelButtonText);
			cancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					main.resetPanel();
				}
			});
		}
		return cancelButton;
	}

	private JScrollPane browserTreeScrollPane = null;

	private JScrollPane getBrowserTreeScrollPane() {
		if (browserTreeScrollPane == null) {
			browserTreeScrollPane = new JScrollPane();
			browserTreeScrollPane.setViewportView(getBrowserTree());
		}
		return browserTreeScrollPane;
	}

	private JTreeRefresh browserTree = null;

	private JTreeRefresh getBrowserTree() {
		if (browserTree == null) {
			browserTree = new JTreeRefresh();
			browserTree.setModel(navigationRoot);
			browserTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener(){
				public void valueChanged(TreeSelectionEvent e) {
					tryActivateOkButton();
				}
			});
			browserTree.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					if (e.isAltDown()) {
						trySelect();
					} else {
						tryActivateOkButton();
						setStatusbar("");
					}
				}
				public void mouseEntered(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
				}
				public void mousePressed(MouseEvent e) {
				}
				public void mouseReleased(MouseEvent e) {
				}
			});
			browserTree.setSelectionRow(0);
		}
		return browserTree;
	}

	protected void tryActivateOkButton() {
		ViewRoot selected = this.getBrowserTree().getSelectedObject();
		try {
			this.getOkButton().setEnabled(selected != null && Class.forName(typeName).isInstance(selected));
		} catch (ClassNotFoundException e) {
			this.okButton.setEnabled(false);
		}
	}

	protected void trySelect() {
			ViewRoot selected = this.getBrowserTree().getSelectedObject();
			if (selected != null) {
				try {
					if (Class.forName(typeName).isInstance(selected)) {
						panel.setSelectedObject((Anything)selected);
						main.resetPanel();
					} else {
						setStatusbar(Wizard.WrongTypeMessage);
					}
				} catch (ClassNotFoundException e1) {
					throw new Error("Type not found: " + typeName);
				}
			}
	}

	protected void setStatusbar(String message) {
		getStatusbar().setText(message);
	}

	private JLabel statusbar = null;

	private JLabel getStatusbar() {
		if (statusbar == null) {
			statusbar = new JLabel();
			statusbar.setForeground(Color.RED);
		}
		return statusbar;
	}

	@Override
	public void determineFirstFocus() {
		this.getBrowserTree().requestFocusInWindow();
	}

	@Override
	JButton getDefaultButton() {
		return this.getOkButton();
	}

}


@SuppressWarnings("serial")
final class NoDetailPanel extends DetailPanel {

	protected NoDetailPanel(ExceptionAndEventHandler exceptionHandler) {
		super(exceptionHandler);
		this.initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(getNoDetailsCenterHorizontal(),BorderLayout.CENTER);		
	}
	private JPanel noDetailsCenterHorizontal = null;
	private Component getNoDetailsCenterHorizontal() {
		if(noDetailsCenterHorizontal == null){
			noDetailsCenterHorizontal = new JPanel();
			noDetailsCenterHorizontal.setLayout(new BoxLayout(noDetailsCenterHorizontal,BoxLayout.X_AXIS));
			noDetailsCenterHorizontal.add(new JPanel());
			noDetailsCenterHorizontal.add(getNoDetailsCenterVertical());
			noDetailsCenterHorizontal.add(new JPanel());
		}
		return noDetailsCenterHorizontal;
	}
	private JPanel noDetailsCenterVertical = null;
	private Component getNoDetailsCenterVertical() {
		if(noDetailsCenterVertical == null){
			noDetailsCenterVertical = new JPanel();
			noDetailsCenterVertical.setLayout(new BoxLayout(noDetailsCenterVertical,BoxLayout.Y_AXIS));
			noDetailsCenterVertical.add(new JPanel());
			JLabel noDetailsLabel = new JLabel("No Details!!!");
			noDetailsCenterVertical.add(noDetailsLabel);
			noDetailsCenterVertical.add(new JPanel());
		}
		return noDetailsCenterVertical;
	}
	public void setAnything(Anything anything) {}

}
@SuppressWarnings("serial")
final class StandardDetailPanel extends DetailPanel {

	protected StandardDetailPanel(ExceptionAndEventHandler exceptionHandler) {
		super(exceptionHandler);
	}
	public void setAnything(Anything anything) {}	
}

@SuppressWarnings("serial")
class ReturnValueView extends JDialog {
	private ReturnValueView(Dimension size, boolean text){
		this.setSize(size);
		if (!text){
			this.setUndecorated(true);
			this.addWindowFocusListener(new WindowFocusListener(){
				public void windowGainedFocus(WindowEvent e) {}
				public void windowLostFocus(WindowEvent e) {
					ReturnValueView.this.setVisible(false);
					ReturnValueView.this.dispose();
				}
			});
		}else{
			this.setModalityType(ModalityType.APPLICATION_MODAL);
		}
		this.setContentPane(new JRootPane());
	}
	ReturnValueView(String error, Dimension size){
		this(size,false);
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(this.getWidth(), Wizard.ReturnValueSmallHeight);
		JTextField textField = new JTextField();
		textField.setBackground(Wizard.ReturnValueBackgroundErrorColor);
		textField.setForeground(Wizard.ReturnValueForegroundErrorColor);
		textField.setFont(textField.getFont().deriveFont(java.awt.Font.BOLD));
		this.getContentPane().add(textField,BorderLayout.NORTH);		
		textField.setText(error);
		textField.invalidate();
	}
	ReturnValueView(String result, boolean text, Dimension size){
		this(size,text);
		this.getContentPane().setLayout(new BorderLayout());
		if (text){
			final JScrollPane scrollPane = new JScrollPane();
			final JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setBackground(Wizard.ReturnValueBackgroundColor);
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			this.getContentPane().add(scrollPane,BorderLayout.CENTER);
			JToolBar textToolBar = new JToolBar();
			final JLabel statusBar = new JLabel(" ");
			final JButton closeButton = new JButton();
			closeButton.setText(Wizard.CloseTextButtonText);
			closeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			JButton saveButton = new JButton();
			saveButton.setText(Wizard.SaveTextButtonText);
			saveButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					if (chooser.showDialog(scrollPane,Wizard.SaveTextApproveText) == JFileChooser.APPROVE_OPTION){
						File file = chooser.getSelectedFile();
						if (file.exists()){
							if (javax.swing.JOptionPane.showConfirmDialog(scrollPane, file, Wizard.ApproveText, javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) != javax.swing.JOptionPane.YES_OPTION){
								return;
							}
						}
						try {
							FileWriter writer = new FileWriter(file);
							writer.write(textArea.getText());
							writer.close();
							statusBar.setText(file.toString());
							((JRootPane)getContentPane()).setDefaultButton(closeButton);
						} catch (IOException ioe) {
							statusBar.setText(ioe.getMessage());							
						}
					}
				}
			});
			textToolBar.add(saveButton);
			textToolBar.add(closeButton);
			textToolBar.add(new JLabel("   "));
			textToolBar.add(statusBar);
			this.getContentPane().add(textToolBar,BorderLayout.SOUTH);
			((JRootPane)this.getContentPane()).setDefaultButton(saveButton);
			textArea.setText(result);
			textArea.invalidate();
		}else{
			this.setSize(this.getWidth(), Wizard.ReturnValueSmallHeight);
			JTextField textField = new JTextField();
			textField.setBackground(Wizard.ReturnValueBackgroundColor);
			this.getContentPane().add(textField,BorderLayout.NORTH);
			textField.setText(result);
			textField.invalidate();
		}
	}
	ReturnValueView(long result, Dimension size){
		this(new Long(result).toString(),false, new Dimension(size.width,Wizard.ReturnValueSmallHeight));
	}
	public ReturnValueView(common.Fraction result, Dimension size) {
		this(result.toString(),false, new Dimension(size.width,Wizard.ReturnValueSmallHeight));
	}	
	
	ReturnValueView(java.util.Date result, boolean millies, Dimension size){
		this(ViewRoot.toString(result, millies),false, new Dimension(size.width,Wizard.ReturnValueSmallHeight));
	}
	ReturnValueView(ViewRoot result, Dimension size){
		this(size,false);
		this.getContentPane().setLayout(new BorderLayout());
		if (result != null){
			JScrollPane scrollPane = new JScrollPane();
			JTreeRefresh tree = new JTreeRefresh();
			tree.setBackground(Wizard.ReturnValueBackgroundColor);
			tree.setRootVisible(true);
			tree.setModel(result);
			scrollPane.setViewportView(tree);
			tree.updateUI();
			this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		}else{
			JLabel nullLabel = new JLabel();
			nullLabel.setText(common.RPCConstantsAndServices.NullObjectToString);
			nullLabel.setForeground(Color.RED);
			this.getContentPane().add(nullLabel, BorderLayout.CENTER);
		}
	}
	ReturnValueView(java.util.Vector<?> result, Dimension size){
		this(size,false);
		this.getContentPane().setLayout(new BorderLayout());
		if (result.size() > 0){
			JScrollPane scrollPane = new JScrollPane();
			JTreeRefresh tree = new JTreeRefresh();
			tree.setBackground(Wizard.ReturnValueBackgroundColor);
			tree.setRootVisible(false);
			tree.setModel(new ListRoot(result));
			tree.invalidate();
			scrollPane.setViewportView(tree);
			this.getContentPane().add(scrollPane,BorderLayout.CENTER);
		}else{
			JLabel emptyLabel = new JLabel();
			emptyLabel.setText(Wizard.EmptyCollectionText);
			emptyLabel.setForeground(Color.RED);
			this.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		}
	}	
}

class ListRoot extends ViewRoot implements TreeModel {
	private Vector<?> list;

	public ListRoot(Vector<?> list) {
		super(0,0);
		this.list = list;
	}
	public Object getChild(Object parent, int index) {
		if (parent == this) return this.list.get(index);
		try {
			return ((ViewObjectInTree)parent).getChild(index);
		} catch (ModelException e) {
			return e;
		}
	}
	public int getChildCount(Object parent) {
		if (parent == this) return this.list.size();
		try {
			return ((ViewObjectInTree)parent).getChildCount();
		} catch (ModelException e) {
			return 0;
		}
	}
	public int getIndexOfChild(Object parent, Object child) {
		if (parent == this) {
			int result = 0;
			Iterator<?> roots = this.list.iterator();
			while (roots.hasNext()){
				if (roots.next().equals(child)) return result;
				result++;
			}
			return 0;
		}else{
			try {
				return ((ViewObjectInTree)parent).getIndexOfChild(child);
			} catch (ModelException e) {
				return 0;
			}
		}
	}
	public ViewRoot getRoot() {
		return this;
	}
	public boolean isLeaf(Object node) {
		if (node == this)return this.list.isEmpty();
		try {
			return ((ViewObjectInTree)node).isLeaf();
		} catch (ModelException e) {
			return true;
		}
	}
	public void addTreeModelListener(TreeModelListener l) {}
	public void removeTreeModelListener(TreeModelListener l) {}
	public void valueForPathChanged(TreePath path, Object newValue) {}

	public ViewRoot getWrappedObject() {
		return this;
	}
	public void setIcon(IconRenderer renderer) {
		renderer.setIcon(null);
	}
	public ViewObject getTheObject() throws ModelException {
		return null;
	}
	public void addTableModelListener(TableModelListener l) {}
	public int getRowCount() {
		return 0;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	public void removeTableModelListener(TableModelListener l) {}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
	public boolean hasTransientFields() {
		for (Object current : this.list) {
			if (((ViewRoot) current).hasTransientFields()) return true;
		}
		return false;
	}

}







@SuppressWarnings("serial")
abstract class UserRegExprSelectionPanel extends RegExprSelectionPanel {
	UserRegExprSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression regExpr) {
		super(parameterName, main, regExpr);
	}
	boolean check(){
		boolean result = this.userCheck();
		this.setOk(result);
		return result;
	}
	abstract boolean userCheck();
}

@SuppressWarnings("serial")
class RegExprSelectionPanel extends StringSelectionPanel{
	
	protected view.ExprManager manager;
	private expressions.RegularExpression regExp;

	public RegExprSelectionPanel(String parameterName, Wizard main, expressions.RegularExpression regExpr){
		super(parameterName, main);
		this.regExp = regExpr;
		this.manager = new view.ExprManager(regExpr);
		this.add(this.getSupportButton());
	}
	private JButton supportButton = null;
	private JButton getSupportButton(){
		if (this.supportButton == null){
			this.supportButton = new JButton();
			this.supportButton.setText(Wizard.SupportButtonText);
			this.supportButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					browse();
				}
			});
		}
		return this.supportButton;
	}
	protected void browse(){
		main.setPanel(getSupportPanel());
	}
	class RegExprBrowserPanel extends AbstractBrowserPanel {

		private RegExprSelectionPanel panel;
		private expressions.RegularExpression regExp;
		private String fieldName;
		public RegExprBrowserPanel(expressions.RegularExpression regExp, RegExprSelectionPanel panel, String text, String fieldName) {
			this.fieldName = fieldName;
			this.panel = panel;
			this.regExp =regExp;
			this.setPreferredSize(new java.awt.Dimension(main.getWidth(), Wizard.StandardRegExprBrowserPanelHeight));
			this.setLayout(new BorderLayout());
			this.add(this.getRegExprPanel(),BorderLayout.CENTER);
			this.add(getButtonPanel(),BorderLayout.SOUTH);
			this.getRegExprPanel().getRegExprInput().setText(text);
		}
		view.RegExprPanel regExprPanel = null;
		view.RegExprPanel getRegExprPanel(){
			if (this.regExprPanel == null){
				this.regExprPanel = new view.RegExprPanel(this.regExp, this.fieldName);
			}
			return this.regExprPanel;
		}
		private JPanel buttonPanel = null;
		private Component getButtonPanel() {
			if(buttonPanel == null){
				buttonPanel = new JPanel();
				buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
				buttonPanel.add(getFillupPanel());
				buttonPanel.add(getOKButton());
				buttonPanel.add(getCancelButton());
			}
			return buttonPanel;
		}
		private JButton cancelButton = null;
		private Component getCancelButton() {
			if (cancelButton == null){
				cancelButton = new JButton();
				cancelButton.setText(Wizard.CancelButtonText);
				cancelButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						main.resetPanel();
					}
				});
			}
			return cancelButton;
		}

		private JButton okButton = null;
		private JButton getOKButton() {
			if (okButton == null){
				okButton = new JButton();
				okButton.setText(Wizard.OKButtonText);
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						panel.setText(getRegExprPanel().getRegExprInput().getText());
						main.resetPanel();
						setVisible(false);
					}
				});
			}
			return okButton;
		}
		private JPanel fillupPanel = null;
		private JPanel getFillupPanel() {
			if(fillupPanel == null){
				fillupPanel = new JPanel();
				fillupPanel.setPreferredSize(new Dimension(2000,10));
			}
			return fillupPanel;
		}
		@Override
		public void determineFirstFocus() {
			this.getRegExprPanel().getRegExprInput().requestFocusInWindow();
		}
		@Override
		JButton getDefaultButton() {
			return this.getOKButton();
		}

	}
	private AbstractBrowserPanel getSupportPanel() {
		return new RegExprBrowserPanel(this.regExp, this, this.getStringInputTextField().getText(), this.parameterName);
	}
	protected void setText(String text) {
		this.getStringInputTextField().setText(text);
	}
	boolean check() {
		String text = getStringInputTextField().getText();
		boolean result = manager.check(text, "", false);
		this.setOk(result);
		return result;
	}
}
