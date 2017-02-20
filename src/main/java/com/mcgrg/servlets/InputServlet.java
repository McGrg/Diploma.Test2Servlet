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
        response.setCharacterEncoding("UTF-8");
        String[] stringSQL = null;
        String[] tableName = null;
        String report = null;
        Map<String, String[]> map = request.getParameterMap();
        //Reading the Map
        //Works for GET && POST Method
        stringSQL = map.get("sql");
        tableName = map.get("table");
        report = "SQL: " + stringSQL[0] + " " + "tableName: " + tableName[0];

        try {
            DBInsert db = new DBInsert();
            switch (tableName[0]) {
                case "authentifikation": {
                    report = report + " authentifikation table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "constructionsite": {
                    report = report + " constructionsite table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "debitstandart": {
                    report = report + " debitstandart table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "materials": {
                    report = report + " materials table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "operations": {
                    report = report + " operations table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "opertype": {
                    report = report + " opertype table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                break;
                case "stock": {
                    report = report + " stock table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                case "usergroups": {
                    report = db.setUsergroups(stringSQL[0]);
                }
                break;
                case "users": {
                    report = report + " users table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
                default: {
                    report = report + " There isn't such a table!";
                    PrintWriter outsites = response.getWriter();
                    outsites.println(report);
                    outsites.close();
                }
            }
            if (db != null) {
                db.close();
            }
        } catch (Exception e) {
            report = e.toString();
        } finally {
            PrintWriter outsites = response.getWriter();
            outsites.println(report);
            outsites.close();
        }
//        PrintWriter outsites = response.getWriter();
//        outsites.println(report);
//        outsites.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
