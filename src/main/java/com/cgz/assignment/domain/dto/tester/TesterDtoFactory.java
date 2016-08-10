package com.cgz.assignment.domain.dto.tester;

import com.cgz.assignment.domain.model.tester.Experience;
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
        dto.setDevices(mapExperiences(tester.getExperiences()));
        return dto;
    }

    private Set<DeviceExperienceDto> mapExperiences(Set<Experience> allDevices) {
        return allDevices.stream().map(this::mapSingleDeviceExperience).collect(Collectors.toSet());
    }

    private DeviceExperienceDto mapSingleDeviceExperience(Experience experience) {
        DeviceExperienceDto dto = new DeviceExperienceDto();
        dto.setDeviceDescription(experience.getDevice().getDescription());
        dto.setDeviceId(experience.getDevice().getId());
        dto.setExperiencePoints(experience.getExperiencePoints());
        return dto;
    }

}
