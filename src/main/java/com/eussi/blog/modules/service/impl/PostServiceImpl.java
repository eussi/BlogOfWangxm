package com.eussi.blog.modules.service.impl;

import com.eussi.blog.base.lang.Consts;
import com.eussi.blog.base.modules.Page;
import com.eussi.blog.modules.dao.PostMapper;
import com.eussi.blog.modules.po.Post;
import com.eussi.blog.modules.service.PostService;
import com.eussi.blog.modules.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by wangxueming on 2019/2/7.
 */
@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public Page<PostVO> paging(Page page, int channelId, Set<Integer> excludeChannelIds, String ord) {
        Post postQuery = new Post();

        StringBuilder orderBySb = new StringBuilder();
        if (Consts.order.FAVOR.equals(ord)) {
            orderBySb.append(" favors desc");
        } else if (Consts.order.HOTTEST.equals(ord)) {
            orderBySb.append(" comments desc");
        } else {
            orderBySb.append(" weight desc");
        }
        orderBySb.append(", created desc");

        if (Consts.order.HOTTEST.equals(ord)) {
            orderBySb.append(", views desc");
        }

        postQuery.setOrderBy(orderBySb.toString());

        if (channelId > Consts.ZERO) {
            postQuery.setChannelId(channelId);
        }

        if (null != excludeChannelIds && !excludeChannelIds.isEmpty()) {
            StringBuilder notInSb = new StringBuilder(" channelId not in (");
            for(Integer chanelId : excludeChannelIds) {
                notInSb.append(chanelId + ", ");
            }
            postQuery.setNotIn(notInSb.toString().
                    substring(0, notInSb.toString().length() - 1).
                    concat(") "));
        }

        //得到总记录数
        Long totalCount = postMapper.getTotalCount(postQuery);

        //得到总页数

        //得到记录数


        return null;
    }

    @Override
    public Page<PostVO> paging4Admin(Page page, long id, String title, int channelId) {
        return null;
    }

    @Override
    public Page<PostVO> pagingByAuthorId(Page page, long userId) {
        return null;
    }

    @Override
    public List<PostVO> findAllFeatured() {
        return null;
    }

    @Override
    public List<PostVO> findLatests(int maxResults, long ignoreUserId) {
        return null;
    }

    @Override
    public List<PostVO> findHots(int maxResults, long ignoreUserId) {
        return null;
    }

    @Override
    public Map<Long, PostVO> findMapByIds(Set<Long> ids) {
        return null;
    }

    @Override
    public long post(PostVO post) {
        return 0;
    }

    @Override
    public PostVO get(long id) {
        return null;
    }

    @Override
    public void update(PostVO p) {

    }

    @Override
    public void updateFeatured(long id, int featured) {

    }

    @Override
    public void updateWeight(long id, int weight) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(long id, long authorId) {

    }

    @Override
    public void delete(Collection<Long> ids) {

    }

    @Override
    public void identityViews(long id) {

    }

    @Override
    public void identityComments(long id) {

    }

    @Override
    public void favor(long userId, long postId) {

    }

    @Override
    public void unfavor(long userId, long postId) {

    }

    @Override
    public long count() {
        return 0;
    }
}
