/*
 * #%L
 * Errai Prototype
 * %%
 * Copyright (C) 2015 - 2017 Doltech
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.insclix.mvc.server.config.jaxrs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.insclix.mvc.server.config.json.JsonHibernateObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JacksonMapperProvider implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    public JacksonMapperProvider() {
        objectMapper = new JsonHibernateObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // Do not serialize map key-value where value is null
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        // Trying to ignore fields that have null values.
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public ObjectMapper getContext(Class type) {
        return objectMapper;
    }
}