package com.mcgrg.servlets;

import com.google.gson.Gson;
import com.mcgrg.entity.ConstructionSites;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by MSI GT70 on 14.02.2017.
 */
@WebServlet("/ServletDBMySql")
public class ServletDBMySql extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            DB db = new DB();
                List<ConstructionSites> sites = db.getSites();
                String gsonsites= new Gson().toJson(sites);
                db.close();
                PrintWriter outsites = response.getWriter();
                outsites.println(gsonsites);
                outsites.close();
//            List<Usergroups> usergroups = db.getUsergroups();
//            String gsonusergroups = new Gson().toJson(usergroups);
//            db.close();
//            PrintWriter outusergroups = response.getWriter();
//            outusergroups.println(gsonusergroups);
//            outusergroups.close();
        } catch (Exception e) {
            String except = e.toString();
            response.getWriter().write(except);
        }
    }
}
