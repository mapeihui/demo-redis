package com.maph.demoredis.mapper;

import com.maph.demoredis.domain.NbaPlayerDO;

import java.util.List;

public interface NbaPlayerDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(NbaPlayerDO record);

    int insertSelective(NbaPlayerDO record);

    NbaPlayerDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NbaPlayerDO record);

    int updateByPrimaryKey(NbaPlayerDO record);

    List<NbaPlayerDO> ListNbaPlayer();
}