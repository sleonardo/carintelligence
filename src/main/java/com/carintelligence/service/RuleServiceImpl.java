package com.carintelligence.service;

import com.carintelligence.model.Rule;
import com.carintelligence.repository.RuleRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 21/3/17
 */
@Service("ruleService")
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleRepository ruleRepository;


    public Rule find(Long ruleId)
    {
        // Returns the Rule for given ruleId.
        return ruleRepository.find(ruleId);
    }


    @Transactional
    public Rule save(Rule rule)
    {
        // Saves the given rule object and returns the same.
        try {
            ruleRepository.save(rule);
        } catch (HibernateException e) {
            throw (e);
        }
        return rule;
    }


    @Override
    public List<Rule> findAll()
    {
        // Returns all the rules in our system.
        return ruleRepository.findAll();
    }


    @Transactional
    public Rule update(Rule rule, Long ruleId)
    {
        // Updates the rule with the given ruleId;
        return ruleRepository.update(rule, ruleId);
    }


    @Transactional
    public Rule delete(Long ruleId)
    {
        // Deletes the rule with the give ruleId and returns the same.
        return ruleRepository.delete(ruleId);
    }


    @Override
    public List<Rule> paginate(int offset, int limit)
    {
        // Paginates the rules objects.
        return ruleRepository.paginate(offset, limit);
    }
}
