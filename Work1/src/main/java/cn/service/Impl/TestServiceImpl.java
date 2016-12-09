package cn.service.Impl;

import cn.service.TestService;
import cn.dao.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-8 0008.
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    public Map selectUser(Map map) {
        return  testMapper.selectUser(map);
    }
}
