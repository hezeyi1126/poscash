package springboot.hello.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import springboot.hello.entity.base.ParamObject;
import springboot.hello.entity.base.QueryEntity;
import springboot.hello.entity.base.ResObj;
import springboot.hello.service.queryService;
import springboot.hello.util.AssertUtil;


@Service("queryService")
public class QueryServiceImpl implements queryService {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private DataSource dataSource;

	/**
	 * 根据queryId查询结果
	 * @throws Exception 
	 */
	@Override
	public Object queryById(ParamObject po) throws Exception {
		//从redis获取查询实体   查询结果 
		String queryid = (String) po.getValue("queryId");
		if(queryid == null) {
			throw new Exception("缺失queryId");
		}
		
		QueryEntity qe = (QueryEntity) redisTemplate.opsForValue().get(queryid);
		//根据传来的参数预处理sql
		preHandleSql(po ,qe );
		//执行查询
		   Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(qe.getSqlpre());
			
			
			//查询总条数
			ResultSet rscnt =   ps.executeQuery("select count(1) from (" + qe.getSqlpre() + ") tableNew");
			int count = 0;
			if(rscnt.next()) {
				count = rscnt.getInt(1);
			}
			//添加分页查询结果
			String sql = addPageInfo(po , qe);
//			System.out.println(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			List dataList =  resultSetToJson(rs ,qe);
			
			
			//添加header
			List headerList  = new ArrayList();
			for (Element element : qe.getAttrs()) {
				Map header = new HashMap();
				List<Attribute> attrs  =  element.attributes();
				for( Attribute at : attrs) {
					header.put(at.getName(), at.getStringValue());
				}
				headerList.add(header);
			}
			//关闭连接
			if(rs != null ) {
				rs.close();
			}
			if(ps != null ) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
			//添加结果到返回对象
			Map res = new HashMap<String, Object>();
			res.put("count", count);
			res.put("data", dataList);
			res.put("header", headerList);
			
		return res;
	}
	
	
	/**
	 * 根据数据库类型添加分页信息
	 * @param po
	 * @param qe
	 * @return
	 */
	private String addPageInfo(ParamObject po, QueryEntity qe) {
		String sql =  qe.getSqlpre();
		int page = 1;
		int size = 10;
		if(po.getValue("page") == null ) {
			//没有分页信息,添加默认页码和size
			
			//mysql
			sql += " limit " + ((page - 1)*size )  +"," + size;
			
		}else {
			page = Integer.parseInt((String) po.getValue("page"));
			size = Integer.parseInt((String) po.getValue("size"));
			sql += " limit " + ((page - 1)*size )  +"," + size;
		}
		return sql;
	}



	public List resultSetToJson(ResultSet rs, QueryEntity qe ) throws SQLException, JSONException
	    {
	       // json数组
	       List array = new ArrayList();
	       // 获取列数
	       ResultSetMetaData metaData = rs.getMetaData();
	       int columnCount = metaData.getColumnCount();
	      
	       // 遍历ResultSet中的每条数据
	        while (rs.next()) {
	           Map valuesMap = new HashMap();
	            // 遍历每一列
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName =metaData.getColumnLabel(i);
	                String value = rs.getString(columnName);
//	                jsonObj.put(qe.getEleMap().get(columnName).attribute("field").getValue(), value);
	                valuesMap.put(columnName, value);
	            } 
	            array.add(valuesMap);
	        }
	      
	       return array;
	    }

	
	
	private void preHandleSql(ParamObject po, QueryEntity qe) {
			String sqlO = qe.getSqlOrign();
			Map values = po.getValues();
			Iterator iterator = values.keySet().iterator();
			
			List<String> list = new ArrayList<String>();
			//切割所有的中括号
			//处理中括号后的语句
			String extraSql = "";
			if(sqlO.lastIndexOf("]") > 0) {
				extraSql = sqlO.substring(sqlO.lastIndexOf("]") + 1);
			}
			//处理中括号里的语句
			if(sqlO.indexOf("[") > 0) {
				String s1 = sqlO.substring(sqlO.indexOf("["));
				while(s1.indexOf("]") > 0) {
					int index = s1.indexOf("]");
					list.add(s1.substring(0, index + 1));
					s1 = s1.substring(index + 1);
				}
			}
			while(iterator.hasNext()) {
				Object key = iterator.next();
				if(!key.equals("queryId") ){
					String val = (String) values.get(key);
					
					for (int i = 0; i < list.size(); i++) {
						String sql = list.get(i);
						//值不是空则替换
						if(sql.indexOf("@" + key) > 0 && AssertUtil.isNull(val)) {
							sql = sql.replace("{#"+ key +"}", val);
							list.set(i, sql);
						}
					}
					
				}
			}
			String sqlpre =  null;
			if(sqlO.indexOf("[") > 0) {
				sqlpre = sqlO.substring(0 , sqlO.indexOf("[") - 1);
			}else {
				sqlpre = sqlO;
			}
		
			//拼接处理好的sql条件
			for (String string : list) {
				//说明已经被替换过值了
				if(string.indexOf("#") < 0) {
					sqlpre += " " +string.substring(string.indexOf(";") + 1, string.lastIndexOf("]") );
				}
			}
			
			System.out.println(sqlpre + extraSql);
			qe.setSqlpre(sqlpre + extraSql);
	}
	
	public static void main(String[] args) {
//		String s= "SELECT  ID,NAME, AGE,SALARY\r\n"
//				+ "		FROM ZHANG_SAN\r\n"
//				+ "		WHERE 1=1\r\n"
//				+ "		[@name; AND NAME LIKE '%{#name}%' ]\r\n"
//				+ "		[@age; AND AGE = {#age} ]";
		
		String ss = "[@name; AND NAME LIKE  {#name}  {#name} '%{#name}%' ]".replace("{#name}", "张三");
		System.out.println(ss);
//		String s1 = s.substring(s.indexOf("["));
		
		
//		System.out.println(s1);
//		System.out.println(s);
	}
	
	

}
