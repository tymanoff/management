package ru.codemark.management.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.codemark.management.endpoint.ManagementEndpointImpl;

import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class ManagementConfiguration {

    public static final String SERVLET_MAPPING_URL_PATH = "/managementEndpoint";

    private final ManagementEndpointImpl managementEndpoint;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), managementEndpoint);
        endpoint.publish(SERVLET_MAPPING_URL_PATH);

        return endpoint;
    }
}
