package com.cgz.assignment.domain.model.Tester;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public class TesterRepository {

    private ConcurrentMap<Long, Tester> bugs = new ConcurrentHashMap<>();

    public Tester findOne(Long testerId) {
        return bugs.get(testerId);
    }
}
