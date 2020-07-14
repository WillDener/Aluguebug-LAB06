package aluguel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class Aluguel {
	public double insertProject(Integer dataPagamento, double valorAluguel) {
		String urlString = "https://aluguebug.herokuapp.com/calc?dados=";

		String name = "Willian Dener da Silva Pinto";
		
		JSONObject obj = new JSONObject();
		
		obj.put("valor_nominal", Double.toString(valorAluguel));
		obj.put("dia", dataPagamento);
		
		urlString += obj;
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Request-Method", "GET");
			connection.setDoInput(true);
			connection.setDoOutput(false);
			connection.setRequestMethod("GET");
			connection.connect();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuffer response = new StringBuffer(9999999);
			String aux = "";
			
			while ((aux = br.readLine()) != null)
				response.append(aux);

			String json_str = (response.toString()).substring(1, (response.toString()).length() - 1).replace("\\", "");
			
			JSONObject json_response = new JSONObject(json_str);
			
			Double valor = json_response.getDouble("valor_calculado");
			
			br.close();

			System.out.println(name + "\nAPI - https://aluguebug.herokuapp.com/calc?dados=\n" + "valor calculado: R$" + 
					valor + " do dia: "+ dataPagamento);
					
			return valor;
			
		} catch (MalformedURLException ex) {
			System.out.println("String of invalid URL!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error in Connection!");
			ex.printStackTrace();
		}		
		
		return 0.0;
	}

	public static void main(String []args) throws JSONException{
		
		new Aluguel().insertProject(22, 350.0);
	}
}