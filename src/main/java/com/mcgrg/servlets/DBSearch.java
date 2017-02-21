package com.mcgrg.servlets;

import com.mcgrg.driver.sqlquerymysql;
import com.mcgrg.entity.ConstructionSite;
import com.mcgrg.entity.Materials;
import com.mcgrg.entity.Usergroups;
import com.mcgrg.entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by MSI GT70 on 15.02.2017.
 */
public class DBSearch {
    private Connection con = null;

    public DBSearch() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        con = sqlquerymysql.sqlDrive();
    }

    public List<ConstructionSite> getSites(String stringSQL) throws SQLException{
        List<ConstructionSite> list = null;
        list = new LinkedList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        while (rs.next()) {
            ConstructionSite site = new ConstructionSite();
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

    public List<Usergroups> getUsergroups() throws SQLException{
        List<Usergroups> list =null;
        list = new LinkedList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM diploma.usergroups;");
        while (rs.next()){
            Usergroups usergroups=new Usergroups();
            usergroups.setUsergroupId(rs.getInt("usergroups_id"));
            usergroups.setUsergroupName(rs.getString("usergroup_name"));
            list.add(usergroups);
        }
        rs.close();
        stmt.close();
        return list;
    }


    public List<Materials> getMaterials(String stringSQL) throws SQLException{
        List<Materials> list =null;
        list = new LinkedList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        while (rs.next()){
            Materials materials =new Materials();
            materials.setMaterialsId(rs.getInt("Materials_ID"));
            materials.setMaterialsName(rs.getString("materials_name"));
            list.add(materials);
        }
        rs.close();
        stmt.close();
        return list;
    }

    public List<Users> getUsers (String stringSQL) throws SQLException{
        List<Users> list =null;
        list = new LinkedList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(stringSQL);
        while (rs.next()){
            Users users =new Users();
            users.setUserID(rs.getInt("users_id"));
            users.setUserName(rs.getString("users_name"));
            users.setUserSurname(rs.getString("users_surname"));
            users.setUserThirdname(rs.getString("users_thirdname"));
            users.setPosition(rs.getString("users_position"));
            list.add(users);
        }
        rs.close();
        stmt.close();
        return list;
    }


    public void close()throws SQLException{
        con.close();
    }
}
