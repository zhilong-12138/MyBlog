package com.zhy.service;

import com.zhy.utils.DataMap;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/11/2 11:47
 */
public interface AnnouncementService {

    DataMap<?> findAll(int rows, int pageNum);

}
