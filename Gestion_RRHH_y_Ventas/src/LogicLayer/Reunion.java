package LogicLayer;

import java.time.LocalDate;

public class Reunion {

    private int idReunion;
    private String titulo;
    private LocalDate fecha;
    private String descripcion;
    private int idProyecto;

    public Reunion() {
    }

    public Reunion(String titulo, LocalDate fecha, String descripcion, int idProyecto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idProyecto = idProyecto;
    }

    public Reunion(int idReunion, String titulo, LocalDate fecha,
                   String descripcion, int idProyecto) {

        this.idReunion = idReunion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "Reunion [idReunion=" + idReunion
                + ", titulo=" + titulo
                + ", fecha=" + fecha
                + ", descripcion=" + descripcion
                + ", idProyecto=" + idProyecto + "]";
    }
}