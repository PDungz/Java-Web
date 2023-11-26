package com.qlsv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qlsv.model.sinhvienBean;

public class sinhvienDAO {
	
	// Hien thi danh sach sinh vien
	public List<sinhvienBean> showSinhVien() {
		List<sinhvienBean> sinhviens = new ArrayList<>();
		try {
			// Mo ket noi
			Connection connection = ConnectionDB.getConnection();
			
			// Tao doi tuong statement
			String query = "SELECT * FROM PROFILESV";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Thuc hien truy van
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				sinhvienBean sinhvien = new sinhvienBean();
				sinhvien.setMsv(resultSet.getInt("msv"));
				sinhvien.setHoten(resultSet.getString("hoten"));
				sinhvien.setNgaysinh(resultSet.getString("ngaysinh"));
				sinhvien.setLop(resultSet.getString("lop"));
				sinhvien.setSdt(resultSet.getString("sdt"));
				sinhvien.setDiachi(resultSet.getString("diachi"));
				sinhviens.add(sinhvien);
			}
			
			// Dong ket noi 
			ConnectionDB.closeConnection(connection); 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sinhviens;
	}
	
	// Them moi sinh vien
	public int insertSinhVien(sinhvienBean sinhvien) {
		int result = 0;
		try {
			// Mo ket noi
			Connection connection = ConnectionDB.getConnection();
			
			// Tao doi tuong statement
			String query = "INSERT INTO profilesv(hoten, ngaysinh, lop, sdt, diachi) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, sinhvien.getHoten());
			statement.setString(2, sinhvien.getNgaysinh());
			statement.setString(3, sinhvien.getLop());
			statement.setString(4, sinhvien.getSdt());
			statement.setString(5, sinhvien.getDiachi());
			
			// Thuc hien cau query
			result = statement.executeUpdate();
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateSinhVien(sinhvienBean sinhvien) {
		int result = 0;
		try {
			// Mo ket noi
			Connection connection = ConnectionDB.getConnection();
			
			// Tao doi tuong statement
			String query = "UPDATE profilesv SET hoten = ?, ngaysinh = ?, lop = ?, sdt = ?, diachi = ? WHERE msv = ?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, sinhvien.getHoten());
			statement.setString(2, sinhvien.getNgaysinh());
			statement.setString(3, sinhvien.getLop());
			statement.setString(4, sinhvien.getSdt());
			statement.setString(5, sinhvien.getDiachi());
			statement.setInt(6, sinhvien.getMsv());
			
			// Thuc hien cau query
			result = statement.executeUpdate();
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteSinhVien(int msv) {
		int result = 0;
		try {
			// Mo ket noi
			Connection connection = ConnectionDB.getConnection();
			
			// Tao statement
			String query = "DELETE FROM  profilesv WHERE msv = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, msv);
			
			// Thuc hien cau query
			result = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	
//	public static void main(String []args) {
//		sinhvienDAO sinhviendao = new sinhvienDAO();
//		List<sinhvienBean> sinhviens = sinhviendao.showSinhVien();
//		sinhvienBean sinhvn = new sinhvienBean();
//		
////		Date currentDate = new Date(-500, 0, 1);
//
//		
////		sinhvienBean sinhvn1 = new sinhvienBean("Nguyen thi okla12", "2003-01-01", "DH11C", "0123456789", "123 - Duong ADC");
////		sinhviendao.insertSinhVien(sinhvn1);
//		
////		sinhvienBean sinhvn = new sinhvienBean("Nguyen thi okla11", currentDate, "DH11C", "0123450000", "123 - Duong ADC");
////		sinhvn.setMsv(11);
////		System.out.println(sinhviendao.deleteSinhVien(11));
//		
//		
//		for (sinhvienBean sinhvien : sinhviens) {
//			System.out.println(sinhvien.toString());
//		}
//	}
	
	
	
}
