# WWIE UI Proxy

## Overview
The `wwie-ui-proxy` is a Spring Boot microservice that acts as a gateway between the frontend and other backend services. It ensures that all backend services remain hidden from direct UI access while managing authentication and request forwarding.

## Features
- Proxies requests from the UI to backend microservices.
- Forwards authentication requests (login/register) to the `wwie-users` service.
- Validates JWT tokens for all protected endpoints.

## Architecture
- The frontend interacts only with `wwie-ui-proxy`.
- Authentication is handled by `wwie-users`.
- Other microservices are secured using JWT authentication.

## Endpoints
### Authentication
- `POST http://localhost:8085/api/v1/auth/login` → Forwards login requests to `wwie-users`.
- `POST http://localhost:8085/api/v1/auth/register` → Forwards registration requests to `wwie-users`.

### Proxying Requests
- All other requests require a valid JWT token and are forwarded to respective backend services.

### Full API Documentation
A full list of all endpoints is available in `/wwie-ui-proxy/wwie-ui-proxy.postman_collection.json`, located in the root folder of the repository. This file can be imported into POSTMAN and used to call the API endpoints.

## Security
- `wwie-ui-proxy` verifies JWT tokens for all endpoints except `http://localhost:8085/api/v1/auth/login` and `http://localhost:8085/api/v1/auth/register`.

## Configuration
- No environment variables are required.
- The application runs at `http://localhost:8085/`.
- The following services must be running and available at their respective ports:
  ```
  app.meals.url=http://localhost:8081/api/v1/
  app.meals-history.url=http://localhost:8082/api/v1
  app.wwie-users.url=http://localhost:8084/api/v1/
  
  # WIP - no need to run this one yet
  app.shopping-lists.url=http://localhost:8083/api/v1
  ```

## Running Locally
1. Clone the repository.
2. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```

## Future Enhancements
- Rate limiting for API requests.
- Logging and monitoring.
- Enhanced error handling for failed requests.

## License
MIT

