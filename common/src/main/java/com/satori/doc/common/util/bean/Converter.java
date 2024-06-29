package com.satori.doc.common.util.bean;

import java.util.List;

/**
 * @author cat_y
 */
public interface Converter<S, T> {

    T copy(S s);

    List<T> copyList(List<S> sources);
}
