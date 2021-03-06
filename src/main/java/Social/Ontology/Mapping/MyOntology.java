package Social.Ontology.Mapping;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.XSD;

public class MyOntology {

	public OntModel buildOntology () {

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
		// Create classes location and time use geonames and time ontologies
		String geo = "http://www.geonames.org/ontology#";
		ontModel.setNsPrefix("geo", geo);
		OntClass Location = ontModel.createClass(geo + "location");
		String time = "http://www.w3.org/2006/time#";
		ontModel.setNsPrefix("time", time);
		OntClass created_at = ontModel.createClass(geo + "time");

		// Create Publication DataTypes
		DatatypeProperty has_id = ontModel.createDatatypeProperty(ns
				+ "identifier");
		has_id.setDomain(Publication);
		has_id.setDomain(Actor);
		has_id.setRange(XSD.xstring); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty has_topic = ontModel.createDatatypeProperty(SIOC
				+ "topic");
		has_topic.setDomain(Publication);
		has_topic.setRange(XSD.xstring); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty language = ontModel.createDatatypeProperty(ns
				+ "language");
		language.setDomain(Publication);
		language.setRange(XSD.language); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty has_Popularity = ontModel.createDatatypeProperty(ns
				+ "has_popularity");
		language.setDomain(Publication);
		language.setRange(XSD.ENTITY); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty created_by = ontModel.createDatatypeProperty(ns
				+ "created_by");
		created_by.setDomain(Publication);
		created_by.setRange(Actor); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty from = ontModel.createDatatypeProperty(ns + "from");
		from.setDomain(Publication);
		from.setRange(Source); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty has_Replay = ontModel.createDatatypeProperty(ns
				+ "has_Replay");
		has_Replay.setDomain(Publication);
		has_Replay.setRange(Replay); // com.hp.hpl.jena.vocabulary.XSD

		DatatypeProperty has_Type = ontModel.createDatatypeProperty(ns
				+ "has_Type");
		has_Type.setDomain(Publication);
		has_Type.setRange(Publication_Type); // com.hp.hpl.jena.vocabulary.XSD

		// Create Actor DataTypes
		DatatypeProperty has_birthday = ontModel.createDatatypeProperty(foaf
				+ FOAF.birthday);
		has_birthday.setDomain(Person);
		has_birthday.setRange(XSD.dateTime);
		DatatypeProperty has_family_Name = ontModel.createDatatypeProperty(foaf
				+ FOAF.family_name);
		has_family_Name.setDomain(Person);
		has_family_Name.setRange(XSD.xstring);
		DatatypeProperty has_first_Name = ontModel.createDatatypeProperty(foaf
				+ FOAF.firstName);
		has_first_Name.setDomain(Person);
		has_first_Name.setRange(XSD.xstring);

		DatatypeProperty has_gender = ontModel.createDatatypeProperty(foaf
				+ FOAF.gender);
		has_gender.setDomain(Person);
		has_gender.setRange(XSD.xstring);

		DatatypeProperty phone = ontModel.createDatatypeProperty(foaf
				+ FOAF.phone);
		phone.setDomain(Actor);
		phone.setRange(XSD.xstring);

		DatatypeProperty topic_interest = ontModel.createDatatypeProperty(foaf
				+ FOAF.topic_interest);
		topic_interest.setDomain(Person);
		topic_interest.setRange(XSD.xstring);
		DatatypeProperty interest_in = ontModel.createDatatypeProperty(foaf
				+ FOAF.interest);
		interest_in.setDomain(Actor);
		interest_in.setRange(XSD.xstring);
		DatatypeProperty has_accountName = ontModel.createDatatypeProperty(foaf
				+ FOAF.accountName);
		has_accountName.setDomain(Actor);
		has_accountName.setRange(XSD.xstring);

		DatatypeProperty knows = ontModel.createDatatypeProperty(foaf
				+ FOAF.knows);
		knows.setDomain(Person);
		knows.setRange(Person);

		DatatypeProperty member_of = ontModel.createDatatypeProperty(foaf
				+ FOAF.member);
		member_of.setDomain(Person);
		member_of.setRange(Group);

		// write the model in Turtle
		ontModel.write(System.out, "RDF/XML-ABBREV");
		
		return ontModel;

	}

}
