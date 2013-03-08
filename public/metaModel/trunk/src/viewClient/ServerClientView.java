package viewClient;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import view.AbsQuantityView;
import view.AbsUnitTypeView;
import view.AbsUnitView;
import view.AccountManagerView;
import view.AccountTypeManagerView;
import view.AccountView;
import view.Anything;
import view.AspectManagerView;
import view.AssociationManagerView;
import view.AssociationView;
import view.ConsistencyException;
import view.CycleException;
import view.DoubleDefinitionException;
import view.FormalParameterView;
import view.HierarchyView;
import view.LinkManagerView;
import view.LinkView;
import view.MAccountTypeView;
import view.MAspectView;
import view.MAtomicTypeView;
import view.MEnumValueView;
import view.MEnumView;
import view.MMeasurementTypeView;
import view.MObjectView;
import view.MObservationTypeView;
import view.MObservationView;
import view.MTypeView;
import view.MeasurementTypeManagerView;
import view.ModelException;
import view.NameSchemeManagerView;
import view.NameSchemeView;
import view.NameView;
import view.NotComputableException;
import view.OperationManagerView;
import view.OperationView;
import view.QuantityManagerView;
import view.QuantityView;
import view.ServerView;
import view.UnitTypeManagerView;
import view.UnitTypeView;
import view.UnitView;
import view.UserException;
import view.objects.ViewRoot;

@SuppressWarnings("serial")
public class ServerClientView extends JPanel implements ExceptionAndEventHandler {

	ConnectionMaster connection;
	ExceptionAndEventHandler parent;

	private JSplitPane mainSplitPane = null;
	private JPanel treePanel = null;
	private JTreeRefresh navigationTree = null;
	private JScrollPane navigationScrollPane = null;
	private JPanel detailsPanel = null;

	private final ServerView service;

	/**
	 * This is the default constructor
	 */
	public ServerClientView(final ExceptionAndEventHandler parent, final ServerView service) {
		super();
		this.parent = parent;
		this.service = service;
		initialize();
	}

