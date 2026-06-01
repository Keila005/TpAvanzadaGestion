package LogicLayer;

import java.time.LocalDate;

public class Reunion {

    private int idReunion;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private int idProyecto;

    public Reunion() {
    }

    public Reunion(
            String titulo,
            String descripcion,
            LocalDate fecha,
            int idProyecto) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idProyecto = idProyecto;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
}