package com.myfinances.myfinances.mapper;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

public class VOMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    // Method to convert class DTO to Model
    public static <Origin, Destiny> Destiny parseObjectClassDTOToModel(Origin origin, Class<Destiny> destinyClass) {
        return mapper.map(origin, destinyClass);
    }

    // Method to convert List<> DTO to Model
    public static <Origin, Destiny> List<Destiny> parseListClassDTOToModel(List<Origin> origin, Class<Destiny> destinyClass) {
        List<Destiny> destinyList = new ArrayList<>();
        for (Origin originClass : origin) {
            destinyList.add(mapper.map(originClass, destinyClass));
        }
        return destinyList;
    }
}
