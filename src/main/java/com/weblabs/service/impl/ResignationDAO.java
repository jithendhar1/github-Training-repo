package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AddResignation;
import com.weblabs.utility.DBUtil;

public class ResignationDAO {
    public static List<AddResignation> getFilteredResignation(String whereClause, int start, int limit) {
        List<AddResignation> FilteredResignation = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.provideConnection();
            String query;
            if (whereClause != null && !whereClause.isEmpty()) {
                query = "SELECT Id, ResigningEmployee, NoticeDate, ResignationDate, ResignationDate FROM resignation WHERE " + whereClause + " LIMIT ?, ?;";
               
            } else {
                query = "SELECT Id, ResigningEmployee, NoticeDate, ResignationDate, ResignationDate FROM resignation LIMIT ?, ?;";
                }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, limit);
     
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	AddResignation pro = new AddResignation();
                pro.setId(resultSet.getString("Id"));
                pro.setResigningEmployee(resultSet.getString("ResigningEmployee"));
                pro.setNoticeDate(resultSet.getString("NoticeDate"));
                pro.setResignationDate(resultSet.getString("ResignationDate"));
                pro.setResignationDate(resultSet.getString("ResignationDate"));
                
                
                FilteredResignation.add(pro);
            }
        } catch (Exception e) {
            // Handle exceptions
        	 e.printStackTrace();
        } finally {
            // Close database resources (connection, statement, result set)
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                // Handle exceptions
            	 e.printStackTrace();
            }
        }

        return FilteredResignation;
    }
    
    public static int totalCount() {
		 int count = 0;
		 Connection connection = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
		 try {
			 connection = DBUtil.provideConnection();
		   String query = "select count(*) as count from resignation";
		 ps = connection.prepareStatement(query);
		 rs = ps.executeQuery();
		 while (rs.next()) {
		 count = rs.getInt("count");
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 try {
			 connection.close();
		 } catch (SQLException ex) {
		 ex.printStackTrace();
		 }
		 }
		 return count;
		 }
}