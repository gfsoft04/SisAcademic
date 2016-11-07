package br.com.gfsoft.sisacademic.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

	private static Connection connection;
	private FileInputStream inputProperties;
	private Properties properties = new Properties();
	private static String url;
	private static String username;
	private static String password;

	public Conexao() {
		try {

			inputProperties = new FileInputStream("properties\\database.properties");
			properties.load(inputProperties);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}

	public static Connection getConnection() {
		
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println("Houve um erro ao conectar com o Banco de Dados.");
			}
		}

		return connection;
	}

}
