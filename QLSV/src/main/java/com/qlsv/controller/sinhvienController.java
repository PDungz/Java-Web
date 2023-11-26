package com.qlsv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.qlsv.dao.sinhvienDAO;
import com.qlsv.model.sinhvienBean;


/**
 * Servlet implementation class sinhvienController
 */
@WebServlet("/")
public class sinhvienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sinhvienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String action = (request.getPathInfo() != null) ? request.getPathInfo() : "";

		String action = request.getServletPath();
		String delete = request.getParameter("delete");
		
		switch (action) {
			case "/views/insert": 
				getInsertSinhvien(request, response);
				break;
			case "/views/update":
				getUpdateSinhvien(request, response);
				break;
			case "/views/delete":
				getDeleteSinhvien(request, response);
				break;
			default:
				getShowSinhvien(request, response);
				break;
		}
		if("delete".equals(delete) && delete != "") {
			getDeleteSinhvien(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// Danh sach sinh vien
	private void getShowSinhvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sinhvienDAO sinhviendao = new sinhvienDAO();
		List<sinhvienBean> sinhviens = sinhviendao.showSinhVien();
		request.setAttribute("sinhviens", sinhviens);
		request.getRequestDispatcher("/views/show.jsp").forward(request, response);
	}
	
	// Them sinh vien
	private void getInsertSinhvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay data tu request
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String lop = request.getParameter("lop");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		
		// Dong goi doi tuong
		sinhvienBean sinhvien = new sinhvienBean(hoten, ngaysinh, lop, sdt, diachi);
		
		// Tao doi tuong dao va goi ham insert
		sinhvienDAO sinhviendao = new sinhvienDAO();
		int result = 0;
		result = sinhviendao.insertSinhVien(sinhvien);
		if(result != 0) {
			request.setAttribute("alert", "Thêm sinh vien thanh cong");
		}
		
		request.getRequestDispatcher("/QLSV/sinhvienController").forward(request, response);
	}
	
	
	// Sua thong tin sinh vien
	private void getUpdateSinhvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay date tu form 
		int msv = Integer.parseInt(request.getParameter("msv"));
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String lop = request.getParameter("lop");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		
		// Dong goi doi tuong
		sinhvienBean sinhvien = new sinhvienBean(hoten, ngaysinh, lop, sdt, diachi);
		sinhvien.setMsv(msv);
		
		// Tao doi tuong DAO
		sinhvienDAO sinhviendao = new sinhvienDAO();
		
		// Gọi hàm
		int result = 0;
		result = sinhviendao.updateSinhVien(sinhvien);
		if(result != 0) {
			request.setAttribute("alert", "Cap nhat thanh cong");
		}
		request.getRequestDispatcher("/QLSV/sinhvienController").forward(request, response);
		
	}
	
	private void getDeleteSinhvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay date msv
		int msv = Integer.parseInt(request.getParameter("msv"));
		
		// Tao doi tuong DAO
		sinhvienDAO sinhviendao = new sinhvienDAO();
		
		// Goi ham
		if(sinhviendao.deleteSinhVien(msv) != 0) {
			request.setAttribute("alert", "Xoa sinh vien thang cong");
		}
		request.getRequestDispatcher("/QLSV/sinhvienController").forward(request, response);
	}

}
