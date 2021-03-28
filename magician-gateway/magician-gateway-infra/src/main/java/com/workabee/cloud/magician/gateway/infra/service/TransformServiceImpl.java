package com.workabee.cloud.magician.gateway.infra.service;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.gateway.domain.service.TransformService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/7 15:28
 * description:
 */
@Service
public class TransformServiceImpl implements TransformService {

    private static final String prefix = "$.";

    @Override
    public List<Object> transform(byte[] source, List<AbstractAttributeDefinition> definitions) {
        ByteArrayInputStream stream = new ByteArrayInputStream(source);
        DocumentContext document = JsonPath.parse(stream);
        List<Object> outs = new ArrayList<>();
        for (AbstractAttributeDefinition definition : definitions) {
            Object object = new Object();
            DocumentContext originalDocument = JsonPath.parse(object);
            transform(document, definition, originalDocument);
            outs.add(originalDocument.json());
        }
        return outs;
    }

    @Override
    public Object transform(Object source, AbstractAttributeDefinition definition) {
        return null;
    }

    public void transform(DocumentContext document, AbstractAttributeDefinition definition, DocumentContext originalDocument) {
        if (definition.getChildAttributeDefinitions() != null) {
            List<AbstractAttributeDefinition> childAttributeDefinitions = definition.getChildAttributeDefinitions();
            for (AbstractAttributeDefinition attributeDefinition : childAttributeDefinitions) {
                transform(document, attributeDefinition, originalDocument);
            }
        } else {
            String path = definition.getPath();
            Object read = document.read(prefix + path);
            String originalPath = definition.getOriginalPath();
            JsonPath originalJsonPath = JsonPath.compile(prefix + originalPath);
            originalDocument.set(originalJsonPath, read);
        }
    }
}
