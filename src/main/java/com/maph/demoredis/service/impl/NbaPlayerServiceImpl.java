package com.maph.demoredis.service.impl;

import com.maph.demoredis.domain.NbaPlayerDO;
import com.maph.demoredis.mapper.NbaPlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：maph
 * @version ：
 * @date ：Created in 2021-03-04 20:27
 * @description：
 * @modified By：
 */
@Service
public class NbaPlayerServiceImpl implements NbaPlayerDAO {

    @Autowired
    private NbaPlayerDAO nbaPlayerDAO;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return nbaPlayerDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(NbaPlayerDO record) {
        return nbaPlayerDAO.insert(record);
    }

    @Override
    public int insertSelective(NbaPlayerDO record) {
        return nbaPlayerDAO.insertSelective(record);
    }

    @Override
    public NbaPlayerDO selectByPrimaryKey(Integer id) {
        return nbaPlayerDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NbaPlayerDO record) {
        return nbaPlayerDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NbaPlayerDO record) {
        return nbaPlayerDAO.updateByPrimaryKey(record);
    }

    @Override
    public List<NbaPlayerDO> ListNbaPlayer() {
        return nbaPlayerDAO.ListNbaPlayer();
    }
}
