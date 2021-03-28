package com.workabee.cloud.magician.plugin.factory;

import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.PsiFile;
import com.workabee.cloud.magician.plugin.service.ApiService;
import com.workabee.cloud.magician.plugin.service.impl.JavaApiService;

/**
 * author: chunxing
 * date: 2021/3/12 11:01
 * description:
 */
public class ApiFactory {


    public static ApiService getService(PsiFile file) {
        boolean b = file.getLanguage().is(JavaLanguage.INSTANCE);
        return new JavaApiService();

    }

}
