import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		loginPage.dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
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
	public mainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 331, 262);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnListarUsurios = new JButton("Listar usu\u00E1rios");
		btnListarUsurios.setBounds(10, 11, 143, 58);
		frame.getContentPane().add(btnListarUsurios);
		
		JButton btnDeletarUsurios = new JButton("Deletar usu\u00E1rios");
		btnDeletarUsurios.setEnabled(false);
		btnDeletarUsurios.setBounds(10, 86, 143, 58);
		frame.getContentPane().add(btnDeletarUsurios);
		
		JButton btnCriarUsurioMestre = new JButton("Novo usu\u00E1rio");
		btnCriarUsurioMestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUserPage.main(null);
			}
		});
		btnCriarUsurioMestre.setBounds(10, 155, 143, 58);
		frame.getContentPane().add(btnCriarUsurioMestre);
		
		JButton btnAlterarSenhas = new JButton("Alterar senhas");
		btnAlterarSenhas.setEnabled(false);
		btnAlterarSenhas.setBounds(163, 11, 143, 58);
		frame.getContentPane().add(btnAlterarSenhas);
		
		JButton btnAlterarLogin = new JButton("Alterar Login");
		btnAlterarLogin.setEnabled(false);
		btnAlterarLogin.setBounds(163, 86, 143, 58);
		frame.getContentPane().add(btnAlterarLogin);
		
		JButton btnAlterarNome = new JButton("Alterar nome");
		btnAlterarNome.setEnabled(false);
		btnAlterarNome.setBounds(163, 155, 143, 58);
		frame.getContentPane().add(btnAlterarNome);
	}

}
