package pers.linxi.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pers.linxi.shop.dao.ProductDao;
import pers.linxi.shop.entity.Product;
import pers.linxi.shop.util.Paging;

/**
 * ��Ʒ��ҵ���
 * 
 * @author ����
 * 
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 */
	public List<Product> findHotNew(boolean result) {
		List<Product> list = productDao.findHotNew(result);
		return list;
	}

	/**
	 * ����id��ѯ��Ʒ
	 * 
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	/**
	 * ���ݶ�Ӧ�ķ���id��ѯ����ҳ����Ʒ
	 * 
	 * @param cid
	 * @param page
	 * @return
	 */
	public Paging<Product> findByPageCid(Integer cid, int page,int id) {
		Paging<Product> paging = new Paging<Product>();
		//���õ�ǰҳ��
		paging.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 8;
		paging.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = 0;
		//id=1ʱ��ִ�в�ѯһ��������������Ʒ���ܼ�¼��
		totalCount = productDao.findCountCid(cid,id);
		paging.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		totalPage = (int) Math.ceil(totalCount/limit) + 1;
		paging.setTotalPage(totalPage);
		//����ÿҳ��ʾ�ļ�������
		int begin = (page -1) * limit;
		List<Product> pList = productDao.findByPageCid(cid,begin,limit,id);
		paging.setList(pList);
		return paging;
	}

}
