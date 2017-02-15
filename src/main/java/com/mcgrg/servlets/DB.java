package com.mcgrg.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MSI GT70 on 15.02.2017.
 */
public class DB {
    private Connection con = null;

    public DB() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        con = sqlquerymysql.sqlDrive();
    }

    public List<ConstructionSites> getSites() throws SQLException{
        List<ConstructionSites> list = null;
        list = new LinkedList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM diploma.constructionsite;");
        while (rs.next()) {
            ConstructionSites site = new ConstructionSites();
            site.setConssiteId(rs.getInt("cons_site_id"));
            site.setConssiteCity(rs.getString("cons_site_city"));
            site.setConssiteStreet(rs.getString("cons_site_street"));
            site.setConssiteBilding(rs.getString("cons_site_bilding"));
            site.setStartDate(rs.getString("start_date"));
            site.setFinishDate(rs.getString("finish_date"));
            site.setManager(rs.getString("manager"));
            list.add(site);
        }
        rs.close();
        stmt.close();
        return list;
    }

    public void close()throws SQLException{
        con.close();
    }
}
