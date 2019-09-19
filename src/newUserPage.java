import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newUserPage {

	private JFrame frame;
	private JTextField iLogin;
	private JTextField iNome;
	private JPasswordField iSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newUserPage window = new newUserPage();
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
	public newUserPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 296, 218);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		iLogin = new JTextField();
		iLogin.setBounds(10, 26, 86, 20);
		frame.getContentPane().add(iLogin);
		iLogin.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 57, 46, 14);
		frame.getContentPane().add(lblNome);
		
		iNome = new JTextField();
		iNome.setBounds(10, 70, 86, 20);
		frame.getContentPane().add(iNome);
		iNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 101, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		iSenha = new JPasswordField();
		iSenha.setBounds(10, 113, 86, 20);
		frame.getContentPane().add(iSenha);
		
		JButton btnCriar = new JButton("Criar novo usu\u00E1rio");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!iLogin.getText().equals("")) && (!iNome.getText().equals("")) && (!String.valueOf(iSenha.getPassword()).equals("")) || (!iLogin.getText().equals(null)) && (!iNome.getText().equals(null)) && (!String.valueOf(iSenha.getPassword()).equals(null))) {
					if(ConnectDb.newUsuario(iLogin.getText(), String.valueOf(iSenha.getPassword()), iNome.getText())) {
						JOptionPane.showMessageDialog(null, "Não foi possivel inserir o usuario especificado");
					}else {
						JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos corretamente");
				}
			}
		});
		btnCriar.setBounds(109, 25, 161, 109);
		frame.getContentPane().add(btnCriar);
	}

}
