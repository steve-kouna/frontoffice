/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Steve KOUNA
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        for (int i = 1; i <= 3; i++) {
            Artist mainArtist = new Artist();
            mainArtist.setName("mainArtist" + i);

            Work work = new Work();
            work.setId(((long)i));
            work.setTitle("work" + i);
            work.setGenre("rap" + i);
            work.setRelease((1234 * i));
            work.setSummary("test " + i);
            work.setMainArtist(mainArtist);

            Catalogue.listOfWorks(work);
            out.print("<h1><a href='work-details?id='" + work.getId() + "'>" + work.getTitle() + " (" + work.getRelease() + ")</a></h1>");
        }
    }

}
