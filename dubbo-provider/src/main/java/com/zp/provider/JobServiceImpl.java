/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.zp.provider;

import com.zp.JobDto;
import com.zp.JobException;
import com.zp.JobService;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by guojun.wang on 2017/7/10.
 */
public class JobServiceImpl implements JobService {
    @Override
    public JobDto getJobInfo(int id) {
        System.out.println("getJobInfo invoked ... id(" + id + ")");
        JobDto jobDto = new JobDto();
        jobDto.setId(id);
        jobDto.setJobTitle("this is from server(dubbo)");
        if (id > 0) {
            throw  new JobException("vvvvvvvvvvvv aaaaaaaaaaaaaaaaaaa");
        }
        return jobDto;
    }

    @Override
    public List<JobDto> search(long companyId, Integer status) {
        System.out.println(status);
        List<JobDto> items = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            JobDto dto = new JobDto();
            dto.setId(i);
            dto.setJobTitle("title" + i);
            items.add(dto);
        }

        return items;
    }

    @Override
    public int getJobCount() {
        return 100;
    }
}
