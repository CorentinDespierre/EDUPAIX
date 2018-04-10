
public class Structure_Comites {

	private String nom,adresse1,adresse2,ville,contact,siret="",rna="";
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getRna() {
		return rna;
	}
	public void setRna(String rna) {
		this.rna = rna;
	}
	public int getCodeP() {
		return codeP;
	}
	public void setCodeP(int codeP) {
		this.codeP = codeP;
	}
	private int niveau,id,codeP;
	private boolean actif,declaree,declarationdoc;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getcodeP() {
		return codeP;
	}
	public void setcodeP(int codeP) {
		this.codeP = codeP;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public boolean isDeclaree() {
		return declaree;
	}
	public void setDeclaree(boolean declaree) {
		this.declaree = declaree;
	}
	public boolean isDeclarationdoc() {
		return declarationdoc;
	}
	public void setDeclarationdoc(boolean declarationdoc) {
		this.declarationdoc = declarationdoc;
	}
	@Override
	public String toString() {
		return "Structure_Comites [nom=" + nom + ", adresse1=" + adresse1 + ", adresse2=" + adresse2 + ", ville="
				+ ville + ", contact=" + contact + ", codeP=" + codeP + ", niveau=" + niveau + ", id=" + id + ", actif="
				+ actif + ", declaree=" + declaree + ", declarationdoc=" + declarationdoc + "]";
	}
	
	
	
}