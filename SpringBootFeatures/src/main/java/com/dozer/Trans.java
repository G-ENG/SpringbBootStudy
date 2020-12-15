package com.dozer;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 不推荐@mapping放在source，最好是放在target
 *
 * @Author GenG
 * @Date 2020/12/2
 **/
public class Trans {
    DozerBeanMapper dozerBeanMapper;
    @Before
    public void before(){
        dozerBeanMapper=new DozerBeanMapper();
    }
    @Test
    public void transDemo(){
        SourceBean sourceBean = new SourceBean();
        sourceBean.setName("耿瑞锋");
        sourceBean.setAge(22);
        TargetBean map = dozerBeanMapper.map(sourceBean, TargetBean.class);
        assertEquals("耿瑞锋",map.getMyName());
        assertEquals("耿瑞锋",map.getName());
        assertEquals(map.getMyAge(),22L);
        assertNotEquals(map.getAge(),22);
    }
}
