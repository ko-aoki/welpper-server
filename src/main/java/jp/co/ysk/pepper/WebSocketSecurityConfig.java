package jp.co.ysk.pepper;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

/**
 * Created by ko-aoki on 2016/05/09.
 */
@Configuration
public class WebSocketSecurityConfig extends
        AbstractSecurityWebSocketMessageBrokerConfigurer {

    protected void configureInbound(MessageSecurityMetadataSourceRegistry
                                            messages) {
        messages // 向先指定の上、全て許可
                .simpDestMatchers("/endpoint/**").permitAll() //
                .simpDestMatchers("/app/**").permitAll() //
                .simpSubscribeDestMatchers("/topic/**").permitAll();
    }

    // e.g. http://docs.spring.io/spring-security/site/docs/current/reference/html/websocket.html
    // 20.4.4
    // CSRFの無効化
    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}
