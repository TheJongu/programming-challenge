package de.jgu.weather;

public class WeatherDTO {

	
	public WeatherDTO() {
		// Object is empty, is filled when its needed
	}
	
	// attributes taken from CSV File
		private int day;
		private int mxt;
		private int mnt;
		private int avt;
		private int avdp;
		private int hrp_pcpn;
		private int pdir;
		private int avsp;
		private int dir;
		private int mxs;
		private int skyc;
		private int mxr;
		private int mn;
		private int r_avslp;
		
		
	// generated getter&setter
	public int getMxt() {
		return mxt;
	}
	public void setMxt(int mxt) {
		this.mxt = mxt;
	}
	public int getMnt() {
		return mnt;
	}
	public void setMnt(int mnt) {
		this.mnt = mnt;
	}
	public int getAvt() {
		return avt;
	}
	public void setAvt(int avt) {
		this.avt = avt;
	}
	public int getAvdp() {
		return avdp;
	}
	public void setAvdp(int avdp) {
		this.avdp = avdp;
	}
	public int getHrp_pcpn() {
		return hrp_pcpn;
	}
	public void setHrp_pcpn(int hrp_pcpn) {
		this.hrp_pcpn = hrp_pcpn;
	}
	public int getPdir() {
		return pdir;
	}
	public void setPdir(int pdir) {
		this.pdir = pdir;
	}
	public int getAvsp() {
		return avsp;
	}
	public void setAvsp(int avsp) {
		this.avsp = avsp;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getMxs() {
		return mxs;
	}
	public void setMxs(int mxs) {
		this.mxs = mxs;
	}
	public int getSkyc() {
		return skyc;
	}
	public void setSkyc(int skyc) {
		this.skyc = skyc;
	}
	public int getMxr() {
		return mxr;
	}
	public void setMxr(int mxr) {
		this.mxr = mxr;
	}
	public int getMn() {
		return mn;
	}
	public void setMn(int mn) {
		this.mn = mn;
	}
	public int getR_avslp() {
		return r_avslp;
	}
	public void setR_avslp(int r_avslp) {
		this.r_avslp = r_avslp;
	}	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}   
