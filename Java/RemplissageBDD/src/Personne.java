import java.time.LocalDate;

public class Personne {
	
	
	private int id, ref,codeP,dep,depRattaches,refComite;
	private LocalDate maj,passeportDelivery;
	private boolean fiche,petitionnaire,elus,mailing,retour,souscription,contact,organisation,comite,mairie,bibli,couple,sansAdrese,Etranger;
	public int getId() {
		return id;
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
	public boolean isMailing() {
		return mailing;
	}
	public void setMailing(boolean mailing) {
		this.mailing = mailing;
	}
	public boolean isRetour() {
		return retour;
	}
	public void setRetour(boolean retour) {
		this.retour = retour;
	}
	public boolean isSouscription() {
		return souscription;
	}
	public void setSouscription(boolean souscription) {
		this.souscription = souscription;
	}
	public boolean isContact() {
		return contact;
	}
	public void setContact(boolean contact) {
		this.contact = contact;
	}
	public boolean isOrganisation() {
		return organisation;
	}
	public void setOrganisation(boolean organisation) {
		this.organisation = organisation;
	}
	public boolean isComite() {
		return comite;
	}
	public void setComite(boolean comite) {
		this.comite = comite;
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
	public boolean isCouple() {
		return couple;
	}
	public void setCouple(boolean couple) {
		this.couple = couple;
	}
	public boolean isSansAdrese() {
		return sansAdrese;
	}
	public void setSansAdrese(boolean sansAdrese) {
		this.sansAdrese = sansAdrese;
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
	public String getAouC() {
		return AouC;
	}
	public void setAouC(String aouC) {
		AouC = aouC;
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
	private String numPasseport,prefecture,ville,AouC,nom,prenom,lieuNaissance,adresse1,adresse2,adresse3,remarque,titre;

}
