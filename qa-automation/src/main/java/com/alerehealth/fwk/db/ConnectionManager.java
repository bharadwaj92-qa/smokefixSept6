package com.alerehealth.fwk.db;

import com.alerehealth.fwk.common.Configuration;

import java.sql.Connection;
import java.util.HashMap;

public class ConnectionManager {

    private static HashMap<DatabaseType,Connection> dbConnections = new HashMap<DatabaseType,Connection>();


    /**
     * Helper method to get Connection to CDR DB;
     * @return
     * @throws Exception
     */
    public static Connection getCDRConnection() throws Exception {

        Connection conn= dbConnections.get(DatabaseType.CDR);

        if(conn == null){

            Configuration configuration = Configuration.getConfiguration();

            String dbHost = configuration.getCdr_db_host();
            String db = configuration.getCdr_db();
            String userName = configuration.getCdr_db_username();
            String password = configuration.getCdr_db_password();

            conn = JDBCConnector.getConnection(dbHost,db,userName,password);

            dbConnections.put(DatabaseType.CDR, conn);

        }

        return conn;


    }

    /**
     * Helper method to get connection to PRPC DB
     * @return
     * @throws Exception
     */
    public static Connection getPRPCDBConnection() throws Exception{

        Connection conn= dbConnections.get(DatabaseType.PRPC);

        if(conn == null){


            Configuration configuration = Configuration.getConfiguration();

            String dbHost = configuration.getPrpc_db_host();
            String db = configuration.getPrpc_db();
            String userName = configuration.getPrpc_db_username();
            String password = configuration.getPrpc_db_password();

            conn = JDBCConnector.getConnection(dbHost,db,userName,password);

            dbConnections.put(DatabaseType.PRPC, conn);

        }

        return conn;

    }
}
