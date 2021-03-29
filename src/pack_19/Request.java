package pack_19;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

// Se usará la interfaz Callable para devolver el resultado del futuro en el hilo main

public class Request implements Callable<String> {

	private URLConnection connection;
	private String targetURL;

	public Request(String url) {
		this.targetURL = url;
	}

	@Override
	public String call() throws Exception {

		connection = new URL(targetURL).openConnection();

		InputStream is = connection.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuilder result = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			result.append(line);
		}
//		System.out.println(result.toString());

		// Retornamos el resultado de la petición a la url
		return result.toString();
	}

}
