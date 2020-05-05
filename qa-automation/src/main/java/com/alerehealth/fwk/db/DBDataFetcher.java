/**
 * @author : venkata.chunduri
 *
 */

package com.alerehealth.fwk.db;

import com.alerehealth.fwk.common.LoggerUtils;

import java.sql.*;

public class DBDataFetcher {


    /**
     * Helper method to execute Query
     * @param query to execute
     * @return Resultset for query
     * @throws SQLException
     */
    private static ResultSet executeQueryOnCDRDB(String query) throws Exception{

        Connection conn = ConnectionManager.getCDRConnection();

        Statement stmt = null ;

        ResultSet rs = null;

        try{

            stmt =  conn.createStatement();

            rs = stmt.executeQuery(query);

        }catch (SQLException sqlException){

            LoggerUtils.error("Error while executing query" + sqlException.getMessage());
        }

        return rs;

    }


    /**
     * Helper method to execute a query
     * @param query to execute
     * @return String [] of row data
     * @throws SQLException
     */
    public static String[] getRowDataForQueryFromCDRDB(String query) throws Exception{

        ResultSet rs = executeQueryOnCDRDB( query);

        ResultSetMetaData metadata = rs.getMetaData();

        int colCount = metadata.getColumnCount();


        String []rowData = new String [colCount];

        if(rs.next()){

            for(int i = 0; i< colCount ; i++){
                rowData[i] = rs.getString(i+1);
            }

        }

        rs.close();

        return rowData;

    }


    /**
     * Helper method to get multiple rows data from DB
     * @param query to be executed
     * @return multiple rows data
     * @throws SQLException
     */
    public static String [][] getMultiRowDataOnCDRDB(String query) throws Exception{

        ResultSet rs = executeQueryOnCDRDB( query);

        ResultSetMetaData metadata = rs.getMetaData();

        int colCount = metadata.getColumnCount();

        //Get number of records returned
        rs.last();

        int rowCount  = rs.getRow();

        String [][]rowData = new String [rowCount][colCount];

        //Its working I will update code . for now u can use ithis
        //Move the result set cursor from last to first to start reading data from result set
        rs.beforeFirst();

        for(int i=0; rs.next() ; i++){

            for(int j = 0; j< colCount ; j++){

                rowData[i][j] = rs.getString(j+1);
            }

        }

        rs.close();

        return rowData;
    }


    private static ResultSet executeQueryOnPRPCDB(String query) throws Exception{

        Connection conn = ConnectionManager.getPRPCDBConnection();

        Statement stmt = null ;

        ResultSet rs = null;

        try{

            stmt =  conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery(query);

        }catch (SQLException sqlException){

            LoggerUtils.error("Error while executing query" + sqlException.getMessage());
        }

        return rs;

    }

    public static String[] getRowDataForQueryFromPRPCDB(String query) throws Exception{

        ResultSet rs = executeQueryOnPRPCDB( query);

        ResultSetMetaData metadata = rs.getMetaData();

        int colCount = metadata.getColumnCount();


        String []rowData = new String [colCount];

        if(rs.next()){

            for(int i = 0; i< colCount ; i++){
                rowData[i] = rs.getString(i+1);
            }

        }

        rs.close();

        return rowData;

    }

    public static String [][] getMultiRowDataOnPRPCDB(String query) throws Exception{

        ResultSet rs = executeQueryOnPRPCDB( query);

        ResultSetMetaData metadata = rs.getMetaData();

        int colCount = metadata.getColumnCount();

        //Get number of records returned
        rs.last();

        int rowCount  = rs.getRow();

        String [][]rowData = new String [rowCount][colCount];


        //Move the result set cursor from last to first to start reading data from result set
        rs.beforeFirst();

        for(int i=0; rs.next() ; i++){

            for(int j = 0; j< colCount ; j++){

                rowData[i][j] = rs.getString(j+1);
            }

        }

        rs.close();

        return rowData;
    }



}
