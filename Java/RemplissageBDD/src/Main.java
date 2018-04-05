import java.io.File;
import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub



	}


	public void parseComites()
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
	
	public void parsePetition()
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
