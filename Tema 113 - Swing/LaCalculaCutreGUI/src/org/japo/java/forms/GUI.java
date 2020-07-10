/*
 * Copyright 2020 jonsui10.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JButton;
import org.japo.java.interfaces.ICalc;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author jns10
 */
public class GUI extends javax.swing.JFrame implements ICalc, KeyListener {

  private static final long serialVersionUID = 1L;

  // Referencias
  private final Properties prp;

  boolean init = true;

  private String sign;

  private double calcVal;

  Clipboard clipboard;
  Transferable transferable;

  /**
   * Creates new form GUI_
   *
   * @param prp
   */
  public GUI(Properties prp) {
    // Conectar Referencia
    this.prp = prp;

    // Inicialización Anterior
    initBefore();

    // Creación Interfaz
    initComponents();

    // Inicializacion Posterior
    initAfter();
  }
// Inicialización Anterior    

  private void initBefore() {
    // Establecer LnF
    UtilesSwing.establecerLnFProfile(prp.getProperty("look_and_feel_profile"));

  }

  // Inicialización Posterior
  private void initAfter() {
    // Establecer Favicon
    UtilesSwing.establecerFavicon(this, prp.getProperty("img_favicon_resource"));

    // Ventana Principal
    setTitle(prp.getProperty("form_title"));
//        int width = Integer.parseInt(prp.getProperty("form_width"));
//        int height = Integer.parseInt(prp.getProperty("form_height"));
//        setSize(width, height);
    setLocationRelativeTo(null);

    MainPanel.requestFocus();
    keyPad.setFocusable(true);
    screen.addKeyListener(this);

  }

  //brrrrr
  public void changeColor(JButton hover, Color rand) {
    hover.setBackground(rand);
  }

  //TECLAS CALCULADORA
  //Acciones pad calculadora
  private void press0() {
    if (!screen.getText().equals("0")) {
      if (init) {
        screen.setText("");
        screen.setText("0");
        init = false;
      } else {
        screen.setText(screen.getText() + "0");
      }
    }
  }

