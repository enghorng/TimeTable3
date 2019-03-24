/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class clsCon {

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    /**
     * @return the stmt
     */
    public static Statement getStmt() {
        return stmt;
    }

    /**
     * @param aStmt the stmt to set
     */
    public static void setStmt(Statement aStmt) {
        stmt = aStmt;
    }

    /**
     * @return the rs
     */
    public static ResultSet getRs() {
        return rs;
    }

    /**
     * @param aRs the rs to set
     */
    public static void setRs(ResultSet aRs) {
        rs = aRs;
    }

    /**
     * @return the fileName
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     * @param aFileName the fileName to set
     */
    public static void setFileName(String aFileName) {
        fileName = aFileName;
    }
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static String fileName;
    public static void inti(){
        try {
           // setFileName("D:\\Study\\IT\\Y3\\Java\\Timetable\\Time_Table\\Course_Timetable");
           setFileName("C:\\Users\\DELL\\Desktop\\TimeTable\\Timetable2");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            setCon(DriverManager.getConnection("jdbc:ucanaccess://" + getFileName() + "/Course_Timetable.accdb"));  
            setStmt(getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
            
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void GetData(JTextField txt,String st){
        try {
            txt.setText(clsCon.getRs().getString(st));
        } catch (SQLException ex) {            
        }
    }
    public static void clear(JTextField txt){
        txt.setText("");
    }

    static Object setRs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
