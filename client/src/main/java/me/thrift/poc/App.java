package me.thrift.poc;

import az.AvailableZonesService;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public TProtocolFactory protocolFactory() {
        return new Factory();
    }

    @Bean(initMethod = "open", destroyMethod = "close")
    public TTransport transport() {
        return new TSocket("localhost", Server.PORT);
    }

    @Bean
    public AvailableZonesService.Client client(TProtocolFactory protocolFactory, TTransport transport) {
        return new AvailableZonesService.Client(protocolFactory.getProtocol(transport));
    }

}
