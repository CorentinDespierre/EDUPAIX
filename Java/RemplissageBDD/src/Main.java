import java.io.File;
import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		parseMembre();

	}



	public static void parseMembre()
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();
			File file = new File("C:/GIT/EDUPAIX/BasesXML/Membres.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			System.out.println(root.toString());
			List<Element> elem = root.elements();
			System.out.println("elem: "+elem.size());


			List <Personne>listp = new ArrayList<>();

			Map<Integer,ContactPersonne> map = new HashMap<>();

			int i=1;
			for(Element e: elem)
			{
				Personne p= new Personne();
				p.setId(i);
				ContactPersonne cp= new ContactPersonne();
				List<Element>attrib = e.elements();
				for(Element f:attrib)
				{

					switch(f.getName())
					{
					case "RéfMembre":
						p.setRef(Integer.parseInt(f.getText()));
						break;
					case "Adhérent_x0020_ou_x0020_contact":

						if(f.getText().contains("A") && !f.getText().contains("z"))
						{
							p.getCateg().add(1);
						}
						if(f.getText().contains("J"))
						{
							p.getCateg().add(3);
						}
						if(f.getText().contains("C"))
						{
							p.getCateg().add(2);
						}
						else
							break;

						break;
					case "Miseàjour":
						String maj=f.getText().substring(0, 10);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						p.setMaj(LocalDate.parse(maj, formatter));
						break;
					case "RefTitre":
						if(Integer.parseInt(f.getText())==1)
							p.setTitre("Mlle");
						else if(Integer.parseInt(f.getText())==2)
							p.setTitre("Mme");
						else if(Integer.parseInt(f.getText())==3)
							p.setTitre("M.");
						else if(Integer.parseInt(f.getText())==4)
							p.setTitre("Intitulé");
						else if(Integer.parseInt(f.getText())==6)
							p.setTitre("M. Mme");

						break;
					case "Nom":
						p.setNom(f.getText());
						break;
					case "Prénom":
						p.setPrenom(f.getText());
						break;
					case "Adresse1":
						p.setAdresse1(f.getText());
						break;
					case "Adresse2":
						p.setAdresse2(f.getText());
						break;
					case "Adresse3":
						p.setAdresse3(f.getText());
						break;
					case "CodeP":
						p.setCodeP(Integer.parseInt(f.getText()));
						break;
					case "Ville":
						p.setVille(f.getText());
						break;
					case "N_x00B0_dép":
						p.setDep(Integer.parseInt(f.getText()));
						break;
					case "N_x00B0_dépt":
						p.setDepRattaches(Integer.parseInt(f.getText()));
						break;
					case "Date_x0020_de_x0020_Naissance":
						String ma=f.getText().substring(0, 10);
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						p.setDateNaissance(LocalDate.parse(ma, format));
						break;
					case "Lieu_x0020_de_x0020_Naissance":
						p.setLieuNaissance(f.getText());
						break;
					case "N_x00B0__x0020_Passeport":
						p.setNumPasseport(f.getText());
						break;
					case "Délivré_x0020_le":
						String m=f.getText().substring(0, 10);
						DateTimeFormatter forma = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						p.setMaj(LocalDate.parse(m, forma));
						break;
					case "Préfecture":
						p.setPrefecture(f.getText());
						break;
					case "Mobile":
						cp.setMobile(f.getText());
						break;
					case "RéfComité":
						p.setRefComite(Integer.parseInt(f.getText()));
						break;
					case "TélDomicile":
						cp.setTelDomicile(f.getText());
						break;
					case "FaxDomicile":
						cp.setFaxDomicile(f.getText());
						break;
					case "TélPortable":
						cp.setPortable(f.getText());
						break;
					case "Courriel":
						cp.setCourriel(f.getText());
						break;
					case "FaxProfessionnel":
						cp.setFaxPro(f.getText());
						break;

					case "TélProfessionnel":
						cp.setTelProfessionel(f.getText());
						break;
					case "Fiche":
						if(Integer.parseInt(f.getText())==0)
							p.setFiche(false);
						else
							p.setFiche(true);
						break;
					case "Pétitionnaire":
						if(Integer.parseInt(f.getText())==0)
							p.setPetitionnaire(false);
						else
							p.setPetitionnaire(true);
						break;
					case "Elus":
						if(Integer.parseInt(f.getText())==0)
							p.setElus(false);
						else
							p.setElus(true);
						break;
					case "Mailing":
						break;
					case "Retour":
						if(Integer.parseInt(f.getText())==0)
							p.setRetour(false);
						else
							p.setRetour(true);
						break;
					case "Souscription":
						break;
					case "Contacts":
						break;
					case "Orga":
						break;
					case "Cté":
						break;
					case "Mairie":
						if(Integer.parseInt(f.getText())==0)
							p.setMairie(false);
						else
							p.setMairie(true);
						break;
					case "Bibliothèque":
						if(Integer.parseInt(f.getText())==0)
							p.setBibli(false);
						else
							p.setBibli(true);
						break;
					case "Couple":
						break;
					case "Sans_x0020_Adresse":
						break;
					case "Etranger":
						if(Integer.parseInt(f.getText())==0)
							p.setEtranger(false);
						else
							p.setEtranger(true);
						break;
					case "Resp_x0020_locales":
						if(f.getText().contains("CPT"))
						{

							RolePersonne rolePersonne = new RolePersonne();
							rolePersonne.setIdPersonne(p.getId());
							rolePersonne.setIdStructure(p.getRefComite());
							rolePersonne.setIdRole(7);
							RolePersonne rolePersonne1 = new RolePersonne();
							rolePersonne1.setIdPersonne(p.getId());
							rolePersonne1.setIdStructure(p.getRefComite());
							rolePersonne1.setIdRole(3);
							p.getRoles().add(rolePersonne);
							p.getRoles().add(rolePersonne1);

						}
						else if (!f.getText().contains("M") && !f.getText().contains("RCP"))
						{
							ResultSet resultat = statement.executeQuery( "SELECT \"idTypeRole\" FROM public.\"TypeRole\" WHERE \"Initiale\"="+"'"+f.getText().toUpperCase()+"'"+";" );
							int id=0;
							while(resultat.next())
							{
								id= resultat.getInt(1);
							}
							RolePersonne rolePersonne2 = new RolePersonne();
							rolePersonne2.setIdPersonne(p.getId());
							rolePersonne2.setIdStructure(p.getRefComite());
							rolePersonne2.setIdRole(id);
							p.getRoles().add(rolePersonne2);


						}
						break;

					case "Resp_x0020_nationales":
						if(f.getText()=="BN")
						{
							RolePersonne rolePersonne = new RolePersonne();
							rolePersonne.setIdPersonne(p.getId());
							rolePersonne.setIdStructure(p.getRefComite());
							rolePersonne.setIdRole(8);
							p.getRoles().add(rolePersonne);							
							break;

						}
						else if(f.getText()=="CN")
						{
							RolePersonne rolePersonne = new RolePersonne();
							rolePersonne.setIdPersonne(p.getId());
							rolePersonne.setIdStructure(p.getRefComite());
							rolePersonne.setIdRole(9);
							p.getRoles().add(rolePersonne);							
							break;
						}
						else
						{
							break;
						}

					case "Remarque":
						p.setRemarque(f.getText());
						break;
					default:
						break;


					}
				}
				listp.add(p);
				map.put(p.getId(), cp);
				i++;
			}

			System.out.println("listp"+listp.size());
			System.out.println("map"+map.size());

			for(Personne p :listp)
			{

				if(p.getTitre()==null)
					p.setTitre("");
				if(p.getNom()==null)
					p.setNom("");
				if(p.getAdresse1()==null)
					p.setAdresse1("");
				if(p.getAdresse2()==null)
					p.setAdresse2("");
				if(p.getAdresse3()==null)
					p.setAdresse3("");
				if(p.getPrenom()==null)
					p.setPrenom("");
				if(p.getVille()==null) 
					p.setVille("");
				if(p.getLieuNaissance()==null)
					p.setLieuNaissance("");
				if(p.getNumPasseport()==null)
					p.setNumPasseport("");
				if(p.getPrefecture()==null)
					p.setPrefecture("");
				if(p.getRemarque()==null)
					p.setRemarque("");
				if(p.getDateNaissance()==null)
					p.setDateNaissance(LocalDate.of(9999,01,01));
				if(p.getMaj()==null)
					p.setMaj(LocalDate.of(9999,01,01));
				if(p.getPasseportDelivery()==null)
					p.setPasseportDelivery(LocalDate.of(9999,01,01));


				//REMPLACEMENT DES '

				if(p.getNom().contains("'"))
					p.setNom(p.getNom().replace("'", " "));
				if(p.getPrenom().contains("'"))
					p.setPrenom(p.getPrenom().replace("'", " "));
				if(p.getAdresse1().contains("'"))
					p.setAdresse1(p.getAdresse1().replace("'", " "));
				if(p.getAdresse2().contains("'"))
					p.setAdresse2(p.getAdresse2().replace("'", " "));
				if(p.getAdresse3().contains("'"))
					p.setAdresse3(p.getAdresse3().replace("'", " "));
				if(p.getVille().contains("'"))
					p.setVille(p.getVille().replace("'", " "));
				if(p.getLieuNaissance().contains("'"))
					p.setLieuNaissance(p.getLieuNaissance().replace("'", " "));
				if(p.getPrefecture().contains("'"))
					p.setPrefecture(p.getPrefecture().replace("'", " "));
				if(p.getRemarque().contains("'"))
					p.setRemarque(p.getRemarque().replace("'", " "));
				if(p.getNumPasseport().contains("'"))
					p.setNumPasseport(p.getNumPasseport().replaceAll("'", " "));

				//statement.execute( "INSERT INTO public.\"Personne\" VALUES("+p.getId()+","+p.getRef()+",'"+p.getTitre()+"','"+p.getNom()+"','"+p.getPrenom()+"','"+p.getMaj()+"','"+p.getAdresse1()+"','"+p.getAdresse2()+"','"+p.getAdresse3()+"',"+p.getCodeP()+",'"+p.getVille()+"',"+p.getDep()+","+p.getDepRattaches()+",'"+p.getDateNaissance()+"','"+p.getLieuNaissance()+"','"+p.getNumPasseport()+"','"+p.getPasseportDelivery()+"','"+p.getPrefecture()+"',"+p.getRefComite()+","+p.isFiche()+","+p.isPetitionnaire()+","+p.isElus()+","+p.isRetour()+","+p.isMairie()+","+p.isBibli()+","+p.isEtranger()+",'"+p.getRemarque()+"');");

			}
			System.out.println("FIN REQUETE 1");

			int l=1;
			for(Personne per: listp)
			{
				if(!per.getCateg().isEmpty())
				{
					for(Integer in : per.getCateg())
					{
						statement.execute("INSERT INTO public.\"CategoriePersonne_Personne_CotisationHisto\" VALUES("+l+","+in+","+per.getId()+");");
						l++;
					}

				}
			}
			System.out.println("FIN REQUETE 2");

			int j=1;
			for(Map.Entry<Integer, ContactPersonne> entry:map.entrySet())
			{
				if(entry.getValue().getPortable()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",1,'"+entry.getValue().getPortable()+"');");
					j++;
				}
				if(entry.getValue().getTelDomicile()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",2,'"+entry.getValue().getTelDomicile()+"');");
					j++;
				}
				if(entry.getValue().getTelProfessionel()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",3,'"+entry.getValue().getTelProfessionel()+"');");
					j++;
				}
				if(entry.getValue().getMobile()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",4,'"+entry.getValue().getMobile()+"');");
					j++;
				}
				if(entry.getValue().getFaxPro()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",5,'"+entry.getValue().getFaxPro()+"');");
					j++;
				}
				if(entry.getValue().getFaxDomicile()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",6,'"+entry.getValue().getFaxDomicile()+"');");
					j++;
				}
				if(entry.getValue().getCourriel()!=null) {
					statement.execute("INSERT INTO public.\"TypeContact_Personne\" VALUES("+j+","+entry.getKey()+",7,'"+entry.getValue().getCourriel()+"');");
					j++;
				}
			}
			System.out.println("FIN REQUETE 3");
			int k=1;
			for(Personne p :listp)
			{
				if(!p.getRoles().isEmpty()) {
					for(RolePersonne rp : p.getRoles())
					{
						statement.execute("INSERT INTO public.\"Role_Structure_Personne\" VALUES("+k+","+rp.getIdRole()+","+rp.getIdStructure()+","+p.getId()+");");
						k++;
					}
				}

			}
			System.out.println("FIN REQUETE 4");

			statement.close();
			con.close();
		} catch (DocumentException | NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void parseComites()
	{

		try {
			File file = new File("C:/GIT/EDUPAIX/BasesXML/Comites.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			System.out.println(root.toString());
			List<Element> elem = root.elements();
			System.out.println("elem: "+elem.size());

			List<Element> autre = new ArrayList<>();
			List<Element> bonne = new ArrayList<>();
			List <Structure_Comites>listsc = new ArrayList<>();

			/*for(Element e: elem)
			{
				if(e.elements().size()<9)
					autre.add(e);
				else
					bonne.add(e);
			}
			System.out.println("autre: "+ autre.size());
			System.out.println("bonne: "+bonne.size());*/



			for(Element e : elem)
			{
				List<Element> attrib = e.elements();
				System.out.println("attrib="+attrib.size());
				Structure_Comites sc = new Structure_Comites();
				sc.setId(Integer.parseInt(attrib.get(0).getText()));

				switch(attrib.get(1).getName())
				{
				case "Région":
					sc.setRegion(attrib.get(1).getText());
					break;
				case "N_x00B0_dép":
					sc.setDepartement(Integer.parseInt(attrib.get(1).getText()));
					break;

				}

				switch(attrib.get(2).getName())
				{
				case "N_x00B0_dép":
					sc.setDepartement(Integer.parseInt(attrib.get(2).getText())); 
					break;
				case "NomComité":
					sc.setNom(attrib.get(2).getText());
					break;
				}

				switch(attrib.get(3).getName())
				{
				case "N_x00B0_catégorie":
					sc.setCategorie(Integer.parseInt(attrib.get(3).getText())); 
					break;
				case "NomComité":
					sc.setNom(attrib.get(3).getText());
					break;
				}

				switch(attrib.get(4).getName())
				{
				case "N_x00B0_catégorie":
					sc.setCategorie(Integer.parseInt(attrib.get(4).getText())); 
					break;
				case "Adresse1":
					sc.setAdresse1(attrib.get(4).getText());
					break;
				case "Adresse2":
					sc.setAdresse2(attrib.get(4).getText());
					break;
				case "CodeP":
					sc.setCodeP(Integer.parseInt(attrib.get(4).getText()));
					break;
				case "Ville":
					sc.setVille(attrib.get(6).getText());
					break;
				case "Téléphone":
					sc.setTelephone(attrib.get(6).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(6).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(6).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(6).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(6).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(6).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;

				}

				switch(attrib.get(5).getName())
				{
				case "Adresse1":
					sc.setAdresse1(attrib.get(5).getText());
					break;
				case "Adresse2":
					sc.setAdresse2(attrib.get(5).getText());
					break;
				case "CodeP":
					sc.setCodeP(Integer.parseInt(attrib.get(5).getText()));
					break;
				case "Ville":
					sc.setVille(attrib.get(5).getText());
					break;
				case "Téléphone":
					sc.setTelephone(attrib.get(5).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(5).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(5).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(5).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(5).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(6).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;

				}

				switch(attrib.get(6).getName())
				{
				case "Adresse2":
					sc.setAdresse2(attrib.get(6).getText());
					break;
				case "CodeP":
					sc.setCodeP(Integer.parseInt(attrib.get(6).getText()));
					break;
				case "Ville":
					sc.setVille(attrib.get(6).getText());
					break;
				case "Téléphone":
					sc.setTelephone(attrib.get(6).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(6).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(6).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(6).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(6).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(6).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				}
				if(attrib.size()==7) {
					listsc.add(sc);				
					continue;}
				switch(attrib.get(7).getName())
				{
				case "CodeP":
					sc.setCodeP(Integer.parseInt(attrib.get(7).getText()));
					break;
				case "Ville":
					sc.setVille(attrib.get(7).getText());
					break;
				case "Téléphone":
					sc.setTelephone(attrib.get(7).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(7).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(7).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(7).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(7).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(7).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(7).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(7).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;

				}
				if(attrib.size()==8) {
					listsc.add(sc);				
					continue;}
				switch(attrib.get(8).getName())
				{
				case "Ville":
					sc.setVille(attrib.get(8).getText());
					break;
				case "Téléphone":
					sc.setTelephone(attrib.get(8).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(8).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(8).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(8).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(8).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(8).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(8).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(8).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 8");
				}
				if(attrib.size()==9) {
					listsc.add(sc);				
					continue;}
				switch(attrib.get(9).getName())
				{				
				case "Téléphone":
					sc.setTelephone(attrib.get(9).getText());
					break;
				case "Mobile":
					sc.setMobile(attrib.get(9).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(9).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(9).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(9).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(9).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(9).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(9).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 9");
				}

				if(attrib.size()==10) {
					listsc.add(sc);
					continue;}
				switch(attrib.get(10).getName())
				{				
				case "Mobile":
					sc.setMobile(attrib.get(10).getText());
					break;
				case "Fax":
					sc.setFax(attrib.get(10).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(10).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(10).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(10).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(10).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(10).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 10");
				}

				if(attrib.size()==11) {
					listsc.add(sc);
					continue;}
				switch(attrib.get(11).getName())
				{				
				case "Fax":
					sc.setFax(attrib.get(11).getText());
					break;
				case "Courriel":
					sc.setCourriel(attrib.get(11).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(11).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(11).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(11).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(11).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 11");
				}

				if(attrib.size()==12) {
					listsc.add(sc);
					continue;}
				switch(attrib.get(12).getName())
				{				

				case "Courriel":
					sc.setCourriel(attrib.get(12).getText());
					break;
				case "Contact":
					sc.setContact(attrib.get(12).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(12).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(12).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(12).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 12");
				}

				if(attrib.size()==13) {
					listsc.add(sc);
					continue;}
				switch(attrib.get(13).getName())
				{				
				case "Contact":
					sc.setContact(attrib.get(13).getText());
					break;
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(13).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(13).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(13).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 13");
				}

				if(attrib.size()==14) {
					listsc.add(sc);
					continue;}
				switch(attrib.get(14).getName())
				{				
				case "Association_x0020_déclarée":
					if(Integer.parseInt(attrib.get(14).getText())==1)
						sc.setDeclaree(true);
					else
						sc.setDeclaree(false);
					break;
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(14).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(14).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 14");
				}

				if(attrib.size()==15)
				{listsc.add(sc);
				continue;}
				switch(attrib.get(15).getName())
				{				
				case "n_x00B0__x0020_de_x0020_déclaration":
					if(Integer.parseInt(attrib.get(15).getText())==1)
						sc.setDeclarationdoc(true);
					else
						sc.setDeclarationdoc(false);
					break;
				case "Actif":
					if(Integer.parseInt(attrib.get(15).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 15");
				}

				if(attrib.size()==16) {
					listsc.add(sc);
					continue;
				}
				switch(attrib.get(16).getName())
				{				
				case "Actif":
					if(Integer.parseInt(attrib.get(16).getText())==1)
						sc.setActif(true);
					else
						sc.setActif(false);
					break;
				default:
					System.out.println("attribut 16");
				}

				listsc.add(sc);
			}

			for(Structure_Comites sc:listsc)
			{
				if(sc.getAdresse1()==null && sc.getAdresse2()==null && sc.getCodeP()==0 && sc.getVille()==null)
					sc.setNiveau(2);
				else
					sc.setNiveau(1);
			}

			System.out.println(listsc.size());
			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();
			List<Structure_Comites> aretravailler = new ArrayList<>();
			for (Structure_Comites sc : listsc)
			{
				if(sc.getRegion()==null)
					sc.setRegion("");
				if(sc.getMobile()==null)
					sc.setMobile("");
				if(sc.getAdresse1()==null)
					sc.setAdresse1("");
				if(sc.getAdresse2()==null)
					sc.setAdresse2("");
				if(sc.getTelephone()==null)
					sc.setTelephone("");
				if(sc.getCourriel()==null)
					sc.setCourriel("");
				if(sc.getContact()==null)
					sc.setContact("");
				if(sc.getVille()==null) {
					sc.setVille("");


				}

				//REMPLACEMENT DES '

				if(sc.getRegion().contains("'"))
					sc.setRegion(sc.getRegion().replace("'", " "));
				if(sc.getAdresse1().contains("'"))
					sc.setAdresse1(sc.getAdresse1().replace("'", " "));
				if(sc.getAdresse2().contains("'"))
					sc.setAdresse2(sc.getAdresse2().replace("'", " "));
				if(sc.getVille().contains("'"))
					sc.setVille(sc.getVille().replace("'", " "));
				if(sc.getContact().contains("'"))
					sc.setContact(sc.getContact().replace("'", " "));
				if(sc.getNom().contains("'"))
					sc.setNom(sc.getNom().replace("'", " "));




				statement.execute( "INSERT INTO public.\"Structure\" VALUES("+sc.getId()+",'"+sc.getNom()+"','"+sc.getAdresse1()+"','"+sc.getAdresse2()+"',"+sc.getCodeP()+",'"+sc.getVille()+"',"+sc.getNiveau()+",'"+sc.getMobile()+"','"+sc.getTelephone()+"','"+sc.getCourriel()+"','"+sc.getContact()+"',"+sc.getDepartement()+",'"+sc.getRegion()+"',"+sc.isDeclaree()+","+sc.getCategorie()+","+sc.isDeclarationdoc()+","+sc.isActif()+");");
			}
			statement.close();

			Statement st= con.createStatement();
			List<StructureHisto> listsh = new ArrayList<>();
			int i=1;
			for(Structure_Comites sc :listsc)
			{
				StructureHisto sh = new StructureHisto();
				sh.setIdHisto(i);
				sh.setIdStructure(sc.getId());
				sh.setDatepremierecreation( LocalDate.of(9999,1,1));
				if(sc.isActif())
				{
					sh.setDateDisparition(LocalDate.of(9999, 1, 1));
					sh.setDateDerniereCreation(LocalDate.of(9999, 1, 1));
				}
				else
				{
					sh.setDateDisparition(LocalDate.now());
					sh.setDateDerniereCreation(LocalDate.of(9999, 1, 1));
				}
				listsh.add(sh);
				i++;
			}

			for(StructureHisto sh: listsh)
			{
				st.execute("INSERT INTO public.\"StructureHisto\" VALUES("+sh.getIdHisto()+","+sh.getIdStructure()+",'"+sh.getDateDisparition()+"','"+sh.getDateDerniereCreation()+"','"+sh.getDatepremierecreation()+"');");
			}
			System.out.println("sh"+listsh.size());
			st.close();
			con.close();



		} catch (DocumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static void parsePetition()
	{
		try {
			File file = new File("C:/GIT/EDUPAIX/BasesXML/Petitions.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			System.out.println(root.toString());
			List<Element> elem = root.elements();
			System.out.println("elem: "+elem.size());




			List<Element> autre = new ArrayList<>();
			List<Element> bonne = new ArrayList<>();
			List<String> themes = new ArrayList<>();
			for(Element e: elem)
			{

				if(e.elements().size()!=10)
					autre.add(e);
				else
					bonne.add(e);
			}
			System.out.println("autre: "+ autre.size());
			System.out.println("bonne: "+bonne.size());
			List<Petition> peti = new ArrayList<>();
			for(Element e:bonne)
			{

				List<Element> attrib=e.elements();

				Petition p= new Petition();
				p.setId(Integer.parseInt(attrib.get(0).getText()));
				p.setMembre(Integer.parseInt(attrib.get(1).getText()));

				if(attrib.get(2).getText()!="6" && !themes.contains(attrib.get(2).getText()))
					themes.add(attrib.get(2).getText());

				p.setTheme(attrib.get(2).getText());
				LocalDate ldate = LocalDate.of(Integer.parseInt(attrib.get(3).getText()),Month.JANUARY,01);
				p.setDate(ldate);
				if(Integer.parseInt(attrib.get(4).getText())==0)
					p.setMaire(false);
				else
					p.setMaire(true);

				if(Integer.parseInt(attrib.get(5).getText())==0)
					p.setDepute(false);
				else
					p.setDepute(true);

				if(Integer.parseInt(attrib.get(6).getText())==0)
					p.setDeputeeuro(false);
				else
					p.setDeputeeuro(true);

				if(Integer.parseInt(attrib.get(7).getText())==0)
					p.setPresparlement(false);
				else
					p.setPresparlement(true);

				if(Integer.parseInt(attrib.get(8).getText())==0)
					p.setPres(false);
				else
					p.setPres(true);

				if(Integer.parseInt(attrib.get(9).getText())==0)
					p.setInternet(false);
				else
					p.setInternet(true);

				peti.add(p);

			}

			//CONNEXION BDD  ET REQUETE

			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();

			//AJOUT DES THEMES SAUF  CEUX NOTES 6
			int i=1;
			for(String s :themes)
			{
				statement.execute( "INSERT INTO public.\"Theme\"VALUES("+i+","+"'"+s+"'"+");");
				i++;
			}

			for(Petition p :peti)
			{

				ResultSet resultat = statement.executeQuery( "SELECT \"idTheme\" FROM public.\"Theme\" WHERE \"Denomination\"="+"'"+p.getTheme()+"'"+";" );
				int idtheme=0;
				while(resultat.next())
				{
					idtheme= resultat.getInt(1);
				}

				statement.execute( "INSERT INTO public.\"Petition\" VALUES("+p.getId()+","+idtheme+","+p.isMaire()+","+p.isDepute()+","+p.isDeputeeuro()+","+p.isPres()+","+p.isInternet()+","+p.isPresparlement()+","+"'"+p.getDate()+"'"+");");
			}
			statement.close();


		} catch (DocumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
