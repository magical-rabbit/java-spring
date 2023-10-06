-- 菜单表的修改和完善
INSERT INTO `menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('user-add', '新增用户', 'user-add.html', '2', 28, 2);
UPDATE `menu` SET `menu_url` = 'user-list.html' WHERE `id` = 36;

-- 菜单添加
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('template-list', '模板列表', 'template-list.html', '2', '40', '1');
-- UPDATE `ovo`.`menu` SET `menu_code` = 'template', `menu_name` = '模板管理' WHERE (`id` = '40');
INSERT INTO `ovo`.`menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('template-add', '模板新增', 'template.html', '2', '40', '2');
