package gui.operacoes.fluxo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class Devolver extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Devolver frame = new Devolver();
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
	public Devolver() {
		setBounds(100, 100, 450, 300);

	}

}
