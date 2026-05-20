package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import LogicLayer.ComentarioAnonimo;

public class ControllerComentario {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	public LinkedList<ComentarioAnonimo> verComentarios(){
		 LinkedList<ComentarioAnonimo> comentarios = new LinkedList<>();
		 
		 try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM mensaje_anonimo");
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("id_mensaje");
	                String contenido = rs.getString("contenido");
	                LocalDate fecha = rs.getDate("fecha").toLocalDate();
	                String sentimiento = rs.getString("sentimiento");
	                int id_reporte = rs.getInt("id_reporte");
	                
	             comentarios.add(new ComentarioAnonimo(id,contenido,fecha,sentimiento,id_reporte));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		 return comentarios;
	}
	
	public void agregarComentarios(ComentarioAnonimo comentario){ 
		 try {
	            PreparedStatement stmt = con.prepareStatement
	            		("INSERT INTO `mensaje_anonimo`(`contenido`, `fecha`,`sentimiento`,`id_reporte`) "
	            				+ "VALUES (?,?,?,?)");
	          
	            stmt.setString(1, comentario.getContenido());
	            //El dato es de tipo LocalDate, pero en la BD es de tipo Date por eso hay que pasarlo
	            stmt.setDate(2, java.sql.Date.valueOf(comentario.getFecha()));
	            stmt.setString(3, comentario.getSentimiento());
	            stmt.setInt(4, 1);
	           
	            int filas = stmt.executeUpdate();
	            if (filas > 0) {
	               JOptionPane.showMessageDialog(null, "Comentario anónimo enviado correctamente😁");
	            }
	            
	            
	            

	     
	        } catch (Exception e) {
	        }	 
	}
	 
	public String generarReporteClima() {

	    LinkedList<ComentarioAnonimo> comentarios = verComentarios();

	    int positivos = 0;
	    int neutros = 0;
	    int negativos = 0;

	    for(ComentarioAnonimo c : comentarios) {

	        if(c.getSentimiento().equalsIgnoreCase("Positivo")) {

	            positivos++;

	        } else if(c.getSentimiento().equalsIgnoreCase("Neutro")) {

	            neutros++;

	        } else if(c.getSentimiento().equalsIgnoreCase("Negativo")) {

	            negativos++;
	        }
	    }

	    return "REPORTE DEL CLIMA LABORAL\n"
	            + "Comentarios positivos: " + positivos
	            + "\nComentarios neutros: " + neutros
	            + "\nComentarios negativos: " + negativos
	            + "\n\nTotal comentarios: " + comentarios.size();
	}
}
