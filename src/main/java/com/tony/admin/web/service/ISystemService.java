package com.tony.admin.web.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.tony.admin.web.common.dao.Paging;
import com.tony.admin.web.model.SysMenu;
import com.tony.admin.web.model.SysRole;
import com.tony.admin.web.model.SysUser;
import com.tony.admin.web.vo.RightTreeVo;


/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 *
 * @author Guoqing
 */
public interface ISystemService {

    /**
     * 根据登录名获取用户
     *
     * @param loginName 登录名
     * @return SysUser user by login name
     */
    SysUser getUserByLoginName(String loginName);

    /**
     * 查询用户列表
     *
     * @param page 分页信息
     * @param user 用户
     * @return 分页数据 page info
     */
    PageInfo<SysUser> findUserPage(Paging page, SysUser user);

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户 user by id
     */
    SysUser getUserById(Integer userId);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return the sys user
     */
    SysUser saveUser(SysUser user);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void updateUserInfo(SysUser user);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    void deleteUserById(Integer userId);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param newPassword 密码
     */
    void updateUserPasswordById(Integer userId, String newPassword);


    /**
     * 查询用户导航菜单
     *
     * @param userId 用户ID
     * @return 菜单列表 menu nav
     */
    List<SysMenu> getMenuNav(Integer userId);

    /**
     * 查询用户菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表 menu list
     */
    List<SysMenu> getMenuList(Integer userId);

    /**
     * 查询用户菜单
     *
     * @param userId 用户ID
     * @return 菜单列表 menu tree
     */
    List<SysMenu> getMenuTree(Integer userId);

    /**
     * 删除菜单
     *
     * @param menuId 菜单ID
     */
    void deleteMenuById(Integer menuId);

    /**
     * 查询菜单
     *
     * @param menuId 菜单ID
     * @return 菜单 menu by id
     */
    SysMenu getMenuById(Integer menuId);

    /**
     * 保存菜单
     *
     * @param menu 菜单
     * @return the sys menu
     */
    SysMenu saveMenu(SysMenu menu);


    /**
     * 查询角色列表
     *
     * @param page 分页信息
     * @param role 角色
     * @return 角色 page info
     */
    PageInfo<SysRole> findRolePage(Paging page, SysRole role);

    /**
     * 获得所有角色列表
     *
     * @return 角色 list
     */
    List<SysRole> findAllRoleList();

    /**
     * 查询用户
     *
     * @param roleId 角色ID
     * @return 角色 role by id
     */
    SysRole getRoleById(Integer roleId);

    /**
     * 保存角色
     *
     * @param role 角色
     * @return the sys role
     */
    SysRole saveRole(SysRole role);

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     */
    void deleteRoleById(Integer roleId);
    
    /**
     * 获取用户的已授权角色列表
     * @param userId
     * @return
     */
    List<SysRole> getAuthList( int userId );
    
    /**
     * 获取用户的未授权角色列表
     * @param userId
     * @return
     */
    List<SysRole> getUnAuthList( int userId );
    
    /**
     * 增加授权信息
     * @param userId
     * @param list
     */
    void addAuthList( int userId, List<SysRole> list );
    
    /**
     * 取消授权信息
     * @param userId
     * @param list
     */
    void cancelAuthList( int userId, List<SysRole> list );
    
    /**
     * 用户一定时间内登录次数限制
     * @param account
     * @return
     */
    Map<String, Object> userLoginLimit(String account);
    
    /**
     * 获取用户菜单数据
     * @param userId
     * @return
     */
    List<SysMenu> getMenuListByUserId(Integer userId);
    
    /**
     * 构建树形菜单
     * @param originals
     * @param useShow
     * @return
     */
    List<SysMenu> makeTree(List<SysMenu> originals, boolean useShow);
    
    /**
     * 菜单树转换为显示树
     * @param menuList
     * @return
     */
    List<RightTreeVo> translateTree(List<SysMenu> menuList);
}
