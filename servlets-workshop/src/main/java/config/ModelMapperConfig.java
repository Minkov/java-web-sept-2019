package config;

import models.service.UserCreateServiceModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;

public class ModelMapperConfig {
    @Produces
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }
}
