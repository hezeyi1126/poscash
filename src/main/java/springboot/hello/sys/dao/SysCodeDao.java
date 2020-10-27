package springboot.hello.sys.dao;

import springboot.hello.sys.entity.SysCode;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@org.apache.ibatis.annotations.Mapper
public interface SysCodeDao extends Mapper<SysCode>{

   int insert(SysCode sysCode);

  //  int delete(SysCode sysCode);

    int deleteByIds(@Param("ids") String[] ids);

   // int update(SysCode sysCode);

    SysCode getById(@Param("id") String id);

   // List<SysCode> list(SysCode sysCode);
}