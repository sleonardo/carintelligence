package com.carintelligence.repository;


import com.carintelligence.model.Rule;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 21/3/17
 */
public interface RuleRepository {
    Rule find(Long ruleId);
    List<Rule> findAll();
    List<Rule> paginate(int offset, int limit);
    Rule save(Rule rule);
    Rule update(Rule Rule, Long ruleId);
    Rule delete(Long ruleId);
}
