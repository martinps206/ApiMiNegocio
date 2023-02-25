package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    private String tipoDeIdentificacion;
    @Column(nullable = false, unique = true, length = 15)
    private String dni;
    @Column(nullable = false, unique = true, length = 150)
    private String apeNom;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, unique = true, length = 15)
    private String numeroCelular;

    private Direccion []direccion = new Direccion[3];

    public Cliente(Long id, String tipoDeIdentificacion, String dni, String apeNom, String email, String numeroCelular) {
        this.id = id;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.dni = dni;
        this.apeNom = apeNom;
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApeNom() {
        return apeNom;
    }

    public void setApeNom(String apeNom) {
        this.apeNom = apeNom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void agregarDireccion(Direccion d){
        if (this.id < 3) {
            int num = this.id.intValue();
            direccion[num] = d;
            this.id++;
        }
    }
}
