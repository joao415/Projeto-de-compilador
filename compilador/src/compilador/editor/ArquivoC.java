package compilador.editor;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArquivoC extends JPanel
                             implements ActionListener {
    static private final String newline = "\n";
    JButton openButton;
    JTextArea log;
    JFileChooser fc;

    public ArquivoC() {
        super(new BorderLayout());

        //Create a file chooser
        fc = new JFileChooser();

        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(ArquivoC.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());}

    }

}