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
package com.insclix.mvc.server.rpc;

import com.insclix.mvc.shared.models.Sample;
import com.insclix.mvc.shared.rpc.SampleRemote;
import org.jboss.errai.bus.server.annotations.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Service
@Scope("session")
public class SampleRpcService implements SampleRemote {

    @Override
    public Long createSample(Sample sample) {
        return null;
    }

    @Override
    public Sample getSample() {
        return null;
    }
}
