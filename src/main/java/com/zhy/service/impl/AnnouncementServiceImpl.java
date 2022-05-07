package com.zhy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhy.component.StringAndArray;
import com.zhy.mapper.AnnouncementMapper;
import com.zhy.model.Announcement;
import com.zhy.model.Article;
import com.zhy.service.AnnouncementService;
import com.zhy.utils.DataMap;
import com.zhy.utils.DateUtil;
import com.zhy.utils.PageResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/11/2 11:47
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    AnnouncementMapper announcementMapper;


    @Override
    public DataMap<?> findAll(int rows, int pageNum) {
        PageHelper.startPage(pageNum, rows);
        List<Announcement> announcementList = announcementMapper.findAll();
        PageInfo<Announcement> pageInfo = new PageInfo<>(announcementList);
        JSONObject returnJson = new JSONObject();
        for (Announcement announcement : announcementList) {
            announcement.setShowStatusName(announcement.getShowStatus().equals(0) ? "显示" : "不显示");
            announcement.setCreateTime(DateUtil.formatDate(announcement.getGmtCreate(), "yyyy-MM-dd HH:mm:ss"));
        }

        returnJson.put("result", announcementList);
        JSONObject pageJson = new JSONObject();
        pageJson.put("pageNum", pageInfo.getPageNum());
        pageJson.put("pageSize", pageInfo.getPageSize());
        pageJson.put("total", pageInfo.getTotal());
        pageJson.put("pages", pageInfo.getPages());
        pageJson.put("isFirstPage", pageInfo.isIsFirstPage());
        pageJson.put("isLastPage", pageInfo.isIsLastPage());

        returnJson.put("pageInfo", pageJson);

        return DataMap.success().setData(returnJson);
    }

    @Override
    public PageResult<?> listAnnouncement(int pageIndex, int pageSize) {
        List<Announcement> announcementList = announcementMapper.listAnnouncement(pageIndex, pageSize);
        if (CollectionUtils.isEmpty(announcementList)) {
            return PageResult.success(new ArrayList<>());
        }
        int count = announcementMapper.countAnnouncement();
        return PageResult.success(announcementList, count);
    }
}
