package com.mcgrg.DataBaseDrivers;

import com.mcgrg.Entity.ConstructionSite;
import com.mcgrg.Entity.Materials;
import com.mcgrg.Entity.Usergroups;
import com.mcgrg.Entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MSI GT70 on 22.02.2017.
 */
public class DBOneItemSearch {
    private Connection con = null;

    public DBOneItemSearch() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        con = sqlquerymysql.sqlDrive();
    }

    public ConstructionSite getSites(String stringSQL) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        ConstructionSite site = new ConstructionSite();
        site.setConssiteId(rs.getInt("cons_site_id"));
        site.setConssiteCity(rs.getString("cons_site_city"));
        site.setConssiteStreet(rs.getString("cons_site_street"));
        site.setConssiteBilding(rs.getString("cons_site_bilding"));
        site.setStartDate(rs.getString("start_date"));
        site.setFinishDate(rs.getString("finish_date"));
        site.setManager(rs.getString("manager"));
        rs.close();
        stmt.close();
        return site;
    }

    public Usergroups getUsergroups(String stringSQL) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        Usergroups usergroups = new Usergroups();
        usergroups.setUsergroupId(rs.getInt("usergroups_id"));
        rs.close();
        stmt.close();
        return usergroups;
    }


    public Materials getMaterials(String stringSQL) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        Materials materials = new Materials();
        materials.setMaterialsId(rs.getInt("Materials_ID"));
        materials.setMaterialsName(rs.getString("materials_name"));
        rs.close();
        stmt.close();
        return materials;
    }

    public Users getUsers(String stringSQL) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        Users users = new Users();
        users.setUserID(rs.getInt("users_id"));
        users.setUserName(rs.getString("users_name"));
        users.setUserSurname(rs.getString("users_surname"));
        users.setUserThirdname(rs.getString("users_thirdname"));
        users.setPosition(rs.getString("users_position"));
        rs.close();
        stmt.close();
        return users;
    }


    public void close() throws SQLException {
        con.close();
    }
}
