package com.shoptao.utilities;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author nguyen293
 */
public class JasperReports {

    public static void exportToPdf(String maHoaDon) {
        Connection con = null;
        try {
            String source = "src\\main\\java\\com\\shoptao\\view\\HoaDonReport.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(source);
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("mahoadon", maHoaDon);

            con = getConnection();
            JasperPrint jp = JasperFillManager.fillReport(jr, params, con);
            OutputStream os = new FileOutputStream("E:/HoaDon_" + maHoaDon + ".pdf");
            JasperExportManager.exportReportToPdfStream(jp, os);

            JasperViewer.viewReport(jp, false);
            
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=DATABASE_NHOM6_SHOPTAO",
                    "sa", "123");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
