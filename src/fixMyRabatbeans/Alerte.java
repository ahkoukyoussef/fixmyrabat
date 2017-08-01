package fixMyRabatbeans;

public class Alerte {
	
String Sujet;
String Rue;
String Description;
String Probleme;
String PicUrl;
String Lat;
String Long;



public Alerte(String sujet, String rue, String description, String probleme,
		String picUrl, String lat, String l) {
	super();
	Sujet = sujet;
	Rue = rue;
	Description = description;
	Probleme = probleme;
	PicUrl = picUrl;
	Lat = lat;
	Long = l;
}

public Alerte() {
	// TODO Auto-generated constructor stub
}

public String getSujet() {
	return Sujet;
}
public void setSujet(String sujet) {
	Sujet = sujet;
}
public String getRue() {
	return Rue;
}
public void setRue(String rue) {
	Rue = rue;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getProbleme() {
	return Probleme;
}
public void setProbleme(String probleme) {
	Probleme = probleme;
}
public String getPicUrl() {
	return PicUrl;
}
public void setPicUrl(String picUrl) {
	PicUrl = picUrl;
}
public String getLat() {
	return Lat;
}
public void setLat(String lat) {
	Lat = lat;
}
public String getLong() {
	return Long;
}
public void setLong(String l) {
	Long = l;
}


}
