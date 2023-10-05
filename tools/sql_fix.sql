-- 菜单表的修改和完善
INSERT INTO `menu` (`menu_code`, `menu_name`, `menu_url`, `menu_level`, `parent_id`, `sort`) VALUES ('user-add', '新增用户', 'user-add.html', '2', 28, 2);
UPDATE `menu` SET `menu_url` = 'user-list.html' WHERE `id` = 36;