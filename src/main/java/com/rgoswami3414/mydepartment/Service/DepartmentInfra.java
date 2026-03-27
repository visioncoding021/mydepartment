package com.rgoswami3414.mydepartment.Service;

import com.rgoswami3414.mydepartment.Dtos.Dtos.*;

import java.util.List;

public interface DepartmentInfra {
    public ResponseDepartment createDepartment(RequestDepartment requestDepartment);
    public List<ResponseDepartment> getAllDepartment(int page, int offset);
    public ResponseDepartment getDepartment(int id);
    public ResponseDepartment updateDepartment(UpdateDepartment requestDepartment);
}
