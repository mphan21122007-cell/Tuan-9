package qlsv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListSinhVien implements IFSinhVien {
	private ArrayList<SinhVien> danhSach;
	
	public ListSinhVien() {
		this.danhSach = new ArrayList<>();
	}
	
	public ListSinhVien(ArrayList<SinhVien> ds) {
		this.danhSach = ds;
	}
	
	public boolean them(SinhVien sv) {
		if(sv == null) return false;
		if(timTheoMa(sv.getMaSV()) != null) return false;
		return danhSach.add(sv);
	}
	
	public List<SinhVien> layTatCa() {
		return new ArrayList<>(danhSach);
	}
	
	public SinhVien timTheoMa(String maSV) {
		for(SinhVien sv : danhSach)
			if(sv.getMaSV().equalsIgnoreCase(maSV)) return sv;
		return null;
	}
	
	public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {
		List<SinhVien> kq = new ArrayList<>();
		for(SinhVien sv : danhSach)
			if(dieuKien.test(sv)) kq.add(sv);
		return kq;
	}
	
	public List<SinhVien> timTheoTen(String tuKhoa) {
		List<SinhVien> kq = new ArrayList<>();
		for(SinhVien sv : danhSach)
			if(sv.getHoTen().toLowerCase().contains(tuKhoa.toLowerCase()))
				kq.add(sv);
		return kq;
	}
	
	public List<SinhVien> timTheoLop(String lop) {
		List<SinhVien> kq =new ArrayList<>();
		String loai = null;
		for(SinhVien sv : danhSach) 
			if(sv.getLoai().equalsIgnoreCase(loai)) kq.add(sv);
		return kq;
	}
	
	public List<SinhVien> timTheoMon(MonHoc monHoc) {
		List<SinhVien> kq = new ArrayList<>();
		for(SinhVien sv : danhSach)
			if(sv.getMonHoc() == monHoc) kq.add(sv);
		return kq;
	}
	
	public int tongSoLuong() {
		return danhSach.size();
	}
	
	public double tongThanhTien() {
		double tong = 0;
		for(SinhVien sv : danhSach) tong += sv.thanhTien();
		return tong;
	}
	
	public void sapXep(Comparator<SinhVien> cmp) {
		danhSach.sort(cmp.reversed());
	}
	
	public List<SinhVien> sapXepTheoTen() {
		List<SinhVien> kq = new ArrayList<>(danhSach);
		kq.sort(Comparator.comparing(SinhVien::getHoTen));
		return kq;
	}

	@Override
	public boolean sua(String maSV, SinhVien svMoi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoa(String maSV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaTatCa() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SinhVien> timTheoLoai(String loai) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SinhVien> sapXepTheoThanhTienGiamDan() {
		// TODO Auto-generated method stub
		return null;
	}
}
