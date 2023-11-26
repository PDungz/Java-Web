package com.qlsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlsp.Bean.SanPhamBean;
import com.qlsp.dao.SanPhamDAO;

/**
 * Servlet implementation class SanPhamController
 */
@WebServlet("/")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Lay duong dang dan cua Servlet dang thuc thi
		String action = request.getServletPath();
		
		// Kiem tra duong dan
		switch(action) {
			case "/views/insert":
				// goi den ham them san pham
				getInsert(request, response);
				break;
			case "/views/update":
				// goi den ham sua san pham
				getUpdate(request, response);
				break;
			case "/views/delete":
				// goi den ham xoa san pham
				getDelete(request, response);	
				break;
			case "/views/search":
				// goi den ham search san pham
				getSearch(request, response);
				break;
			default:
				// goi den ham hien thi san
				getShow(request, response);
				break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// Lay ra danh sach san pham va gui ve qlsp de hien thi
	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tao doi tuong sanphamdao
		SanPhamDAO sanphamdao = new SanPhamDAO();
		
		// Luu danh sach san pham duoc lay ra
		List<SanPhamBean> sanphambeanList = sanphamdao.ShowSP();
		
		// set thuoc tinh gui ve cho danh sach nay
		request.setAttribute("sanphamList", sanphambeanList);
		
		// Chuyen huong den trang qlsp
		request.getRequestDispatcher("/views/qlsp.jsp").forward(request, response);
	}
	
	// Tim kiem lay danh sach san pham duoc tim  kiem va tra ve trang qlsp de hien thi
	private void getSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay du lieu duoc gui tu form qua 
		String search = request.getParameter("search");
		
		// Tao doi tuong sanphamdao
		SanPhamDAO sanphamdao = new SanPhamDAO();
		
		// Luu danh sach san pham duoc lay ra
		List<SanPhamBean> sanphambeanList = sanphamdao.searchSP(search);
		
		// set thuoc tinh gui ve cho danh sach nay
		request.setAttribute("sanphamList", sanphambeanList);
		
		// Chuyen huong den trang qlsp
		request.getRequestDispatcher("/views/qlsp.jsp").forward(request, response);
	}
	
	// Them san pham lay du lieu tu form them gui den controller xu ly dong goi gui qua SanPhamDAO de them san pham vao CSDL
	private void getInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay du lieu duoc gui tu form qua 
		String tensp = request.getParameter("tensp");
		String ngaynhap = request.getParameter("ngaynhap");
		String giatien = request.getParameter("giatien");
		String ghichu = request.getParameter("ghichu");
		
		// Dong goi du lieu lay xuong
		SanPhamBean sanphambean = new SanPhamBean(tensp, ngaynhap, giatien, ghichu);
		
		// Tao doi tuong sanphamdao
		SanPhamDAO sanphamdao = new SanPhamDAO();
		sanphamdao.insertSP(sanphambean);
		
		// Chuyen huong den trang qlsp
		response.sendRedirect("/QLSP/");
	}
	
	// Sua san pham lay du tu form sua va gui den controller xu ly dong goi va gui qua SanPhamDao de sua lai thong san pham
	private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay du lieu duoc gui tu form qua 
		int msp = Integer.parseInt(request.getParameter("msp"));
		String tensp = request.getParameter("tensp");
		String ngaynhap = request.getParameter("ngaynhap");
		String giatien = request.getParameter("giatien");
		String ghichu = request.getParameter("ghichu");
		
		// Dong goi du lieu lay xuong
		SanPhamBean sanphambean = new SanPhamBean(tensp, ngaynhap, giatien, ghichu);
		sanphambean.setMsp(msp);
		
		// Tao doi tuong sanphamdao
		int result = 0;
		SanPhamDAO sanphamdao = new SanPhamDAO();
		result = sanphamdao.updateSP(sanphambean);
		
		// set thuoc tinh gui ve cho danh sach nay
		if(result == 1) {
			request.setAttribute("thongbao", "Sua san pham thanh");
		}
		
		// Chuyen huong den trang qlsp
		request.getRequestDispatcher("/").forward(request, response);
	}
	
	
	// Xoa san lay thong tin tu form xoa san pham gui den controller xu ly dong goi va gui qua SanPhamDao de xoa san pham
	
	private void getDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Lay du lieu duoc gui tu form qua 
		int msp = Integer.parseInt(request.getParameter("msp"));
		
		// Dong goi du lieu lay xuong
		SanPhamBean sanphambean = new SanPhamBean();
		sanphambean.setMsp(msp);
		
		// Tao doi tuong sanphamdao
		int result = 0;
		SanPhamDAO sanphamdao = new SanPhamDAO();
		result = sanphamdao.deleteSP(sanphambean);
		
		// set thuoc tinh gui ve cho danh sach nay
		if(result == 1) {
			request.setAttribute("thongbao", "Xoa san pham thanh");
		}
		
		// Chuyen huong den trang qlsp
		request.getRequestDispatcher("/").forward(request, response);
	}
}
