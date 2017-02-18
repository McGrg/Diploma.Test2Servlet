package com.mcgrg.servlets;

import com.google.gson.Gson;
import com.mcgrg.entity.Materials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by MSI GT70 on 14.02.2017.
 */
@WebServlet("/ServletDBMySql")
public class ServletDBMySql extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String[] stringSQL=null;
        Map<String, String[]> map = request.getParameterMap();
        //Reading the Map
        //Works for GET && POST Method
        for(String paramName:map.keySet()) {
            stringSQL = map.get(paramName);
        }
        try {
            DB db = new DB();
            List<Materials> sites = db.getMaterials(stringSQL[0]);
            String gsonsites= new Gson().toJson(sites);
            db.close();
            PrintWriter outsites = response.getWriter();
            outsites.println(gsonsites);
            outsites.close();
        } catch (Exception e) {
            String except = e.toString();
            response.getWriter().write(except);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
