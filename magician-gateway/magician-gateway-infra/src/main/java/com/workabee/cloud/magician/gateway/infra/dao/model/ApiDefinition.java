package com.workabee.cloud.magician.gateway.infra.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiDefinition implements Serializable {

    private Long id;

    private String name;

    private String version;

    private String protocol;

    private Integer timeOut;

    private String contentType;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
