package gui.relatorios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class FrmRelatorioLucro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRelatorioLucro frame = new FrmRelatorioLucro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRelatorioLucro() {
		setBounds(100, 100, 450, 300);

	}

}
