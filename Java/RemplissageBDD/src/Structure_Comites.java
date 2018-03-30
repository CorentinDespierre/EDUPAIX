
public class Structure_Comites {

	private String nom,adresse1,adresse2,ville,mobile,telephone,courriel,contact,region,fax;
	private int codeP,niveau,departement,categorie,id;
	private boolean actif,declaree,declarationdoc;
	
	
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDeclarationdoc() {
		return declarationdoc;
	}
	@Override
	public String toString() {
		return "Structure_Comites [nom=" + nom + ", adresse1=" + adresse1 + ", adresse2=" + adresse2 + ", ville="
				+ ville + ", mobile=" + mobile + ", telephone=" + telephone + ", courriel=" + courriel + ", contact="
				+ contact + ", region=" + region + ", codeP=" + codeP + ", niveau=" + niveau + ", departement="
				+ departement + ", categorie=" + categorie + ", actif=" + actif + ", declaree=" + declaree
				+ ", declarationdoc=" + declarationdoc + "]";
	}
	public void setDeclarationdoc(boolean declarationdoc) {
		this.declarationdoc = declarationdoc;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public boolean isDeclaree() {
		return declaree;
	}
	public void setDeclaree(boolean declaree) {
		this.declaree = declaree;
	}

	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse1() {
		return adresse1;
	}
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	public String getAdresse2() {
		return adresse2;
	}
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getCodeP() {
		return codeP;
	}
	public void setCodeP(int codeP) {
		this.codeP = codeP;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
