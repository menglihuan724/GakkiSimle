package com.terry.gakkisimle.core.common.util;


import com.terry.gakkisimle.core.common.exception.GlobalErrorCode;

/**
 * Created by terrymeng
 *
 */
public class IdUtils {

    public static String getId(Long tenantId, String bizId) {
        AssertUtils.notNull(tenantId, GlobalErrorCode.TENANTID_ID_NOT_EMPTY);
        return String.format("%s:%s", tenantId, bizId);
    }
}
