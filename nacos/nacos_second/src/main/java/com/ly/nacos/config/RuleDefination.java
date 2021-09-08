package com.ly.nacos.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class RuleDefination {

    private static final Logger log = Logger.getLogger(String.valueOf(RuleDefination.class));
    public static final String TEST_GET= "test";

    @PostConstruct
    public void loadRules() {
        initFlowRule(); // 限流策略初始化
        initDegradeRule(); // 熔断策略初始化
        log.info("sentinel 规则定义完毕！");
    }

    private void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<DegradeRule>();
        DegradeRule rule = new DegradeRule();
        rule.setResource(TEST_GET);
        // 异常率超过0.1，就认为服务不可用，执行熔断操作
        rule.setCount(0.1);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
        rule.setTimeWindow(10);
        rule.setMinRequestAmount(20);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
        log.info("sentinel 熔断规则定义完毕！");
    }

    private void initFlowRule() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource(TEST_GET);
        // qps上限为1：
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        log.info("sentinel 限流规则定义完毕！");
    }
}
