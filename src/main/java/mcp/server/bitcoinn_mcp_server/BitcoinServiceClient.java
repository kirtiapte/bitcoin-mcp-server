package mcp.server.bitcoinn_mcp_server;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BitcoinServiceClient {

    private static final String BASE_URL = "";
    private final RestClient restClient;


    public BitcoinServiceClient(RestClient.Builder restClientBuilder ) {
        this.restClient = restClientBuilder.baseUrl(BASE_URL).build();
    }

    public double getBitcoinPrice() {
        // TODO: Implement the logic to call the external service and return the Bitcoin price
        return 0.0;
    }

}
