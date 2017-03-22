package com.carintelligence.service;


import com.carintelligence.model.Rule;
import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 21/3/17
 */
public interface RuleService {
    Rule find(Long ruleId);
    List<Rule> findAll();
    List<Rule> paginate(int offset, int limit);
    Rule save(Rule rule);
    Rule update(Rule rule, Long ruleId);
    Rule delete(Long ruleId);
}
