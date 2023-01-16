package com.example.oauth2;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.springframework.stereotype.Service;

@Service
public class OAuth2Example {
    public void gete() {
        try {
            // Build the OAuth request
            OAuthClientRequest request = OAuthClientRequest
                    .authorizationLocation("https://accounts.google.com/o/oauth2/auth?access_type=offline")
                    .setClientId("257375467267-d9amq6ras4hq68m36v2hga35rpkfkf8m.apps.googleusercontent.com")
                    .setRedirectURI("http://localhost:8080/Callback")
                    .setResponseType(OAuth.OAUTH_CODE)
                    .setScope("https://www.googleapis.com/auth/spreadsheets")
                    .buildQueryMessage();

            // Redirect the user to the authorization server
            // (in this example, assume this is done by a servlet)
            //response.sendRedirect(request.getLocationUri());

            // When the user grants permission, the authorization server redirects
            // the user back to the redirect URI, with the authorization code in the query string
            // (in this example, assume this is done by a servlet)
            System.out.println(request.getLocationUri());
            String authCode = request.getBody();
            System.out.println(authCode);

            // Exchange the authorization code for an access token
            /*OAuthClientRequest tokenRequest = OAuthClientRequest
                    .tokenLocation("https://oauth_provider/token")
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId("client_id")
                    .setClientSecret("client_secret")
                    .setRedirectURI("http://localhost:8080/callback")
                    .setCode(authCode)
                    .buildBodyMessage();

            // Use the OAuth client to make the request
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            OAuthResourceResponse resourceResponse = oAuthClient.resource(tokenRequest, OAuth.HttpMethod.POST, OAuthResourceResponse.class);

            // Use the access token to make an authenticated request
            OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest("https://oauth_provider/resource")
                    .setAccessToken(resourceResponse.getAccessToken())
                    .buildQueryMessage();
            OAuthResourceResponse userInfoResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);

            System.out.println(userInfoResponse.getBody());*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// https://accounts.google.com/o/oauth2/auth?access_type=offline&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fspreadsheets&response_type=code&redirect_uri=https%3A%2F%2Flocalhost%3A8080%2FCallback&client_id=257375467267-d9amq6ras4hq68m36v2hga35rpkfkf8m.apps.googleusercontent.com
// https://accounts.google.com/o/oauth2/auth?access_type=offline&client_id=257375467267-d9amq6ras4hq68m36v2hga35rpkfkf8m.apps.googleusercontent.com&redirect_uri=http://localhost:5556/Callback&response_type=code&scope=https://www.googleapis.com/auth/spreadsheets