package br.com.jhony.db;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionFactory { 

    public Connection getConnection() { 
    	    	    	
        Connection c = null;           

	    try {
	        Class.forName("org.sqlite.JDBC"); 
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    
		    return c;
        } catch ( Exception e ) { 
            e.printStackTrace();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }
}
