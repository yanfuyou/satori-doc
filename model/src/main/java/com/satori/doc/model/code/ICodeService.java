package com.satori.doc.model.code;

import com.satori.doc.model.exception.ServiceException;
import com.satori.doc.model.vo.ResultVO;

import java.util.Optional;

/**
 * @author cat_y
 */
public interface ICodeService<T> {
    String code();

    String desc();

    String msgFormat();

    default ServiceException buildEx() {
        return new ServiceException(this.code(), this.desc());
    }

    default ServiceException buildEx(Object... args) {
        return new ServiceException(this.code(), getMsg(args));
    }

    default ResultVO<T> buildResult(T data) {
        return new ResultVO<>(this.code(), this.desc(), data);
    }

    default String getMsg(Object... args) {
        return Optional.ofNullable(this.msgFormat())
                .orElse(this.desc())
                .formatted(args);

    }

}
