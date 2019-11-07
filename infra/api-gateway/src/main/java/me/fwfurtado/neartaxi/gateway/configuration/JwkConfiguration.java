package me.fwfurtado.neartaxi.gateway.configuration;

import java.security.KeyPair;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class JwkConfiguration {

    @Bean
    public JwtTokenStore tokenStore(JwtAccessTokenConverter accessTokenConverter) {
        return new JwtTokenStore(accessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter tokenConverter(KeyPair keyPair) {
        var converter = new JwtAccessTokenConverter();

        converter.setKeyPair(keyPair);

        return converter;
    }

    @Bean
    Jwt jwt(AuthorizationServerProperties properties) {
        return properties.getJwt();
    }

    @Bean
    AuthorizationServerProperties authorizationServerProperties() {
        return new AuthorizationServerProperties();
    }

    @Bean
    KeyPair keyPair(Jwt jwt) {

        var keyStore = new ClassPathResource(jwt.getKeyStore());

        var keyFactory = new KeyStoreKeyFactory(keyStore, jwt.getKeyStorePassword().toCharArray());

        return keyFactory.getKeyPair(jwt.getKeyAlias());
    }

}
