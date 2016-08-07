package com.cgz.assignment.domain.model.tester;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface TesterRepository extends PagingAndSortingRepository<Tester, Long> {

//    private ConcurrentMap<Long, Tester> testers = new ConcurrentHashMap<>();
//
//    public Tester findOne(Long testerId) {
//        return testers.get(testerId);
//    }
//
//    public Tester save(Tester t){
//        testers.put(t.getId(), t);
//        return t;
//    }
//
//    public Iterable<Tester> findByDeviceAndCountryOrderByExperience(long[] devices, String[] countries) {
//       return testers.values();
//    }


}
