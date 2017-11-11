/*
 * #%L
 * Errai Prototype
 * %%
 * Copyright (C) 2015 - 2016 Doltech
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
package javax.ws.rs.core;

/**
 * Represents a URI path segment and any associated matrix parameters. When an
 * instance of this type is injected with {@link javax.ws.rs.PathParam}, the
 * value of the annotation identifies which path segment is selected and the
 * presence of an {@link javax.ws.rs.Encoded} annotation will result in an
 * instance that supplies the path and matrix parameter values in
 * URI encoded form.
 *
 * @see UriInfo#getPathSegments
 * @see javax.ws.rs.PathParam
 */
public interface PathSegment
{

    /**
     * Get the path segment.
     * <p/>
     *
     * @return the path segment
     */
    String getPath();

    /**
     * Get a map of the matrix parameters associated with the path segment.
     * The map keys are the names of the matrix parameters with any
     * percent-escaped octets decoded.
     *
     * @return the map of matrix parameters
     * @see <a href="http://www.w3.org/DesignIssues/MatrixURIs.html">Matrix URIs</a>
     */
    MultivaluedMap<String, String> getMatrixParameters();

}