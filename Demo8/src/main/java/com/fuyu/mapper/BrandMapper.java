package com.fuyu.mapper;

import com.fuyu.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /*
    查询所有
     */
    public List<Brand> selectAll();
//    查看详情 根据id 查询
    public Brand selectBranfById(int id );
}
