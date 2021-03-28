package com.workabee.cloud.magician.gateway.domain.util;

/**
 * author: chunxing
 * date: 2021/2/7 14:53
 * description:
 */
public class ExecuteUtil {

    private static ThreadLocal<ExecuteRequest> threadLocal = new ThreadLocal<>();

    public static ExecuteRequest getSessionContext() {
        return ExecuteUtil.threadLocal.get();
    }

    public static void setThreadLocal(ExecuteRequest sessionContext) {
        ExecuteUtil.threadLocal.set(sessionContext);
    }

    public static void remove() {
        ExecuteUtil.threadLocal.remove();
    }

}
