package springboot.hello.bus.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* Created by hbm Generator<27683139@qq.com> on 2020年10月25日.
*/
@Table(name = "BUS_GOODS_TYPE")
public class BusGoodsType implements Serializable {
        /**
         *类型ID
         */
         @Id
   		 @GeneratedValue(generator = "UUID")
   		 @Column(name="TYPE_ID")
         private String typeId; 
         
        /**
         *菜单名称
         */
         @Column(name="TYPE_NAME")
         private String typeName;
         
        /**
         *上级类型ID
         */
         @Column(name="PARENT_ID")
         private String parentId;
         
        /**
         *是否可用 1可用 0不可用
         */
         @Column(name="IS_AVIABLE")
         private BigDecimal isAviable;
         
        /**
         *排序
         */
         @Column(name="SORT_FLAG")
         private BigDecimal sortFlag;
         
        /**
         *创建人
         */
         @Column(name="CREATE_USER_ID")
         private String createUserId;
         
        /**
         *创建时间
         */
   		 @JsonFormat(pattern = "yyyy-MM-dd")
         @Column(name="CREATE_TIME")
         private Date createTime;
         

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }
        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
        public BigDecimal getIsAviable() {
            return isAviable;
        }

        public void setIsAviable(BigDecimal isAviable) {
            this.isAviable = isAviable;
        }
        public BigDecimal getSortFlag() {
            return sortFlag;
        }

        public void setSortFlag(BigDecimal sortFlag) {
            this.sortFlag = sortFlag;
        }
        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }
        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
}
