package springboot.hello.sys.entity;

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
@Table(name = "SYS_CODE")
public class SysCode implements Serializable {
        /**
         *编码ID
         */
         @Id
   		 @GeneratedValue(generator = "UUID")
   		 @Column(name="CODE_ID")
         private String codeId; 
         
        /**
         *编码类型ID
         */
         @Column(name="CODE_TYPE_ID")
         private String codeTypeId;
         
        /**
         *编码
         */
         @Column(name="CODE")
         private String code;
         
        /**
         *编码类型编码
         */
         @Column(name="CODE_TYPE_CODE")
         private String codeTypeCode;
         
        /**
         *编码值
         */
         @Column(name="CODE_VAL")
         private String codeVal;
         
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
         

        public String getCodeId() {
            return codeId;
        }

        public void setCodeId(String codeId) {
            this.codeId = codeId;
        }
        public String getCodeTypeId() {
            return codeTypeId;
        }

        public void setCodeTypeId(String codeTypeId) {
            this.codeTypeId = codeTypeId;
        }
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
        public String getCodeTypeCode() {
            return codeTypeCode;
        }

        public void setCodeTypeCode(String codeTypeCode) {
            this.codeTypeCode = codeTypeCode;
        }
        public String getCodeVal() {
            return codeVal;
        }

        public void setCodeVal(String codeVal) {
            this.codeVal = codeVal;
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
