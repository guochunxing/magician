package com.workabee.cloud.magician.plugin.service.impl;

import com.intellij.psi.*;
import com.intellij.psi.util.MethodSignature;
import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.plugin.model.SelectItem;
import com.workabee.cloud.magician.plugin.service.AbstractApiService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * author: chunxing
 * date: 2021/3/12 11:08
 * description:
 */
public class JavaApiService extends AbstractApiService {


    private static List<String> BASIC_PACKAGE_DATA_TYPES;

    static {
        BASIC_PACKAGE_DATA_TYPES = Arrays.asList(
                String.class.getTypeName(),
                Long.class.getTypeName(),
                Integer.class.getTypeName(),
                Double.class.getTypeName(),
                Float.class.getTypeName(),
                Byte.class.getTypeName(),
                Short.class.getTypeName(),
                Class.class.getTypeName(),
                Object.class.getTypeName(),
                Date.class.getTypeName(),
                Boolean.class.getTypeName(),
                Map.class.getTypeName(),
                byte.class.getTypeName(),
                int.class.getTypeName(),
                short.class.getTypeName(),
                long.class.getTypeName(),
                char.class.getTypeName(),
                float.class.getTypeName(),
                double.class.getTypeName(),
                char.class.getTypeName(),
                boolean.class.getTypeName()
        );
    }

    @Override
    public String supportLanguage() {
        return "JAVA";
    }

    @Override
    public List<SelectItem> selectItems(PsiFile file) {
        PsiJavaFile javaFile = (PsiJavaFile) file;
        PsiClass fileClass = javaFile.getClasses()[0];
        PsiMethod[] methods = fileClass.getMethods();
        List<SelectItem> items = new ArrayList<>();
        for (PsiMethod method : methods) {
            String id = method.getNameIdentifier().getText();
            String name = method.getName();
            MethodSignature signature = method.getSignature(PsiSubstitutor.UNKNOWN);
            PsiType[] parameterTypes = signature.getParameterTypes();

            name = name + "(";
            if (parameterTypes.length > 0) {
                List<String> collect = Arrays.stream(parameterTypes).map(PsiType::getPresentableText).collect(Collectors.toList());
                String join = String.join(",", collect);
                name = name + join;
            }
            name = name + ")";
            PsiType returnType = method.getReturnType();
            String returnText = returnType.getPresentableText();
            name = name + ": " + returnText;

            int code = method.getOriginalElement().getText().hashCode();

            SelectItem item = new SelectItem();
            item.setId(code);
            item.setName(name);
            items.add(item);
        }
        return items;
    }


    @Override
    public void collection(PsiFile file, String selectedText) {
        PsiJavaFile javaFile = (PsiJavaFile) file;
        PsiClass fileClass = javaFile.getClasses()[0];
        PsiMethod[] methods = fileClass.getMethods();
        Optional<PsiMethod> methodOptional = Arrays.stream(methods)
                .filter(method -> method.getName().equals(selectedText))
                .findFirst();

        if (methodOptional.isPresent()) {
            PsiMethod psiMethod = methodOptional.get();
            MethodSignature signature = psiMethod.getSignature(PsiSubstitutor.UNKNOWN);
            List<AbstractAttributeDefinition> parameterDefinition = parseParameters(psiMethod);
            List<AbstractAttributeDefinition> returnDefinition = parseReturn(psiMethod);
        }
    }


    @Override
    public List<AbstractAttributeDefinition> parseParameters(PsiMethod psiMethod) {
        PsiParameterList parameterList = psiMethod.getParameterList();
        PsiParameter[] parameters = parameterList.getParameters();
        List<AbstractAttributeDefinition> definitions = new ArrayList<>();
        for (PsiParameter parameter : parameters) {
            PsiType type = parameter.getType();
            AbstractAttributeDefinition definition = transportInfo(type, parameter.getName());
            definitions.add(definition);
        }
        return definitions;
    }

    @Override
    public List<AbstractAttributeDefinition> parseReturn(PsiMethod psiMethod) {
        PsiType type = psiMethod.getReturnType();
        AbstractAttributeDefinition definition = transportInfo(type, null);
        return Collections.singletonList(definition);
    }


    public AbstractAttributeDefinition transportInfo(PsiType psiType, String name) {
        AbstractAttributeDefinition definition = new AbstractAttributeDefinition();
        return definition;
    }
}
