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
			
			for(Element e: elem)
			{
				if(e.elements().size()<9)
					autre.add(e);
				else
					bonne.add(e);
			}
			System.out.println("autre: "+ autre.size());
			System.out.println("bonne: "+bonne.size());
			
			for(Element e:bonne)
			{

				List<Element> attrib=e.elements();
				Structure_Comites sc = new Structure_Comites();
				sc.setId(Integer.parseInt(attrib.get(0).getText()));
				System.out.println(attrib.get(0).getName());
				
			}
			/*                                      PARTIE PETITION
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

			/*AJOUT DES THEMES SAUF 6
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
			*/
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
