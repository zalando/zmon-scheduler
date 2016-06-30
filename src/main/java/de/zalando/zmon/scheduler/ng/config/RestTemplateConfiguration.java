package de.zalando.zmon.scheduler.ng.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jmussler on 30.06.16.
 */
@Configuration
public class RestTemplateConfiguration {

    private final static ObjectMapper mapper = (new ObjectMapper()).setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientFactory) {
        RestTemplate rt = new RestTemplate(clientFactory);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);

        rt.getMessageConverters().clear();
        rt.getMessageConverters().add(converter);

        return rt;
    }
}