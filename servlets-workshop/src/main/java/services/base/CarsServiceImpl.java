package services.base;

import models.entity.Car;
import models.service.CarServiceModel;
import org.modelmapper.ModelMapper;
import services.CarsService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.invoke.TypeDescriptor;
import java.util.List;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Inject
    public CarsServiceImpl(
            ModelMapper mapper,
            EntityManager entityManager
    ) {

        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    @Override
    public List<CarServiceModel> getAll() {
        return entityManager.createQuery("select c from Car c", Car.class)
                .getResultList()
                .stream()
                .map(car -> mapper.map(car, CarServiceModel.class))
                .collect(Collectors.toList());
    }
}
