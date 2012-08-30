
package com.pocoer.manage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pocoer.model.Kebsite;

public class ss {

    @Test
    public void testAdd() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        KebsiteManage service = (KebsiteManage)ctx.getBean("kebsiteManage");
        System.out.println(service.getClass());
        Kebsite kebsite = new Kebsite();
        kebsite.setKebsiteName("jindong");
        service.add(kebsite);
        ctx.destroy();
    }

}
