/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.bridge.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author tmp
 */
public class InMemoryDAO implements DataAccessObject{

    private Map<ID,Object>managedEntities = new HashMap<>();
    
    @Override
    public <E extends Entity> void persist(E entity) {
        managedEntities.put(new ID(entity), entity);
    }

    @Override
    public <E extends Entity> E find(Class<E> type, Object id) {
        return (E) managedEntities.get(new ID(type, id));
    }

    @Override
    public <E extends Entity> E update(E entity) {
        managedEntities.put(new ID(entity), entity);
        return entity;
    }

    @Override
    public boolean remove(Class<? extends Entity> type, Object id) {
        return managedEntities.remove(new ID(type, id)) != null;
    }

    @Override
    public <E extends Entity> boolean remove(E entity) {
        return managedEntities.remove(new ID(entity)) != null;
    }

    static class ID<E extends Entity> {
        private final Class<E> type;
        private final Object id;

        public ID(Entity entity) {
            type = (Class<E>) entity.getClass();
            id = entity.getId();
        }
        
        public ID(Class<E> type, Object id) {
            this.type = type;
            this.id = id;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + Objects.hashCode(this.type);
            hash = 13 * hash + Objects.hashCode(this.id);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ID other = (ID) obj;
            if (!Objects.equals(this.type, other.type)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return type.getSimpleName() + " (id=" + id + ')';
        }
        
    }

    @Override
    public String toString() {
        return "InMemoryDAO{" + "managedEntities=" + managedEntities + '}';
    }
    
}
