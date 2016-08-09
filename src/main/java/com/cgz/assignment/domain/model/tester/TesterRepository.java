package com.cgz.assignment.domain.model.tester;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by czarek on 07.08.16.
 */
@Repository
public interface TesterRepository extends PagingAndSortingRepository<Tester, Long> {

    @Query(nativeQuery = true, value =
            "select * from tester t where id in (\n" +
                    "  SELECT tester_id\n" +
                    "  FROM (\n" +
                    "         SELECT\n" +
                    "           tester_id,\n" +
                    "           sum(experience_points)\n" +
                    "         FROM public.tester\n" +
                    "           JOIN public.experience\n" +
                    "             ON public.tester.id = public.experience.tester_id\n" +
                    "         WHERE device_id IN (?1) AND country IN (?2)\n" +
                    "         GROUP BY tester_id\n" +
                    "         ORDER BY sum DESC\n" +
                    "       ) AS inner_TABLE\n" +
                    ")"
    )
    List<Tester> findByDeviceAndCountryOrderByExperience(List<Long> deviceIds, List<String> countries);

    @Query(nativeQuery = true, value =
            "select * from tester t where id in (\n" +
                    "  SELECT tester_id\n" +
                    "  FROM (\n" +
                    "         SELECT\n" +
                    "           tester_id,\n" +
                    "           sum(experience_points)\n" +
                    "         FROM public.tester\n" +
                    "           JOIN public.experience\n" +
                    "             ON public.tester.id = public.experience.tester_id\n" +
                    "         WHERE device_id IN (?1)\n" +
                    "         GROUP BY tester_id\n" +
                    "         ORDER BY sum DESC\n" +
                    "       ) AS inner_TABLE\n" +
                    ")"
    )
    List<Tester> findByDeviceOrderByExperience(List<Long> deviceIds);

    @Query(nativeQuery = true, value =
            "select * from tester t where id in (\n" +
                    "  SELECT tester_id\n" +
                    "  FROM (\n" +
                    "         SELECT\n" +
                    "           tester_id,\n" +
                    "           sum(experience_points)\n" +
                    "         FROM public.tester\n" +
                    "           JOIN public.experience\n" +
                    "             ON public.tester.id = public.experience.tester_id\n" +
                    "         WHERE AND country IN (?1)\n" +
                    "         GROUP BY tester_id\n" +
                    "         ORDER BY sum DESC\n" +
                    "       ) AS inner_TABLE\n" +
                    ")"
    )
    List<Tester> findByCountryOrderByExperience(List<String> countries);


    @Query(nativeQuery = true, value =
            "select * from tester t where id in (\n" +
                    "  SELECT tester_id\n" +
                    "  FROM (\n" +
                    "         SELECT\n" +
                    "           tester_id,\n" +
                    "           sum(experience_points)\n" +
                    "         FROM public.tester\n" +
                    "           JOIN public.experience\n" +
                    "             ON public.tester.id = public.experience.tester_id\n" +
                    "         GROUP BY tester_id\n" +
                    "         ORDER BY sum DESC\n" +
                    "       ) AS inner_TABLE\n" +
                    ")"
    )
    List<Tester> findAllOrderByExperience();


}
