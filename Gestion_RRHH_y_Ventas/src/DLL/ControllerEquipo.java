package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;

import LogicLayer.Equipo;

public class ControllerEquipo {

    private static Connection con =
            Conexion.getInstance().getConnection();

    // MOSTRAR TODOS LOS EQUIPOS
    public LinkedList<Equipo> mostrarEquipo() {

        LinkedList<Equipo> equipo = new LinkedList<>();

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "SELECT id_equipo,nombre "
                    + "FROM equipo"
            );

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                int id = rs.getInt("id_equipo");
                String nombre = rs.getString("nombre");

                equipo.add(
                        new Equipo(id,nombre)
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return equipo;
    }

    // CREAR EQUIPO NUEVO
    public void crearEquipo(
            String nombre,
            int idLider) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO equipo "
                    + "(nombre,id_lider) "
                    + "VALUES (?,?)"
            );

            stmt.setString(1, nombre);
            stmt.setInt(2, idLider);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // OBTENER ID DEL ULTIMO EQUIPO CREADO
    public int obtenerUltimoEquipo() {

        int id = 0;

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "SELECT MAX(id_equipo) AS id "
                    + "FROM equipo"
            );

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                id = rs.getInt("id");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return id;
    }

    // AGREGAR MIEMBRO A UN EQUIPO
    public void agregarMiembro(
            int idOperativo,
            int idEquipo) {

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "INSERT INTO equipo_miembro "
                    + "(id_operativo,id_equipo) "
                    + "VALUES (?,?)"
            );

            stmt.setInt(1, idOperativo);
            stmt.setInt(2, idEquipo);

            stmt.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // OBTENER MIEMBROS DE UN EQUIPO
    public LinkedList<Integer> obtenerMiembros(
            int idEquipo) {

        LinkedList<Integer> miembros =
                new LinkedList<>();

        try {

            PreparedStatement stmt =
                    con.prepareStatement(

                    "SELECT id_operativo "
                    + "FROM equipo_miembro "
                    + "WHERE id_equipo = ?"
            );

            stmt.setInt(1, idEquipo);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                miembros.add(
                        rs.getInt("id_operativo")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return miembros;
    }

}