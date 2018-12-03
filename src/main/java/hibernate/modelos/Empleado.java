package hibernate.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {
    public static final long serialVersionUID= 1L;
    @Id
    @Column(name = "COD_EMPLEADO")
    private Long codigo;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHANAC")
    private Date fechanacimiento;

    public Empleado(){

    }

    public Empleado(Long codigo, String apellido, String nombre, Date fechanacimiento) {
        this.codigo = codigo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                '}';
    }
}
