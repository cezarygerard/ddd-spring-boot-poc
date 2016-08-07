package com.cgz.assignment.domain.model.device;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

//    private ConcurrentMap<Long, Device> devices = new ConcurrentHashMap<>();
//
//    public Device findOne(Long deviceId) {
//        return devices.get(deviceId);
//    }
//
//    public Iterable<Device> findAll() {
//        return Collections.unmodifiableCollection(devices.values());
//    }
}
