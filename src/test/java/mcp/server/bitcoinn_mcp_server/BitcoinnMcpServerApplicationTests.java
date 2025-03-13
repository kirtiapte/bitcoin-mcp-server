package mcp.server.bitcoinn_mcp_server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BitcoinnMcpServerApplicationTests {

    @Autowired
    private BitcoinServiceClient bitcoinServiceClient;

    @Test
    void contextLoads() {
        try {
            Integer bitcoinPrice = bitcoinServiceClient.getBitcoinPrice();
            assertTrue(bitcoinPrice > 0, "Bitcoin price should be greater than zero");
        } catch (Exception e) {
            fail("Exception occurred while fetching Bitcoin price: " + e.getMessage());
        }
    }
}
