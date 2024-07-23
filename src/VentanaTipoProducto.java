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

public class VentanaTipoProducto extends JFrame {
	
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bdproductos";
	private static final String usuario="root";
	private static final String clave="ricardoconexion123";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texttnombre;
	private JTextField texttdescripcion;
	private JTextField texttcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTipoProducto frame = new VentanaTipoProducto();
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
	texttnombre.setText(null);
	texttdescripcion.setText(null);	
	texttcodigo.setText(null);
}

	/**
	 * Create the frame.
	 */
	public VentanaTipoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 309);
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
		btnNewButton.setBounds(10, 21, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tipo de producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(134, 13, 202, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(36, 93, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		texttnombre = new JTextField();
		texttnombre.setBounds(134, 93, 133, 20);
		contentPane.add(texttnombre);
		texttnombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(36, 147, 110, 23);
		contentPane.add(lblNewLabel_1_1);
		
		texttdescripcion = new JTextField();
		texttdescripcion.setColumns(10);
		texttdescripcion.setBounds(156, 151, 215, 20);
		contentPane.add(texttdescripcion);
		
		texttcodigo = new JTextField();
		texttcodigo.setBounds(411, 82, 86, 20);
		contentPane.add(texttcodigo);
		texttcodigo.setColumns(10);
		
		JButton btntbuscar = new JButton("Buscar por id");
		btntbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					String sqlconsulta = "SELECT * FROM tipoproducto WHERE idTipoproducto = ?";
					PreparedStatement pstnt = conex.prepareStatement(sqlconsulta);
					
					pstnt.setInt(1, Integer.parseInt(texttcodigo.getText()));
					ResultSet rs = pstnt.executeQuery();
					
					if(rs .next()) {
						
						texttcodigo.setText(rs.getString("idTipoproducto"));
						texttnombre.setText(rs.getString("nombre"));
						texttdescripcion.setText(rs.getString("descripcion"));
						
						
					}else {
						JOptionPane.showInternalMessageDialog(null, "No existe el registro en la BD");
					}
					
					conex.close();
					
					
					}catch(Exception ex) {
						System.out.println(ex);
						limpiar();				
					}
				
				/*
				Connection conex = null;

				try {
				    conex = Conexion();

				    if (conex != null) {
				        System.out.println("Conexión a BD Correcta");
				    } else {
				        System.out.println("No se pudo conectar a la BD");
				    }

				    String sqlConsulta = "SELECT * FROM tipoproducto WHERE idTipoproducto = ? OR nombre = ? OR descripcion = ?";
				    PreparedStatement pstnt = conex.prepareStatement(sqlConsulta);

				    pstnt.setInt(1, Integer.parseInt(texttcodigo.getText()));
				    pstnt.setString(2, texttnombre.getText());
				    pstnt.setString(3, texttdescripcion.getText());

				    ResultSet rs = pstnt.executeQuery();

				    if (rs.next()) {
				        texttcodigo.setText(rs.getString("idTipoproducto"));
				        texttnombre.setText(rs.getString("nombre"));
				        texttdescripcion.setText(rs.getString("descripcion"));
				    } else {
				        JOptionPane.showInternalMessageDialog(null, "No existe el registro en la BD");
				    }

				    conex.close();
				} catch (Exception ex) {
				    System.out.println(ex);
				    limpiar();
				}
				*/

				
			}
		});
		btntbuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntbuscar.setBounds(383, 111, 139, 23);
		contentPane.add(btntbuscar);
		
		JButton btntagregar = new JButton("Agregar");
		btntagregar.addActionListener(new ActionListener() {
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
					
					String sqlinsert = "INSERT INTO tipoproducto(nombre, descripcion) VALUES(?, ?)";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlinsert);
					
					
					pstnt.setString(1, texttnombre.getText());
					pstnt.setString(2, texttdescripcion.getText());
					
					
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
		
		
		btntagregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntagregar.setBounds(394, 148, 110, 23);
		contentPane.add(btntagregar);
		
		JButton btntmodificar = new JButton("Modificar");
		btntmodificar.addActionListener(new ActionListener() {
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
					
					String sqlupdate = "UPDATE tipoproducto SET  nombre=?, descripcion=? WHERE idTipoproducto=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlupdate);
					
					pstnt.setString(1, texttnombre.getText());
					pstnt.setString(2, texttdescripcion.getText());
					pstnt.setString(3, texttcodigo.getText());
					
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
		btntmodificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntmodificar.setBounds(394, 182, 110, 23);
		contentPane.add(btntmodificar);
		
		JButton btnteliminar = new JButton("Eliminar");
		btnteliminar.addActionListener(new ActionListener() {
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
					
					String sqldelete = "DELETE FROM tipoproducto WHERE idTipoproducto=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqldelete);
					
					pstnt.setInt(1, Integer.parseInt(texttcodigo.getText()));
					
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
		btnteliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnteliminar.setBounds(394, 216, 110, 23);
		contentPane.add(btnteliminar);
	}

}
