package me.thrift.poc;

import az.AvailableZonesService;
import az.AvailableZonesService.Processor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

@Slf4j
public class Server {
    public static final int PORT = 5050;

    private static AvailableZones availableZones = new AvailableZones();
    private static AvailableZonesService.Processor processor;

    public static void main(String[] args) {
        try {
            processor = new Processor(availableZones);

            log.info("Some info");

            Runnable runnable = () -> start(processor);

            new Thread(runnable).start();
        } catch (Exception e) {
            log.error("Can't start the server :(", e);
        }
    }

    private static void start(Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            log.info("Server started on port: {}", PORT);
            server.serve();
        } catch (Exception e) {
            log.error("Something went wrong :(", e);
        }
    }

}