	@SuppressWarnings("unused")
	private ServerView getService() {
		return this.service;
	}

	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(getMainSplitPane(), BorderLayout.CENTER);
		final javax.swing.JToolBar mainToolBar = getMainToolBar();
		if (!WithStaticOperations && mainToolBar.getComponentCount() > 0)
			this.add(mainToolBar, BorderLayout.NORTH);
	}

	private javax.swing.JToolBar mainToolBar = null;

	private javax.swing.JToolBar getMainToolBar() {
		if (this.mainToolBar == null) {
			this.mainToolBar = new javax.swing.JToolBar();
			for (final javax.swing.JButton current : this.getToolButtonsForStaticOperations())
				this.mainToolBar.add(current);
		}
		return this.mainToolBar;
	}

	private JSplitPane getMainSplitPane() {
		if (mainSplitPane == null) {
			mainSplitPane = new JSplitPane();
			mainSplitPane.setDividerLocation(600);
			mainSplitPane.setRightComponent(getDetailsPanel());
			mainSplitPane.setLeftComponent(getNavigationSplitPane());
		}
		return mainSplitPane;
	}

	private JSplitPane navigationSplitPane = null;

	private JSplitPane getNavigationSplitPane() {
		if (this.navigationSplitPane == null) {
			this.navigationSplitPane = new JSplitPane();
			navigationSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			navigationSplitPane.setLeftComponent(getNavigationPanel());
			navigationSplitPane.setRightComponent(getErrorPanel());
			navigationSplitPane.setDividerSize(0);
		}
		return this.navigationSplitPane;
	}

	private JPanel errorPanel = null;

	private JPanel getErrorPanel() {
		if (this.errorPanel == null) {
			this.errorPanel = new JPanel();
			errorPanel.setBorder(new javax.swing.border.TitledBorder(Wizard.ErrorTitle));
			errorPanel.setLayout(new BorderLayout());
			errorPanel.add(getErrorScrollPane(), BorderLayout.CENTER);
			errorPanel.setVisible(false);
		}
		return this.errorPanel;
	}

	private JScrollPane errorScrollPane = null;

	private JScrollPane getErrorScrollPane() {
		if (this.errorScrollPane == null) {
			this.errorScrollPane = new JScrollPane();
			this.errorScrollPane.setViewportView(getErrorJTree());
		}
		return this.errorScrollPane;
	}

	private JTreeRefresh errorJTree = null;

	private JTreeRefresh getErrorJTree() {
		if (this.errorJTree == null) {
			this.errorJTree = new JTreeRefresh();
			final DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
			selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			this.errorJTree.setSelectionModel(selectionModel);
			this.errorJTree.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseReleased(final MouseEvent e) {
					tryShowContextMenu(e, errorJTree, false);
				}

				@Override
				public void mousePressed(final MouseEvent e) {
					tryShowContextMenu(e, errorJTree, false);
				}
			});
		}
		return this.errorJTree;
	}

	private void setErrors(final TreeModel errors) {
		this.getErrorPanel().setVisible(true);
		this.getErrorJTree().setModel(null);
		this.getErrorJTree().setModel(errors);
		this.getNavigationSplitPane().setDividerLocation(550.0 / 700.0);
		this.getNavigationSplitPane().setDividerSize(5);
	}

	private void setNoErrors() {
		this.getErrorPanel().setVisible(false);
		this.getNavigationSplitPane().setDividerSize(0);
	}

	private JPanel getNavigationPanel() {
		if (treePanel == null) {
			treePanel = new JPanel();
			treePanel.setBorder(new javax.swing.border.TitledBorder(Wizard.NaviationTitle));
			treePanel.setLayout(new BorderLayout());
			treePanel.add(getNavigationScrollPane(), BorderLayout.CENTER);
		}
		return treePanel;
	}

	private JPanel getDetailsPanel() {
		if (detailsPanel == null) {
			detailsPanel = new JPanel();
			detailsPanel.setBorder(new javax.swing.border.TitledBorder(Wizard.DetailsTitle));
			detailsPanel.setLayout(new BorderLayout());
			this.setDetailsTable(null);
		}
		return detailsPanel;
	}

	private JTreeRefresh getNavigationTree() {
		if (navigationTree == null) {
			navigationTree = new JTreeRefresh();
			final DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
			selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			navigationTree.setSelectionModel(selectionModel);
			navigationTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
				@Override
				public void valueChanged(final javax.swing.event.TreeSelectionEvent e) {
					final Anything selected = (Anything) getNavigationTree().getSelectedObject();
					setDetailsTable(selected);
				}
			});
			navigationTree.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseReleased(final MouseEvent e) {
					tryShowContextMenu(e, navigationTree, WithStaticOperations);
				}

				@Override
				public void mousePressed(final MouseEvent e) {
					tryShowContextMenu(e, navigationTree, WithStaticOperations);
				}
			});
		}
		return navigationTree;
	}

	private DetailPanel currentDetails = null;

	protected void setDetailsTable(Anything object) {
		this.getDetailsPanel().setVisible(false);
		if (currentDetails != null)
			this.getDetailsPanel().remove(currentDetails);
		if (object == null && this.getConnection() != null)
			object = this.getConnection().getServerView();
		if (object == null) {
			this.currentDetails = getNoDetailsPanel();
		} else {
			try {
				this.currentDetails = this.getDetailView(object);
			} catch (final ModelException e) {
				this.handleException(e);
				this.currentDetails = null;
			}
			if (this.currentDetails == null)
				this.currentDetails = getStandardDetailsTable(object);
		}
		this.getDetailsPanel().add(currentDetails, BorderLayout.CENTER);
		this.getDetailsPanel().setVisible(true);
	}

	private DetailPanel getDetailView(final Anything anything) throws ModelException {
		class PanelDecider extends view.visitor.AnythingStandardVisitor {

			private DetailPanel result;

			public DetailPanel getResult() {
				return this.result;
			}

			@Override
			protected void standardHandling(final Anything Anything) throws ModelException {
				this.result = null;
			}
			// TODO Overwrite all handle methods for the types for which you intend to provide a special panel!
		}
		final PanelDecider decider = new PanelDecider();
		anything.accept(decider);
		return decider.getResult();
	}

	private NoDetailPanel noDetailPanel = null;

	public DetailPanel getNoDetailsPanel() {
		if (noDetailPanel == null)
			noDetailPanel = new NoDetailPanel(this);
		return noDetailPanel;
	}

	protected void tryShowContextMenu(final MouseEvent e, final JTreeRefresh tree, final boolean withStaticOperations) {
		if (e.isPopupTrigger()) {
			final ViewRoot selected = tree.getSelectedObject();
			final JPopupMenu popup = this.getContextMenu(selected, withStaticOperations);
			if (popup.getComponentCount() != 0)
				popup.show(tree, e.getX(), e.getY());
		}
	}

	private JScrollPane getNavigationScrollPane() {
		if (navigationScrollPane == null) {
			navigationScrollPane = new JScrollPane();
			navigationScrollPane.setViewportView(getNavigationTree());
		}
		return navigationScrollPane;
	}

	private DetailPanel getStandardDetailsTable(final Anything object) {
		try {
			return DefaultDetailPanel.getStandardDetailPanel(object, this);
		} catch (final ModelException e) {
			this.handleException(e);
			return new NoDetailPanel(this);
		}
	}

	@Override
	public void setConnection(final ConnectionMaster connection) {
		this.connection = connection;
	}

	public ServerConnection getConnection() {
		return (ServerConnection) this.connection;
	}

	/**
	 * Is called by the refresher thread if the server object has changed
	 **/
	@Override
	public void handleRefresh() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					getNavigationTree().refresh();
					final java.util.Vector<?> errors = getConnection().getServerView().getErrors();
					if (errors.size() > 0)
						setErrors(new ListRoot(errors));
					else
						setNoErrors();
				} catch (final ModelException e) {
					handleException(e);
				}
			}
		});
		// TODO adjust implementation: handleRefresh()!
	}

	/**
	 * Is called only once after the connection has been established
	 **/
	@Override
	public void initializeConnection() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				getNavigationTree().setModel((TreeModel) getConnection().getServerView());
				getNavigationTree().setSelectionPath(
						new javax.swing.tree.TreePath(getNavigationTree().getModel().getRoot()));
			}
		});
		// TODO adjust implementation: initializeConnection
	}

	@Override
	public void handleException(final ModelException exception) {
		this.parent.handleException(exception);
	}

	@Override
	public void handleOKMessage(final String message) {
		this.parent.handleOKMessage(message);
	}

	@Override
	public void handleUserException(final UserException exception) {
		this.parent.handleUserException(exception);
	}

	/* Menu and wizard section start */

	static boolean WithStaticOperations = false;


    private java.util.Vector<javax.swing.JButton> getToolButtonsForStaticOperations() {
        java.util.Vector<javax.swing.JButton> result = new java.util.Vector<javax.swing.JButton>();
        javax.swing.JButton currentButton = null;
        currentButton = new javax.swing.JButton("Enum erstellen ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateEnumStringMssgWizard wizard = new ServerCreateEnumStringMssgWizard("Enum erstellen");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("Observation Type erstellen ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateObsTypeStringMEnumMTypeMssgWizard wizard = new ServerCreateObsTypeStringMEnumMTypeMssgWizard("Observation Type erstellen");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("createTypeConjunction ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateTypeConjunctionMTypeLSTMssgWizard wizard = new ServerCreateTypeConjunctionMTypeLSTMssgWizard("createTypeConjunction");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        currentButton = new javax.swing.JButton("createTypeDisjunction ... ");
        currentButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateTypeDisjunctionMTypeLSTMssgWizard wizard = new ServerCreateTypeDisjunctionMTypeLSTMssgWizard("createTypeDisjunction");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });result.add(currentButton);
        return result;
    }
    private JPopupMenu getContextMenu(final ViewRoot selected, final boolean withStaticOperations) {
        JPopupMenu result = new JPopupMenu();
        javax.swing.JMenuItem item = null;
        item = new javax.swing.JMenuItem();
        item.setText("(S) Enum erstellen ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateEnumStringMssgWizard wizard = new ServerCreateEnumStringMssgWizard("Enum erstellen");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) Observation Type erstellen ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateObsTypeStringMEnumMTypeMssgWizard wizard = new ServerCreateObsTypeStringMEnumMTypeMssgWizard("Observation Type erstellen");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) createTypeConjunction ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateTypeConjunctionMTypeLSTMssgWizard wizard = new ServerCreateTypeConjunctionMTypeLSTMssgWizard("createTypeConjunction");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        item = new javax.swing.JMenuItem();
        item.setText("(S) createTypeDisjunction ... ");
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ServerCreateTypeDisjunctionMTypeLSTMssgWizard wizard = new ServerCreateTypeDisjunctionMTypeLSTMssgWizard("createTypeDisjunction");
                wizard.pack();
                wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                wizard.pack();
                wizard.setLocationRelativeTo(getNavigationPanel());
                wizard.setVisible(true);
            }
            
        });
        if (withStaticOperations) result.add(item);
        if (selected != null){
            if (selected instanceof MEnumView){
                item = new javax.swing.JMenuItem();
                item.setText("Enum Wert erstellen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateEnumValueMEnumStringMssgWizard wizard = new ServerCreateEnumValueMEnumStringMssgWizard("Enum Wert erstellen");
                        wizard.setFirstArgument((MEnumView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Enum löschen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Enum löschen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().deleteEnum((MEnumView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof OperationView){
                item = new javax.swing.JMenuItem();
                item.setText("addFormalParameter ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddFpOperationFormalParameterMssgWizard wizard = new ServerAddFpOperationFormalParameterMssgWizard("addFormalParameter");
                        wizard.setFirstArgument((OperationView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeFormalParameter ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerRemoveFpFromOpOperationFormalParameterMssgWizard wizard = new ServerRemoveFpFromOpOperationFormalParameterMssgWizard("removeFormalParameter");
                        wizard.setFirstArgument((OperationView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeOperation");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeOperation" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeOperation((OperationView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MEnumValueView){
                item = new javax.swing.JMenuItem();
                item.setText("Enum Wert löschen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Enum Wert löschen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().deleteEnumValue((MEnumValueView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AssociationView){
                item = new javax.swing.JMenuItem();
                item.setText("addToHierarchy ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddToHierarchyAssociationHierarchyMssgWizard wizard = new ServerAddToHierarchyAssociationHierarchyMssgWizard("addToHierarchy");
                        wizard.setFirstArgument((AssociationView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createHierarchy ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateHierarchyAssociationStringMssgWizard wizard = new ServerCreateHierarchyAssociationStringMssgWizard("createHierarchy");
                        wizard.setFirstArgument((AssociationView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeAssociation");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeAssociation" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeAssociation((AssociationView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MObservationTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("Observation Type löschen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Observation Type löschen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().deleteObsType((MObservationTypeView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Observation erstellen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateObservationMObservationTypeStringMObjectMEnumValueMssgWizard wizard = new ServerCreateObservationMObservationTypeStringMObjectMEnumValueMssgWizard("Observation erstellen");
                        wizard.setFirstArgument((MObservationTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof FormalParameterView){
                item = new javax.swing.JMenuItem();
                item.setText("removeFormalParameter");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeFormalParameter" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeFp((FormalParameterView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof QuantityManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Create quantity ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateQuantityQuantityManagerAbsUnitFractionMssgWizard wizard = new ServerCreateQuantityQuantityManagerAbsUnitFractionMssgWizard("Create quantity");
                        wizard.setFirstArgument((QuantityManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AbsUnitTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("addReferenceType ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddReferenceTypeAbsUnitTypeStringUnitTypeIntegerMssgWizard wizard = new ServerAddReferenceTypeAbsUnitTypeStringUnitTypeIntegerMssgWizard("addReferenceType");
                        wizard.setFirstArgument((AbsUnitTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeUnitType");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeUnitType" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeUnitType((AbsUnitTypeView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AccountView){
                item = new javax.swing.JMenuItem();
                item.setText("Eintrag anlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateEntryAccountMObjectMMeasurementTypeQuantityMssgWizard wizard = new ServerCreateEntryAccountMObjectMMeasurementTypeQuantityMssgWizard("Eintrag anlegen");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Konto unterordnen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddSubAccountAccountAccountMssgWizard wizard = new ServerAddSubAccountAccountAccountMssgWizard("Konto unterordnen");
                        wizard.setFirstArgument((AccountView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof OperationManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("createConstant ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateConstantOperationManagerStringMTypeMssgWizard wizard = new ServerCreateConstantOperationManagerStringMTypeMssgWizard("createConstant");
                        wizard.setFirstArgument((OperationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createFormalParameter ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateFpOperationManagerStringMTypeMssgWizard wizard = new ServerCreateFpOperationManagerStringMTypeMssgWizard("createFormalParameter");
                        wizard.setFirstArgument((OperationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createOperation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateOperationOperationManagerMTypeMTypeStringFormalParameterLSTMssgWizard wizard = new ServerCreateOperationOperationManagerMTypeMTypeStringFormalParameterLSTMssgWizard("createOperation");
                        wizard.setFirstArgument((OperationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createStaticOp ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateStaticOpOperationManagerStringMTypeFormalParameterLSTMssgWizard wizard = new ServerCreateStaticOpOperationManagerStringMTypeFormalParameterLSTMssgWizard("createStaticOp");
                        wizard.setFirstArgument((OperationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createVoidOperation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateVoidOperationOperationManagerMTypeStringFormalParameterLSTMssgWizard wizard = new ServerCreateVoidOperationOperationManagerMTypeStringFormalParameterLSTMssgWizard("createVoidOperation");
                        wizard.setFirstArgument((OperationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof NameSchemeManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Namensschema erstellen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateNameSchemeNameSchemeManagerStringStringMBooleanSUBTYPENameMssgWizard wizard = new ServerCreateNameSchemeNameSchemeManagerStringStringMBooleanSUBTYPENameMssgWizard("Namensschema erstellen");
                        wizard.setFirstArgument((NameSchemeManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof UnitView){
                item = new javax.swing.JMenuItem();
                item.setText("setConversion ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerSetConversionUnitFractionFractionMssgWizard wizard = new ServerSetConversionUnitFractionFractionMssgWizard("setConversion");
                        wizard.setFirstArgument((UnitView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof UnitTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("Create unit ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateUnitUnitTypeStringMssgWizard wizard = new ServerCreateUnitUnitTypeStringMssgWizard("Create unit");
                        wizard.setFirstArgument((UnitTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("setDefaultUnit ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerSetDefaultUnitUnitTypeUnitMssgWizard wizard = new ServerSetDefaultUnitUnitTypeUnitMssgWizard("setDefaultUnit");
                        wizard.setFirstArgument((UnitTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AssociationManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("createAssociation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAssociationAssociationManagerMTypeMTypeStringMssgWizard wizard = new ServerCreateAssociationAssociationManagerMTypeMTypeStringMssgWizard("createAssociation");
                        wizard.setFirstArgument((AssociationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createHierarchy ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateHierarchyAssociationManagerAssociationStringMssgWizard wizard = new ServerCreateHierarchyAssociationManagerAssociationStringMssgWizard("createHierarchy");
                        wizard.setFirstArgument((AssociationManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MeasurementTypeManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Messungstyp anlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateMeasurementTypeMeasurementTypeManagerStringMTypeUnitTypeMssgWizard wizard = new ServerCreateMeasurementTypeMeasurementTypeManagerStringMTypeUnitTypeMssgWizard("Messungstyp anlegen");
                        wizard.setFirstArgument((MeasurementTypeManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AbsQuantityView){
                item = new javax.swing.JMenuItem();
                item.setText("add ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddAbsQuantityAbsQuantityMssgWizard wizard = new ServerAddAbsQuantityAbsQuantityMssgWizard("add");
                        wizard.setFirstArgument((AbsQuantityView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("div ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerDivAbsQuantityAbsQuantityMssgWizard wizard = new ServerDivAbsQuantityAbsQuantityMssgWizard("div");
                        wizard.setFirstArgument((AbsQuantityView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("mul ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerMulAbsQuantityAbsQuantityMssgWizard wizard = new ServerMulAbsQuantityAbsQuantityMssgWizard("mul");
                        wizard.setFirstArgument((AbsQuantityView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("sub ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerSubAbsQuantityAbsQuantityMssgWizard wizard = new ServerSubAbsQuantityAbsQuantityMssgWizard("sub");
                        wizard.setFirstArgument((AbsQuantityView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AccountTypeManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Kontotyp anlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAccountTypeAccountTypeManagerStringMTypeUnitTypeMssgWizard wizard = new ServerCreateAccountTypeAccountTypeManagerStringMTypeUnitTypeMssgWizard("Kontotyp anlegen");
                        wizard.setFirstArgument((AccountTypeManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof LinkManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("createLink ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateLinkLinkManagerAssociationMObjectMObjectMssgWizard wizard = new ServerCreateLinkLinkManagerAssociationMObjectMObjectMssgWizard("createLink");
                        wizard.setFirstArgument((LinkManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MObjectView){
                item = new javax.swing.JMenuItem();
                item.setText("Benennen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAssignNameMObjectNameStringMssgWizard wizard = new ServerAssignNameMObjectNameStringMssgWizard("Benennen");
                        wizard.setFirstArgument((MObjectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Typen entfernen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerRemoveTypeMObjectMAtomicTypeMssgWizard wizard = new ServerRemoveTypeMObjectMAtomicTypeMssgWizard("Typen entfernen");
                        wizard.setFirstArgument((MObjectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Typen ersetzen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerReplaceTypeMObjectMAtomicTypeMAtomicTypeMssgWizard wizard = new ServerReplaceTypeMObjectMAtomicTypeMAtomicTypeMssgWizard("Typen ersetzen");
                        wizard.setFirstArgument((MObjectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Typen hinzuf?gen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddTypeMObjectMAtomicTypeMssgWizard wizard = new ServerAddTypeMObjectMAtomicTypeMssgWizard("Typen hinzuf?gen");
                        wizard.setFirstArgument((MObjectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createLink ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateLinkMObjectAssociationMObjectMssgWizard wizard = new ServerCreateLinkMObjectAssociationMObjectMssgWizard("createLink");
                        wizard.setFirstArgument((MObjectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MObservationView){
                item = new javax.swing.JMenuItem();
                item.setText("Observation löschen");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "Observation löschen" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().deleteObservation((MObservationView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof HierarchyView){
                item = new javax.swing.JMenuItem();
                item.setText("addAssociation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddAssociationHierarchyAssociationMssgWizard wizard = new ServerAddAssociationHierarchyAssociationMssgWizard("addAssociation");
                        wizard.setFirstArgument((HierarchyView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeFromHierarchy ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerRemoveFromHierarchyHierarchyAssociationMssgWizard wizard = new ServerRemoveFromHierarchyHierarchyAssociationMssgWizard("removeFromHierarchy");
                        wizard.setFirstArgument((HierarchyView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeHierarchy");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeHierarchy" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeHierarchy((HierarchyView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MAccountTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("Kontotyp unterordnen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddSubAccountTypeMAccountTypeMAccountTypeMssgWizard wizard = new ServerAddSubAccountTypeMAccountTypeMAccountTypeMssgWizard("Kontotyp unterordnen");
                        wizard.setFirstArgument((MAccountTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof QuantityView){
                item = new javax.swing.JMenuItem();
                item.setText("convertToDefault");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "convertToDefault" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().convertToDefault((QuantityView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("convert ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerConvertQuantityAbsUnitMssgWizard wizard = new ServerConvertQuantityAbsUnitMssgWizard("convert");
                        wizard.setFirstArgument((QuantityView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("createOperation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateOperationMTypeMTypeStringFormalParameterLSTMssgWizard wizard = new ServerCreateOperationMTypeMTypeStringFormalParameterLSTMssgWizard("createOperation");
                        wizard.setFirstArgument((MTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createVoidOperation ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateVoidOperationMTypeStringFormalParameterLSTMssgWizard wizard = new ServerCreateVoidOperationMTypeStringFormalParameterLSTMssgWizard("createVoidOperation");
                        wizard.setFirstArgument((MTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof UnitTypeManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Create unit type ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateUnitTypeUnitTypeManagerStringMssgWizard wizard = new ServerCreateUnitTypeUnitTypeManagerStringMssgWizard("Create unit type");
                        wizard.setFirstArgument((UnitTypeManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("fetchScalarType");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "fetchScalarType" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().fetchScalarType((UnitTypeManagerView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("fetchScalar");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "fetchScalar" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().fetchScalar((UnitTypeManagerView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AbsUnitView){
                item = new javax.swing.JMenuItem();
                item.setText("addReference ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAddReferenceAbsUnitStringUnitIntegerMssgWizard wizard = new ServerAddReferenceAbsUnitStringUnitIntegerMssgWizard("addReference");
                        wizard.setFirstArgument((AbsUnitView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("removeUnit");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeUnit" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeUnit((AbsUnitView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AspectManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("createAspect ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAspectAspectManagerStringMssgWizard wizard = new ServerCreateAspectAspectManagerStringMssgWizard("createAspect");
                        wizard.setFirstArgument((AspectManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof NameSchemeView){
                item = new javax.swing.JMenuItem();
                item.setText("Typen zuordnen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAssignTypeNameSchemeMAtomicTypeMssgWizard wizard = new ServerAssignTypeNameSchemeMAtomicTypeMssgWizard("Typen zuordnen");
                        wizard.setFirstArgument((NameSchemeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MAtomicTypeView){
                item = new javax.swing.JMenuItem();
                item.setText("Exemplar erstellen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateMObjectMAtomicTypeMAtomicTypeLSTMssgWizard wizard = new ServerCreateMObjectMAtomicTypeMAtomicTypeLSTMssgWizard("Exemplar erstellen");
                        wizard.setFirstArgument((MAtomicTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("Namensschema zuordnen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerAssignNameSchemeMAtomicTypeNameSchemeMssgWizard wizard = new ServerAssignNameSchemeMAtomicTypeNameSchemeMssgWizard("Namensschema zuordnen");
                        wizard.setFirstArgument((MAtomicTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("changeAbstract ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerChangeAbstractMAtomicTypeMBooleanSUBTYPENameMssgWizard wizard = new ServerChangeAbstractMAtomicTypeMBooleanSUBTYPENameMssgWizard("changeAbstract");
                        wizard.setFirstArgument((MAtomicTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
                item = new javax.swing.JMenuItem();
                item.setText("createAtomicSubType ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAtomicSubTypeMAtomicTypeStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard wizard = new ServerCreateAtomicSubTypeMAtomicTypeStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard("createAtomicSubType");
                        wizard.setFirstArgument((MAtomicTypeView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof LinkView){
                item = new javax.swing.JMenuItem();
                item.setText("removeLink");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        if (javax.swing.JOptionPane.showConfirmDialog(getNavigationPanel(), "removeLink" + Wizard.ConfirmQuestionMark, "Bestätigen", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null) == javax.swing.JOptionPane.YES_OPTION){
                            try {
                                getConnection().removeLink((LinkView)selected);
                                getConnection().setEagerRefresh();
                            }catch(ModelException me){
                                handleException(me);
                            }
                        }
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof MAspectView){
                item = new javax.swing.JMenuItem();
                item.setText("createAtomicRootType ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAtomicRootTypeMAspectStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard wizard = new ServerCreateAtomicRootTypeMAspectStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard("createAtomicRootType");
                        wizard.setFirstArgument((MAspectView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            if (selected instanceof AccountManagerView){
                item = new javax.swing.JMenuItem();
                item.setText("Konto anlegen ... ");
                item.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        ServerCreateAccountAccountManagerStringMAccountTypeMObjectMssgWizard wizard = new ServerCreateAccountAccountManagerStringMAccountTypeMObjectMssgWizard("Konto anlegen");
                        wizard.setFirstArgument((AccountManagerView)selected);
                        wizard.pack();
                        wizard.setPreferredSize(new java.awt.Dimension(getNavigationPanel().getWidth(), wizard.getHeight()));
                        wizard.pack();
                        wizard.setLocationRelativeTo(getNavigationPanel());
                        wizard.setVisible(true);
                    }
                    
                });
                result.add(item);
            }
            
        }
        
        this.addNotGeneratedItems(result,selected);
        return result;
    }
    
	class ServerAddAssociationHierarchyAssociationMssgWizard extends Wizard {

		protected ServerAddAssociationHierarchyAssociationMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddAssociationHierarchyAssociationMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addAssociation(firstArgument, (AssociationView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("a", "view.AssociationView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private HierarchyView firstArgument; 
	
		public void setFirstArgument(HierarchyView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddFpOperationFormalParameterMssgWizard extends Wizard {

		protected ServerAddFpOperationFormalParameterMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddFpOperationFormalParameterMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addFp(firstArgument, (FormalParameterView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("fp", "view.FormalParameterView", new ListRoot(getConnection().fp_Path_In_AddFp()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationView firstArgument; 
	
		public void setFirstArgument(OperationView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddReferenceTypeAbsUnitTypeStringUnitTypeIntegerMssgWizard extends Wizard {

		protected ServerAddReferenceTypeAbsUnitTypeStringUnitTypeIntegerMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddReferenceTypeAbsUnitTypeStringUnitTypeIntegerMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addReferenceType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(UnitTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getComponent(2)).getResult().longValue());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("referenceUnitType", "view.UnitTypeView", new ListRoot(getConnection().referenceUnitType_Path_In_AddReferenceType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new IntegerSelectionPanel("exponent", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsUnitTypeView firstArgument; 
	
		public void setFirstArgument(AbsUnitTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerAddReferenceAbsUnitStringUnitIntegerMssgWizard extends Wizard {

		protected ServerAddReferenceAbsUnitStringUnitIntegerMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddReferenceAbsUnitStringUnitIntegerMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addReference(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(UnitView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((IntegerSelectionPanel)getParametersPanel().getComponent(2)).getResult().longValue());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("referenceUnit", "view.UnitView", new ListRoot(getConnection().referenceUnit_Path_In_AddReference()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new IntegerSelectionPanel("exponent", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsUnitView firstArgument; 
	
		public void setFirstArgument(AbsUnitView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerAddSubAccountTypeMAccountTypeMAccountTypeMssgWizard extends Wizard {

		protected ServerAddSubAccountTypeMAccountTypeMAccountTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddSubAccountTypeMAccountTypeMAccountTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addSubAccountType(firstArgument, (MAccountTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(CycleException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("child", "view.MAccountTypeView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAccountTypeView firstArgument; 
	
		public void setFirstArgument(MAccountTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddSubAccountAccountAccountMssgWizard extends Wizard {

		protected ServerAddSubAccountAccountAccountMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddSubAccountAccountAccountMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addSubAccount(firstArgument, (AccountView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(CycleException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("child", "view.AccountView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddToHierarchyAssociationHierarchyMssgWizard extends Wizard {

		protected ServerAddToHierarchyAssociationHierarchyMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddToHierarchyAssociationHierarchyMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addToHierarchy(firstArgument, (HierarchyView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("theHierarchy", "view.HierarchyView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AssociationView firstArgument; 
	
		public void setFirstArgument(AssociationView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddTypeMObjectMAtomicTypeMssgWizard extends Wizard {

		protected ServerAddTypeMObjectMAtomicTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddTypeMObjectMAtomicTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().addType(firstArgument, (MAtomicTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("newType", "view.MAtomicTypeView", new ListRoot(getConnection().newType_Path_In_AddType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MObjectView firstArgument; 
	
		public void setFirstArgument(MObjectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAddAbsQuantityAbsQuantityMssgWizard extends Wizard {

		protected ServerAddAbsQuantityAbsQuantityMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAddAbsQuantityAbsQuantityMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().add(firstArgument, (AbsQuantityView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(NotComputableException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("summand2", "view.AbsQuantityView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsQuantityView firstArgument; 
	
		public void setFirstArgument(AbsQuantityView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAssignNameSchemeMAtomicTypeNameSchemeMssgWizard extends Wizard {

		protected ServerAssignNameSchemeMAtomicTypeNameSchemeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAssignNameSchemeMAtomicTypeNameSchemeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().assignNameScheme(firstArgument, (NameSchemeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("scheme", "view.NameSchemeView", new ListRoot(getConnection().scheme_Path_In_AssignNameScheme()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAtomicTypeView firstArgument; 
	
		public void setFirstArgument(MAtomicTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAssignNameMObjectNameStringMssgWizard extends Wizard {

		protected ServerAssignNameMObjectNameStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAssignNameMObjectNameStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().assignName(firstArgument, (NameView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("scheme", "view.NameView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().scheme_Path_In_AssignName((MObjectView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}});
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getComponent(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private MObjectView firstArgument; 
	
		public void setFirstArgument(MObjectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerAssignTypeNameSchemeMAtomicTypeMssgWizard extends Wizard {

		protected ServerAssignTypeNameSchemeMAtomicTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerAssignTypeNameSchemeMAtomicTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().assignType(firstArgument, (MAtomicTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("type", "view.MAtomicTypeView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private NameSchemeView firstArgument; 
	
		public void setFirstArgument(NameSchemeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerChangeAbstractMAtomicTypeMBooleanSUBTYPENameMssgWizard extends Wizard {

		protected ServerChangeAbstractMAtomicTypeMBooleanSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerChangeAbstractMAtomicTypeMBooleanSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().changeAbstract(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new RegExprSelectionPanel("newAbstractType", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAtomicTypeView firstArgument; 
	
		public void setFirstArgument(MAtomicTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerConvertQuantityAbsUnitMssgWizard extends Wizard {

		protected ServerConvertQuantityAbsUnitMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerConvertQuantityAbsUnitMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().convert(firstArgument, (AbsUnitView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("unit", "view.AbsUnitView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private QuantityView firstArgument; 
	
		public void setFirstArgument(QuantityView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset((Anything)firstArgument.getUnit());
				if (!selectionPanel.check()) selectionPanel.preset((Anything)null);
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateAccountTypeAccountTypeManagerStringMTypeUnitTypeMssgWizard extends Wizard {

		protected ServerCreateAccountTypeAccountTypeManagerStringMTypeUnitTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAccountTypeAccountTypeManagerStringMTypeUnitTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAccountType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(UnitTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("type", "view.MTypeView", new ListRoot(getConnection().type_Path_In_CreateAccountType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("unitType", "view.UnitTypeView", new ListRoot(getConnection().unitType_Path_In_CreateAccountType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountTypeManagerView firstArgument; 
	
		public void setFirstArgument(AccountTypeManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateAccountAccountManagerStringMAccountTypeMObjectMssgWizard extends Wizard {

		protected ServerCreateAccountAccountManagerStringMAccountTypeMObjectMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAccountAccountManagerStringMAccountTypeMObjectMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAccount(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MAccountTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("type", "view.MAccountTypeView", new ListRoot(getConnection().type_Path_In_CreateAccount()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new ObjectSelectionPanel("object", "view.MObjectView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountManagerView firstArgument; 
	
		public void setFirstArgument(AccountManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateAspectAspectManagerStringMssgWizard extends Wizard {

		protected ServerCreateAspectAspectManagerStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAspectAspectManagerStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAspect(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AspectManagerView firstArgument; 
	
		public void setFirstArgument(AspectManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateAssociationAssociationManagerMTypeMTypeStringMssgWizard extends Wizard {

		protected ServerCreateAssociationAssociationManagerMTypeMTypeStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAssociationAssociationManagerMTypeMTypeStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAssociation(firstArgument, (MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("source", "view.MTypeView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new ObjectSelectionPanel("target", "view.MTypeView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AssociationManagerView firstArgument; 
	
		public void setFirstArgument(AssociationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateAtomicRootTypeMAspectStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard extends Wizard {

		protected ServerCreateAtomicRootTypeMAspectStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAtomicRootTypeMAspectStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAtomicRootType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("typeName", this));
			getParametersPanel().add(new RegExprSelectionPanel("singletonType", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));
			getParametersPanel().add(new RegExprSelectionPanel("abstractType", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAspectView firstArgument; 
	
		public void setFirstArgument(MAspectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateAtomicSubTypeMAtomicTypeStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard extends Wizard {

		protected ServerCreateAtomicSubTypeMAtomicTypeStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateAtomicSubTypeMAtomicTypeStringMBooleanSUBTYPENameMBooleanSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createAtomicSubType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("typeName", this));
			getParametersPanel().add(new RegExprSelectionPanel("singletonType", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));
			getParametersPanel().add(new RegExprSelectionPanel("abstractType", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAtomicTypeView firstArgument; 
	
		public void setFirstArgument(MAtomicTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateConstantOperationManagerStringMTypeMssgWizard extends Wizard {

		protected ServerCreateConstantOperationManagerStringMTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateConstantOperationManagerStringMTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createConstant(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MTypeView", new ListRoot(getConnection().target_Path_In_CreateConstant()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationManagerView firstArgument; 
	
		public void setFirstArgument(OperationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateEntryAccountMObjectMMeasurementTypeQuantityMssgWizard extends Wizard {

		protected ServerCreateEntryAccountMObjectMMeasurementTypeQuantityMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateEntryAccountMObjectMMeasurementTypeQuantityMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createEntry(firstArgument, (MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MMeasurementTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(QuantityView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(ConsistencyException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("object", "view.MObjectView", new ListRoot(getConnection().object_Path_In_CreateEntry()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("measurementType", "view.MMeasurementTypeView", new ListRoot(getConnection().measurementType_Path_In_CreateEntry()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("quantity", "view.QuantityView", new ListRoot(getConnection().quantity_Path_In_CreateEntry()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AccountView firstArgument; 
	
		public void setFirstArgument(AccountView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset((Anything)firstArgument.getObject());
				if (!selectionPanel.check()) selectionPanel.preset((Anything)null);
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateEnumValueMEnumStringMssgWizard extends Wizard {

		protected ServerCreateEnumValueMEnumStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateEnumValueMEnumStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createEnumValue(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MEnumView firstArgument; 
	
		public void setFirstArgument(MEnumView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateEnumStringMssgWizard extends Wizard {

		protected ServerCreateEnumStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateEnumStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createEnum(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class ServerCreateFpOperationManagerStringMTypeMssgWizard extends Wizard {

		protected ServerCreateFpOperationManagerStringMTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateFpOperationManagerStringMTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createFp(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("ofType", "view.MTypeView", new ListRoot(getConnection().ofType_Path_In_CreateFp()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationManagerView firstArgument; 
	
		public void setFirstArgument(OperationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateHierarchyAssociationManagerAssociationStringMssgWizard extends Wizard {

		protected ServerCreateHierarchyAssociationManagerAssociationStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateHierarchyAssociationManagerAssociationStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createHierarchy(firstArgument, (AssociationView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("a", "view.AssociationView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AssociationManagerView firstArgument; 
	
		public void setFirstArgument(AssociationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateHierarchyAssociationStringMssgWizard extends Wizard {

		protected ServerCreateHierarchyAssociationStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateHierarchyAssociationStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createHierarchy(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AssociationView firstArgument; 
	
		public void setFirstArgument(AssociationView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateLinkLinkManagerAssociationMObjectMObjectMssgWizard extends Wizard {

		protected ServerCreateLinkLinkManagerAssociationMObjectMObjectMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateLinkLinkManagerAssociationMObjectMObjectMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createLink(firstArgument, (AssociationView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("type", "view.AssociationView", new ListRoot(getConnection().type_Path_In_CreateLink()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("source", "view.MObjectView", new ListRoot(getConnection().source_Path_In_CreateLink()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MObjectView", new ListRoot(getConnection().target_Path_In_CreateLink()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private LinkManagerView firstArgument; 
	
		public void setFirstArgument(LinkManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateLinkMObjectAssociationMObjectMssgWizard extends Wizard {

		protected ServerCreateLinkMObjectAssociationMObjectMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateLinkMObjectAssociationMObjectMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createLink(firstArgument, (AssociationView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("type", "view.AssociationView", new ListRoot(getConnection().type_Path_In_CreateLink()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MObjectView", new ListRoot(getConnection().target_Path_In_CreateLink()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MObjectView firstArgument; 
	
		public void setFirstArgument(MObjectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateMObjectMAtomicTypeMAtomicTypeLSTMssgWizard extends Wizard {

		protected ServerCreateMObjectMAtomicTypeMAtomicTypeLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateMObjectMAtomicTypeMAtomicTypeLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createMObject(firstArgument, (java.util.Vector<MAtomicTypeView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("otherTypes", "view.MAtomicTypeView", new ListRoot(getConnection().otherTypes_Path_In_CreateMObject()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MAtomicTypeView firstArgument; 
	
		public void setFirstArgument(MAtomicTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateMeasurementTypeMeasurementTypeManagerStringMTypeUnitTypeMssgWizard extends Wizard {

		protected ServerCreateMeasurementTypeMeasurementTypeManagerStringMTypeUnitTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateMeasurementTypeMeasurementTypeManagerStringMTypeUnitTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createMeasurementType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(UnitTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("type", "view.MTypeView", new ListRoot(getConnection().type_Path_In_CreateMeasurementType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("unitType", "view.UnitTypeView", new ListRoot(getConnection().unitType_Path_In_CreateMeasurementType()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MeasurementTypeManagerView firstArgument; 
	
		public void setFirstArgument(MeasurementTypeManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateNameSchemeNameSchemeManagerStringStringMBooleanSUBTYPENameMssgWizard extends Wizard {

		protected ServerCreateNameSchemeNameSchemeManagerStringStringMBooleanSUBTYPENameMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateNameSchemeNameSchemeManagerStringStringMBooleanSUBTYPENameMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createNameScheme(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("schemeName", this));
			getParametersPanel().add(new StringSelectionPanel("regExp", this));
			getParametersPanel().add(new RegExprSelectionPanel("isIterable", this, common.RegularExpressionManager.mBooleanSUBTYPEName.getRegExpr()));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private NameSchemeManagerView firstArgument; 
	
		public void setFirstArgument(NameSchemeManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateObsTypeStringMEnumMTypeMssgWizard extends Wizard {

		protected ServerCreateObsTypeStringMEnumMTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateObsTypeStringMEnumMTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createObsType(((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MEnumView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			getParametersPanel().add(new ObjectSelectionPanel("enumType", "view.MEnumView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new ObjectSelectionPanel("theType", "view.MTypeView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class ServerCreateObservationMObservationTypeStringMObjectMEnumValueMssgWizard extends Wizard {

		protected ServerCreateObservationMObservationTypeStringMObjectMEnumValueMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateObservationMObservationTypeStringMObjectMEnumValueMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createObservation(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MObjectView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(MEnumValueView)((ObjectSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			getParametersPanel().add(new ObjectSelectionPanel("theObsObject", "view.MObjectView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new ObjectSelectionPanel("enumValue", "view.MEnumValueView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MObservationTypeView firstArgument; 
	
		public void setFirstArgument(MObservationTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateOperationMTypeMTypeStringFormalParameterLSTMssgWizard extends Wizard {

		protected ServerCreateOperationMTypeMTypeStringFormalParameterLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateOperationMTypeMTypeStringFormalParameterLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createOperation(firstArgument, (MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(java.util.Vector<FormalParameterView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MTypeView", new ListRoot(getConnection().target_Path_In_CreateOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("fp", "view.FormalParameterView", new ListRoot(getConnection().fp_Path_In_CreateOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MTypeView firstArgument; 
	
		public void setFirstArgument(MTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateOperationOperationManagerMTypeMTypeStringFormalParameterLSTMssgWizard extends Wizard {

		protected ServerCreateOperationOperationManagerMTypeMTypeStringFormalParameterLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateOperationOperationManagerMTypeMTypeStringFormalParameterLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createOperation(firstArgument, (MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(2)).getResult(),
									(java.util.Vector<FormalParameterView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(3)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("source", "view.MTypeView", new ListRoot(getConnection().source_Path_In_CreateOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MTypeView", new ListRoot(getConnection().target_Path_In_CreateOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("fp", "view.FormalParameterView", new ListRoot(getConnection().fp_Path_In_CreateOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationManagerView firstArgument; 
	
		public void setFirstArgument(OperationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateQuantityQuantityManagerAbsUnitFractionMssgWizard extends Wizard {

		protected ServerCreateQuantityQuantityManagerAbsUnitFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateQuantityQuantityManagerAbsUnitFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createQuantity(firstArgument, (AbsUnitView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("unit", "view.AbsUnitView", (ViewRoot) getConnection().getServerView(), this));
			getParametersPanel().add(new FractionSelectionPanel("f", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private QuantityManagerView firstArgument; 
	
		public void setFirstArgument(QuantityManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateStaticOpOperationManagerStringMTypeFormalParameterLSTMssgWizard extends Wizard {

		protected ServerCreateStaticOpOperationManagerStringMTypeFormalParameterLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateStaticOpOperationManagerStringMTypeFormalParameterLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createStaticOp(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(java.util.Vector<FormalParameterView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectSelectionPanel("target", "view.MTypeView", new ListRoot(getConnection().target_Path_In_CreateStaticOp()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("fp", "view.FormalParameterView", new ListRoot(getConnection().fp_Path_In_CreateStaticOp()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationManagerView firstArgument; 
	
		public void setFirstArgument(OperationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateTypeConjunctionMTypeLSTMssgWizard extends Wizard {

		protected ServerCreateTypeConjunctionMTypeLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateTypeConjunctionMTypeLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createTypeConjunction((java.util.Vector<MTypeView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("containees", "view.MTypeView", new ListRoot(getConnection().containees_Path_In_CreateTypeConjunction()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class ServerCreateTypeDisjunctionMTypeLSTMssgWizard extends Wizard {

		protected ServerCreateTypeDisjunctionMTypeLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateTypeDisjunctionMTypeLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createTypeDisjunction((java.util.Vector<MTypeView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("containees", "view.MTypeView", new ListRoot(getConnection().containees_Path_In_CreateTypeDisjunction()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
	}

	class ServerCreateUnitTypeUnitTypeManagerStringMssgWizard extends Wizard {

		protected ServerCreateUnitTypeUnitTypeManagerStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateUnitTypeUnitTypeManagerStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createUnitType(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitTypeManagerView firstArgument; 
	
		public void setFirstArgument(UnitTypeManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateUnitUnitTypeStringMssgWizard extends Wizard {

		protected ServerCreateUnitUnitTypeStringMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateUnitUnitTypeStringMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createUnit(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitTypeView firstArgument; 
	
		public void setFirstArgument(UnitTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset(firstArgument.getName());
				if (!selectionPanel.check()) selectionPanel.preset("");
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerCreateVoidOperationMTypeStringFormalParameterLSTMssgWizard extends Wizard {

		protected ServerCreateVoidOperationMTypeStringFormalParameterLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateVoidOperationMTypeStringFormalParameterLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createVoidOperation(firstArgument, ((StringSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(java.util.Vector<FormalParameterView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new StringSelectionPanel("name", this));
			try{
				getParametersPanel().add(new ObjectCollectionSelectionPanel("fp", "view.FormalParameterView", new ListRoot(getConnection().fp_Path_In_CreateVoidOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private MTypeView firstArgument; 
	
		public void setFirstArgument(MTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerCreateVoidOperationOperationManagerMTypeStringFormalParameterLSTMssgWizard extends Wizard {

		protected ServerCreateVoidOperationOperationManagerMTypeStringFormalParameterLSTMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerCreateVoidOperationOperationManagerMTypeStringFormalParameterLSTMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().createVoidOperation(firstArgument, (MTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((StringSelectionPanel)getParametersPanel().getComponent(1)).getResult(),
									(java.util.Vector<FormalParameterView>)((ObjectCollectionSelectionPanel)getParametersPanel().getComponent(2)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("source", "view.MTypeView", new ListRoot(getConnection().source_Path_In_CreateVoidOperation()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }
			getParametersPanel().add(new StringSelectionPanel("name", this));
			getParametersPanel().add(new ObjectCollectionSelectionPanel("fp", "view.FormalParameterView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationManagerView firstArgument; 
	
		public void setFirstArgument(OperationManagerView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerDivAbsQuantityAbsQuantityMssgWizard extends Wizard {

		protected ServerDivAbsQuantityAbsQuantityMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerDivAbsQuantityAbsQuantityMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().div(firstArgument, (AbsQuantityView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(NotComputableException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("divisor", "view.AbsQuantityView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsQuantityView firstArgument; 
	
		public void setFirstArgument(AbsQuantityView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerMulAbsQuantityAbsQuantityMssgWizard extends Wizard {

		protected ServerMulAbsQuantityAbsQuantityMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerMulAbsQuantityAbsQuantityMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().mul(firstArgument, (AbsQuantityView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(DoubleDefinitionException e) {
				getStatusBar().setText(e.getMessage());
			}
			catch(NotComputableException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("factor2", "view.AbsQuantityView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsQuantityView firstArgument; 
	
		public void setFirstArgument(AbsQuantityView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerRemoveFpFromOpOperationFormalParameterMssgWizard extends Wizard {

		protected ServerRemoveFpFromOpOperationFormalParameterMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerRemoveFpFromOpOperationFormalParameterMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().removeFpFromOp(firstArgument, (FormalParameterView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("fp", "view.FormalParameterView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private OperationView firstArgument; 
	
		public void setFirstArgument(OperationView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerRemoveFromHierarchyHierarchyAssociationMssgWizard extends Wizard {

		protected ServerRemoveFromHierarchyHierarchyAssociationMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerRemoveFromHierarchyHierarchyAssociationMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().removeFromHierarchy(firstArgument, (AssociationView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("a", "view.AssociationView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private HierarchyView firstArgument; 
	
		public void setFirstArgument(HierarchyView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerRemoveTypeMObjectMAtomicTypeMssgWizard extends Wizard {

		protected ServerRemoveTypeMObjectMAtomicTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerRemoveTypeMObjectMAtomicTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().removeType(firstArgument, (MAtomicTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("oldType", "view.MAtomicTypeView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().oldType_Path_In_RemoveType((MObjectView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}});		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getComponent(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
		}
		
		
		private MObjectView firstArgument; 
	
		public void setFirstArgument(MObjectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerReplaceTypeMObjectMAtomicTypeMAtomicTypeMssgWizard extends Wizard {

		protected ServerReplaceTypeMObjectMAtomicTypeMAtomicTypeMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerReplaceTypeMObjectMAtomicTypeMAtomicTypeMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().replaceType(firstArgument, (MAtomicTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									(MAtomicTypeView)((ObjectSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("oldType", "view.MAtomicTypeView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().oldType_Path_In_ReplaceType((MObjectView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}});
			getParametersPanel().add(new ObjectSelectionPanel("newType", "view.MAtomicTypeView", null, this)
											{protected ViewRoot getBrowserRoot(){
												{try{
													return new ListRoot(getConnection().newType_Path_In_ReplaceType((MAtomicTypeView)this.navigationRoot));
												}catch(ModelException me){
													return (ViewRoot) this.navigationRoot;
												}catch(UserException ue){
													return (ViewRoot) this.navigationRoot;
											}}}});		
		}	
		protected void handleDependencies(int i) {
			if(i == 0){
				((ObjectSelectionPanel)getParametersPanel().getComponent(i)).setBrowserRoot((ViewRoot)firstArgument);
			}
			if(i == 1){
				ViewRoot dependent = (ViewRoot)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult();
				((ObjectSelectionPanel)getParametersPanel().getComponent(i)).setBrowserRoot(dependent);
			}
		}
		
		
		private MObjectView firstArgument; 
	
		public void setFirstArgument(MObjectView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerSetConversionUnitFractionFractionMssgWizard extends Wizard {

		protected ServerSetConversionUnitFractionFractionMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerSetConversionUnitFractionFractionMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().setConversion(firstArgument, ((FractionSelectionPanel)getParametersPanel().getComponent(0)).getResult(),
									((FractionSelectionPanel)getParametersPanel().getComponent(1)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new FractionSelectionPanel("factor", this));
			getParametersPanel().add(new FractionSelectionPanel("constant", this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitView firstArgument; 
	
		public void setFirstArgument(UnitView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	class ServerSetDefaultUnitUnitTypeUnitMssgWizard extends Wizard {

		protected ServerSetDefaultUnitUnitTypeUnitMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerSetDefaultUnitUnitTypeUnitMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().setDefaultUnit(firstArgument, (UnitView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			try{
				getParametersPanel().add(new ObjectSelectionPanel("defaultUnit", "view.UnitView", new ListRoot(getConnection().defaultUnit_Path_In_SetDefaultUnit()), this));
			}catch(ModelException me){;
				 handleException(me);
				 setVisible(false);
				 dispose();
				 return;
			 }catch(UserException ue){;
				 handleUserException(ue);
				 setVisible(false);
				 dispose();
				 return;
			 }		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private UnitTypeView firstArgument; 
	
		public void setFirstArgument(UnitTypeView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			try{
				SelectionPanel selectionPanel = (SelectionPanel)getParametersPanel().getComponent(0);
				selectionPanel.preset((Anything)firstArgument.getDefaultUnit());
				if (!selectionPanel.check()) selectionPanel.preset((Anything)null);
			}catch(ModelException me){
				 handleException(me);
			}
			this.check();
		}
		
		
	}

	class ServerSubAbsQuantityAbsQuantityMssgWizard extends Wizard {

		protected ServerSubAbsQuantityAbsQuantityMssgWizard(String operationName){
			super();
			getOkButton().setText(operationName);
		}
		protected void initialize(){
			this.helpFileName = "ServerSubAbsQuantityAbsQuantityMssgWizard.help";
			super.initialize();			
		}
				
		protected void perform() {
			try {
				getConnection().sub(firstArgument, (AbsQuantityView)((ObjectSelectionPanel)getParametersPanel().getComponent(0)).getResult());
				getConnection().setEagerRefresh();
				setVisible(false);
				dispose();	
			}
			catch(ModelException me){
				handleException(me);
				setVisible(false);
				dispose();
			}
			catch(NotComputableException e) {
				getStatusBar().setText(e.getMessage());
			}
			
		}
		protected String checkCompleteParameterSet(){
			return null;
		}
		
		protected void addParameters(){
			getParametersPanel().add(new ObjectSelectionPanel("subtrahend", "view.AbsQuantityView", (ViewRoot) getConnection().getServerView(), this));		
		}	
		protected void handleDependencies(int i) {
		}
		
		
		private AbsQuantityView firstArgument; 
	
		public void setFirstArgument(AbsQuantityView firstArgument){
			this.firstArgument = firstArgument;
			this.setTitle(this.firstArgument.toString());
			this.check();
		}
		
		
	}

	/* Menu and wizard section end */

	private void addNotGeneratedItems(final JPopupMenu result, final ViewRoot selected) {
		// TODO Add items if you have not generated service calls!!!
	}

}