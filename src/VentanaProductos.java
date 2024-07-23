import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class VentanaProductos extends JFrame {

	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bdproductos";
	private static final String usuario="root";
	private static final String clave="ricardoconexion123";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textpronombre;
	private JTextField textprodescripcion;
	private JTextField textproventa;
	private JTextField textprocosto;
	private JTextField textprostock;
	private JTextField textprocodigo;
	private JTextField texttipoid;
	private JTextField textproid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProductos frame = new VentanaProductos();
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
		textpronombre.setText(null);
		textprodescripcion.setText(null);	
		textproventa.setText(null);
		textprocosto.setText(null);
		textprostock.setText(null);
		texttipoid.setText(null);
		textproid.setText(null);
		textprocodigo.setText(null);
		
	}
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public VentanaProductos() {
		
		
	    
					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 593);
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
		btnNewButton.setBounds(32, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(284, 11, 123, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(75, 76, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		textpronombre = new JTextField();
		textpronombre.setBounds(157, 76, 147, 20);
		contentPane.add(textpronombre);
		textpronombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(75, 112, 113, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio de venta:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(75, 148, 147, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Precio de costo:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(75, 181, 137, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Stock:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(75, 213, 88, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textprodescripcion = new JTextField();
		textprodescripcion.setColumns(10);
		textprodescripcion.setBounds(188, 112, 147, 20);
		contentPane.add(textprodescripcion);
		
		textproventa = new JTextField();
		textproventa.setColumns(10);
		textproventa.setBounds(218, 148, 147, 20);
		contentPane.add(textproventa);
		
		textprocosto = new JTextField();
		textprocosto.setColumns(10);
		textprocosto.setBounds(222, 181, 147, 20);
		contentPane.add(textprocosto);
		
		textprostock = new JTextField();
		textprostock.setColumns(10);
		textprostock.setBounds(136, 213, 147, 20);
		contentPane.add(textprostock);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Tipo de producto:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4_1.setBounds(20, 293, 168, 18);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Proveedor:");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4_2.setBounds(26, 418, 95, 14);
		contentPane.add(lblNewLabel_1_4_2);
		
		JButton btnprobuscar = new JButton("Buscar por id");
		btnprobuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conex = null;
				
				try {
					conex = Conexion();
					
					if(conex != null) {
						System.out.println("Conexion a BD Correcta");
					}else {
						System.out.println("No se pudo conectar a la BD");
					}
					
					String sqlconsulta = "SELECT * FROM productos WHERE idProductos = ?";
					PreparedStatement pstnt = conex.prepareStatement(sqlconsulta);
					
					pstnt.setInt(1, Integer.parseInt(textprocodigo.getText()));
					ResultSet rs = pstnt.executeQuery();
					
					if(rs .next()) {
						
						textprocodigo.setText(rs.getString("idProductos"));
						textpronombre.setText(rs.getString("nombre"));
						textprodescripcion.setText(rs.getString("descripcion"));
						textproventa.setText(rs.getString("precio_venta"));
						textprocosto.setText(rs.getString("precio_costo"));
						textprostock.setText(rs.getString("Stock"));
						texttipoid.setText(rs.getString("Tipoproducto_idTipoproducto"));
						textproid.setText(rs.getString("Proveedor_idProveedor"));
						
						
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
		btnprobuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnprobuscar.setBounds(445, 73, 137, 23);
		contentPane.add(btnprobuscar);
		
		textprocodigo = new JTextField();
		textprocodigo.setBounds(470, 43, 86, 20);
		contentPane.add(textprocodigo);
		textprocodigo.setColumns(10);
		
		JButton btnproagregar = new JButton("Agregar");
		btnproagregar.addActionListener(new ActionListener() {
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
					
					String sqlinsert = "INSERT INTO productos(nombre, descripcion, Precio_venta, Precio_costo, Stock, Tipoproducto_idTipoproducto, Proveedor_idProveedor) VALUES(?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlinsert);
					
					
					pstnt.setString(1, textpronombre.getText());
					pstnt.setString(2, textprodescripcion.getText());
					pstnt.setString(3, textproventa.getText());
					pstnt.setString(4, textprocosto.getText());
					pstnt.setString(5, textprostock.getText());
					pstnt.setString(6, texttipoid.getText());
					pstnt.setString(7, textproid.getText());
										
					
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
		btnproagregar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnproagregar.setBounds(464, 109, 108, 23);
		contentPane.add(btnproagregar);
		
		JButton btnpromodificar = new JButton("Modificar");
		btnpromodificar.addActionListener(new ActionListener() {
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
									
					
					String sqlupdate = "UPDATE productos SET nombre=?, descripcion=?, Precio_venta=?, Precio_costo=?, Stock=?, Tipoproducto_idTipoproducto=?,  Proveedor_idProveedor=? WHERE idProductos=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqlupdate);
					
					
					
				
					pstnt.setString(1, textpronombre.getText());
					pstnt.setString(2, textprodescripcion.getText());
					pstnt.setString(3, textproventa.getText());
					pstnt.setString(4, textprocosto.getText());
					pstnt.setString(5, textprostock.getText());
					pstnt.setString(6, texttipoid.getText());
					pstnt.setString(7, textproid.getText());
					pstnt.setString(8, textprocodigo.getText());
					
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
		
		
		btnpromodificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpromodificar.setBounds(464, 145, 108, 23);
		contentPane.add(btnpromodificar);
		
		JButton btnproeliminar = new JButton("Eliminar");
		btnproeliminar.addActionListener(new ActionListener() {
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
					
					String sqldelete = "DELETE FROM productos WHERE idProductos=?";
					
					PreparedStatement pstnt = conex.prepareStatement(sqldelete);
					
					pstnt.setInt(1, Integer.parseInt(textprocodigo.getText()));
					
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
		btnproeliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnproeliminar.setBounds(464, 178, 108, 23);
		contentPane.add(btnproeliminar);
		
		JButton btnproimprimir = new JButton("Imprimir reporte");
		btnproimprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReportGenerator reporte = new ReportGenerator();
				
				reporte.generateCSVReport();
				
			}
		});
		btnproimprimir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnproimprimir.setBounds(430, 229, 175, 23);
		contentPane.add(btnproimprimir);
		/*
		JList listprov = new JList();
		listprov.setBounds(22, 283, 370, 52);
		contentPane.add(listprov);
		
		 // Crear JScrollPane para listtipo
	    JScrollPane scrollPaneTipo = new JScrollPane(listprov);
	    scrollPaneTipo.setBounds(22, 283, 370, 52);
	    contentPane.add(scrollPaneTipo);
	    
		JList listtpro = new JList();
		listtpro.setBounds(20, 370, 370, 52);
		contentPane.add(listtpro);
		
		 // Crear JScrollPane para listid
	    JScrollPane scrollPaneId = new JScrollPane(listtpro);
	    scrollPaneId.setBounds(20, 370, 370, 52);
	    contentPane.add(scrollPaneId);
	    */
		
		
		JList listtpro = new JList();
		listtpro.setBounds(22, 322, 278, 79);
		contentPane.add(listtpro);
		JScrollPane scrollPaneId = new JScrollPane(listtpro);
	    scrollPaneId.setBounds(22, 322, 278, 79);
	    contentPane.add(scrollPaneId);
		
		
		JList listprov = new JList();
		listprov.setBounds(32, 455, 278, 85);
		contentPane.add(listprov);		
		JScrollPane scrollPaneTipo = new JScrollPane(listprov);
	    scrollPaneTipo.setBounds(32, 455, 278, 85);
	    contentPane.add(scrollPaneTipo);
		
		cargarDatosProveedorEnLista(listprov);
		cargarDatosTipoproductosEnLista(listtpro);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Buscar tipo de producto por id");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4_1_1.setBounds(352, 290, 278, 25);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		texttipoid = new JTextField();
		texttipoid.setColumns(10);
		texttipoid.setBounds(362, 335, 147, 20);
		contentPane.add(texttipoid);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Buscar proveedor por id");
		lblNewLabel_1_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_4_1_1_1.setBounds(352, 413, 253, 25);
		contentPane.add(lblNewLabel_1_4_1_1_1);
		
		textproid = new JTextField();
		textproid.setColumns(10);
		textproid.setBounds(365, 454, 147, 20);
		contentPane.add(textproid);
		
		
	}
	
	
	
	private void cargarDatosProveedorEnLista(JList listprov) {
	    Connection conex = null;
	    PreparedStatement pstmtQuery = null;
	    ResultSet resultSet = null;
	    
	    

	    try {
	        // Establecer la conexión a la base de datos
	        conex = Conexion();

	        // Verificar si la conexión se estableció correctamente
	        if (conex != null) {
	            System.out.println("Conexión a BD establecida correctamente");
	        } else {
	            System.out.println("No se pudo conectar a la BD");
	            return; // Salir del método si la conexión falla
	        }

	        // Consulta SQL para obtener datos de la tabla "proveedor"
	        String sqlQuery = "SELECT idProveedor, nombre_empresa FROM proveedor";
	        pstmtQuery = conex.prepareStatement(sqlQuery);
	        resultSet = pstmtQuery.executeQuery();

	        // Crear un modelo de lista para la lista listid
	        DefaultListModel listModel = new DefaultListModel();

	        // Recorrer los resultados y agregarlos al modelo de lista
	        while (resultSet.next()) {
	            int idProveedor = resultSet.getInt("idProveedor");
	            String nombreProveedor = resultSet.getString("nombre_empresa");
	            String item = idProveedor + " - " + nombreProveedor;
	            listModel.addElement(item);
	        }

	        // Establecer el modelo de lista en la lista listid
	        listprov.setModel(listModel);
	    } catch (Exception ex) {
	        System.err.println(ex);
	    } finally {
	        try {
	            // Cerrar recursos
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (pstmtQuery != null) {
	                pstmtQuery.close();
	            }
	            if (conex != null) {
	                conex.close();
	            }
	        } catch (Exception e) {
	            System.err.println(e);
	        }
	    }
	}
	
	
	private void cargarDatosTipoproductosEnLista(JList listtpro) {
	    Connection conex = null;
	    PreparedStatement pstmtQuery = null;
	    ResultSet resultSet = null;
	    
	    
	    
	    JList lista=new JList();

	    lista.setFont(new Font("Times-Roman", Font.BOLD, 20)); //Esto te demas pero esta bueno es para definirle el tipo y tamaño del texto.

	    JScrollPane scroll=new JScrollPane(lista);
	    
	    try {
	        // Establecer la conexión a la base de datos
	        conex = Conexion();

	        // Verificar si la conexión se estableció correctamente
	        if (conex != null) {
	            System.out.println("Conexión a BD establecida correctamente");
	        } else {
	            System.out.println("No se pudo conectar a la BD");
	            return; // Salir del método si la conexión falla
	        }

	        // Consulta SQL para obtener datos de la tabla "proveedor"
	        String sqlQuery = "SELECT idTipoproducto, nombre FROM tipoproducto";
	        pstmtQuery = conex.prepareStatement(sqlQuery);
	        resultSet = pstmtQuery.executeQuery();

	        // Crear un modelo de lista para la lista listid
	        DefaultListModel listModel = new DefaultListModel();

	        // Recorrer los resultados y agregarlos al modelo de lista
	        while (resultSet.next()) {
	            int idProveedor = resultSet.getInt("idTipoproducto");
	            String nombreProveedor = resultSet.getString("nombre");
	            String item = idProveedor + " - " + nombreProveedor;
	            listModel.addElement(item);
	        }

	        // Establecer el modelo de lista en la lista listid
	        listtpro.setModel(listModel);
	    } catch (Exception ex) {
	        System.err.println(ex);
	    } finally {
	        try {
	            // Cerrar recursos
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (pstmtQuery != null) {
	                pstmtQuery.close();
	            }
	            if (conex != null) {
	                conex.close();
	            }
	        } catch (Exception e) {
	            System.err.println(e);
	        }
	    }
	}
}
