import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{
    public static void main(String[] args) {
        String filePath = "inputkeys.json";

          FileReader reader = new FileReader(filePath)
        
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            for (String key : jsonObject.keySet())
            {
                JsonObject data = jsonObject.getAsJsonObject(key);
                int base = data.get("base").getAsInt();
                String value = data.get("value").getAsString();

                try 
                {
                    int decimalValue = Integer.parseInt(value, base);
                    System.out.println("Decimal: " + decimalValue);
                } 
                catch (NumberFormatException e) {
                    System.out.println("Invalid value '" + value + "' for base " + base);
                }
            }
    }
}
