package me.thrift.poc;

import az.AvailableZonesInput;
import az.AvailableZonesOutput;
import az.AvailableZonesService.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class Commands {

    private final Client client;

    @ShellMethod(key = "get", value = "Get available zones")
    public void perform(
            int cpus,
            int ram,
            int disk,
            int vports,
            boolean sriov,
            String location
    ) throws TException {
        AvailableZonesInput input = new AvailableZonesInput(cpus, ram, disk, vports, sriov, location);

        AvailableZonesOutput zones = client.getZones(input);
        log.info("Server respond with: {}", zones.toString());
    }

}
