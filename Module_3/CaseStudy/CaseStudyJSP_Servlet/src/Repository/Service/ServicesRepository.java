package Repository.Service;

import Model.Service;

import java.util.List;

public interface ServicesRepository {
    List<Service> findAllService();

    void save(Service service);

    Service findServiceById(String id);

    void update(String id, Service service);

    void remove(String id);

    List<Service> search(String search);

    List<Service> sortService(String sortBy);

}
