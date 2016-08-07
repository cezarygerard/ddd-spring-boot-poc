package com.cgz.assignment.domain.model.Device;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public class DeviceRepository {

    private ConcurrentMap<Long, Device> bugs = new ConcurrentHashMap<>();

    public Device findOne(Long deviceId) {
        return bugs.get(deviceId);
    }
    //CACHE!!
}
