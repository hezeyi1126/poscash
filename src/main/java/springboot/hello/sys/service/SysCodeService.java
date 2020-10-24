package springboot.hello.sys.service;

import springboot.hello.sys.entity.SysCode;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月24日.
*/
public interface SysCodeService {

    int insert(SysCode sysCode);

    int delete(SysCode sysCode);

    int deleteByIds(String[] ids);

    int update(SysCode sysCode);

    SysCode getById(String id);

    List<SysCode> list(SysCode sysCode);
    
}