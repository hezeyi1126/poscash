package springboot.hello.sys.service.impl;

import springboot.hello.sys.service.SysCodeTypeService;
import springboot.hello.sys.dao.SysCodeTypeDao;
import springboot.hello.sys.entity.SysCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import springboot.hello.entity.base.ParamObject;
import springboot.hello.util.BeanUtil;
import java.util.List;

/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月24日.
*/
@Service("sysCodeTypeService")
public class SysCodeTypeServiceImpl implements SysCodeTypeService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<SysCodeType> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	sysCodeTypeDao.deleteByIds(ids);
    	paramObject.setMsg(  "删除成功");
    	return null;
    }

    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<SysCodeType> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
    	sysCodeTypeDao.insert(paramObject.getEntity());
    	paramObject.setMsg(  "添加成功");
    	return null;
    }
    
  // @CacheEvict(value = "sysCodeType", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<SysCodeType> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
    	sysCodeTypeDao.delete(paramObject.getEntity());
    	paramObject.setMsg(  "删除成功");
    	 return null;
    }
    
    public Object list(ParamObject<SysCodeType> paramObject) throws Exception{
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
        return  sysCodeTypeDao.select(paramObject.getEntity());
    }
    
    
    //@Cacheable(value = "sysCodeType", key = "#p0.id")
    public Object getBId(ParamObject<SysCodeType> paramObject) throws Exception{
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
        return  sysCodeTypeDao.selectOne(paramObject.getEntity());
    }
    
    
   // @CachePut(value = "sysCodeType", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<SysCodeType> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysCodeType.class, paramObject);
    	SysCodeType entity = paramObject.getEntity();
    	sysCodeTypeDao.updateByPrimaryKey(entity);
    	paramObject.setMsg(  "保存成功");
        return entity;
    }




    @Autowired
    private SysCodeTypeDao sysCodeTypeDao;
    
     @Override
    public SysCodeType getById(String id){
        return sysCodeTypeDao.getById(id);
    }
    
        @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  sysCodeTypeDao.deleteByIds(ids);
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(SysCodeType sysCodeType){
        return sysCodeTypeDao.insert(sysCodeType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(SysCodeType sysCodeType){
        return sysCodeTypeDao.delete(sysCodeType);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(SysCodeType sysCodeType){
        return sysCodeTypeDao.updateByPrimaryKey(sysCodeType);
    }

   

    @Override
    public List<SysCodeType> list(SysCodeType sysCodeType){
        return sysCodeTypeDao.select(sysCodeType);
    }
    
    /**
    *getter and setter
    */
    public SysCodeTypeDao getSysCodeType(){
    	return this.sysCodeTypeDao;
    }
    
    public void setSysCodeTypeDao(SysCodeTypeDao sysCodeTypeDao){
      this.sysCodeTypeDao = sysCodeTypeDao;
    }
    

}