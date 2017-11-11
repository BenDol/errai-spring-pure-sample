/*
 * #%L
 * Errai Prototype
 * %%
 * Copyright (C) 2017 Doltech
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
package com.insclix.mvc.server.jaxrs;

import com.insclix.mvc.shared.jaxrs.SampleJaxrsService;
import com.insclix.mvc.shared.models.Sample;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Service
@Path("/sample")
@Produces(MediaType.APPLICATION_JSON_VALUE)
@Consumes(MediaType.APPLICATION_JSON_VALUE)
public class SampleJaxrsServiceImpl implements SampleJaxrsService {

    @Override
    public Sample getSample() {
        return null;
    }

    @Override
    public Long createSample(Sample sample) {
        return null;
    }
}