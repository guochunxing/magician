package com.workabee.cloud.magician.gateway.infra.dao.mapper.base;

import com.workabee.cloud.magician.gateway.infra.dao.condition.ApiDefinitionCondition;
import com.workabee.cloud.magician.gateway.infra.dao.model.ApiDefinition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseApiDefinitionMapper {
    long countByExample(ApiDefinitionCondition example);

    int deleteByExample(ApiDefinitionCondition example);

    int deleteByPrimaryKey(Long id);

    int insert(ApiDefinition record);

    int insertSelective(ApiDefinition record);

    List<ApiDefinition> selectByExample(ApiDefinitionCondition example);

    ApiDefinition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApiDefinition record, @Param("example") ApiDefinitionCondition example);

    int updateByExample(@Param("record") ApiDefinition record, @Param("example") ApiDefinitionCondition example);

    int updateByPrimaryKeySelective(ApiDefinition record);

    int updateByPrimaryKey(ApiDefinition record);
}