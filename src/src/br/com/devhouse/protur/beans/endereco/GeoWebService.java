package br.com.devhouse.protur.beans.endereco;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class GeoWebService {
	
	private final int connectTimeOut = 10000;
	private final int readTimeout = 120000;
	private final String geoNamesServer = "http://api.geonames.org";
	private final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.30 (KHTML, like Gecko) Chrome/12.0.742.100 Safari/534.30";
	private final String user = "speeddemon";
	private final String lingua = "pt";
	
	private InputStream connect(String url){
		url = this.geoNamesServer + url;
		url += "&username=" + this.user;
		url += "&lang=" + this.lingua;
		URLConnection conn = null;
		try {
			conn = new URL(url).openConnection();
			conn.setConnectTimeout(this.connectTimeOut);
			conn.setReadTimeout(this.readTimeout);
			conn.setRequestProperty("User-Agent", this.userAgent);
			return conn.getInputStream();
		} catch (MalformedURLException e) {
			System.out.println("URL mal formada. " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro de I/O. " + e.getMessage());
		}
		return null;
	}
	
	public List<Pais> getPaises(){
		
		String url = "/countryInfo?";
		InputStream in = this.connect(url);
		SAXBuilder parser = new SAXBuilder();
		Document doc = null;
		
		try {
			doc = parser.build(in);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		
		
		List<Pais> paises = new ArrayList<Pais>();
		for (Object obj : root.getChildren("country")) {
			Element el = (Element) obj;
			Pais pais = new Pais(el.getChildText("countryName"));
			pais.setCodigo(el.getChildText("countryCode"));
			pais.setContinente(el.getChildText("continent"));
			pais.setGeonameId(el.getChildText("geonameId"));
			pais.setIsoAlpha(el.getChildText("isoAlpha3"));
			pais.setIsoNumeric(el.getChildText("isoNumeric"));
			pais.setMoeda(el.getChildText("currencyCode"));
			paises.add(pais);
		}
		return paises;
	}
	
	public List<Estado> getEstados(String paisGeoId){
		
		String url = "/children?geonameId=" + paisGeoId;
		InputStream in = this.connect(url);
		SAXBuilder parser = new SAXBuilder();
		Document doc = null;
		
		try {
			doc = parser.build(in);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		
		
		List<Estado> estados = new ArrayList<Estado>();
		for (Object obj : root.getChildren("geoname")) {
			Element el = (Element) obj;
			Estado estado = new Estado(el.getChildText("name"));
			estado.setCodigoPais(el.getChildText("countryCode"));
			estado.setGeonameId(el.getChildText("geonameId"));
			estado.setNomePais(el.getChildText("countryName"));
			estados.add(estado);
		}
		return estados;
	}
	
	public List<Cidade> getCidades(String estadoGeoId){
		
		String url = "/children?geonameId=" + estadoGeoId;
		InputStream in = this.connect(url);
		SAXBuilder parser = new SAXBuilder();
		Document doc = null;
		
		try {
			doc = parser.build(in);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		
		
		List<Cidade> cidades = new ArrayList<Cidade>();
		for (Object obj : root.getChildren("geoname")) {
			Element el = (Element) obj;
			Cidade cidade = new Cidade(el.getChildText("name"));
			cidade.setCodigoPais(el.getChildText("countryCode"));
			cidade.setGeonameId(el.getChildText("geonameId"));
			cidade.setNomePais(el.getChildText("countryName"));
			cidades.add(cidade);
		}
		return cidades;
	}
}
