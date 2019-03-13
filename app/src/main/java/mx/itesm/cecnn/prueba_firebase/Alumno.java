package mx.itesm.cecnn.prueba_firebase;

public class Alumno {
    private String matricula, nombre;
    private int semestre;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Alumno(String matricula, String nombre, int semestre) {

        this.matricula = matricula;
        this.nombre = nombre;
        this.semestre = semestre;
    }
}
