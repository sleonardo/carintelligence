package com.carintelligence.repository;

import com.carintelligence.model.Rule;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 21/3/17
 */
@Repository("ruleRepository")
public class RuleRepositoryImpl implements RuleRepository {
    @PersistenceContext
    private EntityManager em;


    public Rule find(Long ruleId)
    {
        // Returns the Rule for given ruleId.
        return em.find(Rule.class, ruleId);
    }


    public Rule save(Rule rule)
    {
        // Saves the given rule object and returns the same.
        em.persist(rule);
        em.flush();
        return rule;
    }


    @Override
    public List<Rule> findAll()
    {
        // Returns all the rules in our system.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Rule> q = cb.createQuery(Rule.class);
        Root<Rule> c = q.from(Rule.class);
        q.select(c);
        TypedQuery<Rule> query = em.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<Rule> paginate(int offset, int limit)
    {
        // Returns the list of paginated rules.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Rule> q = cb.createQuery(Rule.class);
        Root<Rule> c = q.from(Rule.class);
        q.select(c);
        TypedQuery<Rule> query = em.createQuery(q);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Rule update(Rule rule, Long ruleId)
    {
        // Updates the given rule with new data.
        rule.setRuleId(ruleId);
        Rule updatedRule = em.merge(rule);
        em.flush();
        return updatedRule;
    }


    @Override
    public Rule delete(Long ruleId)
    {
        // Deletes the rule with the given ruleId.
        Rule ruleToBeDeleted = em.find(Rule.class, ruleId);
        if(ruleToBeDeleted!=null)
            em.remove(ruleToBeDeleted);
        return ruleToBeDeleted;
    }
}
