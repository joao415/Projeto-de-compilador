package compilador.editor;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

import compilador.LexicalError;
import compilador.Lexico;
import compilador.Token;

public class BarraFerramentas {
    JFileChooser fc;
    private static String caminho;

    public void setCaminho(String caminho) {
        BarraFerramentas.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public static void abrir(JTextArea editor, JTextArea textArea, JTextField tf) {
        JFileChooser fileChooser = new JFileChooser();
        File file;
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        } else {
            file = null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editor.setText(stringBuilder.toString());
        textArea.setText("");
        tf.setText(file.getParentFile().getName() + "\\" + file.getName());
        caminho = file.getAbsolutePath();
    }

    public static void salvar(JTextArea editor, JTextArea textArea, JTextField tf) {
        if (tf.getText().equals("")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    String text = editor.getText();
                    writer.write(text);
                    textArea.setText("");
                    tf.setText(fileChooser.getSelectedFile().getParentFile().getName() +
                            "\\" + fileChooser.getSelectedFile().getName());
                    caminho = fileChooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(null, "Arquivo salvo em " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            String filePath = caminho;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                String text = editor.getText();
                writer.write(text);
                textArea.setText("");
                JOptionPane.showMessageDialog(null, "Arquivo salvo em " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void colar(JTextArea editor) {
        // Obtém a área de transferência
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);

        // Verifica se há algum conteúdo
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                // Obtém o texto copiado e cola na área de texto
                String text = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                editor.insert(text, editor.getCaretPosition());
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void copiar(JTextArea editor) {
        // Obtém o texto selecionado
        String selectedText = editor.getSelectedText();

        // Copia o texto para a área de transferência
        if (selectedText != null) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(selectedText);
            clipboard.setContents(selection, null);
        }
    }

    public static void recortar(JTextArea editor) {
        // Obtém o texto selecionado
        String selectedText = editor.getSelectedText();

        // Copia o texto para a área de transferência
        if (selectedText != null) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(selectedText);
            clipboard.setContents(selection, null);

            // Remove o texto selecionado da área de texto
            int start = editor.getSelectionStart();
            int end = editor.getSelectionEnd();
            editor.replaceRange("", start, end);
        }
    }

    public static String compilar(JTextArea editor) throws BadLocationException {
    	Lexico lexico = new Lexico();
		lexico.setInput(editor.getText());
		String resultado = "";
		Token t = null;
		String ancor = editor.getText();
		String fill ="";
		int linha, indice;
        try {
        	 while ((t = lexico.nextToken()) != null) {
                 indice = ancor.indexOf(t.getLexeme());
                 for(int i =0; i<t.getLexeme().length(); i++) {
                	 fill += " ";
                 }
                 ancor = ancor.replaceFirst(t.getLexeme(), fill);
                 linha = editor.getLineOfOffset(indice) + 1;

                 switch (t.getId()) {
                     case 2:
                         resultado += linha + " identificador " + t.getLexeme();
                     break;
                     case 3:
                         resultado += linha + " constante_int " + t.getLexeme();
                     break;
                     case 4:
                         resultado += linha + " constante_float " + t.getLexeme();
                     break;
                     case 5:
                         resultado += linha + " constante_binaria " + t.getLexeme();
                     break;
                     case 6:
                         resultado += linha + " constante_string " + t.getLexeme();
                     break;
                     case 7:
                     case 8:
                     case 9:
                     case 10:
                     case 11:
                     case 12:
                     case 13:
                     case 14:
                     case 15:
                     case 16:
                     case 17:
                     case 18:
                         resultado += linha + " palavra reservada " + t.getLexeme();
                         break;
                     case 19:
                     case 20:
                     case 21:
                     case 22:
                     case 23:
                     case 24:
                     case 25:
                     case 26:
                     case 27:
                     case 28:
                     case 29:
                     case 30:
                     case 31:
                     case 32:
                     case 33:
                     case 34:
                         resultado += linha + " simbolo especial " + t.getLexeme();
                         break;
                 }

                 resultado += "\n";
                 fill = "";
        }
        }
        	 
        catch (LexicalError e) {
            indice = editor.getText().indexOf(e.getLexema());
            linha = editor.getLineOfOffset(indice) + 1;
            return "Erro na linha " + linha + " - " + e.getLexema() + " " + e.getMessage();
        }

        return resultado;
    }

    public static String equipe() {
        return "Equipe 01:\n"
                + "Ana Caroline Cipriani dos Santos;\n"
                + "Guilherme Soares;\n"
                + "Joao Marcelo Schneider da Silva e Souza.";
    }
}
