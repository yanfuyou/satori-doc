package com.satori.doc.common.util.bean;

import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author cat_y
 */
@UtilityClass
public class CopyUtils extends BeanUtils {


    public static <S, T> T copyPropertiesPlus(S source, Class<T> target, BiConsumer<S, T> function) throws BeansException {
        T t = instantiateClass(target);
        copyProperties(source, t);
        if (null != function) {
            function.accept(source, t);
        }
        return t;
    }

    public static <S, T> List<T> copyPropertitesList(List<S> sourcelist, Class<T> target, BiConsumer<S, T> function) {
        List<T> resultList = new ArrayList<>();
        if (null == sourcelist || sourcelist.isEmpty()) {
            return resultList;
        }
        for (S s : sourcelist) {
            T t = copyPropertiesPlus(s, target, function);
            resultList.add(t);
        }
        return resultList;
    }

}
