package com.qlsp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qlsp.Bean.SanPhamBean;

public class SanPhamDAO {
	
	// Hien thi danh sach san pham
	public List<SanPhamBean> ShowSP() {
		// Tao doi tuong luu danh sach san pham
		List<SanPhamBean> sanphambeanList = new ArrayList<SanPhamBean>();
		
		// Kiem tra loi
		try {
			// Mo ket noi voi database
			Connection connection = ConnectionDB.getConnection();
			
			// Tao mot statement va cau lenh mysql
			String query = "SELECT * FROM sanpham;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Thuc hien cau lenh mysql day
				ResultSet lsp = statement.executeQuery();
				/*
				 * Dong goi cac truong duoc lay ra tu csdl vao doi sanphambean va them no vao
				 * danh sach tra ve
				 */
				while(lsp.next()) {
					// Tao doi tuong dong goi
					SanPhamBean sanphambean = new SanPhamBean();
					sanphambean.setMsp(lsp.getInt("msp"));
					sanphambean.setTensp(lsp.getString("tensp"));
					sanphambean.setNgaynhap(lsp.getString("ngaynhap"));
					sanphambean.setGiatien(lsp.getString("giatien"));
					sanphambean.setGhichu(lsp.getString("ghichu"));
					
					// Them vao danh sach tra ve
					sanphambeanList.add(sanphambean);
				}
			
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// Tra ve danh sach san pham
		return sanphambeanList;
	}
	
	// Tim kiem san pham theo msp, tensp, giatien
	// Hien thi danh sach san pham
	public List<SanPhamBean> searchSP(String search) {
		// Tao doi tuong luu danh sach san pham
		List<SanPhamBean> sanphambeanList = new ArrayList<SanPhamBean>();
		
		// Kiem tra loi
		try {
			// Mo ket noi voi database
			Connection connection = ConnectionDB.getConnection();
			
			// Tao mot statement va cau lenh mysql
			String query = "SELECT * FROM sanpham WHERE msp like ? or tensp like ? or giatien like ?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Dien search vao cac cho duoc dat la ?
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			
			// Thuc hien cau lenh mysql day
				ResultSet lsp = statement.executeQuery();
				/*
				 * Dong goi cac truong duoc lay ra tu csdl vao doi sanphambean va them no vao
				 * danh sach tra ve
				 */
				while(lsp.next()) {
					// Tao doi tuong dong goi
					SanPhamBean sanphambean = new SanPhamBean();
					sanphambean.setMsp(lsp.getInt("msp"));
					sanphambean.setTensp(lsp.getString("tensp"));
					sanphambean.setNgaynhap(lsp.getString("ngaynhap"));
					sanphambean.setGiatien(lsp.getString("giatien"));
					sanphambean.setGhichu(lsp.getString("ghichu"));
					
					// Them vao danh sach tra ve
					sanphambeanList.add(sanphambean);
				}
			
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// Tra ve danh sach san pham
		return sanphambeanList;
	}
	
	// Them san pham
	public int insertSP(SanPhamBean sanphambean) {
		int result = 0;
		
		try {
			// Mo ket noi voi database
			Connection connection = ConnectionDB.getConnection();

			// Tao mot statement va cau lenh mysql
			String query = "INSERT INTO sanpham (tensp, ngaynhap, giatien, ghichu) VALUES (?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Dien cac thong tin vao dau ?
			statement.setString(1, sanphambean.getTensp());
			statement.setString(2, sanphambean.getNgaynhap());
			statement.setString(3, sanphambean.getGiatien());
			statement.setString(4, sanphambean.getGhichu());
			
			// Thuc hien cau lenh mysql
			result = statement.executeUpdate();
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	// Sua thong tin san pham
	public int updateSP(SanPhamBean sanphambean) {
		int result = 0;
		
		try {
			// Mo ket noi voi database
			Connection connection = ConnectionDB.getConnection();

			// Tao mot statement va cau lenh mysql
			String query = "UPDATE sanpham SET tensp = ?, ngaynhap = ?, giatien = ?, ghichu = ? WHERE msp = ?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Dien cac thong tin vao dau ?
			statement.setString(1, sanphambean.getTensp());
			statement.setString(2, sanphambean.getNgaynhap());
			statement.setString(3, sanphambean.getGiatien());
			statement.setString(4, sanphambean.getGhichu());
			statement.setInt(5, sanphambean.getMsp());
			
			// Thuc hien cau lenh mysql
			result = statement.executeUpdate();
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	// Xoa san pham
	public int deleteSP(SanPhamBean sanphambean) {
		int result = 0;
		
		try {
			// Mo ket noi voi database
			Connection connection = ConnectionDB.getConnection();

			// Tao mot statement va cau lenh mysql
			String query = "DELETE FROM sanpham WHERE msp = ?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			// Dien cac thong tin vao dau ?
			statement.setInt(1, sanphambean.getMsp());
			
			// Thuc hien cau lenh mysql
			result = statement.executeUpdate();
			
			// Dong ket noi
			ConnectionDB.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	// Test giao tiep voi CSDL
//	public static void  main(String[] agrs) {
//		// Tao doi tuong de goi cac ham trong SanPhamDAO.java
//		SanPhamDAO sanphamdao =  new SanPhamDAO();
//		
//		// Tao ra mot bien list de luu danh sach tra ve
//		List<SanPhamBean> sanphambeanList = sanphamdao.ShowSP();
//		
//		// Tao ra mot bien list de tim kiem
//		//List<SanPhamBean> sanphambeanList = sanphamdao.searchSP("e");
//		
//		// Them san pham
//		//SanPhamBean sanpham = new SanPhamBean("Dong ho", "2023-11-26", "2,000,000", "");
//		//System.out.println(sanphamdao.insertSP(sanpham));
//		
//		// Sửa sảm phẩm
//		// Them san pham
//		//SanPhamBean sanpham = new SanPhamBean("Dong ho111", "2023-11-26", "2,000,000", "");
//		//sanpham.setMsp(1);
//		//System.out.println(sanphamdao.updateSP(sanpham));
//		
//		// Xoa san pham
//		//SanPhamBean sanpham = new SanPhamBean();
//		//sanpham.setMsp(1);
//		//System.out.println(sanphamdao.deleteSP(sanpham));
//		
//		// Duy danh sach in ra 
//		for(SanPhamBean sanphambean : sanphambeanList) {
//			System.out.println(sanphambean.toString());
//		}
//	}
	
}
