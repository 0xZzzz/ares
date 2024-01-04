package com.ares.infrastructure.bean;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class BeanInitCostsStatistician implements BeanPostProcessor, CommandLineRunner {

    private static final int MAX_TOP_RECORD = 20;

    private final Map<String, Long> startTimeRecords = Maps.newConcurrentMap();

    private final Map<String, Long> endTimeRecords = Maps.newConcurrentMap();

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        startTimeRecords.put(beanName, System.currentTimeMillis());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        endTimeRecords.put(beanName, System.currentTimeMillis());
        return bean;
    }

    private List<TimeRecord> sortTimeRecords() {
        List<TimeRecord> records = Lists.newArrayList();
        for (String beanName : endTimeRecords.keySet()) {
            Long startTime = startTimeRecords.get(beanName);
            if (startTime != null) {
                records.add(new TimeRecord(beanName, endTimeRecords.get(beanName) - startTime));
            }
        }
        Collections.sort(records);
        return records;
    }

    @Override
    public void run(String... args) {
        List<TimeRecord> records = sortTimeRecords();
        int i = 0;
        while (i < MAX_TOP_RECORD) {
            TimeRecord record = records.get(i);
            i++;
            System.out.println("cost:[" + record.getCosts() + "ms]" + "beanName:[" + record.getBeanName() + "]");
        }
    }

    @Getter
    @AllArgsConstructor
    private static class TimeRecord implements Comparable<TimeRecord> {

        private String beanName;

        private long costs;

        @Override
        public int compareTo(TimeRecord o) {
            if (this.costs == o.getCosts()) {
                return 0;
            }
            return this.costs < o.getCosts() ? 1 : -1;
        }
    }

}
