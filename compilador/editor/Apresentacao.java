package compilador.editor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class Apresentacao {

	private JFrame frame;
	private static JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		// colocando tamanho min para a janela
		frame.setMinimumSize(new Dimension(900,630));
		frame.setBounds(100, 100, 900, 630);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(160, 0, 715, 570);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spEditor = new JScrollPane();
		spEditor.setBounds(10, 11, panel.getWidth()-20, panel.getHeight()-130);
		panel.add(spEditor);
		spEditor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spEditor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextArea editor = new JTextArea();
		editor.setBorder(new NumberedBorder());
		spEditor.setViewportView(editor);
		
		JScrollPane spTA = new JScrollPane();
		spTA.setBounds(10, 459, 695, 100);
		panel.add(spTA);
		spTA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spTA.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		spTA.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 11, 160, 559);
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spEditor, spTA);
		splitPane.setResizeWeight(0.8); // Define a proporção inicial do tamanho do editor e da textArea
		panel.add(splitPane);
		splitPane.setBounds(10, 11, 695, 548);
			
		frame.addComponentListener(new ComponentAdapter() {
				
			@Override
			public void componentResized(ComponentEvent e) {
				// resized painel 1
				panel.setBounds(160, 0, frame.getWidth()-185, frame.getHeight()-60);
				spEditor.setBounds(10, 11, panel.getWidth()-20, panel.getHeight()-130);
				spTA.setBounds(10, spEditor.getHeight()+15, panel.getWidth()-20, (panel.getHeight()-450));
				tf.setBounds(10, panel.getHeight(), frame.getWidth()-45, 20);
				
				// resized slipPane
				splitPane.setBounds(10, 11, panel.getWidth()-20, panel.getHeight()-20);
				 // Define a proporção atual do tamanho do editor e da textArea
				splitPane.setDividerLocation(0.8);
			}
		});

		ImageIcon novo = getCaminhoDaImagem("imagens/novo.png");
		JButton btnNovo = new JButton();
		btnNovo.setIcon(novo);
		btnNovo.setText("Novo (Ctrl + N)");
		btnNovo.setBounds(0, 6, 160, 42);
		panel_2.add(btnNovo);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editor.setText("");
				textArea.setText("");
				tf.setText("");
			}
		});
		
		// Configura o atalho de teclado Ctrl + N para o botão
        InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("control N"), "newAction");
        ActionMap actionMap = panel.getActionMap();
        actionMap.put("newAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	editor.setText("");
				textArea.setText("");
				tf.setText("");
            }
        });
		
        ImageIcon abrir = getCaminhoDaImagem("imagens/abrir.png");
		JButton btnAbrir = new JButton();
		btnAbrir.setIcon(abrir);
		btnAbrir.setText("Abrir (Ctrl + O)");
		btnAbrir.setBounds(0, 59, 160, 42);
		panel_2.add(btnAbrir);
		btnAbrir.addActionListener(e -> {
			BarraFerramentas.abrir(editor, textArea, tf);
		});
		
		// Configura o atalho de teclado Ctrl + O para o botão
        InputMap inputMap2 = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke("control O"), "openAction");
        ActionMap actionMap2 = panel.getActionMap();
        actionMap2.put("openAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	BarraFerramentas.abrir(editor, textArea, tf);
            }
        });
		
        ImageIcon salvar = getCaminhoDaImagem("imagens/salvar.png");
		JButton btnSalvar = new JButton();
		btnSalvar.setIcon(salvar);
		btnSalvar.setText("Salvar (Ctrl + S)");
		btnSalvar.setBounds(0, 112, 160, 42);
		panel_2.add(btnSalvar);
		btnSalvar.addActionListener(e -> BarraFerramentas.salvar(editor, textArea, tf));
		
		// Configura o atalho de teclado Ctrl + S para o botão
        InputMap inputMap3 = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke("control S"), "saveAction");
        ActionMap actionMap3 = panel.getActionMap();
        actionMap3.put("saveAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione o código para salvar o arquivo aqui
                BarraFerramentas.salvar(editor, textArea, tf);
            }
        });
		
        ImageIcon copiar = getCaminhoDaImagem("imagens/copiar.png");
		JButton btnCopiar = new JButton();
		btnCopiar.setIcon(copiar);
		btnCopiar.setText("Copiar (Ctrl + C)");
		btnCopiar.setBounds(0, 165, 160, 42);
		panel_2.add(btnCopiar);
		btnCopiar.addActionListener(e -> BarraFerramentas.copiar(editor));
		
		ImageIcon colar = getCaminhoDaImagem("imagens/colar.png");
		JButton btnColar = new JButton();
		btnColar.setIcon(colar);
		btnColar.setText("Colar (Ctrl + V)");
		btnColar.setBounds(0, 218, 160, 42);
		panel_2.add(btnColar);
		btnColar.addActionListener(e -> BarraFerramentas.colar(editor));
		
		ImageIcon recortar = getCaminhoDaImagem("imagens/recortar.png");
		JButton btnRecortar = new JButton();
		btnRecortar.setIcon(recortar);
		btnRecortar.setText("Recortar (Ctrl + X)");
		btnRecortar.setBounds(0, 271, 160, 42);
		panel_2.add(btnRecortar);
		btnRecortar.addActionListener(e -> BarraFerramentas.recortar(editor));
		
		ImageIcon compilar = getCaminhoDaImagem("imagens/compilar.png");
		JButton btnCompilar = new JButton();
		btnCompilar.setIcon(compilar);
		btnCompilar.setText("Compilar (F7)");
		btnCompilar.setBounds(0, 318, 160, 42);
		panel_2.add(btnCompilar);
		btnCompilar.addActionListener(e -> {
			try {
				textArea.setText(BarraFerramentas.compilar(editor));
			} catch (BadLocationException | IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		
		// Configura o atalho de teclado F7 para o botão
        InputMap inputMap4 = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke("F7"), "compileAction");
        ActionMap actionMap4 = panel.getActionMap();
        actionMap4.put("compileAction", new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(BarraFerramentas.compilar(editor));
				} catch (BadLocationException | IOException ex) {
					throw new RuntimeException(ex);
				}
			}        	
        });
		
        ImageIcon equipe = getCaminhoDaImagem("imagens/equipe.png");
		JButton btnEquipe = new JButton();
		btnEquipe.setIcon(equipe);
		btnEquipe.setText("Equipe (F1)");
		btnEquipe.setBounds(0, 371, 160, 42);
		panel_2.add(btnEquipe);
		btnEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(BarraFerramentas.equipe());
			}
		});
		
		// Configura o atalho de teclado F1 para o botão
        InputMap inputMap5 = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap5.put(KeyStroke.getKeyStroke("F1"), "teamAction");
        ActionMap actionMap5 = panel.getActionMap();
        actionMap5.put("teamAction", new AbstractAction() {
        	public void actionPerformed(ActionEvent e) {
				textArea.setText(BarraFerramentas.equipe());
			}        	
        });
		
		tf = new JTextField();
		tf.setBackground(UIManager.getColor("Button.background"));
		tf.setBounds(10, 571, 864, 20);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
	}
	
	/**
	 * Retorna uma instância do {@link ImageIcon} de acordo com o caminho da imagem
	 * informada
	 * 
	 * @param caminho
	 * @return {@link ImageIcon}
	 */
	protected static ImageIcon getCaminhoDaImagem(String caminho) {
		return new ImageIcon(Apresentacao.class.getResource(caminho));
	}

}
