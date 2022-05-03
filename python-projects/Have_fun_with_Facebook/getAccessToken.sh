#!/bin/bash
source credentialToken.sh
curl -X GET "https://graph.facebook.com/v2.7/oauth/access_token?client_id=$id&client_secret=$secret&grant_type=client_credentials" > secret.json
