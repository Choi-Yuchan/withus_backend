//package withus.ex.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientRegistration.Builder;
//
//@Configuration
//public class OAuth2Config {
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(clientRegistration());
//    }
//
//    private ClientRegistration clientRegistration() {
//        return ClientRegistration.withRegistrationId("google")
//            .clientId("b51fd5c596862618928e5e18d56ab31c")
//            .clientSecret("Itljs2QRvvnBbvznfB3JggeOSj0HXDXT")
//            .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
//            .scope("openid", "profile", "email")
//            .authorizationUri("https://accounts.kakao.com/o/oauth2/auth")
//            .tokenUri("https://accounts.google.com/o/oauth2/token")
//            .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//            .userNameAttributeName(IdTokenClaimNames.SUB)
//            .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
//            .clientName("Kakao")
//            .build();
//    }
//}
