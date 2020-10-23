package com.spring.webapp.vers2.exception;

public class UnknownEntityException extends CustomNotValidException{
    private final Class<?> clas;
    private final long entityId;

    public UnknownEntityException(Class<?> clas, long entityId) {
        super("NotExist", clas.getSimpleName(), "id");
        this.clas = clas;
        this.entityId = entityId;
    }

    public String getEntityType() {
        return clas.getSimpleName();
    }

    public long getEntityId() {
        return entityId;
    }
}
