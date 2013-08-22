/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import controller.Controller;
import deliver.Deliver;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.CannotUndoException;

/**
 *
 * @author Kiwi
 */
public class MainWindow extends javax.swing.JFrame {

    //Colores para letras
    public static final Color Red = new Color(255, 0, 0);
    public static final Color Black = new Color(0, 0, 0);
    public static final Color Gray = new Color(109, 109, 109);
    
    //<editor-fold defaultstate="collapsed" desc=" Undo & Redo part1 ">
    private Document editorPaneDocument;
    protected UndoHandler undoHandler = new UndoHandler();
    protected UndoManager undoManager = new UndoManager();
    private UndoAction undoAction = null;
    private RedoAction redoAction = null;
    //</editor-fold>

    /**
     * Creates new form NewJFrame
     */
    public MainWindow() {
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
        Deliver.setDestination(this);


    }

    public void setSyntaxText(String text) {
        //syntaxArea.append(text);
        insertText(syntaxArea, text);
    }
    
    public void setEventText(String text) {
        insertText(eventArea, text);
    }

    //<editor-fold defaultstate="collapsed" desc=" Undo & Redo part2">
    class UndoHandler implements UndoableEditListener {

        /**
         * Messaged when the Document has created an edit, the edit is added to
         * <code>undoManager</code>, an instance of UndoManager.
         */
        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            undoAction.update();
            redoAction.update();
        }
    }

    class UndoAction extends AbstractAction {

        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.undo();
            } catch (CannotUndoException ex) {
                // TODO deal with this
                //ex.printStackTrace();
            }
            update();
            redoAction.update();
        }

        protected void update() {
            if (undoManager.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }

    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.redo();
            } catch (CannotRedoException ex) {
                // TODO deal with this
                ex.printStackTrace();
            }
            update();
            undoAction.update();
        }

        protected void update() {
            if (undoManager.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }
    //</editor-fold>

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
        jLabel1 = new javax.swing.JLabel();
        NewOperation = new javax.swing.JFrame();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        orderFormat = new javax.swing.JTextField();
        orderFormatInsert = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        commandFormatExe = new javax.swing.JTextField();
        commandFormatExeInsert = new javax.swing.JButton();
        commandFormatSintax = new javax.swing.JTextField();
        commandFormatSintaxInsert = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        failureManagerFormat = new javax.swing.JTextField();
        failureManagerFormatInsert = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        concatOperationSintax = new javax.swing.JTextField();
        concatOperationSintaxInsert = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        compAsigOperationSintax = new javax.swing.JTextField();
        compAsigOperationSintaxInsert = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        basicProcessingFormat = new javax.swing.JTextField();
        basicProcessingFormatInsert = new javax.swing.JButton();
        newProcessingFormat = new javax.swing.JTextField();
        newProcessingFormatInsert = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        associationFormat = new javax.swing.JTextField();
        associationFormatInsert = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        specialEventFormat = new javax.swing.JTextField();
        specialEventFormatInsert = new javax.swing.JButton();
        msgError = new javax.swing.JDialog();
        msgErrorLabel = new javax.swing.JLabel();
        msgErrorButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        syntaxArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventArea = new javax.swing.JTextArea();
        LoadEvent = new javax.swing.JButton();
        LoadSyntax = new javax.swing.JButton();
        SaveSyntax = new javax.swing.JButton();
        NVariable = new javax.swing.JButton();
        NOperation = new javax.swing.JButton();
        NDataBase = new javax.swing.JButton();
        NTable = new javax.swing.JButton();
        deshacer = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jFrame1.setBounds(new java.awt.Rectangle(0, 0, 225, 206));
        jFrame1.setLocationByPlatform(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><img src=\"http://farm4.staticflickr.com/3227/3115937621_650616f2b0.jpg\" width=210 height=180></html>");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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
        orderFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                orderFormatFocusLost(evt);
            }
        });

        orderFormatInsert.setText("Insert");
        orderFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFormatInsertActionPerformed(evt);
            }
        });

        commandFormatExe.setText("C_EJECUTA_COMANDO");
        commandFormatExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandFormatExeActionPerformed(evt);
            }
        });
        commandFormatExe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                commandFormatExeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                commandFormatExeFocusLost(evt);
            }
        });

        commandFormatExeInsert.setText("Insert");
        commandFormatExeInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandFormatExeInsertActionPerformed(evt);
            }
        });

        commandFormatSintax.setText("C_SINTAXIS_COMANDO");
        commandFormatSintax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandFormatSintaxActionPerformed(evt);
            }
        });
        commandFormatSintax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                commandFormatSintaxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                commandFormatSintaxFocusLost(evt);
            }
        });

        commandFormatSintaxInsert.setText("Insert");
        commandFormatSintaxInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandFormatSintaxInsertActionPerformed(evt);
            }
        });

        failureManagerFormat.setText("CAMPOS_GF");
        failureManagerFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                failureManagerFormatActionPerformed(evt);
            }
        });
        failureManagerFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                failureManagerFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                failureManagerFormatFocusLost(evt);
            }
        });

        failureManagerFormatInsert.setText("Insert");
        failureManagerFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                failureManagerFormatInsertActionPerformed(evt);
            }
        });

        concatOperationSintax.setText("X_OPERACION_SINTAX");
        concatOperationSintax.setToolTipText("SUMA-CONCATENACION");
        concatOperationSintax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concatOperationSintaxActionPerformed(evt);
            }
        });
        concatOperationSintax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                concatOperationSintaxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                concatOperationSintaxFocusLost(evt);
            }
        });

        concatOperationSintaxInsert.setText("Insert");
        concatOperationSintaxInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concatOperationSintaxInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(commandFormatSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandFormatSintaxInsert))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(orderFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderFormatInsert))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(commandFormatExe, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(commandFormatExeInsert))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(failureManagerFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(failureManagerFormatInsert))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(concatOperationSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(concatOperationSintaxInsert)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderFormatInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandFormatExe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandFormatExeInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandFormatSintax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandFormatSintaxInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(failureManagerFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(failureManagerFormatInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concatOperationSintax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(concatOperationSintaxInsert))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(270, 45));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(270, 45));

        compAsigOperationSintax.setText("X_OPERACION_SINTAX");
        compAsigOperationSintax.setToolTipText("COMPARACION-ASIGNACION");
        compAsigOperationSintax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compAsigOperationSintaxActionPerformed(evt);
            }
        });
        compAsigOperationSintax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                compAsigOperationSintaxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                compAsigOperationSintaxFocusLost(evt);
            }
        });

        compAsigOperationSintaxInsert.setText("Insert");
        compAsigOperationSintaxInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compAsigOperationSintaxInsertActionPerformed(evt);
            }
        });

        basicProcessingFormat.setText("_TRATAR_BASICO");
        basicProcessingFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicProcessingFormatActionPerformed(evt);
            }
        });
        basicProcessingFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                basicProcessingFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                basicProcessingFormatFocusLost(evt);
            }
        });

        basicProcessingFormatInsert.setText("Insert");
        basicProcessingFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicProcessingFormatInsertActionPerformed(evt);
            }
        });

        newProcessingFormat.setText("_TRATAR_NUEVO");
        newProcessingFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProcessingFormatActionPerformed(evt);
            }
        });
        newProcessingFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newProcessingFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newProcessingFormatFocusLost(evt);
            }
        });

        newProcessingFormatInsert.setText("Insert");
        newProcessingFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProcessingFormatInsertActionPerformed(evt);
            }
        });

        associationFormat.setText("X_ASOCIAR_SINTAX");
        associationFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associationFormatActionPerformed(evt);
            }
        });
        associationFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                associationFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                associationFormatFocusLost(evt);
            }
        });

        associationFormatInsert.setText("Insert");
        associationFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associationFormatInsertActionPerformed(evt);
            }
        });

        specialEventFormat.setText("_SPECIAL_");
        specialEventFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialEventFormatActionPerformed(evt);
            }
        });
        specialEventFormat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                specialEventFormatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                specialEventFormatFocusLost(evt);
            }
        });

        specialEventFormatInsert.setText("Insert");
        specialEventFormatInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialEventFormatInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(compAsigOperationSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compAsigOperationSintaxInsert))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(basicProcessingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(basicProcessingFormatInsert))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(newProcessingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newProcessingFormatInsert))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(associationFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(associationFormatInsert))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(specialEventFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialEventFormatInsert)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compAsigOperationSintax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compAsigOperationSintaxInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicProcessingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicProcessingFormatInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newProcessingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newProcessingFormatInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(associationFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(associationFormatInsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialEventFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialEventFormatInsert))
                .addContainerGap(57, Short.MAX_VALUE))
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

        msgError.setTitle("WARNING");
        msgError.setBounds(new java.awt.Rectangle(0, 0, 307, 120));
        msgError.setLocationByPlatform(true);

        msgErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgErrorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/bullet_error.png"))); // NOI18N
        msgErrorLabel.setText("Prueba de Texto");

        msgErrorButton.setText("OK");
        msgErrorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        msgErrorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgErrorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout msgErrorLayout = new javax.swing.GroupLayout(msgError.getContentPane());
        msgError.getContentPane().setLayout(msgErrorLayout);
        msgErrorLayout.setHorizontalGroup(
            msgErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(msgErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, msgErrorLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(msgErrorButton)
                .addGap(130, 130, 130))
        );
        msgErrorLayout.setVerticalGroup(
            msgErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(msgErrorLayout.createSequentialGroup()
                .addComponent(msgErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgErrorButton)
                .addContainerGap(47, Short.MAX_VALUE))
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

        LoadEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/page_white_lightning.png"))); // NOI18N
        LoadEvent.setToolTipText("Load Event");
        LoadEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadEventActionPerformed(evt);
            }
        });

        LoadSyntax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/page_white_put.png"))); // NOI18N
        LoadSyntax.setToolTipText("Load Syntax");
        LoadSyntax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadSyntaxActionPerformed(evt);
            }
        });

        SaveSyntax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons2/disk.png"))); // NOI18N
        SaveSyntax.setToolTipText("Save");

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
                .addComponent(LoadEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadSyntax, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveSyntax, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(LoadEvent)
                    .addComponent(SaveSyntax)
                    .addComponent(NVariable)
                    .addComponent(NOperation)
                    .addComponent(NDataBase)
                    .addComponent(NTable)
                    .addComponent(jToggleButton1)
                    .addComponent(deshacer)
                    .addComponent(jButton1)
                    .addComponent(LoadSyntax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        deshacer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadEventActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String storeAllString = "";
            File fichero = fileChooser.getSelectedFile();
            // Aquí debemos abrir y leer el fichero.
            try {
                Controller.controller(Controller.readInput, fichero.toString());
            } catch (Exception e) {
            }
            eventArea.setCaretPosition(0);
        }
    }//GEN-LAST:event_LoadEventActionPerformed
	
	private void LoadSyntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadSyntaxActionPerformed
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
            syntaxArea.setCaretPosition(0);
        }
    }//GEN-LAST:event_LoadSyntaxActionPerformed

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
            syntaxArea.setForeground(Gray);
        } else {
            syntaxArea.setEditable(true);
            syntaxArea.setForeground(Black);
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

        orderFormat.setForeground(Gray);
        commandFormatExe.setForeground(Gray);
        commandFormatSintax.setForeground(Gray);
        failureManagerFormat.setForeground(Gray);
        concatOperationSintax.setForeground(Gray);
        compAsigOperationSintax.setForeground(Gray);
        basicProcessingFormat.setForeground(Gray);
        newProcessingFormat.setForeground(Gray);
        associationFormat.setForeground(Gray);
        specialEventFormat.setForeground(Gray);

        orderFormat.setText("X_ORDEN_SINTAX");
        commandFormatExe.setText("C_EJECUTA_COMANDO");
        commandFormatSintax.setText("C_SINTAXIS_COMANDO");
        failureManagerFormat.setText("CAMPOS_GF");
        concatOperationSintax.setText("X_OPERACION_SINTAX");
        compAsigOperationSintax.setText("X_OPERACION_SINTAX");
        basicProcessingFormat.setText("_TRATAR_BASICO");
        newProcessingFormat.setText("_TRATAR_NUEVO");
        associationFormat.setText("X_ASOCIAR_SINTAX");
        specialEventFormat.setText("_SPECIAL_");

        orderFormatInsert.requestFocus();
    }//GEN-LAST:event_NOperationActionPerformed

	private void msgErrorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgErrorButtonActionPerformed
        // TODO add your handling code here:
        msgError.setVisible(false);
    }//GEN-LAST:event_msgErrorButtonActionPerformed
	
    //<editor-fold defaultstate="collapsed" desc=" JtextField's y JButton's de Operaciones ">
    private void orderFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.orderFormat;
        JTextField jtf = orderFormat;
        JButton jb = orderFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_orderFormatActionPerformed

    private void orderFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = orderFormat;
        String preText = "X_ORDEN_SINTAX";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_orderFormatFocusGained

    private void orderFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = orderFormat;
        String preText = "";
        Color c = Gray;
        String postText = "X_ORDEN_SINTAX";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_orderFormatFocusLost

    private void orderFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.orderFormat;
        JTextField jtf = orderFormat;
        JButton jb = orderFormatInsert;
        String preText = "X_ORDEN_SINTAX";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_orderFormatInsertActionPerformed
	
    private void commandFormatExeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandFormatExeActionPerformed
        // TODO add your handling code here:
        int Index = Controller.commandFormatExe;
        JTextField jtf = commandFormatExe;
        JButton jb = commandFormatExeInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_commandFormatExeActionPerformed

    private void commandFormatExeInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandFormatExeInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.commandFormatExe;
        JTextField jtf = commandFormatExe;
        JButton jb = commandFormatExeInsert;
        String preText = "C_EJECUTA_COMANDO";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_commandFormatExeInsertActionPerformed

    private void commandFormatExeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commandFormatExeFocusGained
        // TODO add your handling code here:
        JTextField jtf = commandFormatExe;
        String preText = "C_EJECUTA_COMANDO";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_commandFormatExeFocusGained

    private void commandFormatExeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commandFormatExeFocusLost
        // TODO add your handling code here:
        JTextField jtf = commandFormatExe;
        String preText = "";
        Color c = Gray;
        String postText = "C_EJECUTA_COMANDO";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_commandFormatExeFocusLost

    private void commandFormatSintaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandFormatSintaxActionPerformed
        // TODO add your handling code here:
        int Index = Controller.commandFormatSintax;
        JTextField jtf = commandFormatSintax;
        JButton jb = commandFormatSintaxInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_commandFormatSintaxActionPerformed

    private void commandFormatSintaxInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandFormatSintaxInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.commandFormatSintax;
        JTextField jtf = commandFormatSintax;
        JButton jb = commandFormatSintaxInsert;
        String preText = "C_SINTAXIS_COMANDO";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_commandFormatSintaxInsertActionPerformed

    private void commandFormatSintaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commandFormatSintaxFocusGained
        // TODO add your handling code here:
        JTextField jtf = commandFormatSintax;
        String preText = "C_SINTAXIS_COMANDO";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_commandFormatSintaxFocusGained

    private void commandFormatSintaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commandFormatSintaxFocusLost
        // TODO add your handling code here:
        JTextField jtf = commandFormatSintax;
        String preText = "";
        Color c = Gray;
        String postText = "C_SINTAXIS_COMANDO";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_commandFormatSintaxFocusLost

    private void failureManagerFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_failureManagerFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.failureManagerFormat;
        JTextField jtf = failureManagerFormat;
        JButton jb = failureManagerFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_failureManagerFormatActionPerformed

    private void failureManagerFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_failureManagerFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.failureManagerFormat;
        JTextField jtf = failureManagerFormat;
        JButton jb = failureManagerFormatInsert;
        String preText = "CAMPOS_GF";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_failureManagerFormatInsertActionPerformed

    private void failureManagerFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_failureManagerFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = failureManagerFormat;
        String preText = "CAMPOS_GF";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_failureManagerFormatFocusGained

    private void failureManagerFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_failureManagerFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = failureManagerFormat;
        String preText = "";
        Color c = Gray;
        String postText = "CAMPOS_GF";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_failureManagerFormatFocusLost

    private void concatOperationSintaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concatOperationSintaxActionPerformed
        // TODO add your handling code here:
        int Index = Controller.concatOperationSintax;
        JTextField jtf = concatOperationSintax;
        JButton jb = concatOperationSintaxInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_concatOperationSintaxActionPerformed

    private void concatOperationSintaxInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concatOperationSintaxInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.concatOperationSintax;
        JTextField jtf = concatOperationSintax;
        JButton jb = concatOperationSintaxInsert;
        String preText = "X_OPERACION_SINTAX";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_concatOperationSintaxInsertActionPerformed

    private void concatOperationSintaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_concatOperationSintaxFocusGained
        // TODO add your handling code here:
        JTextField jtf = concatOperationSintax;
        String preText = "X_OPERACION_SINTAX";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_concatOperationSintaxFocusGained

    private void concatOperationSintaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_concatOperationSintaxFocusLost
        // TODO add your handling code here:
        JTextField jtf = concatOperationSintax;
        String preText = "";
        Color c = Gray;
        String postText = "X_OPERACION_SINTAX";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_concatOperationSintaxFocusLost

    private void compAsigOperationSintaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compAsigOperationSintaxActionPerformed
        // TODO add your handling code here:
        int Index = Controller.compAsigOperationSintax;
        JTextField jtf = compAsigOperationSintax;
        JButton jb = compAsigOperationSintaxInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_compAsigOperationSintaxActionPerformed

    private void compAsigOperationSintaxInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compAsigOperationSintaxInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.compAsigOperationSintax;
        JTextField jtf = compAsigOperationSintax;
        JButton jb = compAsigOperationSintaxInsert;
        String preText = "X_OPERACION_SINTAX";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_compAsigOperationSintaxInsertActionPerformed

    private void compAsigOperationSintaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_compAsigOperationSintaxFocusGained
        // TODO add your handling code here:
        JTextField jtf = compAsigOperationSintax;
        String preText = "X_OPERACION_SINTAX";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_compAsigOperationSintaxFocusGained

    private void compAsigOperationSintaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_compAsigOperationSintaxFocusLost
        // TODO add your handling code here:
        JTextField jtf = compAsigOperationSintax;
        String preText = "";
        Color c = Gray;
        String postText = "X_OPERACION_SINTAX";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_compAsigOperationSintaxFocusLost

    private void basicProcessingFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicProcessingFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.basicProcessingFormat;
        JTextField jtf = basicProcessingFormat;
        JButton jb = basicProcessingFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_basicProcessingFormatActionPerformed

    private void basicProcessingFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicProcessingFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.basicProcessingFormat;
        JTextField jtf = basicProcessingFormat;
        JButton jb = basicProcessingFormatInsert;
        String preText = "_TRATAR_BASICO";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_basicProcessingFormatInsertActionPerformed

    private void basicProcessingFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_basicProcessingFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = basicProcessingFormat;
        String preText = "_TRATAR_BASICO";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_basicProcessingFormatFocusGained

    private void basicProcessingFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_basicProcessingFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = basicProcessingFormat;
        String preText = "";
        Color c = Gray;
        String postText = "_TRATAR_BASICO";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_basicProcessingFormatFocusLost

    private void newProcessingFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProcessingFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.newProcessingFormat;
        JTextField jtf = newProcessingFormat;
        JButton jb = newProcessingFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_newProcessingFormatActionPerformed

    private void newProcessingFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProcessingFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.newProcessingFormat;
        JTextField jtf = newProcessingFormat;
        JButton jb = newProcessingFormatInsert;
        String preText = "_TRATAR_NUEVO";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_newProcessingFormatInsertActionPerformed

    private void newProcessingFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newProcessingFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = newProcessingFormat;
        String preText = "_TRATAR_NUEVO";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_newProcessingFormatFocusGained

    private void newProcessingFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newProcessingFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = newProcessingFormat;
        String preText = "";
        Color c = Gray;
        String postText = "_TRATAR_NUEVO";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_newProcessingFormatFocusLost

    private void associationFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associationFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.associationFormat;
        JTextField jtf = associationFormat;
        JButton jb = associationFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_associationFormatActionPerformed

    private void associationFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associationFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.associationFormat;
        JTextField jtf = associationFormat;
        JButton jb = associationFormatInsert;
        String preText = "X_ASOCIAR_SINTAX";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_associationFormatInsertActionPerformed

    private void associationFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_associationFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = associationFormat;
        String preText = "X_ASOCIAR_SINTAX";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_associationFormatFocusGained

    private void associationFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_associationFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = associationFormat;
        String preText = "";
        Color c = Gray;
        String postText = "X_ASOCIAR_SINTAX";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_associationFormatFocusLost

    private void specialEventFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialEventFormatActionPerformed
        // TODO add your handling code here:
        int Index = Controller.specialEventFormat;
        JTextField jtf = specialEventFormat;
        JButton jb = specialEventFormatInsert;
        String preText = "";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_specialEventFormatActionPerformed

    private void specialEventFormatInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialEventFormatInsertActionPerformed
        // TODO add your handling code here:
        int Index = Controller.specialEventFormat;
        JTextField jtf = specialEventFormat;
        JButton jb = specialEventFormatInsert;
        String preText = "_SPECIAL_";

        opActions(Index, jtf, jb, preText);
    }//GEN-LAST:event_specialEventFormatInsertActionPerformed

    private void specialEventFormatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_specialEventFormatFocusGained
        // TODO add your handling code here:
        JTextField jtf = specialEventFormat;
        String preText = "_SPECIAL_";
        Color c = Black;
        String postText = "";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_specialEventFormatFocusGained

    private void specialEventFormatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_specialEventFormatFocusLost
        // TODO add your handling code here:
        JTextField jtf = specialEventFormat;
        String preText = "";
        Color c = Gray;
        String postText = "_SPECIAL_";

        opFocus(jtf, preText, c, postText);
    }//GEN-LAST:event_specialEventFormatFocusLost
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Acciones de la Interfaz de Operaciones ">
    private void opActions(int Index, JTextField jtf, JButton jb, String preText) {
        if (!jtf.getText().equalsIgnoreCase(preText)) {
            Deliver d = new Deliver();
            Controller c = new Controller();
            d.setDestination(this);
            if (syntaxArea.isEditable()) {
                c.controller(Index, jtf.getText());
                if (preText.equalsIgnoreCase("")) {
                    jtf.setForeground(Black);
                } else {
                    jtf.setForeground(Gray);
                }
                jtf.setText(preText);
                jb.requestFocus();
            } else {
                msgError.setVisible(true);
                String msg = "<html><b>Error</b>: failed insert operation"
                        + "<br><i>Cause</i>: Edit Code Locked</html>";
                msgErrorLabel.setText(msg);
            }
        }
    }

    private void opFocus(JTextField jtf, String preText, Color c, String postText) {
        if (jtf.getText().equalsIgnoreCase(preText)) {
            jtf.setForeground(c);
            jtf.setText(postText);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Make's Room ">
    private String preMakeRoom(javax.swing.JTextArea Area) {
        String bs = "";
        int act = Area.getCaretPosition();
        try {
            String sig = Area.getText(act - 1, 1);
            if (!sig.equalsIgnoreCase("\n")) {
                //Area.insert("\n", Area.getCaretPosition());
                bs = "\n";
            }
        } catch (BadLocationException ex) {
        }
        return bs;
    }

    private String postMakeRoom(javax.swing.JTextArea Area) {
        String bs = "";
        int act = Area.getCaretPosition();
        Area.setCaretPosition(Area.getDocument().getLength());
        int fin = Area.getCaretPosition();
        Area.setCaretPosition(act);
        try {
            String sig = Area.getText(act, 1);
            if (act != fin && sig.equalsIgnoreCase("\n")) {
                Area.setCaretPosition(Area.getCaretPosition() + 1);
            } else {
                //Area.insert("\n", Area.getCaretPosition());
                bs = "\n";
            }
        } catch (BadLocationException ex) {
            //Area.insert("\n", Area.getCaretPosition());
            bs = "\n";
        }
        return bs;
    }

    /**
     * Inserta el parametro String en el parametor JTextArea haciendo un "hueco"
     * en el texto, si fuera necesario
     *
     * @param Area JTextArea
     * @param str String
     */
    private void insertText(javax.swing.JTextArea Area, String str) {
        Area.insert(preMakeRoom(Area) + str
                + postMakeRoom(Area), Area.getCaretPosition());
    }
    //</editor-fold>

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoadEvent;
    private javax.swing.JButton LoadSyntax;
    private javax.swing.JButton NDataBase;
    private javax.swing.JButton NOperation;
    private javax.swing.JButton NTable;
    private javax.swing.JButton NVariable;
    private javax.swing.JFrame NewOperation;
    private javax.swing.JButton SaveSyntax;
    private javax.swing.JTextField associationFormat;
    private javax.swing.JButton associationFormatInsert;
    private javax.swing.JTextField basicProcessingFormat;
    private javax.swing.JButton basicProcessingFormatInsert;
    private javax.swing.JTextField commandFormatExe;
    private javax.swing.JButton commandFormatExeInsert;
    private javax.swing.JTextField commandFormatSintax;
    private javax.swing.JButton commandFormatSintaxInsert;
    private javax.swing.JTextField compAsigOperationSintax;
    private javax.swing.JButton compAsigOperationSintaxInsert;
    private javax.swing.JTextField concatOperationSintax;
    private javax.swing.JButton concatOperationSintaxInsert;
    private javax.swing.JButton deshacer;
    private javax.swing.JTextArea eventArea;
    private javax.swing.JTextField failureManagerFormat;
    private javax.swing.JButton failureManagerFormatInsert;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JDialog msgError;
    private javax.swing.JButton msgErrorButton;
    private javax.swing.JLabel msgErrorLabel;
    private javax.swing.JTextField newProcessingFormat;
    private javax.swing.JButton newProcessingFormatInsert;
    private javax.swing.JTextField orderFormat;
    private javax.swing.JButton orderFormatInsert;
    private javax.swing.JTextField specialEventFormat;
    private javax.swing.JButton specialEventFormatInsert;
    private javax.swing.JTextArea syntaxArea;
    // End of variables declaration//GEN-END:variables
}