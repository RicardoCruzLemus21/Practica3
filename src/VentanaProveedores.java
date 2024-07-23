import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaProveedores extends JFrame {
	
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bdproductos";
	private static final String usuario="root";
	private static final String clave="ricardoconexion123";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textpnombreempresa;
	private JTextField textpnombrecontacto;
	private JTextField textpdireccion;
	private JTextField textptelefono;
	private JTextField textpemail;
	private JTextField textpcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProveedores frame = new VentanaProveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
public static Connection Conexion(){
		
		Connection conex=null;
		
		try {
			Class.forName(driver);
			conex=DriverManager.getConnection(url, usuario, clave);
		}catch(Exception e){
			System.out.println("Error en la conexion a la BD\n" + e.getMessage().toString());
		
		}	
		
		return conex;
	}

void limpiar() {	
	textpnombreempresa.setText(null);
	textpnombrecontacto.setText(null);	
	textpdireccion.setText(null);
	textptelefono.setText(null);
	textpemail.setText(null);
	textpcodigo.setText(null);
}
	
	
	/**
	 * Create the frame.
	 */
	public VentanaProveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("< Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal frame1 = new Principal();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 17, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Proveedores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 15, 148, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la empresa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(26, 72, 216, 20);
		contentPane.add(lblNewLabel_1);
		
		textpnombreempresa = new JTextField();
		textpnombreempresa.setBounds(252, 72, 164, 20);
		contentPane.add(textpnombreempresa);
		textpnombreempresa.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre del contacto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(26, 120, 216, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(26, 166, 97, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(26, 213, 97, 20);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Email:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3_1.setBounds(26, 255, 76, 20);
		contentPane.add(lblNewLabel_1_3_1);
		
		textpnombrecontacto = new JTextField();
		textpnombrecontacto.setColumns(10);
		textpnombrecontacto.setBounds(252, 123, 164, 20);
		contentPane.add(textpnombrecontacto);
		
		textpdireccion = new JTextField();
		textpdireccion.setColumns(10);
		textpdireccion.setBounds(130, 169, 164, 20);
		contentPane.add(textpdireccion);
		
		textptelefono = new JTextField();
		textptelefono.setColumns(10);
		textptelefono.setBounds(130, 216, 164, 20);
		contentPane.add(textptelefono);
		
		textpemail = new JTextField();
		textpemail.setColumns(10);
		textpemail.setBounds(130, 258, 164, 20);
		contentPane.add(textpemail);
		
		textpcodigo = new JTextField();
		textpcodigo.setBounds(498, 75, 86, 20);
		contentPane.add(textpcodigo);
		textpcodigo.setColumns(10);
		
		JButton btnpbuscar = new JButton("Buscar por id ");
		btnpbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					String sqlconsulta = "SELECT * FROM proveedor WHERE idProveedor = ?";
					PreparedStatement pstnt = conex.prepareStatement(sqlconsulta);
					
					pstnt.setInt(1, Integer.parseInt(textpcodigo.getText()));
					ResultSet rs = pstnt.executeQuery();
					
					if(rs .next()) {
						
						textpcodigo.setText(rs.getString("idProveedor"));
						textpnombreempresa.setText(rs.getString("nombre_empresa"));
						textpnombrecontacto.setText(rs.getString("nombre_contacto"));
						textpdireccion.setText(rs.getString("direccion"));
						textptelefono.setText(rs.getString("telefono"));
						textpemail.setText(rs.getString("email"));
						
						
					}else {
						JOptionPane.showInternalMessageDialog(null, "No existe el registro en la BD");
					}
					
					conex.close();
					
					
					}catch(Exception ex) {
						System.out.println(ex);
						limpiar();				
					}
				
			}
		});
		
		
		btnpbuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpbuscar.setBounds(476, 106, 141, 23);
		contentPane.add(btnpbuscar);
		
		JButton btnpagregar = new JButton("Agregar");
		btnpagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					//Insert a la BD
					
					String sqlinsert = "INSERT INTO proveedor(nombre_empresa, nombre_contacto, direccion, telefono, email) VALUES(?, ?, ?, ?, ?)";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlinsert);
					
					
					pstnt.setString(1, textpnombreempresa.getText());
					pstnt.setString(2, textpnombrecontacto.getText());
					pstnt.setString(3, textpdireccion.getText());
					pstnt.setString(4, textptelefono.getText());
					pstnt.setString(5, textpemail.getText());
										
					
					int res = pstnt.executeUpdate();
					if(res > 0) {
						JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "No se insertaron registros en la BD");
					}
					limpiar();					
					conex.close();
					
				}catch(Exception ex) {
					System.out.println(ex);
					limpiar();
					
				}
				
			}
		});
		
		
		btnpagregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpagregar.setBounds(497, 150, 106, 23);
		contentPane.add(btnpagregar);
		
		JButton btnpmodificar = new JButton("Modificar");
		btnpmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					//Insert a la BD
					
					String sqlupdate = "UPDATE proveedor SET nombre_empresa=?, nombre_contacto=?, direccion=?, telefono=?, email=? WHERE idProveedor=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlupdate);
					
					pstnt.setString(1, textpnombreempresa.getText());
					pstnt.setString(2, textpnombrecontacto.getText());
					pstnt.setString(3, textpdireccion.getText());
					pstnt.setString(4, textptelefono.getText());
					pstnt.setString(5, textpemail.getText());
					pstnt.setString(6, textpcodigo.getText());
					
					int res = pstnt.executeUpdate();
					if(res > 0) {
						JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "No se midificaron registros en la BD");
					}
					limpiar();					
					conex.close();
					
				}catch(Exception ex) {
					System.out.println(ex);
					limpiar();
					
				}
				
			}
		});
		
		
		btnpmodificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpmodificar.setBounds(498, 191, 106, 23);
		contentPane.add(btnpmodificar);
		
		JButton btnpeliminar = new JButton("Eliminar");
		btnpeliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					//Insert a la BD
					
					String sqldelete = "DELETE FROM proveedor WHERE idProveedor=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqldelete);
					
					pstnt.setInt(1, Integer.parseInt(textpcodigo.getText()));
					
					int res = pstnt.executeUpdate();
					
					if(res > 0) {
						JOptionPane.showMessageDialog(null, "Datos eleminados correctamente");
						
					}else {
						JOptionPane.showMessageDialog(null, "No se eliminaron registros en la BD");
					}
					limpiar();					
					conex.close();
					
				}catch(Exception ex) {
					System.out.println(ex);
					limpiar();
					
				}
				
			}
		});
		btnpeliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpeliminar.setBounds(497, 228, 106, 23);
		contentPane.add(btnpeliminar);
	}
}
