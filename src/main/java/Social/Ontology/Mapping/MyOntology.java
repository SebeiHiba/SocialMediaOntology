package Social.Ontology.Mapping;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.XSD;

public class MyOntology {

	public static void main(String[] args) {

		// Create an empty ontology model
		OntModel ontModel = ModelFactory
				.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		String ns = new String("http://www.socialmedia.com/myOntology#");
		String baseURI = new String("http://www.socialmedia.com/myOntology");
		Ontology onto = ontModel.createOntology(baseURI);

		// create classes
		// create publication and subclass
		// use existing property of the ontology to complete the construction of
		// the new ontology
		// Import SIOC ontology
		String SIOC = "http://rdfs.org/sioc/ns#";
		ontModel.setNsPrefix("sioc", SIOC);
		OntClass Publication = ontModel.createClass(SIOC + "Post");
		OntClass Publication_Type = ontModel.createClass(ns
				+ "Publication_Type");
		// Import Review ontology
		String rev = "http://purl.org/stuff/rev#";
		ontModel.setNsPrefix("REV", rev);
		String foaf = FOAF.NAMESPACE.getNameSpace();
		ontModel.setNsPrefix("foaf", foaf);
		OntClass Text = ontModel.createClass(rev + "Text");
		OntClass Image = ontModel.createClass(foaf + FOAF.Image.toString());
		OntClass Video = ontModel.createClass(ns + "Video");
		OntClass Audio = ontModel.createClass(ns + "Audio");
		Publication_Type.addSubClass(Text);
		Publication_Type.addSubClass(Video);
		Publication_Type.addSubClass(Image);
		Publication_Type.addSubClass(Audio);

		// create Actor and subclass of Actor
		// Integrate SIOC and FOAF ontology
		OntClass Actor = ontModel.createClass(SIOC + "Actor");
		OntClass Person = ontModel.createClass(foaf + FOAF.Person.toString());
		OntClass Page = ontModel.createClass(foaf + FOAF.page.toString());
		OntClass Group = ontModel.createClass(foaf + FOAF.Group.toString());
		OntClass Event = ontModel.createClass(ns + "Event");

		Page.addSuperClass(Actor);
		Person.addSuperClass(Actor);
		Group.addSuperClass(Actor);
		Event.addSuperClass(Actor);

		// create Popularity class for publication
		OntClass Popularity_Metrics = ontModel.createClass(ns
				+ "Popularity_Metrics");
		OntClass Contextual_Metrics = ontModel.createClass(ns
				+ "Contextual_Metrics");
		OntClass Content_Metrics = ontModel.createClass(ns + "Content_Metrics");

		OntClass Video_Content = ontModel.createClass(ns + "Video_Content");
		OntClass Image_Content = ontModel.createClass(ns + "Image_Content");
		OntClass Audio_Content = ontModel.createClass(ns + "Audio_Content");
		OntClass Text_Content = ontModel.createClass(ns + "Text_Content");

		OntClass Publication_Metadata = ontModel.createClass(ns
				+ "Publication_Metadata");
		OntClass FeedBack_Metadata = ontModel.createClass(ns
				+ "FeedBack_Metadata");
		OntClass Metadata_After_Uplaod = ontModel.createClass(ns
				+ "Metadata_After_Uplaod");
		OntClass Metadata_Before_Uplaod = ontModel.createClass(ns
				+ "Metadata_Before_Uplaod");
		OntClass Implicit_FeedBack = ontModel.createClass(ns
				+ " Implicit_FeedBack");
		OntClass Explicit_FeedBack = ontModel.createClass(ns
				+ "Explicit_FeedBack");

		// create Popularity class for actor
		OntClass Actor_Popularity = ontModel.createClass(ns
				+ "Actor_Popularity");
		OntClass Actor_Metadata = ontModel.createClass(ns + "Actor_Metadata");
		OntClass Actor_Activity = ontModel.createClass(ns + "Actor_Activity");
		OntClass Actor_Connectivity = ontModel.createClass(ns
				+ "Actor_Connectivity");

		// Create source class (social media source of publication)
		OntClass Source = ontModel.createClass(ns + "Source");
		// integrate RDF Review Vocabulary
		OntClass Replay = ontModel.createClass(rev + "Comment");
		//Create classes location and time use  geonames and time ontologies
		String geo= "http://www.geonames.org/ontology#";
		ontModel.setNsPrefix("geo", geo);
		OntClass Location= ontModel.createClass(geo + "location");
		String time =   "http://www.w3.org/2006/time#";
		ontModel.setNsPrefix("time", time);
		OntClass Time= ontModel.createClass(geo + "time");

		
	

		// Create Publication DataTypes
		DatatypeProperty id= ontModel.createDatatypeProperty(ns + "identifier");
		// 'hasAge' takes integer values, so its range is 'integer'
		// Basic datatypes are defined in the ‘vocabulary’ package
		id.setDomain(Publication);
		id.setRange(XSD.xstring); // com.hp.hpl.jena.vocabulary.XSD
		
				
				DatatypeProperty topic= ontModel.createDatatypeProperty(ns + "topic");
				// 'hasAge' takes integer values, so its range is 'integer'
				// Basic datatypes are defined in the ‘vocabulary’ package
				id.setDomain(Publication);
				id.setRange(XSD.xstring); // com.hp.hpl.jena.vocabulary.XSD

				DatatypeProperty language= ontModel.createDatatypeProperty(ns + "language");
				// 'hasAge' takes integer values, so its range is 'integer'
				// Basic datatypes are defined in the ‘vocabulary’ package
				id.setDomain(Publication);
				id.setRange(XSD.language); // com.hp.hpl.jena.vocabulary.XSD
				
			//	Create Actor DataTypes
				DatatypeProperty actor_id= ontModel.createDatatypeProperty(ns + "actor_id");
				actor_id.setDomain(Actor);
				actor_id.setRange(XSD.xstring);
				
				DatatypeProperty birthday= ontModel.createDatatypeProperty(foaf + FOAF.birthday);
				birthday.setDomain(Person);
				birthday.setRange(XSD.dateTime);
				DatatypeProperty family_Name= ontModel.createDatatypeProperty(foaf + FOAF.family_name);
				birthday.setDomain(Person);
				birthday.setRange(XSD.xstring);
				DatatypeProperty first_Name= ontModel.createDatatypeProperty(foaf + FOAF.firstName);
				birthday.setDomain(Person);
				birthday.setRange(XSD.xstring);
				
				DatatypeProperty gender= ontModel.createDatatypeProperty(foaf + FOAF.gender);
				birthday.setDomain(Person);
				birthday.setRange(XSD.xstring);
				
				
				DatatypeProperty phone= ontModel.createDatatypeProperty(foaf + FOAF.phone);
				birthday.setDomain(Actor);
				birthday.setRange(XSD.xstring);

				DatatypeProperty topic_interest= ontModel.createDatatypeProperty(foaf + FOAF.topic_interest);
				birthday.setDomain(Person);
				birthday.setRange(XSD.xstring);
				DatatypeProperty interest= ontModel.createDatatypeProperty(foaf + FOAF.interest);
				birthday.setDomain(Actor);
				birthday.setRange(XSD.xstring);
				DatatypeProperty accountName= ontModel.createDatatypeProperty(foaf + FOAF.accountName);
				birthday.setDomain(Actor);
				birthday.setRange(XSD.xstring);
	

		// write the model in Turtle
		ontModel.write(System.out, "RDF/XML-ABBREV");
		// return ontModel;

	}

}
