package Repository.Service;

import Model.RentType;
import Model.Service;
import Model.ServiceType;
import Repository.DBConection;
import Service.RentType.RentTypeService;
import Service.RentType.RentTypeServiceImpl;
import Service.ServiceType.ServiceTypeService;
import Service.ServiceType.ServiceTypeServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServicesRepository{
    public static final String INSERT_NEW_SERVICE = "insert into service(service_id,service_name,service_area,service_max_people," +
            "service_cost,rent_type_id,service_type_id,standard_room," +
            "description_other_convenience,pool_area,number_of_floors)" +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    RentTypeService rentTypeService = new RentTypeServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();


    @Override
    public List<Service> findAllService() {

        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> listService = new ArrayList<>();
        Service service;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from service;");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String serviceId = resultSet.getString("service_id");
                    String serviceName = resultSet.getString("service_name");
                    int serviceArea = resultSet.getInt("service_area");
                    double serviceCost = Double.parseDouble(resultSet.getString("service_cost"));
                    int serviceMaxPeople = resultSet.getInt("service_max_people");
                    String serviceStandRoom = resultSet.getString("standard_room");
                    String serviceDesc = resultSet.getString("description_other_convenience");
                    double servicePoolArea = Double.parseDouble(resultSet.getString("pool_area"));
                    int serviceFloor = resultSet.getInt("number_of_floors");
                    RentType rentType = this.rentTypeService.findById(resultSet.getInt("rent_type_id"));
                    ServiceType serviceType = this.serviceTypeService.findById(resultSet.getInt("service_type_id"));

                    service = new Service(serviceId,serviceName,serviceArea,serviceCost,
                            serviceMaxPeople,rentType, serviceType,serviceStandRoom,serviceDesc,servicePoolArea,
                            serviceFloor);
                    listService.add(service);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConection.close();
            }
        }
        return listService;

        }


    @Override
    public void save(Service service) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_SERVICE);
                statement.setString(1,service.getService_id());
                statement.setString(2,service.getService_name());
                statement.setInt(3, service.getService_area());
                statement.setInt(4, service.getService_max_people());
                statement.setInt(5, (int) service.getService_cost());
                statement.setInt(6,service.getRentType().getRent_type_id());
                statement.setInt(7, service.getServiceType().getService_type_id());
                statement.setString(8, service.getStandard_room());
                statement.setString(9,service.getDescription_other_convenience());
                statement.setInt(10,(int)service.getPool_area());
                statement.setInt(11,service.getNumber_of_floors());

                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConection.close();
            }

        }
    }

    @Override
    public Service findServiceById(String id) {
        return null;
    }

    @Override
    public void update(String id, Service service) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Service> search(String search) {
        return null;
    }

    @Override
    public List<Service> sortService(String sortBy) {
        return null;
    }

}
