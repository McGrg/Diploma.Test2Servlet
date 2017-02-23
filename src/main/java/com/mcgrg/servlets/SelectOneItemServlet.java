package com.mcgrg.servlets;

import com.google.gson.Gson;
import com.mcgrg.DataBaseDrivers.DBOneItemSearch;
import com.mcgrg.Entity.ConstructionSite;
import com.mcgrg.Entity.Materials;
import com.mcgrg.Entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by MSI GT70 on 22.02.2017.
 */
@WebServlet("/SelectOneItemServlet")
public class SelectOneItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String[] stringSQL = null;
        String[] tableName = null;
        String report = null;
        Map<String, String[]> map = request.getParameterMap();
        //Reading the Map
        //Works for GET && POST Method
        stringSQL = map.get("sql");
        tableName = map.get("table");

        //--------------------------------------------------------------

        try {
            DBOneItemSearch db = new DBOneItemSearch();
            switch (tableName[0]) {
                case "authentifikation": {
                    report = " authentifikation table!";
                }
                break;
                case "constructionsite": {
                    ConstructionSite sites = db.getSites(stringSQL[0]);
                    report = new Gson().toJson(sites);
                    db.close();
                }
                break;
                case "debitstandart": {
                    report = " debitstandart table!";
                }
                break;
                case "materials": {
                    Materials sites = db.getMaterials(stringSQL[0]);
                    report = new Gson().toJson(sites);
                    db.close();
                }
                break;
                case "operations": {
                    report = " operations table!";
                }
                break;
                case "opertype": {
                    report = " debitstandart table!";
                }
                break;
                case "stock": {
                    report = " stock table!";
                }
                break;
                case "usergroups": {
                    report = " usergroups table!";
                }
                break;
                case "users": {
                    Users users = db.getUsers(stringSQL[0]);
                    report = new Gson().toJson(users);
                    db.close();
                }
                break;
                default: {
                    report = " There isn't such a table!";
                }
            }
            db.close();
        } catch (Exception e) {
            report = e.toString();
        } finally {
//            report = report + "tableName: " + tableName + "stringSQL: " + stringSQL;
            PrintWriter outsites = response.getWriter();
            outsites.println( report);
            outsites.close();
        }

        //--------------------------------------------------------------

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}