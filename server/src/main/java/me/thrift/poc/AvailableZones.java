package me.thrift.poc;

import az.AvailableZonesInput;
import az.AvailableZonesNotFound;
import az.AvailableZonesOutput;
import az.AvailableZonesService;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.UUID;

@Slf4j
public class AvailableZones implements AvailableZonesService.Iface {

    @Override
    public AvailableZonesOutput getZones(AvailableZonesInput input) throws AvailableZonesNotFound {
        AvailableZonesOutput zone = new AvailableZonesOutput(
                UUID.randomUUID().toString(),
                Collections.singletonMap(UUID.randomUUID().toString(), 4),
                input.isSriov()
        );

        log.info("Got call: {}", input.toString());

        if (input.getCpus() == 42) throw new AvailableZonesNotFound(404, "(つ･･)つ¤=[]:::::::>");

        log.info("Respond with: {}", zone.toString());
        return zone;
    }
}
