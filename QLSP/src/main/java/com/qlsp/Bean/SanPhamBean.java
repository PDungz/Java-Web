package com.qlsp.Bean;

public class SanPhamBean {
	private int msp;
	private String tensp;
	private String ngaynhap;
	private String giatien;
	private String ghichu;
	
	public SanPhamBean() {
		super();
	}
	
	public SanPhamBean(String tensp, String ngaynhap, String giatien, String ghichu) {
		super();
		this.tensp = tensp;
		this.ngaynhap = ngaynhap;
		this.giatien = giatien;
		this.ghichu = ghichu;
	}

	public int getMsp() {
		return msp;
	}

	public void setMsp(int msp) {
		this.msp = msp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	@Override
	public String toString() {
		return "SanPhamBean [msp=" + msp + ", tensp=" + tensp + ", ngaynhap=" + ngaynhap + ", giatien=" + giatien
				+ ", ghichu=" + ghichu + "]";
	}
	
	
}
