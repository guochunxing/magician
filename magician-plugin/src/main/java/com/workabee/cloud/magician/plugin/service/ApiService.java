package com.workabee.cloud.magician.plugin.service;

import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;
import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.plugin.model.SelectItem;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/3/12 11:04
 * description:
 */
public interface ApiService {


    public String supportLanguage();

    public List<SelectItem> selectItems(PsiFile file);

    public List<AbstractAttributeDefinition> parseParameters(PsiMethod psiMethod);

    public List<AbstractAttributeDefinition> parseReturn(PsiMethod psiMethod);

    void collection(PsiFile file, String selectedText);
}
