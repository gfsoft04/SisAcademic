package br.com.gfsoft.sisacademic.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.gfsoft.sisacademic.model.Endereco;

public class BuscaCep {
	
	private Endereco endereco;
	private JSONObject jsonObjeto;
	private JSONParser parser;
	private URL url;
	private Reader reader;
	
	public Endereco getEndereco(String cep){
		parser = new JSONParser();
		endereco = new Endereco();
		try {
			url = new URL("http://api.postmon.com.br/v1/cep/" + cep);
			reader = new InputStreamReader(url.openStream());
			jsonObjeto = (JSONObject) parser.parse(reader);
			
			endereco.setLogradouro((String) jsonObjeto.get("logradouro"));
			endereco.setBairro((String) jsonObjeto.get("bairro"));
			endereco.setCidade((String) jsonObjeto.get("cidade"));
			endereco.setEstado((String) jsonObjeto.get("estado"));
			
			return endereco;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Url mal formatada!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "CEP Não Localizado!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("ParseExcepition");
			e.printStackTrace();
		}
		
		return null;
	}

//	public String getLogradouro(String CEP) throws IOException {
//
//		try {
//
//			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
//			Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
//			for (Element urlEndereco : urlPesquisa) {
//				return urlEndereco.text();
//			}
//
//		} catch (SocketTimeoutException e) {
//			System.out.println(e);
//		} catch (HttpStatusException w) {
//			System.out.println(w);
//		}
//		return "";
//	}
//
//	public String getBairro(String CEP) throws IOException {
//		
//		try {
//
//			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
//			Elements urlPesquisa = doc.select("td:gt(1)");
//			for (Element urlBairro : urlPesquisa) {
//				return urlBairro.text();
//			}
//
//		} catch (SocketTimeoutException e) {
//			System.out.println(e);
//		} catch (HttpStatusException w) {
//			System.out.println(w);
//		}
//		return "";
//	}
//
//	public String getCidade(String CEP) throws IOException {
//		
//		try {
//
//			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
//			Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
//			for (Element urlCidade : urlPesquisa) {
//				return urlCidade.text();
//			}
//
//		} catch (SocketTimeoutException e) {
//			System.out.println(e);
//		} catch (HttpStatusException w) {
//			System.out.println(w);
//		}
//		return "";
//	}
//
//	public String getEstado(String CEP) throws IOException {
//		
//		try {
//
//			Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/" + CEP).timeout(120000).get();
//			Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
//			for (Element urlEstado : urlPesquisa) {
//				return urlEstado.text();
//			}
//
//		} catch (SocketTimeoutException e) {
//			System.out.println(e);
//		} catch (HttpStatusException w) {
//			System.out.println(w);
//		}
//		return "";
//	}
//
//	public String getLatLong(String CEP) throws IOException, ParseException {
//
//		try {
//
//			if (CEP.contains("-")) {
//				Document doc = Jsoup.connect("http://maps.googleapis.com/maps/api/geocode/xml?address=" + CEP
//						+ "&language=pt-BR&sensor=true").timeout(120000).get();
//				Elements lat = doc.select("geometry").select("location").select("lat");
//				Elements lng = doc.select("geometry").select("location").select("lng");
//				for (Element Latitude : lat) {
//					for (Element Longitude : lng) {
//						return Latitude.text() + "," + Longitude.text();
//					}
//
//				}
//			} else {
//
//				StringBuilder cepHif = new StringBuilder(CEP);
//				cepHif.insert(CEP.length() - 3, '-');
//
//				Document doc = Jsoup.connect("http://maps.googleapis.com/maps/api/geocode/xml?address=" + cepHif
//						+ "&language=pt-BR&sensor=true").timeout(120000).get();
//				Elements lat = doc.select("geometry").select("location").select("lat");
//				Elements lng = doc.select("geometry").select("location").select("lng");
//				for (Element Latitude : lat) {
//					for (Element Longitude : lng) {
//						return Latitude.text() + "," + Longitude.text();
//					}
//
//				}
//			}
//
//		} catch (SocketTimeoutException e) {
//
//		} catch (HttpStatusException w) {
//
//		}
//		return "";
//	}

}
