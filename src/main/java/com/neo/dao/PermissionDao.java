package com.neo.dao;

import com.neo.model.SysPermission;
import com.neo.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PermissionDao extends JpaRepository<SysPermission, Integer> {


    @Query(nativeQuery = true, value = "insert into sys_role_permission (permission_id,role_id) VALUES(?2,?1);")
    void addPerm(String rId, String pId);


}