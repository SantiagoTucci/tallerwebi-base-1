package com.tallerwebi.dominio;

import com.tallerwebi.dominio.calendario.ItemRendimiento;
import com.tallerwebi.dominio.objetivo.Objetivo;
import com.tallerwebi.dominio.rutina.Rutina;
import com.tallerwebi.dominio.reto.Reto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nombre;
    private String apellido;
    private String password;
    private String rol;
    private Boolean activo = false;
    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    private Boolean isInstructor = false;
    @Column(name = "racha_de_retos", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer rachaDeRetos;

    //relacion de usuario con itemRendimiento 1 - n --> bd
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rutina> rutinas;

    //relacion de usuario con itemRendimiento 1 - n --> bd
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemRendimiento> itemsRendimiento;

    public List<ItemRendimiento> getItemsRendimiento() {
        return itemsRendimiento;
    }

    public void setItemsRendimiento(List<ItemRendimiento> itemsRendimiento) {
        this.itemsRendimiento = itemsRendimiento;
    }

    //relacion de usuario con reto 1 - n --> bd
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reto> retos;

    public List<Reto> getRetos() {
        return retos;
    }

    public void setRetos(List<Reto> retos) {
        this.retos = retos;
    }

    public Usuario() {
        this.rutinas = new ArrayList<>();
    }
    public Usuario(String nombre, Objetivo objetivo) {
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.rutinas = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido =  apellido;
        this.email = email;
        this.password = password;
        this.rutinas = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String email, String password, Boolean isInstructor) {
        this.nombre = nombre;
        this.apellido =  apellido;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
        this.rutinas = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, String email, String password, Objetivo objetivo) {
        this.nombre = nombre;
        this.apellido =  apellido;
        this.email = email;
        this.password = password;
        this.objetivo = objetivo;
        this.rutinas = new ArrayList<>();
    }

    public Usuario(String email, String nombre, String apellido, String password, List<Reto> retos, Integer rachaDeRetos) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.retos = retos;
        this.rachaDeRetos = rachaDeRetos;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public boolean activo() {
        return activo;
    }

    public void activar() {
        activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public Boolean getInstructor() {
        return isInstructor;
    }

    public void setInstructor(Boolean instructor) {
        isInstructor = instructor;
    }

    public List<Rutina> getRutinas() {
        return this.rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Boolean isInstructor() {
        return isInstructor;
    }

    public Integer getRachaDeRetos() {
        return rachaDeRetos;
    }

    public void setRachaDeRetos(Integer rachaDeRetos) {
        this.rachaDeRetos = rachaDeRetos;
    }

    public Integer sumarRacha() {
        return this.rachaDeRetos += 1;
    }


}