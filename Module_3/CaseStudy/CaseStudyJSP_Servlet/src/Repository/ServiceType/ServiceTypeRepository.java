package Repository.ServiceType;

import Model.ServiceType;

public interface ServiceTypeRepository {
    ServiceType findById(int id);
}
