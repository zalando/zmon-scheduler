package de.zalando.zmon.scheduler.ng.checks;

import com.codahale.metrics.MetricRegistry;
import de.zalando.zmon.scheduler.ng.*;
import de.zalando.zmon.scheduler.ng.config.SchedulerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jmussler on 4/2/15.
 */
@Component
public class CheckSourceRegistry extends SourceRegistry<CheckSource> {

    public CheckSourceRegistry(MetricRegistry metrics) {

    }

    @Autowired
    public CheckSourceRegistry(SchedulerConfig config, final TokenWrapper tokens, RestTemplate restTemplate) {
        final String url = config.getControllerUrl() + "/api/v1/checks/all-active-check-definitions";
        final DefaultCheckSource source = new DefaultCheckSource("check-source", url, restTemplate);
        register(source);
    }

}
