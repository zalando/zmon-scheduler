package de.zalando.zmon.scheduler.ng.downtimes;

import de.zalando.zmon.scheduler.ng.SchedulerConfig;
import de.zalando.zmon.scheduler.ng.TokenWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;

/**
 * Created by jmussler on 18.06.16.
 */
@Configuration
public class DowntimeConfiguration {

    public static Logger LOG = LoggerFactory.getLogger(DowntimeConfiguration.class);

    @Bean
    DowntimeHttpSubscriber downtimeHttpSubscriber(DowntimeService downtimeService, SchedulerConfig config, TokenWrapper tokenWrapper, ClientHttpRequestFactory httpClientFactory) {
        if (config.downtime_http_url() != null) {
            LOG.info("Registering DowntimeHttpSubscriber");
            return new DowntimeHttpSubscriber(downtimeService, config, tokenWrapper, httpClientFactory);
        }
        return null;
    }
}