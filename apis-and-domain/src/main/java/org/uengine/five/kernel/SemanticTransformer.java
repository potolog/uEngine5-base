package org.uengine.five.kernel;

import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.five.service.SemanticEntityService;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processdesigner.mapper.Transformer;

import java.util.Map;

/**
 * Created by uengine on 2018. 1. 11..
 */
public class SemanticTransformer extends Transformer {

    protected Object transform(ProcessInstance instance, Map parameterMap, Map options) throws Exception {

        SemanticEntityService semanticEntityService = MetaworksRemoteService.getComponent(SemanticEntityService.class);

        return semanticEntityService.entityValue(parameterMap.get("input").toString(), getEntityType());
    }

    public String[] getInputArguments() {
        return new String[]{"input"};
    }

    String entityType;
        public String getEntityType() {
            return entityType;
        }
        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

}