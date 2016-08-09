package com.cgz.assignment.domain.dto.tester;

import com.cgz.assignment.domain.model.device.Device;
import com.cgz.assignment.domain.model.tester.Tester;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by czarek on 08.08.16.
 */
@Component
public class TesterDtoFactory {

    public TesterDto getDto(Tester tester) {
        TesterDto dto = new TesterDto();
        dto.setFirstName(tester.getFirstName());
        dto.setLastName(tester.getLastName());
        dto.setCountry(tester.getCountry().name());
        dto.setTesterId(tester.getId());
        dto.setDevices(mapDevices(tester.getAllDevices()));
        return dto;
    }

    private Set<DeviceDto> mapDevices(Set<Device> allDevices) {
        return allDevices.stream().map(this::mapSingleDevice).collect(Collectors.toSet());
    }

    private DeviceDto mapSingleDevice(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setDeviceDescription(device.getDescription());
        dto.setDeviceId(device.getId());
        return dto;
    }

}
