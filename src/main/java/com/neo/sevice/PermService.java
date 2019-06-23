package com.neo.sevice;

import com.neo.model.SysPermission;

public interface PermService {

    void addPerm(String rId, String pId);

    void save(SysPermission permission);
}
