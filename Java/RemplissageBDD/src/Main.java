import java.io.File;
import java.security.KeyStore.Entry.Attribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
				p.setDate(Integer.parseInt(attrib.get(3).getText()));
				if(attrib.get(4).getText()=="0")
					p.setMaire(false);
				else
					p.setMaire(true);

				if(attrib.get(5).getText()=="0")
					p.setDepute(false);
				else
					p.setDepute(true);

				if(attrib.get(6).getText()=="0")
					p.setDeputeeuro(false);
				else
					p.setDeputeeuro(true);

				if(attrib.get(7).getText()=="0")
					p.setPresparlement(false);
				else
					p.setPresparlement(true);

				if(attrib.get(8).getText()=="0")
					p.setPres(false);
				else
					p.setPres(true);

				if(attrib.get(9).getText()=="0")
					p.setInternet(false);
				else
					p.setInternet(true);

				peti.add(p);
			}
			System.out.println("petitions: "+peti.size());

			//CONNEXION BDD  ET REQUETE

			Connection con=DriverManager.getConnection("jdbc:postgresql://148.60.11.198:5432/Edupaixv1","Alexis","postgresmdp");
			Statement statement = con.createStatement();
			System.out.println(peti.get(0).getTheme());

			statement.execute( "INSERT INTO public.\"Theme\"VALUES(1,"+"'"+peti.get(0).getTheme()+"'"+");");
			//int statut = statement.executeUpdate( "INSERT INTO Petition VALUES("+peti.get(0).getId()+","+peti.get(0).getId()+",1,"+peti.get(0).getDate()+","+peti.get(0).isMaire()+","+peti.get(0).isDepute()+","+peti.get(0).isDeputeeuro()+","+peti.get(0).isPres()+","+peti.get(0).isInternet()+","+peti.get(0).isPresparlement()+");");
			statement.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
