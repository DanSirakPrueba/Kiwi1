/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.Controller;
import deliver.Deliver;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author daniel
 */
public class NewVariable extends javax.swing.JDialog {

    private Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons2/tag_blue.png"));
    JOptionPane Error = new JOptionPane();
    private MainWindow mw;
    
    /**
     * Creates new form NewVariable
     */
    public NewVariable(MainWindow frame) {
        initComponents();
        this.setTitle("New Variable");
        setIconImage(icon);
        Deliver.setDestination(frame);
        this.mw = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        grupoBotones1 = new javax.swing.ButtonGroup();
        grupoBotones2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        name1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        value = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        name2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        init = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        relative = new javax.swing.JRadioButton();
        absolute = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        wToggle = new javax.swing.JRadioButton();
        sToggle = new javax.swing.JRadioButton();
        dToggle = new javax.swing.JRadioButton();
        otherText = new javax.swing.JRadioButton();
        otherField = new javax.swing.JTextField();
        add = new javax.swing.JToggleButton();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(421, 210));
        setResizable(false);

        jTabbedPane1.setName("Hola"); // NOI18N

        name1.setToolTipText("New Variable Name");

        jLabel1.setText("Name");

        jLabel2.setText("Value");
        jLabel2.setToolTipText("Value of the new variable");

        value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 258, Short.MAX_VALUE))
                    .addComponent(value))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("New variable", jPanel2);

        jLabel3.setText("Name");

        name2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Init");

        jLabel5.setText("End");

        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        grupoBotones1.add(relative);
        relative.setSelected(true);
        relative.setText("Relative(+)");

        grupoBotones1.add(absolute);
        absolute.setText("Absolute(-)");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        grupoBotones2.add(wToggle);
        wToggle.setSelected(true);
        wToggle.setText("w");

        grupoBotones2.add(sToggle);
        sToggle.setText("s");

        grupoBotones2.add(dToggle);
        dToggle.setText("d");

        grupoBotones2.add(otherText);
        otherText.setText("...");

        otherField.setForeground(Color.GRAY);
        otherField.setText("...");
        otherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherFieldActionPerformed(evt);
            }
        });
        otherField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                otherFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                otherFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(init, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(name2))
                        .addGap(161, 161, 161))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(relative)
                            .addComponent(absolute))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wToggle)
                                    .addComponent(dToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addComponent(sToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otherText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(init, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(relative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(absolute)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(wToggle)
                                    .addComponent(otherText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dToggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(otherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Variable from text", jPanel3);

        add.setLabel("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(cancel))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("New Variable");
        add.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void otherFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherFieldFocusGained
        String preText = "...";
        Color c = Color.BLACK;
        String postText = "";
        opFocus(otherField, preText, c, postText);
    }//GEN-LAST:event_otherFieldFocusGained

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        
        //Cuando la pestaña de Nueva Variable desde cero está seleccionada:
        if (jTabbedPane1.getSelectedIndex() == 0) {
            name1.setText("");
            value.setText("");
        }
        //Cuando la pestaña de Nueva Variable desde texto está seleccionada:
        else if (jTabbedPane1.getSelectedIndex() == 1){
            name2.setText("");
            relative.setSelected(true);
            wToggle.setSelected(true);
            init.setText("");
            end.setText("");
            otherField.setText("...");
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void otherFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherFieldFocusLost
        // TODO add your handling code here:
        String preText = "";
        Color c = Color.GRAY;
        String postText = "...";
        opFocus(otherField, preText, c, postText);
    }//GEN-LAST:event_otherFieldFocusLost

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        InsertVar();
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueActionPerformed
        InsertVar();
    }//GEN-LAST:event_valueActionPerformed

    private void name2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name2ActionPerformed
        InsertVar();
    }//GEN-LAST:event_name2ActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        InsertVar();
    }//GEN-LAST:event_endActionPerformed

    private void otherFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherFieldActionPerformed
        InsertVar();
    }//GEN-LAST:event_otherFieldActionPerformed
    
    private void opFocus(JTextField jtf, String preText, Color c, String postText) {
        if (jtf.getText().equalsIgnoreCase(preText)) {
            jtf.setForeground(c);
            jtf.setText(postText);
        }
    }
    
    private void InsertVar() {
        //Cuando la pestaña de nueva Variable está seleccionada.
        Object[] what;
        if (jTabbedPane1.getSelectedIndex() == 0) {
            //Empaquetamos los datos:
            what = new Object[2]; 
            what[1] = value.getText();
            if (!name1.getText().equalsIgnoreCase("")) {
                what[0] = name1.getText();
                mw.addVars(name1.getText());
                Controller.controller(Controller.createNewVariable, what);
            } else {
                showError("<html><b>Variable name empty</b></html>");
            }
            name1.setText(""); value.setText("");
        }
        //Cuando la pestaña de Nueva Variable desde texto está seleccionada:
        else if (jTabbedPane1.getSelectedIndex() == 1){
            //int column_start, int column_end, String name, String type, boolean absolute
            what = new Object[5]; 
            String type = "w";
            if (wToggle.isSelected()) {
                type = "w";
            } else if (dToggle.isSelected()) {
                type = "d";
            } else if (sToggle.isSelected()) {
                type = "s";
            } else if (otherText.isSelected() && !otherField.getText().equalsIgnoreCase("...")) {
                type = "\"" + otherField.getText() + "\"";
            }
            try {
                if (init.getText().equalsIgnoreCase("")) {init.setText("0");}
                if (end.getText().equalsIgnoreCase("")) {end.setText("255");}
                what[0] = Integer.parseInt(init.getText());
                what[1] = Integer.parseInt(end.getText());                
                what[2] = name2.getText();
                what[3] = type;
                what[4] = (absolute.isSelected())?true:false;
                if (!name2.getText().equalsIgnoreCase("")) {
                    mw.addVars(name2.getText());
                    if (Integer.parseInt(init.getText()) <= Integer.parseInt(end.getText())) {
                        Controller.controller(Controller.createVariableFromText, what);
                        name2.setText(""); otherField.setText("...");
                        otherField.setForeground(Color.GRAY);
                    } else {showError("<html><b>Addressing error:</b><br>Init &lt= End</html>");}
                } else {showError("<html><b>Variable name empty</b></html>");}
            } catch (NumberFormatException e) {
                showError("<html><b>Addressing error:</b><br> Init/End are numbers</html>");
            }
            init.setText(""); end.setText("");   
        }
        add.setSelected(false);
    }
    
    private void showError(String msg) {
         Error.showMessageDialog(this, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton absolute;
    private javax.swing.JToggleButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JRadioButton dToggle;
    private javax.swing.JButton delete;
    private javax.swing.JTextField end;
    private javax.swing.ButtonGroup grupoBotones1;
    private javax.swing.ButtonGroup grupoBotones2;
    private javax.swing.JTextField init;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField name2;
    private javax.swing.JTextField otherField;
    private javax.swing.JRadioButton otherText;
    private javax.swing.JRadioButton relative;
    private javax.swing.JRadioButton sToggle;
    private javax.swing.JTextField value;
    private javax.swing.JRadioButton wToggle;
    // End of variables declaration//GEN-END:variables
}
