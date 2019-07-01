package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

///借助lombok，不用set get等定义了

//@NoArgsConstructor
@Data  //set，get方法
@Accessors(chain = true)
public class Dept implements Serializable {  //dept-mysql类表关系映射 必须序列化 ！！！！！！！！！！！

    private Long deptno; //主键
    private String dname;
    private String db_source; //存的数据库

    public Dept() {
    }

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }
}
