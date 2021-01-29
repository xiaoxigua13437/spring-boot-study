package com.yushu.study.dao.impl;

import com.yushu.study.bean.User;
import com.yushu.study.dao.UserDao;
import com.yushu.study.util.base.JdbcDaoImpl;
import com.yushu.study.util.base.Page;
import com.yushu.study.util.base.Sql;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends JdbcDaoImpl implements UserDao {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(User user) {
		String sql = "insert into user (name, create_time) values (?, ?)";
		return jdbcTemplate.update(sql, user.getName(), user.getCreateTime());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from user where id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateById(User user) {
		String sql = "update user set name=?, create_time=? where id=?";
		return jdbcTemplate.update(sql, user.getName(), user.getCreateTime(), user.getId());
	}

	@Override
	public User selectById(int id) {
		String sql = "select * from user where id=?";
		/*return jdbcTemplate.queryForObject(sql, new RowMapper<RoncooUser>() {
			@Override
			public RoncooUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				RoncooUser roncooUser = new RoncooUser();
				roncooUser.setId(rs.getInt("id"));
				roncooUser.setName(rs.getString("name"));
				roncooUser.setCreateTime(rs.getDate("create_time"));
				return roncooUser;
			}
		}, id);*/
		
		return queryForObject(sql, User.class, id);
	}

	@Override
	public Page<User> queryForPage(int pageCurrent, int pageSize, String name){
		// 确定参数
		/*String sql = "select * from roncoo_user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class, name);*/
		
		// 若name可能为空，则要进行判定，如下
		/*StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);*/
		
		// 若要like查询，如下
		StringBuffer sql = new StringBuffer("select * from user where 1");
			// Sql.checkSql 的作用是防止sql注入
		sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
		return queryForPage(sql.toString(), pageCurrent, pageSize, User.class);
	}	





}
