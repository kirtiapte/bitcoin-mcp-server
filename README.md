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

## Deploy on to Cloud Foundry
Login to Cloud Foundry instance 
```bash
cf push -f manifest.yml
```
### Binding to MCP Agents
Model Context Protocol (MCP) servers are lightweight programs that expose specific capabilities to AI models through a standardized interface. These servers act as bridges between LLMs and external tools, data sources, or services, allowing your AI application to perform actions like searching databases, accessing files, or calling external APIs without complex custom integrations.

### Create a user-provided service that provides the URL for an existing MCP server:
```
cf cups bitcoin-mcp-server -p '{"mcpServiceURL":"https://your-bitcoin-mcp-server.example.com"}'
```
### Bind the MCP service to your application:
```
cf bind-service ai-tool-chat bitcoin-mcp-server
```
### Restart your application:
```
cf restart ai-tool-chat
```
Your chatbot will now register with the bitcoin MCP agent, and the LLM will be able to invoke the agent's capabilities when responding to chat requests.


