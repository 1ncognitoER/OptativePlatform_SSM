package com.czy.op.serviceImpl;

import com.czy.op.model.CollectionIt;
import com.czy.op.dao.CollectionItDao;
import com.czy.op.service.CollectionItService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("collectionItService")
public class CollectionItServiceImpl implements CollectionItService {
	/* 属性 */
	@Resource
	private CollectionItDao collectionItDao;
	/**
	 * 添加关注
	 */
	public void addCollection(CollectionIt collectionIt) {
		collectionItDao.addCollection(collectionIt);
	}
	/**
	 * 查询用户所有收藏
	 */
	public CollectionIt searchAllCollection(CollectionIt collection) {
		return collectionItDao.searchAllCollection(collection);
	}
	/**
	 * 取消关注
	 */
	public void unsubscribe(CollectionIt collection) {
		collectionItDao.unsubscribe(collection);
	}
	
}
