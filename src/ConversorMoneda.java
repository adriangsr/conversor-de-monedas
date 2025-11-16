import com.google.gson.Gson;

import java.io.IOException;

public class ConversorMoneda {

    ConsultaConversorMoneda consulta = new ConsultaConversorMoneda();

    public double convertir(String base, String target, double monto) throws IOException, InterruptedException {

        // Obtener JSON de la API
        String json = consulta.obtenerTasa(base,target);

        // Convertir JSON a objeto
        Gson gson = new Gson();
        Moneda datos = gson.fromJson(json, Moneda.class);

        // Calcular conversión
        return monto * datos.conversion_rate();
    }

}
