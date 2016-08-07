package com.cgz.assignment.domain.model.bug;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface BugRepository extends PagingAndSortingRepository<Bug, Long> {

//    AtomicLong nextId = new AtomicLong(1);
//    private ConcurrentMap<Long, Bug> bugs = new ConcurrentHashMap<>();
//
//    public Bug save(Bug bug) {
//        if (bug.getId() == null) {
//            bug.setId(nextId.getAndIncrement());
//        }
//        bugs.put(bug.getId(), bug);
//        return bug;
//    }
//
//    public Iterable<Bug> findAll() {
//        return Collections.unmodifiableCollection(bugs.values());
//    }
}
