## Request token
  ```bash
  # 1. Keycloak response
  KC_RESPONSE=$(curl -X POST http://localhost:8180/auth/realms/dev/protocol/openid-connect/token \
  -H 'content-type: application/x-www-form-urlencoded' \
  -d 'grant_type=password&scope=openid' \
  -d 'client_id=car-service&client_secret=b3c2329a-829d-4a9c-923e-eade9f50cffe' \
  -d 'username=dekai&password=qwerty12')

  # 2. Extract access toke
  ACCESS_TOKEN=$(echo $KC_RESPONSE | jq -r .access_token)

  # 3. Use access token in Authorization header
  curl -H "Authorization: Bearer $ACCESS_TOKEN" \
  -H 'content-type: application/json' \
  -d '{"name": "Urus", "type": "Petrol"}' \
  http://localhost:8086/cars/save 
  
  ```