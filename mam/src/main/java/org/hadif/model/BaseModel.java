package org.hadif.model;

import java.util.Date;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel extends PanacheEntityBase{
    public String createdBy;
    public String updatedBy;
    public Date createDate;
    public Date updateDate;

}
