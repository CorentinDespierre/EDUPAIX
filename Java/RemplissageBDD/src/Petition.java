import java.time.LocalDate;

public class Petition {
	
	private int id,membre;
	private String theme;
	private int date;
	private boolean maire=false,depute=false,deputeeuro=false,pres=false,internet=false,presparlement=false;
	
	
	public int getMembre() {
		return membre;
	}
	public void setMembre(int membre) {
		this.membre = membre;
	}
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	
	public boolean isPresparlement() {
		return presparlement;
	}
	public void setPresparlement(boolean presparlement) {
		this.presparlement = presparlement;
	}
	public Petition()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int l) {
		this.date = l;
	}
	public boolean isMaire() {
		return maire;
	}
	public void setMaire(boolean maire) {
		this.maire = maire;
	}
	public boolean isDepute() {
		return depute;
	}
	public void setDepute(boolean depute) {
		this.depute = depute;
	}
	public boolean isDeputeeuro() {
		return deputeeuro;
	}
	public void setDeputeeuro(boolean deputeeuro) {
		this.deputeeuro = deputeeuro;
	}
	public boolean isPres() {
		return pres;
	}
	public void setPres(boolean pres) {
		this.pres = pres;
	}
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	@Override
	public String toString() {
		return "Petition [id=" + id + ", membre=" + membre + ", theme=" + theme + ", date=" + date + ", maire=" + maire
				+ ", depute=" + depute + ", deputeeuro=" + deputeeuro + ", pres=" + pres + ", internet=" + internet
				+ ", presparlement=" + presparlement + "]";
	}
	


}
