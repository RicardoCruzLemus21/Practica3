import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ReportGenerator extends JFrame {
    
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bdproductos";
	private static final String usuario="root";
	private static final String clave="ricardoconexion123";

    public ReportGenerator() {
        
    	
    	/*
    	JButton btnproimprimir = new JButton("Imprimir informe");
        btnproimprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateCSVReport();
            }
        });
        */
        

        //getContentPane().add(btnproimprimir);
/*
        setTitle("Generador de Reportes");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
*/
    }

    public void generateCSVReport() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdproductos", "root", "ricardoconexion123");
            Statement stmt = conn.createStatement();

            String query = "SELECT idProductos, nombre, Precio_venta, Stock FROM productos";
            ResultSet rs = stmt.executeQuery(query);

            FileWriter csvWriter = new FileWriter("reporteproductos.csv");
            csvWriter.append("Codigo,Nombre,Precio,Stock\n");

            while (rs.next()) {
                csvWriter.append(rs.getString("idProductos") + ",");
                csvWriter.append(rs.getString("nombre") + ",");
                csvWriter.append(rs.getString("Precio_venta") + ",");
                csvWriter.append(rs.getString("Stock") + "\n");
            }

            csvWriter.flush();
            csvWriter.close();

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ReportGenerator reportGenerator = new ReportGenerator();
                reportGenerator.setVisible(true);
            }
        });
    }
}
