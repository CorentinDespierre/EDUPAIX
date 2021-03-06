import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Personne {
	
	
	private int id, ref,codeP,dep,depRattaches,refComite;
	private LocalDate maj,passeportDelivery,dateNaissance;
	private boolean fiche,petitionnaire,elus,retour,mairie,bibli,Etranger;
	private String numPasseport,prefecture,ville,nom,prenom,lieuNaissance,adresse1,adresse2,adresse3,remarque,titre;
	private List<RolePersonne> roles= new ArrayList<>();
	private List<Integer> categ = new ArrayList<>();
	
	
	public List<Integer> getCateg() {
		return categ;
	}
	public void setCateg(List<Integer> categ) {
		this.categ = categ;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	

	public int getId() {
		return id;
	}
	public List<RolePersonne> getRoles() {
		return roles;
	}
	public void setRoles(List<RolePersonne> roles) {
		this.roles = roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getCodeP() {
		return codeP;
	}
	public void setCodeP(int codeP) {
		this.codeP = codeP;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public int getDepRattaches() {
		return depRattaches;
	}
	public void setDepRattaches(int depRattaches) {
		this.depRattaches = depRattaches;
	}
	public int getRefComite() {
		return refComite;
	}
	public void setRefComite(int refComite) {
		this.refComite = refComite;
	}
	public LocalDate getMaj() {
		return maj;
	}
	public void setMaj(LocalDate maj) {
		this.maj = maj;
	}
	public LocalDate getPasseportDelivery() {
		return passeportDelivery;
	}
	public void setPasseportDelivery(LocalDate passeportDelivery) {
		this.passeportDelivery = passeportDelivery;
	}
	public boolean isFiche() {
		return fiche;
	}
	public void setFiche(boolean fiche) {
		this.fiche = fiche;
	}
	public boolean isPetitionnaire() {
		return petitionnaire;
	}
	public void setPetitionnaire(boolean petitionnaire) {
		this.petitionnaire = petitionnaire;
	}
	public boolean isElus() {
		return elus;
	}
	public void setElus(boolean elus) {
		this.elus = elus;
	}

	public boolean isRetour() {
		return retour;
	}
	public void setRetour(boolean retour) {
		this.retour = retour;
	}
	
	
	public boolean isMairie() {
		return mairie;
	}
	public void setMairie(boolean mairie) {
		this.mairie = mairie;
	}
	public boolean isBibli() {
		return bibli;
	}
	public void setBibli(boolean bibli) {
		this.bibli = bibli;
	}
	
	public boolean isEtranger() {
		return Etranger;
	}
	public void setEtranger(boolean etranger) {
		Etranger = etranger;
	}
	public String getNumPasseport() {
		return numPasseport;
	}
	public void setNumPasseport(String numPasseport) {
		this.numPasseport = numPasseport;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
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
	public String getAdresse3() {
		return adresse3;
	}
	public void setAdresse3(String adresse3) {
		this.adresse3 = adresse3;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}


}
