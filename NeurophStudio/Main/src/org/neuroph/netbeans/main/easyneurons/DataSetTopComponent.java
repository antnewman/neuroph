package org.neuroph.netbeans.main.easyneurons;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.application.Action;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.netbeans.main.easyneurons.dialog.TrainingDataFileDialog;
import org.openide.cookies.SaveCookie;
import org.openide.loaders.DataObject;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.TopComponent;

/**
 * Top component which displays training set.
 */
public final class DataSetTopComponent extends TopComponent implements LookupListener {

    /**
     * path to the icon used by the component and its open action
     */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "DataSetTopComponent";
    private AbstractLookup aLookup;
    SaveCookie saveCookie;
    private InstanceContent content;

    public DataSetTopComponent() {
        tableModel = new DataSetTableModel();
        initComponents();
        setName(NbBundle.getMessage(DataSetTopComponent.class, "CTL_TrainingSetEditFrameTopComponent"));
        setToolTipText(NbBundle.getMessage(DataSetTopComponent.class, "HINT_TrainingSetEditFrameTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        //content = new InstanceContent();
    }

    public DataSetTopComponent(DataObject dataSetDataObject) {
        // this();  
//        this.dataSet = dataSet;
//        this.saveCookie = cookie;
        this.dataSet = dataSetDataObject.getLookup().lookup(DataSet.class);
        this.saveCookie = dataSetDataObject.getLookup().lookup(SaveCookie.class);             

        tableModel = new DataSetTableModel();
        initComponents();
        setName(NbBundle.getMessage(DataSetTopComponent.class, "CTL_TrainingSetEditFrameTopComponent"));
        setToolTipText(NbBundle.getMessage(DataSetTopComponent.class, "HINT_TrainingSetEditFrameTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        this.setTrainingSetEditFrameVariables(dataSet);
        content = new InstanceContent();
        content.add(dataSet); // dodati i ovo u lookup....
        content.add(saveCookie);
        aLookup = new AbstractLookup(content);
        
    }

    @Override
    public Lookup getLookup() {
        return new ProxyLookup(
                new Lookup[]{
                    super.getLookup(),
                    aLookup
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenu = new javax.swing.JPopupMenu();
        addRowMenuItem = new javax.swing.JMenuItem();
        delRowMenuItem = new javax.swing.JMenuItem();
        namePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        traningSetLabelTextField = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        trainingSetTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        addRowButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(addRowMenuItem, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.addRowMenuItem.text")); // NOI18N
        addRowMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(addRowMenuItem);

        org.openide.awt.Mnemonics.setLocalizedText(delRowMenuItem, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.delRowMenuItem.text")); // NOI18N
        delRowMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delRowMenuItemActionPerformed(evt);
            }
        });
        tablePopupMenu.add(delRowMenuItem);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.jLabel1.text")); // NOI18N

        traningSetLabelTextField.setColumns(30);

        trainingSetTable.setModel(tableModel);
        trainingSetTable.setComponentPopupMenu(tablePopupMenu);
        tableScrollPane.setViewportView(trainingSetTable);

        javax.swing.GroupLayout namePanelLayout = new javax.swing.GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        namePanelLayout.setHorizontalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(traningSetLabelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(namePanelLayout.createSequentialGroup()
                .addComponent(tableScrollPane)
                .addContainerGap())
        );
        namePanelLayout.setVerticalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namePanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(traningSetLabelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addRowButton, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.addRowButton.text")); // NOI18N
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(loadButton, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.loadButton.text")); // NOI18N
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(helpButton, org.openide.util.NbBundle.getMessage(DataSetTopComponent.class, "DataSetTopComponent.helpButton.text")); // NOI18N
        helpButton.setEnabled(false);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(okButton)
                .addGap(5, 5, 5)
                .addComponent(addRowButton)
                .addGap(5, 5, 5)
                .addComponent(loadButton)
                .addGap(5, 5, 5)
                .addComponent(cancelButton)
                .addGap(5, 5, 5)
                .addComponent(helpButton))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addComponent(addRowButton)
                    .addComponent(loadButton)
                    .addComponent(cancelButton)
                    .addComponent(helpButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (trainingSetTable.isEditing()) {
            trainingSetTable.getCellEditor().stopCellEditing();
        }

        if (this.traningSetLabelTextField.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the training set name!");
            return;
        }

        this.dataSet.setLabel(this.traningSetLabelTextField.getText().trim());
        ArrayList<ArrayList> dataVector = this.tableModel.getDataVector();
        Iterator<ArrayList> iterator = dataVector.iterator();
        this.dataSet.clear();

        if (this.trainingSetType.equals("Unsupervised")) {
            while (iterator.hasNext()) {
                ArrayList rowVector = iterator.next();
                ArrayList<Double> doubleRowVector = new ArrayList<Double>();
                try {
                    for (int i = 0; i < this.inputs; i++) {
                        double doubleVal = Double.parseDouble(rowVector.get(i).toString());
                        doubleRowVector.add(new Double(doubleVal));
                    }
                } catch (Exception ex) {
                    continue;
                }

                DataSetRow trainingElement = new DataSetRow(doubleRowVector);
                this.dataSet.addRow(trainingElement);
            }
        } else if (this.trainingSetType.equals("Supervised")) {
            while (iterator.hasNext()) {
                ArrayList rowVector = iterator.next();
                ArrayList<Double> inputVector = new ArrayList<Double>();
                ArrayList<Double> outputVector = new ArrayList<Double>();

                try {
                    for (int i = 0; i < this.inputs; i++) {
                        double doubleVal = Double.parseDouble(rowVector.get(i).toString());
                        inputVector.add(new Double(doubleVal));
                    }

                    for (int i = 0; i < this.outputs; i++) {
                        double doubleVal = Double.parseDouble(rowVector.get(
                                this.inputs + i).toString());
                        outputVector.add(new Double(doubleVal));
                    }
                } catch (Exception ex) {
                    continue;
                }

                DataSetRow trainingElement = new DataSetRow(
                        inputVector, outputVector);
                this.dataSet.addRow(trainingElement);

            }
        }

        // ovde cak i ne treba pisati u fajl vec se to radi na file > save
//          for (CreateTrainigSetFileServiceInterface fileservices : ServiceLoader.load(CreateTrainigSetFileServiceInterface.class)) {
//                fileservices.serialise(this.dataSet);
//            }
        // ovde treba kreirati dogadjaj TreningSetCreatedEvent i fireEvent
        // a neural network frame treba da slusa te dogadjaje. Kako dodati slusaoca???
        // potencilajni problem j esto se ti prozori otvaraju i zatvaraju
        // mozda najbolje to resiti preko lookup-a

//        ProjectManager.getInstance().updateTrainingSets(this.dataSet);
        //this.dispose();
        this.close();
    }//GEN-LAST:event_okButtonActionPerformed

    private void addRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowButtonActionPerformed
        ((DataSetTableModel) trainingSetTable.getModel()).addEmptyRow();
    }//GEN-LAST:event_addRowButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        TrainingDataFileDialog dialog = new TrainingDataFileDialog(inputs, outputs, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_loadButtonActionPerformed

    private void addRowMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowMenuItemActionPerformed
        ((DataSetTableModel) trainingSetTable.getModel()).addEmptyRow();
}//GEN-LAST:event_addRowMenuItemActionPerformed

    private void delRowMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRowMenuItemActionPerformed
        ((DataSetTableModel) trainingSetTable.getModel())
                .removeRow(trainingSetTable.getSelectedRow());
}//GEN-LAST:event_delRowMenuItemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowButton;
    private javax.swing.JMenuItem addRowMenuItem;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem delRowMenuItem;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel namePanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPopupMenu tablePopupMenu;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable trainingSetTable;
    private javax.swing.JTextField traningSetLabelTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void componentOpened() {
        if (this.dataSet != null) {
            setName(dataSet.getLabel());
        } else {
            setName("Training set not loaded");
        }
//        if (content == null) {
//            content = new InstanceContent();
//        }
    }

    @Override
    public void componentClosed() {
        //  ViewManager.getInstance().onTrainingSetClose(dataSet);
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
    private DataSet dataSet;
    private DataSetTableModel tableModel;
    private String trainingSetType;
    private int inputs, outputs;
    private String trainingSetLabel;

    public void setTrainingSetEditFrameVariables(DataSet trainingSet, String type, int inputs, int outputs) {
        this.trainingSetType = type;
        this.dataSet = trainingSet;
        this.inputs = inputs;
        this.outputs = outputs;
        this.tableModel = new DataSetTableModel(inputs, outputs);

        //tableModel.addTableModelListener(new TrainingSetEditFrame.InteractiveTableModelListener());
        tableModel.addTableModelListener(new DataSetTopComponent.InteractiveTableModelListener());

        initComponents();

        if (!tableModel.hasEmptyRow()) {
            tableModel.addEmptyRow();
        }
        trainingSetTable.setSurrendersFocusOnKeystroke(true);

        TableColumn hidden = trainingSetTable.getColumnModel().getColumn(tableModel.HIDDEN_INDEX);
        hidden.setMinWidth(2);
        hidden.setPreferredWidth(2);
        hidden.setMaxWidth(2);
        hidden.setCellRenderer(new InteractiveRenderer(tableModel.HIDDEN_INDEX));

        this.trainingSetLabel = trainingSet.getLabel();
        this.traningSetLabelTextField.setText(this.trainingSetLabel);
        this.trainingSetTable.getTableHeader().setReorderingAllowed(false);
    }

    public void setTrainingSetEditFrameVariables(DataSet trainingSet) {
        this.dataSet = trainingSet;
        this.tableModel = new DataSetTableModel(trainingSet);
        //associateLookup(Lookups.singleton(dataSet));

        //tableModel.addTableModelListener(new TrainingSetEditFrame.InteractiveTableModelListener());
        tableModel.addTableModelListener(new DataSetTopComponent.InteractiveTableModelListener());

        initComponents();

        if (!tableModel.hasEmptyRow()) {
            tableModel.addEmptyRow();
        }
        trainingSetTable.setSurrendersFocusOnKeystroke(true);

        TableColumn hidden = trainingSetTable.getColumnModel().getColumn(tableModel.HIDDEN_INDEX);
        hidden.setMinWidth(2);
        hidden.setPreferredWidth(2);
        hidden.setMaxWidth(2);
        hidden.setCellRenderer(new InteractiveRenderer(tableModel.HIDDEN_INDEX));

        this.trainingSetLabel = trainingSet.getLabel();
        this.traningSetLabelTextField.setText(this.trainingSetLabel);

//        if (dataSet.getRows().size() > 0) {
//            DataSetRow trainingElement = (DataSetRow) dataSet.getRows().get(0);
        if (trainingSet.isSupervised()) {
            this.trainingSetType = "Supervised";
            this.inputs = trainingSet.getInputSize();
            //this.inputs = trainingElement.getInput().size();
            //this.outputs = ((SupervisedTrainingElement) trainingElement)
            //		.getDesiredOutput().length;
            this.outputs = trainingSet.getOutputSize();
        } else {
            this.trainingSetType = "Unsupervised";
            this.outputs = 0;
            //this.inputs = trainingElement.getInput().length;
            this.inputs = trainingSet.getInputSize();
            //          }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @Action
//    public void cancel() {
//        //this.dispose();
//        this.close();
//    }
//    @Action
//    public void addtableRow() {
//        ((DataSetTableModel) trainingSetTable.getModel()).addEmptyRow();
//    }
    @Action
    public void deleteTableRow() {
        //int selected_row = trainingSetTable.getSelectedRow();
        ((DataSetTableModel) trainingSetTable.getModel()).removeRow(trainingSetTable.getSelectedRow());

    }
//
//    @Action
//    public void save() {
//        if (trainingSetTable.isEditing()) {
//            trainingSetTable.getCellEditor().stopCellEditing();
//        }
//
//        if (this.traningSetLabelTextField.getText().trim().isEmpty()) {
//            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the training set name!");
//            return;
//        }
//
//        this.dataSet.setLabel(this.traningSetLabelTextField.getText().trim());
//        Vector<Vector> dataVector = this.tableModel.getDataVector();
//        Iterator<Vector> iterator = dataVector.iterator();
//        this.dataSet.clear();
//
//        if (this.trainingSetType.equals("Unsupervised")) {
//            while (iterator.hasNext()) {
//                Vector rowVector = iterator.next();
//                Vector<Double> doubleRowVector = new Vector<Double>();
//                try {
//                    for (int i = 0; i < this.inputs; i++) {
//                        double doubleVal = Double.parseDouble(rowVector.elementAt(i).toString());
//                        doubleRowVector.add(new Double(doubleVal));
//                    }
//                } catch (Exception ex) {
//                    continue;
//                }
//
//                TrainingElement trainingElement = new TrainingElement(
//                        doubleRowVector);
//                this.dataSet.addElement(trainingElement);
//            }
//        } else if (this.trainingSetType.equals("Supervised")) {
//            while (iterator.hasNext()) {
//                Vector rowVector = iterator.next();
//                Vector<Double> inputVector = new Vector<Double>();
//                Vector<Double> outputVector = new Vector<Double>();
//
//                try {
//                    for (int i = 0; i < this.inputs; i++) {
//                        double doubleVal = Double.parseDouble(rowVector.elementAt(i).toString());
//                        inputVector.add(new Double(doubleVal));
//                    }
//
//                    for (int i = 0; i < this.outputs; i++) {
//                        double doubleVal = Double.parseDouble(rowVector.elementAt(
//                                this.inputs + i).toString());
//                        outputVector.add(new Double(doubleVal));
//                    }
//                } catch (Exception ex) {
//                    continue;
//                }
//
//                SupervisedTrainingElement trainingElement = new SupervisedTrainingElement(
//                        inputVector, outputVector);
//                this.dataSet.addElement(trainingElement);
//            }
//        }
//
//        ProjectManager.getInstance().updateTrainingSets(this.dataSet);
//        //this.dispose();
//        this.close();
//
//    }

    public void highlightLastRow(int row) {
        int lastrow = tableModel.getRowCount();
        if (row == lastrow - 1) {
            trainingSetTable.setRowSelectionInterval(lastrow - 1, lastrow - 1);
        } else {
            trainingSetTable.setRowSelectionInterval(row + 1, row + 1);
        }

        trainingSetTable.setColumnSelectionInterval(0, 0);
    }

    @Override
    public void resultChanged(LookupEvent ev) {
    }

    class InteractiveRenderer extends DefaultTableCellRenderer {

        protected int interactiveColumn;

        public InteractiveRenderer(int interactiveColumn) {
            this.interactiveColumn = interactiveColumn;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == interactiveColumn && hasFocus) {
//                if ((TrainingSetEditFrame.this.tableModel.getRowCount() - 1) == row
//                        && !TrainingSetEditFrame.this.tableModel.hasEmptyRow()) {
//                    TrainingSetEditFrame.this.tableModel.addEmptyRow();
//                }
                if ((DataSetTopComponent.this.tableModel.getRowCount() - 1) == row
                        && !DataSetTopComponent.this.tableModel.hasEmptyRow()) {
                    DataSetTopComponent.this.tableModel.addEmptyRow();
                }


                highlightLastRow(row);
            }

            return c;
        }
    }

    public class InteractiveTableModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent evt) {
            if (evt.getType() == TableModelEvent.UPDATE) {
                int column = evt.getColumn();
                int row = evt.getFirstRow();
                // System.out.println("row: " + row + " column: " + column);
                trainingSetTable.setColumnSelectionInterval(column + 1, column + 1);
                trainingSetTable.setRowSelectionInterval(row, row);
            }
        }
    }

//    @Action
//    public void showLoadTrainingSetDialog() {
//        TrainingDataFileDialog dialog = new TrainingDataFileDialog(inputs, outputs, this);
//        dialog.setVisible(true);
////        EasyNeuronsViewController.getInstance().show(dialog);
//    }
    public void setTrainingSet(DataSet trainingSet) {
        this.dataSet = trainingSet;

        this.tableModel = new DataSetTableModel(this.dataSet);
        this.trainingSetTable.setModel(this.tableModel);
        trainingSetTable.setSurrendersFocusOnKeystroke(true);

        TableColumn hidden = trainingSetTable.getColumnModel().getColumn(tableModel.HIDDEN_INDEX);
        hidden.setMinWidth(2);
        hidden.setPreferredWidth(2);
        hidden.setMaxWidth(2);
        hidden.setCellRenderer(new InteractiveRenderer(tableModel.HIDDEN_INDEX));

        this.tableModel.fireTableDataChanged();

    }

    private void setTableModel() {
        if (dataSet.size() > 0) {
            DataSetRow trainingElement = (DataSetRow) dataSet.getRowAt(0);
            if (trainingElement.isSupervised()) {
                this.trainingSetType = "Supervised";
                this.inputs = trainingElement.getInput().length;
                //this.inputs = trainingElement.getInput().size();
                //this.outputs = ((SupervisedTrainingElement) trainingElement)
                //		.getDesiredOutput().length;
                // this.outputs = ((SupervisedTrainingElement) trainingElement).getDesiredOutput().size();
                this.outputs = trainingElement.getDesiredOutput().length;
            } else {
                this.trainingSetType = "Unsupervised";
                this.outputs = 0;
                this.inputs = trainingElement.getInput().length;
                //this.inputs = trainingElement.getInput().size();
            }
        }
    }
}
