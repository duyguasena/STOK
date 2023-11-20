package model;

public class Stok {
	private String stokkod;
	private String stokad;
	private String barkod;
	private String stoktip;
	private String birim;
	private String kdvtipid;
	private String açıklama;
	private String zaman;
	
	
	public String getStokkod() {
		return stokkod;
	}


	public void setStokkod(String stokkod) {
		this.stokkod = stokkod;
	}


	public String getStokad() {
		return stokad;
	}


	public void setStokad(String stokad) {
		this.stokad = stokad;
	}


	public String getBarkod() {
		return barkod;
	}


	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}


	public String getStoktip() {
		return stoktip;
	}


	public void setStoktip(String stoktip) {
		this.stoktip = stoktip;
	}


	public String getBirim() {
		return birim;
	}


	public void setBirim(String birim) {
		this.birim = birim;
	}


	public String getKdvtipid() {
		return kdvtipid;
	}


	public void setKdvtipid(String kdvtipid) {
		this.kdvtipid = kdvtipid;
	}


	public String getAçıklama() {
		return açıklama;
	}


	public void setAçıklama(String açıklama) {
		this.açıklama = açıklama;
	}


	public String getZaman() {
		return zaman;
	}


	public void setZaman(String zaman) {
		this.zaman = zaman;
	}


	public Stok(String stokkod, String stokad, String barkod, String stoktip, String birim, String kdvtipid,
			String açıklama, String zaman) {
		super();
		this.stokkod = stokkod;
		this.stokad = stokad;
		this.barkod = barkod;
		this.stoktip = stoktip;
		this.birim = birim;
		this.kdvtipid = kdvtipid;
		this.açıklama = açıklama;
		this.zaman = zaman;
	}
	

}
