package com.example.service.springbootrewards.service;

import com.example.service.springbootrewards.SpringBootRewardsApplication;
import com.example.service.springbootrewards.entity.Customer;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRewardsApplication.class)
public class RewardsServiceImplTest {
    @Resource
    private RewardsServiceImpl rewardsService;
    @Test
    public void getCustomerAllTest() {
        List<Customer> list = rewardsService.getCustomerAll();
        Assert.assertThat(list, Matchers.notNullValue());
    }
    @Test
    public void getCustomerByIdTest() {
        Customer customer = rewardsService.getCustomerById(333);
        rewardsService.saveCustomer(customer);
        Assert.assertThat(customer, Matchers.notNullValue());
    }
    @Test
    public void saveCustomerTest() {
        Customer customer = rewardsService.getCustomerById(333);
        rewardsService.saveCustomer(customer);
    }


}