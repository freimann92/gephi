/*
 * Your license here
 *
 * If you don't need it, remove this file and edit MyMetricUI accordingly.
 */

package org.gephi.statistics.spanningtree;

import java.util.Collection;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.openide.util.Lookup;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsUI
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
public class SpanningTreePanel extends javax.swing.JPanel {
    
    private static final String NOT_FOUND = "No Algorithms Found";
    
    //stui is a link in the chain of communication between front and back end
    // SpanningTreePanel<-->SpanningTreeUI<-->SpanningTree
    private SpanningTreeUI stui;
    
    /** Creates new form SpanningTreePanel */

    public SpanningTreePanel(SpanningTreeUI stui) {
        
        this.stui=stui;
        
        initComponents();
        
        //Collect all available spanningTreeAlgorithms
        Collection<? extends SpanningTreeAlgorithm> spanningTreeAlgorithms = 
                Lookup.getDefault().lookupAll(SpanningTreeAlgorithm.class);
       
        Vector options;
        if (spanningTreeAlgorithms.isEmpty()){ 
            options = new Vector();
            options.add(NOT_FOUND);
        }
        else{
            options = new Vector(spanningTreeAlgorithms);
        }
        ComboBoxModel comboModel = new DefaultComboBoxModel(options);
        algorithmComboBox.setModel(comboModel);
        
        //only enable if options are not empty
        algorithmComboBox.setEnabled(!spanningTreeAlgorithms.isEmpty());              
    }

    /** Add here setters and getters for all properties users can edit. */


    
    /** Only useful if the algorithm takes graph type into account. */
    
    public boolean isDirected() {
        return directedRadioButton.isSelected();
    }

    public void setDirected(boolean directed) {
        directedButtonGroup.setSelected(directed ? directedRadioButton.getModel() : undirectedRadioButton.getModel(), true);
    }

    /** ----------------------------------------------------------- */

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directedButtonGroup = new javax.swing.ButtonGroup();
        header = new org.jdesktop.swingx.JXHeader();
        undirectedRadioButton = new javax.swing.JRadioButton();
        directedRadioButton = new javax.swing.JRadioButton();
        algorithmComboBox = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(456, 218));

        header.setDescription(org.openide.util.NbBundle.getMessage(SpanningTreePanel.class, "SpanningTreePanel.header.description")); // NOI18N
        header.setTitle(org.openide.util.NbBundle.getMessage(SpanningTreePanel.class, "SpanningTreePanel.header.title")); // NOI18N

        directedButtonGroup.add(undirectedRadioButton);
        undirectedRadioButton.setText(org.openide.util.NbBundle.getMessage(SpanningTreePanel.class, "SpanningTreePanel.undirectedRadioButton.text")); // NOI18N

        directedButtonGroup.add(directedRadioButton);
        directedRadioButton.setText(org.openide.util.NbBundle.getMessage(SpanningTreePanel.class, "SpanningTreePanel.directedRadioButton.text")); // NOI18N

        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Searching..." }));
        algorithmComboBox.setActionCommand(org.openide.util.NbBundle.getMessage(SpanningTreePanel.class, "SpanningTreePanel.algorithmComboBox.actionCommand")); // NOI18N
        algorithmComboBox.setEnabled(false);
        algorithmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algorithmComboBoxItemStateChanged(evt);
            }
        });
        algorithmComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                algorithmComboBoxPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(undirectedRadioButton)
                    .addComponent(directedRadioButton))
                .addContainerGap(371, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(directedRadioButton)
                .addGap(7, 7, 7)
                .addComponent(undirectedRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void algorithmComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_algorithmComboBoxPropertyChange

    }//GEN-LAST:event_algorithmComboBoxPropertyChange

    private void algorithmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algorithmComboBoxItemStateChanged
        Object selection = algorithmComboBox.getSelectedItem();
        if(selection instanceof SpanningTreeAlgorithm){
            stui.setSpanningTreeAlgorithm((SpanningTreeAlgorithm)selection);
        }
    }//GEN-LAST:event_algorithmComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox algorithmComboBox;
    private javax.swing.ButtonGroup directedButtonGroup;
    protected javax.swing.JRadioButton directedRadioButton;
    private org.jdesktop.swingx.JXHeader header;
    protected javax.swing.JRadioButton undirectedRadioButton;
    // End of variables declaration//GEN-END:variables

}
