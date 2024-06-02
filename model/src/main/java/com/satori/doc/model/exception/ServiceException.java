package com.satori.doc.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author cat_y
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    private String eCode;

    private String eMsg;

    public ServiceException(String eCode, String eMsg, Throwable cause) {
        super(cause.getMessage(), cause);
        this.eCode = eCode;
        this.eMsg = eMsg;
    }
}
