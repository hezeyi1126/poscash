package springboot.hello.sys.service;

import springboot.hello.sys.entity.SysCodeType;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月24日.
*/
public interface SysCodeTypeService {

    int insert(SysCodeType sysCodeType);

    int delete(SysCodeType sysCodeType);

    int deleteByIds(String[] ids);

    int update(SysCodeType sysCodeType);

    SysCodeType getById(String id);

    List<SysCodeType> list(SysCodeType sysCodeType);
    
}