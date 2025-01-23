/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hackaboss.servlets;

import com.hackaboss.logica.Ciudadano;
import com.hackaboss.logica.ControladoraLogica;
import com.hackaboss.logica.Tramite;
import com.hackaboss.logica.Turno;
import com.hackaboss.persistencia.CiudadanoJpaController;
import com.hackaboss.persistencia.TramiteJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author satel
 */
@WebServlet(name = "TurnosSv", urlPatterns = {"/TurnosSv"})
public class TurnosSv extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TurnosSv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurnosSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtén los trámites desde la base de datos
        TramiteJpaController tramiteController = new TramiteJpaController();
        List<Tramite> listaTramites = tramiteController.findTramiteEntities();

        // Pasa la lista a la JSP
        request.setAttribute("listaTramites", listaTramites);
        request.getRequestDispatcher("/turnos.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String idCiudadano = request.getParameter("idCiudadano");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");

        // Crear una nueva instancia de Ciudadano
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setId(Long.parseLong(idCiudadano));  // Asegúrate de que el ID sea de tipo Long
        ciudadano.setApellido(apellido);
        ciudadano.setDni(dni);
        ciudadano.setNombre(nombre);

       
        
        // Guardar el ciudadano en la base de datos usando tu método de persistencia (por ejemplo, un DAO)
        CiudadanoJpaController ciudadanoController = new CiudadanoJpaController();
        try {
            ciudadanoController.create(ciudadano);  // Suponiendo que tienes un método create en tu CiudadanoJpaController
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirigir a otra página o mostrar un mensaje
        response.sendRedirect("turnos.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}