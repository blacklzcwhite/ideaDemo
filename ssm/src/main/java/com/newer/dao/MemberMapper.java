package com.newer.dao;

import com.newer.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface MemberMapper {



    @Insert("insert into t_member values" +
            "(null,#{mname},#{mphone},#{mlevel}," +
            "now(),#{mcardno})")
    int addMember(Member member);

    @Update("update t_member set m_name=#{mname}," +
            "m_phone=#{mphone},m_level=#{mlevel}," +
            "m_card_no=#{mcardno},m_in_time=#{mintime} where m_id=#{mid}")
    int updateMember(Member member);

    @Delete("delete from t_member where m_id=#{mid}")
    int deleteMember(@Param("mid") int mid);

    @Select("select m_id mid,m_name mname,m_phone mphone," +
            "m_level mlevel,m_in_time mintime,m_card_no mcardno" +
            " from t_member where m_id=#{mid}")
    Member findById(@Param("mid") int mid);


    List<Member> findAll(Map<String,Object> map);


}
