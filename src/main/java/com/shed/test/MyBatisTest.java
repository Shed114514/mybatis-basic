package com.shed.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shed.domain.Member;
import com.shed.mapper.MemberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {

        Member member = new Member(7,"Greg",25,new Date());

        MyBatisTest.getMapper("SqlMapConfig.xml").insert(member);

    }

    @Test
    public void testDelete() throws IOException {

        MyBatisTest.getMapper("SqlMapConfig.xml").deleteByPrimaryKey(5);

    }

    @Test
    public void testUpdate() throws IOException {

        Member member = new Member(6,"Frank",null,null);

        MyBatisTest.getMapper("SqlMapConfig.xml").updateByPrimaryKeySelective(member);
    }

    @Test
    public void testSelect() throws IOException {

        // 分页助手需要放置在首行
        PageHelper.startPage(2,2);

        List<Member> memberList = MyBatisTest.getMapper("SqlMapConfig.xml").selectAll();

        for (Member member : memberList) {
            System.out.println(member);
        }

        // 通过PageInfo<T>获取分页相关的其他参数
        PageInfo<Member> pageInfo = new PageInfo<>(memberList);
        System.out.println("总条数: " + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("当前页: " + pageInfo.getPageNum());
        System.out.println("每页显示条数: " + pageInfo.getPageSize());
        System.out.println("上一页: " + pageInfo.getPrePage());
        System.out.println("下一页: " + pageInfo.getNextPage());
        System.out.println("是否为第一页: " + pageInfo.isIsFirstPage());
        System.out.println("是否为最后一页: " + pageInfo.isIsLastPage());

    }

    public static MemberMapper getMapper(String sqlMapConfig) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(sqlMapConfig);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(MemberMapper.class) ;
    }
}
