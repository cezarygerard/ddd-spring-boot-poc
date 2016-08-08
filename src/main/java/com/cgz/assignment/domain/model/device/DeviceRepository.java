package com.cgz.assignment.domain.model.device;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

}
