/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.text.Document;
import javax.swing.undo.*;
import java.lang.Object;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;

/**
 *
 * @author Kiwi
 */
public class NewJFrame2 extends javax.swing.JFrame {

    //Colores para letras
    public static final Color Gray = new Color(109,109,109);
    public static final Color Black = new Color(0,0,0);
   
    // undo and redo
    private Document editorPaneDocument;
    protected UndoHandler undoHandler = new UndoHandler();  
    protected UndoManager undoManager = new UndoManager();
    private UndoAction undoAction = null;
    private RedoAction redoAction = null;
    // In the constructor
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame2() {
        initComponents();
        editorPaneDocument = syntaxArea.getDocument();
        editorPaneDocument.addUndoableEditListener(undoHandler);
        
        KeyStroke undoKeystroke = KeyStroke.getKeyStroke("control Z");
        KeyStroke redoKeystroke = KeyStroke.getKeyStroke("control Y");

        undoAction = new UndoAction();
        syntaxArea.getInputMap().put(undoKeystroke, "undoKeystroke");
        syntaxArea.getActionMap().put("undoKeystroke", undoAction);

        redoAction = new RedoAction();
        syntaxArea.getInputMap().put(redoKeystroke, "redoKeystroke");
        syntaxArea.getActionMap().put("redoKeystroke", redoAction);
        
        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem undoMenuItem = new JMenuItem(undoAction);
        JMenuItem redoMenuItem = new JMenuItem(redoAction);
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        
        
    }
class UndoHandler implements UndoableEditListener
{

  /**
   * Messaged when the Document has created an edit, the edit is added to
   * <code>undoManager</code>, an instance of UndoManager.
   */
  @Override
  public void undoableEditHappened(UndoableEditEvent e)
  {
    undoManager.addEdit(e.getEdit());
    undoAction.update();
    redoAction.update();
  }
}
class UndoAction extends AbstractAction
{
  public UndoAction()
  {
    super("Undo");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      undoManager.undo();
    }
    catch (CannotUndoException ex)
    {
      // TODO deal with this
      //ex.printStackTrace();
    }
    update();
    redoAction.update();
  }

