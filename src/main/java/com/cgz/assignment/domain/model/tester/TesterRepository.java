package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.Country;
import com.cgz.assignment.domain.model.device.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface TesterRepository extends PagingAndSortingRepository<Tester, Long> {

    List<Tester> findByCountryAndExperiencesDeviceOrderByExperiencesExperiencePointsDesc(Country country, Device device);
}
