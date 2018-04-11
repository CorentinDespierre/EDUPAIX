import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//parseVille();
		//parseRegion();
		//parseComites();
		parseMembre();
		//parsePetition();
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

			Map<Integer,Contact> map = new HashMap<>();

			int i=1;
			for(Element e: elem)
			{
				Personne p= new Personne();
				p.setId(i);
				Contact cp= new Contact();
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

				statement.execute( "INSERT INTO public.\"Personne\" VALUES("+p.getId()+","+p.getRef()+",'"+p.getTitre()+"','"+p.getNom()+"','"+p.getPrenom()+"','"+p.getMaj()+"','"+p.getAdresse1()+"','"+p.getAdresse2()+"','"+p.getAdresse3()+"',"+p.getCodeP()+",'"+p.getVille()+"',"+p.getDep()+","+p.getDepRattaches()+",'"+p.getDateNaissance()+"','"+p.getLieuNaissance()+"','"+p.getNumPasseport()+"','"+p.getPasseportDelivery()+"','"+p.getPrefecture()+"',"+p.getRefComite()+","+p.isFiche()+","+p.isPetitionnaire()+","+p.isElus()+","+p.isRetour()+","+p.isMairie()+","+p.isBibli()+","+p.isEtranger()+",'"+p.getRemarque()+"');");

			}
			System.out.println("FIN REQUETE 1 PERSONNE");

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
			System.out.println("FIN REQUETE 2 CATEGORIEPERSONNE_PERSONNE_COTISATIONHISTO");

			int j=1;
			for(Map.Entry<Integer, Contact> entry:map.entrySet())
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
			System.out.println("FIN REQUETE 3 TYPECONTACT_PERSONNE");
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
			System.out.println("FIN REQUETE 4 ROLE_STRUCTURE_PERSONNE");

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
			List <Structure_Comites>listsc = new ArrayList<>();
			Map<Integer,Contact> map = new HashMap<>();


			for(Element e : elem)
			{

				List<Element> attrib = e.elements();
				Structure_Comites sc = new Structure_Comites();
				Contact contact= new Contact();

				for(Element f:attrib)
				{
					switch(f.getName())
					{
					case "RéfComité":
						sc.setId(Integer.parseInt(f.getText()));
						break;
					case "Région":
						break;
					case "N_x00B0_dép":
						break;
					case "NomComité":
						sc.setNom(f.getText());
						break;
					case "N_x00B0_catégorie": 
						break;
					case "Adresse1":
						sc.setAdresse1(f.getText());
						break;
					case "Adresse2":
						sc.setAdresse2(f.getText());
						break;
					case "CodeP":
						sc.setcodeP(Integer.parseInt(f.getText()));
						break;

					case "Téléphone":
						contact.setTelDomicile(f.getText());
						break;
					case "Mobile":
						contact.setMobile(f.getText());
						break;
					case "Fax":
						contact.setFaxDomicile(f.getText());
						break;
					case "Courriel":
						contact.setCourriel(f.getText());
						break;
					case "Contact":
						sc.setContact(f.getText());
						break;
					case "Association_x0020_déclarée":
						if(Integer.parseInt(f.getText())==1)
							sc.setDeclaree(true);
						else
							sc.setDeclaree(false);
						break;
					case "n_x00B0__x0020_de_x0020_déclaration":
						if(Integer.parseInt(f.getText())==1)
							sc.setDeclarationdoc(true);
						else
							sc.setDeclarationdoc(false);
						break;
					case "Actif":
						if(Integer.parseInt(f.getText())==1)
							sc.setActif(true);
						else
							sc.setActif(false);
						break;
					case "Ville":
						sc.setVille(f.getText());
						break;

					}

				}
				listsc.add(sc);
				map.put(sc.getId(), contact);
			}

			for(Structure_Comites sc:listsc)
			{
				if(sc.getAdresse1()==null && sc.getAdresse2()==null && sc.getcodeP()==0 && sc.getVille()==null)
					sc.setNiveau(2);
				else
					sc.setNiveau(1);
			}

			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();

			for (Structure_Comites sc : listsc)
			{
				if(sc.getAdresse1()==null)
					sc.setAdresse1("");
				if(sc.getAdresse2()==null)
					sc.setAdresse2("");
				if(sc.getContact()==null)
					sc.setContact("");
				if(sc.getVille()==null) {
					sc.setVille("");


				}

				//REMPLACEMENT DES '

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



				statement.execute( "INSERT INTO public.\"Structure\" VALUES("+sc.getId()+",'"+sc.getNom()+"','"+sc.getAdresse1()+"','"+sc.getAdresse2()+"',"+sc.getNiveau()+","+sc.isDeclaree()+","+sc.isDeclarationdoc()+","+sc.isActif()+",'"+sc.getSiret()+"','"+sc.getRna()+"','"+sc.getContact()+"',false,'9999-01-01');");
			}

			System.out.println("FIN REQUETE STRUCTURE");

			int k=1;
			for(Structure_Comites sc : listsc)
			{
				statement.execute( "INSERT INTO public.\"NatureStructure_Structure\" VALUES("+k+",1,"+sc.getId()+");");
				k++;
			}
			System.out.println("FIN REQUETE NATURESTRUCTURE_STRUCTURE");

			int z=1;
			for(Structure_Comites sc : listsc)
			{
				
				
				ResultSet set= statement.executeQuery("SELECT \"idCommune\" FROM public.\"Commune\" WHERE \"codeP\"="+sc.getCodeP()+";");
				int id=0;
				while(set.next())
				{
					id=set.getInt(1);
				}
				if(id==0)
					continue;
					
				statement.execute( "INSERT INTO public.\"Structure_Commune\" VALUES("+z+","+sc.getId()+","+id+");");
				z++;
			}

			System.out.println("FIN REQUETE STRUCTURE_Commune");
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
				st.execute("INSERT INTO public.\"StructureHisto\" VALUES("+sh.getIdHisto()+",'"+sh.getDateDisparition()+"','"+sh.getDateDerniereCreation()+"','"+sh.getDatepremierecreation()+"',"+sh.getIdStructure()+");");
			}

			System.out.println("FIN REQUETE STRUCTUREHISTO");
			int j=1;
			for(Map.Entry<Integer, Contact> entry:map.entrySet())
			{

				if(entry.getValue().getTelDomicile()!=null) {
					st.execute("INSERT INTO public.\"Structure_TypeContact\" VALUES("+j+","+entry.getKey()+",2,'"+entry.getValue().getTelDomicile()+"');");
					j++;
				}

				if(entry.getValue().getMobile()!=null) {
					st.execute("INSERT INTO public.\"Structure_TypeContact\" VALUES("+j+","+entry.getKey()+",4,'"+entry.getValue().getMobile()+"');");
					j++;
				}

				if(entry.getValue().getFaxDomicile()!=null) {
					st.execute("INSERT INTO public.\"Structure_TypeContact\" VALUES("+j+","+entry.getKey()+",6,'"+entry.getValue().getFaxDomicile()+"');");
					j++;
				}
				if(entry.getValue().getCourriel()!=null) {
					st.execute("INSERT INTO public.\"Structure_TypeContact\" VALUES("+j+","+entry.getKey()+",7,'"+entry.getValue().getCourriel()+"');");
					j++;
				}
			}
			System.out.println("FIN REQUETE  STRUCTURE_TYPECONTACT");

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

			for(Petition p :peti)
			{

				statement.execute( "INSERT INTO public.\"Petition\" VALUES("+p.getId()+",'"+p.getTheme()+"','"+p.getDate()+"',"+p.isMaire()+","+p.isDepute()+","+p.isDeputeeuro()+","+p.isPres()+","+p.isInternet()+","+p.isPresparlement()+");");
			}
			System.out.println("FIN REQUETE PETITION");
			statement.close();
			con.close();

		} catch (DocumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//MARCHE POUR DEPARTEMENTS ET REGION
	public static void parseRegion()
	{
		try {
			File file = new File("C:/GIT/EDUPAIX/BasesXML/region.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			System.out.println(root.toString());
			List<Element> elem = root.elements();
			System.out.println("elem: "+elem.size());

			List<Region> reg= new ArrayList<>();
			for(Element e:elem)
			{
				Region r= new Region();
				List<Element> attrib=e.elements();
				for(Element f:attrib)
				{

					switch (f.getName())
					{
					case "REGION":
						r.setId(1000+Integer.parseInt(f.getText()));
						break;
					case "NCCENR":
						r.setNom(f.getText());
						break;
					}

				}
				reg.add(r);
			}

			//CONNEXION BDD  ET REQUETE

			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();

			for(Region re: reg)
			{

				if(re.getNom().contains("'"))
					re.setNom(re.getNom().replace("'", " "));
				statement.execute( "INSERT INTO public.\"ZoneGeographique\" VALUES("+re.getId()+",'"+re.getNom()+"');");
			}
			System.out.println("FIN REQUETE REGION");
			statement.close();
			con.close();

		} catch (DocumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void parseVille()
	{
		String csvFile = "C:/GIT/EDUPAIX/BasesXML/insee.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();
			int i=1;
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);
				if(country[2].equals("CODE POSTAL"))
					continue;

				System.out.println("Country [code= " + country[1] + " , name=" + country[2] + "]");

				statement.execute( "INSERT INTO public.\"Commune\" VALUES("+i+",'"+country[1]+"',0,"+country[2]+");");
				i++;
			}
			System.out.println("FIN REQUETE VILLE");
			statement.close();
			con.close();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}


	}
}
