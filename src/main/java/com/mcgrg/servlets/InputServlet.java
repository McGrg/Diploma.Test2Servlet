package com.mcgrg.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by MSI GT70 on 19.02.2017.
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        String[] stringSQL=null;
//        String[] tableName = null;
//        String report = null;
//        Map<String, String[]> map = request.getParameterMap();
//        //Reading the Map
//        //Works for GET && POST Method
//        stringSQL = map.get("sql");
//        tableName = map.get("table");
//        try {
//            DB db = new DB();
//            report = db.setUsergroups(stringSQL[0]);
//            db.close();
//            PrintWriter outsites = response.getWriter();
//            outsites.println(report);
//            outsites.close();
//        } catch (Exception e) {
//            String except = e.toString();
//            response.getWriter().write(except);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String[] stringSQL=null;
        String[] tableName = null;
        String report = null;
        Map<String, String[]> map = request.getParameterMap();
        //Reading the Map
        //Works for GET && POST Method
        stringSQL = map.get("sql");
        tableName = map.get("table");
//        response.getWriter().write(stringSQL[0] + " " + tableName[0]);
        try {
            DB db = new DB();
            report = db.setUsergroups(stringSQL[0]);
            db.close();
        } catch (Exception e) {
            report = e.toString();
            response.getWriter().write(report);
        } finally {
            PrintWriter outsites = response.getWriter();
            outsites.println(report);
            outsites.close();
        }
    }
}
