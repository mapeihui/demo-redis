package com.maph.demoredis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maph.demoredis.domain.NbaPlayerDO;
import com.maph.demoredis.mapper.NbaPlayerDAO;
import com.maph.demoredis.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：maph
 * @version ：
 * @date ：Created in 2021-03-04 19:20
 * @description：
 * @modified By：
 */
@RestController
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private NbaPlayerDAO nbaPlayerDAO;

    @RequestMapping(value = "/setAndGet",method = RequestMethod.POST)
    public String test(@RequestParam("key") String key, @RequestParam("values") String values){
        logger.info("接收入参key={},values={}",key,values);
        redisUtils.set(key, values);
        return (String) redisUtils.get(key);
    }

    @RequestMapping("/test")
    public Object test(){
//        return nbaPlayerDAO.ListNbaPlayer();
        //step1 先从redis中取
        String strJson=(String) redisUtils.get("nbaPlayerCache");
        if (strJson==null){
            System.out.println("从db取值");
            // step2如果拿不到则从DB取值
            List<NbaPlayerDO> listNbaPlayer=nbaPlayerDAO.ListNbaPlayer();
            // step3 DB非空情况刷新redis值
            if (listNbaPlayer!=null){
                redisUtils.set("nbaPlayerCache", JSON.toJSONString(listNbaPlayer));
                return listNbaPlayer;
            }
            return null;
        } else {
            int k = Integer.parseInt((String) redisUtils.get("k")) + 1;
            redisUtils.set("k", k);
            System.out.println("从redis缓存取值"+redisUtils.get("k"));
            return JSONObject.parseArray(strJson,NbaPlayerDO.class);
        }
    }
}
