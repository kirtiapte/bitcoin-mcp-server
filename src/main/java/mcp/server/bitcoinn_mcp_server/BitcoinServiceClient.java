package mcp.server.bitcoinn_mcp_server;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinServiceClient {

    private static final String BASE_URL = "https://api.coingecko.com/api/v3";
    private final RestTemplate restTemplate;


    public BitcoinServiceClient() {
        this.restTemplate = new RestTemplate();
    }
@Tool
public Integer getBitcoinPrice() {
    String url = BASE_URL + "/simple/price?ids=bitcoin&vs_currencies=usd";
    Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    Map<String, Integer> bitcoinData = (Map<String, Integer>) response.get("bitcoin");
    Object priceObject = bitcoinData.get("usd");
    return priceObject != null ? (Integer) priceObject : null;
}
@Tool
public Integer getBitcoinPriceByCurrency(String currency) {
    String url = BASE_URL + "/simple/price?ids=bitcoin&vs_currencies=" + currency;
    Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    Map<String, Integer> bitcoinData = (Map<String, Integer>) response.get("bitcoin");
    return bitcoinData.get(currency.toLowerCase());
}

}
