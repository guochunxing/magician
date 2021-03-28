package com.workabee.cloud.magician.gateway.domain.abstraction;

import com.workabee.cloud.magician.common.abstraction.AbstractAPIDefinition;
import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.gateway.domain.repository.AttributeDefinitionRepository;
import com.workabee.cloud.magician.gateway.domain.util.ApplicationUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Optional;


/**
 * author: chunxing
 * date: 2021/1/13 17:12
 * description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class APIDefinition extends AbstractAPIDefinition {


    @Override
    public List<AbstractAttributeDefinition> getOpenInDefinitions() {
        if (OpenInDefinitions == null) {
            AttributeDefinitionRepository repository = ApplicationUtil.getBean(AttributeDefinitionRepository.class);
            this.OpenInDefinitions = repository.selectByApi(this.name, this.version);
        }
        return OpenInDefinitions;
    }

    @Override
    public AbstractAttributeDefinition getOpenOutDefinition() {
        if (openOutDefinition == null) {
            AttributeDefinitionRepository repository = ApplicationUtil.getBean(AttributeDefinitionRepository.class);
            List<AbstractAttributeDefinition> definitions = repository.selectByApi(this.name, this.version);
            Optional<AbstractAttributeDefinition> definitionOptional = definitions.stream().findFirst();
            return definitionOptional.orElse(null);
        }
        return openOutDefinition;
    }
}
