package com.cgz.assignment.domain.model.tester;

import com.cgz.assignment.domain.model.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface TesterRepository extends PagingAndSortingRepository<Tester, Long> {

    @Query(" SELECT t  " +
            "            FROM Tester t  " +
            "            JOIN t.experiences exp  " +
            "    WHERE exp.device.id IN (:devices) AND t.country IN (:countries)  " +
            "    GROUP BY t.id  " +
            "    ORDER BY sum(exp.experiencePoints) DESC ")
    List<Tester> findByDeviceAndCountryOrderByExperience(@Param("devices") List<Long> devices, @Param("countries") List<Country> countries, Pageable pageable);


    @Query(" SELECT t  " +
            "            FROM Tester t  " +
            "            JOIN t.experiences exp  " +
            "    WHERE exp.device.id IN (:devices)  " +
            "    GROUP BY t.id  " +
            "    ORDER BY sum(exp.experiencePoints) DESC ")
    List<Tester> findByDeviceOrderByExperience(List<Long> deviceIds, Pageable pageable);


    @Query(" SELECT t  " +
            "            FROM Tester t  " +
            "            JOIN t.experiences exp  " +
            "    WHERE t.country IN (:countries)  " +
            "    GROUP BY t.id  " +
            "    ORDER BY sum(exp.experiencePoints) DESC ")
    List<Tester> findByCountryOrderByExperience(List<Country> countries, Pageable pageable);


    @Query(" SELECT t  " +
            "            FROM Tester t  " +
            "            JOIN t.experiences exp  " +
            "    GROUP BY t.id  " +
            "    ORDER BY sum(exp.experiencePoints) DESC ")
    List<Tester> findAllOrderByExperience(Pageable pageable);


}
