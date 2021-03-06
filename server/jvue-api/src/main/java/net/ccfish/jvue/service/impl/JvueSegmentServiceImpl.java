package net.ccfish.jvue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.ccfish.common.mybatis.BaseMapper;
import net.ccfish.jvue.autogen.dao.JvueSegmentMapper;
import net.ccfish.jvue.autogen.model.JvueSegment;
import net.ccfish.jvue.service.JvueSegmentService;

/**
 * Generated by Spring Data Generator on 31/01/2018
 */
@Service
@Transactional
public class JvueSegmentServiceImpl implements JvueSegmentService {

    private JvueSegmentMapper jvueSegmentMapper;

    @Autowired
    public JvueSegmentServiceImpl(JvueSegmentMapper jvueSegmentMapper) {
        this.jvueSegmentMapper = jvueSegmentMapper;
    }

    @Override
    public BaseMapper<JvueSegment> baseMapper() {
        return this.jvueSegmentMapper;
    }

    @Override
    public List<JvueSegment> findByPage(Integer pageId) {
        Assert.notNull(pageId, "画面ID不能为空");
        JvueSegment segment = new JvueSegment();
        segment.setPageId(pageId);
        return jvueSegmentMapper.select(segment);
    }

    @CacheEvict(value = "JwtUserDetailsService", allEntries = true)
    @Override
    public void delete(Integer id) {
        this.jvueSegmentMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value = "JwtUserDetailsService", allEntries = true)
    @Override
    public JvueSegment save(JvueSegment obj) {
    	this.jvueSegmentMapper.insert(obj);
        return obj;
    }
}
