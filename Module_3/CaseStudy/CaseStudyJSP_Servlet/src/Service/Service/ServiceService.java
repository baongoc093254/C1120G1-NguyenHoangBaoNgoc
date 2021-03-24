package Service.Service;

import java.util.List;

public interface ServiceService {
    List<ServiceService> findAllService();

    void save(ServiceService service);

    ServiceService findServiceById(String id);

    void update(String id, ServiceService service);

    void remove(String id);

    List<ServiceService> search(String search);

    List<ServiceService> sortService(String sortBy);
}
