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
package com.insclix.mvc.shared.models;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.security.shared.api.Group;
import org.jboss.errai.security.shared.api.Role;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.unmodifiableMap;

public class User implements org.jboss.errai.security.shared.api.identity.User, Serializable {

    private static final long serialVersionUID = 3172905561115755369L;

    /**
     * Represents a user who is not logged in. This user has no properties and a
     * {@link Role#NOBODY single role}.
     */
    public static final User ANONYMOUS = new User("ANONYMOUS", "ANONYMOUS",
        Collections.singletonList(Role.NOBODY));

    private String name;
    private String emailAddress;
    private String password;
    private final Set<Role> roles;
    private final Set<Group> groups;
    private Set<String> costCentres = new HashSet<>();
    private final Map<String, String> properties = new HashMap<>();

    public User() {
        this("", "", Collections.emptySet());
    }

    public User(String name, final String emailAddress) {
        this(name, emailAddress, Collections.emptySet());
    }

    public User(String name, final String emailAddress, final Collection<? extends Role> roles) {
        this(name, emailAddress, roles, Collections.emptySet(), Collections.emptyMap());
    }

    public User(String name, final String emailAddress, final Collection<? extends Role> roles, final Map<String, String> properties) {
        this(name, emailAddress, roles, Collections.emptySet(), properties);
    }

    public User(String name, final String emailAddress, final Collection<? extends Role> roles, final Collection<? extends Group> groups) {
        this(name, emailAddress, roles, groups, Collections.emptyMap());
    }

    public User(
            @MapsTo("name") String name,
            @MapsTo("emailAddress") final String emailAddress,
            @MapsTo("roles") final Collection<? extends Role> roles,
            @MapsTo("groups") final Collection<? extends Group> groups,
            @MapsTo("properties") final Map<String, String> properties) {

        this.name = name;
        this.emailAddress = emailAddress;
        this.roles = Collections.unmodifiableSet(new HashSet<Role>(roles));
        this.groups = Collections.unmodifiableSet(new HashSet<Group>(groups));
        this.properties.putAll(properties);
    }

    @Override
    public Set<Role> getRoles() {
        return roles;
    }

    public boolean hasAllRoles(String... roleNames) {
        for (String roleName : roleNames) {
            boolean foundThisOne = false;
            for (Role role : roles) {
                if (roleName.equals(role.getName())) {
                    foundThisOne = true;
                    break;
                }
            }
            if (!foundThisOne) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAnyRoles(String... roleNames) {
        for (Role role : roles) {
            for (String roleName : roleNames) {
                if (roleName.equals(role.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Set<Group> getGroups() {
        return groups;
    }

    public boolean hasAllGroups(String... groupNames) {
        for (String groupName : groupNames) {
            boolean foundThisOne = false;
            for (Group group : groups) {
                if (groupName.equals(group.getName())) {
                    foundThisOne = true;
                    break;
                }
            }
            if (!foundThisOne) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAnyGroups(String... groupNames) {
        for (Group group : groups) {
            for (String groupName : groupNames) {
                if (groupName.equals(group.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCostCentre(String costCentre) {
        return this.costCentres.contains(costCentre) || this.costCentres.contains("*");
    }

    @Override
    public Map<String, String> getProperties() {
        return unmodifiableMap(properties);
    }

    @Override
    public void setProperty(final String name, final String value) {
        properties.put(name, value);
    }

    @Override
    public void removeProperty(final String name) {
        properties.remove(name);
    }

    @Override
    public String getProperty(final String name) {
        return properties.get(name);
    }

    @Override
    public String getIdentifier() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getCostCentres() {
        return costCentres;
    }

    public void setCostCentres(Set<String> costCentres) {
        this.costCentres = costCentres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return getIdentifier().equals(user.getIdentifier());
    }

    @Override
    public int hashCode() {
        return emailAddress.hashCode();
    }

    @Override
    public String toString() {
        return "User [id=" + emailAddress + ", roles=" + roles + ", groups=" + groups + ", properties=" + properties + "]";
    }
}
