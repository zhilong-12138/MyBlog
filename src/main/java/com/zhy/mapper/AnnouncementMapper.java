package com.zhy.mapper;

import com.zhy.model.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/11/2 11:44
 */
@Mapper
@Repository
public interface AnnouncementMapper {

    @Select("select id,content,show_status as showStatus,gmt_create as gmtCreate from announcement where is_deleted = 0 order by id desc")
    List<Announcement> findAll();

    @Select("select id,content,show_status as showStatus,gmt_create as gmtCreate from announcement where is_deleted = 0 order by id desc limit #{page},#{limit}")
    List<Announcement> listAnnouncement(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(id) from announcement where is_deleted = 0")
    int countAnnouncement();
}
