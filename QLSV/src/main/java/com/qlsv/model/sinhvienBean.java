package com.qlsv.model;

public class sinhvienBean {
	private int msv;
	private String hoten;
	private String ngaysinh;
	private String lop;
	private String sdt;
	private String diachi;
	
	public sinhvienBean() {

	}
	
	public sinhvienBean(String hoten, String ngaysinh, String lop, String sdt, String diachi) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.lop = lop;
		this.sdt = sdt;
		this.diachi = diachi;
	}

	public int getMsv() {
		return msv;
	}

	public void setMsv(int msv) {
		this.msv = msv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return "sinhvien [msv=" + msv + ", hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", lop=" + lop + ", sdt=" + sdt
				+ ", diachi=" + diachi + "]";
	}
	
	
}
