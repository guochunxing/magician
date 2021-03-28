package com.workabee.cloud.magician.common.util;


import com.workabee.cloud.magician.common.exception.MagicianException;
import com.workabee.cloud.magician.common.exception.MagicianMessage;

/**
 * author: chunxing
 * date: 2020/5/21 00:00
 * description:
 */
public class CheckUtil {


    public static <T> void checkNotNull(T reference, MagicianMessage message, String replaceMessage) {
        if (reference == null) {
            if (replaceMessage != null) {
                throw MagicianException.EX(message, replaceMessage);
            } else {
                throw MagicianException.EX(message);
            }
        }
    }

    public static <T> void checkNull(T reference, MagicianMessage message, String replaceMessage) {
        if (reference != null) {
            if (replaceMessage != null) {
                throw MagicianException.EX(message, replaceMessage);
            } else {
                throw MagicianException.EX(message);
            }
        }
    }

    public static void checkArgument(boolean expression, MagicianMessage message, String replaceMessage) {
        if (!expression) {
            if (replaceMessage != null) {
                throw MagicianException.EX(message, replaceMessage);
            } else {
                throw MagicianException.EX(message);
            }
        }
    }

    public static void checkArgument(boolean expression, MagicianMessage message) {
        if (!expression) {
            throw MagicianException.EX(message);
        }
    }

    public static void checkStringEmpty(String string, MagicianMessage message, String replaceMessage) {
        if (string == null || string.length() == 0) {
            if (replaceMessage != null) {
                throw MagicianException.EX(message, replaceMessage);
            } else {
                throw MagicianException.EX(message);
            }
        }
    }
}
