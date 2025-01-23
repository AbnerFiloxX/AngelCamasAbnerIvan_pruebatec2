/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaboss.logica;

import com.hackaboss.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;




/**
 * Clase ControladoraLogica: Maneja la lógica del negocio para Turnos, Trámites, Ciudadanos y Usuarios.
 */



public class ControladoraLogica {

   
    private ControladoraPersistencia controlPersis;
    
    // Métodos para Turno
    public void crearTurno(String fecha, String estado, Tramite tramite, Ciudadano ciudadano) {
        Turno nuevoTurno = new Turno(fecha, estado, tramite, ciudadano);
        controlPersis.crearTurno(nuevoTurno);
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public List<Turno> obtenerTurnos() {
        return controlPersis.traerTurnos();
    }

    public void eliminarTurno(Long id) {
        controlPersis.eliminarTurno(id);
    }

    // Métodos para Ciudadano
    public void crearCiudadano(String nombre, String apellido, String dni) {
        Ciudadano nuevoCiudadano = new Ciudadano(nombre, apellido, dni);
        controlPersis.crearCiudadano(nuevoCiudadano);
    }

    public List<Ciudadano> obtenerCiudadanos(String filtroDni) {
        List<Ciudadano> ciudadanosCoincidentes = new ArrayList<>();
        List<Ciudadano> listaCiudadanos = controlPersis.traerCiudadanos();

        for (Ciudadano ciudadano : listaCiudadanos) {
            if (ciudadano.getDni().contains(filtroDni)) {
                ciudadanosCoincidentes.add(ciudadano);
            }
        }
        return ciudadanosCoincidentes;
    }

    public List<Ciudadano> traerCiudadanos() {
        return controlPersis.traerCiudadanos();
    }

    public void eliminarCiudadano(Long id) {
        controlPersis.eliminarCiudadano(id);
    }

    // Métodos para Tramite
    public void crearTramite(String nombre, String descripcion) {
        Tramite nuevoTramite = new Tramite(nombre, descripcion);
        controlPersis.crearTramite(nuevoTramite);
    }

    public List<Tramite> traerTramites() {
        return controlPersis.traerTramites();
    }

    public void eliminarTramite(Long id) {
        controlPersis.eliminarTramite(id);
    }

    // Métodos para Usuario
    public void crearUsuario(String username, String password) {
        Usuario nuevoUsuario = new Usuario(username, password);
        controlPersis.crearUsuario(nuevoUsuario);
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public void eliminarUsuario(Long id) {
        controlPersis.eliminarUsuario(id);
    }

    public Tramite buscarTramitePorId(Long tramiteId) {
        return controlPersis.traerTramitePorId(tramiteId);
    }

    public Ciudadano buscarCiudadanoPorId(Long ciudadanoId) {
        return controlPersis.traerCiudadanoPorId(ciudadanoId);
    }

    public Usuario loginUsuario(String username, String password) {
        Usuario usuario = controlPersis.traerUsuarioPorUsername(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario; // Si las credenciales son correctas, devuelve el usuario
        }
        return null; // Si las credenciales son incorrectas, devuelve null
    }

    public Usuario traerUsuarioPorUsername(String username) {
        return controlPersis.traerUsuarioPorUsername(username);
    }
}
