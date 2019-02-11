package com.czy.op.dao;

import com.czy.op.model.CollectionIt;

public interface CollectionItDao {
	/**
	 * 添加关注
	 * @param image
	 */
	public void addCollection(CollectionIt collectionIt);
	/**
	 * 查询用户所有关注
	 * @param collection
	 * @return
	 */
	public CollectionIt searchAllCollection(CollectionIt collectionIt);
	/**
	 * 取消关注
	 * @param collection
	 */
	public void unsubscribe(CollectionIt collectionIt);
	
}
