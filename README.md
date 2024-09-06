## Overview
This is a simple Spring Boot API with two endpoints:
- <code>/hello</code>: Returns a greeting message.
- <code>/indo</code>: Returns client and server information.

Access the API at `http://localhost:8080`

## Endpoints
### <code>/hello</code>
**Method:** GET
**Description:** Returns a greeting. If there's no name provided, it returns "Hello World"
**Example Request:** <code>/hello?name=Sanjoob</code>

### <code>/info</code>
**Method:** GET
**Description:** Returns request time, client IP address, server hostname, and request headers
