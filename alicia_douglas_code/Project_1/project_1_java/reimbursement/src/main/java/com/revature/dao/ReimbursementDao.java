package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;

//import oracle.jdbc.OracleTypes;

public class ReimbursementDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Create
	public void createReimbursement(Reimbursement reimb) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{Call create_reimbursement(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reimb.getEmpUId());
			cs.setDouble(2, reimb.getAmt());
			cs.setString(3, reimb.getDescription());
			cs.setBlob(4, reimb.getImg());
			cs.setInt(5, reimb.getRbTypeId());
			cs.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Read
	/**
	 * get a list of reimbursements using the employees id number
	 * 
	 * @param id
	 * @return
	 */
	public List<Reimbursement> getReimbursementByEmployeeId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement r LEFT JOIN rb_status rs ON r.rb_status_id = rs.rb_status_id LEFT JOIN rb_type rt "
					+ "ON r.rb_type_id = rt.rb_type_id LEFT JOIN users u ON r.emp_u_id = u.u_id LEFT JOIN users u ON r.mgr_u_id = u.u_id WHERE emp_u_id = ? ORDER BY r_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"),
						rs.getString("fname") + " " + rs.getString("lname"), rs.getInt("mgr_u_id"),
						rs.getString(23) + " " + rs.getString(24), rs.getDouble("amt"), rs.getString("description"),
						rs.getBlob("img"), rs.getDate("time_submission"), rs.getString("rb_type"),
						rs.getInt("rb_type_id"), rs.getString("rb_status"), rs.getInt("rb_status_id"));
				reimbursements.add(reimbursement);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	
	public Reimbursement getReimbursementByRId(int rId) {
		Reimbursement reimbursement = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement r LEFT JOIN rb_status rs ON r.rb_status_id = rs.rb_status_id LEFT JOIN rb_type rt "
					+ "ON r.rb_type_id = rt.rb_type_id LEFT JOIN users u ON r.emp_u_id = u.u_id LEFT JOIN users u ON r.mgr_u_id = u.u_id WHERE r_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"),
						rs.getString("fname") + " " + rs.getString("lname"), rs.getInt("mgr_u_id"),
						rs.getString(23) + " " + rs.getString(24), rs.getDouble("amt"), rs.getString("description"),
						rs.getBlob("img"), rs.getDate("time_submission"), rs.getString("rb_type"),
						rs.getInt("rb_type_id"), rs.getString("rb_status"), rs.getInt("rb_status_id"));
//				reimbursements.add(reimbursement);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}
	

	/**
	 * get a list of all the reimbursements
	 * 
	 * @return
	 */
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			
			String sql = "SELECT * FROM reimbursement r LEFT JOIN rb_status rs ON r.rb_status_id = rs.rb_status_id LEFT JOIN rb_type rt "
					+ "ON r.rb_type_id = rt.rb_type_id LEFT JOIN users u ON r.emp_u_id = u.u_id LEFT JOIN users u ON r.mgr_u_id = u.u_id ORDER BY r_id";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"),
						rs.getString("fname") + " " + rs.getString("lname"), rs.getInt("mgr_u_id"),
						rs.getString(23) + " " + rs.getString(24), rs.getDouble("amt"), rs.getString("description"),
						rs.getBlob("img"), rs.getDate("time_submission"), rs.getString("rb_type"),
						rs.getInt("rb_type_id"), rs.getString("rb_status"), rs.getInt("rb_status_id"));
				reimbursements.add(reimbursement);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	// Update
	/**
	 * update the status of a reimbursement
	 * 
	 * @param reimb
	 * @param mgrId
	 * @param status
	 */
	public void updateReimbursementStatus(Reimbursement reimb, int mgrId, int status) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "UPDATE reimbursement SET mgr_u_id = ? , rb_status_id = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mgrId);
			ps.setInt(2, status);
			ps.setInt(3, reimb.getrId());
			ps.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete

}
