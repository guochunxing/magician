package com.workabee.cloud.magician.common.abstraction.value;

import com.workabee.cloud.magician.common.constant.APICt;
import lombok.Data;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/8 10:17
 * description:
 */
@Data
public class AbstractAttributeDefinition {

    protected String name;

    //对外类型
    protected APICt.TypeReference typeReference;

    //对内原始类型
    protected String originalType;

    protected boolean basicType = true;

    protected boolean array = false;
    // $.name
    protected String path;
    //对外参数映射到的内部路径
    protected String originalPath;

    protected List<AbstractAttributeDefinition> childAttributeDefinitions;

    protected Object defaultValue;
}
