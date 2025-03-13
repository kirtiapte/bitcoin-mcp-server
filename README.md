# Bitcoin Model Context Protocol Server
This MCP Server provides an LLM interface for tracking Bitcoin prices using CoinGecko APIs (api.coingecko.com/api/v3). It was built with the [Spring AI MCP](https://docs.spring.io/spring-ai-mcp/reference/spring-mcp.html) project.

![Sample](images/sample.png)

## Building the Server

```bash
./mvnw clean package
```
## Building the Server

```bash
./mvnw test
```

## Configuration

You will need to supply a configuration for the server for your MCP Client. Here's what the configuration looks like for [claude_desktop_config.json](https://modelcontextprotocol.io/quickstart/user):

```
{
  "mcpServers": {
     "bitcoin-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "/path/to/bitcoinn-mcp-server/target/bitcoinn-mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    },
}
```
