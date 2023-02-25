package Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 150)
    private String provincia;
    @Column(nullable = false, unique = true, length = 150)
    private String ciudad;
    @Column(nullable = false, unique = true, length = 150)
    private Double direccion;

    public Direccion(Long id, String provincia, String ciudad, Double direccion) {
        this.id = id;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getDireccion() {
        return direccion;
    }

    public void setDireccion(Double direccion) {
        this.direccion = direccion;
    }
}
