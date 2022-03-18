package de.jgu.weather;

public class WeatherDTO {

	/**
	 * Empty constructor
	 */
	public WeatherDTO() {
		// Object is empty, is filled when its needed
	}
	
	@Override
	public String toString() {
		String theString = "day: " + day;
		theString += ", mxt: " + mxt;
		theString += ", mnt: " + mnt;
		theString += ", avt: " + avt;
		theString += ", avdp: " + avdp;
		theString += ", hrp_pcpn: " + hrp_pcpn;
		theString += ", pdir: " + pdir;
		theString += ", avsp: " + avsp;
		theString += ", dir: " + dir;
		theString += ", mxs: " + mxs;
		theString += ", skyc: " + skyc;
		theString += ", mxr: " + mxr;
		theString += ", mn: " + mn;
		theString += ", r_avslp: " + r_avslp;
		return theString;
	}
	
	// attributes taken from CSV File
		private int day;
		private int mxt;
		private int mnt;
		private int avt;
		private double avdp;
		private double hrp_pcpn;
		private int pdir;
		private double avsp;
		private int dir;
		private int mxs;
		private double skyc;
		private int mxr;
		private int mn;
		private double r_avslp;
		
		
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
	public double getAvdp() {
		return avdp;
	}
	public void setAvdp(double avdp) {
		this.avdp = avdp;
	}
	public double getHrp_pcpn() {
		return hrp_pcpn;
	}
	public void setHrp_pcpn(double hrp_pcpn) {
		this.hrp_pcpn = hrp_pcpn;
	}
	public int getPdir() {
		return pdir;
	}
	public void setPdir(int pdir) {
		this.pdir = pdir;
	}
	public double getAvsp() {
		return avsp;
	}
	public void setAvsp(double avsp) {
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
	public double getSkyc() {
		return skyc;
	}
	public void setSkyc(double skyc) {
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
	public double getR_avslp() {
		return r_avslp;
	}
	public void setR_avslp(double r_avslp) {
		this.r_avslp = r_avslp;
	}	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}   
