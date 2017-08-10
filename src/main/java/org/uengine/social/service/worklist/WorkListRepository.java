package org.uengine.social.service.worklist;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.uengine.social.common.repository.PersistentRepository;

import java.util.List;

/**
 * Created by uengine on 2017. 6. 19..
 */
@RepositoryRestResource(collectionResourceRel = "worklist", path = "worklist")
public interface WorkListRepository extends PersistentRepository<WorkList, Long> {

    //@Query("select wl from WorkList wl where wl.instId = ?#{loggedUserId})")
    @Query(value = "select * from BPM_WORKLIST where instId = ?1",
            nativeQuery = true)
    public List<WorkList> findByInstId(@Param("instId") Long instId);
}

