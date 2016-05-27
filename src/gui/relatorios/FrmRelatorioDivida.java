package gui.relatorios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class FrmRelatorioDivida extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRelatorioDivida frame = new FrmRelatorioDivida();
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
	public FrmRelatorioDivida() {
		setBounds(100, 100, 450, 300);

	}

}
