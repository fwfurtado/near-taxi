package me.fwfurtado.neartaxi.gateway.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
@Import(AuthorizationServerSecurityConfiguration.class)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService service;
    private final JwtAccessTokenConverter tokenConverter;
    private final JwtTokenStore tokenStore;

    public AuthorizationServerConfiguration(AuthenticationManager authenticationManager, UserDetailsService service, JwtAccessTokenConverter tokenConverter, JwtTokenStore tokenStore) {
        this.authenticationManager = authenticationManager;
        this.service = service;
        this.tokenConverter = tokenConverter;
        this.tokenStore = tokenStore;
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
            .tokenStore(tokenStore)
            .accessTokenConverter(tokenConverter)
            .userDetailsService(service)
            .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .checkTokenAccess("permitAll()")
            .tokenKeyAccess("isAuthenticated()");
    }

}
