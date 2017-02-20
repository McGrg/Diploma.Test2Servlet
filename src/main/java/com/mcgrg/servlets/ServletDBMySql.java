package com.mcgrg.servlets;

import com.google.gson.Gson;
import com.mcgrg.entity.ConstructionSite;
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
//        response.setCharacterEncoding("UTF-8");
//        String[] stringSQL=null;
//        String[] tableName = null;
//        String report = null;
//        Map<String, String[]> map = request.getParameterMap();
//        //Reading the Map
//        //Works for GET && POST Method
//        stringSQL = map.get("sql");
//        tableName = map.get("table");
//
//        //--------------------------------------------------------------
//
//        try {
//            DBSearch db = new DBSearch();
//            switch (tableName[0]) {
//                case "authentifikation": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" authentifikation table!");
//                    outsites.close();
//                }
//                break;
//                case "constructionsite": {
//                    List<ConstructionSites> sites = db.getSites(stringSQL[0]);
//                    String gsonsites= new Gson().toJson(sites);
//                    db.close();
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(gsonsites);
//                    outsites.close();
//                }
//                break;
//                case "debitstandart": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" debitstandart table!");
//                    outsites.close();
//                }
//                break;
//                case "materials": {
//                    List<Materials> sites = db.getMaterials(stringSQL[0]);
//                    String gsonsites= new Gson().toJson(sites);
//                    db.close();
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(gsonsites);
//                    outsites.close();
//                }
//                break;
//                case "operations": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" operations table!");
//                    outsites.close();
//                }
//                break;
//                case "opertype": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" opertype table!");
//                    outsites.close();
//                }
//                break;
//                case "stock": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" stock table!");
//                    outsites.close();
//                }
//                break;
//                case "usergroups": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" usergroups table!");
//                    outsites.close();
//                }
//                break;
//                case "users": {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" users table!");
//                    outsites.close();
//                }
//                default: {
//                    PrintWriter outsites = response.getWriter();
//                    outsites.println(" users table!");
//                    outsites.close();
//                }
//            }
//            db.close();
//        } catch (Exception e) {
//            report = e.toString();
//        } finally {
//            PrintWriter outsites = response.getWriter();
//            outsites.println(report);
//            outsites.close();
        }

        //--------------------------------------------------------------


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

        //--------------------------------------------------------------

        try {
            DBSearch db = new DBSearch();
            switch (tableName[0]) {
                case "authentifikation": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" authentifikation table!");
                    outsites.close();
                }
                break;
                case "constructionsite": {
                    List<ConstructionSite> sites = db.getSites(stringSQL[0]);
                    String gsonsites= new Gson().toJson(sites);
                    db.close();
                    PrintWriter outsites = response.getWriter();
                    outsites.println(gsonsites);
                    outsites.close();
                }
                break;
                case "debitstandart": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" debitstandart table!");
                    outsites.close();
                }
                break;
                case "materials": {
                    List<Materials> sites = db.getMaterials(stringSQL[0]);
                    String gsonsites= new Gson().toJson(sites);
                    db.close();
                    PrintWriter outsites = response.getWriter();
                    outsites.println(gsonsites);
                    outsites.close();
                }
                break;
                case "operations": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" operations table!");
                    outsites.close();
                }
                break;
                case "opertype": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" opertype table!");
                    outsites.close();
                }
                break;
                case "stock": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" stock table!");
                    outsites.close();
                }
                break;
                case "usergroups": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" usergroups table!");
                    outsites.close();
                }
                break;
                case "users": {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" users table!");
                    outsites.close();
                }
                default: {
                    PrintWriter outsites = response.getWriter();
                    outsites.println(" users table!");
                    outsites.println(stringSQL[0] + " "+ tableName[0]);
                    outsites.close();
                }
            }
            db.close();
        } catch (Exception e) {
            report = e.toString();
        } finally {
//            PrintWriter outsites = response.getWriter();
//            outsites.println(report);
//            outsites.close();
        }

        //--------------------------------------------------------------

    }
}
