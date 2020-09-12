package cl.awakelab.ensayo3.model;

public class Curso {

    private int idcurso;
    private String nombre;
    private int n_alumnos;

    public Curso() {
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN_alumnos() {
        return n_alumnos;
    }

    public void setN_alumnos(int n_alumnos) {
        this.n_alumnos = n_alumnos;
    }

}
