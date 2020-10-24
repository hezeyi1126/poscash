package springboot.hello.sys.service.impl;

import springboot.hello.sys.service.SysCodeService;
import springboot.hello.sys.dao.SysCodeDao;
import springboot.hello.sys.entity.SysCode;
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
@Service("sysCodeService")
public class SysCodeServiceImpl implements SysCodeService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object delSelected(ParamObject<SysCode> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysCode.class, paramObject);
    	String idsArr = (String) paramObject.getValue("ids");
    	String[] ids =  idsArr.split(",");
    	sysCodeDao.deleteByIds(ids);
    	paramObject.setMsg(  "删除成功");
    	return null;
    }

    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object add(ParamObject<SysCode> paramObject ) throws Exception {
    	BeanUtil.buildEntity(SysCode.class, paramObject);
    	sysCodeDao.insert(paramObject.getEntity());
    	paramObject.setMsg(  "添加成功");
    	return null;
    }
    
  // @CacheEvict(value = "sysCode", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object del(ParamObject<SysCode> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysCode.class, paramObject);
    	sysCodeDao.delete(paramObject.getEntity());
    	paramObject.setMsg(  "删除成功");
    	 return null;
    }
    
    
    //@Cacheable(value = "sysCode", key = "#p0.id")
    public Object getBId(ParamObject<SysCode> paramObject) throws Exception{
    	BeanUtil.buildEntity(SysCode.class, paramObject);
        return  sysCodeDao.selectOne(paramObject.getEntity());
    }
    
    
   // @CachePut(value = "sysCode", key = "#p0.id")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object edit(ParamObject<SysCode> paramObject ) throws Exception{
    	BeanUtil.buildEntity(SysCode.class, paramObject);
    	SysCode entity = paramObject.getEntity();
    	sysCodeDao.updateByPrimaryKey(entity);
    	paramObject.setMsg(  "保存成功");
        return entity;
    }




    @Autowired
    private SysCodeDao sysCodeDao;
    
     @Override
    public SysCode getById(String id){
        return sysCodeDao.getById(id);
    }
    
        @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteByIds(String[] ids) {
        return  sysCodeDao.deleteByIds(ids);
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(SysCode sysCode){
        return sysCodeDao.insert(sysCode);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(SysCode sysCode){
        return sysCodeDao.delete(sysCode);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(SysCode sysCode){
        return sysCodeDao.updateByPrimaryKey(sysCode);
    }

   

    @Override
    public List<SysCode> list(SysCode sysCode){
        return sysCodeDao.select(sysCode);
    }
    
    /**
    *getter and setter
    */
    public SysCodeDao getSysCode(){
    	return this.sysCodeDao;
    }
    
    public void setSysCodeDao(SysCodeDao sysCodeDao){
      this.sysCodeDao = sysCodeDao;
    }
    

}