package com.cgz.assignment.domain.model.bug;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface BugRepository extends PagingAndSortingRepository<Bug, Long> {

}