  private void press1() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("1");
        init = false;
      } else {
        screen.setText(screen.getText() + "1");
      }
    } else {
      screen.setText(screen.getText() + "1");
    }
  }

  private void press2() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("2");
        init = false;
      } else {
        screen.setText(screen.getText() + "2");
      }
    } else {
      screen.setText(screen.getText() + "2");
    }
  }

  private void press3() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("3");
        init = false;
      } else {
        screen.setText(screen.getText() + "3");
      }
    } else {
      screen.setText(screen.getText() + "3");
    }
  }

  private void press4() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("4");
        init = false;
      } else {
        screen.setText(screen.getText() + "4");
      }
    } else {
      screen.setText(screen.getText() + "4");
    }
  }

  private void press5() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("5");
        init = false;
      } else {
        screen.setText(screen.getText() + "5");
      }
    } else {
      screen.setText(screen.getText() + "5");
    }
  }

  private void press6() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("6");
        init = false;
      } else {
        screen.setText(screen.getText() + "6");
      }
    } else {
      screen.setText(screen.getText() + "6");
    }
  }

  private void press7() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("7");
        init = false;
      } else {
        screen.setText(screen.getText() + "7");
      }
    } else {
      screen.setText(screen.getText() + "7");
    }
  }

  private void press8() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("8");
        init = false;
      } else {
        screen.setText(screen.getText() + "8");
      }
    } else {
      screen.setText(screen.getText() + "8");
    }
  }

  private void press9() {
    if (screen.getText().equals("0")) {
      screen.setText("");
      if (init) {
        screen.setText("");
        screen.setText("9");
        init = false;
      } else {
        screen.setText(screen.getText() + "9");
      }
    } else {
      screen.setText(screen.getText() + "9");
    }
  }

  private void pressDot() {
    if (!screen.getText().contains(".")) {
      screen.setText(screen.getText() + ".");
      init = false;
    }
  }

  private void pressClear() {
    screen.setText("0");
    jLabel1.setText("");
    calcVal = 0;
  }

  private void pressSign() {
    String val = screen.getText();

    if (!val.contains("-")) {
      screen.setText("-" + val);
    } else {
      try {
        screen.setText(val.split("-")[1]);
      } catch (IndexOutOfBoundsException e) {
      }
    }
  }

  private void pressDiv() {
    sign = "/";
    if (screen.getText().length() > 0) {
      storeValue(sign);
    }
  }

  private void pressProd() {
    sign = "*";
    if (screen.getText().length() > 0) {
      if (calcVal != 0) {
        double numb = Double.parseDouble(screen.getText());
        doProd(calcVal, numb);
      }
      storeValue(sign);
    }
  }

  private void pressSum() {
    sign = "+";
    if (screen.getText().length() > 0) {
      if (calcVal != 0) {
        double numb = Double.parseDouble(screen.getText());
        doSum(calcVal, numb);
      }
      storeValue(sign);
    }
  }

  private void pressPercent() {
    if (jLabel1.getText().length() > 0 && screen.getText().length() > 0) {
      calcVal = Double.parseDouble(screen.getText());
      doPerc(Double.parseDouble(jLabel1.getText().split(" ")[0]), calcVal);
      calcVal = 0;
    }
  }

  private void pressRes() {
    sign = "-";
    if (screen.getText().length() > 0) {
      if (calcVal != 0) {
        double numb = Double.parseDouble(screen.getText());
        doRes(calcVal, numb);
      } else if (jLabel1.getText().contains("-")) {
        double numb = Double.parseDouble(screen.getText());
        doRes(calcVal, numb);
      }
      storeValue(sign);
    }
  }

  private void pressEq() {

    try {
      if (screen.getText().length() > 0) {
        double b = Double.parseDouble(screen.getText());
        switch (sign) {
          case "+":
            doSum(calcVal, b);
            break;
          case "-":
            doRes(calcVal, b);
            break;
          case "*":
            doProd(calcVal, b);
            break;
          case "/":
            doDiv(calcVal, b);
            break;
        }
        calcVal = 0;
      }
    } catch (NumberFormatException numberFormatException) {
      screen.setText("0");
    }
  }

  private void storeValue(String sign) {
    String val = screen.getText();
    calcVal = Double.parseDouble(val);

    jLabel1.setText(val + " " + sign);
    screen.setText("0");
  }

  @Override
  public void doSum(double a, double b) {
    setResult(a + b);
  }

  @Override
  public void doRes(double a, double b) {
    setResult(a - b);
  }

  @Override
  public void doProd(double a, double b) {
    setResult(a * b);
  }

  @Override
  public void doDiv(double a, double b) {
    double div = a / b;

    if (b == 0) {
      screen.setText("Joanpaon Compra BTC!");
    } else {
      setResult(a / b);
    }

  }

  @Override
  public void doPerc(double a, double b) {
    switch (sign) {
      case "+":
        doSum((a * b / 100), a);
        break;
      case "-":
        doRes((a * b / 100), a);
        break;
      case "*":
        doProd((a * b / 100), a);
        break;
      case "/":
        doDiv((a * b / 100), a);
        break;
    }
  }

  private void setResult(double res) {

    if (Math.floor(res) == res) {
      screen.setText(String.valueOf((int) res));
      jLabel1.setText("");
    } else {
      screen.setText(Double.toString(res));
      jLabel1.setText("");

    }
  }

  private void copyClipboard() {
    clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection txt = new StringSelection("" + screen.getText());
    clipboard.setContents(txt, txt);
    screen.setText(screen.getText());
  }

  private void pasteClipboard() {
    clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    transferable = clipboard.getContents(null);
    if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      try {
        screen.setText("" + transferable.getTransferData(DataFlavor.stringFlavor));
      } catch (UnsupportedFlavorException | IOException e) {
      }
    }
  }

  //no va
  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    displayInfo(e, "KEY PRESSED: ");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    displayInfo(e, "KEY RELEASED: ");
  }

  private void displayInfo(KeyEvent e, String keyStatus) {
//...

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    MainPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    screen = new javax.swing.JTextField();
    keyPad = new javax.swing.JPanel();
    jButtonAC = new javax.swing.JButton();
    jButtonSign = new javax.swing.JButton();
    jButtonPercent = new javax.swing.JButton();
    jButtonDiv = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jButton9 = new javax.swing.JButton();
    jButtonProd = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jButtonRes = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButtonSum = new javax.swing.JButton();
    jButton0 = new javax.swing.JButton();
    jButtonDot = new javax.swing.JButton();
    jButtonEquals = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenuEdit = new javax.swing.JMenu();
    jMenuItemCopy = new javax.swing.JMenuItem();
    jMenuItemPaste = new javax.swing.JMenuItem();
    jMenuAbout = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 0, 51));
    setResizable(false);
    setType(java.awt.Window.Type.UTILITY);

    MainPanel.setBackground(new java.awt.Color(0, 0, 51));
    MainPanel.setPreferredSize(new java.awt.Dimension(230, 300));

    jLabel1.setBackground(new java.awt.Color(0, 0, 51));
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setToolTipText("");

    screen.setBackground(new java.awt.Color(101, 141, 198));
    screen.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    screen.setForeground(new java.awt.Color(243, 213, 173));
    screen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    screen.setText("0");
    screen.setBorder(null);
    screen.setFocusTraversalKeysEnabled(false);
    screen.setRequestFocusEnabled(false);

    keyPad.setBackground(new java.awt.Color(204, 204, 204));

    jButtonAC.setBackground(new java.awt.Color(117, 163, 229));
    jButtonAC.setText("AC");
    jButtonAC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonAC.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonAC.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButtonACMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jButtonACMouseEntered(evt);
      }
    });
    jButtonAC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonACActionPerformed(evt);
      }
    });

    jButtonSign.setBackground(new java.awt.Color(117, 163, 229));
    jButtonSign.setText("+/-");
    jButtonSign.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonSign.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonSign.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonSignActionPerformed(evt);
      }
    });

    jButtonPercent.setBackground(new java.awt.Color(117, 163, 229));
    jButtonPercent.setText("%");
    jButtonPercent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonPercent.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonPercent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonPercentActionPerformed(evt);
      }
    });

    jButtonDiv.setBackground(new java.awt.Color(83, 116, 163));
    jButtonDiv.setText("/");
    jButtonDiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonDiv.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonDiv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonDivActionPerformed(evt);
      }
    });

    jButton7.setBackground(new java.awt.Color(101, 141, 198));
    jButton7.setText("7");
    jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    jButton8.setBackground(new java.awt.Color(101, 141, 198));
    jButton8.setText("8");
    jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jButton9.setBackground(new java.awt.Color(101, 141, 198));
    jButton9.setText("9");
    jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton9.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9ActionPerformed(evt);
      }
    });

    jButtonProd.setBackground(new java.awt.Color(83, 116, 163));
    jButtonProd.setText("x");
    jButtonProd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonProd.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonProd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonProdActionPerformed(evt);
      }
    });

    jButton4.setBackground(new java.awt.Color(101, 141, 198));
    jButton4.setText("4");
    jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton4.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jButton5.setBackground(new java.awt.Color(101, 141, 198));
    jButton5.setText("5");
    jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton5.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jButton6.setBackground(new java.awt.Color(101, 141, 198));
    jButton6.setText("6");
    jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton6.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButtonRes.setBackground(new java.awt.Color(83, 116, 163));
    jButtonRes.setText("-");
    jButtonRes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonRes.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonRes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonResActionPerformed(evt);
      }
    });

    jButton1.setBackground(new java.awt.Color(101, 141, 198));
    jButton1.setText("1");
    jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setBackground(new java.awt.Color(101, 141, 198));
    jButton2.setText("2");
    jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton2.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setBackground(new java.awt.Color(101, 141, 198));
    jButton3.setText("3");
    jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton3.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButtonSum.setBackground(new java.awt.Color(83, 116, 163));
    jButtonSum.setText("+");
    jButtonSum.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonSum.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonSum.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonSumActionPerformed(evt);
      }
    });

    jButton0.setBackground(new java.awt.Color(101, 141, 198));
    jButton0.setText("0");
    jButton0.setToolTipText("0");
    jButton0.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButton0.setFocusPainted(false);
    jButton0.setPreferredSize(new java.awt.Dimension(50, 50));
    jButton0.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jButton0MouseEntered(evt);
      }
    });
    jButton0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton0ActionPerformed(evt);
      }
    });

    jButtonDot.setBackground(new java.awt.Color(101, 141, 198));
    jButtonDot.setText(".");
    jButtonDot.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonDot.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonDot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonDotActionPerformed(evt);
      }
    });

    jButtonEquals.setBackground(new java.awt.Color(83, 116, 163));
    jButtonEquals.setText("=");
    jButtonEquals.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));
    jButtonEquals.setPreferredSize(new java.awt.Dimension(50, 50));
    jButtonEquals.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonEqualsActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout keyPadLayout = new javax.swing.GroupLayout(keyPad);
    keyPad.setLayout(keyPadLayout);
    keyPadLayout.setHorizontalGroup(
      keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(keyPadLayout.createSequentialGroup()
        .addGap(1, 1, 1)
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(keyPadLayout.createSequentialGroup()
            .addComponent(jButtonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButtonSign, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButtonPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButtonDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(keyPadLayout.createSequentialGroup()
            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButtonProd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(keyPadLayout.createSequentialGroup()
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButtonRes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(keyPadLayout.createSequentialGroup()
            .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jButton0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, keyPadLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jButtonDot, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
              .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButtonSum, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButtonEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
    );
    keyPadLayout.setVerticalGroup(
      keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(keyPadLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButtonAC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonSign, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonProd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonRes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonSum, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(keyPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonDot, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
    MainPanel.setLayout(MainPanelLayout);
    MainPanelLayout.setHorizontalGroup(
      MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(screen)
      .addComponent(keyPad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    MainPanelLayout.setVerticalGroup(
      MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(MainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(keyPad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jMenuEdit.setText("Edit");

    jMenuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemCopy.setText("Copy");
    jMenuItemCopy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemCopyActionPerformed(evt);
      }
    });
    jMenuEdit.add(jMenuItemCopy);

    jMenuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItemPaste.setText("Paste");
    jMenuItemPaste.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemPasteActionPerformed(evt);
      }
    });
    jMenuEdit.add(jMenuItemPaste);

    jMenuBar1.add(jMenuEdit);

    jMenuAbout.setText("About");
    jMenuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jMenuAboutMouseClicked(evt);
      }
    });
    jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuAboutActionPerformed(evt);
      }
    });
    jMenuBar1.add(jMenuAbout);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonACMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonACMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jButtonACMouseClicked

  private void jButtonACMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonACMouseEntered
    // No me cambia de color, qué estoy haciendo mal? Gracias...
    changeColor(jButtonAC, Color.red);
  }//GEN-LAST:event_jButtonACMouseEntered

  private void jButtonACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonACActionPerformed
    pressClear();
  }//GEN-LAST:event_jButtonACActionPerformed

  private void jButtonSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignActionPerformed
    pressSign();
  }//GEN-LAST:event_jButtonSignActionPerformed

  private void jButtonPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPercentActionPerformed
    pressPercent();
  }//GEN-LAST:event_jButtonPercentActionPerformed

  private void jButtonDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivActionPerformed
    pressDiv();
  }//GEN-LAST:event_jButtonDivActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    press7();
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    press8();
  }//GEN-LAST:event_jButton8ActionPerformed

  private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    press9();
  }//GEN-LAST:event_jButton9ActionPerformed

  private void jButtonProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdActionPerformed
    pressProd();
  }//GEN-LAST:event_jButtonProdActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    press4();
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    press5();
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    press6();
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButtonResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResActionPerformed
    pressRes();
  }//GEN-LAST:event_jButtonResActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    press1();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    press2();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    press3();
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton0MouseEntered
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton0MouseEntered

  private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
    press0();
  }//GEN-LAST:event_jButton0ActionPerformed

  private void jButtonDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDotActionPerformed
    pressDot();
  }//GEN-LAST:event_jButtonDotActionPerformed

  private void jButtonEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEqualsActionPerformed
    pressEq();
  }//GEN-LAST:event_jButtonEqualsActionPerformed

  private void jButtonSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSumActionPerformed
    pressSum();
  }//GEN-LAST:event_jButtonSumActionPerformed

  private void jMenuItemPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPasteActionPerformed
    pasteClipboard();
  }//GEN-LAST:event_jMenuItemPasteActionPerformed

  private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
    openAbout();
  }//GEN-LAST:event_jMenuAboutActionPerformed

  private void jMenuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAboutMouseClicked
    openAbout();
  }//GEN-LAST:event_jMenuAboutMouseClicked

  private void jMenuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyActionPerformed
    copyClipboard();
  }//GEN-LAST:event_jMenuItemCopyActionPerformed

  private void openAbout() {
    About dialog = new About(this, true);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent e) {
        System.exit(0);
      }
    });
    dialog.setBounds(500, 500, dialog.getWidth(), dialog.getHeight());
    dialog.setVisible(true);
  }


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel MainPanel;
  private javax.swing.JButton jButton0;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JButton jButtonAC;
  private javax.swing.JButton jButtonDiv;
  private javax.swing.JButton jButtonDot;
  private javax.swing.JButton jButtonEquals;
  private javax.swing.JButton jButtonPercent;
  private javax.swing.JButton jButtonProd;
  private javax.swing.JButton jButtonRes;
  private javax.swing.JButton jButtonSign;
  private javax.swing.JButton jButtonSum;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JMenu jMenuAbout;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenu jMenuEdit;
  private javax.swing.JMenuItem jMenuItemCopy;
  private javax.swing.JMenuItem jMenuItemPaste;
  private javax.swing.JPanel keyPad;
  private javax.swing.JTextField screen;
  // End of variables declaration//GEN-END:variables

}
