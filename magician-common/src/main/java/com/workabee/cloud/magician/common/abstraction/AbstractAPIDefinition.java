package com.workabee.cloud.magician.common.abstraction;

import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.common.abstraction.value.ProtocolSpec;
import com.workabee.cloud.magician.common.constant.GatewayCt;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/8 10:14
 * description:
 */
@Data
public class AbstractAPIDefinition {

    /**
     * api 版本和 name/api 唯一标示
     */
    protected String name;

    protected String version;
    /**
     * 需要转化协议
     * HTTP/DUBBO/GRPC
     */
    protected GatewayCt.Protocol protocol;

    /**
     * 调用地址规范
     */
    protected ProtocolSpec protocolSpec;
    /**
     * 鉴权方式
     */
    protected String authId;
    /**
     * 语言 JAVA/PYTHON/GO
     */
    protected String language;
    /**
     * 对外接口入参
     */
    protected List<AbstractAttributeDefinition> OpenInDefinitions;
    /**
     * 对内接口入参
     */
    protected List<AbstractAttributeDefinition> privateInDefinitions;
    /**
     * 对外返回值
     */
    protected AbstractAttributeDefinition openOutDefinition;
    /**
     * 对外返回值
     */
    protected AbstractAttributeDefinition privateOutDefinition;
    /**
     * 支持数据类型
     */
    protected GatewayCt.ContentType contentType;

    /**
     * 超时时间
     */
    protected Integer timeOut;
    /**
     * 分组 Id
     */
    protected Long groupId;

    @Getter(AccessLevel.NONE)
    private String prefix = "$";
    @Getter(AccessLevel.NONE)
    private String spacer = ".";

    public void private2openInDefinitions() {
        initPath(prefix, privateInDefinitions);
        OpenInDefinitions = privateInDefinitions;
    }

    public void private2openOutDefinition() {
        initPath(prefix, Collections.singletonList(privateOutDefinition));
        openOutDefinition = privateOutDefinition;
    }

    private void initPath(String prefix, List<AbstractAttributeDefinition> definitions) {
        for (AbstractAttributeDefinition definition : definitions) {
            String path = prefix + spacer + definition.getName();
            definition.setPath(path);
            definition.setOriginalPath(path);
            if (definition.getChildAttributeDefinitions() != null) {
                initPath(path, definition.getChildAttributeDefinitions());
            }
        }
    }
}
