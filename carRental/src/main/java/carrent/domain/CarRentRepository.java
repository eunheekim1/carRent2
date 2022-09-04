package carrent.domain;

import carrent.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "carRents", path = "carRents")
public interface CarRentRepository
    extends PagingAndSortingRepository<CarRent, Long> {}
