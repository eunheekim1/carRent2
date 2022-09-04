package carrent.infra;

import carrent.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "totalCarLists",
    path = "totalCarLists"
)
public interface TotalCarListRepository
    extends PagingAndSortingRepository<TotalCarList, Long> {
    // keep

}
