package DLL;

import java.sql.PreparedStatement;
import com.mysql.jdbc.Connection;

public class ControllerReunion {

    private static Connection con =
            Conexion.getInstance().getConnection();

    public void crearReunion(
            String titulo,
            String fecha,
            int idProyecto) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO reunion "
                    + "(titulo,fecha,id_proyecto) "
                    + "VALUES (?,?,?,?)"
            );

            stmt.setString(1, titulo);
            stmt.setString(2, fecha);
            stmt.setInt(3, idProyecto);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

}