  protected void update()
  {
    if (undoManager.canUndo())
    {
      setEnabled(true);
      putValue(Action.NAME, undoManager.getUndoPresentationName());
    }
    else
    {
      setEnabled(false);
      putValue(Action.NAME, "Undo");
    }
  }
}
class RedoAction extends AbstractAction
{
  public RedoAction()
  {
    super("Redo");
    setEnabled(false);
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      undoManager.redo();
    }
    catch (CannotRedoException ex)
    {
      // TODO deal with this
      ex.printStackTrace();
    }
    update();
    undoAction.update();
  }

  protected void update()
  {
    if (undoManager.canRedo())
    {
      setEnabled(true);
      putValue(Action.NAME, undoManager.getRedoPresentationName());
    }
    else
    {
      setEnabled(false);
      putValue(Action.NAME, "Redo");
    }
  }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        NewOperation = new javax.swing.JFrame();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        orderFormat = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        syntaxArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventArea = new javax.swing.JTextArea();
        Load = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        NVariable = new javax.swing.JButton();
        NOperation = new javax.swing.JButton();
        NDataBase = new javax.swing.JButton();
        NTable = new javax.swing.JButton();
        deshacer = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        NewOperation.setTitle("New Operation");
        NewOperation.setBounds(new java.awt.Rectangle(0, 0, 547, 260));
        NewOperation.setLocationByPlatform(true);
        NewOperation.setResizable(false);

        jSplitPane2.setDividerLocation(270);
        jSplitPane2.setEnabled(false);
        jSplitPane2.setMinimumSize(new java.awt.Dimension(7, 3));
        jSplitPane2.setPreferredSize(new java.awt.Dimension(547, 47));

        jPanel2.setMaximumSize(new java.awt.Dimension(270, 45));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(270, 45));

        orderFormat.setText("X_ORDEN_SINTAX");
        orderFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFormatActionPerformed(evt);
            }
        });

        jButton2.setText("Insert");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(270, 45));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(270, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel3);

        javax.swing.GroupLayout NewOperationLayout = new javax.swing.GroupLayout(NewOperation.getContentPane());
        NewOperation.getContentPane().setLayout(NewOperationLayout);
        NewOperationLayout.setHorizontalGroup(
            NewOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewOperationLayout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        NewOperationLayout.setVerticalGroup(
            NewOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KiwiSyntaxManager");
        setLocationByPlatform(true);

        jSplitPane1.setResizeWeight(0.5);

        jScrollPane2.setToolTipText("");

        syntaxArea.setColumns(20);
        syntaxArea.setRows(5);
        jScrollPane2.setViewportView(syntaxArea);

        jSplitPane1.setRightComponent(jScrollPane2);

        eventArea.setColumns(20);
        eventArea.setRows(5);
        jScrollPane1.setViewportView(eventArea);

        jSplitPane1.setLeftComponent(jScrollPane1);

        Load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/page_white_put.png"))); // NOI18N
        Load.setToolTipText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/disk.png"))); // NOI18N
        Save.setToolTipText("Save");

        NVariable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/tag_blue_add.png"))); // NOI18N
        NVariable.setToolTipText("New Variable");
        NVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NVariableActionPerformed(evt);
            }
        });

        NOperation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/cog_add.png"))); // NOI18N
        NOperation.setToolTipText("New Operation");
        NOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOperationActionPerformed(evt);
            }
        });

        NDataBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/database_add.png"))); // NOI18N
        NDataBase.setToolTipText("New DataBase");

        NTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/table_add.png"))); // NOI18N
        NTable.setToolTipText("New Table");

        deshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/arrow_undo.png"))); // NOI18N
        deshacer.setToolTipText("Undo");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/page_white_edit.png"))); // NOI18N
        jToggleButton1.setToolTipText("Edit Code");
        jToggleButton1.setRolloverEnabled(false);
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/page_white_delete.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/arrow_redo.png"))); // NOI18N
        jButton1.setToolTipText("Redo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Load, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NTable, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Load)
                    .addComponent(Save)
                    .addComponent(NVariable)
                    .addComponent(NOperation)
                    .addComponent(NDataBase)
                    .addComponent(NTable)
                    .addComponent(jToggleButton1)
                    .addComponent(deshacer)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        deshacer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String storeAllString = "";
            File fichero = fileChooser.getSelectedFile();
            // Aquí debemos abrir y leer el fichero.
            try {
                FileReader readTextFile = new FileReader(fichero.toString());
                Scanner fileReaderScan = new Scanner(readTextFile);
                while (fileReaderScan.hasNextLine()) {
                    String temp = fileReaderScan.nextLine() + "\n";
                    storeAllString = storeAllString + temp;
                }

            } catch (Exception e) {
            }
            syntaxArea.setText(storeAllString);
        }
    }//GEN-LAST:event_LoadActionPerformed

    private void NVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NVariableActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(true);
    }//GEN-LAST:event_NVariableActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        try {
          undoManager.undo();
        } catch (CannotUndoException cre) {
          System.out.println("Can't undo more");
        }
        
    }//GEN-LAST:event_deshacerActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (syntaxArea.isEditable()) {
            syntaxArea.setEditable(false);
            //jTextArea2.setEnabled(false);
        } else {
            syntaxArea.setEditable(true);
            syntaxArea.setEnabled(true);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
           try {
          undoManager.redo();
        } catch (CannotRedoException cre) {
          System.out.println("Can't redo more");
        }
    }//GEN-LAST:event_redoActionPerformed

    private void NOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOperationActionPerformed
        // TODO add your handling code here:
        NewOperation.setVisible(true);
        //jTextField1.setForeground(Gray);
        //jTextField1.setText("X_ORDEN_SINTAX");
        //jTextField2.setForeground(Gray);
        //jTextField2.setText("C_EJECUTA_COMANDO");
        //jButton2.requestFocus()
    }//GEN-LAST:event_NOperationActionPerformed

    private void orderFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFormatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderFormatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Load;
    private javax.swing.JButton NDataBase;
    private javax.swing.JButton NOperation;
    private javax.swing.JButton NTable;
    private javax.swing.JButton NVariable;
    private javax.swing.JFrame NewOperation;
    private javax.swing.JButton Save;
    private javax.swing.JButton deshacer;
    private javax.swing.JTextArea eventArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField orderFormat;
    private javax.swing.JTextArea syntaxArea;
    // End of variables declaration//GEN-END:variables
}
