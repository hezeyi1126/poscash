package springboot.hello.sys.dao;

import springboot.hello.sys.entity.SysCodeType;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月24日.
*/
@org.apache.ibatis.annotations.Mapper
public interface SysCodeTypeDao extends Mapper<SysCodeType>{

   int insert(SysCodeType sysCodeType);

  //  int delete(SysCodeType sysCodeType);

    int deleteByIds(@Param("ids") String[] ids);

   // int update(SysCodeType sysCodeType);

    SysCodeType getById(@Param("id") String id);

   // List<SysCodeType> list(SysCodeType sysCodeType);
}