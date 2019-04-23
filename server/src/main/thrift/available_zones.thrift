namespace java az

struct AvailableZonesInput {
    1: i32 cpus,
    2: i32 ram,
    3: i32 disk,
    4: i32 vports,
    5: bool sriov,
    6: string location
}

struct AvailableZonesOutput {
    1: string compute,
    2: map<string, i32> physical_network_map,
    3: bool sriov
}

exception AvailableZonesNotFound {
    1: i32 error_code = 404,
    2: string message
}

service AvailableZonesService {
    AvailableZonesOutput getZones(1: AvailableZonesInput input) throws (1: AvailableZonesNotFound ex)
}
