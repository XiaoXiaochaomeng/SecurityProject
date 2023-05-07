package com.jwt.JWT.Project.dto;


public class FacebookClientRegistration {

    private static final String CLIENT_ID = "your-client-id";
    private static final String CLIENT_SECRET = "your-client-secret";
    private static final String REDIRECT_URI_TEMPLATE = "{baseUrl}/login/oauth2/code/{registrationId}";

    public static ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("facebook")
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate(REDIRECT_URI_TEMPLATE)
                .scope("email", "public_profile")
                .authorizationUri("https://www.facebook.com/v13.0/dialog/oauth")
                .tokenUri("https://graph.facebook.com/v13.0/oauth/access_token")
                .userInfoUri("https://graph.facebook.com/me")
                .userNameAttributeName("id")
                .clientName("Facebook")
                .build();
    }
}
