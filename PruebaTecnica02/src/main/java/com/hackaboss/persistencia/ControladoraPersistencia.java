/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaboss.persistencia;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.Tramite;
import com.hackaboss.logica.Turno;
import com.hackaboss.logica.Usuario;
import com.hackaboss.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;





/**
 *
 * @author satel
 */
@Stateless
public class ControladoraPersistencia {

   CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    TramiteJpaController tramiteJpa = new TramiteJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    @PersistenceContext(unitName = "PruebaTecnica02")
    private EntityManager em;
    
    public List<Tramite> obtenerTodosLosTramites() {
        return em.createQuery("SELECT t FROM Tramite t", Tramite.class).getResultList();
    }
    
    // Métodos para Turno
    public void crearTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public List<Turno> traerTurnos() {
        return turnoJpa.findTurnoEntities();
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Ciudadano
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }

    public List<Ciudadano> traerCiudadanos() {
        return ciudadanoJpa.findCiudadanoEntities();
    }
    
    

    public void eliminarCiudadano(Long id) {
        try {
            ciudadanoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Tramite
    public void crearTramite(Tramite tramite) {
        tramiteJpa.create(tramite);
    }

    public List<Tramite> traerTramites() {
        return tramiteJpa.findTramiteEntities();
    }
    
    

    public void eliminarTramite(Long id) {
        try {
            tramiteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Usuario
    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void eliminarUsuario(Long id) {
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Tramite traerTramitePorId(Long tramiteId) {
    return tramiteJpa.findTramite(tramiteId);  // Método generado por JPA
    }
    
    public Ciudadano traerCiudadanoPorId(Long ciudadanoId) {
    return ciudadanoJpa.findCiudadano(ciudadanoId);  // Método generado por JPA
    }
    
    
    // Método que trae el Usuario por su username
    public Usuario traerUsuarioPorUsername(String username) {
        EntityManager em = getEntityManager(); // Obtener el EntityManager
        try {
            // Realizar la consulta para traer al usuario que coincide con el username
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class);
            query.setParameter("username", username); // Pasamos el username como parámetro

            List<Usuario> usuarios = query.getResultList(); // Ejecutar la consulta
            if (!usuarios.isEmpty()) {
                return usuarios.get(0); // Si encontramos al menos un usuario, lo devolvemos
            }
            return null; // Si no se encontró ningún usuario, devolvemos null
        } catch (Exception e) {
            e.printStackTrace();
            return null; // En caso de error, devolvemos null
        }
    }
   
    protected EntityManager getEntityManager() {
    return Persistence.createEntityManagerFactory("PruebaTecnica02").createEntityManager();
}

   
}
