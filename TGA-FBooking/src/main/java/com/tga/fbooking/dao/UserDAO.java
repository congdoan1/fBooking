package com.tga.fbooking.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tga.fbooking.dto.UserDTO;
import com.tga.fbooking.util.DBUtils;

@SuppressWarnings("serial")
public class UserDAO implements Serializable {
	
	public static boolean register(String username, String password, String firstName, String lastName) {
		PreparedStatement stm = null;
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			String sql = "insert into user(username, password, firstName, lastName) "
					+ "values(?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			stm.setString(3, firstName);
			stm.setString(4, lastName);
			int row = stm.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static UserDTO checkLogin(String username, String password) {
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			String sql = "select * from user where username=? and password=?";
			stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, password);
			rs = stm.executeQuery();
			if (rs.next()) {
				String user = rs.getString(2);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				
				UserDTO dto = new UserDTO();
				dto.setUsername(user);
				dto.setFirstName(firstName);
				dto.setLastName(lastName);
				return dto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static boolean register(String username, String firstName, String lastName,
			String facebookId, String facebookUrl) {
		PreparedStatement stm = null;
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			String sql = "insert into user(username, firstName, lastName, facebookId, facebookUrl) "
					+ "values(?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, username);
			stm.setString(2, firstName);
			stm.setString(3, lastName);
			stm.setString(4, facebookId);
			stm.setString(5, facebookUrl);
			int row = stm.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static UserDTO checkLogin(String facebookId) {
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DBUtils.makeConnection();
			String sql = "select * from user where facebookId=?";
			stm = con.prepareStatement(sql);
			stm.setString(1, facebookId);
			rs = stm.executeQuery();
			if (rs.next()) {
				String user = rs.getString(2);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				String faceId = rs.getString(6);
				String faceUrl = rs.getString(7);
				
				UserDTO dto = new UserDTO();
				dto.setUsername(user);
				dto.setFirstName(firstName);
				dto.setLastName(lastName);
				dto.setFacebookId(faceId);
				dto.setFacebookUrl(faceUrl);
				return dto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
}
