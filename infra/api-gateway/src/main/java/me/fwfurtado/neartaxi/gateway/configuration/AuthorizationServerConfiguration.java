package me.fwfurtado.neartaxi.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService service;
    private final String jwtKeyValue;

    public AuthorizationServerConfiguration(AuthenticationManager authenticationManager, UserDetailsService service, @Value("${security.oauth2.authorization.jwt.key-value}") String jwtKeyValue) {
        this.authenticationManager = authenticationManager;
        this.service = service;
        this.jwtKeyValue = jwtKeyValue;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("frontend")
            .secret("{bcrypt}$2a$10$maBYaPpmAcKkku1Z8Y2nB.3sHNwnR65rQjsEJsnWkkje9f7ft9NFC")
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("trip:all", "trip:read", "trip:write", "car:read", "user:read");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .tokenStore(tokenStore())
            .accessTokenConverter(tokenConverter())
            .userDetailsService(service)
            .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .checkTokenAccess("permitAll()")
            .tokenKeyAccess("isAuthenticated()");
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        var converter = new JwtAccessTokenConverter();

        converter.setSigningKey(jwtKeyValue);

        return converter;
    }
}
